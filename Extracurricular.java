public class Extracurricular {
    private String title;
    private String position;
    private String startDate;
    private String endDate;
    private boolean resume;

    public Extracurricular(String title, String position, String startDate, String endDate) {
        this.title = title;
        this.position = position;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public String toString() {
        if(resume)
            return title + "\n" + startDate + "-" + endDate + "\n" + position + "\n"; 
        return "";
    }
}
