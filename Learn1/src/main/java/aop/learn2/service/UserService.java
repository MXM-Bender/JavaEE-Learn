package aop.learn2.service;

import aop.learn2.metrics.MetricTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component //此注解将UserService声明为一个组件(Bean)
public class UserService {
    @Autowired //此注解将指定类型的Bean注入到指定的字段中, 该注解不仅可以写在set()方法内,还以写在字段上以及构造方法上.
    private MailService mailService;

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    private List<User> users = new ArrayList<>(List.of(
            new User(1, "bob@example.com", "password", "Bob"),
            new User(2, "alice@example.com", "password", "Alice"),
            new User(3, "tom@example.com", "password", "Tom")
    ));

    public User login(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                mailService.sendLoginMail(user);
                return user;
            }
        }
        throw new RuntimeException("login failed");
    }

    public User getUser(long id) {
        return this.users.stream().filter(user -> user.getId() == id).findFirst().orElseThrow();
    }

    @MetricTime("register")
    public User register(String email, String password, String name) {
        users.forEach((user -> {
            if (user.getEmail().equalsIgnoreCase(email)) {
                throw new RuntimeException("email exist!");
            }
        }));
        User user = new User(users.stream().mapToLong(User::getId).max().getAsLong(), email, password, name);
        users.add(user);
        mailService.sendRegistrationMail(user);
        return user;
    }

}
