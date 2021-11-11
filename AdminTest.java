import org.junit.*;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.UUID;

public class AdminTest {
    private InternshipList internshipList = InternshipList.getInstance();
    private ArrayList<InternshipPost> internshipPosts = internshipList.getInternships();
    private Admin testAdmin = new Admin("adamsanfacon", "password");


    @Before
    public void setup() {
        internshipPosts.clear();
        }

    @After 
    public void tearDown() {
        internshipPosts.clear();
    }

    @Test
    public void testAddPost() {
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(Skill.SQL);
        skills.add(Skill.CPP);
        testAdmin.addPost("Meta", "NFT salesman or something", "Make magic money for pixels", "Anywhere", skills, "April 2022", "December 2022", true, true, 25000, 40000);
        assertEquals("Meta", internshipList.haveInternshipPost("Meta", "NFT salesman or something"));
    }
    
    @Test
    public void testDeletePost() {

    }

    @Test
    public void testDeleteStudentReview() {

    }

    @Test
    public void testDeleteEmployerReview() {

    }
}
