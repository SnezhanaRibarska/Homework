package other;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

import cake.Cake;
import cake.Cake.ICakeType;
import cake.Cake.Kind;

public class SweetShop {

	private String name;
	private String address;
	private String gsm;
	private HashSet<Deliver> delivers;
	private HashMap<Kind,HashMap<ICakeType,TreeMap<Cake,Integer>>> vitrina;
	
	public SweetShop(String name, HashSet<Deliver> delivers) {
		this.name = name;
		this.delivers = delivers;
		this.address="Bul Bulgaria";
		this.gsm="0897656507";
		vitrina=new HashMap<>();
		
	}
	
	public void addCake(Cake c, int num) {
		if (num > 0 && c != null) {
		    Kind kind = c.getKind();
		    if (!vitrina.containsKey(kind)) {
			vitrina.put(kind, new HashMap<>());
		    }
		    ICakeType type = c.getIType();
		    if (!vitrina.get(kind).containsKey(type)) {
			vitrina.get(kind).put(type, new TreeMap<>());
		    }
		    vitrina.get(kind).get(type).put(c, num);
		}
	}
	
	public boolean containsKind(javax.tools.Diagnostic.Kind k){
		if(this.vitrina.containsKey(k)){
			return true;
		}
		return false;
	}

	public Set<ICakeType> viewKind(javax.tools.Diagnostic.Kind k){
		return this.vitrina.get(k).keySet();
	}

	
	
}
