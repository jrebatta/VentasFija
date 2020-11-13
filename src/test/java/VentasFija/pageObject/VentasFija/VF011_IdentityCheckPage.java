package VentasFija.pageObject.VentasFija;

import VentasFija.helpers.BasePage;
import org.testng.Assert;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

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
public class VF011_IdentityCheckPage extends BasePage {
    /**************************************************
     #Localizadores de Validación de Identidad
     **************************************************/
    public final String cbo_Madre                   =   "|id|parentescoSelect";
    //public final String btn_Siguiente             =   "//*[@id=\"data\"]/saleprocess/div/div/div/reniec/div[2]/div/div[2]/div[4]/a";
    public final String btn_Siguiente               =   "//*[contains(text(),'SIGUIENTE')]";
    //public final String btn_consultarnuevamente   =   "/html/body/my-app/main/saleprocess/div/div/div/reniec/div[2]/div[1]/div/a[1]";
    public final String btn_consultarnuevamente     =   "//*[contains(text(),'Consultar nuevamente')]";
    /**************************************************
     #Localizadores de Flujo Offline
     **************************************************/
    public final String lbl_alertaoffline           =   "//*[@id=\"data\"]/saleprocess/div/div/div/reniec/div[3]/div/div[2]/div[4]/label";
    public final String txt_apellidoscliente        =   "//*[@id=\"data\"]/saleprocess/div/div/div/reniec/div[3]/div/div[2]/div[3]/table/tbody/tr[1]/td[2]/input";
    public final String txt_nombrescliente          =   "//*[@id=\"data\"]/saleprocess/div/div/div/reniec/div[3]/div/div[2]/div[3]/table/tbody/tr[2]/td[2]/input";
    public final String txt_nombremadre             =   "//*[@id=\"data\"]/saleprocess/div/div/div/reniec/div[3]/div/div[2]/div[3]/table/tbody/tr[3]/td[2]/input";
    public final String txt_nombrepadre             =   "//*[@id=\"data\"]/saleprocess/div/div/div/reniec/div[3]/div/div[2]/div[3]/table/tbody/tr[4]/td[2]/input";
    public final String txt_fechanacimiento         =   "|id|date";
    public final String cbo_Departamento            =   "|id|department";
    public final String cbo_Provincia               =   "|id|city";
    public final String cbo_Distrito                =   "|id|district";
    public final String btn_siguiente               =   "//*[@id=\"data\"]/saleprocess/div/div/div/reniec/div[3]/div/div[2]/div[5]/a";
    /**************************************************
     #Validación de Identidad
     **************************************************/
    public void identityCheck(String Madre) {
        try {
            updatepagebystring(btn_consultarnuevamente);
            System.out.println("VF011_IdentityCheckPage: ValidaciónIdentityCheck1");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        try {
            doSelectDropdown("Escoger el nombre de la madre",cbo_Madre,Madre,false);
            System.out.println("VF011_IdentityCheckPage: ValidaciónIdentityCheck2");
            doclickByJS("Click en siguiente",btn_Siguiente,true);
            System.out.println("VF011_IdentityCheckPage: ValidaciónIdentityCheck3");
        } catch (IOException | AWTException e) {
            e.printStackTrace();
        }
    }
    /**************************************************
     #Flujo Offline
     **************************************************/
    public void reniecOffline() throws Throwable {
        int count_1=0;
        int count_2=0;
        try {
            System.out.println("VF011_IdentityCheckPage: ValidacionReniecOffline1");
            while (!validateObjExist(lbl_alertaoffline) && count_1<6) {
                count_1=count_1+1;
                System.out.println("VF011_IdentityCheckPage: La alerta de OFFLINE NO EXISTE " +count_1);
                if (validateObjExist(btn_consultarnuevamente)) {
                    System.out.println("VF011_IdentityCheckPage: El boton de consultar nuevamente");
                    while (validateObjExist(btn_consultarnuevamente)) {
                        count_2=count_2+1;
                        doclickByJS("Clic en Consultar Nuevamente", btn_consultarnuevamente, false);
                        System.out.println("VF011_IdentityCheckPage: El boton de consultar nuevamente existe "+ count_2);
                        Thread.sleep(2000);
                    }
                } else {
                    updatepage();
                }
            }
            System.out.println("VF011_IdentityCheckPage: ValidacionReniecOffline2");
            doAddTextField("Ingresando Apellido del Cliente", txt_apellidoscliente, "APELLIDOS DEL CLIENTE", false);
            doAddTextField("Ingresando Nombres del Cliente", txt_nombrescliente, "NOMBRES DEL CLIENTE", false);
            doAddTextField("Ingresando Nombres de la Madre del Cliente", txt_nombremadre, "NOMBRES DE LA MADRE", false);
            doAddTextField("Ingresando Nombres del Padre del Cliente", txt_nombrepadre, "NOMBRES DEL PADRE", false);
            doAddTextField("Ingresando Nombres del Padre del Cliente", txt_fechanacimiento, "01/01/1990", false);
            doSelectDropdown("Seleccionar Departamento", cbo_Departamento, "Lima", false);
            doSelectDropdown("Seleccionar Provincia", cbo_Provincia, "Lima", false);
            doSelectDropdown("Seleccionar Distrito", cbo_Distrito, "San Isidro", false);
            doclickByJS("Clic en Siguiente", btn_siguiente, true);
            //Thread.sleep(2000);
            System.out.println("VF011_IdentityCheckPage: ValidacionReniecOffline3");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
    /**************************************************
     #Consulta al Servicio de Reniec
     **************************************************/
    public void post_request()
    {
        RestAssured.baseURI ="https://api.us.apiconnect.ibmcloud.com/telefonica-del-peru-production/ter/consulta-reniec/consultarPersona";
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", "tester27"); // Cast
        requestParams.put("LastName", "tested27");
        requestParams.put("UserName", "test27");
        requestParams.put("Password", "test27");
        requestParams.put("Email",  "test27@gmail.com");
        request.body(requestParams.toString());
        Response response = request.post("/register");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);

        JsonPath jsonPathEvaluator = response.jsonPath();
        String successCode = jsonPathEvaluator.get("SuccessCode");
        /*
         * System.out.println(jsonPathEvaluator.getString("SuccessCode"));
         * System.out.println(successCode);
         */
        Assert.assertEquals( "OPERATION_SUCCESS", successCode,"Correct Success code was returned");
    }
}
