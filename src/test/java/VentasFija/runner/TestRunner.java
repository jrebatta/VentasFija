package VentasFija.runner;

//import org.junit.runner.RunWith;
//import cucumber.api.junit.Cucumber;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.annotations.BeforeTest;
import VentasFija.utility.ScreenshotUtility;
import org.testng.xml.XmlTest;


import java.io.File;
import java.io.IOException;
import java.sql.Date;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature/FlujoRemotoOut.feature"
        //features =  "src/test/resources/feature/" //Se ejecutaran todos los archivos features, por orden alfabetico segun especificado en el campo Feature.
        , plugin = {"com.cucumber.listener.ExtentCucumberFormatter:results/cucumber-reports/report.html",
        "junit:results/cucumber-reports/Cucumber.xml",
        "html:results/cucumber-reports"} //Formato de reporte generado por Cucumber
        , glue = {"VentasFija.tests", "VentasFija.helpers"} //Ubicación package de la clase steps
        , tags = {"@SmokeTest"} //Filtra por tags los escenarios a ejecutar
        , dryRun = false //Verifica que todos los pasos en el feature esten implementados en los steps
        , monochrome = true //Muestra en consola el output de las pruebas de Cucumber
)


public class TestRunner extends AbstractTestNGCucumberTests {


    @AfterClass
    public static void writeExtentReport()
    {
        System.out.println("afterClass");
        Reporter.loadXMLConfig(new File("./src/extent-config.xml"));
    }

/***
* Metodo que se ejecuta antes de cada "Feature"
*/

@BeforeMethod//@BeforeTest
public static void cleanFolder() throws InterruptedException, IOException {
    System.out.println("cleanFolder Call");
        String sCarpAct = "./results/screenshot/";
    ScreenshotUtility.cleanScreenshot(sCarpAct);

    Thread.sleep(50000);
    System.out.println("cleanFolder Call 2");
    ScreenshotUtility.cleanScreenshot(sCarpAct);

    System.out.println("cleanFolder Call 3");

//        Thread.sleep(5000);
        //  ScreenshotUtility.cleanScreenshot(sCarpAct2);

        //        ScreenshotUtility.cleanScreenshot(sCarpAct);
        //       Thread.sleep(5000);
}
 /***
 * Metodo que se ejecuta una vez al empezar la ejecucion
 */
@BeforeTest
public static void cleanFolderInit(ITestContext e, XmlTest x) throws InterruptedException, IOException {
        System.out.println("cleanFolder");
        String sCarpAct2 = "./results/screenshot2/";
        ScreenshotUtility.cleanScreenshot(sCarpAct2);

    }


}

