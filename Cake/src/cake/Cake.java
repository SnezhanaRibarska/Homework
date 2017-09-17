package cake;

import cake.Cake.ICakeType;

public abstract class Cake {

	public interface ICakeType{};
	
	public enum Kind{
		STANDART,SPECIAL,CHILDREN,WEDDING
	};
	
	public Cake(String name, String description, int price, int brPiece, Kind kind) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.brPiece = brPiece;
		this.kind = kind;
	}

	private String name;
	private String description;
	private int price;
	private int brPiece;
	private Kind kind;
	
	protected int getBrPiece(){
		return brPiece;
	}
	
	protected int getPrice(){
		return price;
	}
	
	public Kind getKind(){
		return kind;
	}

	public abstract ICakeType getIType();

}
