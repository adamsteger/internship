import java.util.ArrayList;
import java.util.UUID;

public class ResumeList {
    private static ResumeList resumeList;
    private ArrayList<Resume> resumes;

    private ResumeList() {
        resumes = DataLoader.getResumes();
    }

    public static ResumeList getInstance() {
        if(resumeList == null)
            resumeList = new ResumeList();
        return resumeList;
    }

    public ArrayList<Resume> getResumes() {
        return resumes;
    }

    public Resume getResumeByID(UUID id) {
        for(Resume resume : resumes) {
            if(resume.getID().equals(id)) {
                return resume;
            }
        }
        return null;
    }

    public void save() {
        DataWriter.saveResumes();
    }
}