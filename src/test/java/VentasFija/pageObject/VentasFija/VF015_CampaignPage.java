package VentasFija.pageObject.VentasFija;

import VentasFija.helpers.BasePage;
import VentasFija.utility.ScreenshotUtility;

import java.awt.*;
import java.io.IOException;

public class VF015_CampaignPage extends BasePage {
    /**************************************************
     #Localizadores Altas, Migraciones y SVA - Presencial y Remoto
     **************************************************/
    //public final String btn_ciudadsitiada = "//*[contains(text(),'CIUDAD SITIADA')]";
    //public final String btn_masiva        = "//*[contains(text(),'MASIVA')]";

    //*[@id="campanais"]
    public final String btn_canpaign (String scanpaign) {
        return "//*[contains(text(),'" + scanpaign + "')]";
    }
    public final String btn_none            = "|id|campanais";
    //public final String lbl_cuadro          = "//*[@id=\"data\"]/campanas/div/div/div[2]/div[2]";
    /**************************************************
     #Selección de Campaña
     **************************************************/
    public void SelectionCampaign(String id, String scanpaign) throws Throwable {
        try {
            if (!validateObjExistById("Validar objeto",btn_canpaign (scanpaign))){
                System.out.println("Validación CanpaignPage Exitosa");
                if(scanpaign.equalsIgnoreCase("CIUDAD SITIADA") || scanpaign.equalsIgnoreCase("EDIFICIOS CON FIBRA") || scanpaign.equalsIgnoreCase("MASIVA")) {
                    /*utilitarios.takeScreenshot("Selección de Campaña_" + scanpaign, BasePage.handleDriver());
                    ScreenshotUtility.saveAccion("Selección de Campaña_" + scanpaign);*/
                    doclickByJS("Seleccion de Campana", btn_canpaign (scanpaign),true);
                }else{
                    /*utilitarios.takeScreenshot("Selección de Campaña Aleatorio", BasePage.handleDriver());
                    ScreenshotUtility.saveAccion("Selección de Campaña Aleatorio");
                    */doclickByJS("Click en cualquier campaña", btn_none,true);
                }
            }else{
                System.out.println("CanpaignPage No Existe");
            }
        } catch (IOException | AWTException e) {
            e.printStackTrace();
        }
    }
    /**************************************************
     #Validadores
     **************************************************/
    public boolean ValidarBtnCampaign(String scanpaign) throws Throwable {
        boolean respuesta=false;
        try{
            Thread.sleep(4000);
            jsScrollIntoView("Scroll hasta boton continuar", btn_canpaign (scanpaign),false);
            respuesta= validateObjExist(btn_canpaign (scanpaign));
        }catch (Exception e){
            e.printStackTrace();
        }
        return respuesta;
    }
}