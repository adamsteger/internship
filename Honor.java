public class Honor {
    private String title;
    private String organization;
    private String description;
    private int year;
    private boolean resume;

    public Honor(String title, String organization, String description, int year, boolean resume) {
        this.title = title;
        this.organization = organization;
        this.description = description;
        this.year = year;
        this.resume = resume;
    }

    public String getTitle() {
        return this.title;
    }

    public String getOrganization() {
        return this.organization;
    }

    public String getdescription() {
        return this.description;
    }

    public int getYear() {
        return this.year;
    }

    public Boolean getResume() {
        return this.resume;
    }

    public String toString() {
        if (resume)
            return this.title + "\n" + this.year + "\n" + this.organization + "\n" + this.description + "\n";
        return "";
    }
}
