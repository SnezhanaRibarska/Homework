package dish;

public class Dessert extends Dish {

	public Dessert(String name,double grams) {
		super(name, 4, grams >=200 && grams<=300 ? grams : 300);
	}

	@Override
	public double getPrice() {
		return price;
	}

	
}
