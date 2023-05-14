package peaksoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.UserDao;
import peaksoft.entities.User;
import peaksoft.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void addUser(User user, String roleName) {
        userDao.addUser(user, roleName);
    }

    @Override
    public void updateUser(Long userId, User user, String roleName) {
        userDao.updateUser(userId, user, roleName);
    }

    @Override
    public User getUserByUserName(String username) {
        return userDao.getUserByUserName(username);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }
}
