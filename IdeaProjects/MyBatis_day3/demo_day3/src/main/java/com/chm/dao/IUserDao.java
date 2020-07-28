package com.chm.dao;

import com.chm.domain.QueryVo;
import com.chm.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findUserInIds(QueryVo vo);
}
