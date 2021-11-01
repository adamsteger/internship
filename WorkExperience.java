import java.util.ArrayList;

public class WorkExperience {
    private String posTitle;
    private String employerTitle;
    private String startDate;
    private String endDate;
    private boolean resume;
    private ArrayList<String> description;
    private String location;

    public WorkExperience(String posTitle, String employerTitle, String location, String startDate, String endDate, boolean resume, ArrayList<String> description) {
        this.posTitle = posTitle;
        this.employerTitle = employerTitle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.resume = resume;
        this.description = description;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public ArrayList<String> getDescription() {
        return description;
    }

    public String getPosTitle() {
        return posTitle;
    }

    public String getEmployerTitle() {
        return employerTitle;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public boolean getResume() {
        return resume;
    }

    public String toString() {
        String ret = "";
        if (resume)
            ret += employerTitle + "\n" + posTitle + "\n" + startDate + "-" + endDate + "\n";
        for (String string : description) {
            ret += "\n\t" + string;
        }
        return ret;
    }
}
