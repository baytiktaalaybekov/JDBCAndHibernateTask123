package peaksoft;

import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;
import peaksoft.util.Util;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
      UserService userService = new UserServiceImpl();
      userService.dropUsersTable();
      userService.saveUser("Baytik","Taaalaybekov",(byte) 20);
      userService.removeUserById(1L);
      userService.getAllUsers();
      userService.cleanUsersTable();

    }
}
