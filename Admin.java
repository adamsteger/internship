import java.util.ArrayList;
import java.util.UUID;

public class Admin extends User {
    private static UUID id;
    
    public Admin(String username, String password) {
        super(username, password);
        id = super.getUUID();
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

    public void deleteStudentReview(StudentReview review) {
        
    }

    public void addStudentReview(StudentReview review) {

    }

    public void deleteEmployerReview(EmployerReview review) {

    }

    public void addEmployerReview(EmployerReview review) {
        
    }
}
