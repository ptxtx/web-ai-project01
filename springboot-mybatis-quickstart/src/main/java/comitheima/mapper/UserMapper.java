package comitheima.mapper;

import comitheima.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper//应用程序在运行时，会自动的为该接口创建一个实现类对象，该对象会交给IOC进行管理
public interface UserMapper {
    @Select("select * from user")
    public List<User> findAll();//查询返回值为User集合
}
