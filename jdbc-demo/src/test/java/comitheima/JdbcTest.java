package comitheima;

import comitheima.pojo.User;
import org.junit.jupiter.api.Test;

import java.sql.*;

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

    @Test
    public void testSelect(){
                // 1. 定义数据库连接信息 (请根据你的实际情况修改数据库名、用户名和密码)
                String url = "jdbc:mysql://localhost:3306/web01";
                String dbUser = "root";
                String dbPassword = "727272Ptx";

                // 定义需要执行的 SQL 语句
                String sql = "select id, username, password, name, age from user where username = 'daqiao' and password = '123456'";

                // 2. 获取连接、创建 Statement、执行查询 (使用 try-with-resources 自动释放资源)
                try (
                        // 获取数据库连接
                        Connection connection = DriverManager.getConnection(url, dbUser, dbPassword);
                        // 获取执行 SQL 的 Statement 对象
                        Statement statement = connection.createStatement();//如果要用预编译，就把这句话改成/*
                        //PreparedStatement pstmt = connection.prepareStatement(sql)
                        //pstmt.setString(1, "daqiao");
                        //pstmt.setString(2, "123456");
                        // 执行 DQL 语句，返回结果集 ResultSet
                        ResultSet resultSet = statement.executeQuery(sql)//封装查询返回的结果
                ) {
                    // 3. 遍历结果集，封装实体类
                    while (resultSet.next()) {
                        // a. 根据字段名获取每一列的值
                        Integer id = resultSet.getInt("id");
                        String username = resultSet.getString("username");
                        String password = resultSet.getString("password");
                        String name = resultSet.getString("name");
                        Integer age = resultSet.getInt("age");

                        // b. 将获取到的数据封装到 User 实体类对象中
                        User user = new User(id, username, password, name, age);

                        // c. 输出 User 对象到控制台
                        System.out.println(user);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
    }
}
