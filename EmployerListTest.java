import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;

public class EmployerListTest {
    private EmployerList employers = EmployerList.getInstance();
    private ArrayList<Employer> employerList = employers.getEmployers();

    @Before
    public void setup() {
        employerList.clear();
        employerList.add(new Employer("anaboca", "1234567"));
        employerList.add(new Employer("asteger", "codykolover"));
        DataWriter.saveAdmins();
    }

    @After
    public void tearDown() {
        AdminList.getInstance().getAdmins().clear();
        DataWriter.saveAdmins();
    }

    @Test
    public void testHaveUserValidFirstItem() {
        boolean hasAna = employers.haveEmployer("anaboca");
        assertTrue(hasAna);
    }

    @Test
    public void testHaveUserValidLastItem() {
        boolean hasAdam = employers.haveEmployer("asteger");
        assertTrue(hasAdam);
    }

    @Test
	public void testHaveUserInValid() {
		boolean hasJoe = employers.haveEmployer("jsmith");
		assertFalse(hasJoe);
	}
	
	@Test
	public void testHaveUserEmpty() {
		boolean hasEmpty = employers.haveEmployer("");
		assertFalse(hasEmpty);
	}
	
	@Test
	public void testHaveUserNull() {
		boolean hasNull = employers.haveEmployer(null);
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
