import java.util.ArrayList;
import java.util.UUID;

public class UserList {
    private static UserList userList;
    private ArrayList<User> users;
    
    private UserList() {
        users = DataLoader.getUsers();
    }

    public static UserList getInstance() {
        if(userList == null)
            userList = new UserList();
        return userList;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User geUserByID(UUID id) {
        User ret = new User();
        for (User user : users) {
            if (user.getUUID().equals(id)) {
                ret = user;
            }
        }
        return ret;
    }

    public ArrayList<User> addStudent(User user) { 
        users.add(user);
        return users;
    }

    public ArrayList<User> removeStuent(User user) {
        users.remove(user);
        return users;
    }

    public void save() {
        
    }
}
