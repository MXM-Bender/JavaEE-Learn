package ioc.custom.validator;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1) //声明装配 List 时位于第 1 **可以不加**
public class EmailValidator implements Validator {

    @Override
    public void validate(String email, String password, String name) {
        if (!email.matches("^[a-z0-9]+\\@[a-z0-9]+\\.[a-z]{2,10}$")) {
            throw new IllegalArgumentException("invalid email");
        }
    }
}
