package com.reto.interactions;

import com.reto.userinterface.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.type.Type;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.reto.userinterface.LoginPage.*;
import static com.reto.userinterface.ProductoPage.SELECCIONAR_PRODUCTO;
import static com.reto.util.constant.ConstantManager.USER;
import static com.reto.util.constant.ConstantManager.USER_PASSWORD;
import static com.reto.util.constant.ConstantManager.USER_PROFILE;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class Abrir implements Interaction {

    private LoginPage homePage;

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = getProxiedDriver();
        actor.attemptsTo(
              Open.browserOn(homePage)
        );
        WebElement webElement = driver.findElement(By.xpath("//*[@id=\"login\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
        actor.attemptsTo(
                Type.theValue(USER).into(USER_NAME),
                Type.theValue(USER_PASSWORD).into(PASSWORD)
        );
        WebElement webElement2 = driver.findElement(By.xpath("//*[@id=\"login\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement2);
        USER_PROFILE = USER_NAME_PROFILE.resolveFor(actor).getText().trim();
    }

    public static Performable elNavegador(){
        return instrumented(Abrir.class);
    }

}
