package TestBase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClassForTests {
    public Logger logger;
    public Properties properties;
    public WebDriver driver;

    @BeforeClass
    @Parameters ({"os", "browser"})
    public void setup(String os, String browser) throws IOException {
        logger = LogManager.getLogger(this.getClass());

        // loading properties from config file
        FileReader file = new FileReader("./src/test/resources/config.properties");
        properties = new Properties();
        properties.load(file);


        switch (browser) {
            case "chrome": driver = new ChromeDriver(); break;
            case "firefox": driver = new FirefoxDriver(); break;
            case "edge": driver = new EdgeDriver(); break;
            default: System.out.println("The browser mentioned is not supported"); return;
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        driver.quit();
    }
}
