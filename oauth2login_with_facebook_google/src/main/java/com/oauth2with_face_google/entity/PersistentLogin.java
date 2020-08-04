package com.oauth2with_face_google.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/*
Bảng PERSISTENT_LOGINS sẽ được tạo ra dựa trên lớp PersistentLogin,
bảng này sẽ được sử dụng tự động bởi Spring Security Remember Me.
Bạn không được thay đổi cấu trúc của bảng này.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "persistent_logins")
public class PersistentLogin {
    @Id
    @Column(name = "Series", length = 64, nullable = false)
    private String series;

    @Column(name = "Username", length = 64, nullable = false)
    private String userName;

    @Column(name = "Token", length = 64, nullable = false)
    private String token;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Last_Used", nullable = false)
    private Date lastUsed;
}
