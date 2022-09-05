package ioc.properties;


import ioc.properties.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import java.time.ZoneId;

@Configuration //对实现类添加Configuration注解
@ComponentScan //该注解告诉容器自动搜索当前类所在的包以及子包, 把所有标注 @Component 的 Bean 自动创建出来,并根据 @Autowired 进行装配

// 读取 classpath 下的 app-1 和 smtp 两个 properties 文件
@PropertySource("app-1.properties")
@PropertySource("smtp.properties")
public class AppConfig {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.login("bob@example.com", "password");
    }

    // 创建第三方 Bean, 为单例
    @Bean
    ZoneId createZoneId(@Value("${app.zone:Z}") String zoneId) {
        return ZoneId.of(zoneId);
    }
}
