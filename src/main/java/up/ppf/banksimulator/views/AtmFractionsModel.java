package up.ppf.banksimulator.views;

public class AtmFractionsModel {
    private String occupiedFraction;
    private String availableFraction;
    private String outOfOrderFraction;

    public AtmFractionsModel(String occupiedFraction, String availableFraction, String outOfOrderFraction) {
        this.occupiedFraction = occupiedFraction;
        this.availableFraction = availableFraction;
        this.outOfOrderFraction = outOfOrderFraction;
    }

    public String getOccupiedFraction() {
        return occupiedFraction;
    }

    public void setOccupiedFraction(String occupiedFraction) {
        this.occupiedFraction = occupiedFraction;
    }

    public String getAvailableFraction() {
        return availableFraction;
    }

    public void setAvailableFraction(String availableFraction) {
        this.availableFraction = availableFraction;
    }

    public String getOutOfOrderFraction() {
        return outOfOrderFraction;
    }

    public void setOutOfOrderFraction(String outOfOrderFraction) {
        this.outOfOrderFraction = outOfOrderFraction;
    }
}
