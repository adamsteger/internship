public class Review {
    private User writer;
    private int rating;
    private String comment;

    public Review(User writer, int rating, String comment) {
        this.writer = writer;
        this.rating = rating;
        this.comment = comment;
<<<<<<< HEAD
=======
    }

    public String toString() {
        return "Rating: " + rating + "\n" + writer + "\n" + comment + "\n";
>>>>>>> c43f91d7c528b69936fb5df9c95fcd1dd5c74523
    }
}
