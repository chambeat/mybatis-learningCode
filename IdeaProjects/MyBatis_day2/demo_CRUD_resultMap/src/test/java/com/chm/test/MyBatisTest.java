package com.chm.test;

import com.chm.dao.IUserDao;
import com.chm.domain.QueryVo;
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

public class MyBatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before//用于在测试方法执行之前执行
    public void init() throws Exception {
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession();
        //4.创建代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destroy() throws Exception {
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        in.close();
    }

    /**
     * 测试查询所有
     *
     * @throws Exception
     */
    @Test
    public void testFindAll() throws Exception {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试保存操作
     */
    @Test
    public void testSave() {
        User user = new User();
        user.setUserName("Black Widow");
        user.setUserBirthday(new Date());
        user.setUserSex("女");
        user.setUserAddress("MC宇宙");
        System.out.println("使用selectKey之前：" + user);
        //保存
        userDao.saveUser(user);
        System.out.println("使用selectKey之后：" + user);
    }

    /**
     * 测试更新操作
     */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setUserId(10);
        user.setUserName("Neo");
        user.setUserBirthday(new Date());
        user.setUserSex("男");
        user.setUserAddress("黑客帝国");
        //更新
        userDao.updateUser(user);
    }

    /**
     * 测试根据id删除操作
     */
    @Test
    public void testDelete() {
        userDao.deleteUser(11);
    }

    /**
     * 测试查询一个
     */
    @Test
    public void testFindOne() {
        User user = userDao.findById(10);
        System.out.println(user);
    }

    /**
     * 测试根据名称模糊查询
     */
    @Test
    public void testFindByName() {
        List<User> users = userDao.findByName("%小%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试统计总记录数
     */
    @Test
    public void testCountTotal() {
        int count = userDao.countTotal();
        System.out.println("user表中总记录数：" + count);
    }

    /**
     * 测试根据queryVo模糊查询
     */
    @Test
    public void testFindByVo() {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUserName("%老%");
        vo.setUser(user);
        List<User> users = userDao.findUserByVo(vo);
        for (User u : users) {
            System.out.println(u);
        }
    }
}
