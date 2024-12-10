package finalProject;

public class Position {
    private int positionId;
    private int portfolioId;
    private int stockId;
    private int quantity;
    private double averageCost;

    public Position() {}

    public Position(int positionId, int portfolioId, int stockId, int quantity, double averageCost) {
        this.positionId = positionId;
        this.portfolioId = portfolioId;
        this.stockId = stockId;
        this.quantity = quantity;
        this.averageCost = averageCost;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public int getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(int portfolioId) {
        this.portfolioId = portfolioId;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAverageCost() {
        return averageCost;
    }

    public void setAverageCost(double averageCost) {
        this.averageCost = averageCost;
    }

    public double getMarketValue(double currentPrice) {
        return currentPrice * quantity;
    }

    public double getUnrealizedProfitLoss(double currentPrice) {
        return (currentPrice - averageCost) * quantity;
    }
}