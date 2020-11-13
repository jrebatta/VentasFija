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
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import VentasFija.pageObject.VentasFija.*;
import VentasFija.utility.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Steps_Remoto {
    public WebDriver driver;
    private Hook hook = new Hook();
    BasePage basepage = new BasePage();
    private String tokenlogin;
    String sError;
    VF001_PreLoginPage VF001PreLoginPage = new VF001_PreLoginPage();
    VF002_NoBiometricLoginPage VF002NoBiometricLoginPage = new VF002_NoBiometricLoginPage();
    VF003_HomePage VF003HomePage = new VF003_HomePage();
    VF004_CustomerDataPage VF004CustomerDataPage = new VF004_CustomerDataPage();
    VF005_InstallationSitePage VF005InstallationSitePage = new VF005_InstallationSitePage();
    VF006_ProductSelectionPage VF006ProductSelectionPage = new VF006_ProductSelectionPage();
    VF007_SVASelectionPage VF007SVASelectionPage = new VF007_SVASelectionPage();
    VF008_SaleTermsPage VF008SaleTermsPage = new VF008_SaleTermsPage();
    VF009_SalesSummaryPage VF009SalesSummaryPage = new VF009_SalesSummaryPage();
    VF010_ContractPage VF010ContractPage = new VF010_ContractPage();
    VF011_IdentityCheckPage VF011IdentityCheckPage = new VF011_IdentityCheckPage();
    VF012_InstallationContactPage VF012InstallationContactPage = new VF012_InstallationContactPage();
    VF013_ClosingSales VF013ClosingSales = new VF013_ClosingSales();
    VF014_GreetingSpeech VF014GreetingSpeech = new VF014_GreetingSpeech();
    VF015_CampaignPage VF015CampaignPage = new VF015_CampaignPage();
    VF016_UpAudioPage VF016UpAudioPage = new VF016_UpAudioPage();
    VF017_SaleTermsPageOut VF017SaleTermsPageOut = new VF017_SaleTermsPageOut();
    protected ScreenshotUtility utilitarios = new ScreenshotUtility();
    String sTester;



    /***
     *
     * Escenario 1: Logeo en la web de venta fija por Flujo Remoto
     *
     */
    @Given("^Remoto-Abre login en web de venta fija \"([^\"]*)\"$")
    public void remoto_abriendo_el_navegador(int id) throws Throwable {
        try {
            System.out.println("PASO1_id:"+id);
        Object[][] parameters = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_LOGIN);//loadURL();
        String sBrowser = parameters[id][2].toString();
        String sURL = parameters[id][3].toString();
        sTester = parameters[id][9].toString();
        driver = hook.setUp(sBrowser, sURL);
        }catch(AssertionError e){
            sError = "ERROR_Falló validación del Given: Error en levantar Login Web de Venta Fija ";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);

        }
    }

    @When("^Remoto-Ingreso codatis y doy click en continuar \"([^\"]*)\"$")
    public void remoto_ingresa_codatis_continuar(int id) throws Throwable {
        try {
            Object[][] parameters = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_LOGIN);//loadURL();
            String codigoatis = parameters[id][5].toString();
            VF001PreLoginPage.prelogin(codigoatis);
        } catch (AssertionError e) {
            sError = "ERROR_Ingreso_Codigo_Atis_Remoto";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);
        }
    }

    @Then("^Remoto-Ingreso password Remoto y Clic en iniciar sesion \"([^\"]*)\"$")
    public void remoto_ingresar_pass(int id) throws Throwable {
        try {
            Object[][] parameters_2 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_LOGIN);//loadURL();
            String pass2 = parameters_2[id][6].toString();
            String suser = parameters_2[id][7].toString();
            VF002NoBiometricLoginPage.loginRemoto(pass2);
            System.out.println("Valor del excel: ");
            System.out.println(suser);
            String id_string = Integer.toString(id);
            //Assert.assertTrue(VF003HomePage.ValidateUser(suser,id_string));
            //Hook.generarWordFile(sTester, id);
        } catch (AssertionError e) {
            sError = "ERROR_Ingreso_Pass_Remot";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);
        }

    }

    /***
     *
     * Escenario 2: Alta en Flujo Remoto
     *
     */

    @Given("^Remoto-Selecciono Alta Nueva Flujo Remoto \"([^\"]*)\"$")
    public void remoto_SeleccionoOperacionComercialAltaNueva(int id) throws Throwable {
        try {            System.out.println("PASO2_id:"+id);
            //Assert.assertTrue(VF003HomePage.validarBtnAlta());
            System.out.println("Seleccionar ALTA Remoto");

            VF003HomePage.opCoAltaNueva(id);
            System.out.println("DEFECT2");
        } catch (AssertionError e) {
            sError = "ERROR_Seleccionar_Alta";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);
        }
    }

    @And("Remoto-Ingresar celular del cliente \"([^\"]*)\", clic en Registrar Celular y clic en Continuar$")
    public void remoto_Registro_celular_u_obviarycontinuar(int id) throws Throwable {
        try {
            Object[][] Parameters_3 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String stelefono = Parameters_3[id][26].toString();
            VF014GreetingSpeech.Registrar_Celular_de_Cliente(stelefono);
            VF014GreetingSpeech.Obviar_y_o_Continuar();
        } catch (AssertionError e) {
            sError = "ERROR_Registro_Celular";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);
        }
    }

    @And("^Remoto-Seleccionar Tipo de Doc, Ingresar Documento, Ingresar Departamento, Provincia y Distrito de Instalación \"([^\"]*)\", clic en Evaluar y clic en Continuar$")
    public void remoto_DefinirDatosCliente_Instalacion(int id) throws Throwable {
        try {
            Object[][] Parameters_3 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String sTipDoc = Parameters_3[id][1].toString();
            String sNumDoc = Parameters_3[id][2].toString();
            String sdepartamento = Parameters_3[id][3].toString();
            String sprovincia = Parameters_3[id][4].toString();
            String sdistrito = Parameters_3[id][5].toString();

            VF004CustomerDataPage.insertDNIClient(sTipDoc, sNumDoc);
            System.out.println("DEFECT3");
            Thread.sleep(3000);
            VF004CustomerDataPage.ubicacionInstalacion(sdepartamento, sprovincia, sdistrito);
            VF004CustomerDataPage.evaluar();
            System.out.println("DEFECT4");
            Assert.assertTrue(VF004CustomerDataPage.validarBtnContinuar());
            VF004CustomerDataPage.clickContinuar();
            System.out.println("DEFECT5");
        } catch (AssertionError e) {
            sError = "ERROR_Ingreso_Datos";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);

        }
    }

    @And("^Remoto-Valido la identidad del cliente \"([^\"]*)\"$")
    public void remoto_Validacion_Identidad(int id) throws Exception, Throwable {
        try {
            Object[][] parameters_3 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String iReniec = parameters_3[id][25].toString();

            if (iReniec.equalsIgnoreCase("OFFLINE")) {
                System.out.println("ValidaciónStepIdentidadCliente1");
                VF011IdentityCheckPage.reniecOffline();
                System.out.println("ValidaciónStepIdentidadCliente2");
            } else {
                VF011IdentityCheckPage.identityCheck(iReniec);
                System.out.println("ValidaciónStepIdentidadCliente3");
            }
        } catch (AssertionError e) {
            sError = "ERROR_Validacion_Identidad";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);
        }
    }

    @And("^Remoto-Valido la identidad del clientes \"([^\"]*)\"$")
    public void remoto_Validacion_Identidad2(int id) throws Exception, Throwable {
        try {
            Object[][] parameters_3 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String iReniec = parameters_3[id][25].toString();

            if (iReniec.equalsIgnoreCase("OFFLINE")) {
                System.out.println("ValidaciónStepIdentidadCliente1");
                VF011IdentityCheckPage.reniecOffline();
                System.out.println("ValidaciónStepIdentidadCliente2");
            } else {
                VF011IdentityCheckPage.identityCheck(iReniec);
                System.out.println("ValidaciónStepIdentidadCliente3");
            }
        } catch (AssertionError e) {
            sError = "ERROR_Validacion_Identidad";
            ExceptionHandler.doException(e, sError, false, sTester, id, true, true);
        }
    }

    @And("^Remoto-Ingreso de direccion y referencia \"([^\"]*)\", ubicar en mapa y Continuar$")
    public void remoto_IngresoDireccionReferencia(int id) throws Throwable {
        try {
            System.out.println("Inicio de Llamado a Parametros de dirección y referencia");
            Object[][] parameters_3 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String sdireccion = parameters_3[id][6].toString();
            String sreferencia = parameters_3[id][7].toString();
            System.out.println("Fin de Llamado a Parametros");
            VF005InstallationSitePage.fijarDireccionMapa(sdireccion, sreferencia);
            System.out.println("Direccion y Referencia ingresada");
            Assert.assertTrue(VF005InstallationSitePage.validar_BtnContinuar());
            VF005InstallationSitePage.continuar();
            System.out.println("Continuar");
        } catch (AssertionError e) {
            sError = "ERROR_Ingreso_Direccion_Remoto";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);

        }
    }

    @And("^Remoto-Selecciono la campania \"([^\"]*)\"$")
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

    @And("^Remoto-Selecciono el producto del \"([^\"]*)\" a contratar Alta$")
    public void remoto_SeleccionoelproductodelacontratarAlta(int id) throws Throwable {
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

            VF006ProductSelectionPage.doClickSeleccionProductoNuevo(sProducto);

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
            sError = "ERROR_Seleccionar_Producto";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);
        }
    }

    @And("^Remoto-Acepto las condiciones de venta, resumen de venta y contrato Alta \"([^\"]*)\"$")
    public void remoto_AceptolascondicionesdeventaresumendeventaycontratoAlta(int id) throws Throwable {
        try {
            Object[][] parameters_1 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CONEXIONES);//getBDconecctions();
            String url_bd = parameters_1[0][1].toString();
            String BD = parameters_1[0][2].toString();
            String port = parameters_1[0][3].toString();
            String username = parameters_1[0][4].toString();
            String password = parameters_1[0][5].toString();

            Object[][] parameters_2 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_LOGIN);//loadURL();
            String codigoatis = parameters_2[1][5].toString();

            Object[][] parameters_3 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String sdebitoautomatico = parameters_3[id][20].toString();
            String stratamientodatos = parameters_3[id][21].toString();
            String spackverde = parameters_3[id][22].toString();
            String scontrolparental = parameters_3[id][23].toString();
            String scorreodebitoautomatico = parameters_3[id][19].toString();
            String scorreopackverde = parameters_3[id][19].toString();
            String sdiscapacidad = parameters_3[id][24].toString();

            VF008SaleTermsPage.doClickDebitoAutomatico(sdebitoautomatico, scorreodebitoautomatico);
            VF008SaleTermsPage.doClickTratamientoDatos(stratamientodatos);
            VF008SaleTermsPage.doClickPackVerde(spackverde, scorreopackverde);
            VF008SaleTermsPage.doClickControlParental(scontrolparental);
            VF008SaleTermsPage.doClickContinuar();
            VF009SalesSummaryPage.salesSummaryPage();
            Assert.assertTrue(VF010ContractPage.validarBtnContratar());
            VF010ContractPage.doClickContratar();

        } catch (AssertionError e) {
            System.out.println("Error_AssertImprimirWORD:False");
            sError = "ERROR_Condiciones_Venta y contrato";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);

        }
    }

    @Then("^Remoto-Agrego numero de contacto, cierro la venta de Alta e Ir al Menú \"([^\"]*)\"$")
    public void remoto_AgregonumerodecontactocierrolaventadeAltaeIralMenú(int id) throws Throwable {
        try {
            Object[][] parameters_3 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String stelefono = parameters_3[id][26].toString();
            String oCodVenta;
            System.out.println("STEP11");
            VF012InstallationContactPage.agendarOSoloInsertarTelefono(stelefono);
            System.out.println("STEP12");
            VF012InstallationContactPage.doClickFinalizarVenta();

            oCodVenta = VF013ClosingSales.getCodVenta();
            System.out.println("Codigo de venta: " + oCodVenta);
            VF016UpAudioPage.cambiarNombreArchivo(oCodVenta);
            //Assert.assertTrue(VF012InstallationContactPage.validarBtnFinalizar());
            System.out.println("STEP13");
            Thread.sleep(100);
            //VF013SalesCompletionPage.DoClickMenuPrincipal();
            VF013ClosingSales.doClickIrAlMenu();
            System.out.println("STEP14");
            //hook.closeBrowser(BasePage.handleDriver());
        } catch (AssertionError e) {
            System.out.println("llego aca remotoX");
            sError = "ERROR_Finalizacion_Contrato";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);

        }
    }

    @Then("^Remoto-Cargo el audio del \"([^\"]*)\" y obtengo mensaje exitoso$")
    public void Remoto_Cargarelaudiodelyobtengomensajeexitoso(int id) throws Throwable {
        System.out.println("Then Remoto ACA");
        Object[][] parameters_3 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
        String aMessage = parameters_3[id][28].toString();
        String id_string = Integer.toString(id);
        try {
            //VF013ClosingSales.goBandejaAudios();

            //https://tdp-web-venta-fija-qa.mybluemix.net/audiocarga

            Object[][] Parameters_2 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_LOGIN);//loadURL();
            String sURLHome = Parameters_2[15][3].toString();
            String sURLAudio = Parameters_2[16][3].toString();
            BasePage base = new BasePage();
            base.redirigirPage(sURLAudio);

            VF016UpAudioPage.cargarAudio();
            VF016UpAudioPage.validateMessageOK(aMessage, id_string);
            base.redirigirPage(sURLHome);

         //   Hook.generarWordFile(sTester, id);
        } catch (AssertionError e) {
            sError = "ERROR Seleccion Condiciones Migracion y contrato";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);

        }
    }

    @Given("Remoto-Selecciono Operacion Comercial SVA \"([^\"]*)\"")
    public void remotoSeleccionoOperacionComercialSVA(int id) throws Exception, Throwable {
        try {            System.out.println("paso44_id:"+id);

            Sleeper.Sleep(2000);
            Assert.assertTrue(VF003HomePage.validarBtnSVA());
            VF003HomePage.OpCoSVA(id);
            System.out.println("Presencial-Clic en SVA");
        } catch (AssertionError e) {
            sError = "ERROR_Seleccionar_SVA";
            ExceptionHandler.doException(e, sError, false, sTester, id, true, true);

        }
    }

    @And("Remoto-Ingreso datos del cliente que contratara SVA \"([^\"]*)\"")
    public void remotoIngresoDatosDelClienteQueContrataraSVA(int id) throws Exception {
        try {
            Object[][] Parameters_3 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String sTipDoc = Parameters_3[id][1].toString();
            String sNumDoc = Parameters_3[id][2].toString();
            VF004CustomerDataPage.insertDNIClient(sTipDoc, sNumDoc);
            System.out.println("DEFECT3");
            VF004CustomerDataPage.evaluar();
            System.out.println("DEFECT5");
        } catch (AssertionError e) {
            sError = "ERROR definicion ingreso de documento";
            ExceptionHandler.doException(e, sError, false, sTester, id, true, true);
        }
    }

    @And("Remoto-Selecciono producto al que se sumara SVAs \"([^\"]*)\"")
    public void remotoSeleccionoProductoAlQueSeSumaraSVAs(int id) throws Exception {
        try {
            VF006ProductSelectionPage.doClickSeleccionProductoActual();
            VF006ProductSelectionPage.doClicSVA();
            System.out.println("DEFECT6");
        } catch (AssertionError e) {
            sError = "ERROR Fallo definicion ingreso de documento";
            ExceptionHandler.doException(e, sError, false, sTester, id, true, true);
        }
    }

    @And("Remoto-Selecciono SVA del \"([^\"]*)\"")
    public void remotoSeleccionoSVADel(int id) throws Exception, Throwable {
        try {
            System.out.println("DEFECT7");
            Object[][] Parameters_3 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String sbloquefullhd = Parameters_3[id][9].toString();
            String sbloquehbonew = Parameters_3[id][10].toString();
            String sbloquefoxnew = Parameters_3[id][11].toString();
            String sbloquehotpack = Parameters_3[id][12].toString();
            String sbloquegoldenpremier = Parameters_3[id][13].toString();
            String sbloqueestelar = Parameters_3[id][14].toString();
            String spasmarthd = Parameters_3[id][15].toString();
            String srsmartwifi = Parameters_3[id][16].toString();
            String ssvainternet = Parameters_3[id][17].toString();
            String ssvalinea = Parameters_3[id][18].toString();
            String scorreopasmarthd = Parameters_3[id][19].toString();
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
            sError = "ERROR Fallo Seleccion de SVA";
            ExceptionHandler.doException(e, sError, true, sTester, id, true, true);

        }
    }

    @When("Remoto-Acepto las condiciones de venta, resumen de venta y contrato SVA \"([^\"]*)\"")
    public void remotoAceptoLasCondicionesDeVentaResumenDeVentaYContratoSVA(int id) throws Exception {
        try {
            Object[][] Parameters_3 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String sdebitoautomatico = Parameters_3[id][20].toString();
            String scorreodebitoautomatico = Parameters_3[id][19].toString();

            VF008SaleTermsPage.doClickDebitoAutomatico(sdebitoautomatico, scorreodebitoautomatico);
            VF008SaleTermsPage.doClickContinuar();

        } catch (AssertionError e) {
            sError = "ERROR Fallo proceso de aceptacion de condiciones y contrato";
            ExceptionHandler.doException(e, sError, false, sTester, id, true, true);

        }
    }

    @Then("Remoto-Agrego numero de contacto, cierro la venta de SVA e Ir al Menú \"([^\"]*)\"")
    public void remotoAgregoNumeroDeContactoCierroLaVentaDeSVAEIrAlMenú(int id) throws Throwable {
        try {
            VF009SalesSummaryPage.salesSummaryPage();
            Assert.assertTrue(VF010ContractPage.validarBtnContratar());
            VF010ContractPage.doClickContratar();
            //VF013SalesCompletionPage.DoClickMenuPrincipal();
            Object[][] Parameters_3 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String stelefono = Parameters_3[id][26].toString();
            VF012InstallationContactPage.agendarOSoloInsertarTelefono(stelefono);
            VF012InstallationContactPage.doClickFinalizarVenta();
            VF013ClosingSales.doClickIrAlMenu();
            Hook.generarWordFile(sTester, id);
            //hook.closeBrowser(BasePage.handleDriver());
        } catch (AssertionError e) {
            sError = "Fallo cierre de migracion";
            ExceptionHandler.doException(e, sError, false, sTester, id, true, true);

        }
    }

    @Given("Remoto-Selecciono Operacion Comercial Migraciones \"([^\"]*)\"$")
    public void remotoSeleccionoOperacionComercialMigraciones(int id) throws Exception {
        try{
            System.out.println("paso3_id:"+id);
            Object[][] parameters = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();

            Thread.sleep(3000);
            /*Assert.assertTrue( VF003HomePage.validarBtnMigracion());*/
            VF003HomePage.opCoMigraciones(id);
        }catch (AssertionError e){
            sError = "ERROR_Seleccionar_Migracion";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);

        }

    }

    @And("Remoto-Ingreso datos del cliente a migrar \"([^\"]*)\"$")
    public void remotoIngresoDatosDelClienteAMigrar(int id) throws Exception {
        try{
            Object[][] parameters_3 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String sTipDoc = parameters_3[id][1].toString();
            String sNumDoc = parameters_3[id][2].toString();
            VF004CustomerDataPage.insertDNIClient(sTipDoc, sNumDoc);
            VF004CustomerDataPage.evaluar();
        }catch (AssertionError e){
            sError = "ERROR_Fallo Ingreso datos del cliente a migrar ";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);
        }
    }

    @And("Remoto-Selecciono producto del \"([^\"]*)\" a migrar")
    public void remotoSeleccionoProductoDelAMigrar(int id) throws Exception, Throwable {
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
            System.out.println("Aqui");

            VF006ProductSelectionPage.doClickSeleccionProductoActual();
            VF006ProductSelectionPage.doClicMigracion();
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
            System.out.println("boton continuar condiciones");
        } catch (AssertionError e) {
            sError = "ERROR_Eleccion_Producto_Migrar";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);

        }
    }

    @And("Remoto-Acepto las condiciones y Hago la validacion de reniec \"([^\"]*)\"$")
    public void remotoAceptoLasCondicionesYHagoLaValidacionDeReniec(int id) throws Exception {
        try {
            Object[][] parameters_4 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String sdebitoautomatico = parameters_4[id][20].toString();
            String stratamientodatos = parameters_4[id][21].toString();
            String spackverde = parameters_4[id][22].toString();
            String scontrolparental = parameters_4[id][23].toString();
            String scorreodebitoautomatico = parameters_4[id][19].toString();
            String scorreopackverde = parameters_4[id][19].toString();

            VF008SaleTermsPage.doClickDebitoAutomatico(sdebitoautomatico, scorreodebitoautomatico);
            VF008SaleTermsPage.doClickTratamientoDatos(stratamientodatos);
            VF008SaleTermsPage.doClickPackVerde(spackverde, scorreopackverde);
            VF008SaleTermsPage.doClickControlParental(scontrolparental);
            VF008SaleTermsPage.doClickContinuar();


        }catch (AssertionError e){
/*            e.printStackTrace();
            utilitarios.takeScreenshot("ERROR_Seleccion_Condiciones_Migra",BasePage.handleDriver());
            ScreenshotUtility.saveAccion("ERROR_Seleccion_Condiciones_Migra");
            Hook.generarWordFile(sTester, id);
            Object[][] Parameters_2 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_LOGIN);//loadURL();
            String sURL = Parameters_2[15][3].toString();
            BasePage base = new BasePage();
            base.redirigirPage(sURL);
            Assert.fail("Fallo proceso de aceptacion de condiciones y contrato",e);
 */
            sError = "Fallo proceso de aceptacion de condiciones y contrato";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);

        }
        try {
            Object[][] Parameters_3 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String ID_Reniec = Parameters_3[id][25].toString();
            VF011IdentityCheckPage.identityCheck(ID_Reniec);

        }catch (AssertionError e){
            sError = "Fallo validacion de RENIEC del cliente";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);

        }

    }

    @And("Remoto-Resumen de venta y contrato de migraciones \"([^\"]*)\"$")
    public void remotoResumenDeVentaYContratoDeMigraciones(int id) throws Exception {
        try{
            VF009SalesSummaryPage.salesSummaryPage();
            Assert.assertTrue(VF010ContractPage.validarBtnContratar());
            VF010ContractPage.doClickContratar();
        } catch (AssertionError e) {
            sError = "Fallo proceso de venta y contrato de migraciones";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);
        }
    }

    @Then("Remoto-Agrego numero de contacto, cierro la venta de Migracion e Ir al Menú \"([^\"]*)\"$")
    public void remotoAgregoNumeroDeContactoCierroLaVentaDeMigracionEIrAlMenú(int id) throws Throwable {
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
            Hook.generarWordFile(sTester, id);
            //hook.closeBrowser(BasePage.handleDriver());
        }catch (AssertionError e){
            sError = "ERROR_Finalizacion_Cierre_Venta_Migracion";
            ExceptionHandler.doException(e, sError, true, sTester, id, false, false);

        }
    }


}


