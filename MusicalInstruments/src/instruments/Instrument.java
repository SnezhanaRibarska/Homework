package instruments;

public abstract class Instrument {

	protected enum InstrumentType {
		STRUNNI, KLAVIRNI, UDARNI, DUHOVI;
	}
	
	private int sold = 0;
	private String name;
	private double price;
	private int quantity;
	protected InstrumentType type;
	
	
	public Instrument(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.type = getType();
	}
	
	public String getName() {
		return name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getSold() {
		return sold;
	}
	
	public void decreaseQuantity(int quant){
		this.quantity -= quant;
		sold+=quant;
	}
	
	public void incraseQuantity(int quant){
		this.quantity += quant;
	}
	
	protected abstract InstrumentType getType();

	@Override
	public String toString() {
		return "Instrument [sold=" + sold + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}

	
}


