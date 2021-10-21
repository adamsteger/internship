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

    public ArrayList<Employer> getEmployers() {
        return employers;
    }

    public Employer getEmployerByID(UUID id) {
        for (Employer employer : employers) {
            if (employer.getUUID() == id) {
                return employer;
            }
        }
        return null;
    }

    public void save() {
        
    }
}
