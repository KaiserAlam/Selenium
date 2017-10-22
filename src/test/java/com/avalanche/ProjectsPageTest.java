package com.avalanche;

import com.page.ProjectsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ProjectsPageTest {

    private static final Logger logger = LoggerFactory.getLogger(SeleniumHQTest.class);
    private WebDriver driver = null;
    private ProjectsPage projectPage = null;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.driver.chrome", System.getProperty("user.name")+"\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=800, 480");
        driver = new ChromeDriver(options);
    }

    @Test
    @Parameters({"browser"})
    public void verifyProjectsListOnProjectPage(){
        projectPage = new ProjectsPage(driver);
        logger.info("Verify page title");
        Assert.assertEquals(projectPage.getPageTitle(), "Selenium Projects");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
