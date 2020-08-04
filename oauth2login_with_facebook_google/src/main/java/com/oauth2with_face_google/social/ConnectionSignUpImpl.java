package com.oauth2with_face_google.social;

import com.oauth2with_face_google.dao.AppUserDAO;
import lombok.AllArgsConstructor;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;

/**
 * Trong lần đầu tiên người dùng đăng nhập với tài khoản mạng xã hội của họ,
 * ứng dụng sẽ có được đối tượng Connection, đối tượng này chứa hồ sơ ( Profile) của người dùng.
 * Bạn sẽ viết code trong lớp ConnectionSignUpImpl để tạo ra một bản ghi của bảng APP_USER.
 * (Xem thêm code trong lớp SocialConfig).
 */
@AllArgsConstructor
public class ConnectionSignUpImpl implements ConnectionSignUp {
    private AppUserDAO userDAO;

    @Override
    public String execute(Connection<?> connection) {
        return null;
    }
}
