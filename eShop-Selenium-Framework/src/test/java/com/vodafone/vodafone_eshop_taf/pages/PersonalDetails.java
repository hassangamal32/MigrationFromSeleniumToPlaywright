package com.vodafone.vodafone_eshop_taf.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PersonalDetails extends PageBase {

    private final By nameField = By.xpath("//vf-side-nav//p[@class='user-name']");

    private final By mobileNumberField = By.xpath("//vf-side-nav//p[@class='user-mobile']");

    private final By logoutButton = By.xpath("(//div[@class='content-item'])[5]");

    private final By chatbotClearButton = By.className("chat-hint-clear");
    private final By chatbotBox = By.className("chat-hint-body");
    private final By vouchersButton = By.xpath("(//div[@class='content-item'])[3]");
    private final By addressesTab = By.xpath("(//div[@class='content-item'])[4]");


    public WebElement getAddressesTab() {
        closeChatbotBoxIfExists();
        return safeFindElement(addressesTab);
    }
    public Addresses clickOnAddressesTab() {
        closeChatbotBoxIfExists();
        safeClick(addressesTab);
        return new Addresses();
    }

    public WebElement getVouchersButton() {
        closeChatbotBoxIfExists();
        return safeFindElement(vouchersButton);
    }
    public void clickOnVouchersButton() {
        closeChatbotBoxIfExists();
        safeFindElement(vouchersButton).click();
    }

    public WebElement getNameField(){
        return safeFindElement(nameField);
    }

    public WebElement getMobileNumberField(){
        return safeFindElement(mobileNumberField);
    }

    public Home clickOnLogoutButton() {
        closeChatbotBoxIfExists();
        safeFindElement(logoutButton).click();
        return new Home();
    }

    public void closeChatbotBoxIfExists() {
        try {
            List<WebElement> chatBoxes = safeFindElements(chatbotBox);
            if (!chatBoxes.isEmpty() && chatBoxes.get(0).isDisplayed()) {
                List<WebElement> clearButtons = safeFindElements(chatbotClearButton);
                if (!clearButtons.isEmpty()) {
                    clearButtons.get(0).click();
                }
            }
        } catch (Exception e) {
            // Chatbot not present, do nothing
        }
    }

}
