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
public class VF003_HomePage extends BasePage {
    //public final String btn_Alta_Nueva    = "//*[@id=\"data\"]/acciones/div/div/div[1]/form/div/a[1]";
    public final String btn_Alta_Nueva      = "//*[contains(text(),'ALTAS NUEVAS')]";
    //public final String btn_Migraciones   = "//*[@id=\"data\"]/acciones/div/div/div[1]/form/div/a[2]";
    public final String btn_Migraciones     = "//*[contains(text(),'MIGRACIONES / COMPLETAS')]";
    //public final String btn_SVA           = "//*[@id=\"data\"]/acciones/div/div/div[1]/form/div/a[3]";
    public final String btn_SVA             = "//*[contains(text(),'EQUIPOS / SVAs')]";
    //public final String btn_movistartotal = "//*[@id=\"data\"]/acciones/div/div/div[1]/form/div/a[4]";
    public final String btn_movistartotal   = "//*[contains(text(),'MOVISTAR TOTAL')]";
    public final String lbl_user            = "//*[@id=\"data\"]/acciones/div/div/div[1]/div";

    public boolean validateUser(String suser,String id){
        boolean respuesta=false;
        try {
            respuesta= verifyText(suser,lbl_user,id,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }
    /**************************************************
     #Operación Comercial Alta Nueva
     **************************************************/
    public void opCoAltaNueva(int id){
        try {
            doclickByJS("Registro_"+id+"_Click en ALTA nueva",btn_Alta_Nueva,true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**************************************************
     #Operación Comercial Migraciones
     **************************************************/
    public void opCoMigraciones(int id){
        try {
            doClick("Registro_"+id+"_Click en Migraciones",btn_Migraciones,true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**************************************************
     #Operación Comercial SVA
     **************************************************/
    public void OpCoSVA(int id){
        try {
            doclickByJS("Registro_"+id+"_Click en SVA",btn_SVA,true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**************************************************
     #Validadores Assert
     **************************************************/
    public boolean validarBtnAlta() throws Throwable{
        boolean respuesta=false;
        try {
            respuesta=validateObjExist(btn_Alta_Nueva);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }
    public boolean validarBtnMigracion() throws Throwable{
        boolean respuesta=false;
        try {
            respuesta=validateObjExist(btn_Migraciones);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }
    public boolean validarBtnSVA() throws Throwable{
        boolean respuesta=false;
        try {
            respuesta=validateObjExist(btn_SVA);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }
 }
