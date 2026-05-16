package com.vodafone.vodafone_eshop_taf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Header extends PageBase {


    private final By vodafoneLogo = By.id("sl-nav-bar-div-1");

    private final By shoppingCartIcon = By.id("sl-cart-button-1");

    private final By changeLanguageButton = By.id("sl-nav-bar-button-1");

    private final By personalTab = By.id("sl-user-profile-button-1");

    private final By businessTab = By.id("profile-tab");

    private final By loginIcon = By.id("sl-user-profile-button-1");

    private final By searchField = By.id("searchInput");

    private final By searchFieldHeader = By.xpath("//div//p[contains(@class,'header')]");

    private final By showAllResultsButtonInSearch = By.id("searchBtn");

    private final By firstItemDisplayedInSearch = By.id("product-0");

    private final By removeButtonInSearchField = By.id("sl-nav-bar-img=3");

    private final By userName = By.id("sl-user-profile-button-1");

    private final By profileOption = By.id("sl-user-profile-a-1-profile");

    private final By myOrdersOption = By.id("sl-user-profile-a-1-myOrders");



    public Header() {

    }

    public WebElement getSearchField() {
        return safeFindElement(searchField);
    }

    public WebElement getSearchFieldHeader() {
        return safeFindElement(searchFieldHeader);
    }

    public WebElement getVodafoneLogo() throws InterruptedException {
        return safeFindElement(vodafoneLogo);
    }

    public WebElement getShowAllResultsButtonInSearch() {
        return safeFindElement(showAllResultsButtonInSearch);
    }

    public WebElement getRemoveButtonInSearchField() {
        return safeFindElement(removeButtonInSearchField);
    }

    public ProductDetails clickOnFirstItemDisplayedInSearch() {
        safeClick(firstItemDisplayedInSearch);
        return new ProductDetails();
    }

    public Cart clickOnShoppingCartIcon() {
        safeClick(shoppingCartIcon);
        return new Cart();
    }

    public Home clickOnPersonalTab() {
        safeClick(personalTab);
        return new Home();
    }


    public void clickOnVodafoneLogo() throws InterruptedException {
        safeClick(vodafoneLogo);
    }

    public Login clickOnLoginIcon() {
        safeClick(loginIcon);
        return new Login();
    }

    public void switchLanguageTo(String preferredLanguage) {
        if (preferredLanguage.equals("ar")) {
            JavascriptExecutorClick((safeFindElement(changeLanguageButton)));
        }

    }

    public void clickOnUserName() {
        safeClick(userName);
    }

    public MyOrders clickOnMyOrdersOption() {
        safeClick(myOrdersOption);
        return new MyOrders();
    }

    public PersonalDetails clickOnProfileOption() {
        safeClick(profileOption);
        return new PersonalDetails();
    }

}
