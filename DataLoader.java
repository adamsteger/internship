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
			FileReader reader = new FileReader(USER_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);
			
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

				
				students.add(new Student(id, firstName, lastName, userName, password, gradYear, email, address, phone, gpa, showGPA, rating));
			}
			
			return students;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
    }

	public static void main(String[] args){
		ArrayList<Student> students = DataLoader.getStudents();

		for(Student student : students){
			System.out.println(student);
		}
	}

	public static ArrayList<InternshipPost> getInternships() {
		return null;
	}
}
