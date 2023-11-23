package up.ppf.banksimulator;

import up.ppf.banksimulator.agents.AtmLine;
import up.ppf.banksimulator.agents.ExecutiveLine;

public class Bank {
    private final AtmLine atmLine;
    private final ExecutiveLine executiveLine;

    public Bank(AtmLine atmLine, ExecutiveLine executiveLine) {
        this.atmLine = atmLine;
        this.executiveLine = executiveLine;
    }

    public AtmLine getAtmLine() {
        return atmLine;
    }

    public ExecutiveLine getExecutiveLine() {
        return executiveLine;
    }
}
