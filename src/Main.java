import java.util.Scanner;

import manager.BookManager;
import manager.ReviewManager;
import manager.UserManager;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserManager userManager = new UserManager();
        BookManager bookManager = new BookManager();
        ReviewManager reviewManager = new ReviewManager();

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("      BOOK REVIEW SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Register User");
            System.out.println("2. Display Users");
            System.out.println("3. Add Book");
            System.out.println("4. Display Books");
            System.out.println("5. Search Book");
            System.out.println("6. Sort Books Alphabetically");
            System.out.println("7. Display Top Rated Books");
            System.out.println("8. Add Review");
            System.out.println("9. Display Reviews");
            System.out.println("10. Delete Review");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    userManager.registerUser();
                    break;

                case 2:
                    userManager.displayUsers();
                    break;

                case 3:
                    bookManager.addBook();
                    break;

                case 4:
                    bookManager.displayBooks();
                    break;

                case 5:
                    bookManager.searchBook();
                    break;

                case 6:
                    bookManager.sortBooksAlphabetically();
                    break;

                case 7:
                    bookManager.displayTopRatedBooks();
                    break;

                case 8:
                    reviewManager.addReview();
                    break;

                case 9:
                    reviewManager.displayReviews();
                    break;

                case 10:
                    reviewManager.deleteReview();
                    break;

                case 11:
                    System.out.println("\nThank you for using Book Review System!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 11);

        sc.close();
    }
}