package vignette;

public abstract class Vignette implements Comparable<Vignette>{

	public enum Validy{DAILY,MONTHLY,YEARLY};
	
	private String date;
	protected String color;
	private Validy validy;
	protected int price;
	
	public Vignette(Validy validy) {
		this.validy = validy;
	}
	
	public abstract int zalepi();
	public void setPrice(){
		int price=0;
		if(this.color.equals("CarColor")){
			price=5;
		}
		if(this.color.equals("TruckColor")){
			price=7;
		}
		if(this.color.equals("BusColor")){
			price=9;
		}
		if(validy==Validy.MONTHLY){
			price*=10;
		}
		if(validy==Validy.YEARLY){
			price*=60;
		}
		this.price=price;
	}
	
	public Validy getValidy(){
		return validy;
	}
	
	@Override
	public int compareTo(Vignette o) {
		if(this.price==o.price){
			return 0;
		}
		else{
			if(this.price>o.price){
				return 1;
			}
			else{
				return -1;
			}
		}
	}
	@Override
	public String toString() {
		return "Vignette [color=" + color + ", validy=" + validy + ", price=" + price + "]";
	}

	public int getPrice(){
		return this.price;
	}
}
