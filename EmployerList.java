import java.util.ArrayList;

public class EmployerList {
    private EmployerList employerList;
    private ArrayList<Student> students;
    
    private EmployerList() {

    }

    public EmployerList getInstance() {
        return new EmployerList();
    }

    public ArrayList<Employer> getEmployers() {
        return new ArrayList<Employer>();
    }

    public void save() {
        
    }
}
