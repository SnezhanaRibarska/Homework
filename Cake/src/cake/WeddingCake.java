package cake;

public class WeddingCake extends Cake implements Comparable<WeddingCake>{

	public enum WeddingCakeType implements ICakeType{
		BIG,SMALL,AVERAGE
	}
	private int floor;
	private WeddingCakeType type;
	
	
	public WeddingCake(String name, String description, int price, int brPiece, WeddingCakeType type,int floor) {
		super(name, description, price, brPiece, Kind.WEDDING);
		this.floor=floor;
		this.type=type;
	}

	@Override
	public int compareTo(WeddingCake k) {
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
