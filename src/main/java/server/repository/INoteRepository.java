package server.repository;


import server.entity.Journal;
import server.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface INoteRepository extends JpaRepository<Note, Integer> {
    Optional<Note> findById(Integer id);
    List<Note> findAllByIdJournal(Journal journal);
    List<Note> findAllByIdJournalOrderByDateDesc(Journal journal);
}