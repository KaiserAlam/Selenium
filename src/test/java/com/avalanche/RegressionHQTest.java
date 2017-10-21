package com.avalanche;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.ArrayList;
import java.util.List;

@Test
public class RegressionHQTest extends SeleniumHQ {

    private static final Logger logger = LoggerFactory.getLogger(RegressionHQTest.class);
    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.driver.chrome", System.getProperty("user.name")+"\\chromedriver.exe");
    }

    @Test(invocationCount = 1)
    @Parameters({"browser"})
    public void navigateTo() {
        driver.get(getURL());
        logger.info("Page Loading ...");
        Assert.assertEquals(driver.getTitle(), "Selenium - Web Browser Automation");
    }

    @Test(invocationCount = 1)
    @Parameters({"browser"})
    public void verifyHeaderNavigationItems(){
        List<String> expectedItem = new ArrayList<>();
        List<String> actualItem = new ArrayList<>();
        expectedItem.add("About");
        expectedItem.add("Support");
        expectedItem.add("Documentation");
        expectedItem.add("Download");
        expectedItem.add("Projects");

        driver.get(getURL());
        List<WebElement> elements = driver.findElements(By.cssSelector("#header > ul > li"));
        Assert.assertEquals(elements.size(), 5);

        for (WebElement element : elements) {
            actualItem.add(element.getText());
        }
        Assert.assertEquals(actualItem, expectedItem);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
