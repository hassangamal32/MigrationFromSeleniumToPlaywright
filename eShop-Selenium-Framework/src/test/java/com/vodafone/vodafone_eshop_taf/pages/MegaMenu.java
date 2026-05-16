package com.vodafone.vodafone_eshop_taf.pages;

import com.vodafone.vodafone_eshop_taf.driver.WebDriverHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MegaMenu extends PageBase {

    @FindBy(xpath = "//a[@class='megaMenuItem active']")
    private WebElement shopTab;

    @FindBy(id = "menu_cat10004")
    private WebElement linesTab;

    private final By redTab = By.xpath("//vf-categories-navbar//button[2]/span\n");

    @FindBy(id = "menu_cat10013")
    private WebElement internetServicesTab;

    @FindBy(id = "submenu_cat90021")
    private WebElement dslFromMegaMenu;

    @FindBy(id = "menu_cat240002")
    private WebElement dealsTab;

    @FindBy(id = "submenu_cat90008")
    private WebElement wifiDevicesTab;

    @FindBy(id = "submenu_cat270019")
    private WebElement wirelessNetTab;

    @FindBy(id = "menu_cat10008")
    private WebElement devicesTab;

    @FindBy(id = "submenu_cat10015")
    private WebElement phonesTab;

    @FindBy(id = "submenu_cat10023")
    private WebElement tabletsTab;

    @FindBy(id = "submenu_cat10001")
    private WebElement accessoriesTab;

    @FindBy(id = "item_cat1740003")
    private WebElement gamingTab;

    @FindBy(xpath = "(//a[@class='megaMenuItem'])[1]")
    private WebElement servicesTab;

    @FindBy(xpath = "(//a[@id='menu_undefined'])[1]")
    private WebElement stayOnControlTab;

    @FindBy(xpath = "(//a[@id='submenu_undefined'])[1]")
    private WebElement selfHelpTab;

    @FindBy(xpath = "(//a[@id='submenu_undefined'])[2]")
    private WebElement paymentAndRechargeTab;

    @FindBy(xpath = "(//a[@id='submenu_undefined'])[3]")
    private WebElement mobileRepairTab;

    @FindBy(xpath = "(//a[@id='submenu_undefined'])[4]")
    private WebElement shokranServicesTab;

    @FindBy(xpath = "(//a[@id='menu_undefined'])[2]")
    private WebElement greatEntertainmentTab;

    @FindBy(xpath = "(//a[@id='submenu_undefined'])[5]")
    private WebElement callToneTab;

    @FindBy(xpath = "(//a[@id='submenu_undefined'])[6]")
    private WebElement olhaBesotkTab;

    @FindBy(xpath = "(//a[@id='submenu_undefined'])[7]")
    private WebElement alAhlyWorldTab;

    @FindBy(xpath = "(//a[@id='menu_undefined'])[3]")
    private WebElement callAndConnectAboardTab;

    @FindBy(xpath = "(//a[@id='submenu_undefined'])[8]")
    private WebElement roamingTab;

    @FindBy(xpath = "(//a[@id='submenu_undefined'])[9]")
    private WebElement internationalCallsTab;

    @FindBy(xpath = "(//a[@id='submenu_undefined'])[10]")
    private WebElement visitingEgyptTab;

    @FindBy(xpath = "(//a[@id='menu_undefined'])[4]")
    private WebElement vodafoneCashTab;

    @FindBy(xpath = "(//a[@id='submenu_undefined'])[11]")
    private WebElement onlinePaymentServiceTab;

    @FindBy(xpath = "(//a[@id='submenu_undefined'])[12]")
    private WebElement onlineDonationServiceTab;

    @FindBy(xpath = "(//a[@id='submenu_undefined'])[13]")
    private WebElement vodafoneCashRechargeAndBillPaymentTab;

    @FindBy(xpath = "(//a[@class='megaMenuItem'])[2]")
    private WebElement promotionsTab;

    @FindBy(xpath = "(//a[@id='menu_undefined'])[5]")
    private WebElement allServicesPromotionsTab;

    @FindBy(xpath = "(//a[@id='submenu_undefined'])[14]")
    private WebElement vodafoneFlex365Tab;

    @FindBy(xpath = "(//a[@id='submenu_undefined'])[15]")
    private WebElement careemPromoForRedCustomersTab;

    @FindBy(xpath = "(//a[@id='submenu_undefined'])[16]")
    private WebElement alaamMazzikaTab;

    @FindBy(xpath = "(//ul[@id='navbar-nav-menu-dropdownList'])[1]")
    private WebElement listOfTabsFromShopTab;

    @FindBy(xpath = "(//ul[@id='navbar-nav-menu-dropdownList'])[2]")
    private WebElement listOfTabsFromServicesTab;

    @FindBy(xpath = "(//ul[@id='navbar-nav-menu-dropdownList'])[3]")
    private WebElement listOfTabsFromPromotionsTab;

    @FindBy(xpath = "(//ul[@class='navbar-nav-subDropdownList-option-list navbar-nav-subDropdownList-option'])[1]")
    private WebElement listOfTabsFromPhonesTab;

    @FindBy(xpath = "(//ul[@class='navbar-nav-subDropdownList-option-list navbar-nav-subDropdownList-option'])[2]")
    private WebElement listOfTabsFromLinesTab;

    @FindBy(xpath = "(//ul[@class='navbar-nav-subDropdownList-option-list navbar-nav-subDropdownList-option'])[3]")
    private WebElement listOfTabsFromInternetServicesTab;

    @FindBy(xpath = "(//ul[@class='navbar-nav-subDropdownList-option-list navbar-nav-subDropdownList-option'])[4]")
    private WebElement listOfTabsFromDealsTab;

    @FindBy(xpath = "(//ul[@class='navbar-nav-subDropdownList-option-list navbar-nav-subDropdownList-option'])[5]")
    private WebElement listOfTabsFromStayOnControlTab;

    @FindBy(xpath = "(//ul[@class='navbar-nav-subDropdownList-option-list navbar-nav-subDropdownList-option'])[6]")
    private WebElement listOfTabsFromGreatEntertainmentTab;

    @FindBy(xpath = "(//ul[@class='navbar-nav-subDropdownList-option-list navbar-nav-subDropdownList-option'])[7]")
    private WebElement listOfTabsFromCallAndConnectAbroadTab;

    @FindBy(xpath = "(//ul[@class='navbar-nav-subDropdownList-option-list navbar-nav-subDropdownList-option'])[8]")
    private WebElement listOfTabsFromVodafoneCashTab;

    @FindBy(xpath = "(//ul[@class='navbar-nav-subDropdownList-option-list navbar-nav-subDropdownList-option'])[9]")
    private WebElement listOfTabsFromAllPromotionsServicesTab;



    public WebElement getDslFromMegaMenu(){
        return dslFromMegaMenu;
    }

    public void clickOnLinesTab() {
        wait.until(ExpectedConditions.elementToBeClickable(linesTab));
        linesTab.click();
    }

    public RedLines clickOnRedTab() {
        wait.until(ExpectedConditions.elementToBeClickable (redTab));
        ((JavascriptExecutor) WebDriverHandler.getWebDriver()).executeScript("arguments[0].click();", safeFindElement(redTab));
        return new RedLines();
    }

    public void clickOnShopTab() {
        shopTab.click();
    }

    public void clickOnInternetServicesTab() {
        internetServicesTab.click();
    }



    public void clickOnDealsTab(){dealsTab.click();}

    public void clickOnDevicesTab(){devicesTab.click();}

    public void clickOnServicesTab(){servicesTab.click();}

    public void clickOnStayOnControlTab(){stayOnControlTab.click();}

    public void clickOnSelfHelpTab(){selfHelpTab.click();}

    public void clickOnPaymentAndRechargeTab(){paymentAndRechargeTab.click();}

    public void clickOnRepairMobileTab(){mobileRepairTab.click();}

    public void clickOnShokranServicesTab(){shokranServicesTab.click();}

    public void clickOnGreatEntertainmentTab(){greatEntertainmentTab.click();}

    public void clickOnCallToneTab(){callToneTab.click();}

    public void clickOnOlhaBesotkTab(){olhaBesotkTab.click();}

    public void clickOnAlAhlyWorldTab(){alAhlyWorldTab.click();}

    public void clickOnCallAndConnectAboardTab(){callAndConnectAboardTab.click();}

    public void clickOnRoamingTab(){roamingTab.click();}

    public void clickOnInternationalCallsTab(){internationalCallsTab.click();}

    public void clickOnVisitingEgyptTab(){visitingEgyptTab.click();}

    public void clickOnVodafoneCashTab(){vodafoneCashTab.click();}

    public void clickOnOnlinePaymentServiceTab(){onlinePaymentServiceTab.click();}

    public void clickOnOnlineDonationServiceTab(){onlineDonationServiceTab.click();}

    public void clickOnVodafoneCashRechargeAndBillPaymentTab(){vodafoneCashRechargeAndBillPaymentTab.click();}

    public void clickOnPromotionsTab(){promotionsTab.click();}

    public void clickOnAllServicesPromotionsTab(){allServicesPromotionsTab.click();}

    public void clickOnVodafoneFlex365Tab(){vodafoneFlex365Tab.click();}

    public void clickOnCareemPromoForRedCustomersTab(){careemPromoForRedCustomersTab.click();}

    public void clickOn3alamMazzikaTab(){alaamMazzikaTab.click();}

    public WebElement getListOfTabsFromShopTab(){return listOfTabsFromShopTab;}

    public WebElement getListOfTabsFromServicesTab(){return listOfTabsFromServicesTab;}

    public WebElement getListOfTabsFromPromotionsTab(){return listOfTabsFromPromotionsTab;}

    public WebElement getListOfTabsFromPhonesTab(){return listOfTabsFromPhonesTab;}

    public WebElement getListOfTabsFromLinesTab(){return listOfTabsFromLinesTab;}

    public WebElement getListOfTabsFromInternetServicesTab(){return listOfTabsFromInternetServicesTab;}

    public WebElement getListOfTabsFromDealsTab(){return listOfTabsFromDealsTab;}

    public WebElement getListOfTabsFromStayOnControlTab(){return listOfTabsFromStayOnControlTab;}

    public WebElement getListOfTabsFromGreatEntertainmentTab(){return listOfTabsFromGreatEntertainmentTab;}

    public WebElement getListOfTabsFromCallAndConnectAbroadTab(){return listOfTabsFromCallAndConnectAbroadTab;}

    public WebElement getListOfTabsFromVodafoneCashTab(){return listOfTabsFromVodafoneCashTab;}

    public WebElement getListOfTabsFromAllPromotionsServicesTab(){return listOfTabsFromAllPromotionsServicesTab;}

}
