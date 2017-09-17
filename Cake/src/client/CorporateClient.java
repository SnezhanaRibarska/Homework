package client;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import javax.tools.Diagnostic.Kind;

import cake.Cake;
import cake.Cake.ICakeType;

public class CorporateClient extends Client {

	private int discount;
	
	public CorporateClient(String name, String gsm,int money) {
		super(name, gsm , money);
		this.discount=10;
	}

	@Override
	public void makeOrder() {
		ArrayList<Cake> order=new ArrayList<>();
		for (int i = 0; i < new Random().nextInt(3)+3; i++) {
			Kind k=Kind.values()[new Random().nextInt(Kind.values().length)];
			if(this.shop.containsKind(k)){
				Set<ICakeType> allTypes=this.shop.viewKind(k);
				ICakeType type=null;
				
				int size=allTypes.size();
				int item=new Random().nextInt(size);
				int idx=0;
				
				for (ICakeType cakeType : allTypes) {
				    if (idx == item)
					type = cakeType;
				    idx++;
				}

				order.add(this.shop.getCake(k, type));
			}
		}
		
	}

}
