package person;

import java.util.ArrayList;
import java.util.Iterator;

import restaurant.Orderable;

public class Vegan extends Client {

	protected ArrayList<IVegan> order;
	
	public Vegan(String name) {
		super(name,30);
	}

	@Override
	public void makeOrder() {
		w=r.getRandomWaiter();
		order=new ArrayList<IVegan>();
		order.add(r.getMenu().getRandomDish());
		order.add(r.getMenu().getRandomDrink());
		

		for (Iterator iterator = order.iterator(); iterator.hasNext();) {
			IVegan iVegan = (IVegan) iterator.next();
			smetka+=iVegan.getPrice();
		}
	
		if(smetka>this.money*0.9){
			System.out.println("You can not pay this bill. Please order again!");
			return;
		}
	
		//check if contain item in returant
		for (Iterator iterator = order.iterator(); iterator.hasNext();) {
			Orderable iMutra = (Orderable) iterator.next();
			if(r.isContain(iMutra)){
				System.out.println("You can order this!");
			}
			else{
				System.out.println("Sorry, you can not order this!");
			}
		}
		
	}
}
