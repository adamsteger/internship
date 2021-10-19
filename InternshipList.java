import java.util.ArrayList;

public class InternshipList {
    private static InternshipList internshipList;
    private ArrayList<InternshipPost> internships;

    private InternshipList() {
        this.internships = DataLoader.getInternships();
    }

    public static InternshipList getInstance() {
        if(internshipList == null)
            internshipList = new InternshipList();
        return internshipList;
    }

    public ArrayList<InternshipPost> getInternships() {
        return internships;
    }

    public void save() {
        
    }
}