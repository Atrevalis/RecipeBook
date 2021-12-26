package server.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import server.entity.Journal;
import server.entity.Note;
import server.entity.User;

import java.util.ArrayList;
import java.util.List;

@EnableTransactionManagement
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JournalDTO {

    private String journalName;
    private UserDTO user;
    private List<Note> idNote;//возможно не нужно

    @Transactional
    public List<JournalDTO> getJournalDTOList(List<Journal> journalList){
        List<JournalDTO> journalDTOList = new ArrayList<>();

        for(Journal journal : journalList){

            JournalDTO journalDTO = new JournalDTO();
            journalDTO.setJournalName(journal.getName());

            UserDTO userDTO = new UserDTO();
            userDTO.setLogin(journal.getUser().getLogin());//выяснить надо или нет

            journalDTO.setUser(userDTO);
            journalDTOList.add(journalDTO);
        }
        return journalDTOList;
    }


    public String getJournalName() {
        return journalName;
    }

    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public List<Note> getIdNote() {
        return idNote;
    }

    public void setIdNote(List<Note> idNote) {
        this.idNote = idNote;
    }

    public JournalDTO(String journalName, UserDTO user, List<Note> idNote) {
        this.journalName = journalName;
        this.user = user;
        this.idNote = idNote;
    }

    public JournalDTO() {
    }
}
