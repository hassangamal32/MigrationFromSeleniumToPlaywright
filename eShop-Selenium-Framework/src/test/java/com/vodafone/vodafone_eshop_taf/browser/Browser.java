package com.vodafone.vodafone_eshop_taf.browser;

import com.vodafone.vodafone_eshop_taf.platform.EshopWebsite;
import com.vodafone.vodafone_eshop_taf.driver.WebDriverHandler;
import com.vodafone.vodafone_eshop_taf.pages.FlexLines;
import org.openqa.selenium.WebDriver;

public class Browser {

    private final WebDriver webDriver = WebDriverHandler.getWebDriver();

    public EshopWebsite eshopWebsite;


    public Browser() {
        eshopWebsite = new EshopWebsite();

    }

    public FlexLines openVodafoneFlexPage() {
        String vodafoneServicesPageLink = "https://eshop.vodafone.com.eg/en/lines/flex/numbers?show=4444";
        webDriver.navigate().to(vodafoneServicesPageLink);
        return new FlexLines();
    }






}
