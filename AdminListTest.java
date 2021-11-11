import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;

public class AdminListTest {
    private AdminList admins = AdminList.getInstance();
    private ArrayList<Admin> adminList = admins.getAdmins();

    @Before
    public void setup() {
        adminList.clear();
        adminList.add(new Admin("anaboca", "1234567"));
        adminList.add(new Admin("asteger", "codykolover"));
        DataWriter.saveAdmins();
    }

    @After
    public void tearDown() {
        AdminList.getInstance().getAdmins().clear();
        DataWriter.saveAdmins();
    }

    @Test
    public void testHaveUserValidFirstItem() {
        boolean hasAna = admins.haveAdmin("anaboca");
        assertTrue(hasAna);
    }

    @Test
    public void testHaveUserValidLastItem() {
        boolean hasAdam = admins.haveAdmin("asteger");
        assertTrue(hasAdam);
    }

    @Test
	public void testHaveUserInValid() {
		boolean hasJoe = admins.haveAdmin("jsmith");
		assertFalse(hasJoe);
	}
	
	@Test
	public void testHaveUserEmpty() {
		boolean hasEmpty = admins.haveAdmin("");
		assertFalse(hasEmpty);
	}
	
	@Test
	public void testHaveUserNull() {
		boolean hasNull = admins.haveAdmin(null);
		assertFalse(hasNull);
	}

    // @Test
    // public void testGetAdminByUUID() {
        
    // }

    // TODO test get admin by user
    // TODO test get admin by ID
    // TODO test addAdmin

}
