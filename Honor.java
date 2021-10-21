public class Honor {
    private String title;
    private String organization;
    private String description;
    private String date;
    private boolean resume;

    public Honor(String title, String organization, String description, String date) {
        this.title = title;
        this.organization = organization;
        this.description = description;
        this.date = date;
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

    public String getDate() {
        return this.date;
    }

    public Boolean getResume() {
        return this.resume;
    }
    
    public String toString() {
        if(resume) 
            return this.title + "\n" + this.date + "\n" + this.organization + "\n" + this.description + "\n";
        return "";
    }
}
