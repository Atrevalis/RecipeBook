package server.service.repository;


import server.service.entity.Journal;
import server.service.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {
    Optional<Note> findById(Integer id);
    List<Note> findAllByIdJournal(Journal journal);
    List<Note> findAllByIdJournalOrderByDateDesc(Journal journal);
}