package server.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import server.entity.Journal;
import server.entity.User;

import java.util.ArrayList;
import java.util.List;

@EnableTransactionManagement
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private String login;
    private List<JournalDTO> journal;

    @Transactional
    public List<UserDTO> getUsersDTOList(List<User> usersList){
        List<UserDTO> userDTOList = new ArrayList<>();

        for(User user : usersList){
            journal = new ArrayList<>();
            UserDTO userDTO = new UserDTO();
            userDTO.setLogin(user.getLogin());
            for(Journal journals : user.getJournal()){
                JournalDTO journalDTO = new JournalDTO();
                journalDTO.setJournalName(journals.getName());
                journal.add(journalDTO);
            }
            userDTO.setJournal(journal);
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<JournalDTO> getJournal() {
        return journal;
    }

    public void setJournal(List<JournalDTO> journal) {
        this.journal = journal;
    }
}
