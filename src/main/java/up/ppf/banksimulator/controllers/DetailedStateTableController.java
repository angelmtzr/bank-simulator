package up.ppf.banksimulator.controllers;

import up.ppf.banksimulator.models.DetailedStateTableModel;
import up.ppf.banksimulator.views.DetailedStateTableView;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DetailedStateTableController {

    public DetailedStateTableController(DetailedStateTableView view, DetailedStateTableModel model) {
        Executors.newScheduledThreadPool(5).scheduleAtFixedRate(() -> {
            model.getBank().getClients().forEach(view::setClientStateRow);
//            model.getBank().getAtms().forEach(view::setClientStateRow);
//            model.getBank().getExecutives().forEach(view::setClientStateRow);
        }, 0, 100, TimeUnit.MILLISECONDS);
    }
}
