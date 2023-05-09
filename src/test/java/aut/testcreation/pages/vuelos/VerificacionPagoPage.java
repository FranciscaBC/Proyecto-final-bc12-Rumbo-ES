package aut.testcreation.pages.vuelos;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerificacionPagoPage extends SeleniumWrapper {
    public VerificacionPagoPage(WebDriver driver) {
        super(driver);
    }
    By locatorVerificacionYPago = By.xpath("//span[@class='Stepperstyles__StyledStepTitle-sc-10m0j3k-4 Stepperstyles__Active-sc-10m0j3k-19 jElmHw'][contains(text(),'Verificación y pago')]");

    public String verificacionYPago(){return getText(locatorVerificacionYPago);}
}
