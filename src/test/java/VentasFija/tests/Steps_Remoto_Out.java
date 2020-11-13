package VentasFija.tests;

import VentasFija.exceptions.ExceptionHandler;
import VentasFija.helpers.BasePage;
import VentasFija.helpers.Hook;
import VentasFija.utility.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import VentasFija.pageObject.VentasFija.*;
import VentasFija.pageObject.WebAdmin.*;
import VentasFija.pageObject.PuertoBiomatch.PB001_LocalHost;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.io.IOException;

public class Steps_Remoto_Out {
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
    private static final String exel = "java/resources/data/TestData.xlsx";
    private static final String login = "Login";
    String sTester;

    /***
     *
     * Funciones para acceder al excel
     * y obtener los datos para las pruebas
     *
     *//*
    public Object[][] getBDconecctions() throws Exception { //            Object[][] parameters_1 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.DATAFILE_HOJA_CONEXIONES);//getBDconecctions();
        Object[][] testObjArray = null;
        testObjArray = ExcelUtils.getTableArray("./src/test/resources/data/TestData.xlsx", "Conexiones");
        return (testObjArray);
    }

    public Object[][] loadURL() throws Exception {
        Object[][] testObjArray = null;
        testObjArray = ExcelUtils.getTableArray("./src/test/resources/data/TestData.xlsx", "Login");
        return (testObjArray);
    }

    public Object[][] getClient() throws Exception {
        Object[][] testObjArray = null;
        testObjArray = ExcelUtils.getTableArray("./src/test/resources/data/TestData.xlsx", "Clients");
        return (testObjArray);
    }*/

    @And("Remoto Out-Seleccionar y evaluar tipo de documento \"([^\"]*)\"")
    public void remotoOutSeleccionarYEvaluarTipoDeDocumento(int id) throws Throwable {
        try {

            Object[][] parameters_3 =  ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String sTipDoc = parameters_3[id][1].toString();
            String sNumDoc = parameters_3[id][2].toString();

            sTester = parameters_3[id][9].toString();

            VF004CustomerDataPage.insertDNIClient(sTipDoc, sNumDoc);
            System.out.println("DEFECT3");
            Thread.sleep(3000);
            VF004CustomerDataPage.evaluar();
            System.out.println("DEFECT4");
        } catch (AssertionError e) {
            sError = "ERROR_Fallo seleccionar y evaluar tipo de documento";
            ExceptionHandler.doException(e, sError, true, sTester, id, true, true);
        }
    }


    @And("Remoto Out-Ingreso de direccion y referencia \"([^\"]*)\", ubicar en mapa y Continuar")
    public void remotoOutIngresoDeDireccionYReferenciaUbicarEnMapaYContinuar(int id) throws Throwable {
        try {
            System.out.println("Inicio de Llamado a Parametros de dirección y referencia");
            Object[][] parameters_3 =  ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String sdireccion = parameters_3[id][6].toString();
            String sreferencia = parameters_3[id][7].toString();
            System.out.println("Fin de Llamado a Parametros");
            VF005InstallationSitePage.fijarDireccionMapa(sdireccion, sreferencia);
            System.out.println("Direccion y Referencia ingresada");
            Assert.assertTrue(VF005InstallationSitePage.validar_BtnContinuar());
            VF005InstallationSitePage.continuar();
            System.out.println("Continuar");
        } catch (AssertionError e) {
            sError = "ERROR_Fallo registro de datos de instalacion";
            ExceptionHandler.doException(e, sError, false, sTester, id, true, true);
        }
/*        Sleeper.Sleep(2000);
        VF009SalesSummaryPage.SalesSummaryPage();*/
    }

    @Given("Remoto Out-Selecciono Operacion Comercial Alta Nueva \"([^\"]*)\"")
    public void remotoOutSeleccionoOperacionComercialAltaNueva(int id) throws Throwable {
        try {
            System.out.println("paso2:"+id);
            Object[][] parameters1 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_LOGIN);//loadURL();
            sTester = parameters1[id][9].toString();
            Sleeper.Sleep(15000);
            //Assert.assertTrue(VF003HomePage.validarBtnAlta());
            VF003HomePage.opCoAltaNueva(id);
            System.out.println("DEFECT2");
        } catch (AssertionError e) {
            sError = "ERROR_Fallo alta nueva";
            ExceptionHandler.doException(e, sError, true, sTester, id, true, true);

        }
    }
    @And("Remoto Out-Seleccionar Tipo de Doc, Ingresar Documento, Ingresar Departamento, Provincia y Distrito de Instalación \"([^\"]*)\", clic en Evaluar y clic en Continuar")
    public void remotoOutSeleccionarTipoDeDocIngresarDocumentoIngresarDepartamentoProvinciaYDistritoDeInstalaciónClicEnEvaluarYClicEnContinuar(int id) throws Throwable {
        try {
            Object[][] parameters_3 =  ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
            String sTipDoc          = parameters_3[id][1].toString();
            String sNumDoc          = parameters_3[id][2].toString();
            String sdepartamento    = parameters_3[id][3].toString();
            String sprovincia       = parameters_3[id][4].toString();
            String sdistrito        = parameters_3[id][5].toString();

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
            sError = "ERROR_Fallo ingreso datos";
            ExceptionHandler.doException(e, sError, false, sTester, id, true, true);

        }
    }

    @And("Remoto Out-Selecciono la campania \"([^\"]*)\"")
    public void remotoOutSeleccionoLaCampania(int id) throws Throwable {
        try {
            System.out.println("Inicio de Llamado a Parametros de campaña");
            Object[][] Parameters_3 =  ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
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
            ExceptionHandler.doException(e, sError, false, sTester, id, true, true);
        }
    }

    @And("Remoto Out-Selecciono el producto del \"([^\"]*)\" a contratar Alta")
    public void remotoOutSeleccionoElProductoDelAContratarAlta(int id) throws Throwable {
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
            ExceptionHandler.doException(e, sError, false, sTester, id, true, true);
        }
    }

    @When("Remoto Out-Acepto las condiciones de venta, resumen de venta y contrato Alta \"([^\"]*)\"")
    public void remotoOutAceptoLasCondicionesDeVentaResumenDeVentaYContratoAlta(int id) throws Throwable {
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

            VF017SaleTermsPageOut.doClickDebitoAutomatico(sdebitoautomatico, scorreodebitoautomatico);
            VF017SaleTermsPageOut.doClickTratamientoDatos(stratamientodatos);
            VF017SaleTermsPageOut.doClickPackVerde(spackverde, scorreopackverde);
            VF017SaleTermsPageOut.doClickControlParental(scontrolparental);
            VF017SaleTermsPageOut.doClickContinuar();

        } catch (AssertionError e) {
            sError = "ERROR_Fallo proceso de condiciones de venta y contrato";
            ExceptionHandler.doException(e, sError, false, sTester, id, true, true);
        }
    }
    @And("Remoto Out-Valido la identidad del cliente \"([^\"]*)\"")
    public void remotoOutValidoLaIdentidadDelCliente(int id) throws Exception, Throwable {
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
            sError = "ERROR_Fallo validacion de identidad";
            ExceptionHandler.doException(e, sError, false, sTester, id, true, true);
        }
    }




    @And("Remoto Out-Acepto resumen de venta, contrato Alta, Agrego numero de contacto, cierro la venta de Alta e Ir al Menú \"([^\"]*)\"")
    public void remotoOutAceptoResumenDeVentaContratoAltaAgregoNumeroDeContactoCierroLaVentaDeAltaEIrAlMenú(int id) throws Throwable {
        try {
            VF009SalesSummaryPage.salesSummaryPage();
            Assert.assertTrue(VF010ContractPage.validarBtnContratar());
            VF010ContractPage.doClickContratar();
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
            ExcelReader.writeCellValue(exel,login,18,5,"-"+oCodVenta);
            System.out.println("COD_VENTA_GUARDADO");
            //Assert.assertTrue(VF012InstallationContactPage.validarBtnFinalizar());
            System.out.println("STEP13");

            Thread.sleep(100);
            //VF013SalesCompletionPage.DoClickMenuPrincipal();
            VF013ClosingSales.doClickIrAlMenu();
            System.out.println("STEP14");
            //hook.closeBrowser(BasePage.handleDriver());
        } catch (AssertionError e) {
            sError = "ERROR_Finalizacion_Contrato_Remoto Out";
            ExceptionHandler.doException(e, sError, false, sTester, id, true, true);
        }
    }


    @Then("Remoto Out-Valido y Cargo el audio del \"([^\"]*)\" y obtengo mensaje exitoso")
    public void remotoOutValidoYCargoElAudioDelYObtengoMensajeExitoso(int id) throws Throwable {
        Object[][] parameters_3 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_CLIENTES);//getClient();
        String aMessage = parameters_3[id][28].toString();
        String id_string = Integer.toString(id);
        try {
            //VF013ClosingSales.goBandejaAudios();

            //https://tdp-web-venta-fija-qa.mybluemix.net/audiocarga


            Object[][] parameters_2 = ExcelUtils.getTableArray(GlobalVariable.DATAFILE_PATH, GlobalVariable.HOJA_LOGIN);//loadURL();
            String sURLHome = parameters_2[15][3].toString();
            String sURLAudio = parameters_2[17][3].toString();
            String codVenta = parameters_2[17][5].toString();
            BasePage base = new BasePage();
            base.redirigirPage(sURLAudio);

            driver.findElement(By.xpath("/html/body/my-app/main/audioout/div/div/div/div[21]/div/div[2]/div/div/div/div")).click();

            scrollBar();Sleeper.Sleep(1000);
            driver.findElement(By.xpath("/html/body/my-app/main/audiooutdetalle/div/div/div/div/div[3]/div/div[1]/div/a")).click();
            Alert myAlert = new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
            myAlert.accept();
            Sleeper.Sleep(1500);scrollBar();scrollBar();


            VF016UpAudioPage.cargarAudio();
            VF016UpAudioPage.validateMessageOK(aMessage, id_string);
            //hook.closeBrowser(basepage.handleDriver());
            base.redirigirPage(sURLHome);

            Hook.generarWordFile(sTester, id);
        } catch (AssertionError e) {
            sError = "ERROR_Carga de Audio";
            ExceptionHandler.doException(e, sError, false, sTester, id, true, true);
        }
    }

    protected void scrollBar() {
        JavascriptExecutor ev = (JavascriptExecutor) driver;
        ev.executeScript("window.scrollBy(0, 720)");
    }

}
