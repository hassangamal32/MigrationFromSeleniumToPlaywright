package com.vodafone.vodafone_eshop_taf.tests.filterAndSort;
import com.vodafone.vodafone_eshop_taf.tests.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class FilterAndSortStepDef extends BaseTest {

    @Then("clear filter button should be displayed in products list page")
    public void clearFilterButtonShouldBeDisplayedInProductsListPage() {
        Assert.assertTrue(browser.eshopWebsite.productsList.getClearFilterButton().isDisplayed());
    }

    @Then("reset all filters button should be displayed in products list page")
    public void resetAllFiltersButtonShouldBeDisplayedInProductsListPage() {
        Assert.assertTrue(browser.eshopWebsite.productsList.getResetAllFiltersButton().isDisplayed());
    }

    @Then("sort by default view should be {string} in products list page")
    public void sortByDefaultViewShouldBeInProductsListPage(String defaultOption) {
        Assert.assertEquals(browser.eshopWebsite.productsList.getSortByDefaultOption(),defaultOption);
    }

    @Then("first sort by value should be {string} in products list page")
    public void firstSortByValueShouldBeInProductsListPage(String firstSortBy) {
        Assert.assertEquals(browser.eshopWebsite.productsList.getRecommendedOption().getText(),firstSortBy);
    }

    @Then("second sort by value should be {string} in products list page")
    public void secondSortByValueShouldBeInProductsListPage(String secondSortBy) {
        Assert.assertEquals(browser.eshopWebsite.productsList.getPriceLowToHighOption().getText(),secondSortBy);
    }

    @Then("third sort by value should be {string} in products list page")
    public void thirdSortByValueShouldBeInProductsListPage(String thirdSortBy) {
        Assert.assertEquals(browser.eshopWebsite.productsList.getPriceHighToLowOption().getText(),thirdSortBy);
    }

    @Then("fourth sort by value should be {string} in products list page")
    public void fourthSortByValueShouldBeInProductsListPage(String fourthSortBy) {
        Assert.assertEquals(browser.eshopWebsite.productsList.getDiscountHighToLowOption().getText(),fourthSortBy);
    }

    @Then("fifth sort by value should be {string} in products list page")
    public void fifthSortByValueShouldBeInProductsListPage(String fifthSortBy) {
        Assert.assertEquals(browser.eshopWebsite.productsList.getBestRatedOption().getText(),fifthSortBy);
    }

    @When("expand category filter drop down in products list page")
    public void expandCategoryFilterDropDownInProductsListPage() throws InterruptedException {
        Thread.sleep(5000);
        browser.eshopWebsite.productsList.expandCategoryFilterDropDown();
    }

    @When("expand category title drop down {string} if needed {string} in products list page")
    public void expandCategoryTitleDropDownIfNeededInProductsListPage(String categoryTitle, String flag) {
        if(flag.equalsIgnoreCase("yes")){
            browser.eshopWebsite.productsList.expandCategoryTitleDropDown(categoryTitle);
        }
    }

    @When("enable the category {string} checkbox in products list page")
    public void enableTheCategoryCheckboxInProductsListPage(String categoryName) {
        browser.eshopWebsite.productsList.enableCategoryCheckBox(categoryName);
    }

    @Then("results should be filtered by {string} in products list page")
    public void resultsShouldBeFilteredByInProductsListPage(String filterName) {
        Assert.assertEquals(browser.eshopWebsite.productsList.getResultAfterFilter(),filterName);
    }

    @When("expand brand filter drop down in products list page")
    public void expandBrandFilterDropDownInProductsListPage() throws InterruptedException {
        Thread.sleep(5000);
        browser.eshopWebsite.productsList.expandBrandFilterDropDown();
    }

    @When("enable the brand {string} checkbox in products list page")
    public void enableTheBrandCheckboxInProductsListPage(String brandName) {
        browser.eshopWebsite.productsList.enableBrandCheckBox(brandName);
    }

    @Then("the brand filter {string} should be active in products list page")
    public void theBrandFilterShouldBeActiveInProductsListPage(String brandName) {
        Assert.assertTrue(browser.eshopWebsite.productsList.checkIfBrandFilterActive(brandName));
    }


    @When("expand price filter drop down in products list page")
    public void expandPriceFilterDropDownInProductsListPage() throws InterruptedException {
        Thread.sleep(5000);
        browser.eshopWebsite.productsList.expandPriceFilterDropDown();
    }

    @When("enable the price {string} checkbox in products list page")
    public void enableThePriceCheckboxInProductsListPage(String priceFilterOption) {
        browser.eshopWebsite.productsList.enablePriceFilterCheckBox(priceFilterOption);
    }

    @Then("first item price should be {string}")
    public void firstItemPriceShouldBe(String priceFilterOption) {
        Assert.assertTrue(browser.eshopWebsite.productsList.checkIfFirstItemPriceMatchTheFilter(priceFilterOption));
    }

    @When("enter minimum value {string} for price filter in products list page")
    public void enterMinimumValueForPriceFilterInProductsListPage(String min) {
        browser.eshopWebsite.productsList.setMinimumPrice(min);
    }

    @When("enter maximum value {string} for price filter in products list page")
    public void enterMaximumValueForPriceFilterInProductsListPage(String max) {
        browser.eshopWebsite.productsList.setMaximumPrice(max);
    }

    @When("click on apply button for price filter in products list page")
    public void clickOnApplyButtonForPriceFilterInProductsListPage() {
        browser.eshopWebsite.productsList.clickOnApplyFilterButton();
    }

    @Then("first item price should be between min {} and max {} in products list page")
    public void firstItemPriceShouldBeBetweenMinAndMaxInProductsListPage(int min, int max) {
        Assert.assertTrue(browser.eshopWebsite.productsList.checkIfFirstItemPriceMatchTheCustomFilterValues(min,max));
    }

    @When("expand sort by drop down menu in products list page")
    public void expandSortByDropDownMenuInProductsListPage() {
        browser.eshopWebsite.productsList.expandSortByDropDownMenu();
    }

    @When("select sort by price low to high in products list page")
    public void selectSortByPriceLowToHighInProductsListPage() {
        browser.eshopWebsite.productsList.selectSortByPriceLowToHighOption();
    }

    @Then("first item price should be less than or equal second item price in products list page")
    public void firstItemPriceShouldBeLessThanOrEqualSecondItemPriceInProductsListPage() {
        int compareResult = browser.eshopWebsite.productsList.compareFirstAndSecondItemsPrices();
        Assert.assertTrue(compareResult <= 0);
    }

    @When("select sort by price high to low in products list page")
    public void selectSortByPriceHighToLowInProductsListPage() {
        browser.eshopWebsite.productsList.selectSortByPriceHighToLowOption();
    }

    @Then("first item price should be greater than or equal second item price in products list page")
    public void firstItemPriceShouldBeGreaterThanOrEqualSecondItemPriceInProductsListPage() {
        int compareResult = browser.eshopWebsite.productsList.compareFirstAndSecondItemsPrices();
        Assert.assertTrue(compareResult >= 0);
    }

    @When("select sort by discount high to low in products list page")
    public void selectSortByDiscountHighToLowInProductsListPage() {
        browser.eshopWebsite.productsList.selectSortByDiscountHighToLowOption();
    }

    @When("first item discount should be greater than or equal second item discount in products list page")
    public void firstItemDiscountShouldBeGreaterThanOrEqualSecondItemDiscountInProductsListPage() {
        int compareResult = browser.eshopWebsite.productsList.compareFirstAndSecondItemsDiscounts();
        Assert.assertTrue(compareResult >= 0);
    }

    @When("select sort by best rated in products list page")
    public void selectSortByBestRatedInProductsListPage() {
        browser.eshopWebsite.productsList.selectSortByBestRatedOption();
    }

    @Then("first item rate should be greater than or equal second item rate in products list page")
    public void firstItemRateShouldBeGreaterThanOrEqualSecondItemRateInProductsListPage() {
        int compareResult = browser.eshopWebsite.productsList.compareFirstAndSecondItemsRates();
        Assert.assertTrue(compareResult == 0 || compareResult == 1);
    }



    @When("click on first product in stock")
    public void clickOnFirstProductInStock(){
        browser.eshopWebsite.productsList.clickOnFirstInStockProduct();
    }

}
