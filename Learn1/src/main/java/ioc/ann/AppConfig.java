package ioc.ann;


import ioc.ann.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration //对实现类添加Configuration注解
@ComponentScan //该注解告诉容器自动搜索当前类所在的包以及子包, 把所有标注 @Component 的 Bean 自动创建出来,并根据 @Autowired 进行装配
public class AppConfig {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
//        userService.register();
    }
}
