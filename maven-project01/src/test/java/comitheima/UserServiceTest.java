package comitheima;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserServiceTest {

    @Test
    public void testGetAge(){
        UserService userService = new UserService();
        Integer age = userService.getAge("100000200010011011");
        System.out.println(age);
    }

    @Test
    public void testGendeerWithAssert(){
        UserService userService = new UserService();
//        String g = userService.getGender("100000200010011011");
//        Assertions.assertEquals("男",g);//一致那么单元测试通过。

        Assertions.assertThrows(IllegalArgumentException.class,()->{
            userService.getGender(null);
        });
    }

    @BeforeAll//在所有的单元测试方法运行之前，运行一次。
    public static void beforeAll(){
        System.out.println("before all");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("after all");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("before each");
    }
    @AfterEach
    public void afterEach(){
        System.out.println("after each");
    }

    /*
    参数化测试
     */
    @DisplayName("测试用户性别")
    @ParameterizedTest
    @ValueSource(strings={"100000200010011011","100000200010011031","100000200010011051"})
    public void getGender2(String idCard) {
        UserService userService = new UserService();
        String gender = userService.getGender(idCard);
        Assertions.assertEquals("男",gender);
    }
}
