package com.reto.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.reto.userinterface.BookStorePage.SELECCIONAR_PRODUCTO;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class Seleccionar implements Interaction {

    private String producto;

    public Seleccionar(String producto) {
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = getProxiedDriver();
        List<WebElementFacade> listaValores = SELECCIONAR_PRODUCTO.resolveAllFor(actor);
        for (int iterador = 0; iterador < listaValores.size(); iterador++) {
            String[] datoUI = listaValores.get(iterador).getText().split("\n");
            String dato = datoUI[0];
            if((dato.contains(producto))){
                WebElement webElement = driver.findElement(By.xpath("//*[@id=\"see-book-" + producto + "\"]"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
                break;
            }
        }
    }

    public static Seleccionar elProducto(String producto){
        return instrumented(Seleccionar.class, producto);
    }

}
