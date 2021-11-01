import java.util.ArrayList;
import java.util.UUID;
/**
 *  Represents a List of InternshipPosts
 *  @author Byte Me 
 */
public class InternshipList {
    private static InternshipList internshipList;
    private ArrayList<InternshipPost> internships;
    /**
     * Gets InternshipPosts from the DataLoader and sets the ArrayList to it 
     */
    private InternshipList() {
        internships = DataLoader.getInternshipPosts();
    }
    /**
     * Returns instance of class
     * @return InternshipList
     */
    public static InternshipList getInstance() {
        if(internshipList == null)
            internshipList = new InternshipList();
        return internshipList;
    }
    /**
     * Searches the ArrayList of InternshipPosts for a specific post based on keywords
     * @param employerTitle
     * @param posTitle
     * @return boolean if successful
     */
    public boolean haveInternshipPost(String employerTitle, String posTitle) {
        for(InternshipPost post : internships) {
            if(post.getEmployerTitle().equals(employerTitle) && post.getPosTitle().equals(posTitle)) {
                return true;
            }
        }
        return false;
    }
    /**
     * @return class ArrayList of InternshipPosts
     */
    public ArrayList<InternshipPost> getInternships() {
        return internships;
    }
    /**
     * Searches ArrayList for a post by UUID
     * @param UUID of post
     * @returns InternshipPost of specified UUID
     */
    public InternshipPost getPostByID(UUID id) {
        for(InternshipPost post : internships) {
            if(post.getUUID().equals(id)) {
                return post;
            }
        }
        return null;
    }
    /**
     * Adds a passed internship to the ArrayList
     * @param InternshipPost
     * @return boolean if successful
     */
    public boolean addInternship(InternshipPost post) { 
        if(haveInternshipPost(post.getEmployerTitle(), post.getPosTitle())) 
            return false;
        
        internships.add(post);
        return true;
    }
    /**
     * creates and adds a new internship to List
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
     * @return boolean if successful
     */
    public boolean addInternship(String employerTitle, String posTitle, String description, String location, ArrayList<Skill> skillReq, String startDate, String endDate, boolean isRemote, boolean isOpen, int lowPay, int highPay) {
        if(haveInternshipPost(employerTitle, posTitle)) 
            return false;
        
        internships.add(new InternshipPost(employerTitle, posTitle, description, location, skillReq, startDate, endDate, isRemote, isOpen, lowPay, highPay));
        return true;
    }

    /**
     * Removes an internship from the ArrayList
     * @param InternshipPost
     * @return a boolean if successful
     */
    public boolean removeInternship(InternshipPost internship) {
        for(InternshipPost post : internships) {
            if(internship.equals(post)) {
                internships.remove(post);
                return true;
            }
        }
        return false;
    }
    /**
     * Saves internship posts with DataWriter
     */
    public void save() {
        DataWriter.saveInternshipPosts();
        // DataWriter.saveApplications();
    }
}