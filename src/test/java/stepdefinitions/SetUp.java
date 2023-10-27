package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class SetUp {


        public static WebDriver driver = null;
        public  static  WebDriverWait wait = null;

        // Windows Browser set up file
        @Before
        public void setUp() throws Exception {

            System.setProperty("BROWSER", "chrome");
            System.setProperty("PLATFORM", "desktop");
            System.setProperty("ENV", "PPE");

            String browser = System.getProperty("BROWSER");



            if (browser.equals("chrome")) {
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions options = new ChromeOptions();
                        // disable ephemeral flash permissions flag
                        options.addArguments("disable-infobars");
                        options.addArguments("--incognito");
                        driver = new ChromeDriver();
                    }

            if (browser.equals("firefox")) {
                driver = new FirefoxDriver();
            }
                    wait = new WebDriverWait(driver, 180);
                    driver.manage().window().maximize();
                    driver.get("http://localhost:3000/");

                }
        @After
        public void tearDown(Scenario scenario) throws Exception {
            if (scenario.isFailed())
            {

                try {
                    TakesScreenshot scrShot = ((TakesScreenshot) driver);
                    File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
                    File DestFile = new File("/target/screenshots" + ".png");
                    FileUtils.copyFile(SrcFile, DestFile);
                }
                catch(Exception e){
                    System.out.println("exception");
                }

                    }
            driver.close();
            driver.quit();
            }


    }

