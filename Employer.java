import java.util.ArrayList;
import java.util.UUID;

public class Employer extends User {
    private String title;
    private String email;
    private double rating;
    private ArrayList<Review> reviews;
    private String location;
    private String mission;
    private ArrayList<InternshipPost> posts;
    private UUID id;


    public Employer(String username, String password) {
        super(username, password);
        title = "";
        email = "";
        rating = 0.0;
        reviews = new ArrayList<Review>();
        location = "";
        mission = "";
        posts = new ArrayList<InternshipPost>();
        id = super.getUUID();
    }

    public Employer(UUID id, String title, String username, String password, String email, double rating, String location, String mission, ArrayList<Review> reviews) {
        super(username, password, id);
        this.id = id;
        this.title = title;
        this.username = username;
        this.password = password;
        this.email = email;
        this.rating = rating;
        this.location = location;
        this.mission = mission;
        this.reviews = reviews;
    }

    public String getEmail() {
        return email;
    }

    public double getRating() {
        return rating;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
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

        return ret;
    }

    public void addPost(InternshipPost post) {
        posts.add(post);
    }

    public void deletePost(InternshipPost post) {
        posts.remove(post);
    }

    // public void addStudentReview(Student student, int rating, String comment) {
    //     StudentReview studentReview = new StudentReview(student, rating, comment);
    //     reviews.add(studentReview);
    // }

}
