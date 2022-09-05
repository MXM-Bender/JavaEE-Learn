package ioc.custom.validator;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3) //声明装配 List 时位于第 3 可以不加
public class PasswordValidator implements Validator {
    @Override
    public void validate(String email, String password, String name) {
        if (!password.matches("^.{6,20}$")) {
            throw new IllegalArgumentException("invalid password");
        }
    }
}
