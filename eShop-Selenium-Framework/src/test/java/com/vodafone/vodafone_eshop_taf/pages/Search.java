package com.vodafone.vodafone_eshop_taf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Search extends PageBase {


    private final By searchTitleResultText = By.xpath("//div[contains(@class,'results')]//strong");

    private final By searchEmptyStateText = By.className("empty-data");

    private final By clearSearch=By.xpath("//div[contains(@class,'header')]//p[contains(@class,'clear')]");

    private final By autoCompleteText=By.xpath("//div[contains(@class,'product-result')][1]");

    private final By devicesContainerInSearchPage=By.className("product-cards");

    public WebElement getSearchTitleResultText() {
        return safeFindElement(searchTitleResultText);
    }

    public WebElement getClearSearch() {
        return safeFindElement(clearSearch);
    }

    public void clickOnClearSearcch() {
        safeFindElement(clearSearch).click();
    }

    public WebElement getAutoCompleteText() {
        return safeFindElement(autoCompleteText);
    }

    public List<WebElement> getDevicesContainerInSearchPage() {
        return safeFindElements(devicesContainerInSearchPage);
    }

    public WebElement getEmptyStateText() {
        return safeFindElement(searchEmptyStateText);
    }

    public boolean isClearSearchButtonHidden() {
        return safeFindElements(clearSearch).isEmpty();
    }

}
