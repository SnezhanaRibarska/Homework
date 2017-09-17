package dish;

import restaurant.Orderable;

public abstract class Dish implements Orderable{ 

	private String name;
	protected double price;
	private double grams;
	
	public Dish(String name, double price, double grams) {
		this.name = name;
		this.price = price;
		this.grams = grams;
	}

	public String getName(){
		return name;
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
		Dish other = (Dish) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dish [name=" + name + ", price=" + price + ", grams=" + grams + "]";
	}
	
	
	
}
