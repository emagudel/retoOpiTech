package com.reto.tasks;

import com.reto.interactions.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.type.Type;
import org.openqa.selenium.*;

import static com.reto.userinterface.BookStorePage.*;
import static com.reto.util.constant.ConstantManager.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class BuscarLibro implements Task {

    private String producto;

    public BuscarLibro(String producto) {
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Wait.aTime(5000)
        );
        WebDriver driver = getProxiedDriver();
        NOMBRE_LIBRO = producto;
        if (BUSCAR_PRODUCTO.resolveFor(actor).isVisible() && !MSG_NO_ROWS_FOUND.resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    Type.theValue(producto).into(BUSCAR_PRODUCTO)
            );
            WebElement webElementProducto = driver.findElement(By.xpath("//*[@id=\"see-book-" + producto + "\"]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webElementProducto);
            webElementProducto.click();
            actor.attemptsTo(
                    Wait.aTime(5000),
                    Scroll.to(AGREGAR_PRODUCTO),
                    Click.on(AGREGAR_PRODUCTO)
            );
            actor.attemptsTo(
                    Wait.aTime(5000)
            );
            Alert alert = driver.switchTo().alert();
            String messageBookAdded = alert.getText();
            if (messageBookAdded.contains(MESSAGE_BOOK_ADD)) {
                alert.accept();
            }else {
                alert.dismiss();
            }
            BUSQUEDA = true;
        }else {
            BUSQUEDA = false;
        }

    }

    public static BuscarLibro unProducto(String producto) {
        return instrumented(BuscarLibro.class, producto);
    }
}
