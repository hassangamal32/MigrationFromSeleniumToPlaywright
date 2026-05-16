package com.vodafone.vodafone_eshop_taf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AtHomeRouter extends PageBase {

    private final By homeWireless4GPlusButton= By.id("sl-internet-router-button-1-01H9FGJMX4W6Y70Z32N4XX15DE");
    private final By homeWireless5GPlusPrice = By.id("sl-internet-router-p-2-01JT0CRF9R6Y7F0C4K82QC0V88");
    private final By homeWireless4GPlusTitle= By.id("sl-internet-router-h5-1-01H9FGJMX4W6Y70Z32N4XX15DE");
    private final By homeWireless5GPlusTitle = By.id("sl-internet-router-h5-1-01JT0CRF9R6Y7F0C4K82QC0V88");
    private final By selectHomeWirelessRouterButton= By.xpath("//vf-internet-service-card[3]/article/section/div[2]/button");
    private final By chooseRoutersPageTitle=By.xpath("//vf-internet-services-home/div/div[3]/vf-routers/div/div/vf-page-header/p");
    private final By homeWireless4GPlusPrice=By.id("sl-internet-router-p-2-01H9FGJMX4W6Y70Z32N4XX15DE");
    private final By homeWireless4GPlusInstallmentPrice=By.id("sl-internet-router-span-2-01H9FGJMX4W6Y70Z32N4XX15DE");
    private final By homeWireless5GPlusInstallmentPrice=By.id("sl-internet-router-span-2-01JT0CRF9R6Y7F0C4K82QC0V88");
    private final By homeWireless5GPlusButton = By.id("sl-internet-router-button-1-01JT0CRF9R6Y7F0C4K82QC0V88");
    private final By TermsAndConditionText=By.xpath("/html/body/vf-root/main/section[2]/vf-internet-services-home/div/div[3]/vf-routers/div/div/div[2]/vf-accordion/ngb-accordion/div/div[2]/div/div/p[1]");

    public WebElement getHomeWireless4GPrice(){
        return safeFindElement(homeWireless4GPlusPrice);
    }

    public WebElement getHomeWireless4GPlusTitle() throws InterruptedException {
        return safeFindElement(homeWireless4GPlusTitle);
    }

    public WebElement gethomeWireless5GPlusTitle() {
        return safeFindElement(homeWireless5GPlusTitle);
    }

    public WebElement getTermsAndConditionText() {
        return safeFindElement(TermsAndConditionText);
    }

    public WebElement getChooseRoutersPageTitle() {
        return safeFindElement(chooseRoutersPageTitle);
    }

    public WebElement getAtHomeRouterInstallmentPrice(String AtHomeRouterName) {
        switch (AtHomeRouterName) {
            case "Home Wireless 4G Plus":
                return safeFindElement(homeWireless4GPlusInstallmentPrice);
            case "Home Wireless 5G Plus":
                return safeFindElement(homeWireless5GPlusInstallmentPrice);
            case "راوتر هوائي منزلي فائق السرعة 4G":
                return safeFindElement(homeWireless4GPlusInstallmentPrice);
            case "راوتر هوائي منزلي فائق السرعة 5G بلس":
                return safeFindElement(homeWireless5GPlusInstallmentPrice);
        }
        return null;
    }

    public WebElement getAtHomeRouterPrice(String AtHomeRouterName) {
        switch (AtHomeRouterName) {
            case "Home Wireless 5G Plus":
                waitElementToBeClickable(homeWireless5GPlusPrice);
                return safeFindElement(homeWireless5GPlusPrice);
            case "Home Wireless 4G Plus":
                return safeFindElement(homeWireless4GPlusPrice);
            case "راوتر هوائي منزلي فائق السرعة 5G بلس":
                return safeFindElement(homeWireless5GPlusPrice);
            case "راوتر هوائي منزلي فائق السرعة 4G":
                return safeFindElement(homeWireless4GPlusPrice);
        }
        return null;
    }
    public Double getAtHomeRouterPriceText(String AtHomeRouterName) {
        return Double.valueOf(splitAmountOfElementText(getAtHomeRouterPrice(AtHomeRouterName)));
    }

    public void clickOnSelectHomeWirelessRouter() {
        JavascriptExecutorClick(safeFindElement(selectHomeWirelessRouterButton));
    }

    public AtHomeSubscriptionDetails clickOnSelectButtonForAtHomeRouterInAtHomeRouterPage(String routerName) {
        switch (routerName) {
            case "Home Wireless 4G Plus":
                JavascriptExecutorClick(safeFindElement(homeWireless4GPlusButton));
                return new AtHomeSubscriptionDetails();
            case "Home Wireless 5G Plus":
                JavascriptExecutorClick(safeFindElement(homeWireless5GPlusButton));
                return new AtHomeSubscriptionDetails();
            case "راوتر هوائي منزلي فائق السرعة 4G":
                JavascriptExecutorClick(safeFindElement(homeWireless4GPlusButton));
                return new AtHomeSubscriptionDetails();
            case "راوتر هوائي منزلي فائق السرعة 5G بلس":
                JavascriptExecutorClick(safeFindElement(homeWireless5GPlusButton));
                return new AtHomeSubscriptionDetails();
        }
        return null;
    }

}
