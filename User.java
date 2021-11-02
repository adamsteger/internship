import java.util.UUID;
import java.util.ArrayList;
/**
 * Abstract base class to define all Users in the system
 * @author Byte Me
 */
public abstract class User {
    protected String username;
    protected String password;
    private UUID id;
    private ArrayList<Review> reviews;
    /**
     * Constructor for creating a new student with new UUID
     * @param username A string of the username of the new user
     * @param password A string of the password of the new user
     */    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.id = UUID.randomUUID();
        this.reviews = new ArrayList<Review>();
    }
    /**
     * Accesses the username of user
     * @return Returns a string of the username
     */
    public String getUsername() {
        return username;
    }
    /**
     * Accesses the password of user
     * @return Returns a string of the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * Accesses the UUID of user
     * @return Returns the id of the user
     */
    public UUID getUUID() {
        return id;
    }
    /**
     * Accesses the ArrayList of reviews from either an employer or student user
     * @return ArrayList of reviews 
     */
    public ArrayList<Review> getReviews() {
        return reviews;
    }
}
