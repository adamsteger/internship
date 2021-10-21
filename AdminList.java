import java.util.ArrayList;

public class AdminList {
    private static AdminList adminList;
    private ArrayList<Admin> admins;
    
    private AdminList() {
        this.admins = DataLoader.getAdmins();
    }

    public AdminList getAdminList() {
        return adminList;
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public static AdminList getInstance() {
        if(adminList == null) 
            adminList = new AdminList();
        return adminList;
    }

    public ArrayList<Admin> addAdmin(Admin admin){
        admins.add(admin);
        return admins;
    }
    public ArrayList<Admin> removeAdmin(Admin admin){
        admins.remove(admin);
        return admins;
    }
    public void save() {
        
    }
}

