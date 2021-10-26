import java.util.ArrayList;

public class InternshipApplication{
    private InternshipList internshipList;
    private UserList userList;
    private User user;
    public InternshipApplication(){

    }
    public ArrayList<InternshipPost> findInternships(){
        return internshipList.getInternships();
    }
    public ArrayList<InternshipPost> findInternships(String keyword){
        return new ArrayList<InternshipPost>();
    }
    public User createAccount(String username, String password, String accountType){
        return user;
    }
    public User login(String username, String password){
        return user;
    }
    public ArrayList<InternshipPost> getFavoriteInternships(){
        return new ArrayList<InternshipPost>();
    }
    public ArrayList<InternshipPost> getMyInternships(){
        return new ArrayList<InternshipPost>();
    }
    public boolean addInternship(Employer employer, String companyName, String posTitle, String description, String location, ArrayList<String> skillReq, String startDate, String endDate, boolean isRemote, boolean isOpen, String language, int lowPay, int highPay, ArrayList<Student> applicants){
        return true;
    }
    public void reviewUser(User user, String comment){

    }
}