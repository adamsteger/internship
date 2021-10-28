import java.util.UUID;
import java.util.ArrayList;

public abstract class User {
    protected String username;
    protected String password;
    private StudentList studentList;
    private EmployerList employerList;
    private AdminList adminList;
    private InternshipList internshipList;
    private UUID id;
    private ArrayList<Review> reviews;
    
    //new account
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.id = UUID.randomUUID();
        this.reviews = new ArrayList<Review>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UUID getUUID() {
        return id;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    // private boolean checkUsername(String username) {
    //     if(studentList.haveStudent(username))
    //         return false;
    //     else if(employerList.haveEmployer(username))
    //         return false;
    //     else if(adminList.haveAdmin(username))
    //         return false;

    //     if(username.length() <= 6 || username.length() >= 15)
    //         return false;
    //     return true;
    // }

    // private boolean checkPassword(String password) {
    //     if(password.length() <= 8 || password.length() >= 20)
    //         return false;
    //     return true;
    // }

    private ArrayList<InternshipPost> getPosts() {
        return internshipList.getInternships();
    }

    private ArrayList<InternshipPost> getPosts(String keyword) {
        ArrayList<InternshipPost> retList = new ArrayList<InternshipPost>();
        for(int i = 0; i < internshipList.getInternships().size(); i++){
            InternshipPost currentPost = internshipList.getInternships().get(i);
            if(currentPost.getPosTitle().contains(keyword))
                retList.add(currentPost);
        }
        return retList;
    }    

    private ArrayList<Employer> getEmployer(String keyword) {
        ArrayList<Employer> retList = new ArrayList<Employer>();
        if(employerList.haveEmployer(keyword))
            retList.add(employerList.getEmployerByTitle(keyword));
        return retList;
    }
}
