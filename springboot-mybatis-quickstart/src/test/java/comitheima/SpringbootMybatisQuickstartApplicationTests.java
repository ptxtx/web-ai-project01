package comitheima;

import comitheima.mapper.UserMapper;
import comitheima.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisQuickstartApplicationTests {
    @Autowired
    public UserMapper userMapper;

    @Test
    public void findAll(){
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }
    @Test
    public void testDelete(){
        userMapper.deleteById(4);
    }

    @Test
    public  void testInsert(){
        User user=new User(null,"lisi","123456","李四",23);
        userMapper.addUser(user);
    }

    @Test
    public void testUpdate(){
        User user=new User(6,"lisi","7272","lisi",23);
        userMapper.updateUser(user);
    }

    @Test
    public void testSelect2(){
        User user=new User(null,"xiaoqiao","123456",null,null);
        User user1 = userMapper.find(user);
        System.out.println(user1);
    }
}
