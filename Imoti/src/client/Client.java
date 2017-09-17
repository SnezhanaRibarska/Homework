package client;

import agency.Agency;
import agency.Agent;
import imot.Imot;

public abstract class Client {

	private String name;
	private String gsm;
	protected double money;
	protected Agent a;
	
	public Client(String name, String gsm) {
		this.name = name;
		this.gsm = gsm;
	}
	
	public Agent getAgent(){
		return a;
	}
	
	public void payCommision(Imot imot,Agency agency){
		this.money-=imot.getMoney()*0.03;
		agency.getCommision(imot.getAgent(),imot.getMoney()*0.03);
	}
	
	
	
	
	
}
