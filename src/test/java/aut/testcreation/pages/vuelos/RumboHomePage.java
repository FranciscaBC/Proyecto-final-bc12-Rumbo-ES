package aut.testcreation.pages.vuelos;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static framework.engine.utils.Constants.BASE_URL_AUT;
import static org.openqa.selenium.Keys.DOWN;
import static org.openqa.selenium.Keys.ENTER;

public class RumboHomePage extends SeleniumWrapper {
    public RumboHomePage(WebDriver driver) {
        super(driver);
    }

    By btnAceptarCookies = By.xpath("//button[@class='iubenda-cs-accept-btn iubenda-cs-btn-primary']");
    By btnRechazarCookies = By.xpath("//button[@class='iubenda-cs-reject-btn iubenda-cs-btn-primary']");
    By btnVueloIdaVuelta = By.xpath("//div[@class='d-vfn33k']");
    By btnVueloSoloIda = By.xpath("//div[@class='d-1s1pmhl']");
    By btnVueloMultidestino = By.xpath("//*[@class='d-1w89ccl']");
    By btnLimpiar = By.xpath("//button[@class='d-1nmp0nm ed5mks90']");
    By locatorOrigenVuelo = By.xpath("//input[@id=':Riqed6lalallbla2m:']");
    By locatorDestinoVuelo = By.xpath("//input[@id=':Rjaed6lalallbla2m:']");
    By locatorFechaSoloIda = By.xpath("//button[@class='d-1kuzy14'][9]");
    By locatorCalendario = By.xpath("//span[@class='d-aziqil']");
    By locatorFechaIda = By.xpath("//button[@class='d-zlm2xw'][1]");
    By locatorFechaVuelta = By.xpath("//button[@class='d-1dj49va'][1]");
    By locatorNumeroPasajeros = By.xpath("//span[@class='d-5n2gua']");
    By btnBuscar = By.xpath("//button[@class='d-1jmk4ql']");
    By errOrigenVuelo = By.xpath("//span[@class = 'd-1toc9z2'][contains(text(),'Introduce ciudad o aeropuerto de origen')]");
    By btnAumentarPasajeros = By.xpath("//button[@aria-label='Aumentar el número de adultos']");


    public void irARumboYCookies(boolean deseaAceptarCookies) {
        navigateTo(BASE_URL_AUT);
        if (deseaAceptarCookies) {
            click(btnAceptarCookies);
        } else {
            click(btnRechazarCookies);
        }
    }

    public void seleccionarVueloIdaVuelta() {
        click(btnVueloIdaVuelta);
    }

    public void seleccionarVueloSoloIda() {
        click(btnVueloSoloIda);
    }

    public void seleccionarVueloMultidestino() {
        click(btnVueloMultidestino);
    }

    public void limpiarCampos(boolean deseaBorrarOrigen, boolean deseaBorrarDestino) {
        List<WebElement> limpiar = findElements(btnLimpiar);
        if (deseaBorrarOrigen) {
            limpiar.get(0).click();
        }
        if (deseaBorrarDestino) {
            limpiar.get(1).click();
        }
    }

    public void agregarOrigen(String origenVuelo) throws InterruptedException {
        click(locatorOrigenVuelo);
        write(origenVuelo, locatorOrigenVuelo);
        Thread.sleep(3000);
        sendKeys(DOWN, locatorOrigenVuelo);
        Thread.sleep(3000);
        sendKeys(ENTER, locatorOrigenVuelo);
        click(locatorOrigenVuelo);
    }

    public void agregarDestino(String destinoVuelo) throws InterruptedException {
        click(locatorDestinoVuelo);
        write(destinoVuelo, locatorDestinoVuelo);
        Thread.sleep(2000);
        sendKeys(DOWN, locatorDestinoVuelo);
        Thread.sleep(2000);
        sendKeys(ENTER, locatorDestinoVuelo);
        Thread.sleep(2000);
        click(locatorDestinoVuelo);
    }

    public void fechas() throws InterruptedException {
        click(locatorCalendario);
        click(locatorFechaIda);
        click(locatorFechaVuelta);
        Thread.sleep(1000);
    }

    public void numPasajeros(boolean deseaAgregarUnPasajero) throws InterruptedException {
        if (deseaAgregarUnPasajero) {
            click(locatorNumeroPasajeros);
            Thread.sleep(100);
            click(locatorNumeroPasajeros);
            click(btnAumentarPasajeros);
            Thread.sleep(2000);
            click(locatorNumeroPasajeros);
        } else {
            click(locatorNumeroPasajeros);
        }
    }

    public void fechaSoloIda() throws InterruptedException {
        Thread.sleep(1000);
        click(locatorCalendario);
        click(locatorFechaSoloIda);
    }

    public String mensajeErrorOrigen() {
        return getText(errOrigenVuelo);
    }

    public void realizarBusqueda() {
        click(btnBuscar);
    }
}