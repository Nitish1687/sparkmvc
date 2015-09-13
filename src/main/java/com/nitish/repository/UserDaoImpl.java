package com.nitish.repository;

import com.nitish.model.UserModel;
import com.nitish.service.UserDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by nsm1211 on 11-09-2015.
 */
public class UserDaoImpl implements UserDao {

    private static  final Map<String,UserModel> userModelMap = new HashMap<>();
    @Override
    public void addUser(UserModel userModel) {
        if (userModelMap.keySet().stream().noneMatch(isUserModelExistInDb(userModel))) {
            System.out.println(" user map = "+userModelMap.hashCode());
            System.out.println("User Model = "+ userModel);
            userModelMap.put(userModel.getUserId(), userModel);
        }
    }

    private Predicate<String> isUserModelExistInDb(UserModel userModel) {
        return (userId) -> userModel.getUserId().equals(userId);
    }

    @Override
    public List<UserModel> getUserModelFor(String userId) {
        return userModelMap.keySet().stream().filter(iteratingUserId -> iteratingUserId.equals(userId)).map(iteratingUserId -> userModelMap.get(iteratingUserId)).collect(Collectors.toList());
    }
}
