package com.vodafone.vodafone_eshop_taf.tests.login;

import com.vodafone.vodafone_eshop_taf.driver.WebDriverHandler;
import com.vodafone.vodafone_eshop_taf.tests.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class LoginStepDefs extends BaseTest {




    @When("user switch language in login page in vodafone website to be {string}")
            public void userSwitchLanguageInLoginPageInVodafoneWebsiteToBe(String preferredLanguage)
    {
        browser.eshopWebsite.login.userSwitchLanguageInLoginPageInVodafoneWebsite(preferredLanguage);
    }

    @Then("error message in login page should be {string}")
    public void errorMessageInLoginPageShouldBe(String errorMessageText)
    {
        Assert.assertTrue(browser.eshopWebsite.login.getInvalidUsernameOrPasswordErrorMessage().getText().contains(errorMessageText));
    }

    @Then("go to my account button should be not clickable")
    public void goToMyAccountButtonShouldBeNotClickable()
    {
        Assert.assertFalse(browser.eshopWebsite.login.getGoToMyAccountButton().isEnabled());
    }

    @When("click on register link")
    public void clickOnRegisterLink()
    {
        browser.eshopWebsite.login.clickOnRegisterLink();
    }

    @Then("registration form header in registration page should be {string}")
    public void registrationFormHeaderInRegistrationPageShouldBeDisplayed(String resetPasswordSectionHeader)
    {
        Assert.assertEquals(browser.eshopWebsite.login.getRegisterFormHeader().getText(),resetPasswordSectionHeader);
    }

    @Then("reset password section header in reset password page should be {string}")
    public void resetPasswordSectionInResetPasswordPageShouldBeDisplayed(String resetFormHeader)
    {
        Assert.assertEquals(browser.eshopWebsite.login.getResetFormHeader().getText(),resetFormHeader);
    }

    @When("click on forget password link")
    public void clickOnForgetPasswordLink() throws InterruptedException {
        browser.eshopWebsite.login.clickOnForgetPasswordLink();

    }
    @Then("user should be redirected to page with link {string} to home page")
    public void userShouldBeRedirectedToPageWithLinkToHomePage(String partialLink) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(WebDriverHandler.getCurrentUrl().contains(partialLink));
    }
}
