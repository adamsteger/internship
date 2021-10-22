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

    public ArrayList<InternshipPost> getInternships() {
        return internships;
    }

    public ArrayList<InternshipPost> addInternship(InternshipPost internship) {
        internships.add(internship);
        return internships;
    }

    public InternshipPost getPostByID(UUID id) {
        InternshipPost ret = new InternshipPost();
        for (InternshipPost post : internships) {
            if (post.getUUID().equals(id)) {
                ret = post;
            }
        }
        return ret;
    }

    public ArrayList<InternshipPost> removeInternship(InternshipPost internship) {
        internships.remove(internship);
        return internships;
    }

    public void save() {
        
    }

    public void remove(InternshipPost post) {

    }
}