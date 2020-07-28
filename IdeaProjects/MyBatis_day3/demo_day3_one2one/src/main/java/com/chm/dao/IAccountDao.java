package com.chm.dao;

import com.chm.domain.Account;

import java.util.List;

public interface IAccountDao {
    List<Account> findAll();
}
