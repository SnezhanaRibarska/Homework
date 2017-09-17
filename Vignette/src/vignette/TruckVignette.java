package vignette;

import vignette.Vignette.Validy;

public class TruckVignette extends Vignette{

	public TruckVignette(Validy validy) {
		super(validy);
		this.color="TruckColor";
		setPrice();
	}

	@Override
	public int zalepi() {
		return 10;
	}
	
}
