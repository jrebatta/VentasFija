package VentasFija.pageObject.VentasFija;

import VentasFija.helpers.BasePage;
import VentasFija.utility.PostgresqlUtility;
import org.testng.Assert;

import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
public class VF010_ContractPage extends BasePage {
    /**************************************************
     #Localizadores de Contrato
     **************************************************/
    //public final String btn_contratar         = "//*[@id=\"data\"]/saleprocess/div/div/div/contract/div/div/div[2]/div[3]/div[3]/div/div/div/a";
    public final String btn_contratar           = "//*[contains(text(),'CONTRATAR')]";
    /**************************************************
     #Localizadores de Flujo Discapacitado
     **************************************************/
    public final String btn_ReintentarValBio    = "//*[@id=\"data\"]/digitalcontract/div[1]/div[1]/div[2]/a[1]";
    public final String btn_clientediscapacidad = "//*[@id=\"data\"]/digitalcontract/div/div/div[2]/div[3]/div/div[3]/div[2]/div/div[1]/a";
    public final String txt_tokendiscapacidad   = "//*[@id=\"data\"]/digitalcontract/div/div/div[2]/div[3]/div/div[3]/div[2]/div/div[2]/div[2]/input";
    public final String btn_validartoken        = "//*[@id=\"data\"]/digitalcontract/div/div/div[2]/div[3]/div/div[3]/div[2]/div/div[2]/div[3]/a";
    /**************************************************
     #Consulta Token Discapacitado
     **************************************************/
    PostgresqlUtility postgresqlUtility=new PostgresqlUtility();
    public String obtener_tokediscapacitado(String url_bd,String bd,String port,String user_name,String password_bd,String codigo_atis) throws SQLException {
        Connection conn= postgresqlUtility.connectDatabase(url_bd,port,bd,user_name,password_bd);
        Statement stmt = conn.createStatement();
        int cod= Integer.parseInt(codigo_atis);
        ResultSet rs= stmt.executeQuery("SELECT * FROM ibmx_a07e6d02edaf552.tdp_token_vendedor WHERE codatis='"+cod+"'");
        String stokendiscapacitado=null;
        while (rs.next()) {
            stokendiscapacitado = rs.getString("token_vent_disc");
            System.out.println(stokendiscapacitado);
        }
        conn.close();
        return stokendiscapacitado;
    }
    /**************************************************
     #Flujo Discapacitado
     **************************************************/
    public void DoClicvalidacion_tokendiscapacitado(String stokendiscapacitado) throws Throwable {
        try {
            while(validateObjExist(btn_ReintentarValBio)) {
                doclickByJS("Clic en Reintentar Validación Biométrica", btn_ReintentarValBio, false);
                Thread.sleep(5000);
            }
            doclickByJS("Clic en Cliente con Discapacidad", btn_clientediscapacidad, false);
            doAddTextField("Ingresando Token",txt_tokendiscapacidad, stokendiscapacitado,true);
            doclickByJS("Clic en Validar Token", btn_validartoken, false);
        } catch (IOException | AWTException | AssertionError e) {
            e.getMessage();
            e.getStackTrace();
            e.printStackTrace();
            Assert.fail("Fallo en el metodo Validación de Token Discapacitado",e);
        }
    }
    /**************************************************
     #OpCo. Alta, Migraciones y SVA
     **************************************************/
    public void doClickContratar() {
        String UIname="Click en contratar";
        try {
            jsScrollIntoView("Scroll hasta el boton continuar",btn_contratar,false);
            System.out.println("VF010_ContractPage: ValidaciónValidacionDoClickContratar1");
            doclickByJS("Clic en contratar", btn_contratar, true);
            System.out.println("VF010_ContractPage: ValidaciónValidacionDoClickContratar2");
        } catch (IOException | AWTException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**************************************************
     #Validación de Objetos
     **************************************************/
    public boolean validarBtnContratar(){
        boolean respuesta= false;
        try{
            respuesta=validateObjExist(btn_contratar);
            System.out.println("VF010_ContractPage: ValidaciónValidacionBtnContratar1");
        }catch (Throwable e){
            e.printStackTrace();
        }
        return respuesta;
    }
}
