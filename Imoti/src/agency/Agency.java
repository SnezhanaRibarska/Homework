package agency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

import imot.Imot;
import imot.Imot.Kind;

public class Agency {

	private double money;
	private String name;
	private String address;
	private String gsm;
	private HashSet<Agent> agents;
	private ArrayList<Imot> catalog;
	
	public Agency(String name, HashSet<Agent> agents) {
		this.name = name;
		this.agents = agents;
	}
	
	public Agent getRandomAgent(){
		Agent[] a=agents.toArray(new Agent[agents.size()]);
		return a[new Random().nextInt(a.length)];
	}

	public void addImot(Imot i) {
		catalog.add(i);
	}
	
	public void getCommision(Agent a,double commision){
		a.setMoney(money + commision*0.5);
		this.money=this.money+commision*0.5;
	}
	
	public Imot getRandomImot(){
		return catalog.get(new Random().nextInt(catalog.size()));
	}

	public double getMoney() {
		return money;
	}
}
