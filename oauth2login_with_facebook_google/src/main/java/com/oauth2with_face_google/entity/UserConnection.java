package com.oauth2with_face_google.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Userconection")
public class UserConnection implements Serializable {
    private static final long serialVersionUID = -8945517162417931921L;
    @Id
    @Column(name = "Userid", length = 255, nullable = false)
    private String userId;

    @Id
    @Column(name = "Providerid", length = 255, nullable = false)
    private String providerId;

    @Id
    @Column(name = "Provideruserid", length = 255, nullable = false)
    private String providerUserId;

    @Column(name = "Rank", nullable = false)
    private int rank;

    @Column(name = "Displayname", length = 255, nullable = true)
    private String displayName;

    @Column(name = "Profileurl", length = 512, nullable = true)
    private String profileUrl;

    @Column(name = "Imageurl", length = 512, nullable = true)
    private String imageUrl;

    @Column(name = "Accesstoken", length = 512, nullable = true)
    private String accessToken;

    @Column(name = "Secret", length = 512, nullable = true)
    private String secret;

    @Column(name = "Refreshtoken", length = 512, nullable = true)
    private String refreshToken;

    @Column(name = "Expiretime", nullable = true)
    private Long expireTime;
}
