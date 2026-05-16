package com.vodafone.vodafone_eshop_taf.tests.profile.vouchers;

import com.vodafone.vodafone_eshop_taf.tests.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class VouchersStepDefs extends BaseTest {

    private WebElement selectedVoucherCard;

    @When("active vouchers tab is displayed with text {string}")
    public void activeVouchersTabIsDisplayedWithText(String expectedSectionName) {
        browser.eshopWebsite.vouchers.getActiveVouchersSection().isDisplayed();
        Assert.assertEquals(browser.eshopWebsite.vouchers.getActiveVouchersSection().getText(), expectedSectionName);
    }

    @When("used vouchers tab is displayed with text {string}")
    public void usedVouchersTabIsDisplayedWithText(String expectedSectionName) {
        browser.eshopWebsite.vouchers.getUsedVouchersSection().isDisplayed();
        Assert.assertEquals(browser.eshopWebsite.vouchers.getUsedVouchersSection().getText(), expectedSectionName);
    }

    @When("expired vouchers tab is displayed with text {string}")
    public void expiredVouchersTabIsDisplayedWithText(String expectedSectionName) {
        browser.eshopWebsite.vouchers.getExpiredVouchersSection().isDisplayed();
        Assert.assertEquals(browser.eshopWebsite.vouchers.getExpiredVouchersSection().getText(), expectedSectionName);
    }

    @When("click on active vouchers tab in vouchers section in profile page")
    public void clickOnActiveVouchersTabInVouchersSectionInProfilePage() {
        browser.eshopWebsite.vouchers.clickOnActiveVouchersSection();
    }

    @When("click on used vouchers tab in vouchers section in profile page")
    public void clickOnUsedVouchersTabInVouchersSectionInProfilePage() {
        browser.eshopWebsite.vouchers.clickOnUsedVouchersSection();
    }

    @When("click on expired vouchers tab in vouchers section in profile page")
    public void clickOnExpiredVouchersTabInVouchersSectionInProfilePage() {
        browser.eshopWebsite.vouchers.clickOnExpiredVouchersSection();
    }

    @Then("active vouchers section displaying message with text {string}")
    public void activeVouchersSectionDisplayingMessageWithText(String expectedMessage) {
        String actualMessage = browser.eshopWebsite.vouchers.getNoVouchersAvailableMessageText().getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Then("used vouchers section displaying message with text {string}")
    public void usedVouchersSectionDisplayingMessageWithText(String expectedMessage) {
        String actualMessage = browser.eshopWebsite.vouchers.getNoVouchersAvailableMessageText().getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Then("expired vouchers section displaying message with text {string}")
    public void expiredVouchersSectionDisplayingMessageWithText(String expectedMessage) {
        String actualMessage = browser.eshopWebsite.vouchers.getNoVouchersAvailableMessageText().getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Then("check name of cart label {string} in vouchers section in profile page")
    public void checkNameOfCartLabelInVouchersSectionInProfilePage(String cartLabel) {
        Assert.assertEquals(browser.eshopWebsite.vouchers.getCartLabelField(selectedVoucherCard).getText(), cartLabel);
    }

    @Then("check name of cart tag {string} in vouchers section in profile page")
    public void checkNameOfCartTagInVouchersSectionInProfilePage(String cartTag) {
        Assert.assertEquals(browser.eshopWebsite.vouchers.getCartTagField(selectedVoucherCard).getText(), cartTag);
    }

    @Then("check name of cart status {string} in vouchers section in profile page")
    public void checkNameOfCartStatusInVouchersSectionInProfilePage(String cartStatus) {
        Assert.assertEquals(browser.eshopWebsite.vouchers.getCartStatusField(selectedVoucherCard).getText(), cartStatus);
    }

    @Then("check redeem button status in vouchers section in profile page is disabled")
    public void checkRedeemButtonStatusInVouchersSectionInProfilePageIsDisabled() {
        Assert.assertFalse(browser.eshopWebsite.vouchers.getRedeemButton().isEnabled());
    }

    @Then("check name of cart title {string} in vouchers section in profile page")
    public void checkNameOfCartTitleInVouchersSectionInProfilePage(String cartTitle) {
        Assert.assertEquals(browser.eshopWebsite.vouchers.getCartTitleField(selectedVoucherCard).getText(), cartTitle);
    }

    @When("select voucher at index {int} in vouchers section in profile page")
    public void selectVoucherAtIndexInVouchersSectionInProfilePage(int index) {
        selectedVoucherCard = browser.eshopWebsite.vouchers.getVoucherCardByIndex(index - 1);
    }

    @When("click on redeem button in profile page")
    public void clickOnRedeemButtonInProfilePage(){
        browser.eshopWebsite.vouchers.clickOnRedeemButton();
    }

    @When("click on copy code button in profile page")
    public void clickOnCopyButtonInProfilePage(){
        browser.eshopWebsite.vouchers.clickOnCopyCodeButton();
    }



}
