package com.avalanche;

import java.util.ResourceBundle;

public class SeleniumHQ extends Page{

    private final ResourceBundle resourceBundle;
    private final String url;

    public SeleniumHQ(){
        this.resourceBundle = ResourceBundle.getBundle("SeleniumHQ");
        this.url = this.getResourceBundle().getString("url");
    }

    public ResourceBundle getResourceBundle() {
        return this.resourceBundle;
    }

    public String getURL() {
        return this.url;
    }
}
