package aut.testcreation.pages.vuelos;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.openqa.selenium.Keys.ENTER;

public class MultidestinoPage extends SeleniumWrapper {
    public MultidestinoPage(WebDriver driver) {super(driver);}
    By locatorInputs = By.xpath("//input[@class='SearchFieldstyled__SearchFieldInput-sc-1f3jsso-5 jYLahH']");
    By btnBorrarTodos = By.xpath("//div[@class='ButtonPrimitiveContentChildren__StyledButtonPrimitiveContentChildren-sc-mra4yy-0 NRXsW'][contains(text(),'Borrar todos')]");
    By locatoraceptarCookies = By.xpath("//button[@id='cookies_accept']");
    By btnBuscarMulti = By.xpath("//div[@class='ButtonPrimitiveContentChildren__StyledButtonPrimitiveContentChildren-sc-mra4yy-0 dLfJcB'] [contains(text(), 'Buscar')]");
    By locatorTextoError = By.xpath("//p[@class='Text__StyledText-sc-1dj99rd-0 kocnUz']");


    public void cambiarPestaniaAMultidestino() throws InterruptedException {
        Thread.sleep(3000);
        switchToTabByTitleContains("Viajes de");
    }

    public void repetirOrigenesDestinos(boolean limpiarCampos, String origenPrimero, String destinoPrimero, String origenSegundo, String destinoSegundo) throws InterruptedException {
        try {
            if (limpiarCampos) {
                click(btnBorrarTodos);
            }
        } catch (Exception e) {
            System.out.println("Error: Campos no se han limpiado con éxito");
        }
        List<WebElement> inputs = findElements(locatorInputs);
        WebElement primerInput = inputs.get(0);
        primerInput.click();
        primerInput.sendKeys(origenPrimero);
        Thread.sleep(1500);
        primerInput.sendKeys(ENTER);
        Thread.sleep(1500);
        WebElement segundoInput = inputs.get(1);
        segundoInput.click();
        segundoInput.sendKeys(destinoPrimero);
        Thread.sleep(1500);
        segundoInput.sendKeys(ENTER);
        Thread.sleep(1500);
        WebElement tercerInput = inputs.get(3);
        tercerInput.sendKeys(origenSegundo);
        Thread.sleep(1500);
        tercerInput.sendKeys(ENTER);
        Thread.sleep(1500);
        WebElement cuartoInput = inputs.get(4);
        cuartoInput.click();
        cuartoInput.sendKeys(destinoSegundo);
        Thread.sleep(1500);
        cuartoInput.sendKeys(ENTER);
        Thread.sleep(1500);
    }

    public void buscarMultidestino(){
        click(btnBuscarMulti);
        click(locatoraceptarCookies);
    }

    public String mensajeErrorMultidestino() {
        return getText(locatorTextoError);
    }

}
