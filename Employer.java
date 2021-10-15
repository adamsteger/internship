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

    }

    public void deletePost(InternshipPost post) {

    }

    public void addStudentReview(Student student, int rating, String comment) {

    }
}
