package server.service.repository;

import server.service.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JournalRepository extends JpaRepository<Journal, Integer> {
    List<Journal> findAllByName(String name);
    List<Journal> findAll();
    Journal findByName(String name);
    Optional<Journal> findById(Integer id);
    List<Journal> findAllById(Integer id);
    Boolean existsByName(String name);
}