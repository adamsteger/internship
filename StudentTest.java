import org.junit.*;

import static org.junit.Assert.assertEquals;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.UUID;

public class StudentTest {
    private Student testStudent = new Student("adam", "sanfacon", "adamsanf", "1234567", 2023, "sanfacoa@email.sc.edu", "2331 preston st", "1234567890", 3.5, true);


    @Before
    public void setup() {
        ArrayList<InternshipPost> a = new ArrayList<InternshipPost>();
        a = testStudent.getFavoritePosts();
    }

    @After 
    public void tearDown() {
        testStudent.getFavoritePosts();
    }
    @Test
    public void testAddFavoritePost(){
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(Skill.SQL);
        skills.add(Skill.CPP);
        testStudent.addFavoritePost(new InternshipPost("IBM", "Intern Developer", "Introductory business coding", "California", skills, "April 2022", "December 2022", true, true, 3000, 5000));
        assertEquals(null, testStudent.getFavoritePosts().get(0));
    }
    @Test
    public void testApply(){
        InternshipPost post = new InternshipPost("IBM", "Intern Developer", "Introductory business coding", "California", skills, "April 2022", "December 2022", true, true, 3000, 5000);
        testStudent.apply(post);
        assertEquals(post, post.getApplicants().get(0));
    }
}
