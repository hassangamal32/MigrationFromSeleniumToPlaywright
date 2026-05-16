package com.vodafone.vodafone_eshop_taf.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaymentContent extends PageBase {

    private final By banksTab = By.xpath("(//div[@class='installments-info-tabs']//button)[1]");
    private final By bnplsTab = By.xpath("(//div[@class='installments-info-tabs']//button)[2]");
    private By paymentPartnerCard = By.xpath("//img[contains(@src,'paymentPartnerName')]/ancestor::div[1]//button");
    private final By educationalSection = By.xpath("//section[@class='installments-info-how-to-use']");
    private final By banner = By.xpath("//vf-carousel");

    public void clickBanksTab() {
        safeClick(banksTab);
    }

    public void clickBnplsTab() {
        safeClick(bnplsTab);
    }

    public boolean isBanksTabSelected() {
        return safeFindElement(banksTab)
                .getAttribute("class")
                .contains("active");
    }

    public boolean isBnplsTabSelected() {
        return safeFindElement(bnplsTab)
                .getAttribute("class")
                .contains("active");
    }

    public WebElement getPaymentPartnerCard(String paymentPartnerName) {
        paymentPartnerCard = By.xpath("//img[contains(@src,'"+paymentPartnerName+"')]/ancestor::div[1]//button");
        return safeFindElement(paymentPartnerCard);
    }

    public PaymentDetails clickOnPaymentPartnerCard(String paymentPartnerName) {
        paymentPartnerCard = By.xpath("//img[contains(@src,'"+paymentPartnerName+"')]/ancestor::div[1]//button");
        safeClick(paymentPartnerCard);
        return new PaymentDetails();
    }

    public WebElement getEducationSection() {
        return safeFindElement(educationalSection);
    }


    public WebElement getBannerSection() {
        return safeFindElement(banner);
    }


}