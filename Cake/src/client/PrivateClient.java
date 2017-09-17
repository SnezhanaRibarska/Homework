package client;

public class PrivateClient extends Client {

	int discount;
	int br;
	
	public PrivateClient(String name, String gsm,int money,int dis,int count) {
		super(name, gsm,money);
		this.discount=dis;
		this.br=count;
	}

	@Override
	public void makeOrder() {
		// TODO Auto-generated method stub
		
	}

}
