import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
	}

	public static void saveEmployers() {
		EmployerList employers = EmployerList.getInstance();
		ArrayList<Employer> employerList = employers.getEmployers();
		JSONArray JSONEmployers = new JSONArray();

		for (int i = 0; i < employerList.size(); i++) {
			JSONEmployers.add(getEmployerJSON(employerList.get(i)));
		}
	}

	public static void saveAdmins() {

	}
	
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
		employerDetails.put(USER_ID, employer.getUUID().toString());
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

		employerDetails.put(STUDENT_REVIEWS, JSONReviews);

		JSONObject employerDetailsJSON = new JSONObject(employerDetails);

		return employerDetailsJSON;
	}

	public static JSONObject getAdminJSON(Admin admin) {
		JSONObject personJSON = new JSONObject();
		return personJSON;
	}

	public static void saveInternshipPosts() {
	} 

	public static void main (String[] args) {
		Student student = new Student("Adam", "Steger", "asteger", "12345678", 2024, "asteger@email.sc.edu", "1238 Axtell Dr Irmo, SC 29063", "(803)730-3278", 4.0, true);
		student.getReviews().add(new Review("Ana Boccanfuso", 5, "Love him."));
	}
}