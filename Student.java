import java.util.ArrayList;
import java.util.UUID;
/**
 * Class for a user of type Student
 * @author Byte Me
 */
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
    private ArrayList<InternshipPost> favoritePosts;
    private ArrayList<Review> reviews;
    private UUID id;
    private Resume resume;
    /**
     * Creates a student with a new UUID
     * @param firstName
     * @param lastName
     * @param username
     * @param password
     * @param gradYear
     * @param email
     * @param address
     * @param phone
     * @param gpa
     * @param showGPA
     */
    public Student(String firstName, String lastName, String username, String password, int gradYear, String email, 
                    String address, String phone, double gpa, boolean showGPA) {
        super(username, password);
        this.id = UUID.randomUUID();
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
        rating = -1;
        favoritePosts = new ArrayList<InternshipPost>();
        resume = new Resume();
        reviews = new ArrayList<Review>();
    }
    /**
     * Creates a student with an existing UUID
     * @param id
     * @param firstName
     * @param lastName
     * @param username
     * @param password
     * @param gradYear
     * @param email
     * @param address
     * @param phone
     * @param gpa
     * @param showGPA
     * @param rating
     * @param reviews
     * @param favPosts
     * @param resume
     */
    public Student(UUID id, String firstName, String lastName, String username, String password, int gradYear,
                    String email, String address, String phone, double gpa, boolean showGPA, double rating, ArrayList<Review> reviews,
                    ArrayList<InternshipPost> favPosts, Resume resume) {
        super(username, password);
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
        favoritePosts = favPosts;
        this.reviews = reviews;
        this.resume = resume;
    }
    /**
     * gets first name of student
     * @return String firstname
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * gets last name of student
     * @return String lastname
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * gets username of student
     * @return String username
     */
    public String getUserName() {
        return username;
    }
    /**
     * gets password of student
     * @return String password
     */
    public String getPassword() {
        return password;
    }
    /**
     * gets grad year of student
     * @return int gradYear
     */
    public int getGradYear() {
        return gradYear;
    }
    /**
     * gets email of student
     * @return String email
     */
    public String getEmail() {
        return email;
    }
    /**
     * gets phone number of student
     * @return String phone
     */
    public String getPhone() {
        return phone;
    }
    /**
     * gets address of student
     * @return String address
     */
    public String getAddress() {
        return address;
    }
    /**
     * gets GPA of student
     * @return double gpa
     */
    public double getGPA() {
        return gpa;
    }
    /**
     * gets boolean if GPA is shown
     * @return boolean whether or not to show GPA
     */
    public boolean getShowGPA() {
        return showGPA;
    }
    /**
     * gets rating of student
     * @return double rating
     */
    public double getRating() {
        return rating;
    }
    /**
     * gets resume of student
     * @return Resume resume
     */
    public Resume getResume() {
        return resume;
    }
    /**
     * gets favorite posts of student
     * @return ArrayList of InternshipPosts
     */
    public ArrayList<InternshipPost> getFavoritePosts() {
        return favoritePosts;
    }
    /**
     * gets reviews of student
     * @return ArrayList of Reviews
     */
    public ArrayList<Review> getReviews() {
        return reviews;
    }
    /**
     * gets uuid of student
     * @return UUID id
     */
    public UUID getUUID() {
        return id;
    }
    /**
     * gets full name of student
     * @return String firstname + lastname
     */
    public String getName() {
        return firstName + " " + lastName;
    }
    /**
     * adds a favorite post to student's favorite posts
     * @param post
     */
    public void addFavoritePost(InternshipPost post) {
        favoritePosts.add(post);
    }
    /**
     * creates a string for all aspects of student class
     * @return String including all arguments passed and corresponding names
     */
    public String toString() {
        String ret = "\nName: " + firstName + " " + lastName + "\nUsername: " + username + "\nPassword: " 
                    + password + "\nGrad Year: " + gradYear + "\nEmail: " + email + "\nPhone: "
                    + phone + "\nGPA: " + gpa + "\nRating: " + rating + "\nReviews: ";
        for (Review review : reviews) {
            ret += review + "\n";
        }
        ret += "Favorite Posts: ";
        for (InternshipPost post : favoritePosts) {
            ret += "\n\tEmployer: " + post.getEmployerTitle() + "\n\tPosition Title: " + post.getPosTitle();
        }
        ret += "\nResume: " + resume;
        return ret;
    }

}
