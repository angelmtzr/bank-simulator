package up.ppf.banksimulator.views;

public class ClientFractionsModel {

    private String entranceFraction;
    private String atmLineFraction;
    private String executiveLineFraction;
    private String atmFraction;
    private String executiveFraction;
    private String exitedFraction;

    public ClientFractionsModel(String entranceFraction, String atmLineFraction, String executiveLineFraction,
                                String atmFraction, String executiveFraction, String exitedFraction) {
        this.entranceFraction = entranceFraction;
        this.atmLineFraction = atmLineFraction;
        this.executiveLineFraction = executiveLineFraction;
        this.atmFraction = atmFraction;
        this.executiveFraction = executiveFraction;
        this.exitedFraction = exitedFraction;
    }

    public String getEntranceFraction() {
        return entranceFraction;
    }

    public void setEntranceFraction(String entranceFraction) {
        this.entranceFraction = entranceFraction;
    }

    public String getAtmLineFraction() {
        return atmLineFraction;
    }

    public void setAtmLineFraction(String atmLineFraction) {
        this.atmLineFraction = atmLineFraction;
    }

    public String getExecutiveLineFraction() {
        return executiveLineFraction;
    }

    public void setExecutiveLineFraction(String executiveLineFraction) {
        this.executiveLineFraction = executiveLineFraction;
    }

    public String getAtmFraction() {
        return atmFraction;
    }

    public void setAtmFraction(String atmFraction) {
        this.atmFraction = atmFraction;
    }

    public String getExecutiveFraction() {
        return executiveFraction;
    }

    public void setExecutiveFraction(String executiveFraction) {
        this.executiveFraction = executiveFraction;
    }

    public String getExitedFraction() {
        return exitedFraction;
    }

    public void setExitedFraction(String exitedFraction) {
        this.exitedFraction = exitedFraction;
    }
}
