package com.vodafone.vodafone_eshop_taf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.time.Duration.ofSeconds;


public class RedLinesSummary extends PageBase {

    private final By LinePriceFieldInPlansPage = By.xpath("//*[@id=\"lines-checkout-summary\"]/div/div[1]/div/p");
    private final By chosenNumberButton = By.xpath("//*[@id=\"lines-checkout-summary\"]/div/div[1]/p");
    private final By ratePlanTitle = By.xpath("(//div[contains(@class,'content-text')]//p)[1]");
    private final By firstFamilyLine = By.xpath("//vf-family-lines-section//div[2]//vf-line-card[1]//div");
    private final By secondFamilyLine = By.xpath("//vf-family-lines-section//div[2]//vf-line-card[2]//div");
    private final By thirdFamilyLine = By.xpath("//vf-family-lines-section//div[2]//vf-line-card[3]//div");


    private final By nationalIdTextField = By.xpath("//input[@formcontrolname='nationalId']");
    private final By submitNationalIdButton = By.id("lines-checkout-submit");
    private final By buyingForMySelfButton= By.xpath("(//div[contains(@class,'select-box-content')]//button)[1]");
    private final By buyingForInput= By.xpath("/html/body/vf-root/main/section[2]/vf-lines-checkout/section/div[1]/vf-checkout-main-form/div/div[2]/div[1]/div/div");
    private final By firstNameTextField= By.xpath("//input[@formcontrolname='firstName']");
    private final By lastNameTextField= By.xpath("//input[@formcontrolname='lastName']");
    private final By nextButton = By.xpath("//button[contains(@class,'step-button') and @form='contactForm']");
    private final By provideOneOfTheFollowingDocumentsCheckBox= By.xpath("//label[contains(@class,'radio-label')]//span[contains(@class,'custom-radio')]");

    public String getPlanName(String planName) {
        return safeFindElement(ratePlanTitle).getText();
    }

    public int chooseFamilyLines(String plan) {
        int count = 0;

        if (plan.equals("Red Advance")) {
            safeClick(firstFamilyLine);
            count++;
        }

        if (plan.equals("Red Prime")) {
            safeClick(firstFamilyLine);
            safeClick(secondFamilyLine);
            count += 2;
        }

        if (plan.equals("Red Elite")) {
            safeClick(firstFamilyLine);
            safeClick(secondFamilyLine);
            safeClick(thirdFamilyLine);
            count += 3;
        }

        return count;
    }

    public void clickOnSubmitNationalId() {
        safeClick(submitNationalIdButton);
    }

    public void enterNationalId(String nationalId) {
        safeClick(nationalIdTextField);
        WebElement nationalIdField = safeFindElement(nationalIdTextField);
        scrollTo(nationalIdField);
        sendText(nationalIdTextField, nationalId);
    }

    public String getMsisdnNumber() {
        return safeFindElement(chosenNumberButton).getText();
    }

    public String getLinePriceInPlansPage() {
        return safeFindElement(LinePriceFieldInPlansPage).getText();
    }

    public void clickSelectOptionBuyingFor() {
        safeClick(buyingForInput);
        safeClick(buyingForMySelfButton);
    }

    public void enterFirstName(String firstName) {
        safeClick(firstNameTextField);
        sendText(firstNameTextField, firstName);

    }

    public void enterLastName(String lastName) {
        safeClick(lastNameTextField);
        sendText(lastNameTextField, lastName);
    }

    public void clickOnNextButton() {
        safeClick(nextButton);
    }

    public void clickOnProvideOneOfTheFollowingDocumentsCheckBox() {
        safeClick(provideOneOfTheFollowingDocumentsCheckBox);
    }
}
