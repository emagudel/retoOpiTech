package com.reto.userinterface;

import net.serenitybdd.core.pages.PageObject;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.targets.Target.the;

public class ProductoPage extends PageObject {

    public static final Target SELECCIONAR_PRODUCTO = the("Seleccionar producto").located(By.className("rt-tr-group"));


    public static final Target BOTON_AGREGAR_AL_CARRITO = the("Boton de carrito").located(By.xpath("//*[@id='add-to-cart-button']"));
    public static final Target BOTON_AGREGAR_GARANTIA_2_AÑO = the("Boton garantia 2 años").located(By.xpath("//*[@class='doc-click-overlay']//span[contains(.,'2 años de Garantía Extendida')]"));
    public static final Target CANTIDAD = the("Cantidad de articulos").located(By.id("quantity-selector-increment-input"));
    public static final Target SEGUIR_COMPRANDO = the("Seguir comprando").located(By.xpath("//button[text()='Seguir comprando']"));
    public static final Target PRECIO_DEL_PRODUCTO = the("Valor del producto").located(By.xpath("//*[@data-internet-price]"));
    public static final Target PRECIO_DE_LA_GARANTIA = the("Valor de la garantia").located(By.xpath("//*[@id=\"__next\"]/div/div/div/div/div/div/div[2]/div/div/div[3]/div/div/table/tbody/tr[1]/td[4]"));




}

