package com.surveycenter.mapper;

import com.surveycenter.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserMapper  {
    //获取所有用户
    @Select("select * from users")
    List<User> selectAllUsers();
    // 获取特定用户
    @Select("select * from users where username=#{username} and password=#{password}")
    User findUser(@Param("username") String username, @Param("password") String password);
    // 根据username获取用户
    @Select("select * from users where username = #{0}")
    User findUserByName( String username);
    //添加用户
    @Insert("insert into users(username,password,telephone,birthdate,sex) values(#{username},#{password},#{telephone},#{birthdate},#{sex}) ")
    int addUser(User registerUser);
    //根据id获取用户
    @Select("select * from users where id = #{0}")
    User findUserById(int id);
    //修改当前用户的用户名
    @Update("update users set username = #{username} where id = #{id}")
    int setUsername(@Param("id") int id, @Param("username") String username);
    // 根据telephone获取用户
    @Select("select * from users where telephone=#{0}")
    User getUserByPhone(String phone);
    //修改当前用户的手机号
    @Update("update users set telephone=#{telephone} where id=#{id}")
    int setPhone(@Param("id") int id, @Param("telephone") String phone);
    //获取当前用户的手机号
    @Select("select telephone from users where id=#{0}")
    String getBeforePhone(int id);
    //获取当前用户的性别
    @Select("select sex from users where id=#{0}")
    int getBeforeSex(int id);
    //修改当前用户的性别
    @Update("update users set sex=#{sex} where id=#{id}")
    int setSex(@Param("id") int id, @Param("sex") int sex);
    //获取当前用户的出生日期
    @Select("select birthdate from users where id=#{0}")
    String getBeforeDate(int id);
    //修改当前用户的出生日期
    @Update("update users set birthdate=#{birthdate} where id=#{id}")
    int setDate(@Param("id") int id, @Param("birthdate") String date);
    @Select("select username from users where id=#{0}")
    String getNameById(int id);
    //重置密码
    @Update("update users set password=#{password} where id=#{id}")
    int resetPass(@Param("id") int id, @Param("password") String password);
}
