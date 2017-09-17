package cake;

import cake.Cake.Kind;

public class SpecialCake extends Cake implements Comparable<SpecialCake> {

	public enum SpecialCakeType implements ICakeType{
		UBILEINA,FIRMENA,REKLAMNA,
	};
	
	private SpecialCakeType type;
	private String subitieName;
	

	public SpecialCake(String name, String description, int price, int brPiece, SpecialCakeType subitie,String subitieName) {
		super(name, description, price, brPiece, Kind.SPECIAL);
		this.type=subitie;
		this.subitieName=subitieName;
	}

	@Override
	public int compareTo(SpecialCake o) {
		if(this.getPrice()==o.getPrice()){
			return 0;
		}
		else{
			if(this.getPrice()>o.getPrice()){
				return 1;
			}
			else{
				return -1;
			}
		}
	}

	@Override
	public ICakeType getIType() {
		return this.type;
	}

}
