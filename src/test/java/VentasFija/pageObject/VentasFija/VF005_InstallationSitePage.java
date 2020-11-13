package VentasFija.pageObject.VentasFija;

import VentasFija.helpers.BasePage;

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
public class VF005_InstallationSitePage extends BasePage {
    /**************************************************
     #Localizadores en OpCo. Alta
     **************************************************/
    public final String txt_direccion               = "//*[@id=\"direccion\"]";
    public final String txt_referencia              = "//*[@id=\"referencia\"]";
    public final String btn_ubicarenmapa            = "//*[contains(text(),'UBICAR EN MAPA')]";
    //public final String btn_continuar             ="//a[contains(@class,'boton_greentdp')]";
    public final String btn_continuaralta           = "//*[contains(text(),'CONTINUAR')]";

    /**************************************************
     #Ubicación de la Dirección en Mapa OpCo. Alta Nueva
     **************************************************/
    public void fijarDireccionMapa(String Direccion, String Referencia)throws Throwable {
        try {
            while (!validateObjExist(btn_continuaralta)) {
                System.out.println("Sub1: Ingreso de Direccion y Referencia");
                doAddTextField("Ingresar direccion", txt_direccion, Direccion ,false);
                doAddTextField("Ingresar referencia", txt_referencia, Referencia ,true);
                //EnterIntoView();
                System.out.println("Sub1: Clic en Ubicar en Mapa");
                doclickByJS("Click_ubicarenmapa",btn_ubicarenmapa,false);
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void continuar(){
        try {
            doclickByJS("Click_continuar", btn_continuaralta,false);
        } catch ( IOException | AWTException e) {
            e.printStackTrace();
        }
    }
    /**************************************************
     #Validadores OpCo. Alta
     **************************************************/
    public boolean validar_BtnContinuar(){
        boolean respuesta=false;
        try {
            Thread.sleep(2000);
            jsScrollIntoView("Scroll hasta el boton continuar", btn_continuaralta,false);
            respuesta=validateObjExist(btn_continuaralta);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return respuesta;
    }
}