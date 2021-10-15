import java.util.ArrayList;
import java.util.UUID;

public class InternshipPost {
    private Employer employer;
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

    public InternshipPost(String compName, String posTitle, String description, String location, ArrayList<Skill> skillReq, String startDate, String endDate, boolean isRemote, boolean isOpen, String language, int lowPay, int highPay) {

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
