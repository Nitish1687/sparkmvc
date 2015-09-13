package com.nitish.service;

import com.nitish.Bean.Output;
import com.nitish.Bean.UserBean;
import com.nitish.mapper.UserMapper;
import com.nitish.repository.UserDaoImpl;
import org.easymock.EasyMock;
import org.junit.Test;

import java.util.HashMap;

import static org.easymock.EasyMock.createMock;
import static org.junit.Assert.*;

/**
 * Created by nsm1211 on 13-09-2015.
 */
public class UserCreateServiceTest {

    @Test
    public void should_create_new_user_with_valid_parameters () {
        UserDaoImpl userDao = createMock(UserDaoImpl.class);
        UserMapper userMapper = createMock(UserMapper.class);
        UserCreateService userCreateService = new UserCreateService(userDao, userMapper);

        UserBean userBean = new UserBean();
        userBean.setUserId(1);
        userBean.setName("nitish");
        userBean.setEmailId("nitish@gmail.com");

        String expectedJSON = "{\n" +
                "  \"userId\" : 1,\n" +
                "  \"name\" : \"nitish\",\n" +
                "  \"emailId\" : \"nitish@gmail.com\",\n" +
                "  \"valid\" : true\n" +
                "}";
        Output output = userCreateService.processImpl(userBean, new HashMap<>(), false);

        assertEquals(200, output.getCode());
    }

    @Test
    public void should_not_create_invalid_user() throws Exception {
        UserDaoImpl userDao = createMock(UserDaoImpl.class);
        UserMapper userMapper = createMock(UserMapper.class);
        UserCreateService userCreateService = new UserCreateService(userDao, userMapper);

        Output output = userCreateService.processImpl(new UserBean(), new HashMap<>(), true);
        assertEquals(400, output.getCode());

    }
}