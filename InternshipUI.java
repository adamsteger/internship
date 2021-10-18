import java.util.Scanner;

public class InternshipUI {
    private static final String WELCOME_MESSAGE = "Welcome to our UrTern";
    private String[] startMenuOptions = { "Sign in as Admin", "Sign in as Student", "Sign in as Employee","Create Student account", "Create Employee account"};
    private String[] StudentHomeOptions = {"See/Edit Educations", "See/Edit Extra Curriculars", "See/Edit Work Experiences", "See/Edit Honors", "See/Edit References", "See/Edit Contact Information", "Browse Internship Posts"};
    private String[] EmployeeHomeOptions = {"See/Edit internship posts", "See Reviews", "Leave Review on a Student"};
    private Scanner scanner;
    // private Internship internship;
    
    InternshipUI() {
            scanner = new Scanner(System.in);
            //internship = new InternshipLibrary();
        }


}

    
}