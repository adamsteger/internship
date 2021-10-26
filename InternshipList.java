import java.util.ArrayList;
import java.util.UUID;

public class InternshipList {
    private static InternshipList internshipList;
    private ArrayList<InternshipPost> internships;

    private InternshipList() {
        internships = DataLoader.getInternshipPosts();
    }

    public static InternshipList getInstance() {
        if(internshipList == null)
            internshipList = new InternshipList();
        return internshipList;
    }

    public boolean haveInternshipPost(String employerTitle, String posTitle) {
        for(InternshipPost post : internships) {
            if(post.getEmployerTitle().equals(employerTitle) && post.getPosTitle().equals(posTitle)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<InternshipPost> getInternships() {
        return internships;
    }

    public InternshipPost getPostByID(UUID id) {
        for(InternshipPost post : internships) {
            if(post.getUUID().equals(id)) {
                return post;
            }
        }
        return null;
    }

    public boolean addInternship(String employerTitle, String posTitle, String description, String location, ArrayList<Skill> skillReq, String startDate, String endDate, boolean isRemote, boolean isOpen, int lowPay, int highPay) {
        if(haveInternshipPost(employerTitle, posTitle)) 
            return false;
        
        internships.add(new InternshipPost(employerTitle, posTitle, description, location, skillReq, startDate, endDate, isRemote, isOpen, lowPay, highPay));
        return true;
    }


    public boolean removeInternship(InternshipPost internship) {
        for(InternshipPost post : internships) {
            if(internship.equals(post)) {
                internships.remove(post);
                return true;
            }
        }
        return false;
    }

    public void save() {
        DataWriter.saveInternshipPosts();
    }
}