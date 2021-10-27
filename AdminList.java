import java.util.ArrayList;
import java.util.UUID;

public class AdminList {
    private static AdminList adminList;
    private ArrayList<Admin> admins;
    
    private AdminList() {
        admins = DataLoader.getAdmins();
    }

    public static AdminList getInstance() {
        if(adminList == null) 
            adminList = new AdminList();
        return adminList;
    }

    public boolean haveAdmin(String username) {
        for(Admin admin : admins) {
            if(admin.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public Admin getAdminByUser(String username) {
        for(Admin admin : admins) {
            if(admin.getUsername().equals(username)) {
                return admin;
            }
        }
        return null;
    }

    public Admin getAdminByID(UUID id) {
        for(Admin admin : admins) {
            if(admin.getUUID().equals(id)) {
                return admin;
            }
        }
        return null;
    }

    public boolean addAdmin(Admin admin){
        if(haveAdmin(admin.getUsername()))
            return false;

        admins.add(admin);
        return true;
    }
    
    public void save() {
        DataWriter.saveAdmins();
    }
}

