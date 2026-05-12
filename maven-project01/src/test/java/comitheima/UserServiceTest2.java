package comitheima;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserServiceTest2 {
    private UserService us;
    @BeforeEach
    public void setUp() {
        us = new UserService();
    }
    @Test
    @DisplayName("获取性别-null值")
    public void testGender1(){
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            us.getGender(null);
        });
    }
    //还有其他方法。。就不列举了
}
