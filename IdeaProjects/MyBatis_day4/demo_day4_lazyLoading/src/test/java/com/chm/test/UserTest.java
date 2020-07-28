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
import java.util.List;

public class UserTest {
    private InputStream is;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public void init() throws Exception {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
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
        List<User> users = userDao.findAll();
//        for (User user : users) {
//            System.out.println("---------------每一个user的信息---------------");
//            System.out.println(user);
//            System.out.println(user.getAccounts() + "\n");
//        }
    }
}