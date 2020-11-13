package VentasFija.pageObject.WebAdmin;

import VentasFija.helpers.BasePage;
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
public class WA005_CodeDetailPage extends BasePage {
    public  final String txt_token = "/html/body/my-app/main/my-numerosasociadosdetail/div/div/div/div/form/table/tbody/tr[5]/td[2]";


public String gettoken(){
    String token=null;
    try {
        token =   getlabel("Obteniendo Token",txt_token);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return token;
}
}
