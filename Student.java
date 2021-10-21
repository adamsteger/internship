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
    private EmployerList employerList;

    public Student(String username, String password) {
        super(username, password, id);
        
    }

    public Student(UUID id, String firstName, String lastName, String username, String password, int gradYear,
                    String email, String address, String phone, double gpa, boolean showGPA, double rating, ArrayList<Review> reviews) {
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
        this.reviews = reviews;
        employerList = EmployerList.getInstance();
    }

    public String toString() {
        String ret = "\nName: " + firstName + " " + lastName + "\nUsername: " + username + "\nPassword: " 
                    + password + "\nGrad Year: " + gradYear + "\nEmail: " + email + "\nPhone: "
                    + phone + "\nGPA: " + gpa + "\nRating: " + rating + "\nReviews: ";
        for (Review review : reviews) {
            ret += review + "\n";
        }
        return ret;
    }

    public void addReview(UUID writerID, int rating, String comment) {
        Employer writer = employerList.getEmployerByID(writerID);
        Review review = new Review(writer, rating, comment);
        reviews.add(review);
    }

}
