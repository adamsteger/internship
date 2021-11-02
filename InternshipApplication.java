import java.util.ArrayList;
import java.util.UUID;
/**
 * A class for an internship application from a student
 * @author Byte Me
 */
public class InternshipApplication {
    private InternshipList internshipList;
    private StudentList studentList;
    private Student student;
    private EmployerList employerList;
    private Employer employer;
    private AdminList adminList;
    private Admin admin;
    /**
     * creates a default internship application
     */
    public InternshipApplication() {
        employerList = EmployerList.getInstance();
        internshipList = InternshipList.getInstance();
        studentList = StudentList.getInstance();
        adminList = AdminList.getInstance();
        DataLoader.getApplicants();
    }

    /**
     * calls a student to be added to the StudentList
     * @param student
     * @return boolean if successful
     */
    public boolean createStudent(Student student) {
        this.student = student;
        return studentList.addStudent(student);
    }

    /**
     * calls a employer to be added to the EmployerList
     * @param employer
     * @return boolean if successful
     */
    public boolean createEmployer(Employer employer) {
        this.employer = employer;
        return employerList.addEmployer(employer);
    }

    /**
     * calls an admin to be added to AdminList
     * @param admin
     * @return boolean if successful
     */
    public boolean createAdmin(Admin admin) {
        this.admin = admin;
        return adminList.addAdmin(admin);
    }

    /**
     * login function for students
     * @param username
     * @param password
     * @return corresponding student 
     */
    public Student studentLogin(String username, String password) {
        if (!studentList.haveStudent(username))
            return null;

        student = studentList.getStudentByUser(username);
        if (student.getPassword().equals(password)) {
            return student;
        }
        return null;
    }
    /**
     * checks lists to see if name is taken
     * @param username
     * @return boolean if taken or not
     */
    public boolean validNewUsername(String username) {
        if (!studentList.haveStudent(username) || !employerList.haveEmployer(username)) {
            return true;
        }
        return false;
    }

    /**
     * login function for employers
     * @param username
     * @param password
     * @return corresponding Employer if username and password match
     */
    public Employer employerLogin(String username, String password) {
        if (!employerList.haveEmployer(username))
            return null;

        employer = employerList.getEmployerByUser(username);
        if (employer.getPassword().equals(password)) {
            return employer;
        }
        return null;
    }

    /**
     * login function for Admin
     * @param username
     * @param password
     * @return corresponding Admin account if username and password match
     */
    public Admin adminLogin(String username, String password) {
        if (!adminList.haveAdmin(username))
            return null;

        admin = adminList.getAdminByUser(username);
        if (admin.getPassword().equals(password)) {
            return admin;
        }
        return null;
    }
    /**
     * Returns the internship posts from an employer in a search
     * @param employer The employer that is being searched for
     * @return ArrayList of InternshipPosts by the employer
     */
    public ArrayList<InternshipPost> getInternships(Employer employer) {
        ArrayList<InternshipPost> ret = new ArrayList<InternshipPost>();
        for(int i = 0; i < internshipList.getInternships().size(); i++) {
            InternshipPost currentPost = internshipList.getInternships().get(i);
            if(currentPost.getEmployerTitle().equals(employer.getTitle())) {
                ret.add(currentPost);
            }
        }
        return ret;
    }
    /**
     * @return native ArrayList of all internships
     */
    public ArrayList<InternshipPost> getInternships() {
        ArrayList<InternshipPost> ret = new ArrayList<InternshipPost>();
        for(int i = 0; i < internshipList.getInternships().size(); i++) {
            ret.add(internshipList.getInternships().get(i));
        }
        return ret;
    }
    /**
     * gets applicants to an InternshipPost
     * @param post
     * @return ArrayList of Students
     */
    public ArrayList<Student> getApplicants(InternshipPost post) {
        return post.getApplicants();
    }
    /**
     * finds internship based on employer and position
     * @param employerTitle
     * @param posTitle
     * @return boolean if position is found
     */
    public boolean findInternship(String employerTitle, String posTitle) {
        return internshipList.haveInternshipPost(employerTitle, posTitle);
    }
    /**
     * removes internship from the InternshipList
     * @param post
     */
    public void removeInternship(InternshipPost post) {
        InternshipList.getInstance().removeInternship(post);
        DataWriter.saveInternshipPosts();
    }
    /**
     * Filters internships by pay
     * @param pay
     * @return array of corresponding InternshipPosts
     */
    public ArrayList<InternshipPost> filterByPay(int pay) {
        ArrayList<InternshipPost> retList = new ArrayList<InternshipPost>();
        for (int i = 0; i < internshipList.getInternships().size(); i++) {
            InternshipPost currentPost = internshipList.getInternships().get(i);
            if (currentPost.getLowPay() >= pay && currentPost.getHighPay() <= pay)
                retList.add(currentPost);
        }
        return retList;
    }
    /**
     * Filters internships by location
     * @param location
     * @return ArrayList of corresponding InternshipPosts
     */
    public ArrayList<InternshipPost> filterByLocation(String location) {
        ArrayList<InternshipPost> retList = new ArrayList<InternshipPost>();
        for (int i = 0; i < internshipList.getInternships().size(); i++) {
            InternshipPost currentPost = internshipList.getInternships().get(i);
            if (currentPost.getLocation().contains(location))
                retList.add(currentPost);
        }
        return retList;
    }
    /**
     * Filters internships by coding language
     * @param language
     * @return corresponding ArrayList of InternshipPosts
     */
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
    /**
     * filters by whether or not an internship is remote
     * @param isRemote
     * @return corresponding ArrayList of InternshipPosts
     */
    public ArrayList<InternshipPost> filterByRemote(boolean isRemote) {
        ArrayList<InternshipPost> retList = new ArrayList<InternshipPost>();
        for (int i = 0; i < internshipList.getInternships().size(); i++) {
            InternshipPost currentPost = internshipList.getInternships().get(i);
            if (currentPost.getRemote() == isRemote)
                retList.add(currentPost);
        }
        return retList;
    }
    /**
     * filters by position at internship
     * @param keyword
     * @return ArrayList of corresponding InternshipPosts
     */
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
    /**
     * filters by employer titles
     * @param keyword
     * @return ArrayList of corresponding InternshipPosts
     */
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
    /**
     * gets favorite internships for a certain UUID
     * @param id
     * @return an ArrayList of that student's favorite posts
     */
    public ArrayList<InternshipPost> getFavoriteInternships(UUID id) {
        Student currentStudent = studentList.getStudentByID(id);
        return currentStudent.getFavoritePosts();
    }
    /**
     * adds an internship to the InternshipList
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
     * @return whether or not operation was successful
     */
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
    /**
     * add work experience to resume
     * @param work
     */
    public void addWorkExperience(WorkExperience work) {
        student.getResume().addWork(work);
        DataWriter.saveResumes();
    }
    /**
     * remove work experience from resume
     * @param work
     */
    public void removeWorkExperience(WorkExperience work) {
        student.getResume().removeWork(work);
        DataWriter.saveResumes();
    }
    /**
     * add education to resume
     * @param edu
     */
    public void addEducation(Education edu) {
        student.getResume().addEducation(edu);
        DataWriter.saveResumes();
    }
    /**
     * remove education from resume
     * @param edu
     */
    public void removeEducation(Education edu) {
        student.getResume().removeEducation(edu);
        DataWriter.saveResumes();
    }
    /**
     * add extracirricular to resume
     * @param extra
     */
    public void addExtracurricular(Extracurricular extra) {
        student.getResume().addExtracurricular(extra);
        DataWriter.saveResumes();
    }
    /**
     * remove extracirricular from resume
     * @param extra
     */
    public void removeExtracurricular(Extracurricular extra) {
        student.getResume().removeExtracurricular(extra);
        DataWriter.saveResumes();
    }
    /**
     * add skill to resume
     * @param skill
     * @param resume
     */
    public void addSkill(Skill skill, boolean resume) {
        student.getResume().addSkill(skill, resume);
        DataWriter.saveResumes();
    }
    /**
     * remove skill from resume
     */
    public void removeSkill(Skill skill) {
        student.getResume().removeSkill(skill);
        DataWriter.saveResumes();
    }
    /**
     * add course to resume
     * @param course
     * @param resume
     */
    public void addCourse(String course, boolean resume) {
        student.getResume().addCourse(course, resume);
        DataWriter.saveResumes();
    }
    /**
     * remove course from resume
     * @param course
     */
    public void removeCourse(String course) {
        student.getResume().removeCourse(course);
        DataWriter.saveResumes();
    }
    /**
     * add honor to resume
     * @param honor
     */
    public void addHonor(Honor honor) {
        student.getResume().addHonor(honor);
        DataWriter.saveResumes();
    }
    /**
     * remove honor from resume
     * @param honor
     */
    public void removeHonor(Honor honor) {
        student.getResume().removeHonor(honor);
        DataWriter.saveResumes();
    }
    /**
     * add employer review to a student
     * @param student
     * @param writer
     * @param rating
     * @param comment
     */
    public void addStudentReview(Student student, String writer, int rating, String comment) {
        student.getReviews().add(new Review(writer, rating, comment));
        DataWriter.saveStudents();
    }
    /**
     * add student review to an employer
     * @param employer
     * @param writer
     * @param rating
     * @param comment
     */
    public void addEmployerReview(Employer employer, String writer, int rating, String comment) {
        employer.getReviews().add(new Review(writer, rating, comment));
        DataWriter.saveEmployers();
    }

    /**
     * Prints the student's resume to a text file
     */
    public void printResumeToFile() {
        student.printResumeToFile();
    }
}