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

public class Checkout extends SeleniumWrapper {

    private WebDriver driver;

    public Checkout(WebDriver driver) {
        super(driver);
    }

    public void formularioContacto(String xpathNombre,String nombre,
                                    String xpathApellido,String apellido,
                                   String xpathEmail, String email,
                                   String xpathTelefono, String telefono,
                                   int tiempo

    ) throws InterruptedException {

        esperarClickeable(xpathNombre,tiempo);
        clickear(xpathNombre);
        escribirInput(xpathNombre,nombre);

        esperarClickeable(xpathApellido,tiempo);
        clickear(xpathApellido);
        escribirInput(xpathApellido,apellido);

        esperarClickeable(xpathEmail,tiempo);
        clickear(xpathEmail);
        escribirInput(xpathEmail,email);

        esperarClickeable(xpathTelefono,tiempo);
        clickear(xpathTelefono);
        escribirInput(xpathTelefono,telefono);
        Thread.sleep(300);

    }

    public void formularioPasajero(String xpathGenero,
                                   String xpathNombre, String nombre,
                                   String xpathApellido, String apellido,
                                   String xpathDiaNacimiento, String diaNacimiento,
                                   String xpathMesNacimiento,String xpathOpMesNacimiento,
                                   String xpathAñoNacimiento, String añoNacimiento,
                                   String xpathTipoDocumento, String tipoDocumento,
                                   String xpathNumeroDocumento,String numeroDocumento,
                                   int tiempo) throws InterruptedException {

        // Hacer scroll al final de la página para asegurarse de que todos los elementos estén visibles
        scroll("//span[@class='traveller-info__traveller-label-title']");
        Thread.sleep(300);

        // Esperar a que el elemento esté visible antes de hacer clic en él
        //esperarVisibleLocated(xpathGenero, 30);
        //clickear(xpathGenero);

        esperarVisibleLocated(xpathNombre, tiempo);
        clickear(xpathNombre);
        escribirInput(xpathNombre, nombre);

        esperarVisibleLocated(xpathApellido, tiempo);
        clickear(xpathApellido);
        escribirInput(xpathApellido, apellido);

        esperarVisibleLocated(xpathDiaNacimiento, tiempo);
        clickear(xpathDiaNacimiento);
        escribirInput(xpathDiaNacimiento, diaNacimiento);

        esperarVisibleLocated(xpathMesNacimiento, tiempo);
        clickear(xpathMesNacimiento);
        esperarVisibleLocated(xpathOpMesNacimiento, tiempo);
        clickear(xpathOpMesNacimiento);

        esperarVisibleLocated(xpathAñoNacimiento, tiempo);
        clickear(xpathAñoNacimiento);
        escribirInput(xpathAñoNacimiento, añoNacimiento);

        esperarVisibleLocated(xpathTipoDocumento, tiempo);
        escribirInput(xpathTipoDocumento,tipoDocumento);
        teclaAbajo(xpathTipoDocumento);
        teclaEnter(xpathTipoDocumento);

        esperarVisibleLocated(xpathNumeroDocumento, tiempo);
        clickear(xpathNumeroDocumento);
        escribirInput(xpathNumeroDocumento, numeroDocumento);
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
        Thread.sleep(2000);
        teclaAbajo(xpath);
        Thread.sleep(2000);
        teclaEnter(xpath);
    }

    public void completarInputDestino(String xpath, String texto) throws InterruptedException {
        esperarVisibleLocated(xpath,10);
        clickear(xpath);
        Thread.sleep(2000);
        escribirInput(xpath, texto);
        Thread.sleep(2000);
        teclaAbajo(xpath);
        Thread.sleep(2000);
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
