package com.vodafone.vodafone_eshop_taf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class Home extends PageBase {

    public MegaMenu megaMenu;

    public Home() {
        megaMenu = new MegaMenu();
    }

    private final By closeCookiesLayoutButton = By.className("onetrust-close-btn-handler");
    private final By closeSpinTheWheelPopup = By.className("close-modal-desktop");
    private final By closeBlackFridayPopup = By.xpath("/html/body/vf-root/vf-dynamic-modal/div/div/div/button[1]");

    private final By bestSellingPhonesHeader = By.xpath("/html/body/vf-root/main/section[2]/vf-landing/section/section/section/vf-products-section-container[2]/section/div[1]/p");

    private final By bestSellingFirstItemTitle = By.xpath("(//section[contains(@class,'homepage-section-container')])[2]//div[contains(@class,'skus-container')]/vf-product-card[1]//a[contains(@class,'product-card-container')]");

    private final By shopByBrandHeader = By.xpath("/html/body/vf-root/main/section[2]/vf-landing-page/section/vf-brands-section/section");

    private final By phoneItemButtonInBestSellingPhones = By.xpath("//*[@id=\"01HJ6A5VWGMP4S0EMDJ9VT10QJ\"]/vf-product-box-featured[4]/div/div/div[2]");

    private final By secondPhoneItemInSmartPhones =  By.xpath("(//div[@id='تليفونات ذكية']//div[@class='--details-container'] | //div[@id='Smart Phones']//div[@class='--details-container'])[2]");

    private final By bestSellingAccessoriesHeader = By.cssSelector("vf-products-section-container[id='sl-products-section-container=8'] p[class='title']");

    private final By firstAccessoryItemButtonInBestSellingAccessories = By.xpath("/html/body/vf-root/main/section[2]/vf-landing/section/section/section/vf-products-section-container[8]/section/div[2]/div/vf-product-box[1]/div/div");

    private final By secondTvItemNameInBestSellingTvs = By.xpath("/html/body/vf-root/main/section[2]/vf-landing/section/section/section/vf-products-section-container[5]/section/div[2]/div/vf-product-box[2]/div/div");

    private final By homeInTrackingLink = By.xpath("/html/body/vf-root/main/section[1]/vf-nav-bar/nav/div/div[1]/p");

    private final By samsungTabInShopByBrand = By.xpath("//vf-brand-card//a[contains(@aria-label,\"سامسونج\") or contains(@aria-label,\"Samsung\")]");

    private final By realmeTabInShopByBrand = By.id("Realme");

    private final By sonyTabInShopByBrand = By.id("Sony");

    private final By ankerTabInShopByBrand = By.xpath("//vf-brand-card//a[contains(@aria-label,\"أنكر\") or contains(@aria-label,\"Anker\")]");

    private final By LGTabInShopByBrand = By.xpath("//vf-brand-card//a[contains(@aria-label,\"LG\")]");

    private final By huaweiTabInShopByBrand = By.xpath("//vf-brand-card//a[contains(@aria-label,\"هواوي\") or contains(@aria-label,\"Brand: Huawei\")]");

    private final By appleTabInShopByBrand = By.xpath("//vf-brand-card//a[contains(@aria-label,\"أبل\") or contains(@aria-label,\"Apple\")]");

    private final By firstHeaderInMostSellingPhones = By.xpath("/html/body/vf-root/main/section[2]/vf-landing/section/section/section/vf-products-section-container[2]/section/div[1]/p");

    private final By getSmartPhonesSectionHeader = By.xpath("/html/body/vf-root/main/section[2]/vf-landing/section/section/section/vf-products-section-container[4]/section/div[1]/p");

    private final By secondHeaderInMostSellingAccessories = By.xpath("/html/body/vf-root/main/section[2]/vf-landing-page/section/div/div[3]/vf-middleware/div[5]/vf-products-container/section/div[1]/h4");

    private final By firstHeaderInMostSellingDiscounts = By.xpath("(//p[@class='products-productHeader-cardHeader-title'])[4]");

    private final By seeMoreButtonInDeals = By.xpath("/html/body/vf-root/main/section[2]/vf-landing/section/section/section/vf-products-section-container[1]/section/div[1]/button");

    private final By seeMoreButtonInAccessories = By.xpath("/html/body/vf-root/main/section[2]/vf-landing/section/section/section/vf-products-section-container[8]/section/div[1]/button");

    private final By SeeMoreButtonInNewArrivalsModuleInHomePage = By.id("01HRPTAZTDTVMP1RFG937Y092E");

    private final By firstAccessoryInBestSellingAccessories = By.xpath("(//div[@class='product-card'])[11]");

    private final By secondAccessoryInBestSellingAccessories = By.xpath("(//div[@class='product-card'])[12]");

    private final By firstItemInDiscountsItems = By.xpath("(//div[@class='product-card'])[16]");

    private final By firstItemInProductsForYouItems = By.xpath("(//div[@class='product-card'])[21]");

    private final By secondItemInProductsForYouItems = By.xpath("(//div[@class='product-card'])[22]");

    private final By thirdItemInProductsForYouItems = By.xpath("(//div[@class='product-card'])[23]");

    private final By forthItemInProductsForYouItems = By.xpath("(//div[@class='product-card'])[24]");

    private final By fifthItemInProductsForYouItems = By.xpath("(//div[@class='product-card'])[25]");

    private final By allProducts = By.className("--products-scroll-bar");

    private final By viewAllButton = By.id("cat10021");

    private final By viewAllButtonForAccessories = By.id("cat10001");

    private final By RedLinesTab = By.id("sl-categories-navbar-button-1-01H9ZBP82DYFKD1XRVY9T81EFD");

    private final By SmartPhonesTab = By.id("sl-categories-navbar-button-1-01H9ZAXJPA1A8M07R2E0PZ04KE");

    private final By DSLTab = By.id("sl-categories-navbar-button-1-01HA7M1EQYA86X1ZYHN7TF03HC");

    private final By wifiDevicesTab = By.id("sl-categories-navbar-button-1-01JNMKA81HJEVK0FCEQ29S1DVW");

    private final By HomeWirelessTab = By.id("sl-categories-navbar-button-1-01HA7M3XNFMSQK0ZN8VFQ70VJM");

    private final By topSellingSection = By.xpath("//h3[normalize-space(text())='Top Selling' or normalize-space(text())='الأكثر مبيعا']");

    private final By featuredBrandsSection = By.xpath("//h3[normalize-space(text())='Featured Brands' or normalize-space(text())='الماركة']");

    private final By firstItemButtonInTopSellingSection = By.xpath("(//section[@ID='sl-sku-bars-section-a-/list?categoryUrls=%2Ftop-selling'])//vf-product-card[1]//div[@class='card-header']");

    private final By secondItemButtonInTopSellingSection = By.xpath("(//section[@ID='sl-sku-bars-section-a-/list?categoryUrls=%2Ftop-selling'])//vf-product-card[2]//div[@class='card-header']");

    private final By cartIcon = By.id("sl-cart-button-1");

    private final By labTopTab = By.id("sl-categories-navbar-button-1-01H9Z9R85TPAM70CBFKF6C0DWM");

    private final By clearButton = By.xpath("//vf-root//div[3]//button[2]");

    private final By TVsSection = By.id("sl-categories-navbar-button-1-01H9ZBK8YC89FS1XMT74850TST");

    private final By firstItemButtonInTvSection = By.xpath("//div[@id='TVs' or @id='تليفزيونات ذكية']//div[@class='--details-container']");

    private final By allTabInNavBar = By.id("sl-categories-navbar-button-1-01H9Z9MD2WKSJ8104H3PQJ12YQ");

    private final By firstItemTitleInTopSellingSection = By.xpath("((//section[@class='skus-wrapper'])[5]//vf-product-card[1]//div[@class='card-body']//p)[1]");

    private final By recommendedForYouSection = By.xpath("(//section[@id='sl-sku-bars-section-a-undefined'])[1]");

    private final By recommendedForYouSkusContainer = By.cssSelector("div.skus-container");

    private final By recommendedForYouProductCards = By.cssSelector("vf-product-card");
    private final By shopNowPayLaterSection = By.xpath("//vf-installments-section");

    private final By exploreAllButtonForShopNowPayLaterSection = By.xpath("(//vf-installments-section//button)[1]");

    private By paymentPartnerCardInShopNowPayLaterSection = By.xpath("//img[contains(@src,'paymentPartnerName')]/ancestor::div[1]//button");


    public WebElement getShopByBrandHeader() {
        return safeFindElement(shopByBrandHeader);
    }

    public WebElement getCartIcon() {
        return safeFindElement(cartIcon);
    }

    public WebElement getBestSellingPhonesHeader() {
        return safeFindElement(bestSellingPhonesHeader);
    }

    public WebElement getBestSellingAccessoriesHeader() {
        return safeFindElement(bestSellingAccessoriesHeader);
    }

    public WebElement getViewAllButton() {
        return safeFindElement(viewAllButton);
    }

    public WebElement getViewAllButtonForAccessories() {
        return safeFindElement(viewAllButtonForAccessories);
    }

    public ProductsList clickOnAllTabInNavBar(){
        safeClick(allTabInNavBar);
        return new ProductsList();
    }

    public WebElement getHomeInTrackingLink() {
        return safeFindElement(homeInTrackingLink);
    }

    public WebElement getRealmeTabInShopByBrand() {
        return safeFindElement(realmeTabInShopByBrand);
    }

    public WebElement getFirstHeaderInMostSellingPhones() throws InterruptedException {
        return safeFindElement(firstHeaderInMostSellingPhones);
    }

    public void scrollToFirstHeaderInMostSellingPhones() throws InterruptedException {
        ScrollHandleMoveTargetOutOfBounds(getFirstHeaderInMostSellingPhones());
    }

    public WebElement getSmartPhonesSectionHeader() {
        return safeFindElement(getSmartPhonesSectionHeader);
    }

    public WebElement getSecondHeaderInMostSellingAccessories() {
        return safeFindElement(secondHeaderInMostSellingAccessories);
    }

    public WebElement getTopSellingSection() {
        return safeFindElement(topSellingSection);
    }

    public WebElement getTVsSection() {
        return safeFindElement(TVsSection);
    }

    public WebElement getFirstHeaderInMostSellingDiscounts() {
        return safeFindElement(firstHeaderInMostSellingDiscounts);
    }

    public WebElement getSeeMoreButtonInAccessoriesModule() {
        return safeFindElement(seeMoreButtonInAccessories);
    }

    public WebElement getSeeMoreButtonInNewArrivalsModuleInHomePage() {
        return safeFindElement(SeeMoreButtonInNewArrivalsModuleInHomePage);
    }

    public WebElement getSecondPhoneItemButtonInSmartPhones() {
        return safeFindElement(secondPhoneItemInSmartPhones);
    }

    public WebElement getSecondAccessoryInBestSellingAccessories() {
        return safeFindElement(secondAccessoryInBestSellingAccessories);
    }

    public WebElement getFirstItemInProductsForYouItems() {
        return safeFindElement(firstItemInProductsForYouItems);
    }

    public WebElement getSecondItemInProductsForYouItems() {
        return safeFindElement(secondItemInProductsForYouItems);
    }

    public WebElement getThirdItemInProductsForYouItems() {
        return safeFindElement(thirdItemInProductsForYouItems);
    }

    public WebElement getForthItemInProductsForYouItems() {
        return safeFindElement(forthItemInProductsForYouItems);
    }

    public WebElement getFifthItemInProductsForYouItems() {
        return safeFindElement(fifthItemInProductsForYouItems);
    }

    public WebElement getProductTitle() {
        return safeFindElement(bestSellingFirstItemTitle);
    }

    public List<WebElement> allProducts() {
        return safeFindElements(allProducts);
    }

    public WebElement getSecondTvItemNameInBestSellingTvs() {
        return safeFindElement(secondTvItemNameInBestSellingTvs);
    }

    public List<WebElement> getAllProducts() {
        return safeFindElements(allProducts);
    }

    private void getHomeWirelessTab() {
        JavascriptExecutorClick(safeFindElement(HomeWirelessTab));
    }

    private void getDSLTab() {
        JavascriptExecutorClick(safeFindElement(DSLTab));
    }

    private void getWifiDevicesTab() {
        JavascriptExecutorClick(safeFindElement(wifiDevicesTab));
    }

    private void getRedLinesTab() {
        JavascriptExecutorClick(safeFindElement(RedLinesTab));
    }

    private void getLapTopTab() throws InterruptedException {
        JavascriptExecutorClick(safeFindElement(labTopTab));
    }

    private void getSmartPhonesTab() {
        JavascriptExecutorClick(safeFindElement(SmartPhonesTab));
    }

    public WebElement getBrandTabInShopByBrandName(String brand) {
        switch (brand) {
            case "Samsung":
                JavascriptExecutorClick(safeFindElement(samsungTabInShopByBrand));
                break;
            case "anker":
                JavascriptExecutorClick(safeFindElement(ankerTabInShopByBrand));
                break;
            case "LG":
                JavascriptExecutorClick(safeFindElement(LGTabInShopByBrand));
                break;
            case "apple":
                JavascriptExecutorClick(safeFindElement(appleTabInShopByBrand));
                break;
            case "سامسونج":
                JavascriptExecutorClick(safeFindElement(samsungTabInShopByBrand));
                break;
            case "أنكر":
                JavascriptExecutorClick(safeFindElement(ankerTabInShopByBrand));
                break;
            case "أبل":
                JavascriptExecutorClick(safeFindElement(appleTabInShopByBrand));
                break;
        }
        return null;
    }

    public void clickOnCloseCookiesLayoutButton() {
        JavascriptExecutorClick(safeFindElement(closeCookiesLayoutButton));
    }

    public void clickOnCloseBlackFridayPopup() {
        JavascriptExecutorClick(safeFindElement(closeBlackFridayPopup));
        try {
            safeClick(closeBlackFridayPopup);
        } catch (TimeoutException | NoSuchElementException e) {
            // Popup not present, continue without failing
        }
    }

    public ProductDetails clickOnPhoneItemButtonInBestSellingPhones() {
        JavascriptExecutorClick(safeFindElement(phoneItemButtonInBestSellingPhones));
        return new ProductDetails();
    }

    public ProductDetails clickOnFirstItemInTopSellingSection() {
        JavascriptExecutorClick(safeFindElement(firstItemButtonInTopSellingSection));
        return new ProductDetails();
    }

    public ProductDetails clickOnSecondItemInTopSellingSection() {
        JavascriptExecutorClick(safeFindElement(secondItemButtonInTopSellingSection));
        return new ProductDetails();
    }

    public ProductDetails clickOnFirstItemInTvSection() {
        JavascriptExecutorClick(safeFindElement(firstItemButtonInTvSection));
        return new ProductDetails();
    }

    public ProductDetails clickOnFirstItemInDiscountsItems() {
        safeFindElement(firstItemInDiscountsItems).click();
        return new ProductDetails();
    }

    public ProductDetails clickOnBestSellingFirstItemLink() {
        JavascriptExecutorClick(safeFindElement(bestSellingFirstItemTitle));
        return new ProductDetails();
    }

    public ProductDetails clickOnFirstAccessoryItemButtonInBestSellingAccessories() {
        JavascriptExecutorClick(safeFindElement(firstAccessoryItemButtonInBestSellingAccessories));
        return new ProductDetails();
    }
    public WebElement clickOnSeeMoreButtonInBrandSectionInHomePage(String section) throws InterruptedException {
        switch (section) {
            case "Deals":
                JavascriptExecutorClick(safeFindElement(seeMoreButtonInDeals));
                break;
            case "Accessories":
                JavascriptExecutorClick(safeFindElement(seeMoreButtonInAccessories));
                break;
            case "العروض":
                JavascriptExecutorClick(safeFindElement(seeMoreButtonInDeals));
                break;
            case "اكسسوارات":
                JavascriptExecutorClick(safeFindElement(seeMoreButtonInAccessories));
                break;
        }
        return null;
    }

    public Object clickOnTabsInNavBarInHomePage(String tab) throws InterruptedException {
        switch (tab) {
            case "Red lines":
                getRedLinesTab();
                return new RedLines();
            case "Wifi Devices":
                getWifiDevicesTab();
                return new ProductsList();
            case "Smart Phones":
                getSmartPhonesTab();
                return new ProductsList();
            case "DSL":
                getDSLTab();
                return new Dsl();
            case "Home wireless":
                getHomeWirelessTab();
                return new AtHomeBundle();
            case "Laptops":
                getLapTopTab();
                return new ProductsList();
            case "خطوط Red":
                getRedLinesTab();
                return new RedLines();
            case "تليفونات ذكية":
                getSmartPhonesTab();
                return new ProductsList();
            case "انترنت منزلى":
                getDSLTab();
                return new Dsl();
            case "انترنت هوائي":
                getHomeWirelessTab();
                return new AtHomeBundle();
            case "أجهزة كمبيوتر محمولة":
                getLapTopTab();
                return new ProductsList();
            case "اجهزه واي فاي":
                getWifiDevicesTab();
        }
        return null;
    }

    public Cart clickOnCartIconInHomePage() throws InterruptedException {
        JavascriptExecutorClick(getCartIcon());
        return new Cart();
    }

    public ProductDetails clickOnSecondPhoneItemInSmartPhones() {
        JavascriptExecutorClick(safeFindElement(secondPhoneItemInSmartPhones));
        return new ProductDetails();
    }

    public void clickClearButton () {
        safeClick(clearButton);
    }

    public WebElement scrollDownToSeeMoreButtonInBrandSection(String scrollToSectionName) throws InterruptedException {
        switch (scrollToSectionName) {
            case "Deals":
                JavascriptExecutorScroll(safeFindElement(seeMoreButtonInDeals));
                break;
            case "Accessories":
                JavascriptExecutorScroll(safeFindElement(seeMoreButtonInAccessories));
                break;
        }
        return null;
    }

    public void scrollToSeeMoreButtonInAccessoriesModule() {
        JavascriptExecutorScroll(safeFindElement(seeMoreButtonInAccessories));
    }

    public WebElement cartIconInHomePageShouldBeClickable() {
        return safeFindElement(cartIcon);
    }

    public void clickOnCloseSpinTheWheelPopup (){
        JavascriptExecutorClick(safeFindElement(closeSpinTheWheelPopup));
    }

    public void scrollTopSellingSection() {
        scrollDownUntilHeaderVisible(topSellingSection, 20);
    }

    public void scrollDownToFeaturedBrand() {
        scrollDownUntilHeaderVisible(featuredBrandsSection, 30);
    }

    public WebElement getFirstItemTitleInTopSelling(){
        return safeFindElement(firstItemTitleInTopSellingSection);
    }

    public WebElement getRecommendedForYouSection() {
        return safeFindElement(recommendedForYouSection);
    }

    public void scrollToRecommendedForYouSection() {
        scrollDownUntilHeaderVisible(recommendedForYouSection, 20);
    }

    public int getRecommendedForYouSkuCount() {
        WebElement section = getRecommendedForYouSection();
        WebElement skuContainer = section.findElement(recommendedForYouSkusContainer);
        return skuContainer.findElements(recommendedForYouProductCards).size();
    }

    public void scrollDownToShopNowPayLaterSection() {
        scrollDownUntilHeaderVisible(shopNowPayLaterSection, 20);
    }

    public WebElement getShopNowPayLaterSection() {
        return safeFindElement(shopNowPayLaterSection);
    }

    public PaymentContent clickOnExploreAllButtonInShopNowPayLaterSection() {
        JavascriptExecutorClick(safeFindElement(exploreAllButtonForShopNowPayLaterSection));
        return new PaymentContent();
    }

    public PaymentDetails clickOnPaymentPartnerCardInShopNowPayLaterSection(String paymentPartnerName){
        paymentPartnerCardInShopNowPayLaterSection = By.xpath("//img[contains(@src,'"+paymentPartnerName+"')]/ancestor::div[1]//button");
        scrollTo(safeFindElement(paymentPartnerCardInShopNowPayLaterSection));
        safeClick(paymentPartnerCardInShopNowPayLaterSection);
        return new PaymentDetails();
    }


}