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
    private double gpa;
    private boolean showGPA;
    private double rating;
    private ArrayList<Review> reviews;
    private ArrayList<InternshipPost> favoritePosts;
    private static UUID id;

    public Student(String username, String password) {
        super(username, password, id);
        
    }

    public Student(UUID id, String firstName, String lastName, String username, String password, int gradYear,
                    String email, String address, String phone, double gpa, boolean showGPA, double rating) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.gradYear = gradYear;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.gpa = gpa;
        this.showGPA = showGPA;
        this.rating = rating;
    }
    public String toString() {
        return "Name: " + firstName + " " + lastName + "\nUsername: " + username + "\nPassword: " 
                    + password + "\nGrad Year: " + gradYear + "\nEmail: " + email + "\nPhone: "
                    + phone + "\nGPA: " + gpa + "\nRating: " + rating;
    }

}
