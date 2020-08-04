package com.oauth2with_face_google.dao;

import com.oauth2with_face_google.entity.AppRole;
import com.oauth2with_face_google.entity.AppUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AppRoleDAO {
    public List<String> getRoleNames(Long userId);
    public AppRole findAppRoleByName(String roleName);
    public void createRoleFor(AppUser appUser, List<String> roleNames);
}
