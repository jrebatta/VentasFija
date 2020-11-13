package VentasFija.pageObject.VentasFija;

import VentasFija.helpers.BasePage;

import java.awt.*;
import java.io.IOException;

public class VF012_InstallationContactPage extends BasePage {
    /**************************************************
     #Localizadores de Fin de Venta con/sin Agendamiento
     **************************************************/
    public final String txt_telefono                    = "//*[@id=\"0phoneNumber\"]";
    //public final String btn_finalizaraltasimple         = "//*[@id=\"data\"]/contactoinstalacion/div/div/div[2]/app-form-contacto/div/div[1]/a";
    public final String btn_finalizar                   = "//*[contains(text(),'FINALIZAR VENTA')]";
    public final String btn_guardarycontinuar           = "//*[contains(text(),'GUARDAR Y CONTINUAR')]";

    //*[@id="data"]/contactoinstalacionout/div/div/div[2]/app-out-form-contacto/div/div[1]/a
    /**************************************************
     #Localizadores de Fin de Venta con Agendamiento
     **************************************************/
    public final String btn_calendario                  = "//*[@id=\"calendar\"]";
    public final String btn_selecciondia                = "//*[@id=\"calendar\"]/my-date-picker/div/div/table[2]/tbody/tr[4]/td[2]/div/span";
    public final String btn_turnomaniana                = "//*[@id=\"data\"]/saleprocess/div/div/div/app-schedule/div[1]/div[4]/div[2]/div/div[1]/div[1]/div";
    public final String btn_turnotarde                  = "//*[@id=\"data\"]/saleprocess/div/div/div/app-schedule/div[1]/div[4]/div[2]/div/div[1]/div[2]/div";
    //public final String btn_finalizarconagendamiento  = "//*[@id=\"data\"]/saleprocess/div/div/div/app-schedule/div[1]/div[4]/div[3]/div/div[3]/a";
    public final String btn_confirmaryfinalizar         = "//*[@id=\"cancel\"]/div/a[1]";
    public final String btn_entendido                   = "//*[@id=\"aceptar\"]";
    public final String lbl_título                      = "//*[@id=\"data\"]/contactoinstalacion/div/div/div[1]/p";
    /**************************************************
     #Ingreso de Datos Finales Para Instalación
     **************************************************/
    public void agendarOSoloInsertarTelefono(String sTelefono) throws Throwable {
        try {
            if(validateObjExist(btn_calendario)) {
                System.out.println("VF012_InstallationContactPage: Agendamiento");
                doclickByJS ("Click en día de instalación", btn_selecciondia, false);
                doclickByJS("Click en selección de turno", btn_turnotarde, true);
                doAddTextField("Ingresar telefono del cliente",txt_telefono,sTelefono,false);
            }
            else {
            //else if(lbl_título.equalsIgnoreCase("Contacto de Instalación")) {
            //if(validateObjExist(btn_finalizaraltasimple)) {
                System.out.println("VF012_InstallationContactPage: Ingreso de Teléfono - Simple");
                doAddTextField("Ingresar telefono del cliente",txt_telefono,sTelefono,false);
            }
        } catch (IOException |AWTException e) {
            e.printStackTrace();
        }
    }
    /**************************************************
     #Finalización de Venta
     **************************************************/
    public void doClickFinalizarVenta()throws Throwable {
        try {
            if(validateObjExist(btn_calendario)) {
                System.out.println("VF012_InstallationContactPage: Finalizar con agendamiento");
                //doClick("Click en finalizar venta", btn_finalizarconagendamiento, true);
                doClick("Click en finalizar venta", btn_finalizar, true);
                doClick("Click en confirmar y finalizar", btn_confirmaryfinalizar, true);

                if (validateObjExist(btn_entendido)) {
                    doClick("Click en entendido", btn_entendido, true);
                }
            }
            else if(validateObjExist(btn_guardarycontinuar)){
                System.out.println("VF012_InstallationContactPage: Finalizar RemotoOut");
                doClick("Click en guardar Y continuar ",btn_guardarycontinuar,true);
            }
            else{
            //if(lbl_título.equalsIgnoreCase("Contacto de Instalación")) {
            //if(validateObjExist(btn_finalizaraltasimple)) {
                System.out.println("VF012_InstallationContactPage: Finalizarción Alta - Simple");
                //doClick("Click en finalizar", btn_finalizaraltasimple, true);
                jsScrollIntoView("ScrollDown", btn_finalizar, false);
                doclickByJS("Click en finalizar", btn_finalizar, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**************************************************
     #Validaciones de Objetos
     **************************************************/
    public boolean validarBtnFinalizar(){
        boolean respuesta= false;
        try{
            //respuesta=validateObjExist(btn_finalizarconagendamiento);
            respuesta=validateObjExist(btn_finalizar);
        } catch (Throwable e){
            e.printStackTrace();
        }
        return respuesta;
    }
}