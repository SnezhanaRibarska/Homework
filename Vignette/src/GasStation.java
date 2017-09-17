

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;

import vehicle.Vehicle;
import vignette.BusVignette;
import vignette.CarVignette;
import vignette.TruckVignette;
import vignette.Vignette;
import vignette.Vignette.Validy;

public class GasStation {

	private double money;
	TreeMap<Vignette, Integer> vignette;

	public GasStation(int number) {
		this.money = money;
		vignette = new TreeMap<>();
		generateVignette(10_000);
	}

	private void generateVignette(int number) {
		for (int i = 0; i < number; i++) {

			int randomValidy = new Random().nextInt(3);
			Validy validy = null;

			switch (randomValidy) {
			case 0:
				validy = Validy.DAILY;
				break;
			case 1:
				validy = Validy.MONTHLY;
				break;
			case 2:
				validy = Validy.YEARLY;
				break;
			}

			Vignette v = null;
			int randomVignette = new Random().nextInt(3);

			switch (randomVignette) {
			case 0:
				v = new CarVignette(validy);
				break;
			case 1:
				v = new BusVignette(validy);
				break;
			case 2:
				v = new TruckVignette(validy);
				break;
			}
			putVignetteInCollectrion(v);
		}

	}

	private void putVignetteInCollectrion(Vignette v) {
		if(this.vignette.containsKey(v)){
			int number=vignette.get(v).intValue();
			this.vignette.put(v, ++number);
		}
		else{
			this.vignette.put(v, 1);
		}
	}
	
	public Vignette buyVignette(Vehicle v){
		v.setVignette(vignette.firstKey());
		return vignette.firstKey();
	}
	
	public void payVignette(double price){
		 this.money+=price;
	}
	
	 public void showVignettesInStock() {
		 for (Entry<Vignette, Integer> entry : this.vignette.entrySet()) {
			  System.out.println(entry.getKey() + " -> " + entry.getValue() + " br");
			}
		}
}
