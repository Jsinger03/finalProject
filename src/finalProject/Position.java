package finalProject;


public class Position {
	
	// data fields
	Stock stock;
	float purchase_price;
	float num_shares;
	
	// extra
	float total_cost = purchase_price * num_shares;
	float total_value = stock.getPrice() * num_shares;
	float profit_loss = total_value - total_cost;
	
	// constructors
	public Position(Stock stock, float purchase_price, float num_shares) {
		this.stock = stock;
		this.purchase_price = purchase_price;
		this.num_shares = num_shares;
	}
	
	// getters and setters
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public float getPurchase_price() {
		return purchase_price;
	}
	public void setPurchase_price(float purchase_price) {
		this.purchase_price = purchase_price;
	}
	public float getNum_shares() {
		return num_shares;
	}
	public void setNum_shares(float num_shares) {
		this.num_shares = num_shares;
	}
	public float getTotal_cost() {
		return total_cost;
	}
	public void setTotal_cost(float total_cost) {
		this.total_cost = total_cost;
	}
	public float getTotal_value() {
		return total_value;
	}
	public void setTotal_value(float total_value) {
		this.total_value = total_value;
	}
	public float getProfit_loss() {
		return profit_loss;
	}
	public void setProfit_loss(float profit_loss) {
		this.profit_loss = profit_loss;
	}
	
}
