package com.nitish.mapper;

import com.nitish.Bean.Bean;
import com.nitish.Bean.UserBean;
import com.nitish.model.Model;
import com.nitish.model.UserModel;

import static java.lang.String.valueOf;

/**
 * Created by nsm1211 on 11-09-2015.
 */
public class UserMapper implements BasicMapper<UserBean, UserModel> {
    @Override
    public UserModel mapToModel(Bean bean) {
        UserModel userModel = new UserModel();
        UserBean userBean = (UserBean) bean;
        userModel.setUserId(valueOf(userBean.getUserId()));
        userModel.setName(userBean.getName());
        userModel.setEmailId(userBean.getEmailId());
        return userModel;
    }

    @Override
    public UserBean mapToBean(Model model) {
        UserModel userModel = (UserModel) model;
        UserBean userBean = new UserBean();
        userBean.setUserId(Integer.valueOf(userModel.getUserId()));
        userBean.setName(userModel.getName());
        userBean.setEmailId(userModel.getEmailId());
        return userBean;
    }
}
