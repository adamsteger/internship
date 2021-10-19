import java.util.ArrayList;

public class AdminList {
    private static AdminList adminList;
    private ArrayList<Admin> admins;
    
    private AdminList() {
        this.admins = admins;
    }

    public static AdminList getInstance() {
        if(adminList == null) 
            adminList = new AdminList();
        return adminList;
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public void save() {
        
    }
}

