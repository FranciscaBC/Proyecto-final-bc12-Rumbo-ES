package aut.testcreation.pages.Hoteles;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Rumbo extends SeleniumWrapper {
    public Rumbo(WebDriver driver) {
        super(driver);
    }

    By btnBusquedaHoteles = By.xpath("//body/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/button[1]");
    By btnAceptarCoockies = By.xpath("//button[@class='iubenda-cs-accept-btn iubenda-cs-btn-primary']");
    By btnClearAlojamiento = By.xpath("//body/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/button[1]/*[1]");
    By campoFechaEntrada = By.xpath("//label[contains(text(),'Fecha de entrada')]");
    By campoFechaSalida = By.xpath("//label[contains(text(),'Fecha de salida')]");
    By btnFechasFlexibles = By.xpath("//button[contains(text(),'Fechas flexibles')]");
    By campoPersonas = By.xpath("//label[contains(text(),'Personas')]");
    By btnRestarPersonas = By.xpath("//body/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[2]/button[1]");
    By btnAumentarPersonas = By.xpath("//body/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[2]/button[2]");


}
