import java.util.ArrayList;

public class StudentList {
    private StudentList studentList;
    private ArrayList<Student> students;
    
    private StudentList() {

    }

    public StudentList getInstance() {
        return new StudentList();
    }

    public ArrayList<Student> getStudents() {
        return new ArrayList<Student>();
    }

    public void save() {
        
    }
}
