import java.util.ArrayList;
import java.util.UUID;

public class Employer extends User {
    private String title;
    private String email;
    private double rating;
    private String location;
    private String mission;
    private ArrayList<InternshipPost> posts;
    private ArrayList<Review> reviews;
    private UUID id;


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
    }

    public String getEmail() {
        return email;
    }

    public double getRating() {
        return rating;
    }

    public String getLocation() {
        return location;
    }

    public String getMission() {
        return mission;
    }

    public ArrayList<InternshipPost> getPosts() {
        return posts;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public UUID getUUID() {
        return id;
    }

    public String getTitle() {
        return title;
    }

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

    public void addPost(InternshipPost post) {
        posts.add(post);
    }

    public void deletePost(InternshipPost post) {
        posts.remove(post);
    }
}
