package VentasFija.pageObject.VentasFija;

import VentasFija.helpers.BasePage;
import VentasFija.utility.ScreenshotUtility;
import org.testng.Assert;

import java.awt.*;
import java.io.IOException;
/**************************************************
 WIPRO COMPANY PROPIEDAD INTELECTUAL www.wipro.com
 #Autor : Marcos Ronceros
 #Description : Venta Fija – Alta
 #Fecha de creación: Feb 2020
 # Venta Fija Version: XXXX
 #Input Parameters: --
 #Nombre que modifica : --
 #Fecha modificación: --
 **************************************************/
public class VF001_PreLoginPage extends BasePage {
    /**************************************************
     #Localizadores Para Inicio de Sesión
     **************************************************/
    public final String txt_codatis = "//*[@id=\"signup-form\"]/div[1]/input";
    //public final String btn_continuar = "//*[@id=\"signup-form\"]/div[2]/a";
    public final String btn_continuar = "//*[contains(text(),'Continuar')]";

    public void prelogin (String codatis) throws AWTException,IOException{
        try {
            doAddTextField("Ingresando Codigo Atis",txt_codatis,codatis,true);
            Thread.sleep(1000);
            doClick("Click en Continuar",btn_continuar,true);
            //utilitarios.takeScreenshot("Ingreso de Codigo Atis",BasePage.handleDriver());
            //ScreenshotUtility.saveAccion("Ingreso de Codigo Atis");
        } catch (AssertionError | InterruptedException e) {
            e.printStackTrace();
            Assert.fail("Fallo en el prelogin",e);
        }
    }
}
