package peaksoft.dao;

import peaksoft.entities.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void addUser(User user, String roleName);
    void updateUser(Long userId, User user, String roleName);
    User getUserByUserName(String username);
    void deleteUser(User user);
    User getUserById(Long id);
}
