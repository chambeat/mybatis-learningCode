package com.chm.test;

import com.chm.dao.IUserDao;
import com.chm.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class CRUDTest {
    private InputStream is;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public void init() throws Exception {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws Exception {
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }

    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUserName("马文才");
        user.setUserSex("男");
        user.setUserBirthday(new Date());
        userDao.saveUser(user);
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setUserId(10);
        user.setUserName("凯特·布兰切特");
        user.setUserSex("女");
        userDao.updateUser(user);
    }

    @Test
    public void testDeleteUser() {
        userDao.deleteUser(10);
    }

    @Test
    public void testFindById() {
        User user = userDao.findById(8);
        System.out.println(user);
    }

    @Test
    public void testFindByUsername() {
        List<User> users = userDao.findByUsername("%老%");
        for (User user : users) {
            System.out.println(user);
        }
    }
}
