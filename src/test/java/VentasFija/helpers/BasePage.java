/**************************************************
 * WIPRO PROPIEDAD INTELECTUAL
 #Autor : Wipro Automation Team
 #Description : Portal de Venta Fija
 #Fecha de creación: Feb 2020
 #Nombre que modifica : --
 #Fecha modificación: --
 **************************************************/
package VentasFija.helpers;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import VentasFija.utility.*;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;

import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage{

    public static WebDriver driver;
//    public  WebDriver driver;
    public  int defaultWaitingTime = 590; //90
    protected  ScreenshotUtility utilitarios = new ScreenshotUtility();
    public  String stepTestName;
    protected Reports reporte = new Reports();

    public ExtentReports extent;
    public static ExtentTest scenarioDef;
    public static ExtentTest features;
    public static String reportLocation = "C:/Report/";

    //Este método se usa para aceptar los alert que aparezcan en los sites.
    public void checkAlert_Accept() throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, defaultWaitingTime);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (AssertionError e) {
            e.printStackTrace();
            Assert.fail("Fallo en check Alert",e);
            utilitarios.takeScreenshot("ERROR_En_Aceptar_Alert", driver);
            ScreenshotUtility.saveAccion("ERROR_En_Aceptar_Alert");
        }
    }



    //Este método ingresa el texto.
    public void doAddTextField(String UIName, String objTechName, String text, Boolean screenshot) throws IOException, AWTException {
        try {
            WebElement element =wait(UIName, objTechName);
            element.clear();
            element.sendKeys(text);
            if (screenshot) {
                utilitarios.takeScreenshot(UIName, driver);
                ScreenshotUtility.saveAccion(UIName);
            }
        } catch (AssertionError e) {
            e.printStackTrace();
            utilitarios.takeScreenshot("ERROR_En_Agregar_El_Texto_" + UIName, driver);
            ScreenshotUtility.saveAccion("ERROR_En_Agregar_El_Texto_" + UIName);
            Assert.fail("Fallo en agregar texto",e);

        }
    }
    //Método para hacer click al objeto.
    public void doClick(String UIName, String objTechName, Boolean screenshot) throws IOException, AWTException {
        try {
            WebElement element=wait(UIName, objTechName);
            if (screenshot) {
                utilitarios.takeScreenshot(UIName, driver);
                ScreenshotUtility.saveAccion(UIName);
            }
            element.click();
        } catch (AssertionError e) {
            e.printStackTrace();
            utilitarios.takeScreenshot("ERROR_Click_" + UIName, driver);
            ScreenshotUtility.saveAccion("ERROR_Click_" + UIName);
            Assert.fail("Fallo en hacer click",e);
        }
    }

    //Método para seleccionar objeto combo
    public void doSelectDropdown(String UIName, String objTechName, String Value, Boolean screenshot)
            throws IOException, AWTException {
        try {
            WebElement element =wait(UIName, objTechName);
            Select dropdown = new Select(element);
            dropdown.selectByVisibleText(Value);
            //dropdown.selectByValue(Value);
            if (screenshot) {
                utilitarios.takeScreenshot(UIName, driver);
                ScreenshotUtility.saveAccion(UIName);
            }
        } catch (AssertionError e) {
            e.printStackTrace();
            Assert.fail("Fallo en agregar texto",e);
            utilitarios.takeScreenshot("ERROR_SelectDropdown" + UIName, driver);
            ScreenshotUtility.saveAccion("ERROR_SelectDropdown" + UIName);
        }
    }

    //Método para elegir la opción index del combo
    public void doSelectDropDownByindex(String UIName, String objTechName, int data, Boolean screenshot) throws Exception {
        try {
            WebElement element =wait(UIName, objTechName);
            Select dropdown = new Select(element);
            dropdown.selectByIndex(data);
            if (screenshot) {
                utilitarios.takeScreenshot(UIName, driver);
                ScreenshotUtility.saveAccion(UIName);
            }
        } catch (AssertionError e) {
            e.printStackTrace();
            Assert.fail("Fallo en agregar seleccionar el dropdown",e);
            utilitarios.takeScreenshot("ERROR_SelectDropdown" + UIName, driver);
            ScreenshotUtility.saveAccion("ERROR_SelectDropdown" + UIName);
        }
    }

    //Método para seleccionar el texto de la opción del elemento
    public void select(String UIName, String objTechName, String data) throws Exception {
        try {
            WebElement element =wait(UIName, objTechName);
            Select selectBox = new Select(element);
            selectBox.selectByVisibleText(data);
            utilitarios.takeScreenshot(UIName, driver);
            ScreenshotUtility.saveAccion(UIName);
        } catch (AssertionError e) {
            e.printStackTrace();
            Assert.fail("Fallo en el select",e);
            utilitarios.takeScreenshot("ERROR_SelectDropdown" + UIName, driver);
            ScreenshotUtility.saveAccion("ERROR_SelectDropdown" + UIName);
        }
    }

    //Método para cambiar de frame
    public void switchiframe(String UIName, String objTechName) throws IOException, AWTException  {
        try {
            WebElement element =wait(UIName, objTechName);
            driver.switchTo().frame(element);
			utilitarios.takeScreenshot(UIName, driver);
			ScreenshotUtility.saveAccion(UIName);
        } catch (AssertionError e) {
            e.printStackTrace();
            Assert.fail("Fallo en switch frame",e);
            utilitarios.takeScreenshot("ERROR_switchFrame" + UIName, driver);
            ScreenshotUtility.saveAccion("ERROR_switchFrame" + UIName);
        }
    }
    public void EnterIntoView(){
        try{
            Actions builder = new Actions(driver);
            builder.sendKeys(Keys.ENTER).build().perform();
        }catch (AssertionError e){
            e.printStackTrace();
            Assert.fail("Fallo en dar ENTER",e);
        }

    }

    public void clickIntoButton(String UIName, String objTechName) {
        try {
            WebElement element = wait(UIName, objTechName);
            Point coordinates = element.getLocation();
            Robot robot = new Robot();
            robot.mouseMove(coordinates.getX(), coordinates.getY() + 120);
        } catch (AssertionError | AWTException | IOException e) {
            e.printStackTrace();
            Assert.fail("Fallo en dar Click", e);
        }
    }

    public void setWebDriver(WebDriver driver) {
        BasePage.driver=driver;
    }

    public enum properties {
        DISPLAYED, VISIBLE, SELECTED;
    }
    //Valida que un objeto exista
    public  boolean ValidateObject(String UIName, String objTechName, String PropertyToBeVerified) throws Exception {
        boolean ActualPropertyValue = false;
        String prop = PropertyToBeVerified.toUpperCase();
        try {
            WebElement element =wait(UIName, objTechName);
            switch (properties.valueOf(prop)) {
                case DISPLAYED:
                    ActualPropertyValue = element.isDisplayed();
                    break;
                case VISIBLE:
                    ActualPropertyValue = element.isEnabled();
                    break;
                case SELECTED:
                    ActualPropertyValue = element.isSelected();
                    break;
                default:
                    break;
            }
        } catch (AssertionError e) {
            e.printStackTrace();
            Assert.fail("Fallo la validacion del objeto",e);
            if (!ActualPropertyValue) {
                utilitarios.takeScreenshot("ERROR_Validar_Objeto" + UIName, driver);
                ScreenshotUtility.saveAccion("ERROR_Validar_Objeto" + UIName);
                return false;
            }
        }
        if (ActualPropertyValue) {
            return true;
        }
        return false;
    }

    //Valida que el texto mostrado corresponda al texto comparado
	//No valida mayúsculas, ni minúsculas
    public  boolean verifyText(String strText, String objTechName, String indice, Boolean screenshot) throws Exception {
        WebElement element = null;
        element =wait(strText, objTechName);

        try {
            WebDriverWait wait = new WebDriverWait(driver, defaultWaitingTime);
            element =wait(strText, objTechName);
            System.out.println("text:" + strText);
            System.out.println("text:" + element.getText());
            if (screenshot) {

                utilitarios.takeScreenshot("Validacion_Texto_" + strText, driver);
                ScreenshotUtility.saveAccion("Validacion_Texto_" + strText);
            }
        } catch (AssertionError e) {
            e.printStackTrace();
            Assert.fail("Fallo la verificacion del texto",e);
            utilitarios.takeScreenshot("ERROR_Este_Texto_No_Fue_Encontrado_"+strText, driver);
            ScreenshotUtility.saveAccion("ERROR_Este_Texto_No_Fue_Encontrado_"+strText);
        }
        return element.getText().equalsIgnoreCase(strText);
    }

    //Método que obtiene el texto del label
    public  String getlabel(String UIName, String objTechName) throws Exception {
        try {

            WebElement element =wait(UIName, objTechName);
            return element.getText();
        } catch (AssertionError e) {
            e.printStackTrace();
            utilitarios.takeScreenshot("ERROR_obtenerTexto" + UIName, driver);
            ScreenshotUtility.saveAccion("ERROR_obtenerTexto" + UIName);
            Assert.fail("Fallo en obtener el label",e);

        }
        return null;
    }

    //Verifica el contenido del texto
    public  boolean verifyContainText(String strText, String objTechName) throws Exception {
        WebElement element=null;
        try {
            System.out.println("REVISION");
            element = wait(strText, objTechName);
            System.out.println("REVISION1");
        } catch (AssertionError e) {
            e.printStackTrace();
            utilitarios.takeScreenshot("ERROR_verificar_texto_contain", driver);
            ScreenshotUtility.saveAccion("ERROR_verificar_texto_contain");
            Assert.fail("Fallo la verificar el texto que contiene un elemento",e);
        }
        return element.getText().contains(strText);
    }
    public WebElement returnWebElement (String UIName, String objTechName) throws Exception {
        WebElement element=null;

        try {
            element =wait(UIName, objTechName);

        } catch (AssertionError e) {
            e.printStackTrace();
            utilitarios.takeScreenshot("ERROR_Retornar_WebElement", driver);
            ScreenshotUtility.saveAccion("ERROR_Retornar_WebElement");
            Assert.fail("Fallo el retorno del elemento",e);
        }
        return element;
    }
    public static WebDriver handleDriver(){
        return driver;
    }
    //*************JavaScript**************
    public void doclickByJS(String UIName, String objTechName, boolean screenshot) throws IOException, AWTException {

        try {
            WebElement element =wait(UIName, objTechName);

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            if (screenshot) {
                utilitarios.takeScreenshot(UIName, driver);
                ScreenshotUtility.saveAccion(UIName);
            }
            jse.executeScript("arguments[0].click()", element);
        } catch (AssertionError e) {
            e.printStackTrace();
            Assert.fail("Fallo el click del boton_js",e);
            utilitarios.takeScreenshot("ERROR_Click_JS_" + UIName, driver);
            ScreenshotUtility.saveAccion("ERROR_Click_JS_" + UIName);
        }
    }

    public void jsScrollIntoView(String UIName, String objTechName, boolean screenshot) throws Exception {

        try {
            System.out.println("antes wait en jsScrollIntoView");

            WebElement   element =wait(UIName, objTechName);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView()", element);
        } catch (AssertionError e) {
            e.printStackTrace();
            Assert.fail("Fallo el scrolldown_js",e);
            utilitarios.takeScreenshot("ERROR_ScrollDown_JS_" + UIName, driver);
            ScreenshotUtility.saveAccion("ERROR_ScrollDown_JS_" + UIName);
        }
    }
    public void redirigirPage(String url){
        try{
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("location.replace('"+url+"')");
        }catch (AssertionError e){
            e.printStackTrace();
            Assert.fail("Fallo el scrolldown_js",e);
        }
    }
    public void updatepagebystring(String str) throws Throwable {
        try{
            Thread.sleep(5000);
            while (driver.findElements(By.xpath(str)).size()!=0){
                driver.navigate().refresh();
                Thread.sleep(7000);
            }
        }catch (AssertionError e){
            e.printStackTrace();
            Assert.fail("Fallo al actualizar la pagina",e);
        }
    }

    public void updatepage() throws Throwable {
        try{
            Thread.sleep(5000);
            driver.navigate().refresh();
            Thread.sleep(7000);

        }catch (AssertionError e){
            e.printStackTrace();
            Assert.fail("Fallo al actualizar la pagina",e);
        }
    }

/*
    public void clicbtninfinito(String objTechName, String str) throws Throwable {
        try{
            Thread.sleep(1000);
            WebElement element=wait(objTechName);
            while (driver.findElements(By.xpath(str)).size()!=0){
                element.click();
                Thread.sleep(5000);
            }
        }catch (AssertionError e){
            e.getMessage();
            e.getStackTrace();
            e.printStackTrace();
            Assert.fail("Fallo al clic en boton",e);
        }
    }

 */

    public boolean validateObjExist(String str) throws Throwable {
        boolean respuesta=false;
        try{
            Thread.sleep(2000);
            if (driver.findElements(By.xpath(str)).size()!=0){
                respuesta=true;
            }else{
                respuesta=false;
            }
        }catch (AssertionError e){
           e.printStackTrace();
            Assert.fail("Fallo la validacion de existencia de objeto",e);
        }

        return respuesta;
    }
    public boolean validateObjExistById(String UIName,String str) throws Throwable {
        boolean respuesta=false;
        try{
            Thread.sleep(2000);
            int tamanio=str.length();
            str =str.substring(4,tamanio);
            System.out.println(str);
            if (driver.findElements(By.id(str)).size()!=0){
                respuesta=true;
            }
        }catch (AssertionError e){
             e.printStackTrace();
            Assert.fail("ERROR_Validacion_Objeto_",e);
            utilitarios.takeScreenshot("ERROR_Validacion_Objeto_" + UIName, driver);
            ScreenshotUtility.saveAccion("ERROR_Validacion_Objeto_" + UIName);
        }

        return respuesta;
    }
    public void UpdatepagExistElement(String str) throws Throwable{
        try{
            Thread.sleep(5000);
            while (driver.findElements(By.xpath(str)).size()!=0){
                driver.navigate().refresh();
                Thread.sleep(7000);
            }
        }catch(AssertionError e){
            e.printStackTrace();
            Assert.fail("Fallo la actualizacion",e);
        }

    }

    public WebElement wait(String UIName, String objTechName) throws IOException, AWTException {
        WebDriverWait wait = new WebDriverWait(driver,defaultWaitingTime);
        WebElement element = null;

        try {
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(ObjectMap.getLocator(objTechName)));

        } catch (Exception e) {
            System.out.println("Excepcion DEL WAIT");
        //    ScreenshotUtility.doScreenShot("ERROR_No se encuentra el elemento_"+ UIName, BasePage.handleDriver());
            utilitarios.takeScreenshot("ERROR_No se encuentra el elemento_" + UIName, driver);
                      ScreenshotUtility.saveAccion("ERROR_No se encuentra el elemento_" + UIName);
            e.printStackTrace();
            Assert.fail("ERROR_ASSERT_No se encuentra el elemento",e);
        }

        return element;
    }

    public void waitInvisibility(String UIName, String objTechName, Boolean screenshot) throws IOException, AWTException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, defaultWaitingTime);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(ObjectMap.getLocator(objTechName)));
        } catch (Exception e) {
            e.printStackTrace();
            utilitarios.takeScreenshot("Error en  " + UIName, driver);
            ScreenshotUtility.saveAccion("Error en " + UIName);
        }
    }

    public void upFile( String objTechName, String nameFile) throws IOException, AWTException {
        String ruta = "./src/test/resources/audio/" + nameFile;
        try {
            WebElement element = driver.findElement(ObjectMap.getLocator(objTechName));
            ((RemoteWebElement) element).setFileDetector(new LocalFileDetector());
            System.out.println(ruta);
            element.sendKeys(ruta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    public void upFilewithRobot(String ruta) throws IOException, AWTException {
        //String ruta = "D:\\Aseguramiento\\WebConvergente_BDD_Aseguramiento\\src\\test\\resources\\audio\\" + nameFile;
        try {
            System.out.println("ruta: " + ruta);
            //setClipboardData(ruta);
            Robot robot = new Robot();
            ;
            robot.setAutoDelay(2000);

            StringSelection stringSelection = new StringSelection("C:\\Users\\Admin\\Documents\\Audio\\-eslh32gzd9qyqt91hi4.gsm");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

            robot.setAutoDelay(3000);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);

            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);

            robot.setAutoDelay(3000);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DropFile(String UIName, File filePath, String objTechName, int offsetX, int offsetY, Boolean screenshot) throws IOException, AWTException {
        try {
            WebElement element = wait(UIName, objTechName);
            if (screenshot == true) {
                utilitarios.takeScreenshot(UIName, driver);
                ScreenshotUtility.saveAccion(UIName);
            }
            if (!filePath.exists())
                throw new WebDriverException("File not found: " + filePath.toString());
            WebDriver driver = ((RemoteWebElement) element).getWrappedDriver();
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            WebDriverWait wait = new WebDriverWait(driver, 30);
            String JS_DROP_FILE =
                    "var target = arguments[0]," +
                            "    offsetX = arguments[1]," +
                            "    offsetY = arguments[2]," +
                            "    document = target.ownerDocument || document," +
                            "    window = document.defaultView || window;" +
                            "" +
                            "var input = document.createElement('INPUT');" +
                            "input.type = 'file';" +
                            "input.style.display = 'none';" +
                            "input.onchange = function () {" +
                            "  var rect = target.getBoundingClientRect()," +
                            "      x = rect.left + (offsetX || (rect.width >> 1))," +
                            "      y = rect.top + (offsetY || (rect.height >> 1))," +
                            "      dataTransfer = { files: this.files };" +
                            "" +
                            "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {" +
                            "    var evt = document.createEvent('MouseEvent');" +
                            "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);" +
                            "    evt.dataTransfer = dataTransfer;" +
                            "    target.dispatchEvent(evt);" +
                            "  });" +
                            "" +
                            "  setTimeout(function () { document.body.removeChild(input); }, 25);" +
                            "};" +
                            "document.body.appendChild(input);" +
                            "return input;";
            WebElement input = (WebElement) jse.executeScript(JS_DROP_FILE, element, offsetX, offsetY);
            input.sendKeys(filePath.getAbsoluteFile().toString());
            wait.until(ExpectedConditions.stalenessOf(input));
        } catch (Exception e) {
            e.printStackTrace();
            utilitarios.takeScreenshot("Error en  " + UIName, driver);
            ScreenshotUtility.saveAccion("Error en " + UIName);
        }
    }

    public int countRowsTableDiv(String strText, String objTechName) throws Exception {
//        WebElement element=null;
        int rowcount = 0;
        try {
        } catch (AssertionError e) {
            e.printStackTrace();
            utilitarios.takeScreenshot("ERROR_verificar_texto_contain", driver);
            ScreenshotUtility.saveAccion("ERROR_verificar_texto_contain");
            Assert.fail("Fallo la verificar el texto que contiene un elemento",e);
        }
        List<WebElement> elements = driver.findElements(By.xpath(objTechName));
//        rowcount = elements.size();


        return rowcount;

    }

}
