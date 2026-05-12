package comitheima.test;

import comitheima.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserService 测试类")
class UserServiceTest {

    private final UserService userService = new UserService();

    @Test
    @DisplayName("测试男性身份证号")
    void testGetGender_Male() {
        // 身份证号第17位为奇数表示男性
        String maleIdCard = "110101199001011231"; // 第17位是3，奇数
        assertEquals("男", userService.getGender(maleIdCard));
    }

    @Test
    @DisplayName("测试女性身份证号")
    void testGetGender_Female() {
        // 身份证号第17位为偶数表示女性
        String femaleIdCard = "110101199001011242"; // 第17位是4，偶数
        assertEquals("女", userService.getGender(femaleIdCard));
    }

    @Test
    @DisplayName("测试身份证号为null的情况")
    void testGetGender_NullIdCard() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.getGender(null);
        });
    }

    @Test
    @DisplayName("测试身份证号长度不正确-过短")
    void testGetGender_TooShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.getGender("123456");
        });
    }

    @Test
    @DisplayName("测试身份证号长度不正确-过长")
    void testGetGender_TooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.getGender("12345678901234567890");
        });
    }

    @Test
    @DisplayName("测试身份证号长度为17位")
    void testGetGender_17Digits() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.getGender("12345678901234567");
        });
    }

    @Test
    @DisplayName("测试身份证号长度为19位")
    void testGetGender_19Digits() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.getGender("1234567890123456789");
        });
    }

    @Test
    @DisplayName("测试边界情况-第17位为1(男性)")
    void testGetGender_GenderDigit1() {
        String idCard = "110101199001011111"; // 第17位是1
        assertEquals("男", userService.getGender(idCard));
    }

    @Test
    @DisplayName("测试边界情况-第17位为0(女性)")
    void testGetGender_GenderDigit0() {
        String idCard = "110101199001011100"; // 第17位是0
        assertEquals("女", userService.getGender(idCard));
    }

    @Test
    @DisplayName("测试边界情况-第17位为9(男性)")
    void testGetGender_GenderDigit9() {
        String idCard = "110101199001011199"; // 第17位是9
        assertEquals("男", userService.getGender(idCard));
    }

    @Test
    @DisplayName("测试边界情况-第17位为8(女性)")
    void testGetGender_GenderDigit8() {
        String idCard = "110101199001011188"; // 第17位是8
        assertEquals("女", userService.getGender(idCard));
    }
}
