package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> getListUsers();

    void addUser (User user);
    void deleteUser (int id);
    void updateUser (int id, User user);
    User getUser(int id);

}
