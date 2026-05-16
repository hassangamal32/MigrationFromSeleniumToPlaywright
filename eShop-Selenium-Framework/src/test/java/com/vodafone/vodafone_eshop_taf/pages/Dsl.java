package com.vodafone.vodafone_eshop_taf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dsl extends PageBase {

    private final By chooseYourPackageCard = By.xpath("//div[@class='dslTabs-container']");

    private final By dslPageHeader = By.xpath("/html/body/app-root/app-dsl/div/div/div[2]/h2");

    private final By landLineFieldForDsl = By.xpath("//input[@formcontrolname='landline']");

    private final By dslTitle = By.xpath("//p[@class='intro-head fontLight']");

    private final By dslSubtitle = By.xpath("//p[@class='intro-text fontReg']");

    private final By subscribeButton = By.xpath("//button//span[@class='text fontLight']");

    private final By dslInfoMessage = By.xpath("//p[contains(text(),'You can only have one active request at a time') or contains(text(),'لا يمكنك ارسال اكثر من طلب اشتراك واحد')]");

    private final By firstBundleName = By.xpath("(//h4/span)[1]");

    private final By secondBundleName = By.xpath("(//h4/span)[3]");

    private final By thirdBundleName = By.xpath("(//h4/span)[5]");

    private final By fourthBundleName = By.xpath("(//h4/span)[7]");

    private final By firstBundlePrice = By.xpath("//span[@class='offer']");

    private final By firstBundleSelectButton = By.xpath("(//button[@class='card-bundle-action-select-btn'])[1]");

    private final By routerName = By.xpath("//h5[text()='VDSL Plus router']");

    private final By cashButton= By.xpath("//button[normalize-space()='Cash' or normalize-space()='شراء']");

    private final By rentButton= By.xpath("//button[normalize-space()='Rent' or normalize-space()='ايجار']");

    private final By continueButton= By.xpath("//button[normalize-space()='Continue' or normalize-space()='استمرار']");

    private final By cashLabel= By.xpath("//div[normalize-space()='Cash' or normalize-space()='شراء']");

    private final By rentLabel= By.xpath("//div[normalize-space()='Rent' or normalize-space()='ايجار']");

    private final By editSubscriptionDetailsButtonInRouterSection= By.xpath("(//div[@class='card-content-edit']/button)[1]");

    private final By landlineNumber= By.xpath("//p[@class='number' and contains(text(), '02 11111111')]");

    private final By submitButton= By.xpath("//button[@class='btn btn-primary']");

    private final By successOverlayTitle= By.xpath("//span[contains(text(), 'Request submitted')]");

    private final By defaultTabOfSpeed= By.xpath("//button[normalize-space()='up to 30 Mbps' or normalize-space()='تصل الى 30 ميجا']");

    private final By termsAndConditionsButton=By.xpath(("//div[@class='custom-accordion-header']//h3"));

    private final By dslBundlesStepper= By.xpath("//div[@class='stepper']");

    private final By dslBundlesTitle= By.xpath("//p[normalize-space()='Vodafone DSL Home Internet' or normalize-space()='الانترنت المنزلي فودافون DSL']");

    private final By dslBundlesSubtitle= By.xpath("//div[@class='dsl-bundles-container']//p[contains(@class,'bodyFont')]");

    private final By newAddressDslButton = By.xpath("//button[@class='new-address-btn']");

    private final By governorateDropDown = By.xpath("//form//select[@formcontrolname='selectedCity']");
    private final By districtDropDown = By.xpath("//select[@formcontrolname='selectedDistrict']");
    private final By streetNameField = By.xpath("//input[@formcontrolname='streetName']");
    private final By buildingNoField = By.xpath("//input[@formcontrolname='buildingNo']");
    private final By floorNoField = By.xpath("//input[@formcontrolname='floorNo']");
    private final By apartmentNoField = By.xpath("//input[@formcontrolname='apartmentNo']");
    private final By loginButtonDslPage = By.xpath("//p//button[@class='login-btn']");
    private final By saveAddressButton = By.xpath("//button[normalize-space()='Save address' or normalize-space()='تاكيد العنوان']");
    private final By fullNameField = By.xpath("//input[contains(@formcontrolname,'fullName')]");
    private final By phoneNumberField = By.xpath("//input[contains(@formcontrolname,'phone')]");
    private final By landLineNumberField = By.xpath("//input[@formcontrolname='landline']");
    private final By selectButtonInChooseYourRouter = By.xpath("//div[@class='device-select-btn']//button");


    public void selectGovernorateFromNameDropDownList(String governorateDropDown) throws InterruptedException {
        Select selectOptions = new Select(getGovernorateDropDownMenu(governorateDropDown));
        selectOptions.selectByVisibleText(governorateDropDown);
    }

    public void selectDistrictFromNameDropDownList(String districtDropDown) {
        Select selectOptions = new Select(getDistrictDropDownMenu(districtDropDown));
        selectOptions.selectByVisibleText(districtDropDown);
    }

    public void enterStreetNameTextField(String streetname) {
        getStreetNameTextField().sendKeys(streetname);
    }

    public void enterBuildingNoTextField(String buildingno) {
        getBuildingNoTextField().sendKeys(buildingno);
    }

    public void enterFloorNoTextField(String floorno) {
        enterFloorNoTextField().sendKeys(floorno);
    }

    public void enterApartmentNoTextField(String apartmentno) {
        enterApartmentNoTextField().sendKeys(apartmentno);
    }

    public void enterLandLineNumber(String landlinenumber) {
        enterLandLineNoTextField().sendKeys(landlinenumber);
    }

    public void enterFullNameTextField(String fullname) {
        enterFullNameTextField().sendKeys(fullname);
    }

    public void enterPhoneNumberTextField(String phone) {
        enterPhoneNumberTextField().sendKeys(phone);
    }

    public void clickOnSavedAddressButton() {
        JavascriptExecutorClick(safeFindElement(saveAddressButton));
    }

    public void clickOnLoginButtonInDslPage() {
        JavascriptExecutorClick(safeFindElement(loginButtonDslPage));
    }

    public WebElement getDslPageHeader() {
        return safeFindElement(dslPageHeader);
    }

    public WebElement getDslBundlesTitle() {
        return safeFindElement(dslBundlesTitle);
    }

    public WebElement getDslBundlesStepper() {
        return safeFindElement(dslBundlesStepper);
    }

    public WebElement getDslBundlesSubtitle() {
        return safeFindElement(dslBundlesSubtitle);
    }

    public WebElement getDslTitle() {
        return safeFindElement(dslTitle);
    }

    public WebElement getDslSubtilte() {
        return safeFindElement(dslSubtitle);
    }

    public WebElement getDslInfoMessage() {
        return safeFindElement(dslInfoMessage);
    }

    public WebElement getFirstBundleName() {
        return safeFindElement(firstBundleName);
    }

    public WebElement getSecondBundleName() {
        return safeFindElement(secondBundleName);
    }

    public WebElement getThirdBundleName() {
        return safeFindElement(thirdBundleName);
    }

    public WebElement getFourthBundleName() {
        return safeFindElement(fourthBundleName);
    }

    public WebElement getFirstBundlePrice() {
        return safeFindElement(firstBundlePrice);
    }

    public WebElement getRouterName() {
        return safeFindElement(routerName);
    }

    public WebElement getSubscribeButton() {
        return safeFindElement(subscribeButton);
    }

    public WebElement getFirstBundleSelectButton() {
        return safeFindElement(firstBundleSelectButton);
    }

    public WebElement getDefaultTabOfSpeed() {
        return safeFindElement(defaultTabOfSpeed);
    }

    public WebElement getChooseYourPackageCard() {
        return safeFindElement(chooseYourPackageCard);
    }

    public WebElement getCashLabel() {
        return safeFindElement(cashLabel);
    }

    public WebElement getRentLabel() {
        return safeFindElement(rentLabel);
    }

    public WebElement getLandlineNumber() {
        return safeFindElement(landlineNumber);
    }
    public String getLandlineNumberText() {
        return splitElementBySpace(getLandlineNumber().getText());
    }

    public WebElement getSuccessOverlayTitle() {
        return safeFindElement(successOverlayTitle);
    }

    public WebElement getTermsAndConditionsButton() {
        return safeFindElement(termsAndConditionsButton);
    }

    public WebElement getNewAddressDslButton() {
        return safeFindElement(newAddressDslButton);
    }

    public WebElement getGovernorateDropDownMenu(String governorateDropDown) {
        return safeFindElement(this.governorateDropDown);
    }

    public WebElement getDistrictDropDownMenu(String districtDropDown) {
        return safeFindElement(this.districtDropDown);
    }

    public WebElement getStreetNameTextField() {
        return safeFindElement(streetNameField);
    }

    public WebElement getBuildingNoTextField() {
        return safeFindElement(buildingNoField);
    }

    public WebElement enterFloorNoTextField() {
        return safeFindElement(floorNoField);
    }

    public WebElement enterApartmentNoTextField() {
        return safeFindElement(apartmentNoField);
    }

    public WebElement enterFullNameTextField() {
        return safeFindElement(fullNameField);
    }

    public WebElement enterPhoneNumberTextField() {
        return safeFindElement(phoneNumberField);
    }

    public WebElement enterLandLineNoTextField() {
        return safeFindElement(landLineNumberField);
    }


    public void clickOnSubscribeButton() {
        JavascriptExecutorClick(safeFindElement(subscribeButton));
    }

    public void clickOnFirstBundleSelectButton() {
        JavascriptExecutorClick(safeFindElement(firstBundleSelectButton));
    }

    public void clickOnCashButton() {
        JavascriptExecutorClick(safeFindElement(cashButton));
    }

    public void clickOnRentButton() {
        JavascriptExecutorClick(safeFindElement(rentButton));
    }

    public void enterLandlineNumber(String landline) {
        safeFindElement(landLineFieldForDsl).sendKeys(landline);
    }

    public void clickOnContinueButton() {
        JavascriptExecutorClick(safeFindElement(continueButton));
    }

    public void clickOnEditSubscriptionDetailsButtonInRouterSection() {
        JavascriptExecutorClick(safeFindElement(editSubscriptionDetailsButtonInRouterSection));
    }

    public void clickOnSubmitButton() {
        JavascriptExecutorClick(safeFindElement(submitButton));
    }

    public void clickOnNewAddressDslButton() {
        JavascriptExecutorClick(safeFindElement(newAddressDslButton));
    }

    public void clickOnSelectButtonInChooseYourRouter() {
        JavascriptExecutorClick(safeFindElement(selectButtonInChooseYourRouter));
    }


}
