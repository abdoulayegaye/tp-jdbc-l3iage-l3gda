package presentation;

import entity.User;
import service.IUserService;
import service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        IUserService dao = new UserServiceImpl();
        User user = new User();
        user.setFirstname("Mansour");
        user.setLastname("SECK");
        user.setUsername("mansour");
        user.setPassword("passer123");
        int ok = dao.create(user);
        if(ok == 1)
            System.out.println("User created !");
        else
            System.out.println("Erreur d'insertion");
    }
}