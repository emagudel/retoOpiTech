package com.reto.stepdefinitions;

import com.reto.interactions.Abrir;
import com.reto.questions.DetalleDelProducto;
import com.reto.questions.DetalleDelProductoEliminado;
import com.reto.questions.DetalleDelProductoFallido;
import com.reto.tasks.*;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.ensure.Ensure;

import static com.reto.util.constant.ConstantManager.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class BuscarLibrosStepDefinition {

    @Dado("que {word} ingresa a la pagina")
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

    @Cuando("el usuario busca el libro {string}")
    public void elUsuarioBuscaEllibro(String producto) {
        withCurrentActor(BuscarLibro.unProducto(producto));
    }

    @Entonces("el usuario deberia de ver el libro en el profile exitosamente")
    public void elUsuarioDeberiaDeVerElLibroExitosamente() {
        theActorInTheSpotlight().should(seeThat(DetalleDelProducto.esExitoso()));
    }

    @Entonces("el usuario NO deberia de ver el libro en el profile exitosamente")
    public void elUsuarioNODeberiaDeVerElLibroExitosamente() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(BUSQUEDA).isEqualTo(BUSQUEDA_FALLIDA));
    }

    @Y("luego elimino el libro y verifico que no este presente en el profile")
    public void luego_elimino_el_libro_y_verifico_que_no_este_presente_en_profile() {
        theActorInTheSpotlight().should(seeThat(DetalleDelProductoEliminado.esExitoso()));
    }

}
