package com.vodafone.vodafone_eshop_taf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Login extends PageBase {

    private final By msisdnField = By.id("username");

    private final By passwordField = By.id("password");

    private final By goToMyAccountButton = By.id("submitBtn");

    private final By invalidUsernameOrPasswordErrorMessage = By.id("js-mobileNumberError");

    private final By registerLink = By.id("goToRegister");

    private final By registerFormHeader = By.id("regMobileNumberTitle");

    private final By forgetPasswordLink = By.id("goToRestPassword");

    private final By resetFormHeader = By.xpath("//h1[contains(@class,'font-bold')]");

    private final By SwitchLanguageInLoginPageInVodafoneWebsiteButton = By.className("font-bold");

    public WebElement getInvalidUsernameOrPasswordErrorMessage() {
        return safeFindElement(invalidUsernameOrPasswordErrorMessage);
    }

    public WebElement getGoToMyAccountButton() {
        return safeFindElement(goToMyAccountButton);
    }

    public WebElement getRegisterFormHeader() {
        return safeFindElement(registerFormHeader);
    }

    public WebElement getResetFormHeader() {
        return safeFindElement(resetFormHeader);
    }

    public Home clickOnGoToMyAccountButon() {
        JavascriptExecutorClick(safeFindElement(goToMyAccountButton));
        return new Home();
    }

    public void clickOnRegisterLink() {
        safeFindElement(registerLink).click();
    }

    public void clickOnForgetPasswordLink() throws InterruptedException {
        safeClick(forgetPasswordLink);
    }

    public void enterMsisdnInMsisdnField(String msisdn) {
        safeFindElement(msisdnField).sendKeys(msisdn);
    }

    public void enterPasswordInPasswordField(String password) {
        safeFindElement(passwordField).sendKeys(password);
    }

    public void userSwitchLanguageInLoginPageInVodafoneWebsite(String preferredLanguage) {
        if (preferredLanguage.equals("ar")) {
            safeFindElement(SwitchLanguageInLoginPageInVodafoneWebsiteButton).click();
        }
    }

    public Home clickOnGoToMyAccountButonAndRedirectsToHome() {
        JavascriptExecutorClick(safeFindElement(goToMyAccountButton));
        return new Home();
    }
}
