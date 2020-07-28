package com.chm.test;

import com.chm.dao.IUserDao;
import com.chm.dao.impl.UserDaoImpl;
import com.chm.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * MyBatis的入门案例
 */
public class MyBatisTest {
    public static void main(String[] args) throws Exception {
        //1.读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        //3.创建UserDao对象
        IUserDao userDao = new UserDaoImpl(factory);
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        is.close();
    }
}
