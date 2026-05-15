package comitheima.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//getset
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer age;

    public User(Integer id, Integer age, String name, String password, String username) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.password = password;
        this.username = username;
    }
}
