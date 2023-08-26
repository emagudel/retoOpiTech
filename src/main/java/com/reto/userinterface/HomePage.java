package com.reto.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.targets.Target.the;

public class HomePage extends PageObject {

    public static final Target MENU_TOOLS_QA =
            the("Menu")
                    .located(By.className("menu-list"));

    public static final Target MENU_PROFILE =
            the("Menu Profile")
                    .located(By.xpath("//*[@id='item-3']//span[contains(.,'Profile')]"));

}
