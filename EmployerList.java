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
        Employer ret = new Employer();
        for (Employer employer : employers) {
            if (employer.getUUID().equals(id)) {
                ret = employer;
            }
        }
        return ret;
    }
    public ArrayList<Employer> removeEmployer(Employer employer){
        employers.remove(employer);
        return employers;
    }

    public void save() {
        
    }

    public void remove() {

    }
}
