package comitheima.mapper;

import comitheima.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper//应用程序在运行时，会自动的为该接口创建一个实现类对象，该对象会交给IOC进行管理
public interface UserMapper {
   //@Select("select * from user")
    public List<User> findAll();//查询返回值为User集合

    @Delete("delete from user where id=#{id}")
    public void deleteById(Integer id);//想接受返回值，则把类型改成Integer

    @Insert("insert into user(username,password,name,age)values(#{username},#{password},#{name},#{age})")
    public void addUser(User user);

    @Update("update user set username=#{username},password=#{password},name=#{name},age=#{age} where id=#{id}")
    public void updateUser(User user);

    @Select("select * from user where username=#{username} and password=#{password}")
    //public User find(@Param("username")String username,@Param("password")String password);  也可以用Param注解给参数命名
    public User find(User user);
}
