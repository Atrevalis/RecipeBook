package server.service.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "journal", schema = "public")
public class Journal {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "journal")
    private Collection<Note> notes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collection<Note> getNotes() {
        return notes;
    }

    public void setNotes(Collection<Note> notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Journal journal = (Journal) o;
        return id == journal.id && Objects.equals(name, journal.name) && Objects.equals(user, journal.user) && Objects.equals(notes, journal.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, user, notes);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", notes=" + notes +
                '}';
    }

    public Journal() {
    }

    public Journal(int id, String name, User user, Collection<Note> notes) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.notes = notes;
    }
}
