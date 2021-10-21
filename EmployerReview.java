public class EmployerReview {
    private Student writer;
    private int rating;
    private String comment;

    public EmployerReview(Student writer, int rating, String comment) {
        this.writer = writer;
        this.rating = rating;
        this.comment = comment;
    }

    public String studentToString() {
        return "\nWriter: " + writer.getName() + "\nReview Rating: " + rating + "\nComment: " + comment;
    }
}
