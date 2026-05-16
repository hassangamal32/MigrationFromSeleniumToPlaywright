package com.vodafone.vodafone_eshop_taf.pages;

import com.vodafone.vodafone_eshop_taf.driver.WebDriverHandler;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsList extends PageBase {

    private final By appleTab = By.xpath("(//div[@class='brand-container']/div)[3]");

    private final By firstMacItemInProductListPage = By.xpath("(//vf-product-card//a[@class='product-card-container column pd-list'])[3]");

    private final By secondMacItemInProductListPage = By.xpath("(//vf-product-card//a[@class='product-card-container column pd-list'])[1]");

    private final By clearFilterButton = By.xpath("//vf-facet-header//button");
    private final By resetAllFiltersButton = By.xpath("//button[contains(@class,'reset-all')]");
    private final By categoryFilterDropDown= By.xpath("//div[@class='category-filter']");
    private final By brandFilterDropDown= By.xpath("//div[@class='brand-filter']");
    private final By priceFilterDropDown= By.xpath("(//div[@class='facet'])[1]");
    private By categoryTitleDropDown = By.xpath("//div[contains(@class,'category-title')][normalize-space()='CategoryTitleDropDown']");
    private By categoryCheckBox = By.xpath("//input[contains(@id,'categoryName')]");
    private final By resultAfterFilter = By.xpath("//div[@class='results']//strong");
    private By brandCheckBox = By.xpath("//input[contains(@id,'brandName')]");
    private By activeFilterBrand = By.xpath("//img[@alt='brandName']/ancestor::div[1][contains(@class,'active')]");
    private By priceFilterCheckbox = By.xpath("//input[contains(@id,'priceOption')]");
    private final By firstItemPrice = By.xpath("(//vf-product-card//p[@aria-label='sale-price'])[1]");
    private final By secondItemPrice = By.xpath("(//vf-product-card//p[@aria-label='sale-price'])[2]");
    private final By minimumPrice = By.xpath("//input[@aria-label='Minimum price']");
    private final By maximumPrice = By.xpath("//input[@aria-label='Maximum price']");
    private final By applyFilterButton = By.xpath("//div[contains(@class,'price-range')]//button");
    private final By sortByDropDownMenu = By.xpath("//div[@class='dropdown']");
    private final By sortByDefaultOption = By.xpath("//div[@class='dropdown-selected']");
    private final By sortByRecommendedOption = By.xpath("//div[contains(@class,'dropdown-options')]//div[1]");
    private final By sortByPriceLowToHighOption = By.xpath("//div[contains(@class,'dropdown-options')]//div[2]");
    private final By sortByPriceHighToLowOption = By.xpath("//div[contains(@class,'dropdown-options')]//div[3]");
    private final By sortByDiscountHighToLowOption = By.xpath("//div[contains(@class,'dropdown-options')]//div[4]");
    private final By sortByBestRatedOption = By.xpath("//div[contains(@class,'dropdown-options')]//div[5]");
    private final By firstItemDiscount = By.xpath("(//vf-product-card//div[@class='discount'])[1]");
    private final By secondItemDiscount = By.xpath("(//vf-product-card//div[@class='discount'])[2]");
    private final By firstItemRate = By.xpath("(//vf-product-card//div[@class='review'])[1]");
    private final By secondItemRate = By.xpath("(//vf-product-card//div[@class='review'])[2]");
    private final By heroBannerCarousel = By.cssSelector("div.slider");
    private final By heroBannerSlides = By.cssSelector("div.slider img.slide");
    private final By heroBannerPrevArrow = By.id("sl-hero-banner-button-1");
    private final By heroBannerNextArrow = By.id("sl-hero-banner-button-2");
    private final By featuredBannerSection = By.id("sl-featured-banner-section-01KCS9NFRVB69FYYRXYJHCZ87A");
    private final By featuredBannerImages = By.cssSelector("vf-featured-banner section.featured-section img");
    private final By addToCart=By.xpath("//button[contains(@class,'add-to-cart')]");
    private final By closeButton=By.xpath("//div[contains(@class, 'close')]");



    private By featuredBrandCard;
    private final By featuredBrandsSection =
            By.cssSelector("section.shop-brand.homepage-section-container[id^='sl-brands-section']");


    public int getFeaturedBannerImagesCount() {
        waitUntilElementExists(featuredBannerImages);
        return driver.findElements(featuredBannerImages).size();
    }

    public int getHeroBannerSlidesCount() {
        waitUntilElementExists(heroBannerSlides);
        return driver.findElements(heroBannerSlides).size();
    }

    public WebElement getClearFilterButton(){
        return safeFindElement(sortByDefaultOption);
    }

    public WebElement getResetAllFiltersButton(){
        return safeFindElement(sortByDefaultOption);
    }

    public void expandCategoryFilterDropDown(){
        safeClick(categoryFilterDropDown);
    }

    public void expandBrandFilterDropDown(){
        safeClick(brandFilterDropDown);
    }

    public void expandPriceFilterDropDown(){
        safeClick(priceFilterDropDown);
    }

    public void expandCategoryTitleDropDown(String categoryTitleName){
        categoryTitleDropDown = By.xpath("//div[contains(@class,'category-title')][normalize-space()='"+categoryTitleName+"']");
        safeClick(categoryTitleDropDown);
    }

    public void enableCategoryCheckBox(String categoryName){
        categoryCheckBox = By.xpath("//input[contains(@id,'"+categoryName+"')]");
        safeClick(categoryCheckBox);
    }

    public String getResultAfterFilter(){
        return safeFindElement(resultAfterFilter).getText();
    }

    public void enableBrandCheckBox(String brandName){
        brandCheckBox = By.xpath("//input[contains(@id,'"+brandName+"')]");
        safeClick(brandCheckBox);
    }

    public Boolean checkIfBrandFilterActive(String brandName){
        activeFilterBrand = By.xpath("//img[@alt='"+brandName+"']/ancestor::div[1][contains(@class,'active')]");
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(activeFilterBrand));
            return true;
        } catch (Exception ignored){}
        return false;
    }

    public void enablePriceFilterCheckBox(String priceFilterOption){
        priceFilterCheckbox = By.xpath("//input[contains(@id,'"+priceFilterOption+"')]");
        safeClick(priceFilterCheckbox);
    }

    public int getFirstItemPrice(){
        String priceText = safeFindElement(firstItemPrice).getText();
        return Integer.parseInt(priceText.replaceAll("[^0-9]", ""));
    }

    public int getSecondItemPrice(){
        String priceText = safeFindElement(secondItemPrice).getText();
        return Integer.parseInt(priceText.replaceAll("[^0-9]", ""));
    }

    public Boolean checkIfFirstItemPriceMatchTheFilter(String priceFilterOption){
        switch (priceFilterOption) {
            case "Below 2,000":
                return getFirstItemPrice() <= 2000;
            case "2,000 to 4,000":
                return getFirstItemPrice() >= 2000 && getFirstItemPrice() <= 4000;
            case "6,000 to 10,000":
                return getFirstItemPrice() >= 6000 && getFirstItemPrice() <= 10000;
            case "12,000 to 18,000":
                return getFirstItemPrice() >= 12000 && getFirstItemPrice() <= 18000;
            case "Above 21,000":
                return getFirstItemPrice() >= 21000;
            default:
                System.out.println("invalid option");
                return false;
        }
    }

    public Boolean checkIfFirstItemPriceMatchTheCustomFilterValues(int min, int max){
        return getFirstItemPrice() > min && getFirstItemPrice() < max;
    }

    public void setMinimumPrice(String min){
        waitElementToBeClickable(minimumPrice);
        safeFindElement(minimumPrice).clear();
        safeFindElement(minimumPrice).sendKeys(min);
    }

    public void setMaximumPrice(String max){
        waitElementToBeClickable(maximumPrice);
        safeFindElement(maximumPrice).clear();
        safeFindElement(maximumPrice).sendKeys(max);
    }

    public void clickOnApplyFilterButton(){
        safeClick(applyFilterButton);
    }

    public void expandSortByDropDownMenu(){
        safeClick(sortByDropDownMenu);
    }

    public String getSortByDefaultOption(){
        return safeFindElement(sortByDefaultOption).getText();
    }

    public WebElement getRecommendedOption() {
        return safeFindElement(sortByRecommendedOption);
    }

    public WebElement getPriceLowToHighOption() {
        return safeFindElement(sortByPriceLowToHighOption);
    }

    public WebElement getPriceHighToLowOption() {
        return safeFindElement(sortByPriceHighToLowOption);
    }

    public WebElement getDiscountHighToLowOption() {
        return safeFindElement(sortByDiscountHighToLowOption);
    }

    public WebElement getBestRatedOption() {
        return safeFindElement(sortByBestRatedOption);
    }

    public void selectSortByPriceLowToHighOption(){
        safeClick(sortByPriceLowToHighOption);
    }
    public void selectSortByPriceHighToLowOption(){
        safeClick(sortByPriceHighToLowOption);
    }
    public void selectSortByDiscountHighToLowOption(){
        safeClick(sortByDiscountHighToLowOption);
    }
    public void selectSortByBestRatedOption(){
        safeClick(sortByBestRatedOption);
    }

    public int compareFirstAndSecondItemsPrices(){
        return compareIntegers(getFirstItemPrice(),getSecondItemPrice());
    }

    public int getFirstItemDiscount(){
        String priceText = safeFindElement(firstItemDiscount).getText();
        return Integer.parseInt(priceText.replaceAll("[^0-9]", ""));
    }

    public int getSecondItemDiscount(){
        String priceText = safeFindElement(secondItemDiscount).getText();
        return Integer.parseInt(priceText.replaceAll("[^0-9]", ""));
    }

    public int compareFirstAndSecondItemsDiscounts(){
        return compareIntegers(getFirstItemDiscount(),getSecondItemDiscount());
    }

    public double getFirstItemRate(){
        String rate = (String) ((JavascriptExecutor) driver)
                .executeScript(
                        "return arguments[0].childNodes[0].textContent.trim();",
                        safeFindElement(firstItemRate)
                );
        return Double.parseDouble(rate.replaceAll("[^0-9.]", ""));
    }

    public double getSecondItemRate(){
        String rate = (String) ((JavascriptExecutor) driver)
                .executeScript(
                        "return arguments[0].childNodes[0].textContent.trim();",
                        safeFindElement(secondItemRate)
                );
        return Double.parseDouble(rate.replaceAll("[^0-9.]", ""));
    }

    public int compareFirstAndSecondItemsRates(){
        return compareDecimals(getFirstItemRate(),getSecondItemRate());
    }


    public WebElement getAppleTab() throws InterruptedException {
        return safeFindElement(appleTab);
    }

    public WebElement getFirstMacItem() throws InterruptedException {
        return safeFindElement(firstMacItemInProductListPage);
    }

    public WebElement getSecondMacItem() throws InterruptedException {
        return safeFindElement(secondMacItemInProductListPage);
    }

    public void clickOnAppleTab() throws InterruptedException {
        JavascriptExecutorClick(getAppleTab());
    }

    public ProductDetails clickOnFirstMacItemInProductsListPage() throws InterruptedException {
        JavascriptExecutorClick(getFirstMacItem());
        return new ProductDetails();
    }

    public ProductDetails clickOnSecondMacItemInProductsListPage() throws InterruptedException {
        JavascriptExecutorClick(getSecondMacItem());
        return new ProductDetails();
    }

    public boolean isHeroBannerCarouselDisplayed() {
        try {
            return safeFindElement(heroBannerCarousel).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean areHeroBannerArrowsDisplayed() {
        boolean prevVisible = safeFindElement(heroBannerPrevArrow).isDisplayed();
        boolean nextVisible = safeFindElement(heroBannerNextArrow).isDisplayed();

        return prevVisible && nextVisible;
    }

    public boolean isFeaturedBannerSectionDisplayed() {
        try {
            return safeFindElement(featuredBannerSection).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void scrollToFeaturedBrandsSection() {
        scrollDownUntilHeaderVisible(featuredBrandsSection,25);
    }


    public boolean isFeaturedBrandsSectionDisplayed() {
        return safeFindElement(featuredBrandsSection).isDisplayed();
    }
    public boolean isFeaturedBrandDisplayed(String brandName) {
        featuredBrandCard = By.xpath(
                "//section[contains(@class,'shop-brand')]//img[@alt='" + brandName + "']"
        );

        try {
            return safeFindElement(featuredBrandCard).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement getAddToCart() {
        return safeFindElement(addToCart);
    }

    public void clickOnFirstInStockProduct() {
        final int startIndex = 2;
        final int maxIndex = 10;
        for (int index = startIndex; index <= maxIndex; index++) {
            clickOnQuickAddToCart(index);
            if (elementIsClickable(getAddToCart())) {
                safeClick(addToCart);
                return;
            }
            safeClick(closeButton);
        }
        throw new AssertionError(
                "No in-stock product found between SKUs index " + startIndex + " and " + maxIndex
        );
    }
    public void clickOnQuickAddToCart(int skuNumber) {
        safeClick(quickAddToCartButton(skuNumber));
    }
    private By quickAddToCartButton(int skuNumber) {
        return By.xpath("(//button[contains(@class,'cart')])[" + skuNumber + "]");
    }



}
