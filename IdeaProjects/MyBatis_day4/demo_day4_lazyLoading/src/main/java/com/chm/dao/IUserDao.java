package com.chm.dao;

import com.chm.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();

    List<User> findById(Integer id);
}
