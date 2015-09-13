package com.nitish.service;

import com.nitish.Bean.Output;
import com.nitish.Bean.UserBean;
import com.nitish.mapper.BasicMapper;
import com.nitish.model.UserModel;

import java.util.Map;

import static com.nitish.Bean.Output.ok;

/**
 * Created by nsm1211 on 10-09-2015.
 */
public class UserCreateService extends AbstractRequestHandler<UserBean>{
    private UserDao userDaoImpl;
    private BasicMapper<UserBean, UserModel> mapper;

    public UserCreateService(UserDao userDao, BasicMapper userBeanMapper) {
        super(UserBean.class, userDao);
        userDaoImpl = userDao;
        mapper = userBeanMapper;
    }

    @Override
    protected Output processImpl(UserBean userBean, Map<String, String> urlParams, boolean shouldReturnHtml) {
        if (!userBean.isValid()) {
            return Output.badRequest(dataToJson(userBean));
        }
        System.out.println("User Dao ="+userDaoImpl);
        userDaoImpl.addUser(mapper.mapToModel(userBean));
        return ok(dataToJson(userBean));
    }
}
