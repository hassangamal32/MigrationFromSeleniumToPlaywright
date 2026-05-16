package com.vodafone.vodafone_eshop_taf.tests.profile.personalDetails;

import com.vodafone.vodafone_eshop_taf.driver.WebDriverHandler;
import com.vodafone.vodafone_eshop_taf.tests.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class personalDetailsStepDefs extends BaseTest {

    @When("click on user name on header")
    public void clickOnUserNameOnHeader() {
        browser.eshopWebsite.header.clickOnUserName();

    }

    @When("click on profile from dropdown menu on header")
    public void clickOnProfileFromDropdownMenuOnHeader() {
        browser.eshopWebsite.personalDetails=browser.eshopWebsite.header.clickOnProfileOption();
    }

    @Then("name on personal info card in profile page should be{string}")
    public void nameOnPersonalInfoCardInProfilePageShouldBe(String name) {
        Assert.assertTrue(browser.eshopWebsite.personalDetails.getNameField().getText().contains(ratePlans.getProperty(name)));
    }

    @Then("mobileNumber on personal info card in profile page should be{string}")
    public void mobileNumberOnPersonalInfoCardInProfilePageShouldBe(String MobileNumber) {
        Assert.assertEquals(browser.eshopWebsite.personalDetails.getMobileNumberField().getText(),ratePlans.getProperty(MobileNumber));
    }

    @And("click on logout button on profile")
    public void clickOnLogoutButtonOnProfile() {
        browser.eshopWebsite.personalDetails.clickOnLogoutButton();
    }

    @Then("browser should be redirected to {string}")
    public void browserShouldBeRedirectedToLoginPage (String loginLink) {
        Assert.assertTrue(WebDriverHandler.getWebDriver().getCurrentUrl().contains(loginLink));
    }

    @Then("vouchers section in profile page should be displayed")
    public void vouchersSectionInProfilePageShouldBeDisplayed() {
        browser.eshopWebsite.personalDetails.getVouchersButton().isDisplayed();
    }

    @When("click on vouchers section in profile page")
    public void clickOnVouchersSectionInProfilePage() {
        browser.eshopWebsite.personalDetails.clickOnVouchersButton();
    }

    @Then("addresses tab in profile page should be displayed")
    public void addressesTabInProfilePageShouldBeDisplayed() {
        browser.eshopWebsite.personalDetails.getAddressesTab().isDisplayed();
    }

    @When("click on addresses tab in profile page")
    public void clickOnAddressesTabInProfilePage() {
        browser.eshopWebsite.addresses = browser.eshopWebsite.personalDetails.clickOnAddressesTab();
    }
}


