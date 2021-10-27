import java.util.UUID;

public class Review {
    private String writer;
    private int rating;
    private String comment;

    public Review(String writer, int rating, String comment) {
        this.writer = writer;
        this.rating = rating;
        this.comment = comment;
    }

    public String getWriter() {
        return writer;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public String toString() {
        return "\n\tWriter: " + writer + "\n\tReview Rating: " + rating + "\n\tComment: " + comment;
    }
}
