package server.requests;

public class UpdateNote {
    private int id;
    private String date;
    private String ingredient;
    private String name;
    private String comment;
    private String journal;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public UpdateNote() {
    }

    public UpdateNote(int id, String date, String ingredient, String name, String comment, String journal) {
        this.id = id;
        this.date = date;
        this.ingredient = ingredient;
        this.name = name;
        this.comment = comment;
        this.journal = journal;
    }
}


