package server.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "note", schema = "public")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "ingredient", nullable = false)
    private String ingredient;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "comment", nullable = false)
    private String comment;

    @ManyToOne
    private Journal journal;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return id == note.id && Objects.equals(date, note.date) && Objects.equals(ingredient, note.ingredient) && Objects.equals(name, note.name) && Objects.equals(comment, note.comment) && Objects.equals(journal, note.journal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, ingredient, name, comment, journal);
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", date=" + date +
                ", ingredient='" + ingredient + '\'' +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                ", category=" + journal +
                '}';
    }

    public Note() {
    }

    public Note(int id, Date date, String ingredient, String comment, Journal journal) {
        this.id = id;
        this.date = date;
        this.ingredient = ingredient;
        this.comment = comment;
        this.journal = journal;
    }
}