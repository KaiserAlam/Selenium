package com.avalanche;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SeleniumHQ extends Page{

    private final ResourceBundle resourceBundle;
    private final String url;
    private WebDriver driver;
    private BrowserActions actions;

    @FindBy(xpath = "//*[@id=\"menu_projects\"]/a")
    protected WebElement projectLinks;

    public SeleniumHQ(WebDriver driver){
        this.resourceBundle = ResourceBundle.getBundle("SeleniumHQ");
        this.url = this.getResourceBundle().getString("url");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ResourceBundle getResourceBundle() {
        return this.resourceBundle;
    }

    public String getURL() {
        return this.url;
    }

    public String getPageTitle(WebDriver driver){
        driver.get(getURL());
        return driver.getTitle();
    }

    public List<String> getHeaderItemList(WebDriver driver){
        List<String> actualItem = new ArrayList<>();
        driver.get(getURL());
        List<WebElement> elements = driver.findElements(By.cssSelector("#header > ul > li"));
        for (WebElement element : elements) {
            actualItem.add(element.getText());
        }
        return actualItem;
    }
}
