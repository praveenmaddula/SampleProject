package com.planit.qa.baseTest;

import com.planit.qa.pages.HomePage;
import com.planit.qa.pages.ResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private Properties properties;
    public WebDriver driver;

    protected HomePage homePage;
    protected ResultsPage resultsPage;

    public BaseTest() {

        properties = new Properties();
        try {
            properties.load(new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/planit/qa/base/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void settUp() {

        launchBrowser();

        driver.navigate().to(properties.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

    }

    private void launchBrowser() {

        String browserType = properties.getProperty("browser");
        String userDir = System.getProperty("user.dir");
         switch (browserType) {

             case "chrome" :
                 System.setProperty("webdriver.chrome.driver", userDir + "/src/test/resources/chromedriver.exe");
                 driver = new ChromeDriver();
                 break;

             case "firefox" :
                 System.setProperty("webdriver.gecko.driver", userDir + "/src/test/resources/geckodriver.exe");
                 driver = new FirefoxDriver();
                 break;

             default :
                 System.setProperty("webdriver.gecko.driver", userDir + "/src/test/java/resources/geckodriver.exe");
                 driver = new FirefoxDriver();
                 break;
         }
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();

    }

}
