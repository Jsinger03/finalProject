package finalProject;

public class Stock {
	private String name;
	private String symbol;
	private float price;
	public Stock() {
		name="";
		symbol="";
		price=-1;
	}
	public Stock(String n, String s, float p) {
		name = n;
		symbol = s;
		price = p;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}
