package com.reto.questions;

import com.reto.interactions.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.reto.userinterface.HomePage.MENU_PROFILE;
import static com.reto.util.constant.ConstantManager.NOMBRE_LIBRO;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class DetalleDelProducto implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        boolean resultBookAddProfile = false;
        WebDriver driver = getProxiedDriver();
        actor.attemptsTo(
                Wait.aTime(3000),
                Scroll.to(MENU_PROFILE),
                Click.on(MENU_PROFILE)
        );
        resultBookAddProfile = driver.findElement(By.xpath("//*[@id=\"see-book-" + NOMBRE_LIBRO + "\"]")).isDisplayed();
        return resultBookAddProfile;
    }

    public static DetalleDelProducto esExitoso() {
        return new DetalleDelProducto();
    }
}
