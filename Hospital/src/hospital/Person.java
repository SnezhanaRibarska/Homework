package hospital;

public abstract class Person {

	private String firstName;
	private String lastName;
	private String phone;

	public Person(String firstName, String lastName, String phone) {
		if (firstName != null && !firstName.isEmpty()) {
			this.firstName = firstName;
		}
		if (lastName != null && !lastName.isEmpty()) {
			this.lastName = lastName;
		}
		if (phone != null && !phone.isEmpty()) {
			this.phone = phone;
		}

	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return getFirstName() + " " + getLastName();
	}

}
