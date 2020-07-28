package com.chm.test;

import com.chm.dao.IRoleDao;
import com.chm.dao.IUserDao;
import com.chm.domain.Role;
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

public class RoleTest {
    private InputStream is;
    private SqlSession session;
    private IRoleDao roleDao;

    @Before
    public void init() throws Exception {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        session = factory.openSession();
        roleDao = session.getMapper(IRoleDao.class);
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
        List<Role> roles = roleDao.findAll();
        for (Role role : roles) {
            System.out.println("---------------每一个角色的信息---------------");
            System.out.println(role);
            System.out.println(role.getUsers() + "\n");
        }
    }
}