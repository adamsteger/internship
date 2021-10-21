import java.util.ArrayList;
import java.util.UUID;

public class EmployerList {
    private static EmployerList employerList;
    private ArrayList<Employer> employers;
    
    private EmployerList() {
        this.employers = DataLoader.getEmployers();
    }

    public ArrayList<Employer> getEmployers() {
        return this.employers;
    }

    public static EmployerList getInstance() {
        if(employerList == null) 
            employerList = new EmployerList();
        return employerList;
    }

    public Employer getEmployerByID(UUID id) {
        for (Employer employer : employers) {
            if (employer.getID() == id) {
                return employer;
            }
        }
        return null;
    }

    public void save() {
        
    }

    public void remove() {

    }
}
