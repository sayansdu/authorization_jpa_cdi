package kz.sayan.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * User: Sayan.Zhumashev
 * Date: 7/16/14
 * Time: 5:36 PM
 */
@Entity
@Table(name = "users")
@NamedQuery(name = "getUserByEmail", query = "select count(*) from User u where u.email = :email")
public class User {

    @Id
    // If in your DB have auto_increment (like in mysql), user IDENTITY instead of AUTO
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //Bean validation only actives when your server support CDI (Jboss-AS 7, Tomcat doesn't)
    @Column(name="name")
    @NotNull @Size(min=3)
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    private String iin;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }
}
