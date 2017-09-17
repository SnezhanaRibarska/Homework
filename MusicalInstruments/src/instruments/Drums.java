package instruments;
import instruments.Instrument.InstrumentType;

public class Drums extends Instrument{

	public Drums(String name, double price, int quantiti) {
		super(name, price, quantiti);
	}

	@Override
	public InstrumentType getType() {
		return InstrumentType.UDARNI;
	}

}
