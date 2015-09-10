package com.nitish.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nitish.Bean.UserBean;
import com.nitish.service.UserService;

import static spark.Spark.get;
import static spark.Spark.post;

/**
 * Created by nsm1211 on 10-09-2015.
 */
public class UserController {

    public UserController(final UserService userService) {
        get("/users", (request, response) -> {
            return "Hello Mere Dost";
        });

        post("/addUser", (request, response) -> {
            ObjectMapper objectMapper = new ObjectMapper();
            UserBean userBean = objectMapper.readValue(request.body(), UserBean.class);
            return "";
        });
    }
}
