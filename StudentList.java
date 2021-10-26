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

    public boolean haveStudent(String username) {
        for(Student student : students) {
            if(student.getUserName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Student getStudentByUser(String username) {
        for(Student student : students) {
            if(student.getUserName().equals(username)) {
                return student;
            }
        }
        return null;
    }
    
    public Student getStudentByID(UUID id) {
        for (Student student : students) {
            if (student.getUUID().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public boolean addStudent(String username, String password) { 
        if(haveStudent(username)) 
            return false;
        
        students.add(new Student(username, password));
        return true;
    }

    public void save() {
        DataWriter.saveStudents();
    }
}
