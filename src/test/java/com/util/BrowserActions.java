package com.util;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
}
