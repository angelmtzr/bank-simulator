package up.ppf.banksimulator.models;

public class ExecutiveFractionsModel {
    private String idleFraction;
    private String busyFraction;
    private String takingBreakFraction;

    public ExecutiveFractionsModel(String idleFraction, String busyFraction, String takingBreakFraction) {
        this.idleFraction = idleFraction;
        this.busyFraction = busyFraction;
        this.takingBreakFraction = takingBreakFraction;
    }

    public String getIdleFraction() {
        return idleFraction;
    }

    public void setIdleFraction(String idleFraction) {
        this.idleFraction = idleFraction;
    }

    public String getBusyFraction() {
        return busyFraction;
    }

    public void setBusyFraction(String busyFraction) {
        this.busyFraction = busyFraction;
    }

    public String getTakingBreakFraction() {
        return takingBreakFraction;
    }

    public void setTakingBreakFraction(String takingBreakFraction) {
        this.takingBreakFraction = takingBreakFraction;
    }
}
