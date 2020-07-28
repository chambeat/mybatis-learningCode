package com.chm.dao;

import com.chm.domain.User;

import java.util.List;

public interface IUserDao {
    /**
     * 查询所有
     * @return
     */
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据id删除用户
     * @param uid
     */
    void deleteUser(Integer uid);

    /**
     * 查询一个
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 通过用户名称模糊查询
     * @param name
     * @return
     */
    List<User> findByName(String name);

    /**
     * 统计总记录条数
     * @return
     */
    int countTotal();
}
