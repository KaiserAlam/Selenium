package com.avalanche;
import com.page.SeleniumHQ;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.ArrayList;
import java.util.List;

@Test
public class SeleniumHQTest {

    private static final Logger logger = LoggerFactory.getLogger(SeleniumHQTest.class);
    private WebDriver driver = null;
    private SeleniumHQ seleniumHQ = null;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.driver.chrome", System.getProperty("user.name")+"\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=800, 480");
        driver = new ChromeDriver(options);
    }

    @Test
    @Parameters({"browser"})
    public void verifySeleniumHQPageTitle(){
        seleniumHQ = new SeleniumHQ(driver);
        logger.info("Verify SeleniumHQ page title");
        Assert.assertEquals(seleniumHQ.getPageTitle(driver), "Selenium - Web Browser Automation");
    }

    @Test
    @Parameters({"browser"})
    public void verifyHeaderItemsOnSeleniumHQPage(){
        List<String> expectedItem = new ArrayList<>();
        expectedItem.add("About");
        expectedItem.add("Support");
        expectedItem.add("Documentation");
        expectedItem.add("Download");
        expectedItem.add("Projects");

        seleniumHQ = new SeleniumHQ(driver);
        List<String> actualHeaderItems = seleniumHQ.getHeaderItemList(driver);
        logger.info("Verify item contains in Header");
        Assert.assertEquals(actualHeaderItems, expectedItem);
    }

    @Test
    @Parameters({"browser"})
    public void verifyProjectPage(){
        seleniumHQ = new SeleniumHQ(driver);
        Assert.assertEquals(seleniumHQ.getPage(driver), "Selenium Projects");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
