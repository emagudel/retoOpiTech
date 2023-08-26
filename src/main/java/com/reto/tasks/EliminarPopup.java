package com.reto.tasks;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.openqa.selenium.WebElement;

import static com.reto.userinterface.HomePage.BOTON_POPUP;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EliminarPopup implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElement botonPopup = BOTON_POPUP.resolveFor(actor).getElement();
        botonPopup.getShadowRoot().findElement(By.cssSelector("button.airship-btn.airship-btn-deny")).click();
    }

    public static EliminarPopup enElHome(){
        return instrumented(EliminarPopup.class);
    }
}
