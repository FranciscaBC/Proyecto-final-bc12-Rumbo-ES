package aut.testcreation.pages.vuelos;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.openqa.selenium.Keys.DOWN;
import static org.openqa.selenium.Keys.ENTER;

public class OfertasVuelosPage extends SeleniumWrapper {
    public OfertasVuelosPage(WebDriver driver) {
        super(driver);
    }
    By locatorElegirVuelo = By.xpath("//div[@class='FullTripCard__PaymentContainer-sc-z8znd4-3 juamvE']");
    By locatorOfertas = By.xpath("//div[@class='FullJourneySummary__JourneySummary-sc-1yzjt4d-0 iwxxyr']");
    By locatorModificarVuelo = By.xpath("//span[@class='search-summary__search']");
    By locatorSoloIda = By.xpath("//div[@class='css-1s1pmhl']");
    By btnLimpiar = By.xpath("//button[@class='css-1nmp0nm ed5mks90']");
    By locatorOrigen = By.xpath("//input[@aria-label='Origen']");
    By locatorDestino = By.xpath("//input[@aria-label='Destino']");
    By btnBuscarOtraVez = By.xpath("//button[@aria-label='Buscar']");
    By locatorElegirLatam = By.xpath("//input[@id='id-LATAM Airlines Group']");
    By locatorElegirUnited = By.xpath("//input[@id='id-United Airlines']");
    By btnVerMas = By.xpath("//button[@class='Link__StyledLink-sc-y3byev-0 kXjsgw Link__BaseLinkButton-sc-y3byev-1 jzRcNR'][contains(text(),'Ver más')]");

    public void elegirPrimerOfertaQueAparezca() throws InterruptedException {
        Thread.sleep(3000);
        switchToTabByTitleContains("Rumbo");
        scrolling(btnVerMas);
        Thread.sleep(1000);
        click(btnVerMas);
        Thread.sleep(2000);
        click(locatorElegirUnited);
        Thread.sleep(4000);
        findElement(locatorElegirVuelo);
        Thread.sleep(2500);
        click(locatorElegirVuelo);
    }

    public void contarNumOfertas() throws InterruptedException {
        Thread.sleep(3000);
        switchToTabByTitleContains("Rumbo");
        List<WebElement> ofertas = findElements(locatorOfertas);
        int num_ofertas = ofertas.size();
        if (num_ofertas == 15) {
            System.out.println("Han sido desplegadas y detectadas las 15 ofertas esperadas");
        } else {
            System.out.println("No se han desplegado las 15 ofertas como se esperaba");
        }
    }

    public void modificarVuelo(String origenVuelo, String destinoVuelo) throws InterruptedException {
        Thread.sleep(4000);
        switchToTabByTitleContains("Rumbo");
        click(locatorModificarVuelo);
        click(locatorSoloIda);
        List<WebElement> limpiar = findElements(btnLimpiar);
        limpiar.get(0).click();
        limpiar.get(1).click();
        click(locatorOrigen);
        write(origenVuelo, locatorOrigen);
        Thread.sleep(1500);
        sendKeys(DOWN, locatorOrigen);
        Thread.sleep(1500);
        sendKeys(ENTER, locatorOrigen);
        Thread.sleep(1500);
        click(locatorDestino);
        write(destinoVuelo, locatorDestino);
        Thread.sleep(1500);
        sendKeys(DOWN, locatorDestino);
        Thread.sleep(1500);
        sendKeys(ENTER, locatorDestino);
        Thread.sleep(1500);
        click(btnBuscarOtraVez);
        Thread.sleep(3000);
        scrolling(btnVerMas);
        click(btnVerMas);
        Thread.sleep(3500);
        click(locatorElegirLatam);
        Thread.sleep(3500);
        findElement(locatorElegirVuelo);
        Thread.sleep(2500);
        click(locatorElegirVuelo);
    }
}
