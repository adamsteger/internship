import java.util.UUID;

public class Review {
    private User writer;
    private int rating;
    private String comment;
    private EmployerList employerList;

    public Review(User writer, int rating, String comment) {
        this.writer = writer;
        this.rating = rating;
        this.comment = comment;
    }

    public Review(UUID writerID, int rating, String comment) {
        employerList = employerList.getInstance();
        Employer writer = employerList.getEmployerByID(writerID);
        this.writer = writer;
        this.rating = rating;
        this.comment = comment;
    }

    public String toString() {
        return "\nWriter: " + writer + "\nReview Rating: " + rating + "\nComment: " + comment;
    }
}
