package server.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "public")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "login", nullable=false)
    private String login;

    @Column(name = "password", nullable=false)
    private String password;

    @OneToMany(mappedBy = "users")
    private List<Journal> journals;

    @ManyToOne
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Journal> getJournal() {
        return journals;
    }

    public void setJournal(List<Journal> journals) {
        this.journals = journals;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user1 = (User) o;
        return Objects.equals(id, user1.id) && Objects.equals(login, user1.login) && Objects.equals(password, user1.password) && Objects.equals(journals, user1.journals) && Objects.equals(user, user1.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, journals, user);
    }

    public User(Integer id, String login, String password, List<Journal> journals, User user) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.journals = journals;
        this.user = user;
    }

    public User() {
    }
}
