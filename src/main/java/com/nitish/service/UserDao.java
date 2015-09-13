package com.nitish.service;

import com.nitish.model.UserModel;

import java.util.List;

/**
 * Created by nsm1211 on 11-09-2015.
 */
public interface UserDao {
    void addUser(UserModel userModel);
    List<UserModel> getUserModelFor(String userId);
}
