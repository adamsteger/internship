import java.util.ArrayList;
import java.util.UUID;
/**
 * Represents an Employer type of User
 * @author Byte Me
 */
public class Employer extends User {
    private String title;
    private String email;
    private double rating;
    private String location;
    private String mission;
    private ArrayList<InternshipPost> posts;
    private ArrayList<Review> reviews;
    private UUID id;

    /**
     * Default constructor for Employer
     * @param username
     * @param password
     */
    public Employer(String username, String password) {
        super(username, password);
        title = "";
        email = "";
        rating = 0.0;
        location = "";
        mission = "";
        posts = new ArrayList<InternshipPost>();
        reviews = new ArrayList<Review>();
        id = super.getUUID();
    }
    /**
     * Constructor for employer with already defined UUID
     * @param id
     * @param title
     * @param username
     * @param password
     * @param email
     * @param rating
     * @param location
     * @param mission
     * @param reviews
     */
    public Employer(UUID id, String title, String username, String password, String email, double rating, String location, String mission, ArrayList<Review> reviews) {
        super(username, password);
        this.id = id;
        this.title = title;
        this.username = username;
        this.password = password;
        this.email = email;
        this.rating = rating;
        this.location = location;
        this.mission = mission;
        posts = new ArrayList<InternshipPost>();
        this.reviews = reviews;
    }
    /**
     * Constructor for employer with new UUID
     * @param title
     * @param username
     * @param password
     * @param email
     * @param location
     * @param mission
     */
    public Employer(String title, String username, String password, String email, String location, String mission) {
        super(username, password);
        this.title = title;
        this.username = username;
        this.password = password;
        this.email = email;
        rating = 5;
        this.location = location;
        this.mission = mission;
        reviews = new ArrayList<Review>();
        id = UUID.randomUUID();
    }
    /**
     * @return email of Employer
     */
    public String getEmail() {
        return email;
    }
    /**
     * @return double of Employer's rating
     */
    public double getRating() {
        return rating;
    }
    /**
     * @return String of Employer's location
     */
    public String getLocation() {
        return location;
    }
    /**
     * @return String of Employer mission statement
     */
    public String getMission() {
        return mission;
    }
    /**
     * @return ArrayList<InternshipPost> of Employer
     */
    public ArrayList<InternshipPost> getPosts() {
        return posts;
    }
    /**
     * @return ArrayList<Review> of Reviews made about Employer
     */
    public ArrayList<Review> getReviews() {
        return reviews;
    }
    /**
     * @return UUID of Employer
     */
    public UUID getUUID() {
        return id;
    }
    /**
     * @return String of title of the Employer
     */
    public String getTitle() {
        return title;
    }
    /**
     * Returns a String that includes the Employer's parameters
     */
    public String toString() {
        String ret = "\nTitle: " + title + "\nUsername: " + username + "\nPassword: " + password + "\nEmail: " + email + "\nRating: " +
                        rating + "\nLocation: " + location + "\nMission: " + mission + "\nReviews: ";
        for (Review review : reviews) {
            ret += review;
        }
        ret += "\nInternship Posts: ";
        for (InternshipPost post : posts) {
            ret += "\n\tPosition Title: " + post.getPosTitle() + "\tLocation: " + post.getLocation();
        }
        return ret;
    }
    /**
     * adds a post to the Employer's InternshipPosts
     * @param post
     */
    public void addPost(InternshipPost post) {
        posts.add(post);
    }
    /**
     * deletes a post to the Employer's InternshipPosts
     * @param post
     */
    public void deletePost(InternshipPost post) {
        posts.remove(post);
    }
}
