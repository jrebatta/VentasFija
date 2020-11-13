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
public class VF008_SaleTermsPage extends BasePage {
    /**************************************************
     #Localizadores de Condiciones de Venta
     **************************************************/
    public final String chk_SIdebitoautomatico      = "//*[@id=\"data\"]/saleprocess/div/div/div/salecondition/div/div/div[2]/div[3]/table/tbody/tr[1]/td[2]/div/label";
                                                      //*[@id="data"]/condicionout/div/div/div[2]/div[3]/table/tbody/tr[1]/td[2]/div/label
    public final String chk_NOdebitoautomatico      = "//*[@id=\"data\"]/saleprocess/div/div/div/salecondition/div/div/div[2]/div[3]/table/tbody/tr[1]/td[3]/div/label";
    public final String txt_correodebitoautomatico  = "|id|email";
    public final String chk_SItratamientodatos      = "//*[@id=\"data\"]/saleprocess/div/div/div/salecondition/div/div/div[2]/div[3]/table/tbody/tr[2]/td[2]/div/label";
    public final String chk_NOtratamientodatos      = "//*[@id=\"data\"]/saleprocess/div/div/div/salecondition/div/div/div[2]/div[3]/table/tbody/tr[2]/td[3]/div/label";
    public final String chk_SIpackverde             = "//*[@id=\"data\"]/saleprocess/div/div/div/salecondition/div/div/div[2]/div[3]/table/tbody/tr[3]/td[2]/div/label";
    public final String chk_NOpackverde             = "//*[@id=\"data\"]/saleprocess/div/div/div/salecondition/div/div/div[2]/div[3]/table/tbody/tr[3]/td[3]/div/label";
    public final String txt_correopackverde         = "|id|email";
    public final String chk_SIcontrolparental       = "//*[@id=\"data\"]/saleprocess/div/div/div/salecondition/div/div/div[2]/div[3]/table/tbody/tr[4]/td[2]/div/label";
    public final String chk_NOcontrolparental       = "//*[@id=\"data\"]/saleprocess/div/div/div/salecondition/div/div/div[2]/div[3]/table/tbody/tr[4]/td[3]/div/label";
    //public final String btn_continuar             = "//*[@id=\"data\"]/saleprocess/div/div/div/salecondition/div/div/div[2]/div[4]/a";
    public final String btn_continuar               = "//*[contains(text(),'CONTINUAR')]";
    /**************************************************
     #Selección de Condiciones de Venta
     **************************************************/
    public void doClickDebitoAutomatico(String sdebitoautomatico, String scorreodebitoautomatico) throws IOException{
        try {
            if (sdebitoautomatico.equalsIgnoreCase("Si")) {
                    doclickByJS("Aceptar Débito Automático", chk_SIdebitoautomatico, false);
                    doAddTextField("Ingresar correo solicitado por aceptar débito automático", txt_correodebitoautomatico, scorreodebitoautomatico, false);
            }
            if (sdebitoautomatico.equalsIgnoreCase("No")) {
                    doclickByJS("No Aceptar Débito Automatico", chk_NOdebitoautomatico, false);
            }
            Thread.sleep(1000);
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void doClickTratamientoDatos(String stratamientodatos) throws IOException{
        try {
            if (stratamientodatos.equalsIgnoreCase("Si")) {
                    doclickByJS("Aceptar Tratamiento de Datos", chk_SItratamientodatos, false);
            }
            if (stratamientodatos.equalsIgnoreCase("No")) {
                    doclickByJS("No Aceptar Tratamiento de Datos", chk_NOtratamientodatos, false);
            }
            Thread.sleep(1000);
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void doClickPackVerde(String spackverde, String scorreopackverde) throws IOException{
        try {
            if (spackverde.equalsIgnoreCase("Si")) {
                    doclickByJS("Aceptar Pack Verde", chk_SIpackverde, false);
                    doAddTextField("Ingresar correo solicitado por aceptar pack verde", txt_correopackverde, scorreopackverde, false);
            }
            if (spackverde.equalsIgnoreCase("No")) {
                    doclickByJS("No Aceptar Pack Verde", chk_NOpackverde, false);
            }
            Thread.sleep(1000);
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void doClickControlParental(String scontrolparental) throws IOException{
        try {
            if (scontrolparental.equalsIgnoreCase("Si")) {
                    doclickByJS("Aceptar Control Parental", chk_SIcontrolparental, true);
            }
            if (scontrolparental.equalsIgnoreCase("No")) {
                    doclickByJS("No Aceptar Control Parental", chk_NOcontrolparental, true);
            }
            Thread.sleep(1000);
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doClickContinuar() throws Exception{
        try {
            jsScrollIntoView("Scroll hasta boton continuar",btn_continuar,true);
            doclickByJS("Clic en Continuar", btn_continuar, false);
        } catch (AWTException ex) {
            ex.printStackTrace();
        }
    }
}
