package com.vodafone.vodafone_eshop_taf.driver;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;

public class WebDriverHandler {

    private static WebDriver webDriver;

    private String driverType = "driverType";
    private static WebDriverHandler webDriverHandler = null;

    public WebDriverHandler() throws IOException {
        setDriverCapabilities(System.getProperty("BROWSERNAME") );
    }
    public static WebDriverHandler getDriverHandler() throws IOException {
        if(webDriverHandler == null)
            webDriverHandler = new WebDriverHandler();
        return webDriverHandler;
    }
    private void setDriverCapabilities(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
            webDriver = new ChromeDriver(chromeOptions);
        } else if (browserName.equalsIgnoreCase("edge")) {
            webDriver = new EdgeDriver();
        }
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public void navigateTo(String link) {
        webDriver.navigate().to(link);
    }

    public void resetCache() {
        webDriver.manage().deleteAllCookies();
    }
    public void maximizeWindow() {
        webDriver.manage().window().maximize();
    }

    public static void close() {
        webDriver.quit();
        webDriverHandler=null;
    }

    public static String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public static void  back(){webDriver.navigate().back();}
}
