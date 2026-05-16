package com.vodafone.vodafone_eshop_taf.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaymentDetails extends PageBase {

    private By breadCrumbInstallmentPlansButton = By.id("sl-lines-bread-crumb-installments-info.installments-plans");
    private By installmentPlansContentSection = By.xpath("//section[@class='content']");

    public PaymentContent clickBreadCrumbInstallmentPlansButton() {
        safeClick(breadCrumbInstallmentPlansButton);
        return new PaymentContent();
    }

    public WebElement getInstallmentPlansContentSection() {
        return safeFindElement(installmentPlansContentSection);
    }
}