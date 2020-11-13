package VentasFija.utility;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class GlobalVariable {

	public static final String BROWSER = "CHROME";
	//	public static final String BROWSER = "IE";

	public static final String AUT_BROWSER_SERVER_PATH_CHROME = "src/test/resources/drivers/chromedriver.exe";
	public static final String AUT_BROWSER_SERVER_PATH_IE = "src/test/resources/drivers/IEDriverServer.exe";
	public static final String AUT_BROWSER_SERVER_PATH_FF = "src/test/resources/drivers/geckodriver.exe";


	public static final String AUT_SCREENSHOT_PATH = "target/images/";

	public static final String AUT_STEPREPORT_PATH = "target/Extent_Report/stepReport.html";

	//RUTA DEL EXCEL CON INPUT DATA:
	public static final String DATAFILE_PATH = "./src/test/resources/data/TestData.xlsx"; //Ruta
	public static final String HOJA_CONEXIONES = "Conexiones"; //Nombre de la Hoja Conexiones
	public static final String HOJA_LOGIN = "Login"; //Nombre de la Hoja Login
	public static final String HOJA_CLIENTES = "Clients"; //Nombre de la Hoja Clients

	//GENERACION DE ARCHIVO WORD:
	public static final Boolean IMPRIMIR_WORD = true; //True: Generacion de documento WORD

}
