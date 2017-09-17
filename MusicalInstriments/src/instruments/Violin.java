package instruments;
public class Violin extends Instrument {

	public Violin(String name, double price, int quantiti) {
		super(name, price, quantiti);
	}

	@Override
	public InstrumentType getType() {
		return InstrumentType.STRUNNI;
	}

}
