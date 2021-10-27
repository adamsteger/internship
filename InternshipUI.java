import java.util.Scanner;
import java.util.UUID;

public class InternshipUI {
    private static final String WELCOME_MESSAGE = "Welcome to our UrTern";
    private String[] startMenuOptions = { "Sign in as Admin", "Sign in as Student", "Sign in as Employer",
            "Create Student account", "Create Employer account" };
    private String[] studentHomeOptions = { "Sign out", "See/Edit Educations", "See/Edit Extra Curriculars",
            "See/Edit Work Experiences", "See/Edit Honors", "See/Edit References", "See/Edit Contact Information",
            "See/Edit Resume", "Browse Internship Posts" };
    private String[] employerHomeOptions = { "Sign out", "See/Edit internship posts", "See Reviews",
            "Leave Review on a Student" };
    private String[] SeeEditInternshipsOptions = { "Go Back to Home", "Add Post", "Edit Post" };
    private String[] adminHomeOptions = { "Sign out", "Delete Post", "Delete Review", "Deletion History" };
    private Scanner scanner;
    private int prevPage;// ??????

    InternshipUI() {
        scanner = new Scanner(System.in);
    }

    private int getUserOpt(int numOfOpts) {
        System.out.print("\nWhat would you like to do?: ");

        String input = scanner.nextLine();
        int command = Integer.parseInt(input);

        if (command >= 0 && command <= numOfOpts - 1)
            return command;

        return -1;
    }

    private boolean yesNo() {
        boolean ret = true;
        while (ret) {
            System.out.println(" (Y/N): ");
            String ans = scanner.nextLine();
            if (!ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("n")) {
                System.out.println("Invalid Input.");
            } else if (ans.equalsIgnoreCase("y")) {
                break;
            } else {
                ret = false;
            }
        }
        return ret;
    }

    private void displayStartMenu() {
        System.out.println("~~ " + WELCOME_MESSAGE + " ~~\n");
        for (int i = 0; i < startMenuOptions.length; i++) {
            System.out.println("    " + (i + 1) + ". " + startMenuOptions[i]);
        }

        int userOpt = getUserOpt(startMenuOptions.length);
        // System.out.println(userOpt);
        // TODO exicute user opt

    }

    private void displayStudentHome(Student student) {
        // String skills;
        // // student.getSkills() may return a hashtable, not array
        // for(int i=0; i<student.getSkills().size() - 1 ; i++){
        // skills += (student.getSkills().get(i) + ", ");
        // }
        // skills += (student.getSkills().get(student.getSkills().size()));

        // System.out.println("~~ " + student.getUsername() + " ~~\n");

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
        for (int i = 1; i < studentHomeOptions.length; i++) {
            System.out.println("    " + (i) + ". " + studentHomeOptions[i]);
        }
        System.out.println("    " + ("0") + ". " + studentHomeOptions[0]);

        int userOpt = getUserOpt(studentHomeOptions.length);
        // TODO exicute user opt

    }

    private void displayEmployerHome(Employer employer) {
        // System.out.println("~~ " + employer.getUsername() + " ~~\n");
        // // TODO Print Logo

        // System.out.println(employer.getMission() + "\n");

        // System.out.println("Email: " + employer.getEmail());
        // System.out.println("Rating: " + employer.getRating() + "/5 stars");
        // System.out.println("Location: " + employer.getLocation());
        // System.out.println("Post(s): " + employer.getPosts().size());

        System.out.println("\nWhat would you like to do?");
        for (int i = 1; i < employerHomeOptions.length; i++) {
            System.out.println("    " + (i) + ". " + employerHomeOptions[i]);
        }
        System.out.println("    " + ("0") + ". " + studentHomeOptions[0]);

        int userOpt = getUserOpt(employerHomeOptions.length);
        // TODO exicute user opt

    }

    private void displayEmployerInternships(Employer employer) {
        System.out.println("~~ See/Edit My internship Post(s) ~~\n");

    }

    private void displayAdminHome(Admin admin) {
        // System.out.println("~~ " + admin.getUsername() + " ~~" + "\n");

        System.out.println("\nWhat would you like to do?");
        for (int i = 1; i < adminHomeOptions.length; i++) {
            System.out.println("    " + (i) + ". " + adminHomeOptions[i]);
        }
        System.out.println("    " + ("0") + ". " + studentHomeOptions[0]);

        int userOpt = getUserOpt(adminHomeOptions.length);
        // TODO exicute user opt

    }

    private void exicuteStartOpt(Student student, int opt) {
        opt--;
        switch (opt) {
        case (0):// Sign in as Admin
            adminSignIn();
        case (1):// Sign in as Student
            studentSignIn();
        case (2):// Sign in as Employer
            employerSignIn();
        case (3):// Create Student account
            createStudent();
        case (4):// Create Employer account
            createEmployer();
        }

    }

    private void exicuteStudentHomeOpt(Student student, int opt) {
        switch (opt) {
        case (0):// Sign Out
            System.out.println("Logging out..\nGood Bye");
            displayStartMenu();
        case (1):// See/Edit Educations

        case (2):// See/Edit Extra Curriculars

        case (3):// See/Edit Work Experiences

        case (4):// See/Edit Honors

        case (5):// See/Edit References

        case (6):// See/Edit Contact Information

        case (7):// See/Edit Resume

        case (8):// Browse Internship Posts

        }

    }

    private void exicuteEmployerHomeOpt(Student student, int opt) {

        switch (opt) {
        case (0):// Sign Out
            System.out.println("Logging out..\nGood Bye");
            displayStartMenu();
        case (1):// See/Edit internship posts

        case (2):// See Reviews

        case (3):// Leave Review on a Student

        }

    }

    private void exicuteAdminHomeOpt(Student student, int opt) {
        if (opt == 0) {// Sign Out
            System.out.println("Logging out..\nGood Bye");
            displayStartMenu();
        } else if (opt == 1) {// Delete Post

        } else if (opt == 2) {// Delete Review

        } else {// Deletion History

        }
    }

    private void adminSignIn() {
        boolean loop = true;
        String userName = null;
        String pass = null;
        while (loop) {
            System.out.println("~~ Admin Sign In ~~\n");
            System.out.println("Enter Username: ");
            userName = scanner.nextLine();
            // check if username is valid
            // if(!validUser){
            // continue;
            // }
            // for (int i = 0; i < PASS_ATTEMPTS; i++) {
            // if limitetd password attempts
            // }
            System.out.println("Enter Password: ");
            pass = scanner.nextLine();
            // check if password is valid
            // if(!correctPass(userName, pass)){
            // continue;
            // }
        }

        Admin admin = new Admin(userName, pass);
        displayAdminHome(admin);
    }

    private Student studentSignIn() {
        String userName = null;
        String pass = null;
        Student student;
        while (true) {
            System.out.println("~~ Student Sign In ~~\n");
            System.out.println("Enter Username: ");
            userName = scanner.nextLine();

            System.out.println("Enter Password: ");
            pass = scanner.nextLine();
            student = InternshipApplication.login(userName, pass);
            if (student == null) {
                break;
            }
        }
        return student;

    }

    private Employer employerSignIn() {
        String userName = null;
        String pass = null;
        Employer employer;
        while (true) {
            System.out.println("~~ Employer Sign In ~~\n");
            System.out.println("Enter Username: ");
            userName = scanner.nextLine();

            System.out.println("Enter Password: ");
            pass = scanner.nextLine();

            employer = InternshipApplication.login(userName, pass);
            if (employer == null) {
                break;
            }
        }

        return employer;
    }

    private void createStudent() {
        UUID id = null;// get new and random id
        String username, password, firstName, lastName, email, phone, address;
        double gpa;
        int gradYear;
        boolean showGPA;

        System.out.println("~~CREATE STUDENT ACCOUNT~~\n");
        username = createUsername();
        password = createPassword();

        System.out.println("Enter your first name: ");
        firstName = scanner.nextLine();

        System.out.println("Enter your last name: ");
        lastName = scanner.nextLine();

        System.out.println("Enter your email: ");
        email = scanner.nextLine();

        System.out.println("Enter your phone number: ");
        phone = scanner.nextLine();

        System.out.println("Enter your permanent address: ");
        address = scanner.nextLine();

        System.out.println("Enter your expected graduation Year: ");
        gradYear = scanner.nextInt();
        scanner.nextLine();

        System.out.println("What is your GPA: ");
        gpa = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Add this to Resume?");
        showGPA = yesNo();

        Student student = new Student(id, firstName, lastName, username, password, gradYear, email, address, phone, gpa,
                showGPA, -1, null, null);

        System.out.print("Would you like to add Work experience?");
        if (yesNo()) {
            System.out.println("How many: ");
            int num = scanner.nextInt();
            scanner.nextLine();
            addWorkExp(student, num);
        }

        System.out.print("Would you like to add Extracurriculars?");
        if (yesNo()) {
            System.out.println("How many: ");
            int num = scanner.nextInt();
            scanner.nextLine();
            addExtracurricular(student, num);
        }

        System.out.print("Would you like to add Honors?");
        if (yesNo()) {
            System.out.println("How many: ");
            int num = scanner.nextInt();
            scanner.nextLine();
            addHonor(student, num);
        }

        displayStudentHome(student);

    }

    private void createEmployer() {
        UUID id = null;
        String title, username, password, email, location, mission;

        System.out.println("~~CREATE EMPLOYER ACCOUNT~~\n");

        username = createUsername();
        password = createPassword();

        System.out.println("Enter your email: ");
        email = scanner.nextLine();

        System.out.println("Company Name: ");
        title = scanner.nextLine();

        System.out.println("Enter The Location of the Company HQ: ");
        location = scanner.nextLine();

        System.out.println("What is your Company's mission?: ");
        mission = scanner.nextLine();

        Employer employer = new Employer(id, title, username, password, email, -1, location, mission, null);

        displayEmployerHome(employer);
    }

    private String createUsername() {
        boolean loop = true;
        String userName = "";
        while (loop) {
            System.out.println("Create a Username(6-15 Characters): ");
            userName = scanner.nextLine();

            if (userName.length() >= 6 && userName.length() <= 15) {
                if (!validUser(userName)) {
                    loop = false; // do i need this?
                    break;// can this just be a return statement?
                } else {
                    System.out.println("This username already exists");
                }
            } else {
                System.out.println("The username must be 6-15 Characters long");
            }
        }
        return userName;
    }

    private boolean validUser(String userName) {
        return false;
    }

    private String createPassword() {
        boolean loop = true;
        String password = null;
        while (loop) {
            System.out.println("Create a Pasword(8-20 Characters): ");
            password = scanner.nextLine();
            if (password.length() >= 8 && password.length() <= 20) {
                break;
            } else {
                System.out.println("Passwoordd must be 8-20 Characters long");
                continue;
            }
        }
        return password;

    }

    private void addWorkExp(Student student, int num) {
        for (int i = 0; i < num; i++) {
            String title, position, startDate, endDate;
            boolean resume;

            System.out.println("~~ADD WORK EXPERIENCE~~\n");

            System.out.println("Company Name: ");
            title = scanner.nextLine();

            System.out.println("Job Title: ");
            position = scanner.nextLine();

            System.out.println("Start Date(mm/dd/yyyy): ");
            startDate = scanner.nextLine();

            System.out.println("End Date(mm/dd/yyyy): ");
            endDate = scanner.nextLine();

            System.out.print("Add this to Resume?");
            resume = yesNo();

            WorkExperience work = new WorkExperience(title, position, startDate, endDate, resume);

            // TODO add work to passed in student

        }
    }

    private void addEducation(Student student, int num) {

    }

    private void addIntershipPost(Employer employer) {
        System.out.println("~~NEW INTERNSHIP POST~~\n");

    }

    // private void addSkill(Student student, int num) {

    // }

    private void addCourse(Student student, int num) {

    }

    private void addExtracurricular(Student student, int num) {
        for (int i = 0; i < num; i++) {
            String title, position, startDate, endDate;
            boolean resume;

            System.out.println("~~ADD EXTRACURRICULAR~~\n");

            System.out.println("Organization: ");
            title = scanner.nextLine();

            System.out.println("Position: ");
            position = scanner.nextLine();

            System.out.println("Start Date(mm/dd/yyyy): ");
            startDate = scanner.nextLine();

            System.out.println("End Date(mm/dd/yyyy): ");
            endDate = scanner.nextLine();

            System.out.print("Add this to Resume?");
            resume = yesNo();

            Extracurricular excurr = new Extracurricular(title, position, startDate, endDate, resume);

            // TODO add excurr to passed in student
        }

    }

    private void addHonor(Student student, int num) {

        for (int i = 0; i < num; i++) {
            String title, organization, description, date;
            boolean resume;

            System.out.println("~~ADD HONOR~~\n");

            System.out.println("Organization Name: ");
            organization = scanner.nextLine();

            System.out.println("Honor Title: ");
            title = scanner.nextLine();

            System.out.println("Descrition: ");
            description = scanner.nextLine();

            System.out.println("Date Recieved(mm/dd/yyyy): ");
            date = scanner.nextLine();

            System.out.print("Add this to Resume?");
            resume = yesNo();

            Honor honor = new Honor(title, organization, description, date, resume);

            // TODO add honor to passed in Student

        }
    }

    private void addReference(Student student, int num) {

    }

    public static void main(String[] args) {
        InternshipUI iUI = new InternshipUI();

        iUI.displayStartMenu();
    }

}
