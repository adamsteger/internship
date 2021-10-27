public class StudentReview {
    private String writer;
    private int rating;
    private String comment;
    private EmployerList employerList;

    public StudentReview(String writer, int rating, String comment) {
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

    public EmployerList getEmployerList() {
        return employerList;
    }
    public String toString() {
        return "\n\tWriter: " + writer + "\n\tReview Rating: " + rating + "\n\tComment: " + comment;
    }
}
