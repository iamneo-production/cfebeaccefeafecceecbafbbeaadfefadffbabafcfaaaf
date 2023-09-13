package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporter {
    // Default report name
    private static final String DEFAULT_REPORT_NAME = "";

    public static ExtentReports generateExtentReport() {
        return generateExtentReport(DEFAULT_REPORT_NAME);
    }

    public static ExtentReports generateExtentReport(String reportName) {
        ExtentReports extentReport = new ExtentReports();
        PropsLoader propsLoader = PropsLoader.getInstance("/src/main/java/config.properties");

        // Create the report directory if it doesn't exist
        String reportDirPath = System.getProperty("user.dir") + "/src/main/reports/";
        File reportDir = new File(reportDirPath);
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }

        // Add timestamp to the report file name
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = dateFormat.format(new Date());
        File extentReportFile = new File(reportDirPath + reportName + "_" + timestamp + ".html");
        // File extentReportFile = new File(reportDirPath + reportName + ".html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);

        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("Gillette Test Report");
        sparkReporter.config().setDocumentTitle("Gillette Automation Automation Report");
        sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");

        extentReport.attachReporter(sparkReporter);

        extentReport.setSystemInfo("Application URL", propsLoader.getProperty("url"));
        extentReport.setSystemInfo("Browser Name", propsLoader.getProperty("browserName"));
        extentReport.setSystemInfo("Email", propsLoader.getProperty("validEmail"));
        extentReport.setSystemInfo("Password", propsLoader.getProperty("validPassword"));
        extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
        extentReport.setSystemInfo("Username", System.getProperty("user.name"));
        extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));

        return extentReport;
    }
}
