package com.vodafone.vodafone_eshop_taf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ProductDetails extends PageBase {

    private final By productStatusText = By.xpath("//p[@class='fnt-size-18']/i");
    private final By addToCartButton = By.xpath("(//button[contains(@class,'add-to-cart')])[2]");
    private final By buyNowButton = By.xpath("(//button[contains(@class,'buy-now')])[2]");
    private final By productNameText = By.xpath("/html/body/vf-root/main/section[2]/vf-middleware/vf-product-details-page/div[2]/div/div/div[1]/div[4]/div[1]/p");
    private final By secondProductNameText = By.xpath("/html/body/vf-root/main/section[2]/vf-product-page/section/section[1]/div[1]/div[2]/div[1]/div[2]");
    private final By productColorText = By.className("productDetailsSwitcher-controllers");
    private final By productCapacityText = By.id("storageTxt");
    private final By paymentOptionsTab = By.cssSelector("body > app-root > app-product-details > div > div.productDetails > div > div.productDetails-paymentOptions > div > ul > li.nav-item.nav-item-tab.nav-item-active > a");
    private final By calculatePointsTab = By.xpath("//a[@class='nav-link nav-payment fontLightArRegEN']");
    private final By youNeedToLoginAlertInCalculatePointsSection = By.cssSelector("#menu1 > app-alert > div > div > div > div.alert-caption-alertText.checkoutAlertText");
    private final By productPrice = By.xpath("//div[@class='--after-price']");
    private final By productPriceWith24MonthsInterest = By.xpath("/html/body/vf-root/main/section[2]/vf-product-page/section/section[1]/div[1]/div[2]/div[3]/vf-price-installments/div/div/div");
    private final By copyLinkIcon = By.xpath("(//i[@class='fas fa-link'])[1]");
    private final By specificationsTab = By.xpath("(//vf-info-accordion)[2]");
    private final By youCanGetThisProductTitle = By.xpath("//div[@class='mrg-bottom']/p");
    private final By stayInControlHeaderText = By.xpath("//div[@class='phoneDetails-dataContainer-text']/p");
    private final By for6Months0InterestText = By.cssSelector("#menu > div > div.col-sm-6.installments-price-halfyear.installments-price-container > p");
    private final By for12Months0InterestText = By.cssSelector("#menu > div > div.col-sm-6.installments-price-fullyear.installments-price-container > p");
    private final By productImageInFooter = By.cssSelector("#toaster > div > div.col-md-4.toasterHead > img");
    private final By productPriceInFooter = By.cssSelector("#toaster > div > div.col-lg-4.col-md-5.toasterBody > div > div.col-6.fontRegBold.toasterBody-first > span.total-toasterDeskTop");
    private final By productPriceFor6Months0InterestInFooter = By.cssSelector("#toaster > div > div.col-lg-4.col-md-5.toasterBody > div > div.col-6.toasterBody-sec > span:nth-child(1)");




    private final By compareCheckbox = By.id("compare");
    private final By TermsAndConditionsTabInProductDetails = By.xpath("//*[@id=\"ngb-panel-0-header\"]/button");
    private final By specificationsSectionButton = By.className("accordion-button");
    private final By specificationsSectionTitleText = By.xpath("/html/body/vf-root/main/section[2]/vf-product-page/section/section[2]/ngb-accordion[1]/div/div/button");
    private final By productTitleInProductDeatilsPageText =By.xpath("/html/body/vf-root/main/section[2]/vf-product-page/section/section[1]/div[1]/div[1]/div[1]/div[2]");
    private final By specificationsSectionBodyText = By.xpath("(//vf-info-accordion)[2]//vf-product-specifications");
    private final By termsSectionTitle= By.xpath("//*[@id=\"ngb-panel-1-header\"]/button");
    private final By termsSectionButton=By.xpath("/html/body/vf-root/main/section[2]/vf-product-page/section/section[2]/vf-accordion[1]/ngb-accordion/div/div/button");
    private final By termsSectionBody = By.xpath("(//vf-info-accordion)[3]//vf-accordion-body-item");
    private final By termsSectionContactUs = By.xpath("/html/body/vf-root/main/section[2]/vf-product-page/section/section[2]/vf-accordion[1]/ngb-accordion/div/div[2]/div/div/p[2]");
    private final By productColor= By.xpath("//vf-color-variants-box");
    private final By productImage= By.xpath("//img[@class='main-image']");
    private final By productStorage=By.xpath("//vf-generic-variant-box");
        private final By productInstallementSectionHeader=By.xpath("/html/body/vf-root/main/section[2]/vf-product-page/section/section[1]/div[1]/div[2]");
    private final By productPriceInProductDetailsPage = By.xpath("//div[@class=\"--after-price\"]");
    private final By addToCartButtonInProductDetailsPage = By.className("add-to-cart");
    private final By clickOnAddToCompareCheckBoxInProductDetailsPage = By.xpath("/html/body/vf-root/main/section[2]/vf-product-page/section/section[1]/div[2]/div/div/input");
    private final By compareSectionInProductPageDetails= By.xpath("/html/body/vf-root/main/div");
    private final By paymentCardContent= By.className("payment-methods-container");
    private final By cibBankIcon=By.xpath("//div[@class='installments']//div[1]//img");
    private final By ahlyBankIcon= By.xpath("/html/body/vf-root/main/section[2]/vf-product-page/section/section[1]/div[1]/div[2]/vf-payment-methods/div/div[2]/div[2]/img");
    private final By misrBankIcon=By.xpath("//div[@class='installments']//div[2]//img");
    private final By valuIcon =By.xpath("/html/body/vf-root/main/section[2]/vf-product-page/section/section[1]/div[1]/div[2]/vf-payment-methods/div/div[2]/div[8]/img");
    private final By SouhoolaIcon=By.xpath("/html/body/vf-root/main/section[2]/vf-product-page/section/section[1]/div[1]/div[2]/vf-payment-methods/div/div[2]/div[4]/img");
    private final By ForsaIcon=By.xpath("/html/body/vf-root/main/section[2]/vf-middleware/vf-product-details-page/div[2]/div/div/div[1]/div[4]/div[10]/div[2]/div[6]");
    private final By compareButton=By.xpath("(//div[@class='container-box ng-star-inserted']//button)[1]");
    private final By clearCompareButton=By.xpath("(//div[@class='mobile-compare-buttons']//button)[2]");

    private final By productTitle = By.xpath("//vf-product-main-info//h1");
    private final By productInstallmentPrice = By.xpath("//vf-price-installments//p[@class='installment']");
    private final By termsAndConditionsTab = By.xpath("(//vf-info-accordion)[3]");
    private final By productInstallmentSectionHeader =By.xpath("//vf-payment-methods//div[@class='sub-section-header']//h3");
    private final By monthlyInstallmentsPlansSection= By.xpath("//vf-payment-methods//div[@class='payment-methods-header']");
    private final By installmentsPlans= By.xpath("//div[@class='installment-name ng-star-inserted']//div[@class='installments']");
    private final By bnplInstallmentsTab=By.xpath("//div[contains(@class,'installment-type bnpl')]");
    private final By sevenIcon =By.xpath("//div[@class='installments']//div[1]//img");
    private final By amanIcon =By.xpath("//div[@class='installments']//div[2]//img");

    private final By compareSection= By.xpath("//div[@class='container-box ng-star-inserted']");

    private final By insuranceSectionTitle = By.xpath("//h2[@class='section-title']");
    private By addInsuranceButton = By.xpath("(//input[@name='insurance'])[#]");
    private By insuranceOptionTitle = By.xpath("(//h3[@class='card-title'])[#]");
    private By insuranceDetailsButton = By.xpath("(//div[@class='card-title-container']//img)[#]");

    private final By tradeInSection = By.xpath("//vf-trade-in");
    private final By tradeInButton = By.xpath("//div[@class='--trade-in-container']");

    private final By notifyMeButton = addToCartButton;
    private final By notifyMePopup = By.xpath("//section//div[@class='notify-box']");
    private final By confirmButtonInNotifyMePopup = By.xpath("//button[@class='confirm-btn']");
    private static final By recommendedForYouSection = By.xpath("//section[.//h3[normalize-space()='Recommended For You']]");
    private static final By recommendedForYouSkusContainer = By.cssSelector("div.skus-container");
    private static final By recommendedForYouProductCards = By.cssSelector("vf-product-card");

    private By paymentPartnerIcon = By.xpath("//div//img[contains(@src,'paymentPartner')]");
    private final By learnMoreButtonInIstallmentsPlansWindow = By.xpath("//button[contains(@class,'learn-more-btn')]");

    public WebElement getProductStatusText() {
        return safeFindElement(productStatusText);
    }

    public WebElement getProductNameText() {
        return safeFindElement(productNameText);
    }

    public WebElement getProductTitle() {
        return safeFindElement(productTitle);
    }

    public WebElement getProductColorText() {
        return safeFindElement(productColorText);
    }

    public WebElement getProductCapacity() {
        return safeFindElement(productCapacityText);
    }

    public String getProductCapacityText() {
        return splitAmountOfElementText(getProductCapacity());
    }

    public WebElement getAddToCartButton() {
        return safeFindElement(addToCartButton);
    }

    public WebElement getBuyNowButton() {
        return safeFindElement(buyNowButton);
    }

    public WebElement getPaymentOptionsTab() {
        return safeFindElement(paymentOptionsTab);
    }

    public WebElement getYouNeedToLoginAlertInCalculatePointsSection() {
        return safeFindElement(youNeedToLoginAlertInCalculatePointsSection);
    }

    public WebElement getProductPrice() {
        return safeFindElement(productPrice);
    }

    public Double getProductPriceText() {
        return Double.valueOf(extractNumericValueFromText(getProductPrice()));

    }

    public WebElement getProductInstallmentPrice() {
        return safeFindElement(productInstallmentPrice);
    }
    public int getProductInstallmentPriceText() {
        return Integer.parseInt(splitAmountOfElementText(getProductInstallmentPrice()));
    }

    public WebElement getCopyLinkIcon() {
        return safeFindElement(copyLinkIcon);
    }

    public WebElement getSpecificationsTab() {
        return safeFindElement(specificationsTab);
    }

    public void scrollToSpecificationsTab() {
        ScrollHandleMoveTargetOutOfBounds(getSpecificationsTab());
    }

    public WebElement getYouCanGetThisProductTitle() {
        return safeFindElement(youCanGetThisProductTitle);
    }

    public WebElement getStayInControlHeaderText() {
        return safeFindElement(stayInControlHeaderText);
    }

    public WebElement getFor6Months0InterestText() {
        return safeFindElement(for6Months0InterestText);
    }

    public WebElement getFor12Months0InterestText() {
        return safeFindElement(for12Months0InterestText);
    }

    public WebElement getProductImageInFooter() {
        return safeFindElement(productImageInFooter);
    }

    public WebElement getProductPriceInFooter() {
        return safeFindElement(productPriceInFooter);
    }

    public WebElement getProductPriceFor6Months0InterestInFooter() {
        return safeFindElement(productPriceFor6Months0InterestInFooter);
    }


    public WebElement getTermsAndConditionsTabInProductDetails() {
        return safeFindElement(termsAndConditionsTab);
    }

    public void scrollToTermsAndConditionsTabInProductDetails() {
        ScrollHandleMoveTargetOutOfBounds(getTermsAndConditionsTabInProductDetails());
    }

    public WebElement getCompareCheckbox() {
        return safeFindElement(compareCheckbox);
    }

    public void clickOnCompareCheckBox() {
        safeClick(compareCheckbox);
    }

    public Cart clickOnAddToCartButton() {
        JavascriptExecutorClick(getAddToCartButton());
        return new Cart();
    }

    public Login clickOnAddToCartButtonForGuestUser() {
        JavascriptExecutorClick(getAddToCartButton());
        return new Login();
    }

    public Cart clickOnBuyNowButton(){
        JavascriptExecutorClick(getBuyNowButton());
        return new Cart();
    }

    public Login clickOnBuyNowButtonForGuestUser() {
        JavascriptExecutorClick(getBuyNowButton());
        return new Login();
    }

    public void clickOnCalculatePointsTab() {
        safeClick(calculatePointsTab);
    }

    public void clickOnSpecificationsSectionInProductDetailsPage() throws InterruptedException {
        safeClick(specificationsSectionButton);
    }

    public void clickOnConfirmButtonInNotifyMeButton() {
        safeClick(notifyMeButton);
    }

    public void clickOnSpecificationsTabInProductDetailsPage() {
        safeClick(specificationsTab);
    }

    public WebElement getSpecificationsSectionBodyText() {
        return safeFindElement(specificationsSectionBodyText);
    }

    public WebElement getTermsSectionTitleText() {
        return safeFindElement(termsSectionTitle);
    }

    public void clickOnTermsSectionButton() {
        safeFindElement(termsAndConditionsTab).click();
    }

    public WebElement getTermsSectionBody() {
        return safeFindElement(termsSectionBody);
    }

    public WebElement getTermsSectionContactUs() {
        return safeFindElement(termsSectionContactUs);
    }

    public WebElement getProductColor() {
        return safeFindElement(productColor);
    }

    public WebElement getProductImage() {
        return safeFindElement(productImage);
    }

    public WebElement getProductStorage() {
        return safeFindElement(productStorage);
    }

    public WebElement productInstallmentSectionHeader() {
        return safeFindElement(productInstallmentSectionHeader);
    }

    public WebElement productPriceInProductDetailsPage() {
        return safeFindElement(productPrice);
    }


    public WebElement getBuyNowButtonInProductDetails() {
        return safeFindElement(buyNowButton);
    }

    public void clickOnAddToCompareCheckBoxInProductDetailsPage() {
        safeClick(compareCheckbox);
    }

    public WebElement getCompareSectionInProductPageDetails() {
        return safeFindElement(compareSection);
    }

    public WebElement getPaymentCardContent() {
        return safeFindElement(paymentCardContent);
    }

    public WebElement getCibBankIcon() {
        return safeFindElement(cibBankIcon);
    }

    public WebElement getAhlyBankIcon() {
        return safeFindElement(ahlyBankIcon);
    }

    public WebElement getMisrBankIcon() {
        return safeFindElement(misrBankIcon);
    }

    public WebElement getValuIcon() {
        return safeFindElement(valuIcon);
    }

    public WebElement getSouhoolaIcon() {
        return safeFindElement(SouhoolaIcon);
    }

    public WebElement getForsaIcon() {
        return safeFindElement(ForsaIcon);
    }

    public WebElement getCompareButton() {
        return safeFindElement(compareButton);
    }

    public WebElement getClearCompareButton() {
        return safeFindElement(clearCompareButton);
    }

    public WebElement getMonthlyInstallmentsPlansSection() {
        return safeFindElement(monthlyInstallmentsPlansSection);
    }

    public WebElement getInstallmentsPlansOptions() {
        return safeFindElement(installmentsPlans);
    }

    public WebElement getBnblInstallmentsTab() {
        return safeFindElement(bnplInstallmentsTab);
    }

    public WebElement getSevenIcon() {
        return safeFindElement(sevenIcon);
    }

    public WebElement getAmanIcon() {
        return safeFindElement(amanIcon);
    }

    public WebElement getInsuranceOptionHeader(String insuranceType) {
        if (insuranceType.equals("Basic Insurance")) {
            insuranceOptionTitle = By.xpath("(//h3[@class='card-title'])[1]");
        } else if (insuranceType.equals("Premium Insurance")) {
            insuranceOptionTitle = By.xpath("(//h3[@class='card-title'])[2]");
        }
        return safeFindElement(insuranceOptionTitle);
    }

    public WebElement getInsuranceSectionTitle() {
        return safeFindElement(insuranceSectionTitle);
    }

    public WebElement getRecommendedForYouSection() {
        return safeFindElement(recommendedForYouSection);
    }

    public void scrollToRecommendedForYouSection() {
        scrollDownUntilHeaderVisible(recommendedForYouSection, 20);
    }

    public void clickOnAddInsuranceButton(String insuranceType) {
        if (insuranceType.equals("Basic Insurance")) {
            addInsuranceButton = By.xpath("(//input[@name='insurance'])[1]");
        } else if (insuranceType.equals("Premium Insurance")) {
            addInsuranceButton = By.xpath("(//input[@name='insurance'])[2]");
        }
        safeClick(addInsuranceButton);
    }

    public void clickOnInsuranceDetailsButton(String insuranceType) {
        if (insuranceType.equals("Basic Insurance")) {
            insuranceDetailsButton = By.xpath("(//div[@class='card-title-container']//img)[1]");
        } else if (insuranceType.equals("Premium Insurance")) {
            insuranceDetailsButton = By.xpath("(//div[@class='card-title-container']//img)[2]");
        }
        safeClick(insuranceDetailsButton);
    }

    public WebElement getTradeInSection() {
        return safeFindElement(tradeInSection);
    }

    public void clickOnTradeInButton() {
        safeClick(tradeInButton);
    }

    public void clickOnNotifyMeButton() {
        safeClick(notifyMeButton);
    }

    public Login clickOnNotifyMeButtonForGuestUser() {
        safeClick(notifyMeButton);
        return new Login();
    }

    public WebElement getNotifyMeButton() {
        return safeFindElement(notifyMeButton);
    }

    public WebElement getNotifyMePopup() {
        return safeFindElement(notifyMePopup);
    }

    public WebElement getConfirmButtonInNotifyMePopup() {
        return safeFindElement(confirmButtonInNotifyMePopup);
    }

    public int getRecommendedForYouSkuCount() {
        WebElement section = getRecommendedForYouSection();
        WebElement skuContainer = section.findElement(recommendedForYouSkusContainer);
        return skuContainer.findElements(recommendedForYouProductCards).size();
    }

    public void selectPaymentPartner(String paymentPartner) {
        paymentPartnerIcon = By.xpath("//div//img[contains(@src,'" + paymentPartner + "')]");
        safeClick(paymentPartnerIcon);
    }

    public PaymentDetails clickOnLearnMoreButton(){
        JavascriptExecutorClick(safeFindElement(learnMoreButtonInIstallmentsPlansWindow));
        return new PaymentDetails();
    }

}