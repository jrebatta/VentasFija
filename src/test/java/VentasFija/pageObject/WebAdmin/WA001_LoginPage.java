package VentasFija.pageObject.WebAdmin;

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
public class WA001_LoginPage extends BasePage {
    public  final String txt_user = "//*[@id=\"login-page\"]/div/form/div[2]/div/input";
    public  final String txt_passwordwa = "//*[@id=\"login-page\"]/div/form/div[3]/div/input";
    public  final String btn_ingreso = "//*[@id=\"login-page\"]/div/form/div[4]/div/button";

    public void login2 (String user,String pass){
        try {
            doAddTextField("Ingresando user",txt_user,user,false);
            doAddTextField("Ingresando password",txt_passwordwa,pass,true);
            doClick("Haciendo Click en Ingresar",btn_ingreso,false);
        } catch (IOException | AWTException e) {
            e.printStackTrace();
        }
    }



}
