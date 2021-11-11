import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;

public class InternshipListTest {
    private InternshipList internships = InternshipList.getInstance();
    private ArrayList<InternshipPost> internshipList = internships.getInternships();

    @Before
    public void setup() {
        internshipList.clear();
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(Skill.JAVA);
        skills.add(Skill.PYTHON);
        internshipList.add(new InternshipPost("Google", "Software Development Intern", "coding things", "Mountain View, CA", skills, "May 2022", "August 2022", false, true, 1000, 2500));
        internshipList.add(new InternshipPost("Microsoft", "Application Design Intern", "design things", "Seattle, WA", skills, "Jan 2022", "December 2022", true, true, 2000, 3000));
        DataWriter.saveInternshipPosts();
    }

    @After
    public void tearDown() {
        InternshipList.getInstance().getInternships().clear();
        DataWriter.saveInternshipPosts();
    }

    @Test
    public void testHaveInternshipValidFirstItem() {
        boolean hasGoogle = internships.haveInternshipPost("Google", "Software Development Intern");
        assertTrue(hasGoogle);
    }

    @Test
    public void testHaveIntershipValidLastItem() {
        boolean hasMicro = internships.haveInternshipPost("Microsoft", "Application Design Intern");
        assertTrue(hasMicro);
    }

    @Test
	public void testHaveInternshipInValid() {
		boolean hasIBM = internships.haveInternshipPost("IBM", "Coding Internship");
		assertFalse(hasIBM);
	}
	
	@Test
	public void testHaveInternshipEmpty() {
		boolean hasEmpty = internships.haveInternshipPost("", "");
		assertFalse(hasEmpty);
	}
	
	@Test
	public void testHaveInternshipNull() {
		boolean hasNull = internships.haveInternshipPost(null, null);
		assertFalse(hasNull);
	}

    // @Test
    // public void testGetAdminByUUID() {
        
    // }

    // TODO test get admin by title
    // TODO test get admin by user
    // TODO test get admin by id
    // TODO test add employer
}

