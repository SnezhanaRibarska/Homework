package cake;

import cake.SpecialCake.SpecialCakeType;

public class StandartCake extends Cake implements Comparable<StandartCake> {


	public enum StandartCakeType implements ICakeType{
		BISKVITENA,EKLEROVA,PLODOVA,SHOKOLADOVA
	}
	 private StandartCakeType type;
	 private boolean isSiroped;
	 

		public StandartCake(String name, String description, int price, int brPiece,StandartCakeType type,boolean isSiroped) {
			super(name, description, price, brPiece, Kind.STANDART);
			this.type=type;
			this.isSiroped=isSiroped;
		}
	@Override
	public int compareTo(StandartCake o) {
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
