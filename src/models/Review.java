package models;

public class Review {

    private int reviewId;
    private int userId;
    private int bookId;
    private int rating;
    private String reviewText;

    public Review(int reviewId, int userId, int bookId,
                  int rating, String reviewText) {

        this.reviewId = reviewId;
        this.userId = userId;
        this.bookId = bookId;
        this.rating = rating;
        this.reviewText = reviewText;
    }

    public int getReviewId() {
        return reviewId;
    }

    public int getUserId() {
        return userId;
    }

    public int getBookId() {
        return bookId;
    }

    public int getRating() {
        return rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    @Override
    public String toString() {

        return "Review ID: " + reviewId +
               "\nUser ID: " + userId +
               "\nBook ID: " + bookId +
               "\nRating: " + rating +
               "\nReview: " + reviewText;
    }
}