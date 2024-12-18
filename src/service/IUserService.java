package service;

import entity.User;

import java.util.List;

public interface IUserService {
    public int create(User user);
    public List<User> getAllUsers();
    public User getUserById(int id);
    public int update(User user);
    public int delete(int id);
}
