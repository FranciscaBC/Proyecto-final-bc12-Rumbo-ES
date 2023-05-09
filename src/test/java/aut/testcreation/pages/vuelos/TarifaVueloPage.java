package aut.testcreation.pages.vuelos;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TarifaVueloPage extends SeleniumWrapper {
    public TarifaVueloPage(WebDriver driver) {
        super(driver);
    }
    By elegirTarifaClassic = By.xpath("//button[@class='Button-sc-1bbve8d-0 gzlNtv']");
    By getElegirTarifaFlex = By.xpath("//button[@class='Button-sc-1bbve8d-0 ghhXOt']");

    public void elegirTarifa(boolean deseaTarifaClassic) throws InterruptedException {
        if (deseaTarifaClassic){
            scrolling(elegirTarifaClassic);
            Thread.sleep(1000);
            click(elegirTarifaClassic);
        }else {
            scrolling(getElegirTarifaFlex);
            Thread.sleep(1000);
            click(getElegirTarifaFlex);
        }
    }
}

