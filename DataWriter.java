import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
	
	
	public static void saveStudents() {
		StudentList students = StudentList.getInstance();
		ArrayList<Student> studentList = students.getStudents();
		JSONArray JSONStudents = new JSONArray();

		for (int i = 0; i < studentList.size(); i++) {
			JSONStudents.add(getStudentJSON(studentList.get(i)));
		}

		try (FileWriter file = new FileWriter(STUDENT_FILE_NAME)) {
			file.write(JSONStudents.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void saveEmployers() {
		EmployerList employers = EmployerList.getInstance();
		ArrayList<Employer> employerList = employers.getEmployers();
		JSONArray JSONEmployers = new JSONArray();

		for (int i = 0; i < employerList.size(); i++) {
			JSONEmployers.add(getEmployerJSON(employerList.get(i)));
		}

		
		try (FileWriter file = new FileWriter(EMPLOYER_FILE_NAME)) {
			file.write(JSONEmployers.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void saveAdmins() {
		AdminList admins = AdminList.getInstance();
		ArrayList<Admin> adminList = admins.getAdmins();
		JSONArray JSONAdmins = new JSONArray();

		for (int i = 0; i < adminList.size(); i++) {
			JSONAdmins.add(getAdminJSON(adminList.get(i)));
		}

		
		try (FileWriter file = new FileWriter(ADMIN_FILE_NAME)) {
			file.write(JSONAdmins.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void saveInternshipPosts() {
		InternshipList internships = InternshipList.getInstance();
		ArrayList<InternshipPost> internshipList = internships.getInternships();
		JSONArray JSONPosts = new JSONArray();

		for (int i = 0; i < internshipList.size(); i++) {
			JSONPosts.add(getPostJSON(internshipList.get(i)));
		}

		
		try (FileWriter file = new FileWriter(INTERNSHIP_FILE_NAME)) {
			file.write(JSONPosts.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	} 

	public static void saveResumes() {
		ResumeList resumes = ResumeList.getInstance();
		ArrayList<Resume> resumeList = resumes.getResumes();
		JSONArray JSONResumes = new JSONArray();

		for (int i = 0; i < resumeList.size(); i++) {
			JSONResumes.add(getResumeJSON(resumeList.get(i)));
		}

		
		try (FileWriter file = new FileWriter(RESUME_FILE_NAME)) {
			file.write(JSONResumes.toJSONString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	} 

	// public static void saveApplicants() {
	// 	InternshipList internships = InternshipList.getInstance();
	// 	ArrayList<InternshipPost> internshipList = internships.getInternships();
	// 	JSONArray JSONApplicants = new JSONArray();

	// 	for (int i = 0; i < internshipList.size(); i++) {
	// 		JSONApplicants.add(getApplicantJSON(internshipList.get(i)));
	// 	}

		
	// 	try (FileWriter file = new FileWriter(APPLICATIONS_FILE_NAME_TEST)) {
	// 		file.write(JSONApplicants.toJSONString());
	// 		file.flush();
	// 	} catch (IOException e) {
	// 		e.printStackTrace();
	// 	}	
	// }
	
	public static JSONObject getStudentJSON(Student student) {
		HashMap<String, Object> studentDetails = new HashMap<String, Object>();
		studentDetails.put(USER_ID, student.getUUID().toString());
		studentDetails.put(USER_USER_NAME, student.getUserName());
		studentDetails.put(USER_PASSWORD, student.getPassword());
		studentDetails.put(STUDENT_FIRST_NAME, student.getFirstName());
		studentDetails.put(STUDENT_LAST_NAME, student.getLastName());
		studentDetails.put(STUDENT_GRAD_YEAR, student.getGradYear());
		studentDetails.put(USER_EMAIL, student.getEmail());
		studentDetails.put(STUDENT_ADDRESS, student.getAddress());
		studentDetails.put(STUDENT_PHONE_NUMBER, student.getPhone());
		studentDetails.put(STUDENT_GPA, student.getGPA());
		studentDetails.put(STUDENT_SHOW_GPA, student.getShowGPA());
		studentDetails.put(USER_RATING, student.getRating());
		
		JSONArray JSONReviews = new JSONArray();
		for (int i = 0; i < student.getReviews().size(); i++) {
			HashMap<String, Object> reviewDetails = new HashMap<String, Object>();
			Review review = student.getReviews().get(i);
			reviewDetails.put(REVIEW_RATING, review.getRating());
			reviewDetails.put(REVIEW_WRITER, review.getWriter());
			reviewDetails.put(REVIEW_COMMENT, review.getComment());
			JSONObject reviewDetailsJSON = new JSONObject(reviewDetails);

			JSONReviews.add(reviewDetailsJSON);
		}

		studentDetails.put(STUDENT_REVIEWS, JSONReviews);

		JSONArray JSONFavPosts = new JSONArray();
		for (int i = 0; i < student.getFavoritePosts().size(); i++) {
			HashMap<String, Object> favPostsDetails = new HashMap<String, Object>();
			InternshipPost post = student.getFavoritePosts().get(i);
			favPostsDetails.put(INTERNSHIP_ID, post.getUUID().toString());
			JSONObject favPostsDetailsJSON = new JSONObject(favPostsDetails);

			JSONFavPosts.add(favPostsDetailsJSON);
		}

		studentDetails.put(STUDENT_FAV_POSTS, JSONFavPosts);

		JSONObject studentDetailsJSON = new JSONObject(studentDetails);
		return studentDetailsJSON;
	}

	public static JSONObject getEmployerJSON(Employer employer) {
		HashMap<String, Object> employerDetails = new HashMap<String, Object>();
		// employerDetails.put(USER_ID, employer.getUUID().toString());
		employerDetails.put(EMPLOYER_TITLE, employer.getTitle());
		employerDetails.put(USER_USER_NAME, employer.getUsername());
		employerDetails.put(USER_PASSWORD, employer.getPassword());
		employerDetails.put(USER_EMAIL, employer.getEmail());
		employerDetails.put(USER_RATING, employer.getRating());
		employerDetails.put(EMPLOYER_LOCATION, employer.getLocation());
		employerDetails.put(EMPLOYER_MISSION, employer.getMission());
		
		JSONArray JSONReviews = new JSONArray();
		for (int i = 0; i < employer.getReviews().size(); i++) {
			HashMap<String, Object> reviewDetails = new HashMap<String, Object>();
			Review review = employer.getReviews().get(i);
			reviewDetails.put(REVIEW_RATING, review.getRating());
			reviewDetails.put(REVIEW_WRITER, review.getWriter());
			reviewDetails.put(REVIEW_COMMENT, review.getComment());
			JSONObject reviewDetailsJSON = new JSONObject(reviewDetails);

			JSONReviews.add(reviewDetailsJSON);
		}

		employerDetails.put(EMPLOYER_REVIEWS, JSONReviews);

		JSONObject employerDetailsJSON = new JSONObject(employerDetails);

		return employerDetailsJSON;
	}

	public static JSONObject getAdminJSON(Admin admin) {
		HashMap<String, Object> adminDetails = new HashMap<String, Object>();
		adminDetails.put(USER_ID, admin.getID().toString());
		adminDetails.put(USER_USER_NAME, admin.getUsername());
		adminDetails.put(USER_PASSWORD, admin.getPassword());

		JSONObject adminDetailsJSON = new JSONObject(adminDetails);
		
		return adminDetailsJSON;
	}

	public static JSONObject getPostJSON(InternshipPost post) {
		HashMap<String, Object> postDetails = new HashMap<String, Object>();
		postDetails.put(USER_ID, post.getUUID().toString());
		postDetails.put(INTERNSHIP_EMPLOYER_TITLE, post.getEmployerTitle());
		postDetails.put(INTERNSHIP_POSITION_TITLE, post.getPosTitle());
		postDetails.put(INTERNSHIP_DESCRIPTION, post.getDescription());
		postDetails.put(INTERNSHIP_LOCATION, post.getLocation());
		postDetails.put(INTERNSHIP_START_DATE, post.getStartDate());
		postDetails.put(INTERNSHIP_END_DATE, post.getEndDate());
		postDetails.put(INTERNSHIP_IS_REMOTE, post.getRemote());
		postDetails.put(INTERNSHIP_IS_OPEN, post.getOpen());
		postDetails.put(INTERNSHIP_LOW_PAY, post.getLowPay());
		postDetails.put(INTERNSHIP_HIGH_PAY, post.getHighPay());
		
		JSONArray JSONSkills = new JSONArray();
		for (int i = 0; i < post.getSkillReq().size(); i++) {
			HashMap<String, Object> skillDetails = new HashMap<String, Object>();
			Skill skill = post.getSkillReq().get(i);
			skillDetails.put(SKILLS_SKILL, skill.toString());
			JSONObject skillDetailsJSON = new JSONObject(skillDetails);

			JSONSkills.add(skillDetailsJSON);
		}

		postDetails.put(INTERNSHIP_SKILLS_REQ, JSONSkills);

		JSONObject postDetailsJSON = new JSONObject(postDetails);
		return postDetailsJSON;
	}

	public static JSONObject getResumeJSON(Resume resume) {
		HashMap<String, Object> resumeDetails = new HashMap<String, Object>();
		// resumeDetails.put(USER_ID, resume.getID().toString());
		
		
		// JSONArray JSONEducations = new JSONArray();
		// for (int i = 0; i < resume.getEducations().size(); i++) {
		// 	HashMap<String, Object> eduDetails = new HashMap<String, Object>();
		// 	Education edu = resume.getEducations().get(i);
		// 	eduDetails.put(EDUCATION_SCHOOL, edu.getSchoolTitle());
		// 	eduDetails.put(EDUCATION_LOCATION, edu.getLocation());
		// 	eduDetails.put(EDUCATION_MAJOR, edu.getMajor());
		// 	eduDetails.put(EDUCATION_GRAD_YEAR, edu.getGradYear());
		// 	eduDetails.put(RESUME, edu.getResume());
		// 	JSONObject eduDetailsJSON = new JSONObject(eduDetails);

		// 	JSONEducations.add(eduDetailsJSON);
		// }

		// resumeDetails.put(RESUME_EDUCATIONS, JSONEducations);

		// JSONArray JSONSkills = new JSONArray();
		// for (int i = 0; i < resume.getSkills().size(); i++) {
		// 	HashMap<String, Object> skillDetails = new HashMap<String, Object>();
		// 	List keys = new ArrayList(resume.getSkills().keySet());
		// 	Object skillObj = keys.get(i);
		// 	skillDetails.put(SKILLS_SKILL, skillObj.toString());
		// 	skillDetails.put(RESUME, resume.getSkills().get(i));
		// 	JSONObject skillDetailsJSON = new JSONObject(skillDetails);

		// 	JSONSkills.add(skillDetailsJSON);
		// }

		// resumeDetails.put(RESUME_SKILLS, JSONSkills);

		// JSONArray JSONCourses = new JSONArray();
		// for (int i = 0; i < resume.getCourses().size(); i++) {
		// 	HashMap<String, Object> courseDetails = new HashMap<String, Object>();
		// 	List keys = new ArrayList(resume.getCourses().keySet());
		// 	Object courseObj = keys.get(i);
		// 	String course = courseObj.toString();
		// 	courseDetails.put(COURSES_COURSE, course);
		// 	courseDetails.put(RESUME, resume.getCourses().get(i));
		// 	JSONObject courseDetailsJSON = new JSONObject(courseDetails);

		// 	JSONSkills.add(courseDetailsJSON);
		// }

		// resumeDetails.put(RESUME_COURSES, JSONCourses);

		JSONObject resumeDetailsJSON = new JSONObject(resumeDetails);
		return resumeDetailsJSON;
	}

	// public static JSONObject getApplicantJSON(InternshipPost post) {
	// 	HashMap<String, Object> applicantDetails = new HashMap<String, Object>();

	// 	applicantDetails.put(APPLICATIONS_STUDENT_ID, post.getApplicants().getUUID());
	// 	applicantDetails.put(APPLICATIONS_POST_ID, )
		
		
	// 	JSONArray JSONSkills = new JSONArray();
	// 	for (int i = 0; i < post.getSkillReq().size(); i++) {
	// 		HashMap<String, Object> skillDetails = new HashMap<String, Object>();
	// 		Skill skill = post.getSkillReq().get(i);
	// 		skillDetails.put(SKILLS_SKILL, skill.toString());
	// 		JSONObject skillDetailsJSON = new JSONObject(skillDetails);

	// 		JSONSkills.add(skillDetailsJSON);
	// 	}

	// 	postDetails.put(INTERNSHIP_SKILLS_REQ, JSONSkills);

	// 	JSONObject postDetailsJSON = new JSONObject(postDetails);
	// 	return postDetailsJSON;
	// }

	

	public static void main (String[] args) {
		// Student student = new Student("Adam", "Steger", "asteger", "12345678", 2024, "asteger@email.sc.edu", "1238 Axtell Dr Irmo, SC 29063", "(803)730-3278", 4.0, true);
		// student.getReviews().add(new Review("Ana Boccanfuso", 5, "Love him."));
		// StudentList.getInstance().addStudent(student);
		// StudentList.getInstance().save();

		// Employer employer = new Employer("Microsoft", "microandsoft", "oiapweru90", "microsoft@outlook.com", "Redmond, Washington", "Be better than Apple");
		// employer.getReviews().add(new Review("Adam Steger", 4, "I mean its alright I guess"));
		// EmployerList.getInstance().addEmployer(employer);
		// DataWriter.saveEmployers();

		// Admin admin = new Admin("imanadmin", "randompassword");
		// AdminList.getInstance().addAdmin(admin);
		// AdminList.getInstance().save();

		ArrayList<Skill> skillReq = new ArrayList<Skill>();
		skillReq.add(Skill.CPP);
		skillReq.add(Skill.C);
		InternshipPost post = new InternshipPost("Microsoft", "Software Intern", "You will do intern things", "Redmond, Washington", skillReq, "May 2021", "August 2021", true, true, 1000, 1500);
		InternshipList.getInstance().addInternship(post);
		InternshipList.getInstance().save();
	}
}