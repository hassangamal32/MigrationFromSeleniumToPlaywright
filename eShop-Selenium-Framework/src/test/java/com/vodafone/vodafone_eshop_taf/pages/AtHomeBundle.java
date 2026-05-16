package com.vodafone.vodafone_eshop_taf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class AtHomeBundle extends PageBase{
    private final By firstQuotaInChooseBundlePageButton = By.xpath("(//button[contains(@id,'sl-internet-service-card-button-1')])[1]");
    private final By Qouta40GBName= By.id("sl-internet-bundle-h4-1-01H9FGYKRYEVV31795BG6D0M9G");
    private final By Qouta135GBName = By.id("sl-internet-bundle-h4-1-01H9FH0TX0TDP91GZCB39Y0PY4");
    private final By Qouta250GBName =By.id("sl-internet-bundle-h4-1-01H9FH412DB23K0XEYMP5W146P");
    private final By Qouta400GBName=By.id("sl-internet-bundle-h4-1-01H9FHAHRQ1PJQ0G2ZFR9S1JGZ");
    private final By homeWirelessStepper=By.xpath("/html/body/vf-root/main/section[2]/vf-internet-services-home/div/div[3]/vf-dsl-bundles/div/div/vf-page-header/p");
    private final By chooseBundlePageTitle= By.xpath("/html/body/vf-root/main/section[2]/vf-internet-services-home/div/div[3]/vf-dsl-bundles/div/div/vf-page-header/p");
    private final By chooseBundlePageDescription= By.xpath("/html/body/vf-root/main/section[2]/vf-internet-services-home/div/div[3]/vf-dsl-bundles/div/div/p");
    private final By termsAndConditionButton=By.xpath("/html/body/vf-root/main/section[2]/vf-internet-services-home/div/div[3]/vf-dsl-bundles/div/div/div[2]/vf-accordion/ngb-accordion/div/div/button");
    private final By termsAndConditionText=By.xpath("/html/body/vf-root/main/section[2]/vf-internet-services-home/div/div[3]/vf-dsl-bundles/div/div/div[2]/vf-accordion/ngb-accordion/div/div/button");

    public AtHomeRouter clickOnSelectFirstQuotaInAtHomeBundlesPage() {
        safeClick(firstQuotaInChooseBundlePageButton);
        return new AtHomeRouter();
    }

    public void clickOnTermsAndConditionButton() {
        JavascriptExecutorClick(safeFindElement(termsAndConditionButton));
    }

    public WebElement getQouta40GBName() {
        return safeFindElement(Qouta40GBName);
    }

    public WebElement getQouta135GBName() {
        return safeFindElement(Qouta135GBName);
    }

    public WebElement getQouta250GBName() {
        return safeFindElement(Qouta250GBName);
    }

    public WebElement getQouta400GBName() {
        return safeFindElement(Qouta400GBName);
    }

    public WebElement getHomeWirelessStepper() throws InterruptedException {
        return safeFindElement(homeWirelessStepper);

    }

    public WebElement getAtHomeBundlesPageTitle() {
        return safeFindElement(chooseBundlePageTitle);
    }

    public WebElement getAtHomeBundlesPageDescription() {
        return safeFindElement(chooseBundlePageDescription);
    }

    public WebElement getTermsAndConditionText() {
        return safeFindElement(termsAndConditionText);
    }
    public void scrollToTermsAndConditionText() {
        JavascriptExecutorScroll(getTermsAndConditionText());
    }

}
