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
    private ArrayList<StudentReview> reviews;
    private ArrayList<InternshipPost> favoritePosts;
    private static UUID id;
    private EmployerList employerList;

    public Student(String username, String password) {
        super(username, password, id);
    }

    public Student() {
        firstName = "";
        lastName = "";
        email = "";
        phone = "";
        address = "";
        gradYear = 0;
        gpa = 0.0;
        showGPA = true;
        rating = 0.0;
        reviews = new ArrayList<StudentReview>();
        favoritePosts = new ArrayList<InternshipPost>();
    }

    public Student(UUID id, String firstName, String lastName, String username, String password, int gradYear,
                    String email, String address, String phone, double gpa, boolean showGPA, double rating, ArrayList<StudentReview> reviews,
                    ArrayList<InternshipPost> favPosts) {
        super();
        this.id = id;
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
        this.employerList = EmployerList.getInstance();
        this.favoritePosts = favPosts;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getUserName() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public int getGradYear() {
        return this.gradYear;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getAddress() {
        return this.address;
    }

    public double getGPA() {
        return this.gpa;
    }

    public boolean getShowGPA() {
        return this.showGPA;
    }

    public double getRating() {
        return this.rating;
    }

    public ArrayList<StudentReview> getReviews() {
        return this.reviews;
    }

    public ArrayList<InternshipPost> getFavoritePosts() {
        return this.favoritePosts;
    }

    public UUID getUUID() {
        return this.id;
    }

    public EmployerList getEmployerList() {
        return this.employerList;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public String toString() {
        String ret = "\nName: " + firstName + " " + lastName + "\nUsername: " + username + "\nPassword: " 
                    + password + "\nGrad Year: " + gradYear + "\nEmail: " + email + "\nPhone: "
                    + phone + "\nGPA: " + gpa + "\nRating: " + rating + "\nReviews: ";
        for (StudentReview review : reviews) {
            ret += review + "\n";
        }
        ret += "Favorite Posts: ";
        for (InternshipPost post : favoritePosts) {
            ret += "\n\tEmployer: " + post.getEmployerTitle() + "\n\tPosition Title: " + post.getPosTitle();
        }
        return ret;
    }

    public void addReview(UUID writerID, int rating, String comment) {
        Employer writer = employerList.getEmployerByID(writerID);
        StudentReview review = new StudentReview(writer, rating, comment);
        reviews.add(review);
    }

}
