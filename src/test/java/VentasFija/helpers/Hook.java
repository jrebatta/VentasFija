/**************************************************
 * WIPRO PROPIEDAD INTELECTUAL
 #Autor : Wipro Automation Team
 #Description : Agendamiento - Trazabilidad
 #Fecha de creación: Feb 2020
 #Nombre que modifica : --
 #Fecha modificación: --
 **************************************************/
package VentasFija.helpers;
import cucumber.api.java.Before;
//import gherkin.formatter.model.Scenario;
import cucumber.api.Scenario;
import VentasFija.utility.GlobalVariable;
import VentasFija.utility.*;
import VentasFija.utility.WordUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Hook {
    public static String sFeatureName;
    public WebDriver driver;
    public BasePage basePage;
    Scenario sce;
    protected  ScreenshotUtility utilitarios = new ScreenshotUtility();




    @Before
    public void getFeatureFileNameFromScenarioId(Scenario scenario) {
        String featureName = "Feature ";
        String rawFeatureName = scenario.getId().split(";")[0].replace("-"," ");
        featureName = featureName + rawFeatureName.substring(0, 1).toUpperCase() + rawFeatureName.substring(1);
        System.out.println("FeatureName_:"+featureName);
        System.out.println("scenarioToString_:"+scenario.getName());
        sFeatureName= featureName;
    }

    /**
     * Borra todos los coockies e instancia el browser indicado
     */
    public  WebDriver  setUp(String sbrowser, String strURL) throws Exception {
/*        String sCarpAct = "./results/screenshot/";
        ScreenshotUtility.cleanScreenshot(sCarpAct);

   */
        
        boolean browserFound = true;
        if (sbrowser.toUpperCase().equals("FIREFOX")) {
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        } else if (sbrowser.toUpperCase().equals("CHROME")) {
            System.setProperty("webdriver.chrome.driver", GlobalVariable.AUT_BROWSER_SERVER_PATH_CHROME);
            driver = new ChromeDriver();
        } else if (sbrowser.toUpperCase().equals("IE")) {
            System.setProperty("webdriver.ie.driver", GlobalVariable.AUT_BROWSER_SERVER_PATH_CHROME);
            driver = new InternetExplorerDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        } else {
            browserFound = false;
        }
        if (browserFound) {
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.get(strURL);
            basePage = new BasePage();
            basePage.setWebDriver(driver);
            System.out.println("Browser Inicializado: "+driver.getTitle());
            return driver;
        } else {
            return null;
        }
    }








    /**
     * Cierra el browser y termina la sesion del WebDriver
     */

    //@After                        //(WebDriver iDriver, String escenario, String featureName, String testername,int id)
    public static void closeBrowser(WebDriver iDriver, String testername,int id) throws Exception {
        generarWordFile(testername,id);
     //   iDriver.quit();
    }
    public static void generarWordFile(String testername,int id) throws Exception {
        String sCarpAct = "./results/screenshot/";
        Thread.sleep(10000);
        List<String> listScreen = ScreenshotUtility.listScreenshot(sCarpAct);
        //  List <String> listaEscenario= ScreenshotUtility.saveScenario();
        System.out.println("contador de ARRAY:"+ ScreenshotUtility.contadorImagenes);
        if(GlobalVariable.IMPRIMIR_WORD){
        if (listScreen != null && listScreen.size() > 0) {
            System.out.println("Generar Word:"+listScreen);
            Thread.sleep(30000);
            WordUtils.createDoc(listScreen, testername,id);
          //   listScreen.clear();
            System.out.println("DespuesClea_List:"+listScreen);
            Thread.sleep(70000);
        } } else {
            System.out.println("No hay Data");
        }

        System.out.println(" antes de clear:");
      //  ScreenshotUtility.cleanScreenshot(sCarpAct);
       // listScreen.clear();

    }
    }