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
    /**
     * Constructor for a new InternshipPost
     * @param everything but UUID to construct new InternshipPost
     */
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
    /**
     * Constructor for an already defined InternshipPost by UUID
     * @param all constructor values including an already defined UUID
     */
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
    /**
     * @return employerTitle
     */
    public String getEmployerTitle() {
        return employerTitle;
    }
    /**
     * @return posTitle
     */
    public String getPosTitle() {
        return posTitle;
    }
    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @return location
     */
    public String getLocation() {
        return location;
    }
    /**
     * @return skillReq
     */
    public ArrayList<Skill> getSkillReq() {
        return skillReq;
    }
    /**
     * @return startDate
     */
    public String getStartDate() {
        return startDate;
    }
    /**
     * @return endDate
     */
    public String getEndDate() {
        return endDate;
    }
    /**
     * @return isRemote
     */
    public boolean getRemote() {
        return isRemote;
    }
    /**
     * @return isOpen
     */
    public boolean getOpen() {
        return isOpen;
    }
    /**
     * @return lowPay
     */
    public int getLowPay() {
        return lowPay;
    }
    /**
     * @return highPay
     */
    public int getHighPay() {
        return highPay;
    }
    /**
     * @return applicants
     */
    public ArrayList<Student> getApplicants() {
        return applicants;
    }
    /**
     * @param sets applicants
     */
    public void setApplicants(ArrayList<Student> applicants) {
        this.applicants = applicants;
    }
    /**
     * @return UUID
     */
    public UUID getUUID() {
        return id;
    }
    /**
     * sets employerTitle and creates new arrayList of skills if defined with no arguments
     */
    public InternshipPost() {
        this.employerTitle = "";
        skillReq = new ArrayList<Skill>();
    }
    /**
     * @param skill
     * @return ArrayList of Students with skill
     */
    public ArrayList<Student> filterBySkill(Skill skill) {
        return new ArrayList<Student>();
    }
    /**
     * @param lowGPA
     * @return ArrayList of Students with GPA
     */
    public ArrayList<Student> filterByGPA(float lowGPA) {
        return new ArrayList<Student>();
    }
    /**
     * @param gradYear
     * @return ArrayList of Students with specified gradYear
     */
    public ArrayList<Student> filterByGradYear(int gradYear) {
        return new ArrayList<Student>();
    }
    /**
     * @param major
     * @return ArrayList of Students with specified major
     */
    public ArrayList<Student> filterByMajor(String major) {
        return new ArrayList<Student>();
    }
    /**
     * @param keyword
     * @return boolean if contains keyword
     */
    public boolean contains(String keyword){
        return false;
    }
    /**
     * Returns the string with values of InternshipPost
     */
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
