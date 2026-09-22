package manager;

import java.util.Scanner;

import database.Database;
import models.User;

public class UserManager {

    Scanner sc = new Scanner(System.in);

    public void registerUser() {

        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();
        sc.nextLine();

        // Check duplicate User ID
        for (User u : Database.users) {
            if (u.getUserId() == userId) {
                System.out.println("User ID already exists!");
                return;
            }
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        User user = new User(userId, name, email, password);

        Database.users.add(user);

        System.out.println("User Registered Successfully!");
    }

    public void displayUsers() {

        if (Database.users.isEmpty()) {
            System.out.println("No users found.");
            return;
        }

        System.out.println("\n===== USERS =====");

        for (User user : Database.users) {
            System.out.println(user);
            System.out.println("---------------------");
        }
    }

}