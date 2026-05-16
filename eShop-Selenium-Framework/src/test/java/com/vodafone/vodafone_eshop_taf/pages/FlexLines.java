package com.vodafone.vodafone_eshop_taf.pages;

import com.vodafone.vodafone_eshop_taf.driver.WebDriverHandler;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class FlexLines extends PageBase {

    private final By stepper = By.xpath("//vf-stepper/div/div");

    private final By flexLinesPageTitle = By.xpath("//p[@class='h3-font']");

    private final By linePriceText = By.xpath("//span[@class='line-price-details']");

    private final By flexLineNumbers = By.xpath("//vf-line-card//div[1]/div[1]/p");

    private final By flexLineButton = By.xpath("//vf-line-card//div[1]/div[1]/p");

    private final By chooseThisLineButton = By.xpath("//*[text()='Choose this line' or text()='اختار هذا الخط']");

    private final By termsAndConditions = By.xpath("//button[@class='accordion-button collapsed']");

    private final By chosenNumberText = By.xpath("//div[@class='selected-line-card']/p");

    private WebDriverWait wait = new WebDriverWait(WebDriverHandler.getWebDriver(), Duration.ofSeconds(30));

    public boolean isStepperPresent() {
        return safeFindElements(stepper).size() > 0;
    }

    public WebElement getChooseThisLineButton() {
        return safeFindElement(chooseThisLineButton);
    }

    public String getFlexLinePageTitle() {
        return safeFindElement(flexLinesPageTitle).getText();
    }

    public String getLinePriceText() {
        return splitString(safeFindElement(linePriceText).getText(),"\\D+");
    }

    public String getFirstLineNumber() {
        WebElement number = safeFindElement(flexLineNumbers);
        return number.getText();
    }

    public String getFirstSelectedLineNumber() {
        try {
            List<WebElement> chosenNumbers = safeFindElements(chosenNumberText);
            if (chosenNumbers.isEmpty()) {
                return "No Selected MSISDNs";
            } else {
                return chosenNumbers.get(0).getText();
            }
        } catch (NoSuchElementException | TimeoutException e) {
            return "No Selected MSISDNs";
        }
    }


    public String getTermsAndConditionsText() {
        JavascriptExecutorScroll(safeFindElement(termsAndConditions));
        return safeFindElement(termsAndConditions).getText();
    }

    public void clickOnTermsAndConditions() {
        JavascriptExecutorScroll(safeFindElement(termsAndConditions));
        JavascriptExecutorClick(safeFindElement(termsAndConditions));
    }

    public void clickOnFirstLineButton() {
        WebElement number = safeFindElement(flexLineButton);
        JavascriptExecutorClick(number);
    }

    public FlexLinesPlans clickOnChooseLineButton() {
        JavascriptExecutorScroll(safeFindElement(chooseThisLineButton));
        JavascriptExecutorClick(safeFindElement(chooseThisLineButton));
        return new FlexLinesPlans();
    }

}
