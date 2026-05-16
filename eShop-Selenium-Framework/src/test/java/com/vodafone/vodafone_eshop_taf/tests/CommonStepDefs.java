package com.vodafone.vodafone_eshop_taf.tests;

import com.vodafone.vodafone_eshop_taf.driver.WebDriverHandler;
import com.vodafone.vodafone_eshop_taf.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CommonStepDefs extends BaseTest {

    private List<WebElement> allProductsInHomePage;


    @When("user change website language to be in language {string}")
    public void changeWebsiteLanguage(String preferredLanguage) throws InterruptedException {
        Thread.sleep(2000);
        browser.eshopWebsite.header.switchLanguageTo(preferredLanguage);
    }

    @Given("website is opened and user need it to be in language {string}")
    public void websiteIsOpenedAndUserNeedItToBeInLanguage(String preferredLanguage) {
        browser.eshopWebsite.header.switchLanguageTo(preferredLanguage);
    }

    @And("click on login icon in header")
    public void clickOnLoginIconInHeader(){
        browser.eshopWebsite.login=browser.eshopWebsite.header.clickOnLoginIcon();
    }

    @When("user enter {string} and {string} to login")
    public void userEnterMsisdnAndPasswordToLogin(String msisdn,String password){
        browser.eshopWebsite.login.enterMsisdnInMsisdnField(ratePlans.getProperty(msisdn));
        browser.eshopWebsite.login.enterPasswordInPasswordField(ratePlans.getProperty(password));
    }

    @When("user click on go to my account button")
    public void userClickOnGoToMyAccountButton()
    {
        browser.eshopWebsite.home=browser.eshopWebsite.login.clickOnGoToMyAccountButon();
    }

    @When("click on remove button in cart page")
    public void clickOnRemoveButtonInCartPage() throws InterruptedException {
            browser.eshopWebsite.home=browser.eshopWebsite.cart.clickOnDeleteProductIcon();
    }

    @When("click on vodafone logo in header section")
    public void clickOnVodafoneLogoInHeaderSection() throws InterruptedException {
        browser.eshopWebsite.header.clickOnVodafoneLogo();
    }
    @When("click on {string} in nav bar in home page")
    public void clickOnTabsInNavBarInHomePage(String tab) throws InterruptedException {
        Object nextPage = browser.eshopWebsite.home.clickOnTabsInNavBarInHomePage(tab);
        if (nextPage instanceof RedLines) {
            browser.eshopWebsite.redLines = (RedLines) nextPage;
        } else if (nextPage instanceof Dsl) {
            browser.eshopWebsite.dsl=(Dsl) nextPage;
        } else if (nextPage instanceof ProductsList) {
            browser.eshopWebsite.productsList = (ProductsList) nextPage;
        } else if (nextPage instanceof AtHomeBundle) {
            browser.eshopWebsite.atHomeBundle = (AtHomeBundle) nextPage;
        }
    }




    @When("click on the first accessory item in best selling accessories in shop page")
    public void clickOnTheFirstAccessoryItemInBestSellingAccessoriesInShopPage() {
        allProductsInHomePage=browser.eshopWebsite.home.getAllProducts();
        //System.out.println(allProductsInHomePage.size());
        browser.eshopWebsite.productDetails = browser.eshopWebsite.home.clickOnFirstAccessoryItemButtonInBestSellingAccessories();

        try {
            Thread.sleep(3000);
            browser.eshopWebsite.productDetails.getAddToCartButton().isDisplayed();
        }
        catch (Exception e) {
            for (int i = 11; i < 15; i++)
            {
                WebDriverHandler.getWebDriver().navigate().back();
                allProductsInHomePage.get(i).click();
                try
                {
                    if (browser.eshopWebsite.productDetails.getAddToCartButton().isDisplayed()) {
                        break;
                    }
                }
                catch (Exception e1)
                {
                    continue;
                }
            }
        }
    }

    @Then("user should be redirected to page with link {string} in product list page")
    public void userShouldBeRedirectedToPageWithLink(String partialLink) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(WebDriverHandler.getCurrentUrl().contains(partialLink));
    }


    @Then("user should be redirected to page with partial link {string} in product details page")
    public void userShouldBeRedirectedToPageWithPartialLink(String partialLink) {
        Assert.assertTrue(WebDriverHandler.getCurrentUrl().contains(partialLink));
    }

  /*    there is step used in cart feature & cart Step Def modules
        called "click on cart icon in the home page header"
        it should be deleted & replaced with the following more general step
  */
    @When("click on shopping cart icon in header")
    public void clickOnCartIconInTheHomePageHeader() {
        browser.eshopWebsite.cart=browser.eshopWebsite.header.clickOnShoppingCartIcon();
    }

    @Then("the header {string} should be visible in cart page")
    public void theHeaderShouldBeVisibleInCartPage(String headerTitle) throws InterruptedException {
        Assert.assertTrue(browser.eshopWebsite.cart.getCartHeader(headerTitle).isDisplayed());
    }

    @Then("the header {string} should be visible in order confirmation page")
    public void theHeaderShouldBeVisibleInOrderConfirmationPage(String headerTitle) throws InterruptedException {
        Assert.assertTrue(browser.eshopWebsite.orderConfirmation.getOrderConfirmationHeader(headerTitle).isDisplayed());
    }


    /*    passing order id from order confirmation page
          to  my orders & order details pages
    */
    private String newOrderId;

    @When("cache order id in order confirmation page")
    public void cacheOrderIdInOrderConfirmationPage() {
        newOrderId = browser.eshopWebsite.orderConfirmation.getOrderNumberText();
    }

    @Then("order id in my orders page should be same as order confirmation page")
    public void orderIdInMyOrdersPageShouldBeSameAsOrderConfirmationPage() {
        Assert.assertTrue(browser.eshopWebsite.myOrders.getOrderId().getText().contains(newOrderId));
    }

    @Then("order id in order details page should be same as order confirmation page")
    public void orderIdInOrderDetailsPageShouldBeSameAsOrderConfirmationPage() {
        Assert.assertTrue(browser.eshopWebsite.orderDetails.getOrderId().getText().contains(newOrderId));
    }

}
