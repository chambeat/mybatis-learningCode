package com.chm.dao;

import com.chm.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@CacheNamespace
public interface IUserDao {
    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("select * from user")
    @Results(id = "userMap", value = {
            @Result(property = "userId", column = "id", id = true),
            @Result(property = "userName", column = "username"),
            @Result(property = "userSex", column = "sex"),
            @Result(property = "userAddress", column = "address"),
            @Result(property = "userBirthday", column = "birthday"),
            @Result(property = "accounts", column = "id", many = @Many(select = "com.chm.dao.IAccountDao.findByUid", fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    /**
     * 保存用户
     *
     * @param user
     */
    @Insert("insert into user(username,sex,birthday) values(#{username},#{sex},#{birthday})")
    @ResultMap({"userMap"})
    void saveUser(User user);

    /**
     * 更新用户
     *
     * @param user
     */
    @Update("update user set username=#{username},sex=#{sex} where id = #{id}")
    @ResultMap({"userMap"})
    void updateUser(User user);

    /**
     * 删除用户
     *
     * @param userId
     */
    @Delete("delete from user where id = #{id}")
    @ResultMap({"userMap"})
    void deleteUser(Integer userId);

    /**
     * 根据id查询用户
     *
     * @param userId
     * @return
     */
    @Select("select * from user where id=#{id}")
    @ResultMap({"userMap"})
    User findById(Integer userId);

    /**
     * 根据名称模糊查询用户
     *
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username}")
    @ResultMap({"userMap"})
    List<User> findByUsername(String username);
}
