import java.util.ArrayList;

public class InternshipList {
    private InternshipList internshipList;
    private ArrayList<InternshipPost> internships;

    private InternshipList() {

    }

    public InternshipList getInstance() {
        return new InternshipList();
    }

    public ArrayList<InternshipPost> getInternships() {
        return new ArrayList<InternshipPost>();
    }

    public void save() {
        
    }
}