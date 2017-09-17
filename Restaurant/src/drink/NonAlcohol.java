package drink;

import person.IVegan;

public class NonAlcohol extends Drink implements IVegan {

	public NonAlcohol(String name) {
		super(name, 2);
	}

	@Override
	public double getPrice() {
		return price;
	}

}
