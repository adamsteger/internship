import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;

import javax.tools.DocumentationTool.Location;

public class InternshipUI {
    private InternshipApplication internApp = new InternshipApplication();
    private static final String WELCOME_MESSAGE = "Welcome to our UrTern";
    private String[] startMenuOptions = { "Sign in as Admin", "Sign in as Student", "Sign in as Employer",
            "Create Student account", "Create Employer account" };
    private String[] studentHomeOptions = { "Sign out", "See/Edit Educations", "See/Edit Extra Curriculars",
            "See/Edit Work Experiences", "See/Edit Honors", "See/Edit Courses", "See/Edit Skills", "See Resume",
            "Browse Internship Posts" };
    private String[] employerHomeOptions = { "Sign out", "See/Edit internship posts", "See Reviews",
            "Leave Review on a Student" };
    private String[] studentInternshipOptions = { "Go Home", "Sort by Pay", "Filter by Loction",
            "Filter By position Title", "Filter By Company Name", "Filter By skill", "Apply to a listing" };
    private String[] SeeEditInternshipsOptions = { "Go Back to Home", "Add Post", "Edit Post" };
    private String[] adminHomeOptions = { "Sign out", "Delete Post", "Delete Review" };
    private Scanner scanner;
    private String[] skills = { "JAVA", "C", "PYTHON", "CPP", "VBNET", "CPOUND", "PHP", "JAVASCRIPT", "SQL",
            "OBJECTIVEC", "RUBY", "MATLAB", "SWIFT", "GO", "PERL", "R", "HTML" };

    InternshipUI() {
        scanner = new Scanner(System.in);
        int userOpt = getUserOpt(startMenuOptions.length);
        executeStartOpt(userOpt);
    }

    private void run() {

        displayStartMenu();

    }

    private int getUserOpt(int numOfOpts) {
        while (true) {
            System.out.print("\nWhat would you like to do?: ");

            String input = scanner.nextLine();
            int command = Integer.parseInt(input);

            if (command >= 0 && command <= numOfOpts - 1) {
                return command;
            } else {
                System.out.print("Invalid input. Please Try again");
            }
        }

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
    }

    private void displayStudentHome(Student student) {
        System.out.println("~~ " + student.getName() + " ~~\n");

        System.out.println("Email: " + student.getEmail());
        System.out.println("Phone: " + student.getPhone());
        System.out.println("Rating: " + student.getRating() + "/5 stars");
        // System.out.println("Skill(s): " + skills.size());
        System.out.println("Educations(s): " + student.getResume().getEducations().size());

        System.out.println("ExtraCurricular(s): " + student.getResume().getExtracurriculars().size());
        System.out.println("Work Experience(s): " + student.getResume().getWork().size());
        System.out.println("Honor(s): " + student.getResume().getHonors().size());

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
        ArrayList<InternshipPost> posts = employer.getPosts();
        for (InternshipPost post : posts) {
            System.out.println(post + "\n");
        }

    }

    private void displayStudentInternships(Student student, ArrayList<InternshipPost> posts) {

        for (int i = 0; i < posts.size(); i++) {
            System.out.println((i + 1) + ". " + posts.get(i).toString());
        }

        System.out.println("\nWhat would you like to do?");
        for (int i = 1; i < studentInternshipOptions.length; i++) {
            System.out.println("    " + (i) + ". " + studentInternshipOptions[i]);
        }
        System.out.println("    " + ("0") + ". " + studentInternshipOptions[0]);

        int userOpt = getUserOpt(studentInternshipOptions.length);
        executeStudentInternshipOpt(student, userOpt);

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
        // opt--;
        // System.out.println(opt);
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
        Resume res = student.getResume();
        Enumeration<String> enuStr;
        Enumeration<Skill> enuSkill;
        int i;
        switch (opt) {
        case (0):// Sign Out
            System.out.println("Logging out..\nGood Bye");
            displayStartMenu();
            // restart run method instead?

        case (1):// See/Edit Educations
            for (i = 0; i < res.getEducations().size(); i++) {
                System.out.println((i + 1) + ". ");
                System.out.println(res.getEducations().get(i).toString());
            }
            editEducation(student);

        case (2):// See/Edit Extra Curriculars
            for (i = 0; i < res.getExtracurriculars().size(); i++) {
                System.out.println((i + 1) + ". ");
                System.out.println(res.getExtracurriculars().get(i).toString());
            }
            editExtraCurr(student);

        case (3):// See/Edit Work Experiences
            for (i = 0; i < res.getWork().size(); i++) {
                System.out.println((i + 1) + ". ");
                System.out.println(res.getWork().get(i).toString());
            }
            editWorkExp(student);

        case (4):// See/Edit Honors
            for (i = 0; i < res.getHonors().size(); i++) {
                System.out.println((i + 1) + ". ");
                System.out.println(res.getHonors().get(i).toString());
            }

        case (5):// See/Edit Courses
            enuStr = res.getCourses().keys();
            i = 1;
            while (enuStr.hasMoreElements()) {
                System.out.println(i + ". " + enuStr.nextElement());
                i++;
            }
            editCourse(student);

        case (6):// See/Edit Skills
            enuSkill = res.getSkills().keys();
            i = 1;
            while (enuSkill.hasMoreElements()) {
                System.out.println(i + ". " + enuSkill.nextElement());
                i++;
            }
            editSkill(student);

        case (7):// See Resume
            res.toString();

        case (8):// Browse Internship Posts
            ArrayList<InternshipPost> posts = internApp.getInternships();
            displayStudentInternships(student, posts);

        }

        displayStudentHome(student);

    }

    private void executeStudentInternshipOpt(Student student, int opt) {
        // "Go Home", "Sort by Pay", "Filter by Loction", "Filter By position Title",
        // "filter By Company Name"};
        ArrayList<InternshipPost> posts = new ArrayList<InternshipPost>();
        switch (opt) {
        case (0):// Go Home
            displayStudentHome(student);
        case (1):// Sort by Pay
            System.out.println("Enter desired Wage: ");
            int pay = scanner.nextInt();
            scanner.nextLine();
            posts = internApp.filterByPay(pay);
            displayStudentInternships(student, posts);
        case (2):// Filter by Loction INClude Remote
            System.out.println("Enter Location (enter \"remote\" for remote jobs): ");
            if (scanner.nextLine().equalsIgnoreCase("remote")) {
                posts = internApp.filterByRemote(true);
                displayStudentInternships(student, posts);
            } else {
                posts = internApp.filterByLocation(scanner.nextLine());
                displayStudentInternships(student, posts);
            }
        case (3):// Filter By position Title
            System.out.println("Enter Position title: ");
            posts = internApp.filterByPosTitle(scanner.nextLine());
            displayStudentInternships(student, posts);
        case (4):// filter By Company Name
            System.out.println("Enter Company Name: ");
            posts = internApp.filterByEmployerTitle(scanner.nextLine());
            displayStudentInternships(student, posts);

        case (5):// Filter By skill
            System.out.println("Enter one of the following to filter for ");
            for (String skill : skills) {
                System.out.println(skill);
            }
            System.out.println("\nSkill: ");
            Skill skill = Skill.valueOf(scanner.nextLine());
            posts = internApp.filterByLanguage(skill);
            displayStudentInternships(student, posts);

        case (6):// view listing
            System.out.println("Which listing would you like to apply to?");
            int temp = scanner.nextInt() - 1;
            scanner.nextLine();
            // Apply to posts.get(temp);
            posts.get(temp).toString();// for testing purposes
        }
    }

    private void executeEmployerHomeOpt(Employer employer, int opt) {

        switch (opt) {
        case (0):// Sign Out
            System.out.println("Logging out..\nGood Bye");
            displayStartMenu();
        case (1):// See/Edit internship posts
            System.out.println("Internship Posts: ");
            ArrayList<InternshipPost> posts = internApp.getInternships(employer);
            for (InternshipPost post : posts) {
                System.out.println(post);
            }
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
            addWorkExp(num);
        }

        System.out.print("Would you like to add Education(s)?");
        if (yesNo()) {
            System.out.println("How many: ");
            int num = scanner.nextInt();
            scanner.nextLine();
            addEducation(num);
        }

        System.out.print("Would you like to add Course(s)?");
        if (yesNo()) {
            System.out.println("How many: ");
            int num = scanner.nextInt();
            scanner.nextLine();
            addCourse(num);
        }

        System.out.print("Would you like to add Extracurricular(s)?");
        if (yesNo()) {
            System.out.println("How many: ");
            int num = scanner.nextInt();
            scanner.nextLine();
            addExtracurricular(num);
        }

        System.out.print("Would you like to add Honor(s)?");
        if (yesNo()) {
            System.out.println("How many: ");
            int num = scanner.nextInt();
            scanner.nextLine();
            addHonor(num);
        }

        System.out.print("Would you like to add Skill(s)?");
        if (yesNo()) {
            System.out.println("How many: ");
            int num = scanner.nextInt();
            scanner.nextLine();
            addSkill(num);
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

    private void addWorkExp(int num) {
        for (int i = 0; i < num; i++) {
            String title, position, location, startDate, endDate;
            boolean resume;
            ArrayList<String> description = new ArrayList<String>();

            System.out.println("~~ADD WORK EXPERIENCE~~\n");

            System.out.println("Company Name: ");
            title = scanner.nextLine();

            System.out.println("Job Title: ");
            position = scanner.nextLine();

            System.out.println("Location: ");
            location = scanner.nextLine();

            System.out.println("Start Date(mm/dd/yyyy): ");
            startDate = scanner.nextLine();

            System.out.println("End Date(mm/dd/yyyy): ");
            endDate = scanner.nextLine();

            System.out.println("Would you like to add descriptions? ");
            if (yesNo()) {
                System.out.println("How many would you like to add?");
                int works = scanner.nextInt();
                for (int j = 0; j < works; j++) {
                    System.out.println("Enter description " + (j + 1) + ":");
                    description.add(scanner.nextLine());
                }
            }

            System.out.print("Add this to Resume?");
            resume = yesNo();

            WorkExperience work = new WorkExperience(position, title, location, startDate, endDate, resume,
                    description);
            internApp.addWorkExperience(work);
        }
    }

    private void addEducation(int num) {
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
        ArrayList<Skill> skillReq = new ArrayList<Skill>();
        System.out.println("~~NEW INTERNSHIP POST~~\n");
        System.out.println("Enter position title: ");
        String posTitle = scanner.nextLine();
        System.out.println("Enter a description: ");
        String description = scanner.nextLine();
        System.out.println(
                "Would you like to enter skill requirements from the following?\nType \'yes\' or \'no\'\n" + skills);
        if (yesNo()) {
            System.out.println("How many skills would you like to add?");
            int number = scanner.nextInt();
            if (number >= 1 && number <= 17) {
                for (int i = 0; i < number; i++) {
                    System.out.println("Skill requirement " + (i + 1) + ": ");
                    Skill reqSkill = Skill.valueOf(scanner.nextLine());
                    skillReq.add(reqSkill);
                }
            } else {
                System.out.println("Invalid input");
                System.exit(0); // maybe change this to a loop later
            }
        }
        System.out.println("Enter start date with the format MM/DD/YY: ");
        String startDate = scanner.nextLine();
        System.out.println("Enter end date with the format MM/DD/YY: ");
        String endDate = scanner.nextLine();
        System.out.println("Is this internship remote? Type \'yes\' or \'no\': ");
        String remote = scanner.nextLine();
        boolean isRemote = false;
        if (yesNo()) {
            isRemote = true;
        }
        System.out.println("Is this internship currently open? Type \'yes\' or \'no\': ");
        boolean isOpen = false;
        if (yesNo()) {
            isOpen = true;
        }
        System.out.println("Enter a low pay for the internship: ");
        int lowPay = scanner.nextInt();
        System.out.println("Enter a high pay for the internship: ");
        int highPay = scanner.nextInt();
        internApp.addInternship(employer.getTitle(), posTitle, description, employer.getLocation(), skillReq, startDate,
                endDate, isRemote, isOpen, lowPay, highPay);

    }

    private void addSkill(int num) {
        for (int i = 0; i < num; i++) {
            boolean resume;
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

    private void addCourse(int num) {
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

    private void addExtracurricular(int num) {
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

    private void addHonor(int num) {

        for (int i = 0; i < num; i++) {
            String title, organization, description;
            int date;

            boolean resume;

            System.out.println("~~ADD HONOR~~\n");

            System.out.println("Organization Name: ");
            organization = scanner.nextLine();

            System.out.println("Honor Title: ");
            title = scanner.nextLine();

            System.out.println("Descrition: ");
            description = scanner.nextLine();

            System.out.println("Year Recieved: ");
            date = scanner.nextInt();

            System.out.print("Add this to Resume?");
            resume = yesNo();

            Honor honor = new Honor(title, organization, description, date, resume);

            internApp.addHonor(honor);
        }
    }

    private void editWorkExp(Student student) {

        System.out.println("    1. Remove a Work Experience");
        System.out.println("    2. Add a Work Experience");
        System.out.println("    0. Go Home");

        switch (getUserOpt(3)) {
        case (0):
            displayStudentHome(student);
        case (1):

            System.out.println("Which Work Experience would you like to remove?");
            int temp = scanner.nextInt() - 1;
            scanner.nextLine();
            internApp.removeWorkExperience(student.getResume().getWork().get(temp));

        case (2):
            System.out.println("How many: ");
            int num = scanner.nextInt();
            scanner.nextLine();
            addWorkExp(num);
        }

    }

    private void editEducation(Student student) {

        System.out.println("    1. Remove an Education");
        System.out.println("    2. Add an Education");
        System.out.println("    0. Go Home");

        switch (getUserOpt(3)) {
        case (0):
            displayStudentHome(student);
        case (1):

            System.out.println("Which Education would you like to remove?");
            int temp = scanner.nextInt() - 1;
            scanner.nextLine();
            internApp.removeEducation(student.getResume().getEducations().get(temp));

        case (2):
            System.out.println("How many: ");
            int num = scanner.nextInt();
            scanner.nextLine();
            addEducation(num);
        }

    }

    private void editExtraCurr(Student student) {

        System.out.println("    1. Remove an Extracurricular");
        System.out.println("    2. Add an Extracurricular");
        System.out.println("    0. Go Home");

        switch (getUserOpt(3)) {
        case (0):
            displayStudentHome(student);
        case (1):

            System.out.println("Which Extracurricular would you like to remove?");
            int temp = scanner.nextInt() - 1;
            scanner.nextLine();
            internApp.removeExtracurricular(student.getResume().getExtracurriculars().get(temp));

        case (2):
            System.out.println("How many: ");
            int num = scanner.nextInt();
            scanner.nextLine();
            addExtracurricular(num);
        }

    }

    private void editCourse(Student student) {

        System.out.println("    1. Remove a Course");
        System.out.println("    2. Add a Course");
        System.out.println("    0. Go Home");

        switch (getUserOpt(3)) {
        case (0):
            displayStudentHome(student);
        case (1):

            System.out.println("Which Course would you like to remove?(case senseitive)");
            String temp = scanner.nextLine();
            internApp.removeCourse(temp);

        case (2):
            System.out.println("How many: ");
            int num = scanner.nextInt();
            scanner.nextLine();
            addCourse(num);
        }

    }

    private void editHonor(Student student) {

        System.out.println("    1. Remove a Honor");
        System.out.println("    2. Add a Honor");
        System.out.println("    0. Go Home");

        switch (getUserOpt(3)) {
        case (0):
            displayStudentHome(student);
        case (1):

            System.out.println("Which Honor would you like to remove?");
            int temp = scanner.nextInt() - 1;
            scanner.nextLine();
            internApp.removeHonor(student.getResume().getHonors().get(temp));

        case (2):
            System.out.println("How many: ");
            int num = scanner.nextInt();
            scanner.nextLine();
            addHonor(num);
        }

    }

    private void editSkill(Student student) {

        System.out.println("    1. Remove a Skill");
        System.out.println("    2. Add a Skill");
        System.out.println("    0. Go Home");

        switch (getUserOpt(3)) {
        case (0):
            displayStudentHome(student);
        case (1):

            System.out.println("Which Skill would you like to remove?(case senseitive)");
            String temp = scanner.nextLine();
            Skill skill = Skill.valueOf(temp);
            internApp.removeSkill(skill);

        case (2):
            System.out.println("How many: ");
            int num = scanner.nextInt();
            scanner.nextLine();
            addSkill(num);
        }

    }

    public static void main(String[] args) {
        InternshipUI iUI = new InternshipUI();

        iUI.displayStartMenu();
    }
}
