package com.nitish.repository;

import com.nitish.model.UserModel;

/**
 * Created by nsm1211 on 11-09-2015.
 */
public interface userDao {
    void addUser(UserModel userModel);
    UserModel getUerById(String userId);
}
