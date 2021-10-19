public class Education {
    private String schoolTitle;
    private String location;
    private String major;
    private int gradYear;
    private boolean resume;

    public Education(String schoolTitle, String location, String major, int gradYear) {
        this.schoolTitle = schoolTitle;
        this.location = location;
        this.major = major;
        this.gradYear = gradYear;
    }

    public String toString() {
        if(resume)
            return this.schoolTitle + "\n" + this.location + "\n" + this.major + "\n" + this.gradYear + "\n";
        return "";
    }
}
