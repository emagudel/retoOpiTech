package com.reto.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;

import static com.reto.userinterface.DetalleDelCarritoExitosoPage.PRODUCTOS_DE_LA_ORDEN;
import static com.reto.userinterface.DetalleDelCarritoExitosoPage.TOTAL_DE_LA_ORDEN;
import static com.reto.userinterface.HomePage.BOTON_CARRITO;
import static com.reto.util.constant.ConstantManager.*;

public class DetalleDelCarrito implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        boolean resultadoCantidad = false;
        boolean resultadoPrecios = false;
        actor.attemptsTo(
                Click.on(BOTON_CARRITO)
        );
        Integer valorCantProductos = CONTEO_PRODUCTOS + CONTEO_GARANTIAS;
        String valorCantResumen = PRODUCTOS_DE_LA_ORDEN.resolveAllFor(actor).get(0).getText()
                .replace("(", "")
                .replace(")", "")
                .replace("productos", "")
                .trim();
        Integer valorTotalProductos = VALOR_PRODUCTO + VALOR_GARANTIA;
        String valorTotalResumen = TOTAL_DE_LA_ORDEN.resolveAllFor(actor).get(0).getText()
                .replace("$ ", "")
                .replace(".", "")
                .trim();

        resultadoCantidad = valorCantProductos.equals(Integer.parseInt(valorCantResumen));
        resultadoPrecios = valorTotalProductos.equals(Integer.parseInt(valorTotalResumen));
        return resultadoCantidad == resultadoPrecios;
    }

    public static DetalleDelCarrito esExitoso() {
        return new DetalleDelCarrito();
    }
}
