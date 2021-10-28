import java.util.Scanner;
import java.util.UUID;

public class InternshipUI {
    private InternshipApplication internApp = new InternshipApplication();
    private static final String WELCOME_MESSAGE = "Welcome to our UrTern";
    private String[] startMenuOptions = { "Sign in as Admin", "Sign in as Student", "Sign in as Employer",
            "Create Student account", "Create Employer account" };
    private String[] studentHomeOptions = { "Sign out", "See/Edit Educations", "See/Edit Extra Curriculars",
            "See/Edit Work Experiences", "See/Edit Honors", "See/Edit Contact Information", "See/Edit Resume",
            "Browse Internship Posts" };
    private String[] employerHomeOptions = { "Sign out", "See/Edit internship posts", "See Reviews",
            "Leave Review on a Student" };
    private String[] SeeEditInternshipsOptions = { "Go Back to Home", "Add Post", "Edit Post" };
    private String[] adminHomeOptions = { "Sign out", "Delete Post", "Delete Review", "Deletion History" };
    private Scanner scanner;
    private int prevPage;// ??????

    InternshipUI() {
        scanner = new Scanner(System.in);

    }

    private void run() {

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

        executeStartOpt(userOpt);

    }

    private void displayStudentHome(Student student) {
        System.out.println("~~ " + student.getFirstName() + student.getLastName() + " ~~\n");

        System.out.println("Email: " + student.getEmail());
        System.out.println("Phone: " + student.getPhone());
        System.out.println("Rating: " + student.getRating() + "/5 stars");
        // System.out.println("Skill(s): " + skills.size());
        // System.out.println("Educations(s): " + student.getEducations().size();

        // System.out.println("ExtraCurricular(s): " +
        // student.getExtraCurriculars().size();
        // System.out.println("Work Experience(s): " +
        // student.getWorkExperiences().size();
        // System.out.println("Honor(s): " + student.getHonors().size();

        System.out.println("\nWhat would you like to do?");
        for (int i = 1; i < studentHomeOptions.length; i++) {
            System.out.println("    " + (i) + ". " + studentHomeOptions[i]);
        }
        System.out.println("    " + ("0") + ". " + studentHomeOptions[0]);

        int userOpt = getUserOpt(studentHomeOptions.length);
        executeStudentHomeOpt(student, userOpt);
    }

    private void displayEmployerHome(Employer employer) {
        System.out.println("~~ " + employer.getUsername() + " ~~\n");

        System.out.println(employer.getMission() + "\n");

        System.out.println("Email: " + employer.getEmail());
        System.out.println("Rating: " + employer.getRating() + "/5 stars");
        System.out.println("Location: " + employer.getLocation());
        System.out.println("Post(s): " + employer.getPosts().size());

        System.out.println("\nWhat would you like to do?");
        for (int i = 1; i < employerHomeOptions.length; i++) {
            System.out.println("    " + (i) + ". " + employerHomeOptions[i]);
        }
        System.out.println("    " + ("0") + ". " + studentHomeOptions[0]);

        int userOpt = getUserOpt(employerHomeOptions.length);
        executeEmployerHomeOpt(employer, userOpt);

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
        executeAdminHomeOpt(admin, userOpt);

    }

    private void executeStartOpt(int opt) {
        opt--;
        switch (opt) {
        case (0):// Sign in as Admin
            displayAdminHome(adminSignIn());
        case (1):// Sign in as Student
            displayStudentHome(studentSignIn());
        case (2):// Sign in as Employer
            displayEmployerHome(employerSignIn());
        case (3):// Create Student account
            displayStudentHome(createStudent());
        case (4):// Create Employer account
            displayEmployerHome(createEmployer());
        }

    }

    private void executeStudentHomeOpt(Student student, int opt) {
        switch (opt) {
        case (0):// Sign Out
            System.out.println("Logging out..\nGood Bye");
            displayStartMenu();
        case (1):// See/Edit Educations

        case (2):// See/Edit Extra Curriculars

        case (3):// See/Edit Work Experiences

        case (4):// See/Edit Honors

        case (5):// See/Edit Contact Information

        case (6):// See/Edit Resume

        case (7):// Browse Internship Posts

        }

    }

    private void executeEmployerHomeOpt(Employer employer, int opt) {

        switch (opt) {
        case (0):// Sign Out
            System.out.println("Logging out..\nGood Bye");
            displayStartMenu();
        case (1):// See/Edit internship posts

        case (2):// See Reviews

        case (3):// Leave Review on a Student

        }

    }

    private void executeAdminHomeOpt(Admin admin, int opt) {

        switch (opt) {
        case (0):// Sign Out
            System.out.println("Logging out..\nGood Bye");
            displayStartMenu();
        case (1):// Delete Post

        case (2):// Delete Review

        case (3):// Deletion History

        }

    }

    private Admin adminSignIn() {
        String userName = null;
        String pass = null;
        Admin admin;
        while (true) {
            System.out.println("~~ Admin Sign In ~~\n");
            System.out.println("Enter Username: ");
            userName = scanner.nextLine();

            System.out.println("Enter Password: ");
            pass = scanner.nextLine();

            admin = internApp.adminLogin(userName, pass);
            if (admin != null) {
                break;
            }
        }
        return admin;
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

            student = internApp.studentLogin(userName, pass);
            if (student != null) {
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

            employer = internApp.employerLogin(userName, pass);
            if (employer == null) {
                break;
            }
        }
        return employer;
    }

    private Student createStudent() {
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

        System.out.print("Add this GPA to Resume?");
        showGPA = yesNo();

        Student student = new Student(firstName, lastName, username, password, gradYear, email, address, phone, gpa,
                showGPA);

        internApp.createStudent(student);

        System.out.print("Would you like to add Work Experience(s)?");
        if (yesNo()) {
            System.out.println("How many: ");
            int num = scanner.nextInt();
            scanner.nextLine();
            addWorkExp(student, num);
        }

        System.out.print("Would you like to add Education(s)?");
        if (yesNo()) {
            System.out.println("How many: ");
            int num = scanner.nextInt();
            scanner.nextLine();
            addEducation(student, num);
        }

        System.out.print("Would you like to add Course(s)?");
        if (yesNo()) {
            System.out.println("How many: ");
            int num = scanner.nextInt();
            scanner.nextLine();
            addCourse(student, num);
        }

        System.out.print("Would you like to add Extracurricular(s)?");
        if (yesNo()) {
            System.out.println("How many: ");
            int num = scanner.nextInt();
            scanner.nextLine();
            addExtracurricular(student, num);
        }

        System.out.print("Would you like to add Honor(s)?");
        if (yesNo()) {
            System.out.println("How many: ");
            int num = scanner.nextInt();
            scanner.nextLine();
            addHonor(student, num);
        }

        System.out.print("Would you like to add Skill(s)?");
        if (yesNo()) {
            System.out.println("How many: ");
            int num = scanner.nextInt();
            scanner.nextLine();
            addSkill(student, num);
        }

        return student;

    }

    private Employer createEmployer() {
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

        Employer employer = new Employer(title, username, password, email, location, mission);

        internApp.createEmployer(employer);

        return employer;
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
            System.out.println("Create a Password(8-20 Characters): ");
            password = scanner.nextLine();
            if (password.length() >= 8 && password.length() <= 20) {
                break;
            } else {
                System.out.println("Password must be 8-20 Characters long");
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
            internApp.addWorkExperience(work);
        }
    }

    private void addEducation(Student student, int num) {
        for (int i = 0; i < num; i++) {
            String title, location, major;
            int gradYear;
            boolean resume;

            System.out.println("~~ADD WORK EXPERIENCE~~\n");

            System.out.println("Institution : ");
            title = scanner.nextLine();

            System.out.println("Location : ");
            location = scanner.nextLine();

            System.out.println("Major : ");
            major = scanner.nextLine();

            System.out.println("Graduation Year: ");
            gradYear = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Add this to Resume?");
            resume = yesNo();

            Education edu = new Education(title, location, major, gradYear, resume);
            internApp.addEducation(edu);
        }

    }

    private void addIntershipPost(Employer employer) {
        System.out.println("~~NEW INTERNSHIP POST~~\n");

    }

    private void addSkill(Student student, int num) {
        for (int i = 0; i < num; i++) {
            boolean resume;
            String[] skills = { "JAVA", "C", "PYTHON", "CPP", "VBNET", "CPOUND", "PHP", "JAVASCRIPT", "SQL",
                    "OBJECTIVEC", "RUBY", "MATLAB", "SWIFT", "GO", "PERL", "R", "HTML" };
            System.out.println("Enter one of the following: ");
            for (String skill : skills) {
                System.out.println(skill);
            }

            System.out.println("\nSkill: ");
            Skill skill = Skill.valueOf(scanner.nextLine());

            System.out.print("Add this to Resume?");
            resume = yesNo();

            internApp.addSkill(skill, resume);
        }
    }

    private void addCourse(Student student, int num) {
        for (int i = 0; i < num; i++) {
            String course;
            boolean resume;

            System.out.print("Name of course: ");
            course = scanner.nextLine();

            System.out.print("Add this to Resume?");
            resume = yesNo();

            internApp.addCourse(course, resume);
        }
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

            internApp.addExtracurricular(excurr);
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

            internApp.addHonor(honor);
        }
    }

    public static void main(String[] args) {
        InternshipUI iUI = new InternshipUI();

        iUI.displayStartMenu();
    }

}
