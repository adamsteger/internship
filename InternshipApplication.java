import java.util.ArrayList;
import java.util.UUID;

public class InternshipApplication {
    private InternshipList internshipList;
    private StudentList studentList;
    private Student student;
    private EmployerList employerList;
    private Employer employer;
    private AdminList adminList;
    private Admin admin;

    public InternshipApplication() {
        internshipList = InternshipList.getInstance();
        studentList = StudentList.getInstance();
    }

    // creates a new student account
    public boolean createStudent(Student student) {
        this.student = student;
        return studentList.addStudent(student);
    }

    // creates a new employer account
    public boolean createEmployer(Employer employer) {
        this.employer = employer;
        return employerList.addEmployer(employer);
    }

    // creates a new admin account
    public boolean createAdmin(Admin admin) {
        return adminList.addAdmin(admin);
    }

    // student login
    public Student studentLogin(String username, String password) {
        if (!studentList.haveStudent(username))
            return null;

        student = studentList.getStudentByUser(username);
        if (student.getPassword().equals(password)) {
            return student;
        }
        return null;
    }

    // employer login
    public Employer employerLogin(String username, String password) {
        if (!employerList.haveEmployer(username))
            return null;

        employer = employerList.getEmployerByUser(username);
        if (employer.getPassword().equals(password)) {
            return employer;
        }
        return null;
    }

    // admin login
    public Admin adminLogin(String username, String password) {
        if (!adminList.haveAdmin(username))
            return null;

        admin = adminList.getAdminByUser(username);
        if (admin.getPassword().equals(password)) {
            return admin;
        }
        return null;
    }

    public boolean findInternship(String employerTitle, String posTitle) {
        return internshipList.haveInternshipPost(employerTitle, posTitle);
    }

    private ArrayList<InternshipPost> filterByPay(int lowPay, int highPay) {
        ArrayList<InternshipPost> retList = new ArrayList<InternshipPost>();
        for (int i = 0; i < internshipList.getInternships().size(); i++) {
            InternshipPost currentPost = internshipList.getInternships().get(i);
            if (currentPost.getLowPay() >= lowPay && currentPost.getHighPay() <= highPay)
                retList.add(currentPost);
        }
        return retList;
    }

    private ArrayList<InternshipPost> filterByLocation(String location) {
        ArrayList<InternshipPost> retList = new ArrayList<InternshipPost>();
        for (int i = 0; i < internshipList.getInternships().size(); i++) {
            InternshipPost currentPost = internshipList.getInternships().get(i);
            if (currentPost.getLocation().contains(location))
                retList.add(currentPost);
        }
        return retList;
    }

    private ArrayList<InternshipPost> filterByLanguage(Skill language) {
        ArrayList<InternshipPost> retList = new ArrayList<InternshipPost>();
        for (int i = 0; i < internshipList.getInternships().size(); i++) {
            InternshipPost currentPost = internshipList.getInternships().get(i);
            for (int j = 0; j < currentPost.getSkillReq().size(); i++) {
                if (currentPost.getSkillReq().get(i).equals(language))
                    retList.add(currentPost);
            }
        }
        return retList;
    }

    private ArrayList<InternshipPost> filterByRemote(boolean isRemote) {
        ArrayList<InternshipPost> retList = new ArrayList<InternshipPost>();
        for (int i = 0; i < internshipList.getInternships().size(); i++) {
            InternshipPost currentPost = internshipList.getInternships().get(i);
            if (currentPost.getRemote() == isRemote)
                retList.add(currentPost);
        }
        return retList;
    }

    public ArrayList<InternshipPost> filterByPosTitle(String keyword) {
        ArrayList<InternshipPost> retList = new ArrayList<InternshipPost>();
        for (int i = 0; i < internshipList.getInternships().size(); i++) {
            InternshipPost currentPost = internshipList.getInternships().get(i);
            if (currentPost.getPosTitle().contains(keyword)) {
                retList.add(currentPost);
            }
        }
        return retList;
    }

    public ArrayList<InternshipPost> filterByEmployerTitle(String keyword) {
        ArrayList<InternshipPost> retList = new ArrayList<InternshipPost>();
        for (int i = 0; i < internshipList.getInternships().size(); i++) {
            InternshipPost currentPost = internshipList.getInternships().get(i);
            if (currentPost.getEmployerTitle().contains(keyword)) {
                retList.add(currentPost);
            }
        }
        return retList;
    }

    public ArrayList<InternshipPost> getFavoriteInternships(UUID id) {
        Student currentStudent = studentList.getStudentByID(id);
        return currentStudent.getFavoritePosts();
    }

    public ArrayList<InternshipPost> getMyInternships(UUID id) {
        Student currentStudent = studentList.getStudentByID(id);
        return currentStudent.getFavoritePosts();
    }

    public boolean addInternship(String employerTitle, String posTitle, String description, String location,
            ArrayList<Skill> skillReq, String startDate, String endDate, boolean isRemote, boolean isOpen, int lowPay,
            int highPay) {
        if (internshipList.haveInternshipPost(employerTitle, posTitle)) {
            return false;
        }
        internshipList.addInternship(employerTitle, posTitle, description, location, skillReq, startDate, endDate,
                isRemote, isOpen, lowPay, highPay);
        internshipList.save();
        return true;
    }

    // TODO Add Removes for Resume fields

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

    public void addHonor(Honor honor) {
        student.getResume().addHonor(honor);
    }

    public void addStudentReview(Student student, String writer, int rating, String comment) {
        student.getReviews().add(new Review(writer, rating, comment));
    }

    public void addEmployerReview(Employer employer, String writer, int rating, String comment) {
        employer.getReviews().add(new Review(writer, rating, comment));
    }
}