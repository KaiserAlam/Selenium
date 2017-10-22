package com.util;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class BrowserActions {

    private static final Logger logger = LoggerFactory.getLogger(BrowserActions.class);

    public void clickOnElement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            logger.info("Unable to location web element");
            e.printStackTrace();
        }
    }

    public List<String> getLinksAsString(List<WebElement> elements){
        List<String> projectLinks = new ArrayList<>();
        try {
            for(WebElement element: elements){
                projectLinks.add(element.getAttribute("href"));
            }
            return projectLinks;
        } catch (Exception e) {
            logger.info("Unable to location web element");
            e.printStackTrace();
        }
        return null;
    }
}
