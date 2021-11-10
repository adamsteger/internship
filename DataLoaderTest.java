import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;

public class DataLoaderTest {
    private ArrayList<Employer> employerList = EmployerList.getInstance().getEmployers();
    private ArrayList<InternshipPost> internshipList = InternshipList.getInstance().getInternships();
    private ArrayList<Admin> adminList = AdminList.getInstance().getAdmins();
    private StudentList studentList = StudentList.getInstance();

    @BeforeClass
    public void setup() {
        System.out.println("working");
        studentList.getStudents().clear();
        Student adam = new Student("Adam", "Steger", "asteger", "mypassword", 2024, "asteger@email.sc.edu", "1238 Axtell Dr Cayce, SC 29033", "(803)730-3278", 4.0, true);
        Student chris = new Student("Chris", "Bacon", "chrispbacon", "hispassword", 2022, "baconbits@gmail.com", "123 BLT St, Irmo, SC 29063", "(803)123-4567", 3.5, false);
        studentList.addStudent(adam);
        studentList.addStudent(chris);
        // DataWriter.saveStudents();
    }

    @AfterClass
    public void tearDown() {
        StudentList.getInstance().getStudents().clear();
        DataWriter.saveStudents();
    }

    @Test
    public void testGetStudentsSize() {
        // studentList = DataLoader.getStudents();
        assertEquals(2, studentList.getStudents().size());
    }

    @Test
    public void testGetStudentsSizeZero() {
        StudentList.getInstance().getStudents().clear();
        DataWriter.saveStudents();
        assertEquals(0,studentList.getStudents().size());
    }

    @Test
    public void testGetStudentsEmptyStudent() {
        StudentList.getInstance().getStudents().clear();
        Student empty = new Student("","","","",0,"","","",0.0,false);
        studentList.addStudent(empty);
        assertEquals(1,studentList.getStudents().size());
    }
}

//empty student, null student, normal students, 1 student 

