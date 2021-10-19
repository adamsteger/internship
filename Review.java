public class Review {
    private User writer;
    private int rating;
    private String comment;

    public Review(User writer, int rating, String comment) {
        this.writer = writer;
        this.rating = rating;
        this.comment = comment;
    }

    public String toString() {
        return "Rating: " + rating + "\n" + writer + "\n" + comment + "\n";
    }
}
