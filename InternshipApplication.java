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
    public boolean createStudent(Student student) {
        this.student = student;
        return studentList.addStudent(student);
    }

    //creates a new employer account
    public boolean createEmployer(Employer employer) {
        this.employer = employer;
        return employerList.addEmployer(employer);
    }

    //creates a new admin account
    public boolean createAdmin(Admin admin) {
        return adminList.addAdmin(admin);
    }

    public Student studentLogin(String username) {
        if(!studentList.haveStudent(username))
            return null;
        
        student = studentList.getStudentByUser(username);
        return student;
    }

    public Employer employerLogin(String username) {
        if(!employerList.haveEmployer(username))
            return null;
        
        employer = employerList.getEmployerByUser(username);
        return employer;
    }

    public Admin adminLogin(String username) {
        if(!adminList.haveAdmin(username))
            return null;
        
        admin = adminList.getAdminByUser(username);
        return admin;
    }

    public boolean findInternship(String employerTitle, String posTitle){
        return internshipList.haveInternshipPost(employerTitle, posTitle);
    }

    
    private ArrayList<InternshipPost> filterByPay(int lowPay, int highPay) {
        ArrayList<InternshipPost> retList = new ArrayList<InternshipPost>();
        for(int i = 0; i < internshipList.getInternships().size(); i++){
            InternshipPost currentPost = internshipList.getInternships().get(i);
            if(currentPost.getLowPay() >= lowPay && currentPost.getHighPay() <= highPay)
                retList.add(currentPost);
        }
        return retList;
    }

    private ArrayList<InternshipPost> filterByLocation(String location) {
        ArrayList<InternshipPost> retList = new ArrayList<InternshipPost>();
        for(int i = 0; i < internshipList.getInternships().size(); i++){
            InternshipPost currentPost = internshipList.getInternships().get(i);
            if(currentPost.getLocation().contains(location))
                retList.add(currentPost);
        }
        return retList;
    }

    private ArrayList<InternshipPost> filterByLanguage(Skill language) {
        ArrayList<InternshipPost> retList = new ArrayList<InternshipPost>();
        for(int i = 0; i < internshipList.getInternships().size(); i++){
            InternshipPost currentPost = internshipList.getInternships().get(i);
            for(int j = 0; j < currentPost.getSkillReq().size(); i++){
                if(currentPost.getSkillReq().get(i).equals(language))
                    retList.add(currentPost);
            }
        }
        return retList;
    }

    private ArrayList<InternshipPost> filterByRemote(boolean isRemote) {
        ArrayList<InternshipPost> retList = new ArrayList<InternshipPost>();
        for(int i = 0; i < internshipList.getInternships().size(); i++){
            InternshipPost currentPost = internshipList.getInternships().get(i);
            if(currentPost.getRemote() == isRemote)
                retList.add(currentPost);
        }
        return retList;
    }

    public ArrayList<InternshipPost> filterByPosTitle(String keyword){
        ArrayList<InternshipPost> retList = new ArrayList<InternshipPost>();
        for(int i = 0; i < internshipList.getInternships().size(); i++){
            InternshipPost currentPost = internshipList.getInternships().get(i);
            if(currentPost.getPosTitle().contains(keyword)){
                retList.add(currentPost);
            }
        }
        return retList;
    }

    public ArrayList<InternshipPost> filterByEmployerTitle(String keyword){
        ArrayList<InternshipPost> retList = new ArrayList<InternshipPost>();
        for(int i = 0; i < internshipList.getInternships().size(); i++){
            InternshipPost currentPost = internshipList.getInternships().get(i);
            if(currentPost.getEmployerTitle().contains(keyword)){
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
    
    public void studentReview(String comment){

    }

    public void addWorkExperience(WorkExperience work) {
        student.getResume().addWork(work);
        DataWriter.saveStudents();
    } 

    public void addEducation(Education edu) {
        student.getResume().addEducation(edu);
        DataWriter.saveStudents();
    }

    public void addExtracurricular(Extracurricular extra) {
        student.getResume().addExtracurricular(extra);
        DataWriter.saveStudents();
    }

    public void addSkill(Skill skill, boolean resume) {
        student.getResume().addSkill(skill, resume);
        DataWriter.saveStudents();
    }

    public void addCourse(String course, boolean resume) {
        student.getResume().addCourse(course, resume);
    }
}