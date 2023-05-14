package peaksoft.service;

import peaksoft.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void addUser(User user, String roleName);
    void updateUser(Long userId, User user, String roleName);
    User getUserByUserName(String username);
    void deleteUser(User user);
    User getUserById(Long id);
}
