import java.time.chrono.IsoChronology;
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

    public InternshipPost(String employerTitle, String posTitle, String description, String location, ArrayList<Skill> skillReq, String startDate, String endDate, boolean isRemote, boolean isOpen, int lowPay, int highPay) {
        this.id = UUID.randomUUID();
        this.posTitle = posTitle;
        this.employerTitle = employerTitle;
        this.description = description;
        this.location = location;
        this.skillReq = skillReq;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isRemote = isRemote;
        this.isOpen = isOpen;
        this.lowPay = lowPay;
        this.highPay = highPay;
        applicants = new ArrayList<Student>();
    }

    public InternshipPost(UUID id, String employerTitle, String posTitle, String description, String location, String startDate, String endDate, boolean isRemote, boolean isOpen, int lowPay, int highPay, ArrayList<Skill> skills) {
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
        this.skillReq = skills;
        applicants = new ArrayList<Student>();
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

    public void setApplicants(ArrayList<Student> applicants) {
        this.applicants = applicants;
    }

    public UUID getUUID() {
        return id;
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

    public boolean contains(String keyword){
        return false;
    }
    
    public String toString() {
        String ret = "\nEmployer: " + employerTitle + "\nPosition Title: " + posTitle + "\nDescription: " + description +
                        "\nLocation: " + location + "\nStart Date: " + startDate + "\nEnd Date: " + endDate + "\nRemote? " + 
                        isRemote + "\nOpen? " + isOpen + "\nPay: " + lowPay + "-" + highPay + "\nSkills Required: ";
        for (Skill skill : skillReq) {
            ret += skill + "\t";
        }
        ret += "\nApplicants: ";
        for (Student student : applicants) {
            ret += "\n\tName: " + student.getName() + "\tGraduation Year: " + student.getGradYear();
        }
        return ret;
    }

}
