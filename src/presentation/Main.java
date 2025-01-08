package presentation;

import entity.User;
import service.IUserService;
import service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        IUserService dao = new UserServiceImpl();
        int ok = dao.delete(2);
        if (ok == 1)
            System.out.println("Suppression ok");
    }
}