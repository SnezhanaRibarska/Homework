package vehicle;

import vignette.Vignette;

public abstract class Vehicle {

	@Override
	public String toString() {
		return "Vehicle [model=" + model + ", year=" + year + "]";
	}

	private String model;
	private Vignette vignette;
	private int year;
	public void setVignette(Vignette v){
		this.vignette=v;
	}

	public Vehicle(String model, int year) {
		this.model = model;
		this.year = year;
	}
	
	
}
