package com.oauth2with_face_google.dao.impl;

import com.oauth2with_face_google.dao.AppRoleDAO;
import com.oauth2with_face_google.entity.AppRole;
import com.oauth2with_face_google.entity.AppUser;

import java.util.List;

public class AppRoleDaoImpl implements AppRoleDAO {
    @Override
    public List<String> getRoleNames(Long userId) {
        return null;
    }

    @Override
    public AppRole findAppRoleByName(String roleName) {
        return null;
    }

    @Override
    public void createRoleFor(AppUser appUser, List<String> roleNames) {

    }
}
