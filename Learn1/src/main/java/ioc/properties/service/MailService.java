package ioc.properties.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Component //此注解将MailService声明为一个装配的组件(Bean)
public class MailService {

    // 注入 SmtpConfig 类的 host 属性的值
    @Value("#{smtpConfig.host}")
    private String smtpHost;
    // 注入 SmtpConfig 类的 port 属性的值
    @Value("#{smtpConfig.port}")
    private int smtpPort;

    @Autowired
    private ZoneId zoneId = ZoneId.systemDefault();

    public void sendWelcomeMail(User user) {
        System.out.println("at zone: " + zoneId);
        System.out.println("sent by smtp host: " + smtpHost);
        System.out.println("sent by smtp port: " + smtpPort);
    }
}
