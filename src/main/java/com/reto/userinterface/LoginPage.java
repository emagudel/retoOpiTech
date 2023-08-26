package com.reto.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.targets.Target.the;

public class LoginPage extends PageObject {

    public static final Target USER_NAME =
            the("Nombre de usuario")
                    .located(By.id("userName"));

    public static final Target PASSWORD =
            the("Contraseña")
                    .located(By.id("password"));

    public static final Target USER_NAME_PROFILE =
            the("Usuario logueado")
                    .located(By.xpath("//*[@id='userName-value']"));

}
