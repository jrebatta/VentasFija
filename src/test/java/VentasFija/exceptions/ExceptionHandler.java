package VentasFija.exceptions;

import VentasFija.helpers.BasePage;
import VentasFija.helpers.Hook;
import VentasFija.utility.ExcelUtils;
import VentasFija.utility.GlobalVariable;
import VentasFija.utility.ScreenshotUtility;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ExceptionHandler {

    /***
     *
     * Metodo que maneja las Excepciones
     * PARAMETROS:
     *  AssertionError  : parametro de la excepcion manejada por Java
     *  sError          : parametro del mensaje de error que se va a mostrar en el Reporte HTML
     *  reload          : parametro de hacer recarga a la pagina web en la seccion del Home
     *  sEscenario      : Nombre del Escenario correspondiente en el archivo .feature
     *  sFeatureName    : Nombre del Feature correspondiente en el archivo .feature
     *  sTester         : Nombre del Tester responsable
     *  id              : Int - correspondiente al indice del archivo .feature
     *  closeBrowser    : parametro para cerrar el browser
     *  word            : parametro para generar el archivo Word
     */

    public static void  doException (AssertionError e, String sError, Boolean reload, String sTester, int id, Boolean closeBrowser, Boolean word) throws Exception {
        e.printStackTrace();
        if (word){
            Hook.generarWordFile(sTester, id);

        }
        if (reload) {doLoadMenu();}
        if (closeBrowser) {BasePage.handleDriver().quit();}
        Assert.fail(sError,e);
    }

    public static void  doLoadMenu() throws Exception {
        Object[][] Parameters_2 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_LOGIN);//loadURL();
        String sURL = Parameters_2[15][3].toString();
        BasePage base = new BasePage();
        base.redirigirPage(sURL);
    }

}
