package comitheima.Controller;

import cn.hutool.core.io.IoUtil;
import comitheima.Service.UserService;
import comitheima.Service.impl.UserServiceImpl;
import comitheima.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {
    private UserService userService=new UserServiceImpl();
    @RequestMapping("/list")
    public List<User>  list() throws FileNotFoundException {
        List<User> userList = userService.findAll();//调用service获得数据
        //3.返回数据（JSON）
        return userList;


    }
}
