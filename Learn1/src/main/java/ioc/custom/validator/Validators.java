package ioc.custom.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Validators {
    /*
        在此对 List 对象声明注入, Spring会将扫描到的所有 Validator 的 Bean 装配到该 List 中
        此后, 每增加一个 Validator 的 Bean 都会被 Spring 装配到该 List 中.
     */
    @Autowired
    List<Validator> validators;

    public void validate(String email, String password, String name) {
        for (var validator : this.validators) {
            validator.validate(email, password, name);
        }
    }
}
