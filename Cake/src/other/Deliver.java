package other;
import java.util.HashSet;

public class Deliver {

	private String name;
	private String gsm;
	private HashSet<Order> orders;
	
	public Deliver(String name) {
		this.name = name;
		this.gsm=gsm;
		this.orders=new HashSet<>();
	}
	
}
