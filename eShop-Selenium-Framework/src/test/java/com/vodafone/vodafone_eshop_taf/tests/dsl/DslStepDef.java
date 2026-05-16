package com.vodafone.vodafone_eshop_taf.tests.dsl;

import com.vodafone.vodafone_eshop_taf.tests.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class DslStepDef extends BaseTest {
    @When("click on dsl in mega menu")
    public void clickOnDslInMegaMenu() {
        browser.eshopWebsite.home.megaMenu.getDslFromMegaMenu().click();
    }

    @Then("dsl title in dsl page should be {string}")
    public void dslTitleInDslPageShouldBe(String dslTitle){
        Assert.assertEquals(browser.eshopWebsite.dsl.getDslTitle().getText(),dslTitle);
    }

    @Then("Dsl subtitle in dsl page should be displayed")
    public void dslSubtitleInDslPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.dsl.getDslSubtilte().isDisplayed());
    }

    @When("click on subscribe button in dsl page")
    public void clickOnSubscribeButtonInDslPage() throws InterruptedException {
        Thread.sleep(3000);
        browser.eshopWebsite.dsl.clickOnSubscribeButton();
        Thread.sleep(3000);
    }

    @Then("first bundle name in dsl bundles page should be {string}")
    public void bundleNameInDslBundlesPageShouldBe(String firstbundleName) {
        Assert.assertEquals(browser.eshopWebsite.dsl.getFirstBundleName().getText(),firstbundleName);
    }

    @When("click on select button in first bundle section in dsl bundles page")
    public void clickOnSelectButtonInFirstBundleSectionInDslBundlesPage() {
        browser.eshopWebsite.dsl.clickOnFirstBundleSelectButton();
    }

    @Then("router name in dsl devices page should be {string}")
    public void routerNameInDslDevicesPageShouldBe(String routerName) {
        Assert.assertEquals(browser.eshopWebsite.dsl.getRouterName().getText(),routerName);
    }

    @When("click on cash button in router section in dsl devices page")
    public void clickOnCashButtonInRouterSectionInDslDevicesPage() {
        browser.eshopWebsite.dsl.clickOnCashButton();
    }

    @When("enter {string} in subscription details page")
    public void enterLandlineNumberInSubscriptionDetailsPageWith(String landline) {
        browser.eshopWebsite.dsl.enterLandlineNumber(landline);
    }

    @When("click on continue button in dsl subscription details page")
    public void clickOnContinueButtonInDslSubscriptionDetailsPage() {
        browser.eshopWebsite.dsl.clickOnContinueButton();
    }

    @Then("cash label in router section in dsl checkout page should be displayed")
    public void cashLabelInRouterSectionInDslCheckoutPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.dsl.getCashLabel().isDisplayed());
    }

    @When("click on rent button in router section in dsl devices page")
    public void clickOnRentButtonInRouterSectionInDslDevicesPage() {
        browser.eshopWebsite.dsl.clickOnRentButton();
    }

    @Then("rent label in router section in dsl checkout page should be displayed")
    public void rentLabelInRouterSectionInDslCheckoutPageShouldBeDisplayed(){
        Assert.assertTrue(browser.eshopWebsite.dsl.getRentLabel().isDisplayed());
    }

    @When("click on edit subscription details button in router section in dsl checkout page")
    public void clickOnEditSubscriptionDetailsButtonInRouterSectionInDslCheckoutPage() {
        browser.eshopWebsite.dsl.clickOnEditSubscriptionDetailsButtonInRouterSection();
    }

    @Then("landline number in dsl checkout page should be edited to {string}")
    public void landlineNumberInDslCheckoutPageShouldBeEditedTo(String landlineNumber) {
        Assert.assertEquals(browser.eshopWebsite.dsl.getLandlineNumberText(),landlineNumber);

    }

    @When("click on submit button in dsl checkout page")
    public void clickOnSubmitButtonInDslCheckoutPage() {
        browser.eshopWebsite.dsl.clickOnSubmitButton();
    }

    @Then("success overlay should be displayed")
    public void successOverlayShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.dsl.getSuccessOverlayTitle().isDisplayed());
    }

    @Then("subscribe button in dsl page should be displayed")
    public void subscribeButtonInDslPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.dsl.getSubscribeButton().isDisplayed());
    }

    @Then("dsl info message in dsl page should be {string}")
    public void dslInfoMessageInDslPageShouldBe(String dslInfo) {
        Assert.assertEquals(browser.eshopWebsite.dsl.getDslInfoMessage().getText(),dslInfo);
    }

    @Then("first bundle price in dsl page should be {string}")
    public void firstBundlePriceInDslPageShouldBe(String firstbundlePrice) {
        Assert.assertEquals(browser.eshopWebsite.dsl.getFirstBundlePrice().getText(),firstbundlePrice);
    }

    @Then("first bundle select button in dsl page should be displayed")
    public void firstBundleSelectButtonInDslPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.dsl.getFirstBundleSelectButton().isDisplayed());
    }

    @Then("default tab of speed should be {string}")
    public void defaultTabOfSpeedShouldBe(String defaultTab) {
        Assert.assertEquals(browser.eshopWebsite.dsl.getDefaultTabOfSpeed().getText(),defaultTab);
    }

    @Then("second bundle name in dsl bundles page should be {string}")
    public void secondBundleNameInDslBundlesPageShouldBe(String secondBundleName) {
        Assert.assertEquals(browser.eshopWebsite.dsl.getSecondBundleName().getText(),secondBundleName);
    }

    @Then("third bundle name in dsl bundles page should be {string}")
    public void thirdBundleNameInDslBundlesPageShouldBe(String thirdBundleName) {
        Assert.assertEquals(browser.eshopWebsite.dsl.getThirdBundleName().getText(),thirdBundleName);
    }

    @Then("fourth bundle name in dsl bundles page should be {string}")
    public void fourthBundleNameInDslBundlesPageShouldBe(String fourthBundleName) {
        Assert.assertEquals(browser.eshopWebsite.dsl.getFourthBundleName().getText(),fourthBundleName);
    }

    @Then("terms and conditions button in dsl page should be {string}")
    public void termsAndConditionsButtonInDslPageShouldBe(String termsAndConditions) {
        Assert.assertEquals(browser.eshopWebsite.dsl.getTermsAndConditionsButton().getText(),termsAndConditions);
    }

    @Then("dsl bundles stepper in dsl bundles page should be displayed")
    public void dslBundlesStepperInDslBundlesPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.dsl.getDslBundlesStepper().isDisplayed());
    }

    @When("add new address in dsl page")
    public void addNewAddressInDslPage(){
        browser.eshopWebsite.dsl.clickOnNewAddressDslButton();
    }

    @When("enter governorate {string} and district {string} and street name {string} in your address in dsl page")
    public void enterGovernorateAndDistrictAndStreetNameAndAndInYourAddressInDslPage(String governorateDropDown , String districtDropDown , String streetname) throws InterruptedException {
        Thread.sleep(3000);
        browser.eshopWebsite.dsl.selectGovernorateFromNameDropDownList(governorateDropDown);
        browser.eshopWebsite.dsl.selectDistrictFromNameDropDownList(districtDropDown);
        browser.eshopWebsite.dsl.enterStreetNameTextField(streetname);
    }
    @When("enter building no {string} and floor no {string} and apartment no {string} in your address in dsl page")
    public void enterBuildingNoAndFloorNoAndApartmentNoInYourAddressInDslPage(String buildingno , String floorno , String apartmentno){
        browser.eshopWebsite.dsl.enterBuildingNoTextField(buildingno);
        browser.eshopWebsite.dsl.enterFloorNoTextField(floorno);
        browser.eshopWebsite.dsl.enterApartmentNoTextField(apartmentno);
    }

    @When("enter fullname {string} phone number {string} and landline number {string} in dsl page")
    public void enterLandLineNumberInDslPage(String fullname, String phone , String landline) throws InterruptedException {
        browser.eshopWebsite.dsl.enterFullNameTextField(fullname);
        browser.eshopWebsite.dsl.enterPhoneNumberTextField(ratePlans.getProperty(phone));
        browser.eshopWebsite.dsl.enterLandLineNumber(landline);
    }
    @When("click on login button in dsl Page")
    public void clickOnLoginButtonInDslPage(){
        browser.eshopWebsite.dsl.clickOnLoginButtonInDslPage();
    }

    @When("click on saved address in dsl page")
    public void clickOnSavedAddressInDslPage() throws InterruptedException {
        browser.eshopWebsite.dsl.clickOnSavedAddressButton();
        Thread.sleep(3000);
    }

    @Then("dsl bundles title in dsl bundles page should be {string}")
    public void dslBundlesTitleInDslBundlesPageShouldBe(String dslBundlesTitle) {
        Assert.assertEquals(browser.eshopWebsite.dsl.getDslBundlesTitle().getText(),dslBundlesTitle);
    }

    @Then("dsl bundles subtitle in dsl bundles page should be displayed")
    public void dslBundlesSubtitleInDslBundlesPageShouldBeDisplayed() {
        Assert.assertTrue(browser.eshopWebsite.dsl.getDslBundlesSubtitle().isDisplayed());
    }

    @When("click on select button in choose your router page in dsl page")
    public void clickOnSelectButtonInChooseYourRouterPageInDslPage() {
        browser.eshopWebsite.dsl.clickOnSelectButtonInChooseYourRouter();
    }
}
