package VentasFija.helpers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Karthik on 21/09/2019.
 */


public class ExtentReportUtil extends BasePage {

    String fileName = reportLocation + "extentreport_" + getcurrentdateandtime() + ".html";
    String screenshotname;

    public void ExtentReport() {
        //First is to create Extent Reports
        extent = new ExtentReports();

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("Test report for Selenium Basic");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Test report");

        extent.attachReporter(htmlReporter);

    }

    public void ExtentReportScreenshot() throws IOException {

        File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        screenshotname = "screenshot_" + getcurrentdateandtime() + ".png";
        Files.copy(scr.toPath(), new File(reportLocation + screenshotname).toPath());
        scenarioDef.fail("details").addScreenCaptureFromPath(reportLocation + screenshotname);

        System.out.println("Screenshot");

    }

    public String captureScreenShot(WebDriver driver) throws IOException {
        TakesScreenshot screen = (TakesScreenshot) driver;
        File src = screen.getScreenshotAs(OutputType.FILE);
        String dest = reportLocation + screenshotname;
        File target = new File(dest);
        Files.copy(src.toPath(), new File(reportLocation + screenshotname).toPath());
        return dest;
    }

    private static String getcurrentdateandtime() {
        String str = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
            Date date = new Date();
            str = dateFormat.format(date);
            str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
        } catch (Exception e) {
        }
        return str;
    }

    public void FlushReport(){
        extent.flush();
    }




}
