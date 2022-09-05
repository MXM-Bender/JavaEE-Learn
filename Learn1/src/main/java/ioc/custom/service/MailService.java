package ioc.custom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Component //此注解将MailService声明为一个装配的组件(Bean)
public class MailService {

    @Autowired(required = false) //声明该组件并非必须, 若不存在则使用默认值
    private ZoneId zoneId = ZoneId.systemDefault();

    // 注入后的初始化操作
    @PostConstruct
    public void init() {
        System.out.println("Init mail service with zoneId = " + this.zoneId);
    }

    // 销毁前的操作
    @PreDestroy
    public void shutdown() {
        System.out.println("Shutdown mail service");
    }


    public void setZoneId(ZoneId zoneId) {
        this.zoneId = zoneId;
    }

    public String getTime() {
        return ZonedDateTime.now(this.zoneId).format(DateTimeFormatter.ISO_DATE_TIME);
    }

    public void sendLoginMail(User user) {
        System.err.printf("Hi,%s! You are logged in at %s\n", user.getName(), getTime());
    }

    public void sendRegistrationMail(User user) {
        System.err.printf("Welcome %s!\n", user.getName());
    }
}
