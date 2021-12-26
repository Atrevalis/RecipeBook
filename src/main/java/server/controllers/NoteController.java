package server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import server.dto.NoteDTO;
import server.requests.AddNote;
import server.requests.DeleteNote;
import server.requests.JournalName;
import server.requests.UpdateNote;
import server.services.NoteService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping("/addNote")
    public void createNote(@RequestBody AddNote addNote, HttpServletResponse response){
        try{
            noteService.createNote(addNote.getDate(), addNote.getIngredient(), addNote.getJournal(), addNote.getComment());
            response.setStatus(HttpServletResponse.SC_CREATED);
        }catch (Exception e){
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/deleteNote")
    public void deleteNote(@RequestBody DeleteNote deleteNote, HttpServletResponse response){
        try{
                noteService.deleteNote(deleteNote.getIdNote());
                response.setStatus(HttpServletResponse.SC_CREATED);
        }catch (Exception e){
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/listNote")
    public @ResponseBody
    List<NoteDTO> listNote(@RequestBody JournalName journalName){
        NoteDTO noteDTO = new NoteDTO();
        return noteDTO.getNoteDTOList(noteService.findAllByIdJournalOrderByDate(journalName.getJournalName()));
    }

    @PostMapping("/updateNote")
    public void updateNote(@RequestBody UpdateNote updateNote, HttpServletResponse response){
        try{
                noteService.updateNote(updateNote.getDate(), updateNote.getIngredient(), updateNote.getJournal(), updateNote.getComment(),updateNote.getId());
                response.setStatus(HttpServletResponse.SC_OK);
        }catch(Exception e){
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}