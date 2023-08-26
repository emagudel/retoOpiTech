package com.reto.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.targets.Target.the;

public class HomePage extends PageObject {

    public static final Target MENU_TOOLS_QA =
            the("Menu")
                    .located(By.className("menu-list"));

    public static final Target MENU =
            the("Menu")
                    .located(By.xpath("//span[contains(.,'Menú')]"));

    public static final Target BOTON_POPUP =
            the("Boton de popup")
                    .located(By.className("airship-html-prompt-shadow"));

    public static final Target BOTON_COOKIES =
            the("Boton de cookies")
                    .located(By.id("testId-accept-cookies-btn"));

    public static final Target BOTON_CARRITO =
            the("Boton de carrito")
                    .located(By.id("testId-UserAction-basket"));

}
