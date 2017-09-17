import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import vehicle.Bus;
import vehicle.Car;
import vehicle.Truck;
import vehicle.Vehicle;
import vignette.Vignette.Validy;

public class Demo {

	public static void main(String[] args) {

		GasStation gasStation = new GasStation(10_000);
		gasStation.showVignettesInStock();

		String[] names = { "Noah", "Liam", "William", "Mason", "James", "Benjamin", "Jacob", "Michael", "Elijah",
				"Ethan", "Alexander", "Oliver", "Daniel", "Lucas", "Matthew", "Aiden", "Jackson", "Logan", "David",
				"Joseph" };

		HashSet<Driver> drivers = new HashSet<>();
		for (int i = 0; i < 20; i++) {
			Driver d = new Driver(names[new Random().nextInt(names.length)]);
			d.setGasStation(gasStation);
			drivers.add(d);
		}

		System.out.println("=======================================");
		for (Driver driver : drivers) {
			System.out.println(driver);
		}

		System.out.println("=======================================");

		ArrayList<Vehicle> vehicles = new ArrayList<>();
		for (int i = 0; i < 200; i++) {
			Vehicle v=null;
			 String[] marks = { "Alfa Romeo", "Aston Martin", "Audi", "Bentley", "Benz", "BMW", "Bugatti", "Cadillac",
					    "Chevrolet", "Chrysler", "Citroen", "Corvette", "DAF", "Dacia", "Daewoo", "Daihatsu", "Datsun",
					    "De Lorean", "Dino", "Dodge", "Farboud", "Ferrari", "Fiat", "Ford", "Honda", "Hummer", "Hyundai",
					    "Jaguar", "Jeep", "KIA", "Koenigsegg", "Lada", "Lamborghini", "Lancia", "Land Rover", "Lexus",
					    "Ligier", "Lincoln", "Lotus", "Martini", "Maserati", "Maybach", "Mazda", "McLaren", "Mercedes",
					    "Mercedes-Benz", "Mini", "Mitsubishi", "Nissan", "Noble", "Opel", "Peugeot", "Pontiac", "Porsche",
					    "Renault", "Rolls-Royce", "Rover", "Saab", "Seat", "Skoda", "Smart", "Spyker", "Subaru", "Suzuki",
					    "Toyota", "Vauxhall", "Volkswagen", "Volvo" };
			 int randomVehicle=new Random().nextInt(3);
			 int randomYear=new Random().nextInt(67)+1950;
			 
			 switch(randomVehicle){
			 case 0:
				 v=new Car(marks[new Random().nextInt(marks.length)],randomYear);
				 break;
			 case 1:
				 v=new Bus(marks[new Random().nextInt(marks.length)],randomYear);
				 break;
			 case 2:
				 v=new Truck(marks[new Random().nextInt(marks.length)],randomYear);
				 break;
				 
			 }
			 vehicles.add(v);
			 }
		
		for (Driver driver : drivers) {
			for (int i = 0; i < 10; i++) {
				driver.addVehicle(vehicles.get(0));
				vehicles.remove(0);
			}
			System.out.println(driver);
		}
		
		System.out.println("====================================");
		
		
		int i=0;
		for (Driver driver : drivers) {
			if(i%3==0){
				for (int j = 0; j < 5; j++) {
					Validy validy=null;
					int randomValidy=new Random().nextInt(3);
					switch(randomValidy){
					case 0:
						validy=Validy.DAILY;
						break;
					case 1:
						validy=Validy.MONTHLY;
						break;
					case 2:
						validy=Validy.YEARLY;
						break;
					}
					driver.buyVignette(driver.getRandom(), validy);
				}
			}
			else{
				for (Iterator iterator = driver.getVehicles().iterator(); iterator.hasNext();) {
					Vehicle vehicle = (Vehicle) iterator.next();
					driver.buyVignetteForAllVehicle();
				}
			}
			i++;
		}
	}
}
