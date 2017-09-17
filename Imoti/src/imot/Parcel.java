package imot;

import java.util.Random;

import imot.House.IHouseType;
import imot.Imot.ConstructionType;
import imot.Imot.IImotType;
import imot.Parcel.IParcelType;

public class Parcel extends Imot {

	public Parcel(String description, String address, double price, double area,
			IParcelType type, boolean isRegular) {
		super(description, address, price, area);
		this.kind=Kind.PARCEL;
		this.type=type;
		this.isRegular=isRegular;
	}
	
	protected enum IParcelType implements IImotType{NIVA,POLQNA,GORA}; 
	
	private IParcelType type;
	private boolean isRegular;
	public static IParcelType getRandomParcelType() {
		int chance = new Random().nextInt(IParcelType.values().length);
		switch(chance){
		case 0:
			return IParcelType.GORA;
		case 1:
			return IParcelType.NIVA;
		case 2:
			return IParcelType.POLQNA;
		}
		return null;
	}
	
}
