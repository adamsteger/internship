import java.util.ArrayList;
import java.util.UUID;
/**
 *  A singleton for the list of internship posts
 *  @author Byte Me 
 */
public class InternshipList {
    private static InternshipList internshipList;
    private ArrayList<InternshipPost> internships;

    /**
     * Creates an instance of internship list by loading the JSON file
     */
    private InternshipList() {
        internships = DataLoader.getInternshipPosts();
    }

    /**
     * Retrieves an instance of internship list and ensures only 1 exists at a time
     * @return Returns an instance of internship list
     */
    public static InternshipList getInstance() {
        if(internshipList == null)
            internshipList = new InternshipList();
        return internshipList;
    }

    /**
     * Searches the ArrayList of InternshipPosts for a specific post based on keywords
     * @param employerTitle A string of the employer title that is being searched for
     * @param posTitle A string of the position title that is being searched for
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
     * Accesses the arraylist of internship posts
     * @return Returns the ArrayList of InternshipPosts
     */
    public ArrayList<InternshipPost> getInternships() {
        return internships;
    }

    /**
     * Searches ArrayList for a post by UUID
     * @param id The UUID that is being searched for
     * @returns Returns the InternshipPost of specified UUID
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
     * @param InternshipPost The internship post that is being added
     * @return Returns a boolean that is true if the post is successfully added
     */
    public boolean addInternship(InternshipPost post) { 
        if(haveInternshipPost(post.getEmployerTitle(), post.getPosTitle())) 
            return false;
        
        internships.add(post);
        return true;
    }
    
    /**
     * creates and adds a new internship to List
     * @param employerTitle A string of the employer title that made the post
     * @param posTitle A string of the position title of the post
     * @param description A string of a description of the position
     * @param location A string of the location where the position is
     * @param startDate A string of when the position begins
     * @param endDate A string of when the position ends
     * @param isRemote A boolean that is true if the position is virtual
     * @param isOpen A boolean that is true if the employer is still taking applications
     * @param lowPay An integer of the lowest a student could be paid for the position
     * @param highPay An integer of the highest a student could be paid for the position
     * @param skills An arraylist of type skill of all the skills required for the position
     * @return Returns a boolean that is true if the post is successfully added
     */
    public boolean addInternship(String employerTitle, String posTitle, String description, String location, ArrayList<Skill> skillReq, String startDate, String endDate, boolean isRemote, boolean isOpen, int lowPay, int highPay) {
        if(haveInternshipPost(employerTitle, posTitle)) 
            return false;
        
        internships.add(new InternshipPost(employerTitle, posTitle, description, location, skillReq, startDate, endDate, isRemote, isOpen, lowPay, highPay));
        return true;
    }

    /**
     * Removes an internship from the ArrayList
     * @param InternshipPost The internship post that is being removed
     * @return Returns a boolean that is true if the post is successfully removed
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