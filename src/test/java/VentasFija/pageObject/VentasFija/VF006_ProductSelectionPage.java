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
 #Venta Fija Version: XXXX
 #Input Parameters: --
 #Nombre que modifica : --
 #Fecha modificación: --
 **************************************************/
public class VF006_ProductSelectionPage extends BasePage {
    /**************************************************
     #Localizadores en OpCo. Alta, Migraciones y SVA
     **************************************************/
    //public final String btn_pestaniamono  = "|id|a4";
    public final String btn_pestaniamono    = "//*[contains(text(),'MONO')]";
    //public final String btn_pestaniaduo   = "|id|a3";
    public final String btn_pestaniaduo     = "//*[contains(text(),'DÚO')]";
    //public final String btn_pestaniatrio  = "|id|a2";
    public final String btn_pestaniatrio    = "//*[contains(text(),'TRÍO')]";
    public final String btn_productomono    = "//*[@id=\"tab4\"]/div[1]/div[2]/a";
    public final String btn_productoduo     = "//*[@id=\"tab3\"]/div[1]/div/div[2]/a";
    public final String btn_productotrio    = "//*[@id=\"tab2\"]/div[1]/div[2]/a";
    public final String div_alert           = "//*[@id=\"data\"]/offering/div/div/div[2]/div[3]/div[1]/div";
    /**************************************************
     #Localizadores en OpCo. Migraciones y SVA
     **************************************************/
    //public final String btn_verdetalle    = "//*[@id=\"tab5\"]/div/table/tbody/tr/td[4]/a";
    public final String btn_verdetalle      = "//*[contains(text(),'VER DETALLE')]";
    public final String btn_cerrardetalle   = "//*[@id=\"tab5\"]/div/table/tbody/div/div[1]/div/div/div[2]/a";
    public final String btn_seleccionprod   = "//*[@id=\"tab5\"]/div/table/tbody/tr/td[5]/div/label";
    //public final String btn_Migracion     = "//*[@id=\"data\"]/saleprocess/div/div/div/park/div/div/div[2]/div[5]/div/a";
    public final String btn_Migracion       = "//*[contains(text(),'MIGRAR')]";
    //public final String btn_SVA           = "//*[@id=\"data\"]/saleprocess/div/div/div/park/div/div/div[2]/div[4]/div/a";
    public final String btn_SVA             = "//*[contains(text(),'SVA')]";

    public final String tbl_PlanList        = "//div[@id='tab1']";

    public String txt_NamePlan(Integer i){
        return "/html[1]/body[1]/my-app[1]/main[1]/offeringout[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[" + i + "]/div[1]/p[1]";
    }

    public String btn_DetailPlan(Integer i){
        i = i - 1;
        return "//div[@id='toggle" + i + "']//p[contains(text(),'Ver detalle')]\n";
    }

    public String txt_CodePlan(Integer i){
        return "/html[1]/body[1]/my-app[1]/main[1]/offeringout[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[" + i + "]/div[6]/div[3]/span[2]";
    }

    public String btn_SeleccionPlan(Integer i){
        return "/html[1]/body[1]/my-app[1]/main[1]/offeringout[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[" + i + "]/div[2]/a[1]";
    }

    /**************************************************
     WIPRO COMPANY PROPIEDAD INTELECTUAL www.wipro.com
     #Autor: Carlos Pardo
     #Description: Selección de Producto Nuevo – Alta
     #Fecha de creación: Abr 2020
     **************************************************/
    public void doClickSeleccionProductoNuevo(String stipoproducto) throws IOException{
        try {
           switch (stipoproducto){
               case "MONO":
                   System.out.println(" Elección Mono");
                   doclickByJS("Seleccionar Pestaña Mono", btn_pestaniamono, true);
                   //doclickByJS("Seleccionar Producto Mono", btn_productomono, false);
                   Thread.sleep(2000);
                   break;
               case "DUO":
                   System.out.println(" Elección Duo");
                   doclickByJS("Seleccionar Pestaña Dúo", btn_pestaniaduo, true);
                   //doclickByJS("Seleccionar Producto Dúo", btn_productoduo, false);
                   Thread.sleep(2000);
                   break;
               case "TRIO":
                   System.out.println(" Elección Trio");
                   doclickByJS("Seleccionar Pestaña Trío", btn_pestaniatrio, true);
                   //doclickByJS("Seleccionar Producto Trío", btn_productotrio, false);
                   Thread.sleep(2000);
                   break;
               }
           } catch (AWTException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    /**************************************************
     WIPRO COMPANY PROPIEDAD INTELECTUAL www.wipro.com
     #Autor: Carlos Pardo
     #Description: Seleccción de Producto que Migrará – Migra y SVA
     #Fecha de creación: Abr 2020
     **************************************************/
    public void doClickSeleccionProductoActual(){
        try{
            Thread.sleep(6000);
            doclickByJS("Ver Detalle del Producto Actual", btn_verdetalle, true);
         /*   utilitarios.takeScreenshot("Ver Detalle del Producto Actual",BasePage.handleDriver());
            ScreenshotUtility.saveAccion("Ver Detalle del Producto Actual");*/
            Thread.sleep(2000);
            doclickByJS("Cerrar Detalles del Producto Actual", btn_cerrardetalle, false);
            doclickByJS("Selección del Producto Actual", btn_seleccionprod, true);
            Thread.sleep(2000);
            /*utilitarios.takeScreenshot("Selección del Producto",BasePage.handleDriver());
            ScreenshotUtility.saveAccion("Selección del Producto");*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void doClicMigracion(){
        try{
            doclickByJS("Selección del Botón Migrar", btn_Migracion, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void doClicSVA(){
        try{
            doclickByJS("Selección del Botón SVA", btn_SVA, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void doSelectPlanProduct(String snombreplan, String scodeplan){
        try{
        System.out.println("Inicio de seleccion de producto");
            int i = 1;
            System.out.println("NOMBRE PLAN 1: " + snombreplan);
            Thread.sleep(2000);
            int n = countRowsTableDiv("Selección del Producto Actual", tbl_PlanList);
            Thread.sleep(2000);
            System.out.println("NOMBRE PLAN 2: " + n);
            n = 50;
            while (n >= i){
                if (verifyContainText(snombreplan, txt_NamePlan(i))) {
                    System.out.println("NOMBRE PLAN 3: " + snombreplan);
                    doclickByJS("Ver Detalle del Plan", btn_DetailPlan(i), false);
///                    Thread.sleep(2000);

//                      if (verifyContainText(scodeplan, txt_CodePlan(i))) {
                        doclickByJS("Seleccionar Plan", btn_SeleccionPlan(i), true);
                        System.out.println("NOMBRE PLAN 4: " + snombreplan);
                        i = n;
                        Thread.sleep(2000);
///                    }

                }
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**************************************************
     #Validadores OpCo. Alta, Migraciones y SVA
     **************************************************/
    public boolean validateAlert(){
        boolean respuesta=false;
        try{
            respuesta=validateObjExist(div_alert);
        }catch (Throwable e){
            e.printStackTrace();
        }
        return respuesta;
    }

}
