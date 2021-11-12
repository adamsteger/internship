import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;

public class DataLoaderTest {
    private EmployerList employerList = EmployerList.getInstance();
    private InternshipList internshipList = InternshipList.getInstance();
    private AdminList adminList = AdminList.getInstance();
    private StudentList studentList = StudentList.getInstance();

    @Before
    public void setup() {
        studentList.getStudents().clear();

        Student adam = new Student("Adam", "Steger", "asteger", "mypassword", 2024, "asteger@email.sc.edu", "1238 Axtell Dr Cayce, SC 29033", "(803)730-3278", 4.0, true);
        adam.getReviews().add(new Review("Google", 4, "Very Good Student"));
        adam.getReviews().add(new Review("Amazon", 2, "Mid"));

        Student chris = new Student("Chris", "Bacon", "chrispbacon", "hispassword", 2022, "baconbits@gmail.com", "123 BLT St, Irmo, SC 29063", "(803)123-4567", 3.5, false);
        InternshipPost post = new InternshipPost("Google", "Intern", "Intern things", "Columbia, SC", new ArrayList<Skill>(), "May 2020", "August 2020", false, true, 1000, 1500);
        chris.getFavoritePosts().add(post);

        studentList.addStudent(adam);
        studentList.addStudent(chris);


        employerList.getEmployers().clear();

        Employer google = new Employer("Google", "ImGoogle", "password", "google@gmail.com", "Columbia, SC", "Google forever");
        google.getReviews().add(new Review("Adam Steger", 5, "Great company"));
        google.getReviews().add(new Review("Amy Smith", 3, "Solid employer"));

        Employer google2 = new Employer("Google2", "ImGoogle2", "password", "google@gmail.com", "Columbia, SC", "Google forever");

        employerList.addEmployer(google);
        employerList.addEmployer(google2);


        internshipList.getInternships().clear();

        ArrayList<Skill> postSkills = new ArrayList<Skill>();
        postSkills.add(Skill.C);
        postSkills.add(Skill.CPP);
        InternshipPost googlePost = new InternshipPost("Google", "Intern", "Intern at Google", "Columbia, SC", postSkills, "May 2020", "August 2020", false, true, 1000, 1500);
        ArrayList<Skill> post2Skills = new ArrayList<Skill>();
        post2Skills.add(Skill.JAVA);
        post2Skills.add(Skill.JAVASCRIPT);
        InternshipPost google2Post = new InternshipPost("Google", "Intern2", "Intern at Google", "Columbia, SC", post2Skills, "May 2020", "August 2020", false, true, 1000, 1500);

        internshipList.addInternship(googlePost);
        internshipList.addInternship(google2Post);
    }

    @After
    public void tearDown() {
        StudentList.getInstance().getStudents().clear();
        DataWriter.saveStudents();
    }

    @Test
    public void testGetStudentsSize() {
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

    @Test
    public void testGetStudentsNullStudent() {
        StudentList.getInstance().getStudents().clear();
        Student nullStudent = null;
        studentList.addStudent(nullStudent);
        assertEquals(0, studentList.getStudents().size());
    }

    @Test
    public void testGetStudentsUsername() {
        assertEquals("asteger", studentList.getStudents().get(0).getUsername());
    }

    @Test
    public void testGetStudentsReviewsSize() {
        assertEquals(2, studentList.getStudents().get(0).getReviews().size());
    }

    @Test
    public void testGetStudentsReviewsFirstElement() {
        assertEquals("Google", studentList.getStudents().get(0).getReviews().get(0).getWriter());
    }

    @Test
    public void testGetStudentsReviewsLastElement() {
        assertEquals("Mid", studentList.getStudents().get(0).getReviews().get(1).getComment());
    }

    @Test
    public void testGetStudentsFavPostsSize() {
        assertEquals(1, studentList.getStudents().get(1).getFavoritePosts().size());
    }

    @Test
    public void testGetStudentsFavPosts() {
        assertEquals("Intern", studentList.getStudents().get(1).getFavoritePosts().get(0).getPosTitle());
    }

    @Test
    public void testGetFourStudents() {
        Student amy = new Student("Adam", "Steger", "asmith", "mypassword", 2024, "asteger@email.sc.edu", "1238 Axtell Dr Cayce, SC 29033", "(803)730-3278", 4.0, true);
        Student berry = new Student("Adam", "Steger", "bsmith", "mypassword", 2024, "asteger@email.sc.edu", "1238 Axtell Dr Cayce, SC 29033", "(803)730-3278", 4.0, true);
        studentList.addStudent(amy);
        studentList.addStudent(berry);
        assertEquals("bsmith", studentList.getStudents().get(3).getUsername());
    }

    // @Test
    // public void testGetStudentsResume() {
    //     assertEquals(expected, actual);
    // }

    @Test
    public void testGetEmployersSize() {
        assertEquals(2, employerList.getEmployers().size());
    }

    @Test
    public void testGetEmployersSizeZero() {
        employerList.getEmployers().clear();
        DataWriter.saveEmployers();
        assertEquals(0,employerList.getEmployers().size());
    }

    @Test
    public void testGetEmployersEmptyEmployer() {
        employerList.getEmployers().clear();
        Employer empty = new Employer("","","","","","");
        employerList.addEmployer(empty);
        assertEquals(1,employerList.getEmployers().size());
    }

    @Test
    public void testGetEmployersNullEmployer() {
        employerList.getEmployers().clear();
        Employer nullEmployer = null;
        employerList.addEmployer(nullEmployer);
        assertEquals(0, employerList.getEmployers().size());
    }

    @Test
    public void testGetEmployersUsername() {
        assertEquals("ImGoogle", employerList.getEmployers().get(0).getUsername());
    }

    @Test
    public void testGetEmployersReviewsSize() {
        assertEquals(2, employerList.getEmployers().get(0).getReviews().size());
    }

    @Test
    public void testGetEmployersReviewsFirstElement() {
        assertEquals("Adam Steger", employerList.getEmployers().get(0).getReviews().get(0).getWriter());
    }

    @Test
    public void testGetEmployersReviewsLastElement() {
        assertEquals("Solid employer", employerList.getEmployers().get(0).getReviews().get(1).getComment());
    }

    @Test
    public void testGetFourEmployers() {
        Employer google3 = new Employer("Google", "ImGoogle3", "password", "google@gmail.com", "Columbia, SC", "Google forever");
        Employer google4 = new Employer("Google", "ImGoogle4", "password", "google@gmail.com", "Columbia, SC", "Google forever");
        employerList.addEmployer(google3);
        employerList.addEmployer(google4);
        assertEquals("ImGoogle4", employerList.getEmployers().get(3).getUsername());
    }

    @Test
    public void testGetInternshipsSize() {
        assertEquals(2, internshipList.getInternships().size());
    }

    @Test
    public void testGetInternshipsSizeZero() {
        internshipList.getInternships().clear();
        DataWriter.saveInternshipPosts();
        assertEquals(0,internshipList.getInternships().size());
    }

    @Test
    public void testGetInternshipsEmptyInternship() {
        internshipList.getInternships().clear();
        InternshipPost empty = new InternshipPost("","","","", new ArrayList<Skill>(),"","",false,false,0,0);
        internshipList.addInternship(empty);
        assertEquals(1,internshipList.getInternships().size());
    }

    @Test
    public void testGetInternshipsNullInternship() {
        internshipList.getInternships().clear();
        InternshipPost nullPost = null;
        internshipList.addInternship(nullPost);
        assertEquals(0, internshipList.getInternships().size());
    }

    @Test
    public void testGetInternshipsPosTite() {
        assertEquals("Intern", internshipList.getInternships().get(0).getPosTitle());
    }

    @Test
    public void testGetInternshipsSkillsSize() {
        assertEquals(2, internshipList.getInternships().get(0).getSkillReq().size());
    }

    @Test
    public void testGetInternshipsSkillsFirstElement() {
        assertEquals(Skill.C, internshipList.getInternships().get(0).getSkillReq().get(0));
    }

    @Test
    public void testGetInternshipsSkillsLastElement() {
        assertEquals(Skill.JAVASCRIPT, internshipList.getInternships().get(1).getSkillReq().get(1));
    }
}

//empty student, null student, normal students, 1 student 

