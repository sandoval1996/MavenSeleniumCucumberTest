package com.store.steps;

import com.store.factory.registroFactory;
import com.store.utils.Base;
import com.store.utils.Hooks;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;


import java.util.List;
import java.util.Map;

public class RegistroStep extends Base{


    public RegistroStep(Hooks hooks) {this.hooks = hooks;}
    protected Hooks hooks;

    registroFactory RegistroFactory = new registroFactory(driver);


    @Dado("ingreso a la Tienda Jugos Owasp")
    public void ingresoALaTiendaJugosOwasp() throws InterruptedException {
     RegistroFactory.Alerta();
    }
    @Cuando("Realizo el registro de usuarios")
    public void realizoElRegistroDeUsuarios() throws InterruptedException {
     RegistroFactory.realizarRegistro();
    }
    @Cuando("Ingreso la informacion de los usuarios")
    public void ingresoLaInformacionDeLosUsuarios(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : data) {
            String correo = row.get("Correo");
            String contrasema = row.get("Contrasena");
            String repetircontrasena = row.get("RContrasena");
            String respuesta = row.get("Respuesta");

            RegistroFactory.IngresarInformacionUsuario(correo, contrasema, repetircontrasena, respuesta);


        }
    }
    @Entonces("se evidencia que se realizo el registro exitoso")
    public void seEvidenciaQueSeRealizoElRegistroExitoso() {
           RegistroFactory.RegisterAssertion();
    }



}
