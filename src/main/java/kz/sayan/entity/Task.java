package kz.sayan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * User: Sayan.Zhumashev
 * Date: 7/16/14
 * Time: 5:36 PM
 */
@Entity
@Table(name="tasks")
public class Task {

    @Id @GeneratedValue
    private Long id;

    @NotNull(message = "title cannot be empty")
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
