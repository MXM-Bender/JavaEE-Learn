package aop.learn2.service;

import aop.learn2.metrics.MetricTime;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Component //此注解将MailService声明为一个装配的组件(Bean)
public class MailService {
    private ZoneId zoneId = ZoneId.systemDefault();

    public void setZoneId(ZoneId zoneId) {
        this.zoneId = zoneId;
    }

    public String getTime() {
        return ZonedDateTime.now(this.zoneId).format(DateTimeFormatter.ISO_DATE_TIME);
    }

    @MetricTime("loginMail")
    public void sendLoginMail(User user) {
        System.err.printf("Hi,%s! You are logged in at %s\n", user.getName(), getTime());
    }

    public void sendRegistrationMail(User user) {
        System.err.printf("Welcome %s!\n", user.getName());
    }
}
