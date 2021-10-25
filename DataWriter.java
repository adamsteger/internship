import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
	
	
	public static void saveStudents() {
		
	}

	public static void saveEmployers() {

	}

	public static void saveAdmins() {

	}
	
	public static JSONObject getStudentJSON(Student student) {
		JSONObject personJSON = new JSONObject();
		return personJSON;
	}

	public static JSONObject getEmployerJSON(Employer employer) {
		JSONObject personJSON = new JSONObject();
		return personJSON;
	}

	public static JSONObject getAdminJSON(Admin admin) {
		JSONObject personJSON = new JSONObject();
		return personJSON;
	} 
}