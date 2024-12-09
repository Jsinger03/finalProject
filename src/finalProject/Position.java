
public class Position {
	Stock stock;
	float purchase_price;
	float num_shares;
	float current_value;
	
	float total_cost = purchase_price * num_shares;
	float total_value = stock.getPrice() * num_shares;
	float profit_loss = total_value - total_cost;
	
}
