
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import vehicle.Vehicle;
import vignette.Vignette;
import vignette.Vignette.Validy;

public class Driver {

	private String name;
	private HashSet<Vehicle> vehicles;
	double money;
	private GasStation station;
	
	
	public Driver(String name) {
		this.name = name;
		this.vehicles = vehicles;
		this.money =new Random().nextInt(500)+50000;
		vehicles=new HashSet<>();
	}
	
	public Set<Vehicle> getVehicles(){
		return Collections.unmodifiableSet(vehicles);
	}

	void buyVignetteForAllVehicle(){
		for (Vehicle vehicle : vehicles) {
			Vignette v=station.buyVignette(vehicle);
			vehicle.setVignette(v);
			this.money-=v.getPrice();
			station.payVignette(v.getPrice());
		}
	}
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(money);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Driver other = (Driver) obj;
		if (Double.doubleToLongBits(money) != Double.doubleToLongBits(other.money))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}



	void buyVignette(int index,Validy validy){
		Vehicle[] vehicle=vehicles.toArray(new Vehicle[vehicles.size()]);
		this.station.buyVignette(vehicle[index]);
	}
	
	public int getRandom(){
		return new Random().nextInt(vehicles.size());
	}

	public void setGasStation(GasStation gasStation) {
		this.station=gasStation;
		
	}
	
	public void addVehicle(Vehicle v){
		this.vehicles.add(v);
	}

	@Override
	public String toString() {
		return "Driver [name=" + name + ", vehicles=" + vehicles + ", money=" + money + "]";
	}
}
