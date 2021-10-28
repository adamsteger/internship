import java.util.ArrayList;
import java.util.Hashtable;
import java.util.UUID;

public class Resume {
    private ArrayList<Education> educations;
    private Hashtable<Skill, Boolean> skills;
    private Hashtable<String, Boolean> courses;
    private ArrayList<WorkExperience> work;
    private ArrayList<Extracurricular> extracurriculars;
    private ArrayList<Honor> honors;
    private UUID id;
    
    public Resume(ArrayList<Education> educations, Hashtable<Skill, Boolean> skills, Hashtable<String, Boolean> courses, 
      ArrayList<WorkExperience> work, ArrayList<Extracurricular> extracurriculars, ArrayList<Honor> honors) {
        this.educations = educations;
        this.skills = skills;
        this.courses = courses;
        this.work = work;
        this.extracurriculars = extracurriculars;
        this.honors = honors;
        id = UUID.randomUUID();
    }

    public Resume() {
        educations = new ArrayList<Education>();
        skills = new Hashtable<Skill, Boolean>();
        courses = new Hashtable<String, Boolean>();
        work = new ArrayList<WorkExperience>();
        extracurriculars = new ArrayList<Extracurricular>();
        honors = new ArrayList<Honor>();
        id = UUID.randomUUID();
    }

    public ArrayList<Education> getEducations() {
        return this.educations;
    }

    public ArrayList<Honor> getHonors() {
        return honors;
    }

    public Hashtable<Skill, Boolean> getSkills() {
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

    public void addHonor(Honor honor) {
        honors.add(honor);
    }

    public void removeHonor(Honor honor) {
        honors.remove(honor);
    }

    public void removeEducation(Education edu) {
        educations.remove(edu);
    }

    public void addSkill(Skill skill, boolean bool) {
        skills.put(skill, bool);
    }

    public void removeSkill(Skill skill) {
        skills.remove(skill);
    }

    public void addCourse(String course, boolean bool) {
        courses.put(course, bool);
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

    public void sortReverseChronEdu(ArrayList<Education> education) {
        
    }

    public void sortReverseChronWork(ArrayList<Education> work) {

    }
    
    public String toString() {
        return "";
    }
}
