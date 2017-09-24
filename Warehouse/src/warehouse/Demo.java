package warehouse;

public class Demo {

	public static void main(String[] args) {
		
		Warehouse wh = new Warehouse();
		
		Supplier sup = new Supplier(wh);
		sup.start();
		Shop shop1 = new Shop(wh);
		shop1.start();
		Shop shop2 = new Shop(wh);
		shop2.start();
		Shop shop3 = new Shop(wh);
		shop3.start();
		Client client1 = new Client(shop1,"Banana");
		client1.start();
		Client client2 = new Client(shop1,"Orange");
		client2.start();
		Client client3 = new Client(shop1,"Apple");
		client3.start();
		Client client4 = new Client(shop2,"Potato");
		client4.start();
		Client client5 = new Client(shop2,"Eggplant");
		client5.start();
		Client client6 = new Client(shop2,"Cucumber");
		client6.start();
		Client client7 = new Client(shop3,"Pork");
		client7.start();
		Client client8 = new Client(shop3,"Beef");
		client8.start();
		Client client9 = new Client(shop3,"Chicken");
		client9.start();
		
		

	}

}
