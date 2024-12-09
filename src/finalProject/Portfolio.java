package finalProject;
import java.util.ArrayList;

public class Portfolio {
	
	public Portfolio() {
		ArrayList<Position> port = new ArrayList<Position>();
	}
	
	private ArrayList<Position> port;
	
	// function that returns overall portfolio performance
	public void get_overview() {
		float total_value = 0;
		float total_cost = 0;
		for (int i = 0; i < port.size(); i++) {
			float value = port.get(i).getCurrent_value();
			float cost = port.get(i).getTotal_cost();
			total_value += value;
			total_cost += cost;
		}
		float total_profit_loss = total_value - total_cost;
		float percent_gain_loss = (total_profit_loss / total_value) * 100;
		System.out.print("Your total portfolio value is: " + total_value);
		System.out.print("Your total profit/loss is: " + total_profit_loss);
		System.out.print("Your % change is: " + percent_gain_loss + "%");
	}	

}
