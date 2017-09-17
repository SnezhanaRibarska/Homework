package person;

public class Waiter {

	private String name;
	private double money;
	
	public Waiter(String name, double money) {
		this.name = name;
		this.money = money;
	}
	
	public Waiter(){
		this.name="No name";
		this.money=0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Waiter other = (Waiter) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Waiter [name=" + name + ", money=" + money + "]";
	}

	public void setMoney(double bakchish) {
		this.money=bakchish;
	}

	
	
	
	
}
