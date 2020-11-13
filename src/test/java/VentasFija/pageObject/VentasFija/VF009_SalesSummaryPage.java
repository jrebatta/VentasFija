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
public class VF009_SalesSummaryPage extends BasePage {
    /**************************************************
     #Localizadores de Resumen de Contrato
     **************************************************/
    //public final String btn_siacepto  = "//*[@id=\"data\"]/saleprocess/div/div/div/salesummary/div[2]/div/div[2]/div[4]/a";
    public final String btn_siacepto    = "//*[contains(text(),'SI, ACEPTO')]";
    /**************************************************
     #Aceptación de Resumen de Contrato
     **************************************************/
    public void salesSummaryPage() {
        try {
            doclickByJS("Click_btn_aceptar",btn_siacepto,true);
        } catch ( IOException | AWTException e) {
            e.printStackTrace();
        }
    }


}
