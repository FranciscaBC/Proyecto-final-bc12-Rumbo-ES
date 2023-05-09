package aut.testcreation.testcases;

import aut.testcreation.pages.trenes.RumboHomePage;
import aut.testcreation.pages.trenes.Flights;
import aut.testcreation.pages.trenes.Trenes;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TC007_POM extends SeleniumTestBase {

    Trenes trenes;
    Flights flights;
    RumboHomePage rumboHomePage;

    @Test
    @Tag("funcional")
    void registroTrenesPrueba() throws InterruptedException {

        //Precondiciones
        rumboHomePage = new RumboHomePage(DriverFactory.getDriver());
        rumboHomePage.navegarAlHome();
        rumboHomePage.aceptarCoockies();

        //Paso1 hacer click en trenes
        rumboHomePage.elegirTrenes();
        trenes = new Trenes(DriverFactory.getDriver());
        //Paso 2 Seleccionar solo ida
        trenes.esperarVisibleLocatedyclick("//div[contains(text(),'Solo ida')]", 20);
        //Paso 3 Hacer click en Input Origen y escribir
        trenes.completarInputOrigen("//input[contains(@placeholder, 'Origen')]", "madrid");
        //paso 4 completar Input Destino
        trenes.completarInputDestino("//input[contains(@placeholder, 'Destino')]", "Barcelona");
        //paso 5 elegir fecha ida
        trenes.seleccionarFechaIda("//button[@aria-label='Fecha de ida']");
        //paso 6 elegir cantidad de pasajeros
        trenes.seleccionarPasajeros("//label[contains(text(),'Pasajero')]",
                "//button[@aria-label='Aumentar el número de adultos']",
                "//button[@aria-label='Aumentar el número de niños']",
                "//li[contains(text(),'3 años')]");
        //Paso 7 hacer click en buscar
        trenes.clickBuscar("/html/body/div[1]/div[2]/div/div[2]/div/div/div[5]/div/div/div/div/div/form/div[2]/div[4]/div/button");



    }
}
