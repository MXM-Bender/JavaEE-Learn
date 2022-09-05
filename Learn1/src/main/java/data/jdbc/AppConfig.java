package data.jdbc;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import data.jdbc.service.User;
import data.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration //对实现类添加Configuration注解
@ComponentScan //该注解告诉容器自动搜索当前类所在的包以及子包, 把所有标注 @Component 的 Bean 自动创建出来,并根据 @Autowired 进行装配
@PropertySource("jdbc.properties")
public class AppConfig {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.register("bob@example.com", "password1", "Bob");
        userService.register("alice@example.com", "password2", "Alice");
        User bob = userService.getUserByName("Bob");
        System.out.println(bob);

        User tom = userService.register("tom@example.com", "password3", "Tom");
        System.out.println(tom);
        System.out.println("Total: " + userService.getUsers());

        for (User u : userService.getUsers(1)) {
            System.out.println(u);
        }
    }

    @Value("${jdbc.url}")
    String jdbcUrl;

    @Value("${jdbc.username}")
    String jdbcUsername;

    @Value("${jdbc.password}")
    String jdbcPassword;

    @Bean
    JdbcTemplate createJdbcTemplate(@Autowired DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    DataSource createDateSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(jdbcUsername);
        config.setPassword(jdbcPassword);
        config.addDataSourceProperty("autoCommit", "true");
        config.addDataSourceProperty("connectionTimeout", "5");
        config.addDataSourceProperty("idleTimeout", "60");
        return new HikariDataSource(config);
    }
}
