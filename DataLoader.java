import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class DataLoader extends DataConstants {
	
	public static ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<Student>();

        try {
			FileReader reader = new FileReader(STUDENT_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray peopleJSON = (JSONArray)parser.parse(reader);
			
			for(int i=0; i < peopleJSON.size(); i++) {
				JSONObject personJSON = (JSONObject)peopleJSON.get(i);
				UUID id = UUID.fromString((String)personJSON.get(USER_ID));
				String userName = (String)personJSON.get(USER_USER_NAME);
				String password = (String)personJSON.get(USER_PASSWORD);
				String firstName = (String)personJSON.get(STUDENT_FIRST_NAME);
				String lastName = (String)personJSON.get(STUDENT_LAST_NAME);
				int gradYear = ((Long)personJSON.get(STUDENT_GRAD_YEAR)).intValue();
				String email = (String)personJSON.get(USER_EMAIL);
				String address = (String)personJSON.get(STUDENT_ADDRESS);
				String phone = (String)personJSON.get(STUDENT_PHONE_NUMBER);
				double gpa = (double)personJSON.get(STUDENT_GPA);
				boolean showGPA = (boolean)personJSON.get(STUDENT_SHOW_GPA);
				double rating = (double)personJSON.get(USER_RATING);

				JSONArray reviewsJSON = (JSONArray)personJSON.get(STUDENT_REVIEWS);
				ArrayList<StudentReview> reviews = new ArrayList<StudentReview>();
				for (int j = 0; j < reviewsJSON.size(); j++) {
					JSONObject reviewJSON = (JSONObject)reviewsJSON.get(j);
					UUID writerID = UUID.fromString((String)reviewJSON.get(REVIEW_WRITER_ID));
					Employer employer = EmployerList.getInstance().getEmployerByID(writerID);
					int reviewRating = ((Long)reviewJSON.get(REVIEW_RATING)).intValue();
					String comment = (String)reviewJSON.get(REVIEW_COMMENT);

					reviews.add(new StudentReview(employer, reviewRating, comment));
				}

				JSONArray favPostsJSON = (JSONArray)personJSON.get(STUDENT_FAV_POSTS);
				ArrayList<InternshipPost> favPosts = new ArrayList<InternshipPost>();
				for (int j = 0; j < favPostsJSON.size(); j++) {
					JSONObject favPostJSON = (JSONObject)favPostsJSON.get(j);
					UUID postID = UUID.fromString((String)favPostJSON.get(INTERNSHIP_ID));
					InternshipPost post = InternshipList.getInstance().getPostByID(postID);

					favPosts.add(post);
				}

				students.add(new Student(id, firstName, lastName, userName, password, gradYear, email, address, phone, gpa, showGPA, rating, reviews, favPosts));
			}
			
			return students;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
    }

	public static ArrayList<Employer> getEmployers() {
        ArrayList<Employer> employers = new ArrayList<Employer>();

        try {
			FileReader reader = new FileReader(EMPLOYER_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i = 0; i < peopleJSON.size(); i++) {
				JSONObject personJSON = (JSONObject)peopleJSON.get(i);
				UUID id = UUID.fromString((String)personJSON.get(USER_ID));
				String title = (String)personJSON.get(EMPLOYER_TITLE);
				String userName = (String)personJSON.get(USER_USER_NAME);
				String password = (String)personJSON.get(USER_PASSWORD);
				String email = (String)personJSON.get(USER_EMAIL);
				double rating = (double)personJSON.get(USER_RATING);
				String location = (String)personJSON.get(EMPLOYER_LOCATION);
				String mission = (String)personJSON.get(EMPLOYER_MISSION);

				JSONArray reviewsJSON = (JSONArray)personJSON.get(EMPLOYER_REVIEWS);
				ArrayList<EmployerReview> reviews = new ArrayList<EmployerReview>();
				for (int j = 0; j < reviewsJSON.size(); j++) {
					JSONObject reviewJSON = (JSONObject)reviewsJSON.get(j);
					UUID writerID = UUID.fromString((String)reviewJSON.get(REVIEW_WRITER_ID));
					// Student student = StudentList.getInstance().getStudentByID(writerID);
					int reviewRating = ((Long)reviewJSON.get(REVIEW_RATING)).intValue();
					String comment = (String)reviewJSON.get(REVIEW_COMMENT);

				// 	reviews.add(new EmployerReview(student, reviewRating, comment));
				}

				
				employers.add(new Employer(id, title, userName, password, email, rating, location, mission, reviews));
			}
			
			return employers;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
    }

	public static ArrayList<InternshipPost> getInternshipPosts() {
		ArrayList<InternshipPost> posts = new ArrayList<InternshipPost>();

        try {
			FileReader reader = new FileReader(INTERNSHIP_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray postsJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i = 0; i < postsJSON.size(); i++) {
				JSONObject postJSON = (JSONObject)postsJSON.get(i);
				UUID postID = UUID.fromString((String)postJSON.get(INTERNSHIP_ID));
				String employerTitle = (String)postJSON.get(INTERNSHIP_EMPLOYER_TITLE);
				String posTitle = (String)postJSON.get(INTERNSHIP_POSITION_TITLE);
				String description = (String)postJSON.get(INTERNSHIP_DESCRIPTION);
				String location = (String)postJSON.get(INTERNSHIP_LOCATION);
				String startDate = (String)postJSON.get(INTERNSHIP_START_DATE);
				String endDate = (String)postJSON.get(INTERNSHIP_END_DATE);
				boolean isRemote = (boolean)postJSON.get(INTERNSHIP_IS_REMOTE);
				boolean isOpen = (boolean)postJSON.get(INTERNSHIP_IS_OPEN);
				int lowPay = ((Long)postJSON.get(INTERNSHIP_LOW_PAY)).intValue();
				int highPay = ((Long)postJSON.get(INTERNSHIP_HIGH_PAY)).intValue();

				
				posts.add(new InternshipPost(postID, employerTitle, posTitle, description, location, startDate, endDate, isRemote, isOpen, lowPay, highPay));
			}
			
			return posts;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static void main(String[] args){
		ArrayList<Employer> employers = DataLoader.getEmployers();
		ArrayList<Student> students = DataLoader.getStudents();
		ArrayList<InternshipPost> posts = DataLoader.getInternshipPosts();

		// for(Student student : students) {
		// 	System.out.println(student);
		// }

		for(Employer employer : employers){
			System.out.println(employer);
		}

		// for(InternshipPost post : posts) {
		// 	System.out.println(post);
		// }
	}
}
