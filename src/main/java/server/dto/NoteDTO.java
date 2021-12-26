package server.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import server.entity.Journal;
import server.entity.Note;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@EnableTransactionManagement
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NoteDTO {


    @ManyToOne
    private Journal journal;

    private Integer id;
    private String date;
    private String ingredient;
    private String comment;
    private String name;
    private JournalDTO journalDTO;

    SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    @Transactional
    public List<NoteDTO> getNoteDTOList(List<Note> noteList){
        List<NoteDTO> noteDTOList = new ArrayList<>();

        for(Note note : noteList){
            journalDTO = new JournalDTO();
            NoteDTO noteDTO = new NoteDTO();
            noteDTO.setId(note.getId());
            noteDTO.setDate(df.format(note.getDate()));
            noteDTO.setName(note.getName());
            noteDTO.setComment(note.getComment());
            noteDTO.setIngredient(note.getIngredient());
            noteDTO.setJournal(note.getJournal());
            noteDTOList.add(noteDTO);
        }
        return noteDTOList;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JournalDTO getJournalDTO() {
        return journalDTO;
    }

    public void setJournalDTO(JournalDTO journalDTO) {
        this.journalDTO = journalDTO;
    }
}

