package aut.testcreation.testcases;

import aut.testcreation.pages.vuelos.RumboHomePage;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Test;

public class TC005_POM extends SeleniumTestBase {
    RumboHomePage rumboHomePage;

    @Test
    void buscarVueloIdaNoOk() throws InterruptedException {
        rumboHomePage = new RumboHomePage(DriverFactory.getDriver());
        rumboHomePage.irARumboYCookies(true);
        rumboHomePage.seleccionarVueloSoloIda();
        rumboHomePage.limpiarCampos(true, false);
        rumboHomePage.agregarDestino("Osaka (OSA)");
        rumboHomePage.fechaSoloIda();
        rumboHomePage.numPasajeros(false);
        rumboHomePage.realizarBusqueda();
        if (rumboHomePage.mensajeErrorOrigen().equals("Introduce ciudad o aeropuerto de origen")) {
            System.out.println("Test completado con éxito: Mensaje de error 'Introduce ciudad o aeropuerto de origen' encontrado y desplegado en pantalla.\n");
        } else {
            System.out.println("Test sin éxito: Mensaje de error 'Introduce ciudad o aeropuerto de origen' no ha sido encontrado o desplegado en pantalla \n");
        }
    }
}