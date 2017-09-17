package imot;

import java.util.Random;

import imot.House.IHouseType;
import imot.Imot.ConstructionType;

public class Apartment extends Imot {

	public Apartment(String description, String address, double price, double area,
			IApartamentType type,
			ConstructionType construction) {
		super(description, address, price, area);
		this.kind=Kind.APARTAMENT;
		this.type=type;
		this.construction=construction;
	}
	
	protected enum IApartamentType implements IImotType{STUDIO,GARSIONERA,DVUSTAEN,
		TRISTAEN,MEZONET}; 
	
	private IApartamentType type;
	private ConstructionType construction;
	
	public static IApartamentType getRandomApartamentType(){
		int chance=new Random().nextInt(IApartamentType.values().length);
		
		switch(chance){
		case 0:
			return IApartamentType.DVUSTAEN;
		case 1:
			return IApartamentType.GARSIONERA;
		case 2:
			return IApartamentType.MEZONET;
		case 3:
			return IApartamentType.STUDIO;
		case 4:
			return IApartamentType.TRISTAEN;
		}
		return null;
		
	}
	
}
