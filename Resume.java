import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
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

    public Resume(UUID id, ArrayList<Education> educations, Hashtable<Skill, Boolean> skills, Hashtable<String, Boolean> courses, 
      ArrayList<WorkExperience> work, ArrayList<Extracurricular> extracurriculars, ArrayList<Honor> honors) {
        this.educations = educations;
        this.skills = skills;
        this.courses = courses;
        this.work = work;
        this.extracurriculars = extracurriculars;
        this.honors = honors;
        this.id = id;
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

    public UUID getID() {
        return id;
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
        List keys = new ArrayList(skills.keySet());
        if (keys.contains(skill)) {
            skills.put(skill, bool);
        }
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
        //TODO Read in resume bool for skills and courses
        String ret = "\nEducations: ";
        for (Education edu : educations) {
            ret += edu + "\n";
        }
        ret += "\nSkills: ";
        Enumeration<Skill> skillsValues = skills.keys();
        while (skillsValues.hasMoreElements()) {
            ret += skillsValues.nextElement() + "\t";
        }
        ret += "\n\nCourses: ";
        Enumeration<String> coursesValues = courses.keys();
        while (coursesValues.hasMoreElements()) {
            ret += coursesValues.nextElement() + "\t";
        }
        ret += "\n\nWork Experiences: ";
        for (WorkExperience workExperience : work) {
            ret += workExperience + "\t";
        }
        ret += "\nExtracurriculars: ";
        for (Extracurricular extra : extracurriculars) {
            ret += extra + "\t";
        }
        ret += "\nHonors: ";
        for (Honor honor : honors) {
            ret += honor + "\t";
        }

        return ret;
    }
}
