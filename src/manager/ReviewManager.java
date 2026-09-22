package manager;

import java.util.Scanner;

import database.Database;
import models.Book;
import models.Review;
import models.User;

public class ReviewManager {

    Scanner sc = new Scanner(System.in);

    // Add Review
    public void addReview() {

        if (Database.users.isEmpty()) {
            System.out.println("No users registered.");
            return;
        }

        if (Database.books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.print("Enter Review ID: ");
        int reviewId = sc.nextInt();

        // Check duplicate Review ID
        for (Review r : Database.reviews) {
            if (r.getReviewId() == reviewId) {
                System.out.println("Review ID already exists!");
                return;
            }
        }

        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();

        boolean userFound = false;

        for (User user : Database.users) {
            if (user.getUserId() == userId) {
                userFound = true;
                break;
            }
        }

        if (!userFound) {
            System.out.println("User not found.");
            return;
        }

        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();

        boolean bookFound = false;

        for (Book book : Database.books) {
            if (book.getBookId() == bookId) {
                bookFound = true;
                break;
            }
        }

        if (!bookFound) {
            System.out.println("Book not found.");
            return;
        }

        int rating;

        do {
            System.out.print("Enter Rating (1-5): ");
            rating = sc.nextInt();

            if (rating < 1 || rating > 5) {
                System.out.println("Invalid Rating! Enter between 1 and 5.");
            }

        } while (rating < 1 || rating > 5);

        sc.nextLine();

        System.out.print("Enter Review: ");
        String reviewText = sc.nextLine();

        Review review = new Review(reviewId, userId, bookId, rating, reviewText);

        Database.reviews.add(review);

        System.out.println("Review Added Successfully!");
    }

    // Display Reviews
    public void displayReviews() {

        if (Database.reviews.isEmpty()) {
            System.out.println("No reviews available.");
            return;
        }

        System.out.println("\n===== REVIEWS =====");

        for (Review review : Database.reviews) {

            System.out.println(review);
            System.out.println("---------------------------");
        }
    }

    // Delete Review
    public void deleteReview() {

        if (Database.reviews.isEmpty()) {
            System.out.println("No reviews available.");
            return;
        }

        System.out.print("Enter Review ID to delete: ");
        int reviewId = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < Database.reviews.size(); i++) {

            if (Database.reviews.get(i).getReviewId() == reviewId) {

                Database.reviews.remove(i);

                System.out.println("Review Deleted Successfully!");

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Review ID not found.");
        }
    }
}