package com.store.steps;

import com.store.factory.agregarmetododepagoFactory;
import com.store.factory.agregarproductosFactory;
import com.store.utils.Base;
import com.store.utils.Hooks;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import java.util.List;

public class AgregarProductosStep extends Base {

    public AgregarProductosStep(Hooks hooks) {
        this.hooks = hooks;
    }

    protected Hooks hooks;

    agregarproductosFactory AgregarproductosFactory = new agregarproductosFactory(driver);


    @Cuando("agrega los productos")
    public void agregaLosProductos(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        List<List<String>> data = dataTable.asLists(String.class);
        for (List<String> list: data)
        {
            AgregarproductosFactory.Buscarproducto(list.get(0));
            AgregarproductosFactory.Buscarproductos(list.get(1));
            AgregarproductosFactory.Buscarproductos(list.get(2));
        }
    }
    @Cuando("selecciona la direccion y el metodo de pago")
    public void seleccionaLaDireccionYElMetodoDePago() throws InterruptedException {
        AgregarproductosFactory.GestionarCompra();
    }
    @Entonces("se evidencia que completa su orden de pago de los productos")
    public void seEvidenciaQueCompletaSuOrdenDePagoDeLosProductos() {
        AgregarproductosFactory.OrderAssertion();
    }


    @Cuando("agrega los productos aleatorios")
    public void agregaLosProductosAleatorios() throws InterruptedException {
     AgregarproductosFactory.AgregarproductoAleatorio();
    }











}
