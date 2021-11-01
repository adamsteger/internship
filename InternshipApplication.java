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
        employerList = EmployerList.getInstance();
        adminList = AdminList.getInstance();
        DataLoader.getApplicants();
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
        this.admin = admin;
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

    public boolean validNewUsername(String username) {
        if (!studentList.haveStudent(username) || !employerList.haveEmployer(username)) {
            return true;
        }
        return false;
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

    public ArrayList<InternshipPost> getInternships(Employer employer) {
        ArrayList<InternshipPost> ret = new ArrayList<InternshipPost>();
        for(int i = 0; i < internshipList.getInternships().size(); i++) {
            InternshipPost currentPost = internshipList.getInternships().get(i);
            if(currentPost.getEmployerTitle().equals(employer.username)) {
                ret.add(currentPost);
            }
        }
        return ret;
    }

    public ArrayList<InternshipPost> getInternships() {
        ArrayList<InternshipPost> ret = new ArrayList<InternshipPost>();
        for(int i = 0; i < internshipList.getInternships().size(); i++) {
            ret.add(internshipList.getInternships().get(i));
        }
        return ret;
    }

    public ArrayList<Student> getApplicants(InternshipPost post) {
        return post.getApplicants();
    }

    public boolean findInternship(String employerTitle, String posTitle) {
        return internshipList.haveInternshipPost(employerTitle, posTitle);
    }

    public void removeInternship(InternshipPost post) {
        InternshipList.getInstance().removeInternship(post);
        DataWriter.saveInternshipPosts();
    }

    public ArrayList<InternshipPost> filterByPay(int pay) {
        ArrayList<InternshipPost> retList = new ArrayList<InternshipPost>();
        for (int i = 0; i < internshipList.getInternships().size(); i++) {
            InternshipPost currentPost = internshipList.getInternships().get(i);
            if (currentPost.getLowPay() >= pay && currentPost.getHighPay() <= pay)
                retList.add(currentPost);
        }
        return retList;
    }

    public ArrayList<InternshipPost> filterByLocation(String location) {
        ArrayList<InternshipPost> retList = new ArrayList<InternshipPost>();
        for (int i = 0; i < internshipList.getInternships().size(); i++) {
            InternshipPost currentPost = internshipList.getInternships().get(i);
            if (currentPost.getLocation().contains(location))
                retList.add(currentPost);
        }
        return retList;
    }

    public ArrayList<InternshipPost> filterByLanguage(Skill language) {
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

    public ArrayList<InternshipPost> filterByRemote(boolean isRemote) {
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

    public void addWorkExperience(WorkExperience work) {
        student.getResume().addWork(work);
        DataWriter.saveResumes();
    }

    public void removeWorkExperience(WorkExperience work) {
        student.getResume().removeWork(work);
        DataWriter.saveResumes();
    }

    public void addEducation(Education edu) {
        student.getResume().addEducation(edu);
        DataWriter.saveResumes();
    }

    public void removeEducation(Education edu) {
        student.getResume().removeEducation(edu);
        DataWriter.saveResumes();
    }

    public void addExtracurricular(Extracurricular extra) {
        student.getResume().addExtracurricular(extra);
        DataWriter.saveResumes();
    }

    public void removeExtracurricular(Extracurricular extra) {
        student.getResume().removeExtracurricular(extra);
        DataWriter.saveResumes();
    }

    public void addSkill(Skill skill, boolean resume) {
        student.getResume().addSkill(skill, resume);
        DataWriter.saveResumes();
    }

    public void removeSkill(Skill skill) {
        student.getResume().removeSkill(skill);
        DataWriter.saveResumes();
    }

    public void addCourse(String course, boolean resume) {
        student.getResume().addCourse(course, resume);
        DataWriter.saveResumes();
    }

    public void removeCourse(String course) {
        student.getResume().removeCourse(course);
        DataWriter.saveResumes();
    }

    public void addHonor(Honor honor) {
        student.getResume().addHonor(honor);
        DataWriter.saveResumes();
    }

    public void removeHonor(Honor honor) {
        student.getResume().removeHonor(honor);
        DataWriter.saveResumes();
    }

    public void addStudentReview(Student student, String writer, int rating, String comment) {
        student.getReviews().add(new Review(writer, rating, comment));
        DataWriter.saveStudents();
    }

    public void addEmployerReview(Employer employer, String writer, int rating, String comment) {
        employer.getReviews().add(new Review(writer, rating, comment));
        DataWriter.saveEmployers();
    }
}