package com.vodafone.vodafone_eshop_taf.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FlexLinesSummary extends PageBase {

    private final By yourIDNumberTitle = By.xpath("//vf-review//h4[3]");
    private final By idNumberField = By.xpath("//vf-lines-submit-form//div[1]//div//input");
    private final By idSubmitButton = By.xpath("//button[@class='btn btn-primary submit-btn']");


    public String getYourIDNumberTitle() {
        JavascriptExecutorScroll(safeFindElement(yourIDNumberTitle));
        return safeFindElement(yourIDNumberTitle).getText();
    }

    public WebElement getIdSubmitButton() {
        return safeFindElement(idSubmitButton);
    }

    public Cart clickOnIdSubmitButton() {
        JavascriptExecutorScroll(safeFindElement(idSubmitButton));
        JavascriptExecutorClick(safeFindElement(idSubmitButton));
        return new Cart();
    }

    public void enterIdNumberField(String idNumber) {
        JavascriptExecutorScroll(safeFindElement(idNumberField));
        safeFindElement(idNumberField).clear();
        safeFindElement(idNumberField).sendKeys(idNumber);
    }
}
