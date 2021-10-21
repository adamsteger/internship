import java.util.ArrayList;

public class StudentList {
    private static StudentList studentList;
    private ArrayList<Student> students;
    
    private StudentList() {
        this.students = DataLoader.getStudents();
    }

    public static StudentList getInstance() {
        if(studentList == null)
            studentList = new StudentList();
        return studentList;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
    public ArrayList<Student> addStudent(Student student) { 
        students.add(student);
        return students;
    }

    public ArrayList<Student> removeStuent(Student student) {
        students.remove(student);
        return students;
    }

    public void save() {
        
    }
}
