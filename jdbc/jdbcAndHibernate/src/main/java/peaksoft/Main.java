package peaksoft;

import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;
import peaksoft.util.Util;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        Util.getConnection();
        UserService userService = new UserServiceImpl();
        Scanner scanner = new Scanner(System.in);


            while (true){
                System.out.println("""
                    <<Commands>>
                    1.Press -> createUsersTable: 
                    2.Press -> Drop table: 
                    3.Press -> Save users: 
                    4.Press -> Remove user by Id: 
                    5.Press -> Get all users: 
                    6.Press -> Clean users table:
                   
                    ENTER BY COMMAND:
                     """);
            int number= scanner.nextInt();
            switch (number){
                case 1:
                    userService.createUsersTable();
                    break;
                case 2:
                    userService.dropUsersTable();
                    break;
                case 3:
                    userService.saveUser("Baytik","Taalaybekov",(byte) 20);
                    break;
                case 4:
                    userService.removeUserById(new Scanner(System.in).nextInt());
                    break;
                case 5:
                    System.out.println(userService.getAllUsers());
                    break;
                case 6:
                    userService.cleanUsersTable();
                    break;
                default:
                    System.out.println("OK");
                    break;
            }

        }

    }
}
