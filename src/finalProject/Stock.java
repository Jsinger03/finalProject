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
}
