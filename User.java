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


    //existing account loaded from json
    public User(String username, String password, UUID id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }
    
    //new account
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.id = UUID.randomUUID();
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

    private boolean checkUsername(String username) {
        if(studentList.haveStudent(username))
            return false;
        if(employerList.haveEmployer(username))
            return false;
        if(adminList.haveAdmin(username))
            return false;
        if(username.length() < 10 || username.length() > 20)
            return false;
        return true;
    }

    private boolean checkPassword(String password) {
        if(password.length() < 10 || password.length() > 20)
            return false;
        return true;
    }

    private ArrayList<InternshipPost> getPosts() {
        return internshipList.getInternships();
    }

    private ArrayList<InternshipPost> getPosts(String keyword) {
        ArrayList<InternshipPost> retList = new ArrayList<InternshipPost>();
        for(int i = 0; i < internshipList.getInternships().size(); i++){
            InternshipPost currentPost = internshipList.getInternships().get(i);
            if(currentPost.getEmployerTitle() == keyword)
                retList.add(currentPost);
        }
        return retList;
    }    

    private ArrayList<Employer> getEmployer(String keyword) {
        ArrayList<Employer> retList = new ArrayList<Employer>();
        if(employerList.haveEmployer(keyword))
            retList.add(employerList.getEmployerByUser(keyword));
        return retList;
    }

    private ArrayList<InternshipPost> filterByPay(int lowPay, int highPay) {
        ArrayList<InternshipPost> retList = new ArrayList<InternshipPost>();
        for(int i = 0; i < internshipList.getInternships().size(); i++){
            InternshipPost currentPost = internshipList.getInternships().get(i);
            if(currentPost.getLowPay() > lowPay && currentPost.getHighPay() < highPay)
                retList.add(currentPost);
        }
        return retList;
    }

    private ArrayList<InternshipPost> filterByLocation(String location) {
        ArrayList<InternshipPost> retList = new ArrayList<InternshipPost>();
        for(int i = 0; i < internshipList.getInternships().size(); i++){
            InternshipPost currentPost = internshipList.getInternships().get(i);
            if(currentPost.getLocation() == location)
                retList.add(currentPost);
        }
        return retList;
    }

    private ArrayList<InternshipPost> filterByLanguage(Skill language) {
        ArrayList<InternshipPost> retList = new ArrayList<InternshipPost>();
        for(int i = 0; i < internshipList.getInternships().size(); i++){
            InternshipPost currentPost = internshipList.getInternships().get(i);
            for(int j = 0; j < currentPost.getSkillReq().size(); i++){
                if(currentPost.getSkillReq().get(i) == language)
                    retList.add(currentPost);
            }
        }
        return retList;
    }

    private ArrayList<InternshipPost> filterByRemote(boolean isRemote) {
        ArrayList<InternshipPost> retList = new ArrayList<InternshipPost>();
        for(int i = 0; i < internshipList.getInternships().size(); i++){
            InternshipPost currentPost = internshipList.getInternships().get(i);
            if(currentPost.getRemote() == isRemote)
                retList.add(currentPost);
        }
        return retList;
    }
}
