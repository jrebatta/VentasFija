package VentasFija.pageObject.PuertoBiomatch;

import VentasFija.helpers.BasePage;
import org.testng.Assert;

import java.awt.*;
import java.io.IOException;

public class PB001_LocalHost extends BasePage {

    public final String btn_configuracionavanzada = "|id|details-button";
    //public final String btn_configuracionavanzada = "//*[@id=\"details-button\"]";
    public final String btn_accederlocalhost = "|id|proceed-link";
    //public final String btn_accederlocalhost = "//*[@id=\"proceed-link\"]";

    public void DoClicPuertoBiomatch () throws AWTException, IOException {
        try {
            doClick("Click en Configuración Avanzada",btn_configuracionavanzada,false);
            doClick("Click en Acceder al Local Host",btn_accederlocalhost,false);
        } catch (AssertionError e) {
            e.getMessage();
            e.getStackTrace();
            e.printStackTrace();
            Assert.fail("Fallo Puerto Biomatch",e);
        }
    }
}
