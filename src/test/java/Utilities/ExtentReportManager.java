package Utilities;

import TestBase.BaseClassForTests;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager implements ITestListener {
    ExtentSparkReporter sparkReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;
    String reportPath;
    String reportName;

    public void onStart(ITestContext context) {
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        reportName = MessageFormat.format("TestReport_{0}.html", timestamp);
        reportPath = MessageFormat.format("{0}\\reports\\{1}", System.getProperty("user.dir"), reportName);

        sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setDocumentTitle("Opencart Automation Report");
        sparkReporter.config().setReportName("Opencart Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Application", "Opencart");
        extentReports.setSystemInfo("Module", "Admin");
        extentReports.setSystemInfo("Sub Module", "Customers");
        extentReports.setSystemInfo("User Name", System.getProperty("user.name"));
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("OS", context.getCurrentXmlTest().getParameter("os"));
        extentReports.setSystemInfo("Browser", context.getCurrentXmlTest().getParameter("browser"));
        extentReports.setSystemInfo("Groups", context.getCurrentXmlTest().getIncludedGroups().toString());

    }

    public void onTestSuccess(ITestResult result) {
        extentTest = extentReports.createTest(result.getTestClass().getName());
        extentTest.assignCategory(result.getMethod().getGroups());
        extentTest.log(Status.PASS, MessageFormat.format("{0} is executed successfully", result.getName()));
    }

    public void onTestFailure(ITestResult result) {
        extentTest = extentReports.createTest(result.getTestClass().getName());
        extentTest.assignCategory(result.getMethod().getGroups());

        extentTest.log(Status.FAIL, MessageFormat.format("{0} is failed", result.getName()));
        extentTest.log(Status.INFO, result.getThrowable().getMessage());

        try {
            String imgPath = new BaseClassForTests().captureScreenshot(result.getName());
            extentTest.addScreenCaptureFromPath(imgPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        extentTest = extentReports.createTest(result.getTestClass().getName());
        extentTest.assignCategory(result.getMethod().getGroups());

        extentTest.log(Status.SKIP, MessageFormat.format("{0} is skipped", result.getName()));
        extentTest.log(Status.INFO, result.getThrowable().getMessage());
    }

    public void onFinish(ITestContext context) {
        extentReports.flush();

        File file = new File(MessageFormat.format("{0}\\reports\\{1}", System.getProperty("user.dir"), reportName));

        try {
            Desktop.getDesktop().browse(file.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
