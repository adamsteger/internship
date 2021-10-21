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

    public InternshipPost(UUID id, String employerTitle, String posTitle, String description, String location, String startDate, String endDate, boolean isRemote, boolean isOpen, int lowPay, int highPay) {
        this.id = id;
        this.employerTitle = employerTitle;
        this.posTitle = posTitle;
        this.description = description;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isRemote = isRemote;
        this.isOpen = isOpen;
        this.lowPay = lowPay;
        this.highPay = highPay;
    }

    public InternshipPost() {
        this.employerTitle = "";
        skillReq = new ArrayList<Skill>();
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
        String ret = "\nEmployer: " + employerTitle + "\nPosition Title: " + posTitle + "\nDescription: " + description +
                        "\nLocation: " + location + "\nStart Date: " + startDate + "\nEnd Date: " + endDate + "\nRemote? " + 
                        isRemote + "\nOpen? " + isOpen + "\nPay: " + lowPay + "-" + highPay;
        return ret;
    }

    public UUID getID() {
        return id;
    }

    public String getEmployerTitle() {
        return employerTitle;
    }

    public String getPositionTitle() {
        return posTitle;
    }
}
