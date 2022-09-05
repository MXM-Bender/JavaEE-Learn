package data.dao;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import data.dao.service.User;
import data.dao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
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
        // 插入Bob:
        if (userService.fetchUserByEmail("bob@example.com") == null) {
            userService.register("bob@example.com", "password1", "Bob");
        }
        // 插入Alice:
        if (userService.fetchUserByEmail("alice@example.com") == null) {
            userService.register("alice@example.com", "password2", "Alice");
        }
        // 插入Tom:
        if (userService.fetchUserByEmail("tom@example.com") == null) {
            userService.register("tom@example.com", "password2", "Tom");
        }
        // 插入Root:
        try {
            userService.register("root@example.com", "password3", "root");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        // 查询所有用户:
        for (User u : userService.getUsers(1)) {
            System.out.println(u);
        }
        ((ConfigurableApplicationContext) context).close();
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
