package up.ppf.banksimulator;

public class GeneralStateTableParamsModel {
    private final int clientsNumber;
    private final int atmsNumber;
    private final int executiveNumber;
    private final int atmsLineSize;
    private final int executivesLineSize;

    public GeneralStateTableParamsModel(int clientsNumber, int atmsNumber,
                                        int executiveNumber, int atmsLineSize,
                                        int executivesLineSize) {
        this.clientsNumber = clientsNumber;
        this.atmsNumber = atmsNumber;
        this.executiveNumber = executiveNumber;
        this.atmsLineSize = atmsLineSize;
        this.executivesLineSize = executivesLineSize;
    }

    public int getClientsNumber() {
        return clientsNumber;
    }

    public int getAtmsNumber() {
        return atmsNumber;
    }

    public int getExecutiveNumber() {
        return executiveNumber;
    }

    public int getAtmsLineSize() {
        return atmsLineSize;
    }

    public int getExecutivesLineSize() {
        return executivesLineSize;
    }
}
