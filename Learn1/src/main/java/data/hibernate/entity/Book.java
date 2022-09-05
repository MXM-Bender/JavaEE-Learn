package data.hibernate.entity;


import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Book extends AbstractEntity {
    private String title;

    @Column(nullable = false, length = 100)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("Book[id=%s, title=%s, createdAt=%s, createdDateTime=%s]", getId(), getTitle(),
                getCreatedAt(), getCreatedDateTime());
    }
}
