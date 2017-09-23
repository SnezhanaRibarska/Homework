package hospital;

import java.util.ArrayList;
import java.util.Random;

public class Patient extends Person implements Runnable {

	public static Hospital h;
	public static final ArrayList<String> GENDERS;
	static {
		GENDERS = new ArrayList<>();
		GENDERS.add("Male");
		GENDERS.add("Female");
	}

	private int age;
	private Plan plan;
	private int daysLeft;
	private String gender;
	private Room r;
	private Doctor doctor;

	public Patient(String firstName, String lastName, String phone, int age, String gender) {
		super(firstName, lastName, phone);
		if (age > 0) {
			this.age = age;
		}
		if (GENDERS.contains(gender)) {
			this.gender = gender;
		}
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
		this.daysLeft = new Random().nextInt(3) + 3;
	}

	@Override
	public void run() {
		h.acceptPatient(this);
	}

	public Plan getPlan() {
		return plan;
	}

	public String getGender() {
		return gender;
	}

	public void setRoom(Room r) {
		this.r = r;
	}

	public int getDaysLeft() {
		return this.daysLeft;
	}

	public void clearRoom() {
		this.r.removePatient(this);
	}

	public void setDaysLeft(int days) {
		this.daysLeft = days;

	}

	public void receiveMeds(Nurse n) {
		for (String med : plan.getMedsArray()) {
			System.out.println("Sestra " + n + " dade na pacient " + this + " v staq " + r.hashCode() + " ot otdelenie "
					+ n.getDepartment().getName() + " lekarstvo " + med);
		}
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public Room getR() {
		return r;
	}

}
