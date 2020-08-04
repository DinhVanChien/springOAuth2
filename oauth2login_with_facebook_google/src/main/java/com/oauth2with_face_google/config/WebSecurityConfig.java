package com.oauth2with_face_google.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.social.security.SpringSocialConfigurer;
/*
Bảng USERCONNECTION sẽ được tạo ra dựa trên lớp UserConnection,
bảng này sẽ được sử dụng tự động bởi Spring Social API,
nó lưu trữ các thông tin công khai của người dùng lấy được từ mạng xã hội như
ProviderId, ProviderUserId, Displayname, Imageurl, ...
Bạn không được thay đổi cấu trúc của bảng này.
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Override
    public UserDetailsService userDetailsService() {
        return userDetailsService;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Sét đặt dịch vụ để tìm kiếm User trong Database
        auth.userDetailsService(userDetailsService);
    }
    // This bean is load the user specific data when form login is used.

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // path mà tất cả các request đi qua mà không cần login
        http.authorizeRequests().antMatchers("/", "/signup", "/login","/logout").permitAll()
                //path chỉ có user
                .antMatchers("/userInfo").hasRole("USER")
                // path admin
                .antMatchers("/admin").hasRole("ADMIN")
                // nếu login sai quyền bắn về 403
                .and().exceptionHandling().accessDeniedPage("/403");

        //form login config
        http.authorizeRequests().and().formLogin()
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/login")//
                .defaultSuccessUrl("/userInfo")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password");
        //form logout config
        http.authorizeRequests().and().logout().logoutUrl("/logout").logoutSuccessUrl("/");
        // Spring Social Config.
        http.apply(new SpringSocialConfigurer()).signupUrl("/signup");
    }
}
