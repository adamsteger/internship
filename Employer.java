import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Employer extends User {
    private String email;
    private double rating;
    private ArrayList<Review> reviews;
    private String location;
    private String mission;
    private ImageIcon logo;
    private ArrayList<InternshipPost> posts;

    public Employer(String username, String password) {
        super(username, password);
    }

    public void addPost(InternshipPost post) {
        posts.add(post);
    }

    public void deletePost(InternshipPost post) {
        posts.remove(post);
    }

    public void addStudentReview(User student, int rating, String comment) {
        Review studentReview = new Review(student, rating, comment);
        reviews.add(studentReview);
    }
}
