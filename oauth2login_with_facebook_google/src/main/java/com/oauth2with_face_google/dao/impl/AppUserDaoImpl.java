package com.oauth2with_face_google.dao.impl;

import com.oauth2with_face_google.dao.AppUserDAO;
import com.oauth2with_face_google.entity.AppUser;
import com.oauth2with_face_google.form.AppUserForm;
import org.springframework.social.connect.Connection;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AppUserDaoImpl implements AppUserDAO {
    @Override
    public AppUser findAppUserByUserId(Long userId) {
        return null;
    }

    @Override
    public AppUser findAppUserByUserName(String userName) {
        return null;
    }

    @Override
    public AppUser findByEmail(String email) {
        return null;
    }

    @Override
    public String findAvailableUserName(String userName_prefix) {
        return null;
    }

    @Override
    public AppUser createAppUser(Connection<?> connection) {
        return null;
    }

    @Override
    public AppUser registerNewUserAccount(AppUserForm appUserForm, List<String> roleNames) {
        return null;
    }
}
