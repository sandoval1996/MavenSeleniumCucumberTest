package com.store.steps;

import com.store.factory.iniciarsesionFactory;
import com.store.factory.registroFactory;
import com.store.utils.Base;
import com.store.utils.Hooks;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import java.util.List;
import java.util.Map;

public class IniciarSesionsStep extends Base {

    public IniciarSesionsStep(Hooks hooks) {
        this.hooks = hooks;
    }

    protected Hooks hooks;

    iniciarsesionFactory IniciarsesionFactory = new iniciarsesionFactory(driver);


    @Dado("Ingreso al Login")
    public void IngresoAlLogin()
    {
       IniciarsesionFactory.AccederLogin();
    }

    @Cuando("Ingresar la informacion de  usuarios")
    public void ingresarLaInformacionDeUsuarios(io.cucumber.datatable.DataTable dataTable) {

        List<List<String>> data = dataTable.asLists(String.class);
        for (List<String> list: data)
        {
            IniciarsesionFactory.Login(list.get(0), list.get(1));
        }



    }

    @Entonces("se evidencia que se muestra el mensaje del inicio de sesion exitoso")
    public void seEvidenciaQueSeMuestraElMensajeDelInicioDeSesionExitoso() {
        IniciarsesionFactory.ValidarInicioSesionExitoso();

    }

    @Entonces("se evidencia que se muestra el mensaje del inicio de sesion fallido")
    public void seEvidenciaQueSeMuestraElMensajeDelInicioDeSesionFallido() {

       IniciarsesionFactory.ValidarInicioSesionFallido();
    }
}