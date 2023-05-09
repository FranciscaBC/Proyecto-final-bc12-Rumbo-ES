package aut.testcreation.testcases;

import aut.testcreation.pages.vuelos.RumboHomePage;
import aut.testcreation.pages.vuelos.FormularioVuelosPage;
import aut.testcreation.pages.vuelos.OfertasVuelosPage;
import aut.testcreation.pages.vuelos.TarifaVueloPage;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Test;

public class TC003_POM extends SeleniumTestBase {
    RumboHomePage rumboHomePage;
    OfertasVuelosPage ofertasVuelosPage;
    TarifaVueloPage tarifaVueloPage;
    FormularioVuelosPage formularioVuelosPage;

    @Test
    void registroVueloNoOk() throws InterruptedException {
        rumboHomePage = new RumboHomePage(DriverFactory.getDriver());
        ofertasVuelosPage = new OfertasVuelosPage(DriverFactory.getDriver());
        tarifaVueloPage = new TarifaVueloPage(DriverFactory.getDriver());
        formularioVuelosPage = new FormularioVuelosPage(DriverFactory.getDriver());
        rumboHomePage.irARumboYCookies(true);
        rumboHomePage.seleccionarVueloIdaVuelta();
        rumboHomePage.limpiarCampos(true, false);
        rumboHomePage.agregarOrigen("Santiago (SCL)");
        rumboHomePage.agregarDestino("Cancún (CUN)");
        rumboHomePage.fechas();
        rumboHomePage.numPasajeros(false);
        rumboHomePage.realizarBusqueda();
        ofertasVuelosPage.cambiarPestaniaARumbo();
        ofertasVuelosPage.filtrarUnitedAirlines();
        ofertasVuelosPage.seleccionarOferta();
        tarifaVueloPage.elegirTarifa(true);
        formularioVuelosPage.datosPrincipalesContacto("Ana", "Rodriguez", "Holamundo2222@gmail.com", "9874563");
        formularioVuelosPage.preguntarSaludoAContacto(false);
        formularioVuelosPage.fechaNacimientoContacto("15", "2022");
        formularioVuelosPage.bajarYPresionarEnSgte();
        if (formularioVuelosPage.mensajeErrorAnnioEncontrado().equals("El adulto debe tener más de 12 años")) {
            System.out.println("Test completado con éxito: Al escribir año de nacimiento 2022, el sistema muestra mensaje de error esperado.");
        } else {
            System.out.println("Test sin éxito: A pesar de escribir año de nacimiento 2022, el sistema no verifica el error: Menor de 12 años.");
        }
    }
}