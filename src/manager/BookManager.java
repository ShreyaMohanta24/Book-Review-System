package manager;

import java.util.ArrayList;
import java.util.Scanner;

import database.Database;
import models.Book;
import models.Review;

public class BookManager {

    Scanner sc = new Scanner(System.in);

    // Add Book
    public void addBook() {

        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();
        sc.nextLine();

        // Check duplicate Book ID
        for (Book b : Database.books) {
            if (b.getBookId() == bookId) {
                System.out.println("Book ID already exists!");
                return;
            }
        }

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        System.out.print("Enter Genre: ");
        String genre = sc.nextLine();

        Database.books.add(new Book(bookId, title, author, genre));

        System.out.println("Book Added Successfully!");
    }

    // Display Books
    public void displayBooks() {

        if (Database.books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\n===== BOOK LIST =====");

        for (Book book : Database.books) {
            System.out.println(book);
            System.out.println("---------------------------");
        }
    }

    // Sort Books Alphabetically
    public void sortBooksAlphabetically() {

        if (Database.books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        mergeSort(Database.books, 0, Database.books.size() - 1);

        System.out.println("\nBooks Sorted Successfully!\n");

        displayBooks();
    }

    // Merge Sort
    private void mergeSort(ArrayList<Book> books, int left, int right) {

        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(books, left, mid);

            mergeSort(books, mid + 1, right);

            merge(books, left, mid, right);
        }
    }

    // Merge Method
    private void merge(ArrayList<Book> books, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        Book[] L = new Book[n1];
        Book[] R = new Book[n2];

        for (int i = 0; i < n1; i++)
            L[i] = books.get(left + i);

        for (int j = 0; j < n2; j++)
            R[j] = books.get(mid + 1 + j);

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {

            if (L[i].getTitle().compareToIgnoreCase(R[j].getTitle()) <= 0) {

                books.set(k, L[i]);
                i++;

            } else {

                books.set(k, R[j]);
                j++;
            }

            k++;
        }

        while (i < n1) {

            books.set(k, L[i]);
            i++;
            k++;
        }

        while (j < n2) {

            books.set(k, R[j]);
            j++;
            k++;
        }
    }
        // Search Book using Binary Search
    public void searchBook() {

        if (Database.books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        // Sort first
        mergeSort(Database.books, 0, Database.books.size() - 1);

        sc.nextLine();

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        int index = binarySearch(title);

        if (index == -1) {
            System.out.println("Book Not Found.");
        } else {
            System.out.println("\n===== BOOK FOUND =====");
            System.out.println(Database.books.get(index));
        }
    }

    // Binary Search
    private int binarySearch(String title) {

        int low = 0;
        int high = Database.books.size() - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result = Database.books.get(mid)
                    .getTitle()
                    .compareToIgnoreCase(title);

            if (result == 0) {
                return mid;
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    // Display Top Rated Books
    public void displayTopRatedBooks() {

        if (Database.books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        ArrayList<Book> sortedBooks = new ArrayList<>(Database.books);

        // Selection Sort based on Average Rating
        for (int i = 0; i < sortedBooks.size() - 1; i++) {

            int maxIndex = i;

            for (int j = i + 1; j < sortedBooks.size(); j++) {

                if (getAverageRating(sortedBooks.get(j).getBookId())
                        > getAverageRating(sortedBooks.get(maxIndex).getBookId())) {

                    maxIndex = j;
                }
            }

            Book temp = sortedBooks.get(i);
            sortedBooks.set(i, sortedBooks.get(maxIndex));
            sortedBooks.set(maxIndex, temp);
        }

        System.out.println("\n===== TOP RATED BOOKS =====");

        for (Book book : sortedBooks) {

            double avg = getAverageRating(book.getBookId());

            System.out.println(book);
            System.out.printf("Average Rating : %.2f%n", avg);
            System.out.println("---------------------------");
        }
    }

    // Calculate Average Rating
    private double getAverageRating(int bookId) {

        int total = 0;
        int count = 0;

        for (Review review : Database.reviews) {

            if (review.getBookId() == bookId) {
                total += review.getRating();
                count++;
            }
        }

        if (count == 0)
            return 0;

        return (double) total / count;
    }

}