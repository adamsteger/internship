public class Education {
    private String schoolTitle;
    private String location;
    private String major;
    private int gradYear;
    private boolean resume;

    public Education(String schoolTitle, String location, String major, int gradYear, boolean resume) {
        this.schoolTitle = schoolTitle;
        this.location = location;
        this.major = major;
        this.gradYear = gradYear;
        this.resume = resume;
    }

    public String getSchoolTitle() {
        return this.schoolTitle;
    }

    public String getLocation() {
        return this.location;
    }

    public String getMajor() {
        return this.major;
    }

    public int getGradYear() {
        return this.gradYear;
    }

    public Boolean getResume() {
        return this.resume;
    }

    public String toString() {
        if(resume)
            return this.schoolTitle + "\n" + this.location + "\n" + this.major + "\n" + this.gradYear + "\n";
        return "";
    }
}
