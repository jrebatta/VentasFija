/**************************************************
 #Autor : Wipro
 #Description : E2E - Venta Fija – Alta
 #Fecha de creación: Feb 2020
 # Venta Fija Version: XXXX
 #Input Parameters: --
 #Nombre que modifica : --
 #Fecha modificación: --
 **************************************************/
package VentasFija.tests;
import VentasFija.helpers.BasePage;
import VentasFija.exceptions.ExceptionHandler;
import VentasFija.helpers.Hook;
import VentasFija.utility.GlobalVariable;
import VentasFija.utility.ScreenshotUtility;
import VentasFija.utility.Sleeper;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import VentasFija.pageObject.VentasFija.*;
import VentasFija.pageObject.WebAdmin.*;
import VentasFija.pageObject.PuertoBiomatch.PB001_LocalHost;
import VentasFija.utility.ExcelUtils;
import gherkin.formatter.model.Scenario;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Steps_Presencial {
    public WebDriver driver;
    private Hook hook = new Hook();
    private String tokenlogin;
    private String tokendiscapacitado;
    String sError;
    WA001_LoginPage                 WA001LoginPage                  = new WA001_LoginPage();
    WA002_HomePage                  WA002HomePage                   = new WA002_HomePage();
    WA003_TokenModulePage           WA003TokenModulePage            = new WA003_TokenModulePage();
    WA004_UserListPage              WA004UserListPage               = new WA004_UserListPage();
    WA005_CodeDetailPage            WA005DetalleCodPage             = new WA005_CodeDetailPage();
    PB001_LocalHost                 PB001LocalHost                  = new PB001_LocalHost();
    VF001_PreLoginPage              VF001PreLoginPage               = new VF001_PreLoginPage();
    VF002_NoBiometricLoginPage      VF002NoBiometricLoginPage       = new VF002_NoBiometricLoginPage();
    VF003_HomePage                  VF003HomePage                   = new VF003_HomePage();
    VF004_CustomerDataPage          VF004CustomerDataPage           = new VF004_CustomerDataPage();
    VF005_InstallationSitePage      VF005InstallationSitePage       = new  VF005_InstallationSitePage();
    VF006_ProductSelectionPage      VF006ProductSelectionPage       = new VF006_ProductSelectionPage();
    VF007_SVASelectionPage          VF007SVASelectionPage           = new  VF007_SVASelectionPage();
    VF008_SaleTermsPage             VF008SaleTermsPage              = new VF008_SaleTermsPage();
    VF009_SalesSummaryPage          VF009SalesSummaryPage           = new  VF009_SalesSummaryPage();
    VF010_ContractPage              VF010ContractPage               = new VF010_ContractPage();
    VF011_IdentityCheckPage         VF011IdentityCheckPage          = new VF011_IdentityCheckPage();
    VF012_InstallationContactPage   VF012InstallationContactPage    = new VF012_InstallationContactPage();
    VF013_ClosingSales              VF013ClosingSales               = new VF013_ClosingSales();
    VF014_GreetingSpeech            VF014GreetingSpeech             = new VF014_GreetingSpeech();
    VF015_CampaignPage              VF015CampaignPage               = new VF015_CampaignPage();
    protected ScreenshotUtility utilitarios = new ScreenshotUtility();
    public String sTester;



    /***
     *
     * Escenario 1: Logeo en la web de venta fija por Flujo Presencial
     *
     */
    @Given("^Presencial-Abre login en web de venta fija \"([^\"]*)\"$")
    public void presencial_abriendo_el_navegador(int id) throws Throwable {
     try {
         Object[][] parameters_2 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_LOGIN);//loadURL();
         String sBrowser = parameters_2[id][2].toString();
         String sURL = parameters_2[id][3].toString();
         sTester = parameters_2[id][9].toString();
         System.out.println("testerName:"+sTester);
         driver = hook.setUp(sBrowser, sURL);
     }catch(AssertionError e){
         sError = "Error en levantar Browser o boton Supervisor";
         ExceptionHandler.doException(e, sError, true, sTester, id, false, false);
     }
     }
    @When("^Presencial-Ingreso codatis y doy clic en continuar \"([^\"]*)\"$")
    public void presencial_ingresa_codatis_continuar (int id) throws  Throwable {
        try{
            Object[][] parameters_3 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_LOGIN);//loadURL();
            sTester =  parameters_3[15][9].toString();
            String codigoatis = parameters_3[id][5].toString();
            ///TEST
            String sURL = parameters_3[15][3].toString();
            BasePage base = new BasePage();
            base.redirigirPage(sURL);

            VF001PreLoginPage.prelogin(codigoatis);
        }catch (AssertionError e){
            sError = "Fallo primer ingreso a la web de ventas por flujo presencial";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);

        }
    }
    @And("^Presencial-Obtengo token \"([^\"]*)\"$")
    public void presencial_obtener_token(int id) throws Throwable{
        try{
            Object[][] parameters_2 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_LOGIN);//loadURL();
            String codigoatis = parameters_2[id][5].toString();
            Object[][] parameters_1 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CONEXIONES);
            //getBDconnections();
            String url_bd = parameters_1[0][1].toString();
            String BD = parameters_1[0][2].toString();
            String port = parameters_1[0][3].toString();
            String username = parameters_1[0][4].toString();
            String password = parameters_1[0][5].toString();
          /*  System.out.println("url:"+url_bd);
            System.out.println("BD:"+BD);
            System.out.println("port:"+port);
            System.out.println("username:"+username);
            System.out.println("password:"+password);
            System.out.println("codigoatis:"+codigoatis);
            */
            tokenlogin = VF002NoBiometricLoginPage.obtener_token(url_bd,BD,port,username,password,codigoatis);
        }catch (AssertionError e){
            sError = "Error Obteniendo Token";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);

        }
    }
    //Acciones Sobre Web Ventas Fija
    @Then("^Presencial-Ingreso password y token, Clic en iniciar sesion \"([^\"]*)\"$")
    public void presencial_ingresar_pass_token(int id) throws Throwable{
        try{
            Object[][] parameters_2 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_LOGIN);//loadURL();
            String pass2 = parameters_2[id][6].toString();
            String suser = parameters_2[id][7].toString();
            System.out.println("DEFECT1");
            VF002NoBiometricLoginPage.loginPresencial(pass2, tokenlogin);
            System.out.println("DEFECT2");
            System.out.println("Valor del excel: ");
            System.out.println(suser);
            String id_string = Integer.toString(id);
            Assert.assertTrue(VF003HomePage.validateUser(suser,id_string));
          //  Hook.generarWordFile(sTester, idve);
        }catch (AssertionError e){
            sError = "Error Login";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);
        }
    }

    /***
     *
     * Escenario 2: Alta de un duo plano
     *
     */

    @Given("^Presencial-Selecciono Operacion Comercial Alta Nueva \"([^\"]*)\"$")
    public void presencial_SeleccionoOperacionComercialAltaNueva(int id)  throws Throwable {
        try{
            Sleeper.Sleep(2000);
            Object[][] parameters = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            sTester = parameters[id][9].toString();

            Assert.assertTrue(VF003HomePage.validarBtnAlta());
            VF003HomePage.opCoAltaNueva(id);
            System.out.println("DEFECT2");

        }catch (AssertionError e){
            sError = "ERROR_Seleccionar_Alta";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);        }
    }
    @And("^Presencial-Ingreso datos del cliente \"([^\"]*)\", fijo el lugar de instalacion y doy click en Continuar$") //ALTA
    public void presencial_DefinirDatosCliente_Instalacion(int id) throws Throwable {
        try{
            Object[][] parameters_3 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String sTipDoc = parameters_3[id][1].toString();
            String sNumDoc = parameters_3[id][2].toString();
            String sdepartamento = parameters_3[id][3].toString();
            String sprovincia = parameters_3[id][4].toString();
            String sdistrito = parameters_3[id][5].toString();
            String sdireccion = parameters_3[id][6].toString();
            String sreferencia = parameters_3[id][7].toString();
            VF004CustomerDataPage.insertDNIClient(sTipDoc, sNumDoc);
            System.out.println("DEFECT3");
            Thread.sleep(3000);
            VF004CustomerDataPage.ubicacionInstalacion(sdepartamento, sprovincia, sdistrito);
            VF004CustomerDataPage.evaluar();
            System.out.println("DEFECT4");
            Assert.assertTrue(VF004CustomerDataPage.validarBtnContinuar());
            VF004CustomerDataPage.clickContinuar();
            System.out.println("DEFECT5");
            Thread.sleep(800);
            VF005InstallationSitePage.fijarDireccionMapa(sdireccion,sreferencia);
            System.out.println("DEFECT6");
            Assert.assertTrue(VF005InstallationSitePage.validar_BtnContinuar());
            VF005InstallationSitePage.continuar();
            System.out.println("DEFECT7");
        }catch (AssertionError e){
            sError = "ERROR_Seleccionar_Alta";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);
        }
    }

    @And("^Presencial-Selecciono la campania \"([^\"]*)\"$")
    public void remoto_Seleccionolacampania(int id) throws Throwable {
        try {
            System.out.println("Inicio de Llamado a Parametros de campaña");
            Object[][] Parameters_3 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String scampania = Parameters_3[id][27].toString();
            String id_string = Integer.toString(id);
            //System.out.println("Fin de Llamado a Parametros");
            VF015CampaignPage.SelectionCampaign(id_string, scampania);
            //System.out.println("Direccion y Referencia ingresada");
            //Assert.assertTrue(VF005InstallationSitePage.Validar_BtnContinuar());
            //VF005InstallationSitePage.Continuar();
            System.out.println("Continuar");
        } catch (AssertionError e) {
            sError = "ERROR_Selección_Campaña_Remoto";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);
        }
    }

    @And("^Presencial-Selecciono el producto del \"([^\"]*)\" a contratar Alta$")
    public void presencial_SelecciondeProducto(int id) throws Throwable {
        try {
            Object[][] parameters_3 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String sProducto = parameters_3[id][8].toString();
            String sbloquefullhd = parameters_3[id][9].toString();
            String sbloquehbonew = parameters_3[id][10].toString();
            String sbloquefoxnew = parameters_3[id][11].toString();
            String sbloquehotpack = parameters_3[id][12].toString();
            String sbloquegoldenpremier = parameters_3[id][13].toString();
            String sbloqueestelar = parameters_3[id][14].toString();
            String spasmarthd = parameters_3[id][15].toString();
            String srsmartwifi = parameters_3[id][16].toString();
            String ssvainternet = parameters_3[id][17].toString();
            String ssvalinea = parameters_3[id][18].toString();
            String scorreopasmarthd = parameters_3[id][19].toString();

            String snombreplan = parameters_3[id][29].toString();
            String scodeplan = parameters_3[id][30].toString();

            //VF006ProductSelectionPage.doClickSeleccionProductoNuevo(sProducto);

            VF006ProductSelectionPage.doSelectPlanProduct(snombreplan, scodeplan);

            System.out.println("DEFECT8");
            Thread.sleep(200000);
            /***COMENTANDO para implementar seleccion paquetes**/

            Assert.assertTrue(!VF006ProductSelectionPage.validateAlert());
            VF007SVASelectionPage.seleccionSVATV_Altas(sbloquefullhd, sbloquehbonew, sbloquefoxnew, sbloquehotpack, sbloquegoldenpremier, sbloqueestelar, spasmarthd, scorreopasmarthd);
            System.out.println("DEFECT9");
            VF007SVASelectionPage.seleccionSVAInternet_Altas(srsmartwifi, ssvainternet);
            System.out.println("DEFECT10");
            VF007SVASelectionPage.seleccionSVALinea_Altas(ssvalinea);
            System.out.println("DEFECT11");
            VF007SVASelectionPage.doClickContinuar();
        } catch (AssertionError e) {
            sError = "ERROR_Seleccionar_Alta_producto";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);
        }
    }
    @When("^Presencial-Acepto las condiciones de venta, resumen de venta y contrato Alta \"([^\"]*)\"$")
    public void presencial_ProcesodeCondicionesyVentaAlta(int idcl) throws Exception, Throwable {
        try{

            Object[][] parameters_1 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CONEXIONES);
//getBDconnections();
            String url_bd = parameters_1[0][1].toString();
            String BD = parameters_1[0][2].toString();
            String port = parameters_1[0][3].toString();
            String username = parameters_1[0][4].toString();
            String password = parameters_1[0][5].toString();

            Object[][] parameters_2 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_LOGIN);//loadURL();
            String codigoatis = parameters_2[1][5].toString();

            Object[][] parameters_3 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String sdebitoautomatico = parameters_3[idcl][20].toString();
            String stratamientodatos = parameters_3[idcl][21].toString();
            String spackverde = parameters_3[idcl][22].toString();
            String scontrolparental = parameters_3[idcl][23].toString();
            String scorreodebitoautomatico = parameters_3[idcl][19].toString();
            String scorreopackverde = parameters_3[idcl][19].toString();
            String sdiscapacidad = parameters_3[idcl][24].toString();

            VF008SaleTermsPage.doClickDebitoAutomatico(sdebitoautomatico, scorreodebitoautomatico);
            VF008SaleTermsPage.doClickTratamientoDatos(stratamientodatos);
            VF008SaleTermsPage.doClickPackVerde(spackverde, scorreopackverde);
            VF008SaleTermsPage.doClickControlParental(scontrolparental);
            VF008SaleTermsPage.doClickContinuar();
            VF009SalesSummaryPage.salesSummaryPage();
            Assert.assertTrue(VF010ContractPage.validarBtnContratar());
            VF010ContractPage.doClickContratar();
            //Thread.sleep(2000);

            /*if(sdiscapacidad.equalsIgnoreCase("Si")) {
                String navegador = Parameters_2[14][2].toString();
                String urlpuerto = Parameters_2[14][3].toString();
                ((JavascriptExecutor) driver).executeScript("window.open('"+urlpuerto+"')");
                Set<String> customerWindow = driver.getWindowHandles();
                driver.switchTo().window((String) customerWindow.toArray()[1]);
                PB001LocalHost.DoClicPuertoBiomatch();
                customerWindow = driver.getWindowHandles();
                driver.switchTo().window((String) customerWindow.toArray()[0]);
                Thread.sleep(3000);
                tokendiscapacitado = VF010ContractPage.obtener_tokediscapacitado(url_bd,BD,port,username,password,codigoatis);
                VF010ContractPage.DoClicvalidacion_tokendiscapacitado(tokendiscapacitado);
            }
             */
            //else {
            //if(sdiscapacidad.equalsIgnoreCase("No")) {

            //}
        }catch (AssertionError e){
            sError = "ERROR_Fallo proceso de condiciones de venta y contrato";
            ExceptionHandler.doException(e, sError, true, sTester, idcl, false, false);

        }
    }
    @And("^Presencial-Valido la identidad del cliente Alta \"([^\"]*)\"$")
    public void presencial_Validacion_Identidad(int idcl) throws Exception, Throwable {
        try{
            Object[][] parameters_3 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String iReniec = parameters_3[idcl][25].toString();

            if(iReniec.equalsIgnoreCase("OFFLINE")) {
                System.out.println("ValidaciónStepIdentidadCliente1");
                VF011IdentityCheckPage.reniecOffline();
                System.out.println("ValidaciónStepIdentidadCliente2");
            }
            else{
                VF011IdentityCheckPage.identityCheck(iReniec);
                System.out.println("ValidaciónStepIdentidadCliente3");
            }

            /*Hook.generarWordFile();
            Object[][] Parameters_2 = LoadURL();
            String sURL = Parameters_2[15][3].toString();
            BasePage base = new BasePage();
            base.RedirigirPage(sURL);
             */
            //hook.closeBrowser(BasePage.handleDriver());

        }catch (AssertionError e){
            sError = "ERROR_Seleccionar_Alta_producto";
            ExceptionHandler.doException(e, sError, true, sTester, idcl, false, false);

        }
    }
    @Then("^Presencial-Agrego numero de contacto, cierro la venta de Alta e Ir al Menú \"([^\"]*)\"$")
    public void presencial_AddNumContacAndFinishAlta(int idcl) throws Exception, Throwable {
        try{
            Object[][] parameters_3 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String stelefono = parameters_3[idcl][26].toString();
            System.out.println("STEP11");
            VF012InstallationContactPage.agendarOSoloInsertarTelefono(stelefono);
            System.out.println("STEP12");
            //Assert.assertTrue(VF012InstallationContactPage.validarBtnFinalizar());
            // ACA descomentar para confirmar la venta
          //  VF012InstallationContactPage.doClickFinalizarVenta();
            System.out.println("STEP13");
            Thread.sleep(100);
            //VF013SalesCompletionPage.DoClickMenuPrincipal();
            VF013ClosingSales.doClickIrAlMenu();
            System.out.println("STEP14");
          //  Hook.generarWordFile(sTester, idcl);
        }catch (AssertionError e){
            sError = "ERROR_Seleccionar_Alta_producto";
            ExceptionHandler.doException(e, sError, true, sTester, idcl, false, false);        }
    }
    /***
     *
     * Escenario 3: Migracion
     *
     */
    @Given("^Presencial-Selecciono Operacion Comercial Migraciones \"([^\"]*)\"$")
    public void presencialSeleccionoOperacionComercialMigraciones(int id)  throws Throwable {
        try{
            Object[][] parameters = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            sTester = parameters[id][9].toString();

            Thread.sleep(3000);
            Assert.assertTrue( VF003HomePage.validarBtnMigracion());
            VF003HomePage.opCoMigraciones(id);
        }catch (AssertionError e){
            sError = "ERROR_Seleccionar_Migracion";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);
        }

    }

    @And("^Presencial-Ingreso datos del cliente a migrar \"([^\"]*)\"$")
    public void presencial_DatosClienteMigrar(int id) throws Exception {
        try{
            Object[][] parameters_3 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String sTipDoc = parameters_3[id][1].toString();
            String sNumDoc = parameters_3[id][2].toString();
            VF004CustomerDataPage.insertDNIClient(sTipDoc, sNumDoc);
            VF004CustomerDataPage.evaluar();
        }catch (AssertionError e){
            sError = "ERROR_Ingreso_Datos";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);
        }
    }
    @And("^Presencial-Selecciono producto del \"([^\"]*)\" a migrar$")
    public  void presencial_productoAmigrar(int id) throws Exception, Throwable {
        try {
            Object[][] parameters_3 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String sProducto = parameters_3[id][8].toString();
            String sbloquefullhd = parameters_3[id][9].toString();
            String sbloquehbonew = parameters_3[id][10].toString();
            String sbloquefoxnew = parameters_3[id][11].toString();
            String sbloquehotpack = parameters_3[id][12].toString();
            String sbloquegoldenpremier = parameters_3[id][13].toString();
            String sbloqueestelar = parameters_3[id][14].toString();
            String spasmarthd = parameters_3[id][15].toString();
            String srsmartwifi = parameters_3[id][16].toString();
            String ssvainternet = parameters_3[id][17].toString();
            String ssvalinea = parameters_3[id][18].toString();
            String scorreopasmarthd = parameters_3[id][19].toString();

            VF006ProductSelectionPage.doClickSeleccionProductoActual();
            VF006ProductSelectionPage.doClicMigracion();
            System.out.print("Seleccion de Producto a Migrar");
            VF006ProductSelectionPage.doClickSeleccionProductoNuevo(sProducto);
            VF007SVASelectionPage.doClickMasSVA();

            System.out.println("DEFECT8");
            Assert.assertTrue(!VF006ProductSelectionPage.validateAlert());

            VF007SVASelectionPage.seleccionSVATV_MigraySVA(sbloquefullhd, sbloquehbonew, sbloquefoxnew, sbloquehotpack, sbloquegoldenpremier, sbloqueestelar, spasmarthd, scorreopasmarthd);
            System.out.println("DEFECT9");
            VF007SVASelectionPage.seleccionSVAInternet_MigraySVA(srsmartwifi, ssvainternet);
            System.out.println("DEFECT10");
            VF007SVASelectionPage.seleccionSVALinea_MigraySVA(ssvalinea);
            System.out.println("DEFECT11");
            VF007SVASelectionPage.doClickContinuar();
        } catch (AssertionError e) {
            sError = "ERROR_Seleccion producto";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);

        }
    }
    @When("^Presencial-Acepto las condiciones, resumen de venta y contrato Migraciones \"([^\"]*)\"$")
    public void presencial_ProcesodeCondicionesyVentaMigra(int id) throws Exception {
        try {
            Object[][] parameters_4 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String sdebitoautomatico = parameters_4[id][20].toString();
            String scorreodebitoautomatico = parameters_4[id][19].toString();

            VF008SaleTermsPage.doClickDebitoAutomatico(sdebitoautomatico, scorreodebitoautomatico);
            VF008SaleTermsPage.doClickContinuar();
            VF009SalesSummaryPage.salesSummaryPage();
            Assert.assertTrue(VF010ContractPage.validarBtnContratar());
            VF010ContractPage.doClickContratar();
        }catch (AssertionError e){
            sError = "ERROR_Ingreso_Datos";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);

        }
    }
    @And("^Presencial-Hago la validacion de reniec \"([^\"]*)\"$")
    public void presencial_ValidarReniec(int id) throws Exception {
        try{
            Object[][] parameters_3 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String ID_Reniec = parameters_3[id][25].toString();
            VF011IdentityCheckPage.identityCheck(ID_Reniec);

            //Hook.generarWordFile();
            //Object[][] Parameters_2 = loadURL();
            //String sURL = Parameters_2[15][3].toString();
            //BasePage base = new BasePage();
            //base.RedirigirPage(sURL);
            //hook.closeBrowser(BasePage.handleDriver());
        }catch (AssertionError e){
            sError = "ERROR_Fallo validacion de RENIEC del cliente";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);

        }

    }

    @Then("^Presencial-Agrego numero de contacto, cierro la venta de Migracion e Ir al Menú \"([^\"]*)\"$")
    public void presencial_AddNumContacAndFinishMigracion(int id) throws Throwable {
        try{
            Object[][] parameters_3 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String stelefono = parameters_3[id][26].toString();
            System.out.println("STEP11");
            VF012InstallationContactPage.agendarOSoloInsertarTelefono(stelefono);
            System.out.println("STEP12");
            //Assert.assertTrue(VF012InstallationContactPage.validarBtnFinalizar());
            VF012InstallationContactPage.doClickFinalizarVenta();
            System.out.println("STEP13");
            Thread.sleep(100);
            //VF013SalesCompletionPage.DoClickMenuPrincipal();
            VF013ClosingSales.doClickIrAlMenu();
            System.out.println("STEP14");
            //hook.closeBrowser(BasePage.handleDriver());
        }catch (AssertionError e){
            sError = "ERROR_Finalizacion_Venta_Migra";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);

        }
    }

    /***
     *
     * Escenario 4: SVA en Flujo Presencial
     *
     */

    @Given("^Presencial-Selecciono Operacion Comercial SVA \"([^\"]*)\"$")
    public void presencialSeleccionoOperacionComercialSVA(int id) throws Exception, Throwable {
        try{
            Object[][] parameters = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            sTester = parameters[id][9].toString();

            Assert.assertTrue(VF003HomePage.validarBtnSVA());
            VF003HomePage.OpCoSVA(id);
            System.out.println("Presencial-Clic en SVA");
        }catch (AssertionError e){
            sError = "ERROR_Seleccionar_SVA";
            ExceptionHandler.doException(e, sError, true, sTester, id, true, true);
        }
    }

    @And("^Presencial-Ingreso datos del cliente que contratara SVA \"([^\"]*)\"$")
    public void presencialIngresoDatosDelClienteQueContrataraSVA(int id) throws Throwable {
        try{
            Object[][] parameters_3 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String sTipDoc          = parameters_3[id][1].toString();
            String sNumDoc          = parameters_3[id][2].toString();
            VF004CustomerDataPage.insertDNIClient(sTipDoc, sNumDoc);
            System.out.println("DEFECT3");
            VF004CustomerDataPage.evaluar();
            System.out.println("DEFECT5");
        }catch (AssertionError e){
            sError = "ERROR_Fallo definicion ingreso de documento";
            ExceptionHandler.doException(e, sError, true, sTester, id, true, true);


        }

    }

    @And("^Presencial-Selecciono producto al que se sumara SVAs \"([^\"]*)\"$")
    public void presencialSeleccionoProductoSumaraSVAs(int id) throws Exception {
        try {
            VF006ProductSelectionPage.doClickSeleccionProductoActual();
            VF006ProductSelectionPage.doClicSVA();
            System.out.println("DEFECT6");
        } catch (AssertionError e){
            String sError = "ERROR_Seleccion_de_Producto";
            ExceptionHandler.doException(e, sError, true, sTester, id, true, true);

        }
    }

    @And("^Presencial-Selecciono SVA del \"([^\"]*)\"$")
    public void presencialSeleccionoSVADel(int id) throws Exception, Throwable {
        try {
            System.out.println("DEFECT7");
            Object[][] parameters_3     = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String sbloquefullhd        = parameters_3[id][9].toString();
            String sbloquehbonew        = parameters_3[id][10].toString();
            String sbloquefoxnew        = parameters_3[id][11].toString();
            String sbloquehotpack       = parameters_3[id][12].toString();
            String sbloquegoldenpremier = parameters_3[id][13].toString();
            String sbloqueestelar       = parameters_3[id][14].toString();
            String spasmarthd           = parameters_3[id][15].toString();
            String srsmartwifi          = parameters_3[id][16].toString();
            String ssvainternet         = parameters_3[id][17].toString();
            String ssvalinea            = parameters_3[id][18].toString();
            String scorreopasmarthd     = parameters_3[id][19].toString();
            System.out.println("DEFECT8");
            VF007SVASelectionPage.doClickMasSVA();
            Assert.assertTrue(!VF006ProductSelectionPage.validateAlert());
            VF007SVASelectionPage.seleccionSVATV_MigraySVA(sbloquefullhd, sbloquehbonew, sbloquefoxnew, sbloquehotpack, sbloquegoldenpremier, sbloqueestelar, spasmarthd, scorreopasmarthd);
            System.out.println("DEFECT9");
            VF007SVASelectionPage.seleccionSVAInternet_MigraySVA(srsmartwifi, ssvainternet);
            System.out.println("DEFECT10");
            VF007SVASelectionPage.seleccionSVALinea_MigraySVA(ssvalinea);
            System.out.println("DEFECT11");
            VF007SVASelectionPage.doClickContinuar();
        } catch (AssertionError e) {

            sError = "ERROR_Fallo Seleccion de SVA";
            ExceptionHandler.doException(e, sError, true, sTester, id, true, true);

        }
    }

    @When("^Presencial-Acepto las condiciones de venta, resumen de venta y contrato SVA \"([^\"]*)\"$")
    public void presencialAceptoLasCondicionesDeVentaResumenDeVentaYContratoSVA(int id) throws Exception {
        try {
            Object[][] parameters_3 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String sdebitoautomatico = parameters_3[id][20].toString();
            String scorreodebitoautomatico = parameters_3[id][19].toString();

            VF008SaleTermsPage.doClickDebitoAutomatico(sdebitoautomatico, scorreodebitoautomatico);
            VF008SaleTermsPage.doClickContinuar();
            VF009SalesSummaryPage.salesSummaryPage();
            Assert.assertTrue(VF010ContractPage.validarBtnContratar());
            VF010ContractPage.doClickContratar();
        } catch (AssertionError e) {
            sError = "ERROR_Fallo proceso de aceptacion de condiciones y contrato";
            ExceptionHandler.doException(e, sError, true, sTester, id, true, true);


        }
    }

    @And("^Presencial-Valido la identidad del cliente SVA \"([^\"]*)\"$")
    public void presencialValidoLaIdentidadDelClienteSVA(int id) throws Exception {
        try{
            Object[][] parameters_3 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String ID_Reniec = parameters_3[id][25].toString();
            VF011IdentityCheckPage.identityCheck(ID_Reniec);

        }catch (AssertionError e){
            sError = "ERROR_Fallo validacion de RENIEC del cliente";
            ExceptionHandler.doException(e, sError, true, sTester, id, true, true);

        }

    }

    @Then("^Presencial-Agrego numero de contacto, cierro la venta de SVA e Ir al Menú \"([^\"]*)\"$")
    public void presencialAgregoNumeroDeContactoCierroLaVentaDeSVAEIrAlMenú(int id) throws Throwable {
        try{
            //VF013SalesCompletionPage.DoClickMenuPrincipal();
            Object[][] parameters_3 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String stelefono = parameters_3[id][26].toString();
            VF012InstallationContactPage.agendarOSoloInsertarTelefono(stelefono);
            VF012InstallationContactPage.doClickFinalizarVenta();
            VF013ClosingSales.doClickIrAlMenu();
            Hook.closeBrowser(BasePage.handleDriver(), sTester, id);
        }catch (AssertionError e){
            sError = "ERROR_Fallo cierre de migracion";
            ExceptionHandler.doException(e, sError, true, sTester, id, true, true);


        }
    }
}