package com.reto.stepdefinitions;

import com.reto.interactions.Abrir;
import com.reto.questions.DetalleDelCarrito;
import com.reto.tasks.*;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.ensure.Ensure;

import static com.reto.util.constant.ConstantManager.USER;
import static com.reto.util.constant.ConstantManager.USER_PROFILE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class BuscarLibrosStepDefinition {

    @Dado("que {word} ingresa a la pagina para buscar libros")
    public void queElUsuarioIngresaAlaPagina(String nombreActor) {
        theActorCalled(nombreActor).wasAbleTo(
                Abrir.elNavegador()
        );
    }

    @Y("verifico que al loguearse sea el nombre del usuario registrado")
    public void verifico_al_usuario_registrado() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(USER).isEqualTo(USER_PROFILE));
    }

    @Y("selecciona la categoria {string} y subcategoria {string}")
    public void seleccionalacategoriaSubcategoria(String categoria, String subCategoria) {
        withCurrentActor(Seleccionar.unaCategoria_y_Subcategoria(categoria, subCategoria));
    }

    @Y("selecciona otra categoria {string} y otra subcategoria {string}")
    public void seleccionaOtracategoriaOtraSubcategoria(String categoria, String subCategoria) {
        withCurrentActor(Seleccionar.unaCategoria_y_Subcategoria(categoria, subCategoria));
    }

    @Cuando("el usuario busca el libro {string}")
    public void elUsuarioBuscaEllibro(String producto) {
        withCurrentActor(Adicionar.unProducto(producto));
    }

    @Entonces("el usuario deberia de ver el detalle del carrito exitosamente")
    public void elUsuarioDeberiaDeVerElDetalleExitosamente() {
        theActorInTheSpotlight().should(seeThat(DetalleDelCarrito.esExitoso()));
    }

}
