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

    public boolean haveEmployer(String username) {
        for(Employer employer : employers) {
            if(employer.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Employer> getEmployers() {
        return employers;
    }

    public Employer getEmployerByUser(String username) {
        for(Employer employer : employers) {
            if(employer.getUsername().equals(username)) {
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

    public boolean addEmployer(String username, String password) {
        if(haveEmployer(username))
            return false;
        
        employers.add(new Employer(username, password));
        return true;
    }

    public void save() {
        DataWriter.saveEmployers();
    }
}
