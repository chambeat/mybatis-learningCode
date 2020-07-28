package com.chm.dao;

import com.chm.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();

    User findById(Integer id);
}
