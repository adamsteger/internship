import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Hashtable;

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
				ArrayList<Review> reviews = new ArrayList<Review>();
				for (int j = 0; j < reviewsJSON.size(); j++) {
					JSONObject reviewJSON = (JSONObject)reviewsJSON.get(j);
					String writer = (String)reviewJSON.get(REVIEW_WRITER);
					int reviewRating = ((Long)reviewJSON.get(REVIEW_RATING)).intValue();
					String comment = (String)reviewJSON.get(REVIEW_COMMENT);

					reviews.add(new Review(writer, reviewRating, comment));
				}

				JSONArray favPostsJSON = (JSONArray)personJSON.get(STUDENT_FAV_POSTS);
				ArrayList<InternshipPost> favPosts = new ArrayList<InternshipPost>();
				for (int j = 0; j < favPostsJSON.size(); j++) {
					JSONObject favPostJSON = (JSONObject)favPostsJSON.get(j);
					UUID postID = UUID.fromString((String)favPostJSON.get(INTERNSHIP_ID));
					InternshipPost post = InternshipList.getInstance().getPostByID(postID);

					favPosts.add(post);
				}

				students.add(new Student(id, firstName, lastName, userName, password, gradYear, email, address, phone, gpa, showGPA, rating, favPosts));
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
				ArrayList<Review> reviews = new ArrayList<Review>();
				for (int j = 0; j < reviewsJSON.size(); j++) {
					JSONObject reviewJSON = (JSONObject)reviewsJSON.get(j);
					String writer = (String)reviewJSON.get(REVIEW_WRITER);
					int reviewRating = ((Long)reviewJSON.get(REVIEW_RATING)).intValue();
					String comment = (String)reviewJSON.get(REVIEW_COMMENT);

				 	reviews.add(new Review(writer, reviewRating, comment));
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


				JSONArray skillsJSON = (JSONArray)postJSON.get(INTERNSHIP_SKILLS_REQ);
				ArrayList<Skill> skills = new ArrayList<Skill>();
				for (int j = 0; j < skillsJSON.size(); j++) {
					JSONObject skillJSON = (JSONObject)skillsJSON.get(j);
					String skillString = (String)skillJSON.get(INTERNSHIP_SKILL);
					Skill skill = Skill.valueOf(skillString);
					skills.add(skill);
				}
				
				posts.add(new InternshipPost(postID, employerTitle, posTitle, description, location, startDate, endDate, isRemote, isOpen, lowPay, highPay, skills));
			}
			
			return posts;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	// public static ArrayList<Resume> getResumes() {
	// 	ArrayList<Resume> resumes = new ArrayList<Resume>();

	// 	try {
	// 		FileReader reader = new FileReader(RESUME_FILE_NAME);
	// 		JSONParser parser = new JSONParser();	
	// 		JSONArray resumesJSON = (JSONArray)new JSONParser().parse(reader);
			
	// 		for(int i = 0; i < resumesJSON.size(); i++) {
	// 			JSONObject resumeJSON = (JSONObject)resumesJSON.get(i);
	// 			UUID id = UUID.fromString((String)resumeJSON.get(RESUME_ID));

	// 			JSONArray educationsJSON = (JSONArray)resumeJSON.get(EMPLOYER_REVIEWS);
	// 			ArrayList<Education> educations = new ArrayList<Education>();
	// 			for (int j = 0; j < educationsJSON.size(); j++) {
	// 				JSONObject educationJSON = (JSONObject)educationsJSON.get(j);
	// 				String schoolTitle = (String)educationJSON.get(EDUCATION_SCHOOL);
	// 				String location = (String)educationJSON.get(EDUCATION_LOCATION);
	// 				String major = (String)educationJSON.get(EDUCATION_MAJOR);
	// 				int gradYear = ((Long)educationJSON.get(EDUCATION_GRAD_YEAR)).intValue();
	// 				Boolean resume = (Boolean)educationJSON.get(RESUME);

	// 			 	educations.add(new Education(schoolTitle, location, major, gradYear, resume));
	// 			}

	// 			JSONArray skillsJSON = (JSONArray)resumeJSON.get(SKILLS);
	// 			Hashtable<Skill,Boolean> skills = new Hashtable<Skill,Boolean>();
	// 			for (int j = 0; j < skillsJSON.size(); j++) {
	// 				JSONObject skillJSON = (JSONObject)skillsJSON.get(j);
	// 				String skillString = (String)skillJSON.get(SKILLS_SKILL);
	// 				Boolean resume = (Boolean)skillJSON.get(RESUME);
	// 				Skill skill = Skill.valueOf(skillString);

	// 			 	skills.put(skill, resume);
	// 			}

	// 			JSONArray coursesJSON = (JSONArray)resumeJSON.get(RESUME_COURSES);
	// 			Hashtable<String,Boolean> courses = new Hashtable<String,Boolean>();
	// 			for (int j = 0; j < coursesJSON.size(); j++) {
	// 				JSONObject courseJSON = (JSONObject)coursesJSON.get(j);
	// 				String course = (String)courseJSON.get(COURSES_COURSE);
	// 				Boolean resume = (Boolean)courseJSON.get(RESUME);

	// 			 	courses.put(course, resume);
	// 			}

	// 			JSONArray worksJSON = (JSONArray)resumeJSON.get(RESUME_WORK);
	// 			ArrayList<WorkExperience> works = new ArrayList<WorkExperience>();
	// 			for (int j = 0; j < worksJSON.size(); j++) {
	// 				JSONObject workJSON = (JSONObject)educationsJSON.get(j);
	// 				String posTitle = (String)workJSON.get(WORK_POSITION_TITLE);
	// 				String employer = (String)workJSON.get(WORK_EMPLOYER);
	// 				String location = (String)workJSON.get(WORK_LOCATION);
	// 				String startDate = (String)workJSON.get(WORK_START_DATE);
	// 				String endDate = (String)workJSON.get(WORK_END_DATE);


	// 				JSONArray descriptionsJSON = (JSONArray)workJSON.get(WORK_DESCRIPTION);
	// 				ArrayList<String> description = new ArrayList<String>();
	// 				for (int k = 0; k < descriptionsJSON.size(); k++) {

	// 				}


	// 				int gradYear = ((Long)educationJSON.get(EDUCATION_GRAD_YEAR)).intValue();
	// 				Boolean resume = (Boolean)educationJSON.get(RESUME);

	// 			 	educations.add(new Education(schoolTitle, location, major, gradYear, resume));
	// 			}


				
	// 			employers.add(new Employer(id, title, userName, password, email, rating, location, mission, reviews));
	// 		}
			
	// 		return employers;
			
	// 	} catch (Exception e) {
	// 		e.printStackTrace();
	// 	}
		
	// 	return null;
		
	// }

	public static ArrayList<Admin> getAdmins() {
		ArrayList<Admin> ret = new ArrayList<Admin>();
		return ret;
	}	

	public static void getApplicants() {
		// ArrayList<Student> applicants = new ArrayList<Student>();
		try {
			FileReader reader = new FileReader(APPLICATIONS_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray applicantsJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i = 0; i < applicantsJSON.size(); i++) {
				JSONObject applicantJSON = (JSONObject)applicantsJSON.get(i);
				UUID studentID = UUID.fromString((String)applicantJSON.get(APPLICATIONS_STUDENT_ID));
				UUID postID = UUID.fromString((String)applicantJSON.get(APPLICATIONS_POST_ID));
				UUID employerID = UUID.fromString((String)applicantJSON.get(APPLICATIONS_EMPLOYER_ID));

				Employer employer = EmployerList.getInstance().getEmployerByID(employerID);
				InternshipPost post = InternshipList.getInstance().getPostByID(postID);
				Student student = StudentList.getInstance().getStudentByID(studentID);
				
				post.getApplicants().add(student);
				employer.getPosts().add(post);
			}

			// return applicants;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return null;
	}

	public static void main(String[] args){
		ArrayList<Employer> employers = DataLoader.getEmployers();
		ArrayList<Student> students = DataLoader.getStudents();
		ArrayList<InternshipPost> posts = DataLoader.getInternshipPosts();
		// DataLoader.getApplicants();

		// for(Student student : students) {
		// 	System.out.println(student);
		// }

		// for(Employer employer : employers){
		// 	System.out.println(employer);
		// }

		for(InternshipPost post : posts) {
			System.out.println(post);
		}
	}

   
}

