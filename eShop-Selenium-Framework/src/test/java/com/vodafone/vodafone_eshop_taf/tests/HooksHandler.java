package com.vodafone.vodafone_eshop_taf.tests;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.vodafone.vodafone_eshop_taf.browser.Browser;
import com.vodafone.vodafone_eshop_taf.driver.WebDriverHandler;
import com.vodafone.vodafone_eshop_taf.properties_reading.ReadPropertiesFile;
import com.vodafone.vodafone_eshop_taf.utilities.extent_report.ExtentReport;
import com.vodafone.vodafone_eshop_taf.utilities.image_reducer.ImageReducer;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.*;

public class HooksHandler extends BaseTest {

    String eshopEnvironmentLink;
    @Before(value = "@eshop", order = 1)
    public void setUpEshop() throws IOException {
        webDriverHandler = WebDriverHandler.getDriverHandler();
        webDriverHandler.resetCache();
        webDriverHandler.maximizeWindow();
        browser = new Browser();

        if (System.getProperty("ENVIRONMENT").equalsIgnoreCase("Production")){
            properties = ReadPropertiesFile.setEshopProductionEnvironmentProperties();
            ratePlans = ReadPropertiesFile.setEshopProductionMsisdnProperties();
            eshopEnvironmentLink = properties.getProperty("eshopProductionLink");
            webDriverHandler.navigateTo(eshopEnvironmentLink);
        }
        else if (System.getProperty("ENVIRONMENT").equalsIgnoreCase("Staging")) {
            properties = ReadPropertiesFile.setEshopStagingEnvironmentProperties();
            ratePlans = ReadPropertiesFile.setEshopStagingMsisdnProperties();
            eshopEnvironmentLink = properties.getProperty("eshopStagingLink");
            webDriverHandler.navigateTo(eshopEnvironmentLink);
        }

        try {
            browser.eshopWebsite.home.clickOnCloseCookiesLayoutButton();
        } catch (TimeoutException e) {
            System.out.println("Close cookies button not found, continuing with execution.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }

//        try {
//            browser.eshopWebsite.home.clickOnCloseSpinTheWheelPopup();
//        } catch (TimeoutException e) {
//            System.out.println("Close spin & win popup button not found, continuing with execution.");
//        } catch (Exception e) {
//            System.out.println("An unexpected error occurred: " + e.getMessage());
//        }

//        Needed only on Black Friday
//        try {
//            browser.eshopWebsite.home.clickOnCloseBlackFridayPopup();
//        } catch (TimeoutException e) {
//        }
    }


    @Before(value = "@eshop", order = 0)
    public void startTCHooks(Scenario scenario) {
        ExtentReport.setScenario(scenario);
        ExtentReport.startTC();
    }

    @Before(value = "@eshop", order = 2)
    public void setStepDefs() throws NoSuchFieldException, IllegalAccessException {
        ExtentReport.setStepDefs();
    }

    @AfterStep(value = "@eshop")
    public void AfterStep(Scenario scenario) throws IOException {
        String stepName = ExtentReport.getCurrentStepName();
        Status logStatus = scenario.isFailed() ? Status.FAIL : Status.PASS;
        String allureLogStatus = scenario.isFailed() ? "Failed" : "Passed";

        try {
            WebDriver driver = WebDriverHandler.getWebDriver();

            if (driver != null
                    && ((RemoteWebDriver) driver).getSessionId() != null
                    && ((RemoteWebDriver) driver).getWindowHandles().size() > 0) {

                byte[] image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                String base64Screenshot = ImageReducer.reduce(image, 800, 600);

                ExtentReport.getTest().log(
                        logStatus,
                        stepName,
                        MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build()
                );

                Allure.addAttachment(allureLogStatus + " Screenshot", new ByteArrayInputStream(image));
            } else {
                System.out.println("WebDriver session is not active. Skipping screenshot.");
            }

        } catch (Exception e) {
            System.out.println("⚠️ Failed to take screenshot: " + e.getMessage());
            // Optional: log to report as info or warning if needed
            ExtentReport.getTest().log(Status.WARNING, "Screenshot skipped due to error: " + e.getMessage());
        }
    }

    @After(value = "@eshop", order = 0)
    public void tearDown() {
        webDriverHandler.resetCache();
        WebDriverHandler.close();
    }

    @After(value = "@eshop", order = 1)
    public void endTC() {
        if (ExtentReport.isCurrentlyUsingReport()) {
            ExtentReport.getExtent().flush();
        }
    }
}
