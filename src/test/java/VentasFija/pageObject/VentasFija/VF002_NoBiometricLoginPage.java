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
public class VF002_NoBiometricLoginPage extends BasePage {
    /**************************************************
     #Localizadores Para Inicio de Sesión Presencial y Remoto
     **************************************************/
    public final String txt_passwordvf              = "|id|password";
    //public final String btn_ingresarpresencial    = "//*[@id=\"signup-form\"]/div[4]/a";
    //public final String btn_ingresarremoto        = "//*[@id=\"signup-form\"]/div[3]/a";
    public final String btn_ingresar                = "//*[contains(text(),'Ingresar')]";
    /**************************************************
     #Localizadores Para Ingreso de Token en Sesión Presencial
     **************************************************/
    public final String txt_token                   = "|id|token";
    /**************************************************
     #Localizadores Conexión a BD
     **************************************************/
    PostgresqlUtility postgresqlUtility=new PostgresqlUtility();

    public String obtener_token(String url_bd, String bd, String port, String user_name, String password_bd, String codigo_atis) throws SQLException {
        String token=null;
        try{
        Connection conn= postgresqlUtility.connectDatabase(url_bd,port,bd,user_name,password_bd);
        Statement stmt = conn.createStatement();
        int cod= Integer.parseInt(codigo_atis);
        ResultSet rs= stmt.executeQuery("SELECT * FROM ibmx_a07e6d02edaf552.tdp_token_vendedor WHERE codatis='"+cod+"'");

        while (rs.next()) {
            token = rs.getString("token");
            System.out.println(token);
        }
        conn.close();
       }catch(Exception e){
            e.printStackTrace();
//            Assert.fail("Fallo en conexion PostgreSQL",e);
       }
        return token;

       }
    /**************************************************
     #Localizadores Login Presencial
     **************************************************/
    public void loginPresencial(String pass, String token) {
        try {
            doAddTextField("Ingresando Password",txt_passwordvf,pass,false);
            doAddTextField("Ingresando Token",txt_token,token,true);
            //doClick("Hacer Click en Iniciar Sesion", btn_ingresarpresencial,false);
            doClick("Click en Iniciar Sesion", btn_ingresar,true);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Fallo en el metodo TrueLoginPresencial",e);
        }
    }
    /**************************************************
     #Localizadores Remoto
     **************************************************/
    public void loginRemoto(String pass) {
        try {
            doAddTextField("Ingresando Password",txt_passwordvf,pass,true);
            Thread.sleep(1000);
            doClick("Hacer Click en Iniciar Sesion", btn_ingresar,false);
        } catch (IOException | AWTException | AssertionError | InterruptedException e) {
            e.getMessage();
            e.getStackTrace();
            e.printStackTrace();
            Assert.fail("Fallo en el metodo TrueLoginRemoto",e);
        }
    }
}
