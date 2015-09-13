package com.nitish;

import com.nitish.mapper.UserMapper;
import com.nitish.repository.UserDaoImpl;
import com.nitish.service.UserCreateService;
import com.nitish.service.UserGetService;

import static spark.Spark.get;
import static spark.Spark.post;

/**
 * Created by nsm1211 on 10-09-2015.
 */
public class Application {

    public static void main(String[] args) {
        get("/get/:userid/user", new UserGetService(new UserDaoImpl(), new UserMapper()));
        post("/add-user", new UserCreateService(new UserDaoImpl(), new UserMapper()));
    }
}
