package VentasFija.pageObject.VentasFija;

import VentasFija.helpers.BasePage;

import java.io.IOException;

public class VF014_GreetingSpeech extends BasePage{
    /**************************************************
     #Localizadores de Inicio de Venta en Altas, Migraciones y SVA - Remoto
     **************************************************/
    public final String txt_clientphone = "//*[@id=\"mobilePhone\"]";
    public final String btn_registerphone = "//*[@id=\"data\"]/contacto/div/div/div/form/div[2]/div[1]/div/a";
    public final String btn_continuar = "//*[@id=\"continuar_\"]";
    /**************************************************
     #Localizadores de Registro de Celular
     **************************************************/
    public void Registrar_Celular_de_Cliente(String sclientphone) throws Throwable{
        try {
            jsScrollIntoView("Scrolldown", btn_registerphone, false);
            doAddTextField("Ingresando Telefono de Cliente",txt_clientphone,sclientphone,true);
            doClick("Registro del Celular del Cliente",btn_registerphone,true);
            Thread.sleep(2000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Obviar_y_o_Continuar() throws Throwable{
        try {
            doClick("Hacer Click en Obviar y Continuar",btn_continuar,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
