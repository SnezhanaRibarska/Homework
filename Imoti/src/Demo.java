
import java.util.HashSet;
import java.util.Random;

import agency.Agency;
import agency.Agent;
import client.Buyer;
import client.Seller;
import imot.Imot;
import imot.Apartment;

import imot.House;

import imot.Parcel;

public class Demo {

	public static void main(String[] args) {
		 
		String[] names={"Pesho","Mario","Vlado","Sneji","Krasi","Krisi","Tosho"};
		String[] phones = { "0888111222", "0888333444", "0888555666", "0888777888", "0888999000" };
		HashSet<Agent> agents=new HashSet<>();
		
		for (int i = 0; i <5; i++) {
			agents.add(new Agent(names[new Random().nextInt(names.length)],
					phones[new Random().nextInt(phones.length)]));
		}
		//1.
		Agency agency=new Agency("������� �������",agents);
		//2.
		HashSet<Seller> sellers=new HashSet<>();
		for (int i = 0; i < 30; i++) {
			String name=names[new Random().nextInt(names.length)];
			String phone=phones[new Random().nextInt(phones.length)];
			Seller s=new Seller(name,phone,generateImot());
			sellers.add(s);
		}
		
		//3. ������ ��������� �� ����������� ������� �� �� �������� � ���������; 
		for (Seller seller : sellers) {
			seller.registrateImot(agency);
		}
		
		//4.�� �� �������� 10 �������� �� ���������� ������� � ������� ����� 30 000 � 150 000 ����; 
		HashSet<Buyer> buyers=new HashSet<>();
		for (int i = 0; i < 10; i++) {
			Buyer b=new Buyer(names[new Random().nextInt(names.length)],
							  phones[new Random().nextInt(phones.length)],
							  new Random().nextInt(120_000)+30_000);
			buyers.add(b);
		}
	    //5.������ �������� �� ����������� ������ �� ������� �� ���� ��� ���������;
		for (Buyer buyer : buyers) {
			buyer.searchImot(agency);
		}
		
		// 6.����� ������� �� ����� 3 ������ �� ���������� ����� �� ���������;
		for (Buyer buyer : buyers) {
			buyer.viewImot(agency.getRandomImot());
			buyer.viewImot(agency.getRandomImot());
			buyer.viewImot(agency.getRandomImot());
		}
		//7. ����� ������� �� ������ ������� �� ����� �� ���������� �� ���� ����� �� ���������� �������;
		for (Buyer buyer : buyers) {
			Imot property = buyer.getRandomImot();
			buyer.buyImot(property, agency);
		}
		
		//8. �� �� ������ �� ������ �������� ������ �� ��������� ���� ���������� �� �������
		System.out.println(agency.getMoney());
	}
	
	public static Imot generateImot(){
		Imot i=null;
		String[] desc={"Ima muhal","Mnogo e hubav","Mnogo e skup","Ujasen e"};
		String[] address={"Cherni vruh","Lulin","Mladost","Nadejda"};
		int chance=new Random().nextInt(3);
		switch(chance){
		case 0:
			i=new Apartment(desc[new Random().nextInt(desc.length)],address[new Random().nextInt(address.length)],
					new Random().nextInt(80_000)+70_000, new Random().nextInt(260) + 40,
					Apartment.getRandomApartamentType(),
					Imot.getRandomConstructionType());
			break;
		case 1:
			i=new House(desc[new Random().nextInt(desc.length)],address[new Random().nextInt(address.length)],
					new Random().nextInt(30_000)+50_000, new Random().nextInt(260) + 40,
					House.getRandomHouseType(),
					Imot.getRandomConstructionType(),new Random().nextInt(4),new Random().nextInt(400)+1);
		case 2:
			i=new Parcel(desc[new Random().nextInt(desc.length)],address[new Random().nextInt(address.length)],
					new Random().nextInt(55_000)+30_000, new Random().nextInt(260) + 40,
					Parcel.getRandomParcelType(),new Random().nextBoolean());
		default: 
			break;
			
		}
		return i;
	}
}
