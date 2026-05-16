package com.vodafone.vodafone_eshop_taf.tests.productsList;

import com.vodafone.vodafone_eshop_taf.tests.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ProductsListStepDef extends BaseTest {
    @When("click on apple tab in products list page")
    public void clickOnAppleTabInProductsListPage() throws InterruptedException {
        browser.eshopWebsite.productsList.clickOnAppleTab();
    }
    @When("click on fist mac item in in products list page")
    public void clickOnFirstMacItemInProductsListPage() throws InterruptedException {
        browser.eshopWebsite.productDetails = browser.eshopWebsite.productsList.clickOnFirstMacItemInProductsListPage();
    }

    @When("click on second mac item in in products list page")
    public void clickOnSecondMacItemInProductsListPage() throws InterruptedException {
        browser.eshopWebsite.productDetails = browser.eshopWebsite.productsList.clickOnSecondMacItemInProductsListPage();
    }

    @Then("main promotional banner carousel should be displayed in products list page")
    public void mainPromotionalBannerCarouselShouldBeDisplayedInProductsListPage() {
        Assert.assertTrue(
                browser.eshopWebsite.productsList.isHeroBannerCarouselDisplayed(),
                "Hero banner carousel is NOT displayed"
        );
    }

    @Then("at least one banner image should be visible in main carousel in products list page")
    public void atLeastOneBannerImageShouldBeVisibleInMainCarouselInProductsListPage() {
        int slidesCount = browser.eshopWebsite.productsList.getHeroBannerSlidesCount();
        Assert.assertTrue(slidesCount >= 1, "No hero banner slides found in carousel");
    }

    @Then("banner navigation arrows should be displayed in products list page")
    public void bannerNavigationArrowsShouldBeDisplayedInProductsListPage(){
        Assert.assertTrue(
                browser.eshopWebsite.productsList.areHeroBannerArrowsDisplayed(),
                "Hero banner navigation arrows are NOT displayed"
        );
    }

    @Then("secondary promotional banner section should be displayed in products list page")
    public void secondaryPromotionalBannerSectionShouldBeDisplayedInProductsListPage() {
        Assert.assertTrue(
                browser.eshopWebsite.productsList.isFeaturedBannerSectionDisplayed(),
                "Featured banner section is NOT displayed"
        );
    }

    @Then("at least one secondary banner image should be visible in products list page")
    public void atLeastOneSecondaryBannerImageShouldBeVisibleInProductsListPage() {
        int count = browser.eshopWebsite.productsList.getFeaturedBannerImagesCount();
        Assert.assertTrue(count >= 1, "No featured banner images found");
    }


    @When("scroll down to featured brands section in products list page")
    public void scrollDownToFeaturedBrandsSectionInProductsListPage() {
        browser.eshopWebsite.productsList.scrollToFeaturedBrandsSection();
    }

    @Then("featured brands section should be displayed in products list page")
    public void featuredBrandsSectionShouldBeDisplayedInProductsListPage() {
        Assert.assertTrue(
                browser.eshopWebsite.productsList.isFeaturedBrandsSectionDisplayed(),
                "Featured Brands section is NOT displayed"
        );
    }

    @Then("featured brands list should contain {string} in products list page")
    public void featuredBrandsListShouldContainInProductsListPage(String brandName) {
        Assert.assertTrue(
                browser.eshopWebsite.productsList.isFeaturedBrandDisplayed(brandName),
                "Brand " + brandName + " is NOT displayed in Featured Brands section"
        );
    }

}