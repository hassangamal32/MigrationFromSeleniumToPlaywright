package com.vodafone.vodafone_eshop_taf.pages;

import com.vodafone.vodafone_eshop_taf.driver.WebDriverHandler;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.*;
import java.time.*;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class PageBase {

    protected WebDriver driver = WebDriverHandler.getWebDriver();
    protected WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
    protected JavascriptExecutor jse = (JavascriptExecutor) driver;
    protected Actions action = new Actions(driver);


    public void waitUntilElementExists(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitElementToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement safeFindElement(By locator) {
        waitUntilElementExists(locator);
        waitElementToBeVisible(locator);
        return driver.findElement(locator);
    }

    public WebElement safeFindElement(SearchContext  parent, By locator) {
        waitUntilElementExists(locator);
        waitElementToBeVisible(locator);
        return parent.findElement(locator);
    }


    public List<WebElement> safeFindElements(By locator) {
        waitUntilElementExists(locator);
        waitElementToBeVisible(locator);
        return driver.findElements(locator);
    }

    public void safeClick(By locator) {
        WebElement element = safeFindElement(locator);
        WebDriverWait waitClick = new WebDriverWait(driver,Duration.ofSeconds(6));
        for (int i = 0; i < 5; i++) {
            try {
                waitClick.until(ExpectedConditions.elementToBeClickable(locator));
                element.click();
                break;
            } catch (Exception ignored) {
            }
        }
    }

    public boolean IsElementDisplayed(By locator) {
        return safeFindElement(locator).isDisplayed();
    }

    public boolean IsElementClickable(By locator) {
        try {
            waitElementToBeClickable(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getCurrentURL() {
        return WebDriverHandler.getCurrentUrl();
    }

    public void scrollDownUsingActionsClass(WebElement element, int steps) {
        for (int i = 0; i <= steps; i++) {
            if (element.isDisplayed()) {
                action.sendKeys(Keys.ARROW_DOWN).build().perform();
                action.moveToElement(element).perform();
                break;
            }
        }
    }


    public void scrollDownUsingActionsClass(By locator, int steps) {
        for (int i = 0; i <= steps; i++) {
            if (IsElementDisplayed(locator)) {
                action.sendKeys(Keys.ARROW_DOWN).build().perform();
                action.moveToElement(safeFindElement(locator)).perform();
                break;
            }
        }
    }

    public void JavascriptExecutorClick(WebElement element) {
        jse.executeScript("arguments[0].click();", element);
    }

    public void JavascriptExecutorScroll(WebElement element) {
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }


    public void waitForUrlContains(String urlSubstring) {
        wait.until(ExpectedConditions.urlContains(urlSubstring));
    }


    public void scrollDownUntilHeaderVisible(By headerLocator, int maxAttempts) {
        int scrollAmount = 500;
        int attempts = 0;
        WebDriverWait localWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        while (attempts < maxAttempts) {
            try {
                WebElement header = localWait.until(ExpectedConditions.presenceOfElementLocated(headerLocator));
                if (header.isDisplayed()) {
                    jse.executeScript("arguments[0].scrollIntoView(true);", header);
                    break;
                }
            } catch (TimeoutException | NoSuchElementException e) {
                // Header not found yet, keep scrolling
            }
            jse.executeScript("window.scrollBy(0, " + scrollAmount + ");");
            attempts++;
            try {
                Thread.sleep(700); // Wait for content to load
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    public Optional<List<WebElement>> findElementsOptional(By locator) {
        try {
            List<WebElement> elements = safeFindElements(locator);
            if (elements.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(elements);
        } catch (Exception e) {
            return Optional.empty();
        }
    }


    public WebElement waitForElementEnabledAndDisplayedAndClickUsingJS(By locator) {
        WebElement element = wait.until(d -> {
            try {
                WebElement el = d.findElement(locator);
                return (el.isDisplayed() && el.isEnabled()) ? el : null;
            } catch (StaleElementReferenceException | NoSuchElementException e) {
                return null;
            }
        });
        jse.executeScript("arguments[0].click();", element);
        return element;
    }


    public void selectFromDropDownWithPartialText(By locator, String text) {
        Select dropDown = new Select(safeFindElement(locator));
        safeClick(locator);
        wait.until((ExpectedCondition<Boolean>) driver -> dropDown.getOptions().size() > 1);
        dropDown.selectByContainsVisibleText(text);
    }


    public void sendText(By locator, String text) {
        safeFindElement(locator).clear();
        safeFindElement(locator).sendKeys(text);
    }

    public boolean elementIsClickable(WebElement element) {
        if (element.isDisplayed() && element.isEnabled()) {
            return true;
        } else {
            return false;
        }
    }


    public void scrollTo(WebElement element) {
        final int xOffset = 200;
        final int yOffset = 0;
        do {
            if (element.isDisplayed()) {
                action.moveToElement(element, xOffset, yOffset);
                action.perform();
                break;
            }
            action.sendKeys(Keys.ARROW_DOWN).build().perform();
        }
        while (true);
    }

    public void ScrollHandleMoveTargetOutOfBounds(WebElement element) {
        try {
            action.moveToElement(element).perform();
        } catch (MoveTargetOutOfBoundsException moveTargetOutOfBoundsException) {
            moveTargetOutOfBoundsException.printStackTrace();
        }
    }

    public void swipeTo(WebElement targetElement) {
        Actions action = new Actions(WebDriverHandler.getWebDriver());
        action.dragAndDropBy(targetElement, 200, 0).build().perform();
    }

    public static String splitString(String string, String regex)
    {
        String[] parts = string.split(regex);
        for (String part : parts) {
            if (!part.isEmpty()) {
                return part;
            }
        }
        return "";
    }

    public String setDate(int daysToAdd)
    {
        LocalDate dateAfterTomorrow = LocalDate.now().plusDays(daysToAdd);
        String formattedDate = dateAfterTomorrow.toString();
        return formattedDate;
    }

    public String splitAmountOfElementText(WebElement element) {
        String amountText = element.getText().replace("\n", " ").trim();
        String[] splittedElementText = amountText.split(" ");
        String splittedElementText2 = splittedElementText[0].replace(",", "");
        return splittedElementText2;
    }

    public String splitElementBySpace(String input) {
        String[] parts = input.split(" ");
        if (parts.length > 1) {
            return parts[1];
        } else {
            return "";
        }
    }

    public String extractNumericValueFromText(WebElement element) {
        String elementText = element.getText();
        String numberPattern = "\\d{1,3}(?:,\\d{3})*";
        Pattern pattern = Pattern.compile(numberPattern);
        Matcher matcher = pattern.matcher(elementText);
        String extractedValue = "No price found";
        if (matcher.find()) {
            extractedValue= matcher.group().replace(",", "");
        } else {
            System.out.println("No number found.");
        }
        return extractedValue;
    }

    public int compareIntegers(int a, int b){
        return Integer.compare(a,b);
    }

    public int compareDecimals(double a, double b) {
        return Double.compare(a, b);
    }

    //to be revamped
    public Optional<WebElement> waitForVisibleIfPresent(By locator, int timeoutSeconds) {
        try {
            return Optional.of(
                    wait.until(driver1 -> {
                        try {
                            WebElement el = driver1.findElement(locator);
                            return el.isDisplayed() ? el : null;
                        } catch (StaleElementReferenceException | NoSuchElementException e) {
                            return null;
                        }
                    })
            );
        } catch (TimeoutException e) {
            return Optional.empty();
        }
    }

}

