package com.vodafone.vodafone_eshop_taf.tests.home;

import com.vodafone.vodafone_eshop_taf.tests.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class HomeStepDefs extends BaseTest {

    @Then("tracking link should be contain home link {string} in home page")
    public void trackingLinkShouldBeContainHomeLink(String homeLinkText)
    {
        Assert.assertEquals(browser.eshopWebsite.home.getHomeInTrackingLink().getText(),homeLinkText);
    }

    @When("scroll down to Top Selling section in home page")
    public void scrollDownToTopSellingSectionInHomePage() throws InterruptedException {
        Thread.sleep(1500);
        browser.eshopWebsite.home.scrollTopSellingSection();
    }

    @When("scroll down to Featured Brand section in home page")
    public void scrollDownToFeaturedBrandSectionInHomePage() throws InterruptedException {
        Thread.sleep(1500);
        browser.eshopWebsite.home.scrollDownToFeaturedBrand();
    }

    @When("click on the first item in top selling section in home page")
    public void clickOnTheFirstItemInTopSellingSectionInHomePage(){
        browser.eshopWebsite.productDetails = browser.eshopWebsite.home.clickOnFirstItemInTopSellingSection();
    }

    @When("click on the second item in top selling section in home page")
    public void clickOnTheSecondItemInTopSellingSectionInHomePage(){
        browser.eshopWebsite.productDetails = browser.eshopWebsite.home.clickOnSecondItemInTopSellingSection();
    }

    @When("click on {string} tab in shop by brand section in home page")
    public void clickOnBrandTabInShopByBrandName(String brand)
    {
        browser.eshopWebsite.home.getBrandTabInShopByBrandName(brand);
    }

    @When("scroll down to most selling phones")
    public void scrollDownToMostSellingPhones() throws InterruptedException {
        browser.eshopWebsite.home.scrollToFirstHeaderInMostSellingPhones();
    }

    @Then("the smart Phones section header in home page with header {string} should be displayed")
    public void theSmartPhonesSectionHeaderInHomePageWithHeaderShouldBeDisplayed(String secondHeaderText)
    {
        Assert.assertEquals(browser.eshopWebsite.home.getSmartPhonesSectionHeader().getText(),secondHeaderText);
    }

    @When("scroll down to see more button in {string} in home page")
    public void scrollDownToSeeMoreButtonInBrandSection(String scrollToSectionName) throws InterruptedException {
        browser.eshopWebsite.home.scrollDownToSeeMoreButtonInBrandSection(scrollToSectionName);
    }

    @When("click on see more button in {string} in home page")
    public void clickOnSeeMoreButtonInBrandSectionInHomePage(String section) throws InterruptedException {
        browser.eshopWebsite.home.clickOnSeeMoreButtonInBrandSectionInHomePage(section);
    }

    @When("scroll down to see more button in accessories module in home page")
    public void scrollDownToSeeMoreButtonInAccessoriesModuleInHomePage(){
        browser.eshopWebsite.home.scrollToSeeMoreButtonInAccessoriesModule();
    }

   @When("click on show more button in discounts in home page")
    public void clickOnShowMoreButtonInDiscountsInHomePage()
    {
        browser.eshopWebsite.home.getSeeMoreButtonInNewArrivalsModuleInHomePage().click();
    }

    @When("click on the phone item in best selling phones in home page")
    public void clickOnThePhoneItemInBestSellingPhonesInShopPage()
    {
        browser.eshopWebsite.productDetails = browser.eshopWebsite.home.clickOnBestSellingFirstItemLink();
    }

    @When("click on the second phone item in smart phones section in home page")
    public void clickOnTheSecondPhoneItemInSmartPhonesSectionInHomePage()
    {
        browser.eshopWebsite.productDetails = browser.eshopWebsite.home.clickOnSecondPhoneItemInSmartPhones();
    }

    @When("click on the first item in discounts items in shop page")
    public void clickOnTheFirstItemInDiscountsItemInShopPage()
    {
        browser.eshopWebsite.productDetails = browser.eshopWebsite.home.clickOnFirstItemInDiscountsItems();
    }

//    @Then("cart icon in home page should be unClickable")
//    public void cartIconInHomePageShouldBeUnClickable() {
//        Assert.assertTrue( browser.eshopWebsite.home.cartIconInHomePageShouldBeUnclickable().isDisplayed());
//    }

    @Then("cart icon in home page should be clickable")
    public void cartIconInHomePageShouldBeClickable() {
        Assert.assertTrue(browser.eshopWebsite.home.cartIconInHomePageShouldBeClickable().isEnabled());
    }

    @When("click on all tab in nav bar in home page")
    public void clickOnAllTabInNavBarInHomePage() {
        browser.eshopWebsite.productsList = browser.eshopWebsite.home.clickOnAllTabInNavBar();
    }

    @When("scroll down to recommended for you section in home page")
    public void scrollDownToRecommendedForYouSectionInHomePage() {
        browser.eshopWebsite.home.scrollToRecommendedForYouSection();
    }

    @Then("recommended for you section in home page should be displayed")
    public void recommendedForYouSectionInHomePageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.home.getRecommendedForYouSection().isDisplayed());
    }

    @Then("recommended for you section in home page should have less than 50 sku")
    public void recommendedForYouSectionInHomePageShouldHaveLessThan50Sku(){
            int actualSkuCount = browser.eshopWebsite.home.getRecommendedForYouSkuCount();

            Assert.assertTrue(actualSkuCount < 50,
                    "recommended for you section has " + actualSkuCount +
                            " SKUs, expected less than 50");

    }
}