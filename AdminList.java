import java.util.ArrayList;

public class AdminList {
    private AdminList adminList;
    private ArrayList<Admin> admins;
    
    private AdminList() {

    }

    public AdminList getInstance() {
        return new AdminList();
    }

    public ArrayList<Admin> getAdmins() {
        return new ArrayList<Admin>();
    }

    public void save() {
        
    }
}

