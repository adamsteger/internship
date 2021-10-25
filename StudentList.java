import java.util.ArrayList;
import java.util.UUID;

public class StudentList {
    private static StudentList studentList;
    private ArrayList<Student> students;
    
    private StudentList() {
        students = DataLoader.getStudents();
    }

    public static StudentList getInstance() {
        if(studentList == null)
            studentList = new StudentList();
        return studentList;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Student getStudentByID(UUID id) {
        Student ret = new Student();
        for (Student student : students) {
            if (student.getUUID().equals(id)) {
                ret = student;
            }
        }
        return ret;
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
