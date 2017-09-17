package dish;

import person.IMutra;

public class MainDish extends Dish implements IMutra{

	public MainDish(String name, double grams) {
		super(name, 9, grams>=400 && grams<=800 ? grams : 400);
	}

	@Override
	public double getPrice() {
		return this.price;
	}

}
