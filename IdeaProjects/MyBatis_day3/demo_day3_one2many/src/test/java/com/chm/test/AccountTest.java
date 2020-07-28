package com.chm.test;

import com.chm.dao.IAccountDao;
import com.chm.dao.IUserDao;
import com.chm.domain.Account;
import com.chm.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class AccountTest {
    private InputStream is;
    private SqlSession session;
    private IAccountDao accountDao;

    @Before
    public void init() throws Exception {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        session = factory.openSession();
        accountDao = session.getMapper(IAccountDao.class);
    }

    @After
    public void destroy() throws Exception {
        //提交事务
        session.commit();
        session.close();
        is.close();
    }

    @Test
    public void testFindAll() {
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println("---------------每一个account的信息---------------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }
}