package restaurant;

import java.util.HashSet;
import java.util.Random;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import person.Client;
import person.Mutra;
import person.Student;
import person.Vegan;
import person.Waiter;

public class Demo {

	public static void main(String[] args) {
		

	HashSet<Waiter> waiters=new HashSet<>();
	for(int i=0;i<5;i++){
		waiters.add(new Waiter("Waiter" + (i+1),0));
	}
	Restaurant r=new Restaurant("Pri Pesho Talanta!",waiters);
	System.out.println(r.toString());
	
	HashSet<Client> clients=new HashSet<>();
	for (int i = 0; i < 15; i++) {
		int chance=new Random().nextInt(100);
		if(chance<20){
			clients.add(new Vegan("Client" + (i+1)));
		}
		else{
			if(chance>=20 && chance<70){
				clients.add(new Mutra("Client" + (i+1)));
			}
			else{
				clients.add(new Student("Client" + (i+1)));
			}
		}
	}
	//vsichki klienti vlizat v magazina
	r.startWork(clients);
	//poruchka na vsichki klienti
	for (Client client : clients) {
		client.makeOrder();
		System.out.println();
	}
	//iskane na smetkata ot vsichki klienti
	for (Client client : clients) {
		client.wantBill();
		System.out.println();
	}
	//plashtane na smetkata ot vsichki klienti
	for (Client client : clients) {
		client.payBill();
		System.out.println();
	}
	
	System.out.println();
	System.out.println(clients.toString());
  }
}