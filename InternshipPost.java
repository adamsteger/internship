import java.util.ArrayList;
import java.util.UUID;

public class InternshipPost {
    private String employerTitle;
    private String posTitle;
    private String description;
    private String location;
    private ArrayList<Skill> skillReq;
    private String startDate;
    private String endDate;
    private boolean isRemote;
    private boolean isOpen;
    private int lowPay;
    private int highPay;
    private ArrayList<Student> applicants;
    private UUID id;

    public InternshipPost(String employerTitle, String posTitle, String description, String location, ArrayList<Skill> skillReq, String startDate, String endDate, boolean isRemote, boolean isOpen, String language, int lowPay, int highPay) {
        this.posTitle = posTitle;
    }

    public String getEmployerTitle() {
        return employerTitle;
    }

    public String getPosTitle() {
        return posTitle;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public ArrayList<Skill> getSkillReq() {
        return skillReq;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public boolean getRemote() {
        return isRemote;
    }

    public boolean getOpen() {
        return isOpen;
    }

    public int getLowPay() {
        return lowPay;
    }

    public int getHighPay() {
        return highPay;
    }

    public ArrayList<Student> getApplicants() {
        return applicants;
    }

    public UUID getUUID() {
        return id;
    }

    public ArrayList<Student> filterBySkill(Skill skill) {
        return new ArrayList<Student>();
    }

    public ArrayList<Student> filterByGPA(float lowGPA) {
        return new ArrayList<Student>();
    }

    public ArrayList<Student> filterByGradYear(int gradYear) {
        return new ArrayList<Student>();
    }

    public ArrayList<Student> filterByMajor(String major) {
        return new ArrayList<Student>();
    }

    public String toString() {
        return "";
    }
}
