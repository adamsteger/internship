import java.util.UUID;

public class Admin extends User {
    private static UUID id;
    
    public Admin(String username, String password) {
        super(username, password, id);
    }

    public void deletePost(InternshipPost post) {

    }

    public void addPost(InternshipPost post) {

    }

    public void deleteStudentReview(StudentReview review) {

    }

    public void addStudentReview(StudentReview review) {

    }
}
