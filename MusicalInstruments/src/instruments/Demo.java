package instruments;

import instruments.Instrument.InstrumentType;

public class Demo {


	public static void main(String[] args) {

		Shop shop = new Shop();
		shop.sell("Yamaha", 3);
		shop.sell("Orfey", 1);
		shop.sell("Fender", 2);
		shop.printInstrumentsByType();
		System.out.println("-------------------------------------------------------------------");
		shop.printInstrumentsByName();
		System.out.println("-------------------------------------------------------------------");
		shop.printInstrumentsByPrice(true);
		System.out.println("-------------------------------------------------------------------");
		shop.printInstrumentsByPrice(false);
		System.out.println("-------------------------------------------------------------------");
		shop.printInstrumentsBySales();
		System.out.println("-------------------------------------------------------------------");
		System.out.println(shop.getProfit());
	}
}
