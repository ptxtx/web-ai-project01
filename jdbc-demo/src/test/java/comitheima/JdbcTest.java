package comitheima;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {
    /*
    JDBC入门程序
     */
    @Test
    public void testUpdate() throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.获取数据库连接
        String url="jdbc:mysql://localhost:3306/web01";
        String username="root";
        String password="727272Ptx";
        Connection connection = DriverManager.getConnection(url, username, password);

        //3.获取SQL语句执行对象
        Statement statement = connection.createStatement();

        //4.执行SQL
        int result = statement.executeUpdate("update user set age=25 where id=1");//DML语句//返回值为影响的行数
        System.out.println("影响的行数:"+result);


        //5.释放资源
        statement.close();
        connection.close();
    }
}
