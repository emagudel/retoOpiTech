package com.reto.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.reto.userinterface.BookStorePage.MSG_NO_ROWS_FOUND;

public class DetalleDelProductoFallido implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        boolean result = false;
        result = MSG_NO_ROWS_FOUND.resolveFor(actor).isVisible();
        return result;
    }

    public static DetalleDelProductoFallido esExitoso() {
        return new DetalleDelProductoFallido();
    }
}
