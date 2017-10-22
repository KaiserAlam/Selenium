package com.page;

import com.util.BrowserActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.ResourceBundle;

public class ProjectsPage extends Page {

    private final ResourceBundle resourceBundle;
    private final String url;
    private WebDriver driver;
    private BrowserActions actions;


    public ProjectsPage(WebDriver driver){
        this.resourceBundle = ResourceBundle.getBundle("ProjectsPage");
        this.url = this.getResourceBundle().getString("url");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle(){
        driver.get(getURL());
        return driver.getTitle();
    }

    @Override
    public ResourceBundle getResourceBundle() {
        return this.resourceBundle;
    }

    @Override
    public String getURL() {
        return this.url;
    }
}
