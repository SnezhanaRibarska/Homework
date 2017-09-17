package restaurant;

import person.IMutra;
import person.IVegan;

public interface Orderable extends IMutra,IVegan{
	abstract public String getName();
}
