package person;

import java.util.ArrayList;
import java.util.Iterator;

import dish.MainDish;
import drink.Alcohol;
import drink.NonAlcohol;
import restaurant.Orderable;

public class Mutra extends Client {

	protected ArrayList<IMutra> order;
	
	public Mutra(String name) {
		super(name,50);
	}

	@Override
	public void makeOrder() {
		w=r.getRandomWaiter();
		order=new ArrayList<IMutra>();
		order.add(r.getMenu().getRandomDish());
		order.add(r.getMenu().getRandomDrink());
		

		for (Iterator iterator = order.iterator(); iterator.hasNext();) {
			IMutra iMutra = (IMutra) iterator.next();
			smetka+=iMutra.getPrice();
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
