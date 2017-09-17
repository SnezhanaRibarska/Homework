package vignette;

import vignette.Vignette.Validy;

public class CarVignette extends Vignette {


	public CarVignette(Validy validy) {
		super(validy);
		this.color="CarColor";
		setPrice();
		
	}

	@Override
	public int zalepi() {
		return 5;
	}


}
