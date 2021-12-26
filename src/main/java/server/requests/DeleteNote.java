package server.requests;

public class DeleteNote {
    private int idNote;
    private String login;
    private String journal;

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public int getIdNote() {
        return idNote;
    }

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public DeleteNote(int idNote, String login, String journal) {
        this.idNote = idNote;
        this.login = login;
        this.journal = journal;
    }
}
