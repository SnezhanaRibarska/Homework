package instruments;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

import instruments.Instrument.InstrumentType;

public class Shop {
	private static final double MARGIN = 1.3;
	//type->(name->instrument)
	private HashMap<InstrumentType, HashMap<String, Instrument>> instruments;
	
	private double money;
	private double profit = 0;
	
	public Shop() {
		
		instruments = new HashMap<>();
		instruments.put(InstrumentType.KLAVIRNI, new HashMap<>());
		instruments.get(InstrumentType.KLAVIRNI).put("Yamaha", new Piano("Yamaha", 2000, 5));
		instruments.get(InstrumentType.KLAVIRNI).put("Suzuki", new Piano("Suzuki", 1200, 15));
		instruments.put(InstrumentType.DUHOVI, new HashMap<>());
		instruments.put(InstrumentType.UDARNI, new HashMap<>());
		instruments.get(InstrumentType.UDARNI).put("Marshal", new Piano("Marshal", 1200, 0));
		instruments.put(InstrumentType.STRUNNI, new HashMap<>());
		instruments.get(InstrumentType.STRUNNI).put("Fender", new Guitar("Fender", 300, 10));
		instruments.get(InstrumentType.STRUNNI).put("Orfey", new Guitar("Orfey", 120, 30));
		instruments.get(InstrumentType.STRUNNI).put("Strativarius", new Violin("Strativarius", 700_000, 2));
		money = 10_000;
	}

	/**
	 * 
	 * @param name
	 * @param quantity
	 * @param add - if true -> we add the instrument. if false -> we remove the instrument
	 */
	private void modify(String name, int quantity, boolean add){
		if(name == null || quantity <= 0){
			System.out.println("Wrong parameters");
			return;
		}
		Instrument instrument = null;
		for(HashMap<String, Instrument> razdel : instruments.values()){
			if(razdel.containsKey(name)){
				instrument = razdel.get(name);
			}
		}
		if(instrument == null){
			System.out.println("No such instrument!");
		}
		else{
			if(add){
				if(this.money >= quantity* instrument.getPrice()){
					instrument.incraseQuantity(quantity);
					this.money-= quantity* instrument.getPrice();
				}
				else{
					System.out.println("Not enough money to order this instrument");
				}
			}
			else{
				if(instrument.getQuantity() >= quantity){
					instrument. decreaseQuantity(quantity);
					this.money+= quantity* instrument.getPrice()*MARGIN;
					this.profit+=quantity* instrument.getPrice()*MARGIN;
				}
				else{
					System.out.println("Not enought quantity for this instrument; There are " +instrument.getQuantity()+ " left");
				}
			}
		}
	}
	
	public void sell(String name, int quantity){
		modify(name, quantity, false);
	}

	public void receive(String name, int quantity){
		modify(name, quantity, true);
	}
	
	public void printInstrumentsByType(){
		for (InstrumentType type : instruments.keySet()) {
			System.out.println(" ============== " + type + " ============== ");
			if(instruments.get(type).isEmpty()){
				System.out.println("NONE");
			}
			else{
				for (Instrument i : instruments.get(type).values()) {
					System.out.println(i);
				}
			}
		}
	}

	public void printInstrumentsByName(){
		printAll(new Comparator<Instrument>() {
			@Override
			public int compare(Instrument o1, Instrument o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
	}

	/**
	 * 
	 * @param asc - if true-> order ascending. If false -> order descending
	 */
	public void printInstrumentsByPrice(boolean asc) {
		printAll(new Comparator<Instrument>() {
			@Override
			public int compare(Instrument o1, Instrument o2) {
				if(o1.getPrice() == o2.getPrice()){
					return o1.getName().compareTo(o2.getName());
				}
				if(asc){
					return Double.compare(o1.getPrice(), o2.getPrice());
				}
				else{
					return Double.compare(o2.getPrice(), o1.getPrice());
				}
			}
		});
	}
	
	public void printInstrumentsBySales(){
		printAll(new Comparator<Instrument>() {
			@Override
			public int compare(Instrument o1, Instrument o2) {
				if(o1.getSold() == o2.getSold()){
					return o1.getName().compareTo(o2.getName());
				}
				return o2.getSold() - o1.getSold();
			}
		});
	}
	
	private void printAll(Comparator comp){
		TreeSet<Instrument> set = new TreeSet<>(comp);
		//fill all
		for(HashMap<String, Instrument> innerMap : instruments.values()){
			set.addAll(innerMap.values());
		}
		for(Instrument i : set){
			System.out.println(i);
		}
	}
	
	public double getProfit() {
		return profit;
	}
}
