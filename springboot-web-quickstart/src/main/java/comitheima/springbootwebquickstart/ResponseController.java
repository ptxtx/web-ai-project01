package comitheima.springbootwebquickstart;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ResponseController {
    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws IOException {
        //1.设置响应状态码
        response.setStatus(200);//通常来说不会设置状态码
        //2.设置响应头
        response.setHeader("name", "itheima");

        //3.设置响应体
        response.getWriter().write("<h1>hello response</h1>");//通过IO流写入响应体
    }

    /*
    方式2: 使用ResponseEntity
     */
    @RequestMapping("/response2")
    public ResponseEntity<String> response2(){
        return ResponseEntity.status(200).header("name","javaweb-ai").body("hello response2");
    }
}
