package com.store.steps;

import com.store.factory.agregardireccionFactory;
import com.store.utils.Base;
import com.store.utils.Hooks;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import java.util.List;
import java.util.Map;

public class AgregarDireccionStep extends Base {

    public AgregarDireccionStep(Hooks hooks) {
        this.hooks = hooks;
    }

    protected Hooks hooks;

    agregardireccionFactory AgregardireccionFactory = new agregardireccionFactory(driver);

    @Cuando("selecciona la opcion de agregar direcciones")
    public void seleccionaLaOpcionDeAgregarDirecciones() throws InterruptedException {

        AgregardireccionFactory.OpcionAgregarDireccion();
    }
    @Cuando("Ingresar la informacion de  la direccion")
    public void ingresarLaInformacionDeLaDireccion(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : data) {
            String pais = row.get("Pais");
            String nombre = row.get("Nombre");
            String celular = row.get("Celular");
            String zip = row.get("Zip");
            String direccion = row.get("Direccion");
            String ciudad = row.get("Ciudad");
            String estado = row.get("Estado");

            AgregardireccionFactory.IngresarDireccion(pais,nombre,celular,zip,direccion,ciudad,estado);

        }

    }
    @Entonces("se evidencia que guarda la informacion de la direccion.")
    public void seEvidenciaQueGuardaLaInformacionDeLaDireccion() throws InterruptedException {
       AgregardireccionFactory.AddressAssertion();
    }




}
