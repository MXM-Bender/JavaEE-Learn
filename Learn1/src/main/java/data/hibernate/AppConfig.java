package data.hibernate;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import data.hibernate.entity.AbstractEntity;
import data.hibernate.entity.User;
import data.hibernate.service.UserService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration //对实现类添加Configuration注解
@EnableTransactionManagement
@ComponentScan //该注解告诉容器自动搜索当前类所在的包以及子包, 把所有标注 @Component 的 Bean 自动创建出来,并根据 @Autowired 进行装配
@PropertySource("jdbc.properties")
public class AppConfig {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        if (userService.fetchUserByEmail("bob@example.com") == null) {
            User bob = userService.register("bob@example.com", "bob123", "Bob");
            System.out.println("Registered ok: " + bob);
        }
        if (userService.fetchUserByEmail("alice@example.com") == null) {
            User alice = userService.register("alice@example.com", "helloalice", "Bob");
            System.out.println("Registered ok: " + alice);
        }
        // 查询所有用户:
        for (User u : userService.getUsers(1)) {
            System.out.println(u);
        }
        User bob = userService.login("bob@example.com", "bob123");
        System.out.println(bob);
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

    @Bean
    LocalSessionFactoryBean createSessionFactory(@Autowired DataSource dataSource) {
        var props = new Properties();
        props.setProperty("hibernate.hbm2ddl.auto", "update");
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        props.setProperty("hibernate.show_sql", "true");
        var sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);

        //扫描指定的 package 获取所有 entity class:
        sessionFactoryBean.setPackagesToScan(AbstractEntity.class.getPackageName());
        sessionFactoryBean.setHibernateProperties(props);
        return sessionFactoryBean;
    }


//    @Bean
//    SessionFactory createSessionFactory(@Autowired LocalSessionFactoryBean localSessionFactoryBean) {
//        return localSessionFactoryBean.getObject();
//    }

    @Bean
    HibernateTemplate createHibernateTemplate(@Autowired SessionFactory sessionFactory) {
        return new HibernateTemplate(sessionFactory);
    }

    /*
        PlatformTransactionManager 是 Spring 的事务管理器。 一切事务由其管理
     */
    @Bean
    PlatformTransactionManager createTxManager(@Autowired SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }
}
