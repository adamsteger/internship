import java.util.ArrayList;
import java.util.Hashtable;
import java.util.UUID;

public class Student extends User {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private int gradYear;
    private Hashtable<Education, Boolean> educations;
    private Hashtable<Skill, Boolean> skills;
    private Hashtable<String, Boolean> courses;
    private Hashtable<WorkExperience, Boolean> work;
    private Hashtable<Extracurricular, Boolean> extracurriculars;
    private double gpa;
    private boolean showGPA;
    private double rating;
    private ArrayList<Review> reviews;
    private ArrayList<InternshipPost> favoritePosts;
    private Resume resume;
    private UUID id;

    public Student(String username, String password) {
        super(username, password, id);
    }

    public Student(UUID id, String firstName, String lastName, String username, String password, int gradYear,
                    String email, String address, String phone, double gpa, boolean showGPA, double rating) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.gradYear = gradYear;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.gpa = gpa;
        this.showGPA = showGPA;
        this.rating = rating;
    }

    public String toString() {
        return "Name: " + firstName + " " + lastName + "\nUsername: " + username + "\nPassword: " 
                    + password + "\nGrad Year: " + gradYear + "\nEmail: " + email + "\nPhone: "
                    + phone + "\nGPA: " + gpa + "\nRating: " + rating;
    }

    public void addEducation(Education edu) {

    }

    public void removeEducation(Education edu) {

    }

    public void addSkill(Skill skill) {

    }

    public void removeSkill(Skill skill) {

    }

    public void addCourse(String course) {

    }

    public void removeCourse(String course) {

    }

    public void addWork(WorkExperience work) {

    }

    public void removeWork(WorkExperience work) {

    }

    public void addExtracurricular(Extracurricular extracurricular) {

    }

    public void removeExtracurricular(Extracurricular extracurricular) {

    }

    public void apply(InternshipPost post) {

    }

    public void addCompanyReview(Employer employer, int rating, String comment) {

    }

    public void sortReverseChronEdu(Hashtable<Education, Boolean> education) {

    }

    public void sortReverseChronWork(Hashtable<WorkExperience, Boolean> work) {

    }
}
