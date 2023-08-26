package com.reto.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;

import static com.reto.userinterface.CategoriaSubCategoria.CATEGORIA;
import static com.reto.userinterface.CategoriaSubCategoria.SUBCATEGORIA;
import static com.reto.userinterface.HomePage.MENU;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Seleccionar implements Task {

    private String categoria, subCategoria;

    public Seleccionar(String categoria, String subCategoria) {
        this.categoria = categoria;
        this.subCategoria = subCategoria;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(MENU),
                MoveMouse.to(CATEGORIA.of(categoria)),
                Click.on(SUBCATEGORIA.of(subCategoria))
        );
    }

    public static Seleccionar unaCategoria_y_Subcategoria(String categoria, String subCategoria){
        return instrumented(Seleccionar.class, categoria, subCategoria);
    }
}
