package server.repository;

import server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {
    User findByLogin(String login);
    List<User> findAllByLogin(String login);
    List<User> findAll();
    Optional<User> findById(Integer id);
    Boolean existsByLogin(String login);
}