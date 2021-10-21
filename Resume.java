import java.util.Hashtable;

public class Resume {
    private Student student;
    private Hashtable<Education, Boolean> educations;
    private Hashtable<Skill, Boolean> skills;
    private Hashtable<String, Boolean> courses;
    private Hashtable<WorkExperience, Boolean> work;
    private Hashtable<Extracurricular, Boolean> extracurriculars;
    
    public Resume(Hashtable<Education, Boolean> educations, Hashtable<Skill, Boolean> skills, Hashtable <String, Boolean> courses, 
      Hashtable<WorkExperience,Boolean> work, Hashtable<Extracurricular, Boolean> extracurriculars) {
        this.educations = educations;
        this.skills = skills;
        this.courses = courses;
        this.work = work;
        this.extracurriculars = extracurriculars;
    }

    public Student getStudent() {
        return student;
    }

    public Hashtable<Education, Boolean> getEducations() {
        return this.educations;
    }

    public Hashtable<Skill, Boolean> getSkills() {
        return this.skills;
    }

    public Hashtable<String, Boolean> getCourses() {
        return this.courses;
    }

    public Hashtable<WorkExperience, Boolean> getWork() {
        return this.work;
    }

    public Hashtable<Extracurricular, Boolean> getExtracurriculars() {
        return this.extracurriculars;
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
    public String toString() {
        return "";
    }
}
