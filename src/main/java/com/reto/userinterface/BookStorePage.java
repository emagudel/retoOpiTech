package com.reto.userinterface;

import net.serenitybdd.core.pages.PageObject;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.targets.Target.the;

public class BookStorePage extends PageObject {

    public static final Target BUSCAR_PRODUCTO = the("Buscar producto").located(By.id("searchBox"));
    public static final Target SELECCIONAR_PRODUCTO = the("Seleccionar producto").locatedBy("//*[@id=\"see-book-{0}\"]");
    public static final Target AGREGAR_PRODUCTO = the("Agregar producto").located(By.xpath("//button[text()='Add To Your Collection']"));
    public static final Target ELIMINAR_PRODUCTO = the("Eliminar producto").located(By.id("delete-record-undefined"));
    public static final Target BOTON_ELIMINAR_OK = the("Boton Eliminar Ok").located(By.id("closeSmallModal-ok"));
    public static final Target MSG_NO_ROWS_FOUND = the("Mensaje no encontro informacion").located(By.className("rt-noData"));

}

