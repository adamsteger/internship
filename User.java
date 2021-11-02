import java.util.UUID;
import java.util.ArrayList;
/**
 * Base class to define all Users in the system
 * @author Byte Me
 */
public abstract class User {
    protected String username;
    protected String password;
    private StudentList studentList;
    private EmployerList employerList;
    private AdminList adminList;
    private InternshipList internshipList;
    private UUID id;
    private ArrayList<Review> reviews;
    /**
     * Constructor for creating a new student with new UUID
     * @param username
     * @param password
     */    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.id = UUID.randomUUID();
        this.reviews = new ArrayList<Review>();
    }
    /**
     * gets useername of user
     * @return String username
     */
    public String getUsername() {
        return username;
    }
    /**
     * gets password of user
     * @return String password
     */
    public String getPassword() {
        return password;
    }
    /**
     * gets UUID of user
     * @return UUID id
     */
    public UUID getUUID() {
        return id;
    }
    /**
     * gets ArrayList of reviews from either an employer or student user
     * @return ArrayList of reviews 
     */
    public ArrayList<Review> getReviews() {
        return reviews;
    }

    // private boolean checkUsername(String username) {
    //     if(studentList.haveStudent(username))
    //         return false;
    //     else if(employerList.haveEmployer(username))
    //         return false;
    //     else if(adminList.haveAdmin(username))
    //         return false;

    //     if(username.length() <= 6 || username.length() >= 15)
    //         return false;
    //     return true;
    // }

    // private boolean checkPassword(String password) {
    //     if(password.length() <= 8 || password.length() >= 20)
    //         return false;
    //     return true;
    // }
    
    /**
     * gets ArrayList from InternshipList class
     * @return ArrayList of InternshipPosts
     */
    private ArrayList<InternshipPost> getPosts() {
        return internshipList.getInternships();
    }
    /**
     * gets an ArrayList of posts after passing in keyword
     * @param keyword
     * @return an ArrayList of posts with the corresponding keyword
     */
    private ArrayList<InternshipPost> getPosts(String keyword) {
        ArrayList<InternshipPost> retList = new ArrayList<InternshipPost>();
        for(int i = 0; i < internshipList.getInternships().size(); i++){
            InternshipPost currentPost = internshipList.getInternships().get(i);
            if(currentPost.getPosTitle().contains(keyword))
                retList.add(currentPost);
        }
        return retList;
    }    
    /**
     * gets an ArrayList of employers from keyword passed
     * @param keyword
     * @return an ArrayList of employers that satisfy the keyword
     */
    private ArrayList<Employer> getEmployer(String keyword) {
        ArrayList<Employer> retList = new ArrayList<Employer>();
        if(employerList.haveEmployer(keyword))
            retList.add(employerList.getEmployerByTitle(keyword));
        return retList;
    }
}
