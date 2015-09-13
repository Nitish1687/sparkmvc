package com.nitish.service;

import com.nitish.Bean.Output;
import com.nitish.Bean.UserBean;
import com.nitish.Bean.UserGetBean;
import com.nitish.mapper.BasicMapper;
import com.nitish.mapper.UserMapper;
import com.nitish.model.UserModel;

import java.util.List;
import java.util.Map;

import static com.nitish.Bean.Output.NotFound;
import static com.nitish.Bean.Output.ok;

/**
 * Created by nsm1211 on 13-09-2015.
 */
public class UserGetService extends  AbstractRequestHandler<UserGetBean>{
    private UserDao userDaoImpl;
    private BasicMapper<UserBean, UserModel> mapper = new UserMapper();
    private static final String USER_ID = ":userid";

    public UserGetService(UserDao userDao, UserMapper userMapper) {
        super(UserGetBean.class, userDao);
        this.userDaoImpl = userDao;
    }


    @Override
    public Output processImpl(UserGetBean value, Map<String, String> urlParams, boolean shouldReturnHtml) {
        System.out.println("Request Param = " + urlParams.get(USER_ID));
        List<UserModel> userModelFor = userDaoImpl.getUserModelFor(urlParams.get(USER_ID));
        if (null != userModelFor.get(0)) {
            return ok(dataToJson(userModelFor.get(0)));
        }
        return NotFound(dataToJson(urlParams.get(USER_ID)));
    }
}
