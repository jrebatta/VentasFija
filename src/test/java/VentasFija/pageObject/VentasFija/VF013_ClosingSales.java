package VentasFija.pageObject.VentasFija;

import VentasFija.helpers.BasePage;

import java.awt.*;
import java.io.IOException;

public class VF013_ClosingSales extends BasePage {
    /**************************************************
     #Localizadores de Ir Al Menú
     **************************************************/
    public final String lbl_codVenta = "/html[1]/body[1]/my-app[1]/main[1]/saleprocess[1]/div[1]/div[1]/div[1]/app-fin-venta[1]/div[1]/div[1]/div[3]/p[2]/span[2]";
    public final String btn_usuario = "//img[@class='user']";
    public final String btn_bandejaAudios = "//div[@class='menuperfil noen']//a[contains(text(),'Bandeja de audios')]";
    public final String btn_IrAlMenuAlta    = "/html/body/my-app/main/saleprocess/div/div/div/app-fin-venta/div/div/div[4]/a";
    //public final String btn_IrAlMenuAlta  = "//*[contains(text(),'IR AL MENÚ')]";
    /**************************************************
     #Dirigirse al Menú Principal
     **************************************************/
    public String getCodVenta() throws Exception {
        return getlabel("Codigo de Venta", lbl_codVenta);
    }

    public void goBandejaAudios() throws Throwable {
        try {
            doclickByJS("Click en boton usuario", btn_usuario, true);
            clickIntoButton("Click Boton usuario", btn_usuario);
            doclickByJS("Click en Bandeja de audios", btn_bandejaAudios, true);
        }catch (IOException | AWTException e){
            e.printStackTrace();
        }
    }
    public void doClickIrAlMenu()  throws Throwable {
        try {
            System.out.println("VF013_ClosingSales: DoClickAlMenu");
                System.out.println("VF013_ClosingSales: DoClickAlMenu Alta Simple 1");
                doclickByJS("Click en Ir al Menu", btn_IrAlMenuAlta, true);
                System.out.println("VF013_ClosingSales: DoClickAlMenu Alta Simple 1");
            } catch (IOException | AWTException e) {
            e.printStackTrace();
        }
    }
}
