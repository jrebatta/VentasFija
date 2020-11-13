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
public class WA004_UserListPage extends BasePage {
    public  final String txt_codatis = "/html/body/my-app/main/numerosasociados/div/div/div/div[2]/div/form/div[1]/input";
    public  final String btn_buscar = "/html/body/my-app/main/numerosasociados/div/div/div/div[2]/div/form/div[3]/button";
    public  final String btn_detalle ="/html/body/my-app/main/numerosasociados/div/div/div/div[4]/table/tbody/tr/td[8]/a/i";
public void lista (String codatis){
    try {
        doAddTextField("Ingresando Codatis",txt_codatis,codatis,false);
        doClick("Haciendo click en buscar",btn_buscar,false);
        doClick("Haciendo Click en Detalle",btn_detalle,true);
    } catch (IOException |AWTException e) {
        e.printStackTrace();
    }
}
}
