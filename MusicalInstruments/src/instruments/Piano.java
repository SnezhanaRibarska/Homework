package instruments;
public class Piano extends Instrument {

	public Piano(String name, double price, int quantiti) {
		super(name, price, quantiti);
	}

	@Override
	public InstrumentType getType() {
		return InstrumentType.KLAVIRNI;
	}
	

}
