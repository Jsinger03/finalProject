package finalProject;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Portfolio {
    private int portfolioId;
    private int ownerId;
    private List<Position> positions;

    public Portfolio() {
        positions = new ArrayList<>();
    }

    public Portfolio(int portfolioId, int ownerId) {
        this.portfolioId = portfolioId;
        this.ownerId = ownerId;
        this.positions = new ArrayList<>();
    }

    public int getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(int portfolioId) {
        this.portfolioId = portfolioId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public void addPosition(Position p) {
        this.positions.add(p);
    }

    public void removePosition(Position p) {
        this.positions.remove(p);
    }

    public void updatePosition(Position updated) {
        for (int i = 0; i < positions.size(); i++) {
            if (positions.get(i).getPositionId() == updated.getPositionId()) {
                positions.set(i, updated);
                break;
            }
        }
    }
/* 
    public double calculateTotalValue(Map<Integer, Double> currentPrices) {
        double total = 0.0;
        for (Position p : positions) {
            double currentPrice = currentPrices.getOrDefault(p.getStockId(), 0.0);
            total += p.getMarketValue(currentPrice);
        }
        return total;
    }

    public double getProfitLoss(Map<Integer, Double> currentPrices) {
        double pl = 0.0;
        for (Position p : positions) {
            double currentPrice = currentPrices.getOrDefault(p.getStockId(), 0.0);
            pl += p.getUnrealizedProfitLoss(currentPrice);
        }
        return pl;
    }
		*/
	public void get_overview() {
		float total_value = 0;
		float total_cost = 0;
		for (int i = 0; i < positions.size(); i++) {
			float value = positions.get(i).getCurrent_value();
			float cost = positions.get(i).getTotal_cost();
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
