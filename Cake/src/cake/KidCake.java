package cake;

public class KidCake extends Cake implements Comparable<KidCake> {

	public enum KidCakeType implements ICakeType{
		BIRTHDAY, KRUSHTENE, PROSHTAPULNIK
	};

	private String kidName;
	private KidCakeType type;


	public KidCake(String name, String description, int price, int brPiece,String kidName,KidCakeType t) {
		super(name, description, price, brPiece, Kind.CHILDREN);
		this.kidName=kidName;
		this.type=t;
	}

	@Override
	public int compareTo(KidCake k) {
		if(this.getBrPiece()==k.getBrPiece()){
			return 0;
		}
		else{
			if(this.getBrPiece()>k.getBrPiece()){
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
