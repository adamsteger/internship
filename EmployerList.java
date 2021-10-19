import java.util.ArrayList;

public class EmployerList {
    private static EmployerList employerList;
    private ArrayList<Employer> employers;
    
    private EmployerList() {
        this.employers = employers;
    }

    public static EmployerList getInstance() {
        if(employerList == null) 
            employerList = new EmployerList();
        return employerList;
    }

    public ArrayList<Employer> getEmployers() {
        return employers;
    }

    public void save() {
        
    }
}
