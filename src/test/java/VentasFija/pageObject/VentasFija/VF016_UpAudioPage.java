package VentasFija.pageObject.VentasFija;

import VentasFija.helpers.BasePage;
import VentasFija.utility.ScreenshotUtility;
import org.testng.Assert;

import java.io.File;

public class VF016_UpAudioPage extends BasePage {

    public final String btn_seleccionarArchivo = "//*[@id=\"file-1\"]";
    public final String btn_subir = "|id|subirAudioVisible";
    public final String btn_subirout= "//*[@id=\"data\"]/audioout/div/div/div/div[21]/div/div[2]/div/label";
    public final String lbl_messageOK = "//td[contains(text(),'Archivo de audio fue cargado correctamente')]";


    public void cambiarNombreArchivo(String oCodVenta) throws Exception {
        String evidencePath = "./src/test/resources/audio/";
        try {
            String nombre = ScreenshotUtility.getName(evidencePath);
            System.out.println("Archivo original: " + nombre);
            File oldfile = new File("./src/test/resources/audio/" + nombre);
            File newfile = new File("./src/test/resources/audio/" + oCodVenta + ".gsm");
            if (oldfile.renameTo(newfile)) {
                System.out.println("Archivo renombrado");
            } else {
                System.out.println("Error al cambiar nombre de audio");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("ERROR en cambiarNombreArchivo", e);
        }
    }

    public void cargarAudio() {
        String evidencePath = "./src/test/resources/audio/";
        try {
            Thread.sleep(5000);
            String nameFile = ScreenshotUtility.getName(evidencePath);
            System.out.println("Nombre de archivo: " + nameFile);
            upFile(btn_seleccionarArchivo,nameFile);
            System.out.println("Archivo cargado exitosamente");
            Thread.sleep(4000);
            doclickByJS("Click en subir",btn_subir, true);
            Thread.sleep(4000);
            jsScrollIntoView("Mensaje de confirmacion",lbl_messageOK,true);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("ERROR en cargarAudio", e);
        }
    }

    public void cargarAudioOut() {
        String evidencePath = "./src/test/resources/audio/";
        try {
            Thread.sleep(5000);
            String nameFile = ScreenshotUtility.getName(evidencePath);
            System.out.println("Nombre de archivo: " + nameFile);
            upFile(btn_subirout,nameFile);
            System.out.println("Archivo cargado exitosamente");
            Thread.sleep(4000);
            doclickByJS("Click en subir",btn_subir, true);
            Thread.sleep(4000);
            jsScrollIntoView("Mensaje de confirmacion",lbl_messageOK,true);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("ERROR en cargarAudio", e);
        }
    }

    public boolean validateMessageOK(String message, String id) {
        boolean respuesta = false;
        try {
            respuesta = verifyText(message, lbl_messageOK, id, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    public void validarVenta(){

    }
}
