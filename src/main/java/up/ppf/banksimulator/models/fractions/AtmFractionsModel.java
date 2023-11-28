package up.ppf.banksimulator.models.fractions;

public class AtmFractionsModel {
    private String occupiedFraction;
    private String availableFraction;
    private String outOfOrderFraction;

    public AtmFractionsModel(String availableFraction, String occupiedFraction, String outOfOrderFraction) {
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
