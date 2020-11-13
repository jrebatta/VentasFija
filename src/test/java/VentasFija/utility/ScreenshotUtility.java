package VentasFija.utility;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;

public class ScreenshotUtility {
    public static int i=1;
    public static int contador;
    public static ArrayList<String> acciones = new ArrayList<String>();
    public static List<String> listaEscenario = new ArrayList<String>();
    public static int contadorImagenes = 0;
    public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    public static void takeScreenshot(String UIName, WebDriver driver) throws IOException, AWTException {
        int val = 1;
        if (contador > 1) {
            val = contador;
        }
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        Formatter fmt = new Formatter();
        if (val > 0 && val < 10) {
            fmt.format("%02d", val);
            ImageIO.write(image, "png", new File("./results/screenshot/" + fmt + ". " + UIName + " " + timestamp() + ".png"));
            ImageIO.write(image, "png", new File("./results/screenshot2/" + fmt + ". " + UIName + " " + timestamp() + ".png"));

            contador = val + 1;
        } else {
            ImageIO.write(image, "png", new File("./results/screenshot/" + val + ". " + UIName + " " + timestamp() + ".png"));
            ImageIO.write(image, "png", new File("./results/screenshot2/" + val + ". " + UIName + " " + timestamp() + ".png"));
            contador = val + 1;
        }
    }

    public static void doScreenShot(String UIName, WebDriver driver) throws IOException, AWTException {
         takeScreenshot(UIName,driver);
         saveAccion(UIName);
         i=i++;
        System.out.println("doScreenShot()_i:"+i);
        System.out.println("doScreenShot()_UIName:"+i+":"+UIName);
}

    public static String getScreenshot(String UIName, WebDriver driver) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir") + "./results/screenshot/screenshot_" + UIName + timestamp() + ".png";
        File destination = new File(path);

        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            System.out.println("Capture failed" + e.getMessage());
        }

        return path;
    }


  	public static List<String> saveScenario(String sEscenario) {
        listaEscenario.add(sEscenario);
        //      System.out.println("Acciones: " + acciones);
        //     System.out.println(acciones.size());
        return listaEscenario;
    }

    public static ArrayList<String> saveAccion(String UIName) {

        acciones.add(UIName);
        contadorImagenes = acciones.size();
        int i;
        for ( i=0; i>=acciones.size(); i++){
            System.out.println("accionesCONTADOR:"+i+":"+acciones.get(i));
            i++;
        }
        System.out.println("accionesContent:"+acciones);
        System.out.println("accionesSize:"+acciones.size());
        return acciones;
    }

    public static List<String> listScreenshot(String sCarpAct) {
        File carpeta = new File(sCarpAct);
        List<String> lista = new ArrayList<>();
       // lista = null;
        String[] listado = carpeta.list();
        System.out.println("Archivos1: " + lista);
        System.out.println("Listado1: " + listado);
        for (String File : listado) {
            lista.add(File.toString());
        }
        Collections.sort(lista);
        System.out.println("Archivos: " + lista);
        return lista;
    }
    public static void cleanScreenshot(String sCarpAct) throws IOException, InterruptedException {
        File carpeta = new File(sCarpAct);
        for (File file : carpeta.listFiles()) {
            if (!file.isDirectory())
                file.delete();
        }

        System.out.println("Inicio Carga del Site");
    }
    public static void cleanScreenshot2(String sCarpAct, List<String> listScreen) {
        File carpeta = new File(sCarpAct);
        for (File file : carpeta.listFiles()) {
            if (!file.isDirectory())
                file.delete();
        }
        System.out.println("Inicio Carga del Site");
    }

    public static String getName(String sCarpAct) {
        File carpeta = new File(sCarpAct);
        String nombre = null;
        for (File file : carpeta.listFiles()) {
            if (!file.isDirectory())
                nombre = file.getName();
        }
        System.out.println(nombre);
        return nombre;
    }
}
