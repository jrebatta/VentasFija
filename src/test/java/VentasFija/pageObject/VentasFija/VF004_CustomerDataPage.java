package VentasFija.pageObject.VentasFija;

import VentasFija.helpers.BasePage;
import VentasFija.utility.ScreenshotUtility;

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
public class VF004_CustomerDataPage extends BasePage {
    /**************************************************
     #Localizadores Altas, Migraciones y SVA - Presencial y Remoto
     **************************************************/
    public final String cbo_TipoDoc             = "|id|documentType";
    public final String txt_NroDoc              = "|id|docNroDni";
    //public final String btn_EvaluarAlta       = "//*[@id=\"data\"]/searchuser/div/div/div[2]/form/div[6]/button";
    //public final String btn_EvaluarMigracion  = "//*[@id=\"data\"]/searchuser/div/div/div[2]/form/div[3]/button";
    //public final String btn_EvaluarSVA        = "//*[@id=\"data\"]/searchuser/div/div/div[2]/form/div[3]/a";
    public final String btn_Evaluar             =     "//*[contains(text(),'evaluar')]";
    //public final String lbl_ErrorMessage        = "|cselector|#data > searchuser > div > div > div.cnt_forcnt > form > div.contingencia_error > div > div > div:nth-child(2)";
    //public final String btn_Continuar         = "//*[@id=\"data\"]/searchuser/div/div/div[2]/div[4]/button";
    public final String btn_Continuar           = "//*[contains(text(),'CONTINUAR')]";
    /**************************************************
     #Localizadores Altas - Presencial
     **************************************************/
    public final String cbo_Departamento        = "|id|department";
    public final String cbo_Provincia           = "|id|city";
    public final String cbo_Distrito            = "|id|district";
    /**************************************************
     #Ingreso de Tipo y Número de DNI en OpCo. Altas, Migraciones y SVA
     **************************************************/
    public void insertDNIClient(String sTipoDoc, String sNumDoc){
        try {
            doSelectDropdown("Seleccionar Tipo de Doc", cbo_TipoDoc, sTipoDoc, false);
            doAddTextField("Ingresar Número de Doc cliente", txt_NroDoc, sNumDoc, true);
           /* utilitarios.takeScreenshot("Ingreso de Documento",BasePage.handleDriver());
            ScreenshotUtility.saveAccion("Ingreso de Documento");
           */ Thread.sleep(3000);
        } catch (IOException | AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**************************************************
     #Ingreso de Dep, Prov y Dis en OpCo. Altas
     **************************************************/
    public void ubicacionInstalacion(String sDepartamento, String sProvincia, String sDistrito){
        try {
            doSelectDropdown("Seleccionar Departamento", cbo_Departamento, sDepartamento, false);
            doSelectDropdown("Seleccionar Provincia", cbo_Provincia, sProvincia, false);
            doSelectDropdown("Seleccionar Distrito", cbo_Distrito, sDistrito, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**************************************************
     #Botones Evaluar y Continuar en OpCo. Alta, Migraciones y SVA
     **************************************************/
    public void evaluar(){
        try {
            //jsScrollIntoView("Scroll hasta boton evaluarr", btn_EvaluarAlta, false);
            //doClick("Click en evaluar cliente", btn_EvaluarAlta, true);
            Thread.sleep(10000);
            jsScrollIntoView("Scroll hasta boton evaluar", btn_Evaluar, false);
            doclickByJS("Click en evaluar cliente", btn_Evaluar, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void clickContinuar() throws InterruptedException, IOException, AWTException {
        doclickByJS("Click en evaluar cliente", btn_Continuar,true);
    }
    /**************************************************
     #Validadores OpCo. Alta, Migraciones y SVA
     **************************************************/
    public boolean validarBtnContinuar() throws Throwable {
        boolean respuesta=false;
        try{
            System.out.println("EN validarBtnContinuar");
            Thread.sleep(4000);
            jsScrollIntoView("Scroll hasta boton continuar TEST", btn_Continuar,true);
            System.out.println("antes respuesta");

            respuesta= validateObjExist(btn_Continuar);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("retornar respuesta aACA llego");
        return respuesta;
    }
}
