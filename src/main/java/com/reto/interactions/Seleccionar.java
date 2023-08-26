package com.reto.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.reto.userinterface.ProductoPage.SELECCIONAR_PRODUCTO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Seleccionar implements Interaction {

    private String producto;

    public Seleccionar(String producto) {
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> listaValores = SELECCIONAR_PRODUCTO.resolveAllFor(actor);
        for (int iterador = 0; iterador < listaValores.size(); iterador++) {
            String[] datoUI = listaValores.get(iterador).getText().split("\n");
            String dato = datoUI[0];
            if((dato.contains(producto))){

                //SELECCIONAR_PRODUCTO.resolveAllFor(actor).get(iterador).click();
                break;
            }
        }
    }

    public static Seleccionar elProducto(String producto){
        return instrumented(Seleccionar.class, producto);
    }

}
