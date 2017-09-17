package other;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import cake.Cake;
import cake.Cake.Kind;
import cake.KidCake;
import cake.KidCake.KidCakeType;
import cake.SpecialCake;
import cake.SpecialCake.SpecialCakeType;
import cake.StandartCake;
import cake.StandartCake.StandartCakeType;
import cake.WeddingCake;
import cake.WeddingCake.WeddingCakeType;
import client.Client;
import client.CorporateClient;
import client.PrivateClient;

public class Demo {

	public static void main(String[] args) {
		
		String[] names={"Sneji","Krasi","Pesho","Vladi","Tedi","Vasko","Mitko"};
		HashSet<Deliver> delivers=new HashSet<>();
		for (int i = 0; i < 5; i++) {
			delivers.add(new Deliver(names[new Random().nextInt(names.length)]));
		}
		
		 SweetShop s=new SweetShop("Сладки таланти",delivers);
		 
		 //String name, String description, int price, int brPiece, Kind kind
		 ArrayList<Cake> cakes=new ArrayList<>();
		 String[] cakesName={"Nedelq","Plodova Pita","Snikers","Frenska","Grucka"};
		 String[] cakesDescription={"Mnogo gadna","Mnogo vkusna","Stava"};
		 
		 for (int i = 0; i < 30; i++) {

		 int chance=new Random().nextInt(100);
		 String cakeName=cakesName[new Random().nextInt(cakesName.length)];
		 String cakeDescription=cakesDescription[new Random().nextInt(cakesDescription.length)];
		 int cakePrice=new Random().nextInt(20)+10;
		 int cakesPiece=new Random().nextInt(20)+5; 
		 int number=new Random().nextInt(5)+1;
		 
		 if(chance<25){
			 boolean isMoistCake = new Random().nextBoolean();
			 StandartCakeType t=StandartCakeType.values()[new Random().nextInt(StandartCakeType.values().length)];
			 StandartCake c=new StandartCake(cakeName,cakeDescription,cakePrice,cakesPiece,t,isMoistCake);
			 s.addCake(c,number);
		 }
		 else{
			 if(chance>=25 && chance<50){
				 int floor=new Random().nextInt(3)+1;
				 WeddingCakeType t=WeddingCakeType.values()[new Random().nextInt(WeddingCakeType.values().length)];
				 WeddingCake w=new WeddingCake(cakeName,cakeDescription,cakePrice,cakesPiece,t,floor);
				 s.addCake(w,number);
			 }
			 else{
				 if(chance>=50 && chance<75){
					 SpecialCakeType t=SpecialCakeType.values()[new Random().nextInt(SpecialCakeType.values().length)];
					 SpecialCake w=new SpecialCake(cakeName,cakeDescription,cakePrice,cakesPiece,t,"Golqmo subitie");
					 s.addCake(w,number);
				 }
				 else{
					 KidCakeType t=KidCakeType.values()[new Random().nextInt(KidCakeType.values().length)];
					 KidCake w=new KidCake(cakeName,cakeDescription,cakePrice,cakesPiece,"Sneji",t);
					 s.addCake(w,number);
				 }
			 }
		 }
	   }
		 
		 String[] clientsNames={"Sneji","Toni","Vladi","Poni","Koni","Moni","Vani","Gani"};
		 String[] gsmNumbersClient = { "0899949505", "0899949505", "0899949001", "0899949875", "0899749502",
		 "0879969505"};
		 ArrayList<Client> clients=new ArrayList<>();
		 for (int i = 0; i < 10 ; i++) {
			
			String name=clientsNames[new Random().nextInt(clientsNames.length)];
			String gsm=gsmNumbersClient[new Random().nextInt(gsmNumbersClient.length)];
			if(new Random().nextBoolean()){
				int money = new Random().nextInt() * 10 + new Random().nextInt(1000) + 500;
				CorporateClient client=new CorporateClient(name,gsm,money);
				clients.add(client);
			}
			else{
				int numVaucher = new Random().nextInt(4) + 1;
				int money = new Random().nextInt() * 10 + new Random().nextInt(500) + 100;
				int priceVaucher = new Random().nextInt() * 10 + new Random().nextInt(20) + 1;
				PrivateClient p = new PrivateClient(name, gsm, money, numVaucher, priceVaucher);
				clients.add(p);
			}
		}
	}

}
