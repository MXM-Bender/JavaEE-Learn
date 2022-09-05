package data.hibernate.entity;


import javax.persistence.*;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@MappedSuperclass
public class AbstractEntity {
    private Long id;
    private Long createdAt;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false, updatable = false)
    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createAt) {
        this.createdAt = createAt;
    }

    /*
    创建一个虚拟方法，用于添加表中不存在的字段
    可以用来忽略某个字段，不让其映射数据库
     */
    @Transient
    public ZonedDateTime getCreatedDateTime() {
        return Instant.ofEpochMilli(this.createdAt).atZone(ZoneId.systemDefault());
    }

    /*
    该注解在 insert 操作之前执行
     */
    @PrePersist
    public void preInsert() {
        setCreatedAt(System.currentTimeMillis());
    }
}
