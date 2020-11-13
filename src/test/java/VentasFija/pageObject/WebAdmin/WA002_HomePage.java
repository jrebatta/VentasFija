package VentasFija.pageObject.WebAdmin;

import VentasFija.helpers.BasePage;

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
public class WA002_HomePage extends BasePage {
    public final String btn_administacion = "/html/body/my-app/header/nav/div/div/ul[1]/li[3]/a";
    public final String lbl_message_welcome="/html/body/my-app/main/my-welcome/div/div/div/div/div[2]/span";
    public void welcome () throws InterruptedException {
        try {
           // UpdatepageNoexistElement(btn_administacion);
            doClick("Haciendo Click en Administrador",btn_administacion,true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }




}
