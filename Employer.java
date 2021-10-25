import java.util.ArrayList;
import java.util.UUID;

import javax.swing.ImageIcon;

public class Employer extends User {
    private String title;
    private String email;
    private double rating;
    private ArrayList<EmployerReview> reviews;
    private String location;
    private String mission;
    private ArrayList<InternshipPost> posts;
    private static UUID id;

    public Employer() {
        title = "";
        email = "";
        rating = 0.0;
        location = "";
        reviews = new ArrayList<EmployerReview>();
        mission = "";
        posts = new ArrayList<InternshipPost>();
    }

    public Employer(String username, String password) {
        super(username, password, id);
    }

    public Employer(UUID id, String title, String username, String password, String email, double rating, String location, String mission) {
        this.id = id;
        this.title = title;
        this.username = username;
        this.password = password;
        this.email = email;
        this.rating = rating;
        this.location = location;
        this.mission = mission;
    }

    public String getEmail() {
        return this.email;
    }

    public double getRating() {
        return this.rating;
    }

    public ArrayList<EmployerReview> getReviews() {
        return this.reviews;
    }

    public String getLocation() {
        return this.location;
    }

    public String getMission() {
        return this.mission;
    }

    public ArrayList<InternshipPost> getPosts() {
        return this.posts;
    }

    public UUID getID() {
        return this.id;
    }

    public String toString() {
        String ret = "\nTitle: " + title + "\nUsername: " + username + "\nPassword: " + password + "\nEmail: " + email + "\nRating: " +
                        rating + "\nLocation: " + location + "\nMission: " + mission;

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

    public UUID getUUID() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
