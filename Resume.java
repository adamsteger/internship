import java.util.ArrayList;
import java.util.Hashtable;
import java.util.UUID;

public class Resume {
    private Student student;
    private ArrayList<Education> educations;
    private ArrayList<Skill> skills;
    private Hashtable<String, Boolean> courses;
    private ArrayList<WorkExperience> work;
    private ArrayList<Extracurricular> extracurriculars;
    private UUID id;
    
    public Resume(ArrayList<Education> educations, ArrayList<Skill> skills, Hashtable<String, Boolean> courses, 
      ArrayList<WorkExperience> work, ArrayList<Extracurricular> extracurriculars) {
        this.educations = educations;
        this.skills = skills;
        this.courses = courses;
        this.work = work;
        this.extracurriculars = extracurriculars;
        id = UUID.randomUUID();
    }

    public ArrayList<Education> getEducations() {
        return this.educations;
    }

    public ArrayList<Skill> getSkills() {
        return this.skills;
    }

    public Hashtable<String, Boolean> getCourses() {
        return this.courses;
    }

    public ArrayList<WorkExperience> getWork() {
        return this.work;
    }

    public ArrayList<Extracurricular> getExtracurriculars() {
        return this.extracurriculars;
    }

    public void addEducation(Education edu) {
        educations.add(edu);
    }

    public void removeEducation(Education edu) {
        educations.remove(edu);
    }

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    public void removeSkill(Skill skill) {
        skills.remove(skill);
    }

    public void addCourse(String course) {
        courses.put(course, true);
    }

    public void removeCourse(String course) {
        courses.remove(course);
    }

    public void addWork(WorkExperience workExperience) {
        work.add(workExperience);
    }

    public void removeWork(WorkExperience workExperience) {
        work.remove(workExperience);
    }

    public void addExtracurricular(Extracurricular extracurricular) {
        extracurriculars.add(extracurricular);
    }

    public void removeExtracurricular(Extracurricular extracurricular) {
        extracurriculars.remove(extracurricular);
    }

    public void apply(InternshipPost post) {
        
    }

    public void addCompanyReview(Employer employer, int rating, String comment) {

    }

    public void sortReverseChronEdu(Hashtable<Education, Boolean> education) {
        
    }

    public void sortReverseChronWork(Hashtable<WorkExperience, Boolean> work) {

    }
    public String toString() {
        return "";
    }
}
