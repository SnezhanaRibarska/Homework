package dish;

import person.IVegan;

public class Salat extends Dish implements IVegan {

	public Salat(String name,double grams) {
		super(name, 5 , (grams>=300 && grams <=600) ? grams : 300 );
	}

	@Override
	public double getPrice() {
		return price;
	}

}
