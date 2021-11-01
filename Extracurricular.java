/**
 * 
 */
public class Extracurricular {
    private String title;
    private String position;
    private String startDate;
    private String endDate;
    private boolean resume;

    public Extracurricular(String title, String position, String startDate, String endDate, boolean resume) {
        this.title = title;
        this.position = position;
        this.startDate = startDate;
        this.endDate = endDate;
        this.resume = resume;
    }

    public String getTitle() {
        return this.title;
    }

    public String getPosition() {
        return this.position;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public boolean getResume() {
        return this.resume;
    }

    public String toString() {
        if (resume)
            return title + "\n" + startDate + "-" + endDate + "\n" + position + "\n";
        return "";
    }
}
