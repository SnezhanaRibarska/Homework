package hospital;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Plan {

	private static final String[] MEDS = {"Aspirin" , "Analgin" , "Vitamin C"};
	private String diagnose;
	private ArrayList<String> medsArray;
	public static String getRandomMeds(){
		return MEDS[new Random().nextInt(MEDS.length)];
	}
	
	public Plan(String diagnose, String... meds) {
		this.diagnose = diagnose;
		medsArray = new ArrayList<>();
		for (String s : meds) {
			medsArray.add(s);
		}
	}
	
	public String getDiagnose(){
		return diagnose;
	}
	
	public List<String> getMedsArray(){
		return Collections.unmodifiableList(medsArray);
	}
	
}
