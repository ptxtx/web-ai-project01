package comitheima.Dao.impl;

import cn.hutool.core.io.IoUtil;
import comitheima.Dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Repository
//@Component
public class UserDaoImpl implements UserDao {

    @Override
    public List<String> findAll() {
        //1.加载并读取user.txt来获取用户数据
        //InputStream in=new FileInputStream(new File("/Users/ptx/Desktop/static/user.txt"))
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("static/user.txt");//classloader：类加载器
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
        return lines;
    }
}