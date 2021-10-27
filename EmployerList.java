import java.util.ArrayList;
import java.util.UUID;

public class EmployerList {
    private static EmployerList employerList;
    private ArrayList<Employer> employers;
    
    private EmployerList() {
        employers = DataLoader.getEmployers();
    }

    public static EmployerList getInstance() {
        if(employerList == null) 
            employerList = new EmployerList();
        return employerList;
    }

    public boolean haveEmployer(String title) {
        for(Employer employer : employers) {
            if(employer.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Employer> getEmployers() {
        return employers;
    }

    public Employer getEmployerByTitle(String title) {
        for(Employer employer : employers) {
            if(employer.getTitle().contains(title)) {
                return employer;
            }
        }
        return null;
    }

    public Employer getEmployerByUser(String username) {
        for(Employer employer : employers) {
            if(employer.getUsername().contains(username)) {
                return employer;
            }
        }
        return null;
    }

    public Employer getEmployerByID(UUID id) {
        for (Employer employer : employers) {
            if (employer.getUUID().equals(id)) {
                return employer;
            }
        }
        return null;
    }

    public boolean addEmployer(Employer employer) {
        if(haveEmployer(employer.getUsername()))
            return false;
        
        employers.add(employer);
        return true;
    }

    public void save() {
        DataWriter.saveEmployers();
    }
}
