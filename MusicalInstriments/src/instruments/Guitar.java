package instruments;
import instruments.Instrument.InstrumentType;

public class Guitar extends Instrument{

	public Guitar(String name, double price, int quantiti) {
		super(name, price, quantiti);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InstrumentType getType() {
		return InstrumentType.STRUNNI;
	}

}
