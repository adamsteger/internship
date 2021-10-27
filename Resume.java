import java.util.Hashtable;
import java.util.UUID;

public class Resume {
    private Hashtable<Education, Boolean> educations;
    private Hashtable<Skill, Boolean> skills;
    private Hashtable<String, Boolean> courses;
    private Hashtable<WorkExperience, Boolean> work;
    private Hashtable<Extracurricular, Boolean> extracurriculars;
    private UUID id;

    public Resume(Hashtable<Education, Boolean> educations, Hashtable<Skill, Boolean> skills, Hashtable <String, Boolean> courses, 
      Hashtable<WorkExperience,Boolean> work, Hashtable<Extracurricular, Boolean> extracurriculars) {
        this.educations = educations;
        this.skills = skills;
        this.courses = courses;
        this.work = work;
        this.extracurriculars = extracurriculars;
        id = UUID.randomUUID();
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
        educations.put(edu, true);
    }

    public void removeEducation(Education edu) {
        educations.remove(edu);
    }

    public void addSkill(Skill skill) {
        skills.put(skill, true);
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
        work.put(workExperience, true);
    }

    public void removeWork(WorkExperience workExperience) {
        work.remove(workExperience);
    }

    public void addExtracurricular(Extracurricular extracurricular) {
        extracurriculars.put(extracurricular, true);
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
