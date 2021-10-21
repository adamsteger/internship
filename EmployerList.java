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
        Employer ret = new Employer();
        for (Employer employer : employers) {
            if (employer.getUUID().equals(id)) {
                ret = employer;
            }
        }
        return ret;
    }

    public void save() {
        
    }
}
