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
public class WA003_TokenModulePage extends BasePage {
    public  final String btn_tokenmodule = "/html/body/my-app/main/my-administration/div/div/div[27]/a";

    public void administracion (){
        try {
            doClick("Haciendo Click en Modulo Token", btn_tokenmodule,true);
        } catch (IOException | AWTException e) {
            e.printStackTrace();
        }
    }
}
