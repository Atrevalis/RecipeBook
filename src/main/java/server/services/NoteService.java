package server.services;

import server.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.repository.IJournalRepository;
import server.repository.INoteRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
    public class NoteService {
        @Autowired
        private INoteRepository noteRepository;
        @Autowired
        private IJournalRepository journalRepository;

        public void createNote(String date, String ingredient, String journal, String comment) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date dates = format.parse(date);
        Note note = new Note();
        note.setDate(dates);
        note.setIngredient(ingredient);
        note.setComment(comment);
        note.setJournal(journalRepository.findByName(journal));
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
        note.setJournal(journalRepository.findByName(journal));
        noteRepository.save(note);
    }

    public List<Note> findAllByIdJournalOrderByDate(String journalName){
        return noteRepository.findAllByIdJournalOrderByDateDesc(journalRepository.findByName(journalName));
    }
}
