public class Reference {
    private String name;
    private String relationship;
    private String email;
    private String phone;
    private boolean resume;

    public String toString() {
        if(resume)
            return "Name: " + name + "\n" + "Relationship: " + relationship + "\n" + "Email: " + email + "\n" + "Phone: " + phone + "\n";
        return "";
    }
}
