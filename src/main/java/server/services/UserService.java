package server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import server.entity.User;
import server.repository.IJournalRepository;
import server.repository.IUserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IJournalRepository journalRepository;


    public UserService(IUserRepository usersRepository) {
        this.userRepository = usersRepository;
    }

    public void createUsers(User users) {
        userRepository.save(users);
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public List<User> findAllByLogin(String login) {
        return userRepository.findAllByLogin(login);
    }

    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = findByLogin(login);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException(String.format("User %s is not found", login));
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), true, true, true, true, new HashSet<>());
    }

    public Boolean existsUser(String login) {
        return userRepository.existsByLogin(login);
    }
}