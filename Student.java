import java.util.ArrayList;
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
    private ArrayList<InternshipPost> favoritePosts;
    private UUID id;
    private Resume resume;

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
    }

    public Student(UUID id, String firstName, String lastName, String username, String password, int gradYear,
                    String email, String address, String phone, double gpa, boolean showGPA, double rating,
                    ArrayList<InternshipPost> favPosts) {
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
        resume = new Resume();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getGradYear() {
        return gradYear;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public double getGPA() {
        return gpa;
    }

    public boolean getShowGPA() {
        return showGPA;
    }

    public double getRating() {
        return rating;
    }

    public Resume getResume() {
        return resume;
    }

    public ArrayList<InternshipPost> getFavoritePosts() {
        return favoritePosts;
    }

    public UUID getUUID() {
        return id;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public void addFavoritePost(InternshipPost post) {
        favoritePosts.add(post);
    }

    public String toString() {
        String ret = "\nName: " + firstName + " " + lastName + "\nUsername: " + username + "\nPassword: " 
                    + password + "\nGrad Year: " + gradYear + "\nEmail: " + email + "\nPhone: "
                    + phone + "\nGPA: " + gpa + "\nRating: " + rating + "\nReviews: ";
        ArrayList<Review> reviews = super.getReviews();
        for (Review review : reviews) {
            ret += review + "\n";
        }
        ret += "Favorite Posts: ";
        for (InternshipPost post : favoritePosts) {
            ret += "\n\tEmployer: " + post.getEmployerTitle() + "\n\tPosition Title: " + post.getPosTitle();
        }
        return ret;
    }

}
