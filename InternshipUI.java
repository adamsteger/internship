import java.util.Scanner;

public class InternshipUI {
    private static final String WELCOME_MESSAGE = "Welcome to our UrTern";
    private String[] startMenuOptions = { "Sign in as Admin", "Sign in as Student", "Sign in as Employee",
            "Create Student account", "Create Employee account" };
    private String[] studentHomeOptions = { "See/Edit Educations", "See/Edit Extra Curriculars",
            "See/Edit Work Experiences", "See/Edit Honors", "See/Edit References", "See/Edit Contact Information",
            "Browse Internship Posts" };
    private String[] employeeHomeOptions = { "See/Edit internship posts", "See Reviews", "Leave Review on a Student" };
    private String[] adminHomeOptions = { "Delete Post", "Delete Review", "Deletion History" };
    private Scanner scanner;

    InternshipUI() {
        scanner = new Scanner(System.in);
    }

    private int getUserOpt(int numOfOpts) {
        System.out.print("\nWhat would you like to do?: ");

        String input = scanner.nextLine();
        int command = Integer.parseInt(input) - 1;

        if (command >= 0 && command <= numOfOpts - 1)
            return command;

        return -1;
    }

    private void displayStartMenu() {
        System.out.println("~~" + WELCOME_MESSAGE + "~~" + "\n");
        for (int i = 0; i < startMenuOptions.length; i++) {
            System.out.println("    " + (i + 1) + ". " + startMenuOptions[i]);
        }

        int userOpt = getUserOpt(startMenuOptions.length);
        // TODO exicute user opt

    }

    private void displayStudentHome(Student student) {
        // String skills;
        // // student.getSkills() may return a hashtable, not array
        // for(int i=0; i<student.getSkills().size() - 1 ; i++){
        // skills += (student.getSkills().get(i) + ", ");
        // }
        // skills += (student.getSkills().get(student.getSkills().size()));

        // System.out.println("~~" + student.getUsername() + "~~" + "\n");

        // System.out.println("Email: " + student.getEmail());
        // System.out.println("Phone: " + student.getPhone());
        // System.out.println("Rating: " + student.getRating() + "/5 stars");
        // System.out.println("Skill(s): " + skills);
        // // TODO Print year and school, Ex: Senior at University of South Carolina
        // System.out.println("ExtraCurricular(s): " +
        // student.getExtraCurriculars().size());
        // System.out.println("Work Experience(s): " +
        // student.getWorkExperiences().size());
        // System.out.println("Honor(s): " + student.getHonors().size());
        // System.out.println("Reference(s): " + student.getReferences().size());

        System.out.println("\nWhat would you like to do?");
        for (int i = 0; i < studentHomeOptions.length; i++) {
            System.out.println("    " + (i + 1) + ". " + studentHomeOptions[i]);
        }

        int userOpt = getUserOpt(studentHomeOptions.length);
        // TODO exicute user opt

    }

    private void displayEmployeeHome(Employer employer) {
        // System.out.println("~~" + employer.getUsername() + "~~" + "\n");
        // // TODO Print Logo

        // System.out.println(employer.getMission() + "\n");

        // System.out.println("Email: " + employer.getEmail());
        // System.out.println("Rating: " + employer.getRating() + "/5 stars");
        // System.out.println("Location: " + employer.getLocation());
        // System.out.println("Post(s): " + employer.getPosts().size());

        System.out.println("\nWhat would you like to do?");
        for (int i = 0; i < employeeHomeOptions.length; i++) {
            System.out.println("    " + (i + 1) + ". " + employeeHomeOptions[i]);
        }

        int userOpt = getUserOpt(employeeHomeOptions.length);
        // TODO exicute user opt

    }

    private void displayAdminHome(Admin admin) {
        // System.out.println("~~" + admin.getUsername() + "~~" + "\n");

        System.out.println("\nWhat would you like to do?");
        for (int i = 0; i < adminHomeOptions.length; i++) {
            System.out.println("    " + (i + 1) + ". " + adminHomeOptions[i]);
        }

        int userOpt = getUserOpt(adminHomeOptions.length);
        // TODO exicute user opt

    }

    public static void main(String[] args) {
        InternshipUI iUI = new InternshipUI();

        iUI.displayStartMenu();
    }

}
