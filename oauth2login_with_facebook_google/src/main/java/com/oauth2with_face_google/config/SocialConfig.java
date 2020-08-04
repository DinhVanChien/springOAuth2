package com.oauth2with_face_google.config;

import com.oauth2with_face_google.dao.AppUserDAO;
import com.oauth2with_face_google.social.ConnectionSignUpImpl;
import org.bouncycastle.asn1.pkcs.EncryptionScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.*;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.security.AuthenticationNameUserIdSource;

import javax.sql.DataSource;

/*
Tập tin social-cfg.properties sẽ được đọc trong lớp SocialConfig.
Chú ý thuộc tính social.auto-signup:
social.auto-signup=true: Có nghĩa là khi người dùng đăng nhập lần đầu tiên bằng mạng xã hội,
một bản ghi APP_USER sẽ được tạo ra tự động.
social.auto-signup=false: Có nghĩa là khi người dùng đăng nhập lần đầu tiên bằng mạng xã hội,
ứng dụng sẽ chuyển hướng người dùng tới trang đăng ký, với các thông tin mặc định,
người dùng có thể thay đổi các thông tin này, sau đó nhấn "Submit",
lúc này một bản ghi APP_USER mới được tạo ra.
 */
@Configuration
@EnableSocial
@PropertySource("classpath:social-cfg.properties")
public class SocialConfig implements SocialConfigurer {
    private boolean autoSignUp = false;
    @Autowired
    private AppUserDAO appUserDAO;
    @Autowired
    private DataSource dataSource;
    // @env: read from social-cfg.properties file.
    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment) {
        try {
            this.autoSignUp = Boolean.parseBoolean(environment.getProperty("social.auto-signup"));
        }catch (Exception e) {
            this.autoSignUp = false;
        }
        // Facebook
        FacebookConnectionFactory faceConFactory = new FacebookConnectionFactory(
                environment.getProperty("facebook.app.id"),
                environment.getProperty("facebook.app.secret")
        );
        faceConFactory.setScope(environment.getProperty("facebook.scope"));
        // auth_type=reauthenticate
        connectionFactoryConfigurer.addConnectionFactory(faceConFactory);

        GoogleConnectionFactory googleConFactory = new GoogleConnectionFactory(
                environment.getProperty("google.client.id"),
                environment.getProperty("google.client.secret")
        );
        googleConFactory.setScope(environment.getProperty("google.scope"));
        connectionFactoryConfigurer.addConnectionFactory(googleConFactory);
    }
    // The UserIdSource determines the userID of the user.
    // xác định userId của người dùng
    @Override
    public UserIdSource getUserIdSource() {
        return new AuthenticationNameUserIdSource();
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository
            (ConnectionFactoryLocator connectionFactoryLocator) {
        JdbcUsersConnectionRepository usersConnectionRepository  = new JdbcUsersConnectionRepository(
                dataSource,
                connectionFactoryLocator,
                Encryptors.noOpText()
        );
        /*
         After logging in to social networking.
         (Sau khi đăng nhập vào mạng xã hội)
         Automatically creates corresponding APP_USER if it does not exist.
         (Tự động tạo APP_USER tương ứng nếu nó không tồn tại).
         */
        if(autoSignUp) {
            ConnectionSignUp connectionSignUp = new ConnectionSignUpImpl(appUserDAO);
            usersConnectionRepository.setConnectionSignUp(connectionSignUp);
        } else {
            // After logging in to social networking.
            // If the corresponding APP_USER record is not found.
            // Navigate to registration page.
            usersConnectionRepository.setConnectionSignUp(null);
        }
        return usersConnectionRepository;
    }
    // This bean manages the connection flow between the account provider
    // and the example application.
    // quan ly ket noi giua acount và application
    @Bean
    public ConnectController connectController(ConnectionFactoryLocator connectionFactoryLocator,
                                               ConnectionRepository connectionRepository) {
        return new ConnectController(connectionFactoryLocator, connectionRepository);
    }
}
