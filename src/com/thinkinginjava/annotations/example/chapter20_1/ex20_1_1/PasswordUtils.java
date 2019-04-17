package com.thinkinginjava.annotations.example.chapter20_1.ex20_1_1;

import java.util.List;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/17
 * @description:
 */
public class PasswordUtils {
    @UseCase(id = 47, description = "Password must contain at least one numeric")
    public boolean validatePassword(String password) {
        return password.matches("\\w*\\d\\w*");
    }

    @UseCase(id = 48)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 49, description = "New password can't equal previously used ones")
    public boolean checkForNewPassword(List<String> prevPassword, String password) {
        return !prevPassword.contains(password);
    }
}
