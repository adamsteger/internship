import java.util.ArrayList;

public class StudentList {
    private static StudentList studentList;
    private ArrayList<Student> students;
    
    private StudentList() {
        this.students = students;
    }

    public static StudentList getInstance() {
        if(studentList == null)
            studentList = new StudentList();
        return studentList;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void save() {
        
    }
}
