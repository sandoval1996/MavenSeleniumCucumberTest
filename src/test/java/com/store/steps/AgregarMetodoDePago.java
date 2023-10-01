package com.store.steps;

import com.store.factory.agregardireccionFactory;
import com.store.factory.agregarmetododepagoFactory;
import com.store.utils.Base;
import com.store.utils.Hooks;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import java.util.List;
import java.util.Map;

public class AgregarMetodoDePago extends Base {

    public AgregarMetodoDePago(Hooks hooks) {
        this.hooks = hooks;
    }

    protected Hooks hooks;

    agregarmetododepagoFactory AgregarmetododepagoFactory = new agregarmetododepagoFactory(driver);



    @Cuando("selecciona la opcion de agregar metodo de pagos")
    public void seleccionaLaOpcionDeAgregarMetodoDePagos() throws InterruptedException {
         AgregarmetododepagoFactory.OpcionAgregarpago();
    }
    @Cuando("Ingresar la informacion de metodo de pagos")
    public void ingresarLaInformacionDeMetodoDePagos(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : data) {
            String nombretarjeta = row.get("NombreTarjeta");
            String numerotarjeta = row.get("NumeroTarjeta");
            String mes = row.get("Mes");
            String anio = row.get("Ano");

            AgregarmetododepagoFactory.IngresarInformacionDePago(nombretarjeta,numerotarjeta,mes,anio);

        }
    }
    @Entonces("se evidencia que guarda la informacion del metodo de pago.")
    public void seEvidenciaQueGuardaLaInformacionDelMetodoDePago() {
        AgregarmetododepagoFactory.paymentAssertion();
    }





}
