package data.mybatis.entity;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public abstract class AbstractEntity {
    private Long id;
    private long createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getCreateDateTime() {
        return Instant.ofEpochMilli(this.createdAt).atZone(ZoneId.systemDefault());
    }
}
