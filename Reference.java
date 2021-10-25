public class Reference {
    private String name;
    private String relationship;
    private String email;
    private String phone;
    private boolean resume;

    public Reference() {
        this.name = name;
        this.relationship = relationship;
        this.email = email;
        this.phone = phone;
        this.resume = resume;
    }

    public String getName() {
        return this.name;
    }

    public String getRelationship() {
        return this.relationship;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public boolean getResume() {
        return this.resume;
    }

    public String toString() {
        if(resume)
            return "Name: " + this.name + "\n" + "Relationship: " + this.relationship + "\n" + "Email: " + this.email + "\n" + "Phone: " + this.phone + "\n";
        return "";
    }
}
