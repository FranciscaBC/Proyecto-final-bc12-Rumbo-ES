package aut.testcreation.pages.trenes;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static framework.engine.utils.Constants.BASE_URL_AUT;
import static org.openqa.selenium.Keys.ARROW_DOWN;
import static org.openqa.selenium.Keys.ENTER;

public class Trenes extends SeleniumWrapper {

    private WebDriver driver;

    public Trenes(WebDriver driver) {
        super(driver);
    }

    public void irATrenes(){

        navigateTo("https://www.rumbo.es/trenes/");

    }

    public  void titulo(){
        String titulo = getUrlTitle();
        System.out.println(titulo);
    }
    public void  esperarVisibleLocated(String xpath, int tiempo){
        waitForElementToBeVisible(By.xpath(xpath), tiempo);
    }

    public void esperarVisibleLocatedyclick(String xpath, int tiempo) throws InterruptedException {
        waitForElementToBeVisible(By.xpath(xpath), tiempo);
        clickear(xpath);
        Thread.sleep(500);
    }

    public void  esperarClickeable(String xpath, int tiempo){
        waitForElementToBeClickable(By.xpath(xpath), tiempo);
    }


    public  void clickear(String xpath){
        click(By.xpath(xpath));
    }

    public void escribirInput (String xpath, String textoInput){
        write(textoInput,By.xpath(xpath));
    }

    public void teclaEnter (String xpath){
        sendKeys(ENTER, By.xpath(xpath));
    }
    public void teclaAbajo(String xpath){
        sendKeys(ARROW_DOWN, By.xpath(xpath));
    }

    public void esperaImplicita(int segundos){
        implicitWait(segundos);
    }

    public void hacerScroll (String xpath){

        scroll(xpath);

    }

    public void completarInputOrigen(String xpath,String texto) throws InterruptedException {
        esperarVisibleLocated(xpath,10);
        clickear(xpath);
        escribirInput(xpath, texto);
        Thread.sleep(1000);
        teclaAbajo(xpath);
        Thread.sleep(1000);
        teclaEnter(xpath);
    }

    public void completarInputDestino(String xpath, String texto) throws InterruptedException {
        esperarVisibleLocated(xpath,10);
        clickear(xpath);
        Thread.sleep(1000);
        escribirInput(xpath, texto);
        Thread.sleep(1000);
        teclaAbajo(xpath);
        Thread.sleep(1000);
        teclaEnter(xpath);
        scroll(xpath);
    }

    public void seleccionarFechaIdayVuelta(String xpath, String xpath2){
        scroll(xpath);
        esperarVisibleLocated(xpath,10);
        clickear(xpath);
        clickear(xpath2);

    }

    public void seleccionarFechaIda(String xpath){
        scroll(xpath);
        esperarVisibleLocated(xpath,10);
        clickear(xpath);

    }

    public  void  seleccionarPasajero(String xpath){
        scroll(xpath);
        esperarVisibleLocated(xpath,10);
        clickear(xpath);
    }

    public  void  seleccionarPasajeros(String xpath, String xpath2, String xpath3,String xpath4){
        scroll(xpath);
        esperarVisibleLocated(xpath,10);
        clickear(xpath);
        esperarVisibleLocated(xpath2, 10);
        clickear(xpath2);
        esperarVisibleLocated(xpath3,10);
        clickear(xpath3);
        esperarVisibleLocated(xpath4,10);
        clickear(xpath4);


    }
    public void clickBuscar(String xpath){
        esperarVisibleLocated(xpath,10);
        clickear(xpath);
    }
}
