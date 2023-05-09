package aut.testcreation.testcases.ejemplosDomingo;
import aut.testcreation.pages.vuelos.RumboHomePage;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class atc01_POM extends SeleniumTestBase {

    RumboHomePage googleHomePage;

    @Test
    @Tag("regresion")
    void busquedaGoogle(){
        /*
        googleHomePage = new RumboHomePage(DriverFactory.getDriver());
        googleHomePage.navegarAlHome();
        googleHomePage.buscarConBotonBuscar("Tsoft");
        Assertions.assertEquals("Tsoft - Buscar con Google",googleHomePage.getUrlTitle()); */
    }
}
