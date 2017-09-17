package drink;

import person.IMutra;

public class Alcohol extends Drink implements IMutra {

	public Alcohol(String name) {
		super(name, 4);
	}

	@Override
	public double getPrice() {
		return 4;
	}

}
