package com.store.steps;

import com.store.factory.agregardireccionFactory;
import com.store.factory.historialpedidosFactory;
import com.store.utils.Base;
import com.store.utils.Hooks;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

public class HistorialPedidosStepd  extends Base {

    public HistorialPedidosStepd(Hooks hooks) {
        this.hooks = hooks;
    }

    protected Hooks hooks;

    historialpedidosFactory HistorialpedidosFactory = new historialpedidosFactory(driver);


    @Cuando("selecciona la opcion de historial de pedidos")
    public void seleccionaLaOpcionDeHistorialDePedidos() throws InterruptedException {
        HistorialpedidosFactory.Historialpedidos();
    }
    @Entonces("se visualiza los pedidos completados")
    public void seVisualizaLosPedidosCompletados() {

        HistorialpedidosFactory.HistoryAssertion();
    }











}
