package comitheima.springbootwebquickstart;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//当前类是一个请求处理类
public class HelloController {
    @RequestMapping("/hello")//如果请求路径是/hello，则调用此方法
    public String hello(String name){
        System.out.println("name:"+name);
        return "hello:"+name+"~";//给前端响应一个字符串
    }
}
