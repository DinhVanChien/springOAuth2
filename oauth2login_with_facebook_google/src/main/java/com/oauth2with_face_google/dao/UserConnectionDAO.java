package com.oauth2with_face_google.dao;

import com.oauth2with_face_google.entity.UserConnection;

public interface UserConnectionDAO {
    public UserConnection findUserConnectionByUserProviderId(String userProviderId);
}
