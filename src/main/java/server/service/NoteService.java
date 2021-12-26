package server.service;

import server.service.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.service.repository.JournalRepository;
import server.service.repository.NoteRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
    public class NoteService {
        @Autowired
        private NoteRepository noteRepository;
        @Autowired
        private JournalRepository journalRepository;

        public void createNote(String date, String ingredient, String journal, String comment) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date dates = format.parse(date);
        Note note = new Note();
        note.setDate(dates);
        note.setIngredient(ingredient);
        note.setComment(comment);
        note.setCategory(journalRepository.findByName(journal));
        noteRepository.save(note);
    }
    public void deleteNote(Integer id) {
        Note note = noteRepository.findById(id).get();
        noteRepository.delete(note);
    }

    public void updateNote(String date, String ingredient, String journal, String comment,Integer id) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date dates = format.parse(date);
        Note note = noteRepository.findById(id).get();
        note.setDate(dates);
        note.setIngredient(ingredient);
        note.setComment(comment);
        note.setCategory(journalRepository.findByName(journal));
        noteRepository.save(note);
    }
}
