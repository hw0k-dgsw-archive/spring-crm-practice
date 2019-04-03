package kr.hs.dgsw.springcrmpractice.service;

import kr.hs.dgsw.springcrmpractice.domain.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();
    User getUser(Long id);
    User addUser(User user);
    User updateUser(Long id, User user);
    boolean deleteUser(Long id);
}
