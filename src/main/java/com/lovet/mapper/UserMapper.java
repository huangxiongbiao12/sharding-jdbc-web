package com.lovet.mapper;


import com.lovet.entity.User;

import java.util.List;

public interface UserMapper {

    List<User> getAll();

    void insert(User user);

    int count();

}
