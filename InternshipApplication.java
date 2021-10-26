import java.util.ArrayList;

public class InternshipApplication{
    private InternshipList internshipList;
    private StudentList studentList;
    private Student student;
    private EmployerList employerList;
    private Employer employer;
    private AdminList adminList;
    private Admin admin;

    public InternshipApplication(){
        internshipList = InternshipList.getInstance();
        studentList = StudentList.getInstance();
    }

    //creates a new student account
    public boolean createStudentAccount(String username, String password) {
        return studentList.addStudent(username, password);
    }

    //creates a new employer account
    public boolean createEmployerAccount(String username, String password) {
        return employerList.addEmployer(username, password);
    }

    //creates a new admin account
    public boolean createAdminAccount(String username, String password) {
        return adminList.addAdmin(username, password);
    }

    public boolean studentLogin(String username) {
        if(!studentList.haveStudent(username))
            return false;
        
        student = studentList.getStudentByUser(username);
        return true;
    }

    public boolean employerLogin(String username) {
        if(!employerList.haveEmployer(username))
            return false;
        
        employer = employerList.getEmployerByUser(username);
        return true;
    }

    public boolean adminLogin(String username) {
        if(!adminList.haveAdmin(username))
            return false;
        
        admin = adminList.getAdminByUser(username);
        return true;
    }

    public boolean findInternship(String employerTitle, String posTitle){
        return internshipList.haveInternshipPost(employerTitle, posTitle);
    }

    public ArrayList<InternshipPost> findInternships(String keyword){
        ArrayList<InternshipPost> retList = new ArrayList<InternshipPost>();
        for(int i = 0; i < internshipList.getInternships().size(); i++){
            InternshipPost currentPost = internshipList.getInternships().get(i);
            if(currentPost.getEmployerTitle() == keyword){
                retList.add(currentPost);
            }
        }
        return retList;
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
    
    //public void studentReview(, String comment){

    //}/
}