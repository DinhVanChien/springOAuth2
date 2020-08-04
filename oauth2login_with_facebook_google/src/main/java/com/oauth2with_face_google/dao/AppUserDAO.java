package com.oauth2with_face_google.dao;

import com.oauth2with_face_google.entity.AppUser;
import com.oauth2with_face_google.form.AppUserForm;
import org.springframework.social.connect.Connection;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserDAO {
    public AppUser findAppUserByUserId(Long userId);
    public AppUser findAppUserByUserName(String userName);
    public AppUser findByEmail(String email);
    public String findAvailableUserName(String userName_prefix);
    public AppUser createAppUser(Connection<?> connection);
    public AppUser registerNewUserAccount(AppUserForm appUserForm, List<String> roleNames);

}
