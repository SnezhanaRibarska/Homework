package agency;

import client.Buyer;
import imot.Imot;

public class Ogled {

	private Imot i;
	private Agent a;
	private String date;
	private Buyer buyer;
	
	public Ogled(Imot i, Agent a, String date, Buyer buyer) {
		this.i = i;
		this.a = a;
		this.date = date;
		this.buyer = buyer;
	}
	
	public Imot getImot(){
		return i;
	}
	
}
