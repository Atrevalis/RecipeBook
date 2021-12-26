package server.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import server.dto.JournalDTO;
import server.entity.User;
import server.requests.Login;
import server.services.UserService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public void registration(@RequestBody User user, HttpServletResponse response) {
        try {
            userService.createUsers(user);
            response.setStatus(HttpServletResponse.SC_CREATED);
        }catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/userJournals")
    public @ResponseBody List<JournalDTO> getAllJournals(@RequestBody Login login){
        User user = userService.findByLogin(login.getLogin());
        JournalDTO journalDTO = new JournalDTO();
        return journalDTO.getJournalDTOList(user.getJournal());
    }

}
