package com.reto.tasks;

import com.reto.interactions.Seleccionar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.type.Type;

import static com.reto.userinterface.ProductoPage.*;
import static com.reto.util.constant.ConstantManager.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Adicionar implements Task {

    private String producto;

    public Adicionar(String producto) {
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Seleccionar.elProducto(producto)
        );
        CANTIDAD.resolveFor(actor).clear();
        actor.attemptsTo(
                Type.theValue(CANTIDAD_ARTICULOS).into(CANTIDAD),
                Scroll.to(BOTON_AGREGAR_AL_CARRITO),
                Click.on(BOTON_AGREGAR_AL_CARRITO)
        );
        CONTEO_PRODUCTOS = CONTEO_PRODUCTOS + Integer.parseInt(CANTIDAD_ARTICULOS);
        VALOR_PRODUCTO = VALOR_PRODUCTO + Integer.parseInt(PRECIO_DEL_PRODUCTO.resolveFor(actor).getText()
                .replace("$","")
                .replace(".","")
                .trim()) * Integer.parseInt(CANTIDAD_ARTICULOS);
        if(BOTON_AGREGAR_GARANTIA_2_AÑO.isVisibleFor(actor)){
            actor.attemptsTo(
                    Scroll.to(BOTON_AGREGAR_GARANTIA_2_AÑO),
                    Click.on(BOTON_AGREGAR_GARANTIA_2_AÑO)
            );
            CONTEO_GARANTIAS = CONTEO_GARANTIAS + 2;
            VALOR_GARANTIA = VALOR_GARANTIA + Integer.parseInt(PRECIO_DE_LA_GARANTIA.resolveFor(actor).getText()
                    .replace("$","")
                    .replace(".","")
                    .trim()) * 2;
            actor.attemptsTo(
                    Scroll.to(SEGUIR_COMPRANDO),
                    Click.on(SEGUIR_COMPRANDO)
            );
        }else{
            actor.attemptsTo(
                    Scroll.to(SEGUIR_COMPRANDO),
                    Click.on(SEGUIR_COMPRANDO)
            );
        }

    }

    public static Adicionar unProducto(String producto){
        return instrumented(Adicionar.class, producto);
    }
}
