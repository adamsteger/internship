import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class DataLoaderTest {
    private ArrayList<Employer> employerList = EmployerList.getInstance().getEmployers();
    private ArrayList<InternshipPost> internshipList = InternshipList.getInstance().getInternships();
    private ArrayList<Admin> adminList = AdminList.getInstance().getAdmins();
    private ArrayList<Student> studentList = StudentList.getInstance().getStudents();

    @BeforeEach
    public void setup() {
        studentList.clear();
        Student adam = new Student("Adam", "Steger", "asteger", "mypassword", 2024, "asteger@email.sc.edu", "1238 Axtell Dr Cayce, SC 29033", "(803)730-3278", 4.0, true);
        Student chris = new Student("Chris", "Bacon", "chrispbacon", "hispassword", 2022, "baconbits@gmail.com", "123 BLT St, Irmo, SC 29063", "(803)123-4567", 3.5, false);
        studentList.add(adam);
        studentList.add(chris);
        DataWriter.saveStudents();
    }

    @AfterEach
    public void tearDown() {
        StudentList.getInstance().getStudents().clear();
        DataWriter.saveStudents();
    }

    @Test
    public void testGetStudentsSize() {
        studentList = DataLoader.getStudents();
        assertEquals(2, studentList.size());
    }

    @Test
    public void testGetStudentsSizeZero() {
        StudentList.getInstance().getStudents().clear();
        DataWriter.saveStudents();
        assertEquals(0,studentList.size());
    }
}
