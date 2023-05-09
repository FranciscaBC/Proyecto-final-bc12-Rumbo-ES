package aut.testcreation.testcases;

import aut.testcreation.pages.trenes.Checkout;
import aut.testcreation.pages.trenes.RumboHomePage;
import aut.testcreation.pages.trenes.Flights;
import aut.testcreation.pages.trenes.Trenes;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TC009_POM extends SeleniumTestBase {
    RumboHomePage rumboHomePage;
    Trenes trenes;
    Flights flights;
    Checkout checkout;

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
        //Paso 2 Esperar a que carguen los elementos
        trenes.esperarVisibleLocated("//input[contains(@placeholder, 'Origen')]", 20);
        //Paso 3 Hacer click en Input Origen y escribir
        trenes.completarInputOrigen("//input[contains(@placeholder, 'Origen')]", "madrid");
        //paso 4 completar Input Destino
        trenes.completarInputDestino("//input[contains(@placeholder, 'Destino')]", "Barcelona");
        //paso 5 elegir fecha ida y vuelta
        trenes.seleccionarFechaIdayVuelta("//button[@aria-label='Fecha de ida']",
                "//button[@aria-label='Fecha de vuelta']");
        //paso 6 elegir cantidad de pasajeros
        trenes.seleccionarPasajero("//label[contains(text(),'Pasajero')]");
        //Paso 7 hacer click en buscar
        trenes.clickBuscar("/html/body/div[1]/div[2]/div/div[2]/div/div/div[5]/div/div/div/div/div/form/div[2]/div[4]/div/button");
        //paso 8 esperar a que cargue la sigueinte pagina
        flights = new Flights(DriverFactory.getDriver());
        flights.esperarClickeable("//h5[contains(text(),'Más barato')]", 10);
        //paso 9 hacer click en "Más barato"
        flights.clickear("//h5[contains(text(),'Más barato')]");
        //paso10 Seleccionar boleto
        flights.esperarYSeleccionarBoleto("/html/body/div[6]/div/div/div/div/div[1]/div[2]/div[3]/div/div[2]/div[5]/div/section[2]/div/div[1]/div/div/div/div/div[2]/div/div/div/div/span[1]",20);
        //paso 11 Esperar a que cargue la pagina y cargar los datos del pasajero
        checkout = new Checkout(DriverFactory.getDriver());
        checkout.formularioContacto("//input[@name='name']", "Ana",
                "//input[@name='surname']","Rodríguez",
                "//input[@name='email' and @data-test='input-email']","ana.rodriguez12345@gmail.com",
                "//input[@name='phone']","9876543",20);
        //paso 12 Completar datos pasajeros
        checkout.formularioPasajero("//input[@type='radio' and @value='FEMALE']",
                "//input[@type='text' and @name='groups.1.travellers.1.name']","Ana",
                "//input[@type='text' and @name='groups.1.travellers.1.surname']","Rodríguez",
                "//input[@data-test='input-groups.1.travellers.1.dateOfBirth-day']","15",
                "//select[@class='form-control select-input date__field']","//option[@value='7']",
                "//input[@data-test='input-groups.1.travellers.1.dateOfBirth-year']","1992",
                "//div[@class=' css-13wifi2']","Pasaporte",
                "//input[@data-test='input-groups.1.travellers.1.documentNumber']","00523821F",
                20);


    }
}
