package com.reto.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.targets.Target.the;

public class DetalleDelCarritoExitosoPage {

    public static final Target PRODUCTOS_DE_LA_ORDEN =
            the("Cantidad de productos de la orden")
                    .located(By.xpath("//*[@data-testid=\"total-products-count\"]"));
    public static final Target TOTAL_DE_LA_ORDEN =
            the("Cantidad de productos de la orden")
                    .located(By.xpath("//*[@data-testid=\"total-amount\"]"));

}
