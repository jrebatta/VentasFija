package VentasFija.utility;

import VentasFija.helpers.Hook;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class WordUtils {

    public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }
   // public static int val = 0;
public static    int val1=0;
    public static    int contadorItems=0;
    public static int index=0;



    public static void createDoc(List<String> listScreen, String testername,int id) throws Exception {
        try {
            // Blank Document
            XWPFDocument document = new XWPFDocument();
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            XWPFParagraph paragraph2 = document.createParagraph();
            XWPFRun run2 = paragraph.createRun();
            // Path to Word
            String evidencePath = "./results/";
            int format = XWPFDocument.PICTURE_TYPE_PNG;
            System.out.println("Documento en blanco");
/*          Insert Title of the Scenario
            run.setText();
  */
            run.setText("Información general:");
            run.setBold(true);
            run.setFontSize(14);
            run.addBreak();
            run.addBreak();
            run.addTab();
            run.setText("Feature:  "+Hook.sFeatureName);
            run.setBold(false);
            run.setFontSize(12);
            run.addBreak();
            run.addBreak();
          //  run.addTab();
            //  run.setText("Registro Nro:  "+id);
            // run.setBold(false);
            //run.setFontSize(12);
            //run.addBreak();
            //run.addBreak();
            // Insert screenshoots
            int val = 0;
            System.out.println("contadorLIST_acciones:"+ScreenshotUtility.acciones.size());
            System.out.println("WordUtils_listScreen:"+listScreen);
            System.out.println("WordUtils_acciones:"+ScreenshotUtility.acciones);

            System.out.println("WordUtils_val_ANTES:"+val1);
            contadorItems=ScreenshotUtility.acciones.size()-index;
            index=ScreenshotUtility.acciones.size();
            System.out.println("WordUtils_contadorItems:"+contadorItems);
            System.out.println("WordUtils_index:"+contadorItems);


            for (String file : listScreen) {
                String imgFile = "./results/screenshot/" + file;
                System.out.println("ValREview:"+val);
                run.setText(val + 1 + ". " + ScreenshotUtility.acciones.get(val) + ":");
                run.setBold(false);

                val++;
                run.addBreak();
                run.addBreak();
                run.addPicture(new FileInputStream(imgFile), format, imgFile, Units.toEMU(420), Units.toEMU(230));
                run.addBreak();
                run.addBreak();
            }

            // Insert Header
            CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
            XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(document, sectPr);

            XWPFHeader header = headerFooterPolicy.createHeader(XWPFHeaderFooterPolicy.DEFAULT);

            paragraph = header.createParagraph();
            paragraph.setAlignment(ParagraphAlignment.CENTER);

            CTTabStop tabStop = paragraph.getCTP().getPPr().addNewTabs().addNewTab();
            tabStop.setVal(STTabJc.CENTER);
            int twipsPerInch = 1440;
            tabStop.setPos(BigInteger.valueOf(6 * twipsPerInch));

            run = paragraph.createRun();
            run.setText("SUSTENTO DE PRUEBAS TESTING - PROCESOS DE VENTA");
            run.setBold(true);
            run.setFontSize(14);
            run.setTextPosition(100);
            run.addTab();
            //run.addBreak();


     /*      run.setText(escenario);
            run.setBold(true);
            run.setFontSize(12);
            run.setTextPosition(100);
*/
            //run = paragraph.createRun();
            String imgLogo = "./src/test/resources/logo/Logo_wipro.jpg";
            run.addPicture(new FileInputStream(imgLogo), XWPFDocument.PICTURE_TYPE_PNG, imgLogo, Units.toEMU(30), Units.toEMU(30));

            // Insert Footer
            CTP ctp = CTP.Factory.newInstance();
            CTText t = ctp.addNewR().addNewT();
            System.out.println("Tester:"+ testername);
            t.setStringValue("Tester:"+ testername);
            XWPFParagraph pars[] = new XWPFParagraph[1];
            pars[0] = new XWPFParagraph(ctp, document);
            XWPFHeaderFooterPolicy hfp = document.createHeaderFooterPolicy();
            hfp.createFooter(XWPFHeaderFooterPolicy.DEFAULT, pars);

            // Write the Document in file system
            FileOutputStream out = new FileOutputStream(new File(evidencePath + Hook.sFeatureName + " "+timestamp() + ".doc"));
            document.write(out);
            out.close();

            // Imprimir confirmacion de Word generado en consola
            System.out.println("Documento Word creado satisfactoriamente!:"+Hook.sFeatureName);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    //OLD method
    public static void createDoc2(String escenario, String testCaseName, List<String> listScreen, String testername,int id) throws Exception {
        try {
            // Blank Document
            XWPFDocument document = new XWPFDocument();
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            XWPFParagraph paragraph2 = document.createParagraph();
         //   XWPFRun run2 = paragraph.createRun();
            // Path to Word
            String evidencePath = "./results/";
            int format = XWPFDocument.PICTURE_TYPE_PNG;
            System.out.println("Documento en blanco");

/*          Insert Title of the Scenario
            run.setText();

  */
            run.setText("Información general:");
            run.setBold(true);
            run.setFontSize(14);
            run.addBreak();
            run.addBreak();
            run.addTab();
            run.setText("Escenario:  "+escenario);
            run.setBold(false);
            run.setFontSize(12);
            run.addBreak();
            run.addBreak();
            run.addTab();
            run.setText("Registro Nro:  "+id);
            run.setBold(false);
            run.setFontSize(12);
            run.addBreak();
            run.addBreak();
            // Insert screenshoots

            System.out.println("contadorLIST_acciones:"+ScreenshotUtility.acciones.size());
            System.out.println("WordUtils_listScreen:"+listScreen);
            System.out.println("WordUtils_val_ANTES:"+val1);
//            for (String file : listScreen) {
            contadorItems=ScreenshotUtility.acciones.size()-index;
            index=ScreenshotUtility.acciones.size();
            System.out.println("contadorItems:"+contadorItems);
            for (int val = val1; val < contadorItems; val++) {
                //String imgFile = "./results/screenshot/" + file;
                System.out.println("WordUtils_val_En el forANTES:"+val);
                System.out.println("WordUtils_val_En el forval1ANTES:"+val1);

                String imgFile = "./results/screenshot/" + listScreen.get(val);
                System.out.println("textoVALnum:"+val + 1);

                System.out.println("texto:"+val + 1 + ". " + ScreenshotUtility.acciones.get(val) + ":");

                run.setText(val + 1 + ". " + ScreenshotUtility.acciones.get(val) + ":");
                run.setBold(false);

                run.addBreak();
                run.addBreak();
                run.addPicture(new FileInputStream(imgFile), format, imgFile, Units.toEMU(420), Units.toEMU(230));
                run.addBreak();
                run.addBreak();
                //val1=val;
                val1++;

                System.out.println("WordUtils_val_En el for:"+val);
                System.out.println("WordUtils_val_En el forval1:"+val1);
            }
           // val1++;

//           System.out.println("WordUtils_val_DESPUES:"+val);

            System.out.println("WordUtils_val_DESPUES:"+val1);



            // Insert Header
            CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
            XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(document, sectPr);
            XWPFHeader header = headerFooterPolicy.createHeader(XWPFHeaderFooterPolicy.DEFAULT);
            paragraph = header.createParagraph();
            paragraph.setAlignment(ParagraphAlignment.CENTER);

            CTTabStop tabStop = paragraph.getCTP().getPPr().addNewTabs().addNewTab();
            tabStop.setVal(STTabJc.CENTER);
            int twipsPerInch = 1440;
            tabStop.setPos(BigInteger.valueOf(6 * twipsPerInch));

            run = paragraph.createRun();
            run.setText("SUSTENTO DE PRUEBAS TESTING - PROCESOS DE VENTA");
            run.setBold(true);
            run.setFontSize(14);
            run.setTextPosition(100);
            run.addTab();
            //run.addBreak();


            //run = paragraph.createRun();
            String imgLogo = "./src/test/resources/logo/Logo_wipro.jpg";
            run.addPicture(new FileInputStream(imgLogo), XWPFDocument.PICTURE_TYPE_PNG, imgLogo, Units.toEMU(30), Units.toEMU(30));

            // Insert Footer
            CTP ctp = CTP.Factory.newInstance();
            CTText t = ctp.addNewR().addNewT();
            System.out.println("testerworkd:"+ testername);
            t.setStringValue("Tester:"+ testername);
            XWPFParagraph pars[] = new XWPFParagraph[1];
            pars[0] = new XWPFParagraph(ctp, document);
            XWPFHeaderFooterPolicy hfp = document.createHeaderFooterPolicy();
            hfp.createFooter(XWPFHeaderFooterPolicy.DEFAULT, pars);

            // Write the Document in file system
            FileOutputStream out = new FileOutputStream(new File(evidencePath + testCaseName + " "+"Registro_"+id+" "+timestamp() + ".doc"));
            
            document.write(out);
            out.close();
           // listScreen.clear();
            //val = 0;
            //val=val-1;
            //val++;
            // Print a confirmation image to console
            System.out.println("Documento Word creado satisfactoriamente!_val1:"+val1);
       //         ScreenshotUtility.acciones.clear();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
