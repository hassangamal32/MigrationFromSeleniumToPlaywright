package com.vodafone.vodafone_eshop_taf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class RedLinesPlans extends PageBase {

        private final By redEssentialTitle = By.xpath("//p[contains(text(), 'Red Essential')]");
    private final By redEssentialData = By.xpath("//div[contains(@class,'tariff-benefit')]//p[contains(normalize-space(),'16') and (contains(.,'GB') or contains(.,'جيجا'))]");
    private final By redEssentialVoice = By.xpath("//p[@class='data' and contains(text(), '3000 minutes')]");
    private final By selectRedEssentialButton = By.xpath("//div[contains(@class, 'lines-planCard-header') and .//p[contains(text(), 'Red Essential')]]//button");

    private final By redAdvanceTitle = By.xpath("//div[contains(@class,'tariff-card-container')]//div[contains(@class,'header')]//h2[normalize-space()='RED ADVANCE+' or normalize-space()='+RED ADVANCE']");
    private final By redAdvanceData = By.xpath("//div[contains(@class,'tariff-benefit')]//p[contains(normalize-space(),'32') and (contains(.,'GB') or contains(.,'جيجا'))]");
    private final By redAdvanceVoice = By.xpath("//p[@class='data' and contains(text(), '5000 minutes')]");
    private final By redAdvanceFamilyMembers = By.xpath("//div[contains(@class,'tariff-card-container')][.//h2[normalize-space()='RED ADVANCE+' or normalize-space()='+RED ADVANCE']]//div[contains(@class,'tariff-benefit')][2]//p");
    private final By selectRedAdvanceButton = By.xpath("//div[contains(@class, 'lines-planCard-header') and .//p[contains(text(), 'Red Advance')]]//button");
    public By selectPlanButton(String planName) {
        return By.xpath(
                "//h2[contains(normalize-space(),'" + planName + "')]/ancestor::div[contains(@class,'tariff-card-container')]//button[contains(@class,'select-plan-btn')]"
        );
    }

    private final By redPrimeTitle = By.xpath("//div[contains(@class,'tariff-card-container')]//div[contains(@class,'header')]//h2[normalize-space()='RED PRIME+' or normalize-space()='+RED PRIME']");
    private final By redPrimeData = By.xpath("//div[contains(@class,'tariff-benefit')]//p[contains(normalize-space(),'50') and (contains(.,'GB') or contains(.,'جيجا'))]");

    private final By redPrimeVoice = By.xpath("//p[@class='data' and contains(text(), '7000 minutes')]");
    private final By redPrimeFamilyMembers = By.xpath("//div[contains(@class,'tariff-card-container')][.//h2[normalize-space()='RED PRIME+' or normalize-space()='+RED PRIME']]//div[contains(@class,'tariff-benefit')][2]//p");
    private final By selectRedPrimeButton = By.xpath("//div[contains(@class, 'lines-planCard-header') and .//p[contains(text(), 'Red Prime')]]//button");

    private final By redEliteTitle = By.xpath("//div[contains(@class,'tariff-card-container')]//div[contains(@class,'header')]//h2[normalize-space()='RED ELITE+' or normalize-space()='+RED ELITE']");
    private final By redEliteData = By.xpath("//div[contains(@class,'tariff-benefit')]//p[contains(normalize-space(),'85') and (contains(.,'GB') or contains(.,'جيجا'))]");
    private final By redEliteVoice = By.xpath("//p[@class='data' and contains(text(), '10000 minutes')]");
    private final By redEliteFamilyMembers = By.xpath("//div[contains(@class,'tariff-card-container')][.//h2[normalize-space()='RED ELITE+' or normalize-space()='+RED ELITE']]//div[contains(@class,'tariff-benefit')][2]//p");
    private final By selectRedEliteButton = By.xpath("//div[contains(@class, 'lines-planCard-header') and .//p[contains(text(), 'Red Elite')]]//button");
    private final By seeMoreButtonP2 = By.id("sl-tariff-card-vf-vf-more-link-btn-1-01G54XZE165ZF4110EYV0E00QK");
    private final By overlayMonthelySubscibtionDuringPromotionalPeriod = By.xpath("//div[contains(@class,'price-box')]//h2");
    private final By overlaySubscibtionVatDuringPromotionalPeriod = By.xpath("(//div[contains(@class,'price-box')]//h2[contains(@class,'--header')])[2]");
    private final By overlayMonthelySubscibtionAfterPromotionalPeriod = By.xpath("(//div[contains(@class,'after-promotion-box')]//h2[contains(@class,'--header')])[1]");
    private final By overlaySubscibtionVatAfterPromotionalPeriod = By.xpath("(//div[contains(@class,'after-promotion-box')]//h2[contains(@class,'--header')])[2]");
    private final By overlayCloseButton = By.xpath("/html/body/vf-root/main/section[2]/vf-home/section/vf-plans/vf-ng-main-container/section/div/div/div/div[1]/vf-rate-plan-card/div/div[2]/vf-rate-plan-more-info/div/button/img");
    private final By editButton = By.xpath("(//button[.//img[@alt='edit']])[2]");
    private final By subscibtionToTitle = By.xpath("//div[contains(@class,'plan-subscriptions')]//div[contains(@class,'--content')]//p ");
    private final By moreBenefitsTitle = By.xpath("//div[contains(@class,'more-benefits')]//p");
    private final By  rateplan= By.xpath("//*[@id=\"tariffScroller\"]/vf-tariff-card[2]/div/div/button");

    public String getOverlayMonthelySubscibtionDuringPromotionalPeriod() {
        return safeFindElement(overlayMonthelySubscibtionDuringPromotionalPeriod).getText();
    }

    public String getOverlaySubscibtionVatDuringPromotionalPeriod() {
        return safeFindElement(overlaySubscibtionVatDuringPromotionalPeriod).getText();
    }
    public String getOverlayMonthelySubscibtionAfterPromotionalPeriod() {
        return safeFindElement(overlayMonthelySubscibtionAfterPromotionalPeriod).getText();
    }

    public String getOverlaySubscibtionVatAfterPromotionalPeriod() {
        return safeFindElement(overlaySubscibtionVatAfterPromotionalPeriod).getText();
    }

    public String getSubscibtionToTitle() {
        return safeFindElement(subscibtionToTitle).getText();
    }
    public String getMoreBenefitsTitle() {
        return safeFindElement(moreBenefitsTitle).getText();
    }

    public String getPlanName(String planName) {

        switch (planName.toUpperCase()) {
            case "RED ESSENTIAL":
                return safeFindElement(redEssentialTitle).getText();

            case "RED ADVANCE":
                return safeFindElement(redAdvanceTitle).getText();

            case "RED PRIME":
                return safeFindElement(redPrimeTitle).getText();

            case "RED ELITE":
                return safeFindElement(redEliteTitle).getText();

            default:
                throw new IllegalArgumentException("Unsupported plan name: " + planName);
        }
    }

    public String getPlanData(String planName) {

        String rawText;

        switch (planName.toUpperCase()) {
            case "RED ESSENTIAL":
                rawText = safeFindElement(redEssentialData).getText();
                break;

            case "RED ADVANCE":
                rawText = safeFindElement(redAdvanceData).getText();
                break;

            case "RED PRIME":
                rawText = safeFindElement(redPrimeData).getText();
                System.out.println(rawText);
                break;

            case "RED ELITE":
                rawText = safeFindElement(redEliteData).getText();
                break;

            default:
                throw new IllegalArgumentException("Unsupported plan name: " + planName);
        }

        return extractGbValue(rawText);
    }
    private String extractGbValue(String text) {
        // 1) English pattern: "25 GB" / "25GB" / "25 GBs"
        java.util.regex.Matcher en = java.util.regex.Pattern
                .compile("(\\d+)\\s*GB", java.util.regex.Pattern.CASE_INSENSITIVE)
                .matcher(text);

        if (en.find()) {
            return en.group(1) + " GB";
        }

        // 2) Arabic pattern: "25 جيجا" (and common variants)
        java.util.regex.Matcher ar = java.util.regex.Pattern
                .compile("(\\d+)\\s*(جيجا|جيجابايت)")
                .matcher(text);

        if (ar.find()) {
            return ar.group(1) + " GB";
        }

        throw new IllegalArgumentException("Could not extract GB from: " + text);
    }


    public String getPlanVoice(String planVoice) {

        String rawText;

        switch (planVoice.toUpperCase()) {
            case "RED ESSENTIAL":
                rawText = safeFindElement(redEssentialData).getText();
                break;

            case "RED ADVANCE":
                rawText = safeFindElement(redAdvanceData).getText();
                break;

            case "RED PRIME":
                rawText = safeFindElement(redPrimeData).getText();
                break;

            case "RED ELITE":
                rawText = safeFindElement(redEliteData).getText();
                break;

            default:
                throw new IllegalArgumentException("Unsupported plan name: " + planVoice);
        }

        return extractMinutesValue(rawText);
    }
    private String extractMinutesValue(String text) {
        java.util.regex.Matcher en = java.util.regex.Pattern
                .compile("(\\d[\\d,]*)\\s*minutes", java.util.regex.Pattern.CASE_INSENSITIVE)
                .matcher(text);

        if (en.find()) {
            return en.group(1).replace(",", "") + " minutes";
        }

        java.util.regex.Matcher ar = java.util.regex.Pattern
                .compile("(\\d[\\d,]*)\\s*دقيقة")
                .matcher(text);

        if (ar.find()) {
            return ar.group(1).replace(",", "") + " minutes";
        }

        throw new IllegalArgumentException("Could not extract minutes from: " + text);
    }


    public String getPlanFamilyMembersNo(String planName) {

        switch (planName.toUpperCase()) {

            case "RED ADVANCE":
                return safeFindElement(redAdvanceFamilyMembers).getText();

            case "RED PRIME":
                return safeFindElement(redPrimeFamilyMembers).getText();

            case "RED ELITE":
                return safeFindElement(redEliteFamilyMembers).getText();

            default:
                throw new IllegalArgumentException(
                        "Unsupported plan name for family members: " + planName
                );
        }
    }


    public void clickSelectButton(String plan) {

        if (plan.equals("RED ESSENTIAL")) {
            safeClick(selectPlanButton (plan));
        } else if (plan.equals("RED ADVANCE")) {
            safeClick(selectPlanButton (plan));
        } else if (plan.equals("RED PRIME")) {
            safeClick(selectPlanButton (plan));
        } else if (plan.equals("RED ELITE")) {
            safeClick(selectPlanButton (plan));
        }
    }
    public WebElement getSeeMoreButton(){
        return safeFindElement(seeMoreButtonP2);
    }

    public void clickOnSeeMoreButton(){
        scrollTo(safeFindElement(seeMoreButtonP2));
        safeClick(seeMoreButtonP2);
    }

    public void clickOverlayCloseButton(){
        safeClick(overlayCloseButton);
    }
    public void clickEditButton(){
        safeClick(editButton);
    }


    public void clickRatePlan() {
       waitForElementEnabledAndDisplayedAndClickUsingJS(rateplan);
    }

    public WebElement getSelectPlanButton(String planName) {
        return safeFindElement(selectPlanButton(planName));
    }
    public void scrollToSelectPlanButton(String planName) {
        JavascriptExecutorScroll(getSelectPlanButton(planName));
    }

}
