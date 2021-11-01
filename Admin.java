import java.util.ArrayList;
import java.util.UUID;
/**
 *  Represents an instance of the Admin user
 *  @author Byte Me 
 */
public class Admin extends User {
    private static UUID id;
    /**
    *  Creates a new Admin 
    *  @param username 
    *  @param password
    */
    public Admin(String username, String password) {
        super(username, password);
        id = super.getUUID();
    }
    /**
    *  Creates a new Admin from existing UUID
    *  @param username 
    *  @param password
    *  @param id
    */
    public Admin(UUID id, String username, String password) {
        super(username, password);
        this.id = id;
    }
    /**
     *  @return UUID of Admin
     */
    public UUID getID() {
        return id;
    }
    /**
     * Deletes a post as Admin 
     * @param post
     */
    public void deletePost(InternshipPost post) {
        InternshipList internshipList = InternshipList.getInstance();
        for (InternshipPost internship : internshipList.getInternships()) {
            if (internship.equals(post)) {
                internshipList.removeInternship(internship);
            }
        }
        internshipList.save();
    }
    /**
     * Adds a post to the system as an Admin
     * @param employerTitle
     * @param posTitle
     * @param description
     * @param location
     * @param skillReq
     * @param startDate
     * @param endDate
     * @param isRemote
     * @param isOpen
     * @param lowPay
     * @param highPay
     */
    public void addPost(String employerTitle, String posTitle, String description, String location, ArrayList<Skill> skillReq, String startDate, String endDate, boolean isRemote, boolean isOpen, int lowPay, int highPay) {
       InternshipList internshipList = InternshipList.getInstance();
       internshipList.addInternship(employerTitle, posTitle, description, location, skillReq, startDate, endDate, isRemote, isOpen, lowPay, highPay);
       internshipList.save();
    }
    /**
     * Deletes a review created by an Employer
     * @param student
     * @param review
     */
    public void deleteStudentReview(Student student, Review review) {
        student.getReviews().remove(review);
        DataWriter.saveStudents();
    }
    /**
     * Deletes a review created by a Student
     * @param employer
     * @param review
     */
    public void deleteEmployerReview(Employer employer, Review review) {
        employer.getReviews().remove(review);
    }
    /**
     * toStrings the username and password of Admin
     */
    public String toString() {
        return "\nUsername: " + username + "\nPassword: " + password;
    }

}
