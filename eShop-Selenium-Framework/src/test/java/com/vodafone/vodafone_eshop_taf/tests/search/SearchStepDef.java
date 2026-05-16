package com.vodafone.vodafone_eshop_taf.tests.search;

import com.vodafone.vodafone_eshop_taf.tests.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SearchStepDef extends BaseTest {

    @Then("placeholder text  in search field in header section should be {string}")
    public void placeholderTextInSearchFieldInHeaderSectionShouldBe(String textInsideSearchField) {
        Assert.assertEquals(browser.eshopWebsite.header.getSearchField().getAttribute("placeholder"),textInsideSearchField);
    }

    @Then("header section should be {string} in search field")
    public void headerSectionShouldBeInSearchField(String textInsideSearchField) {
        Assert.assertEquals(browser.eshopWebsite.header.getSearchFieldHeader().getAttribute("placeholder"),textInsideSearchField);
    }

    @When("enter {string} in search field in header section")
    public void enterInSearchFieldInHeaderSection(String productName) {
        browser.eshopWebsite.header.getSearchField().sendKeys(productName);
    }
    @When("click on remove button in search field")
    public void clickOnRemoveButtonInSearchField()
    {
        browser.eshopWebsite.Search.clickOnClearSearcch();
    }

    @When("click enter button in keyboard")
    public void clickEnterButtonInKeyboard() {

        browser.eshopWebsite.header.getSearchField().sendKeys(Keys.ENTER);
    }

    @When("click on search field in header section")
    public void clickOnSearchFieldInHeaderSection() {

        browser.eshopWebsite.header.getSearchField().click();
    }

    @Then("search result title in search page should be {string}")
    public void searchResultTitleInSearchPageShouldBe(String searchTitle) {
        Assert.assertTrue(browser.eshopWebsite.Search.getSearchTitleResultText().getText().contains(searchTitle));

    }

    @Then("text in drop down list in search field in header section should be {string}")
    public void textInDropDownListInSearchFieldInHeaderSectionShouldBe(String resultText) {
        String requiredText =
                browser.eshopWebsite.Search.getAutoCompleteText().getText();
        Assert.assertTrue(requiredText.contains(resultText),
                "Expected empty state message to contain: [" + resultText +
                "] but found: [" + requiredText + "]"
        );

    }

    @Then("{string} in search page should be displayed")
    public void inSearchPageShouldBeDisplayed(String searchText) {
        String actualText =
                browser.eshopWebsite.Search.getEmptyStateText().getText();

        Assert.assertTrue(
                actualText.contains(searchText),
                "Expected empty state message to contain: [" + searchText +
                        "] but found: [" + actualText + "]"
        );
    }

    @Then("all products in search page should be {string}")
    public void allProductsInSearchPageShouldBe(String productName) {
        List<WebElement> devicesContainerInSearchPage ;
        for(WebElement element:browser.eshopWebsite.Search.getDevicesContainerInSearchPage())
        {
            Assert.assertTrue(element.getText().contains(productName));
        }
    }

    @Then("remove button in search bar should be disappeared")
    public void removeButtonInSearchBarShouldBeDisappeared() {
        Assert.assertTrue(
                browser.eshopWebsite.Search.isClearSearchButtonHidden(),
                "Remove (clear) button is still visible in the search bar"
        );
    }

}
