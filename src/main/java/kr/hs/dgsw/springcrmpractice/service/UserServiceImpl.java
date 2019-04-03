package kr.hs.dgsw.springcrmpractice.service;

import kr.hs.dgsw.springcrmpractice.domain.User;
import kr.hs.dgsw.springcrmpractice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User addUser(User user) {
        Optional<User> target = userRepository.findByEmail(user.getEmail());
        if (target.isPresent()) {
            return null;
        }

        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> target = userRepository.findById(id);
        if (!target.isPresent()) {
            return null;
        }

        User targetUser = target.get();
        targetUser.setUsername(user.getUsername() != null ? user.getUsername() : targetUser.getUsername());
        targetUser.setEmail(user.getEmail() != null ? user.getEmail() : targetUser.getEmail());
        targetUser.setAvatarId(user.getAvatarId() != null ? user.getAvatarId() : targetUser.getAvatarId());

        return userRepository.save(targetUser);
    }

    @Override
    public boolean deleteUser(Long id) {
        Optional<User> target = userRepository.findById(id);
        if (!target.isPresent()) {
            return false;
        }

        try {
            userRepository.deleteById(id);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
}
