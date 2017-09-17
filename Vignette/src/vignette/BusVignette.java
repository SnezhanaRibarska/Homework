package vignette;

public class BusVignette extends Vignette{

	public BusVignette(Validy validy) {
		super(validy);
		this.color="BusColor";
		setPrice();
	}

	@Override
	public int zalepi() {
		return 20;
	}


}
