import java.util.ArrayList;
import java.util.Hashtable;
import java.util.UUID;

public class Student extends User {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private int gradYear;
    private float gpa;
    private boolean showGPA;
    private double rating;
    private ArrayList<Review> reviews;
    private ArrayList<InternshipPost> favoritePosts;
    private static UUID id;

    public Student(String username, String password) {
        super(username, password, id);
        
    }

}
