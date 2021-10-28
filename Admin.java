import java.util.ArrayList;
import java.util.UUID;

public class Admin extends User {
    private static UUID id;
    
    public Admin(String username, String password) {
        super(username, password);
        id = super.getUUID();
    }

    public Admin(UUID id, String username, String password) {
        super(username, password);
        this.id = id;
    }

    public UUID getID() {
        return id;
    }
    
    public void deletePost(InternshipPost post) {
        InternshipList internshipList = InternshipList.getInstance();
        for (InternshipPost internship : internshipList.getInternships()) {
            if (internship.equals(post)) {
                internshipList.removeInternship(internship);
            }
        }
        internshipList.save();
    }

    public void addPost(String employerTitle, String posTitle, String description, String location, ArrayList<Skill> skillReq, String startDate, String endDate, boolean isRemote, boolean isOpen, int lowPay, int highPay) {
       InternshipList internshipList = InternshipList.getInstance();
       internshipList.addInternship(employerTitle, posTitle, description, location, skillReq, startDate, endDate, isRemote, isOpen, lowPay, highPay);
       internshipList.save();
    }

    public void deleteStudentReview(Student student, Review review) {
        student.getReviews().remove(review);
        DataWriter.saveStudents();
    }

    public void deleteEmployerReview(Employer employer, Review review) {
        employer.getReviews().remove(review);
    }

    public String toString() {
        return "\nUsername: " + username + "\nPassword: " + password;
    }

}
