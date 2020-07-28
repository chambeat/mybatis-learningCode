package com.chm.dao;

import com.chm.domain.Account;

import java.util.List;

public interface IAccountDao {
    List<Account> findAll();

    /**
     * 根据用户id查询账户信息
     * @param uid
     * @return
     */
    List<Account> findByUid(Integer uid);
}
