import java.util.UUID;
import java.util.ArrayList;

public abstract class User {
    protected String username;
    protected String password;
    private UUID id;

    public User() {
        this.username = "";
        this.password = "";
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private boolean checkUsername(String username) {
        return true;
    }

    private boolean checkPassword(String password) {
        return true;
    }

    private ArrayList<InternshipPost> getPosts() {
        return new ArrayList<InternshipPost>();
    }

    private ArrayList<InternshipPost> getPosts(String keyword) {
        return new ArrayList<InternshipPost>();
    }    

    private ArrayList<Employer> getEmployer(String keyword) {
        return new ArrayList<Employer>();
    }

    private ArrayList<InternshipPost> filterByPay(int lowPay, int highPay, ArrayList<InternshipPost> posts) {
        return new ArrayList<InternshipPost>();
    }

    private ArrayList<InternshipPost>  filterByLocation(String location) {
        return new ArrayList<InternshipPost>();
    }

    private ArrayList<InternshipPost> filterByLanguage(String language) {
        return new ArrayList<InternshipPost>();
    }

    private ArrayList<InternshipPost> filterByRemote(boolean isRemote) {
        return new ArrayList<InternshipPost>();
    }
}
