package aut.testcreation.testcases;

import aut.testcreation.pages.vuelos.RumboHomePage;
import aut.testcreation.pages.vuelos.*;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Test;

public class TC001_POM extends SeleniumTestBase {
    RumboHomePage rumboHomePage;
    OfertasVuelosPage ofertasVuelosPage;
    TarifaVueloPage tarifaVueloPage;
    FormularioVuelosPage formularioVuelosPage;
    ServiciosAdicionalesPage serviciosAdicionalesPage;
    VerificacionPagoPage verificacionPagoPage;

    @Test
    void comprobacionesHastaPago() throws InterruptedException {
        rumboHomePage = new RumboHomePage(DriverFactory.getDriver());
        ofertasVuelosPage = new OfertasVuelosPage(DriverFactory.getDriver());
        tarifaVueloPage = new TarifaVueloPage(DriverFactory.getDriver());
        formularioVuelosPage = new FormularioVuelosPage(DriverFactory.getDriver());
        serviciosAdicionalesPage = new ServiciosAdicionalesPage(DriverFactory.getDriver());
        verificacionPagoPage = new VerificacionPagoPage(DriverFactory.getDriver());
        rumboHomePage.irARumboYCookies(true);
        rumboHomePage.seleccionarVueloIdaVuelta();
        rumboHomePage.limpiarCampos(true, false);
        rumboHomePage.agregarOrigen("Buenos Aires (BUE)");
        rumboHomePage.agregarDestino("Santiago (SCL)");
        rumboHomePage.fechas();
        rumboHomePage.numPasajeros(false);
        rumboHomePage.realizarBusqueda();
        ofertasVuelosPage.cambiarPestaniaARumbo();
        ofertasVuelosPage.modificarVuelo( true, true, "Mendoza (MDZ)", "Cartagena");
        ofertasVuelosPage.filtrarLATAM();
        ofertasVuelosPage.seleccionarOferta();
        tarifaVueloPage.elegirTarifa(true);
        formularioVuelosPage.datosPrincipalesContacto("Ana", "Rodriguez", "Holamundo2222@gmail.com", "9874563");
        formularioVuelosPage.preguntarSaludoAContacto(false);
        formularioVuelosPage.fechaNacimientoContacto("15", "1992");
        formularioVuelosPage.checksFormularioLatam(true, true, false);
        formularioVuelosPage.bajarYPresionarEnSgte();
        serviciosAdicionalesPage.presionarSiguiente();
        if (verificacionPagoPage.verificacionYPago().equals("Verificación y pago")) {
            System.out.println("Test completado con éxito: La ejecución del test finaliza en la pestaña 'Verificación y pago'. \nNombre de pestaña 'Verificación y pago' ha sido encontrado y desplegado en pantalla.\n ");
        } else {
            System.out.println("Test sin éxito: No ha sido posible encontrar el nombre de pestaña 'Verificación y pago'. \n");
        }
    }
}
