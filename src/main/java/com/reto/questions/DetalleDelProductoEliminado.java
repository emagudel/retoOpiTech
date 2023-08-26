package com.reto.questions;

import com.reto.interactions.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import static com.reto.userinterface.BookStorePage.BOTON_ELIMINAR_OK;
import static com.reto.userinterface.BookStorePage.ELIMINAR_PRODUCTO;
import static com.reto.util.constant.ConstantManager.MESSAGE_BOOK_DELETE;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class DetalleDelProductoEliminado implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        boolean resultBookDeleteProfile;
        boolean expectedResult = false;
        WebDriver driver = getProxiedDriver();
        actor.attemptsTo(
                Wait.aTime(3000),
                Click.on(ELIMINAR_PRODUCTO),
                Click.on(BOTON_ELIMINAR_OK),
                Wait.aTime(3000)
        );
        Alert alert = driver.switchTo().alert();
        String messageBookDelete = alert.getText();
        if (messageBookDelete.contains(MESSAGE_BOOK_DELETE)) {
            alert.accept();
        }else {
            alert.dismiss();
        }
        resultBookDeleteProfile = BOTON_ELIMINAR_OK.resolveFor(actor).isVisible();
        return resultBookDeleteProfile == expectedResult;
    }

    public static DetalleDelProductoEliminado esExitoso() {
        return new DetalleDelProductoEliminado();
    }
}
