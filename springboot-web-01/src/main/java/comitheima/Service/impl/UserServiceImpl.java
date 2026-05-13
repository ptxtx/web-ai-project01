package comitheima.Service.impl;

import comitheima.Dao.UserDao;
import comitheima.Dao.impl.UserDaoImpl;
import comitheima.Service.UserService;
import comitheima.pojo.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();//接口多态
    @Override
    public List<User> findAll() {
        List<String> lines = userDao.findAll();
        //2.解析用户信息，封装为User对象->list集合
        List<User> userList = lines.stream().map(line -> {
            String[] split = line.split(",");
            Integer id = Integer.parseInt(split[0]);
            String username = split[1];
            String password = split[2];
            String name = split[3];
            Integer age = Integer.parseInt(split[4]);
            LocalDateTime updateTime = LocalDateTime.parse(split[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(id, username, password, name, age, updateTime);
        }).toList();
        return userList;

    }
}
