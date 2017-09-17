package imot;

import java.util.Random;

import imot.Apartment.IApartamentType;
import imot.House.IHouseType;
import imot.Imot.ConstructionType;
import imot.Imot.IImotType;

public class House extends Imot{

	public House(String description, String address, double price, double area,IHouseType type,
			ConstructionType construction,int park,double areYard) {
		super(description, address, price, area);
		this.type=type;
		this.construction=construction;
		this.brParkPlace=park;
		this.areaYard=areaYard;
		this.kind=Kind.HOUSE;
		
	}
	
	protected enum IHouseType implements IImotType{ETAJ,CQLA}; 
	
	private IHouseType type;
	private ConstructionType construction;
	private int brParkPlace;
	private double areaYard;
	
	public static IHouseType getRandomHouseType() {
		int chance=new Random().nextInt(IHouseType.values().length);
		switch (chance){
		case 0:
			return IHouseType.CQLA;
		
		case 1:
			return IHouseType.ETAJ;
		}
			return null;
	}
	
}
