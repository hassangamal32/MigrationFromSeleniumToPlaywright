package com.vodafone.vodafone_eshop_taf.pages;

import com.vodafone.vodafone_eshop_taf.driver.WebDriverHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RedLines extends PageBase {

    private final By stepper = By.xpath("//button[contains(@class,'step-btn') and contains(@class,'stepBtn-active')]");
    private final By pageTitle = By.xpath("//div[contains(@class,'header-container')]//h2");
    private final By termsAndCondition = By.xpath("//div[contains(@class,'custom-accordion-header')]//h3");


    private final By linePrice = By.xpath("//*[@id=\"red-panel\"]/vf-lines-pool/div[1]/vf-lines-type-switcher/div/label[1]/p/span");
    private final By firstLineNumber = By.xpath("(//div[contains(@class,'msisdn-item-container') and @role='button'])[1]");
    private final By firstLineButton = By.xpath("//*[@id=\"red-panel\"]/vf-lines-pool/vf-lines-view-container/div/div[1]/div");
    private final By chooseThisLineButton = By.xpath("//button[contains(@class,'vf-btn-primary') and contains(@class,'vf-btn-md') and @aria-label]");

    private final By switchNowButton = By.xpath("//vf-mnp-redirect-box//button");
    private final By redLinesScetion = By.xpath("//vf-lines-view-container//div[contains(@class,'msisdn-container')]//div");

    public WebElement getChooseThisLineButton() {
        return safeFindElement(chooseThisLineButton);
    }


    public boolean isStepperPresent() {
        return safeFindElements(stepper).size() > 0;
    }

    public String getMainPageTitle() {
        return safeFindElement(pageTitle).getText();
    }

    public WebElement getTermsAndConditionSection() {
        return safeFindElement(termsAndCondition);
    }
    public void scrollToTermsAndConditionSection() {
        scrollTo(getTermsAndConditionSection());
    }

    public void clickOnTermsAndConditionSection() {
        safeClick(termsAndCondition);
    }

    public String getLinePriceText() {
        return splitString(safeFindElement(linePrice).getText(),"\\D+");
    }

    public WebElement getLinePrice() {
        return safeFindElement(linePrice);
    }

    public void scrollToLinePrice() {
        scrollTo(safeFindElement(linePrice));
    }

    public String getFirstLineNumber() {
        scrollDownUntilHeaderVisible(firstLineNumber, 1);
        return safeFindElement(firstLineNumber).getText();
    }

    public WebElement getSwitchNowButton() {
        return safeFindElement(switchNowButton);
    }

    public void scrollToSwitchNowButton() {
        JavascriptExecutorScroll(getSwitchNowButton());
    }

    public Mnp clickOnSwitchNowButton() {
        JavascriptExecutorClick(getSwitchNowButton());
        return new Mnp();
    }

    public void clickOnFirstLineButton() {
        waitForElementEnabledAndDisplayedAndClickUsingJS(firstLineButton);
    }


    public void clickOnChooseLineButton() {
        waitForElementEnabledAndDisplayedAndClickUsingJS(chooseThisLineButton);
    }


    public void scrollToLinesSection() {
        scrollDownUntilHeaderVisible(redLinesScetion, 10);
    }
}



