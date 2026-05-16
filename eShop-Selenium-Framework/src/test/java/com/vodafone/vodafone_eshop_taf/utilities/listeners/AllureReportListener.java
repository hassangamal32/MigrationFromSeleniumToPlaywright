package com.vodafone.vodafone_eshop_taf.utilities.listeners;

import com.vodafone.vodafone_eshop_taf.driver.WebDriverHandler;
import com.vodafone.vodafone_eshop_taf.utilities.allure.AllureEnvironmentWriter;
import org.testng.IExecutionListener;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AllureReportListener implements IExecutionListener {
    private static final String ALLURE_RESULT_PATH = System.getProperty("user.dir") +
            File.separator + "allure-results";

    private static final String CLEAN_COMMAND = "allure generate --clean --output \"" + ALLURE_RESULT_PATH + "\"";
    private static final String GENERATE_COMMAND = "allure generate --clean --single-file \"" + ALLURE_RESULT_PATH + "\"";
    private static final String SERVE_COMMAND = "allure serve \"" + ALLURE_RESULT_PATH + "\" -h localhost";
    private static final Logger LOGGER = Logger.getLogger(AllureReportListener.class.getName());

    @Override
    public void onExecutionStart() {
        try {
            LOGGER.log(Level.INFO, "=============================== Clean Environment From Old Reports =============================== ");
            Runtime.getRuntime().exec("cmd.exe /c " + CLEAN_COMMAND).waitFor();
            LOGGER.log(Level.INFO, "Successfully Cleaning The Old Allure Reports");
        } catch (IOException | InterruptedException e) {
            LOGGER.log(Level.SEVERE, "Failed to clean Allure report: " + e.getMessage(), e);
        }
    }

    @Override
    public void onExecutionFinish() {
        Properties props =new Properties();
        props.setProperty("User Name", System.getProperty("user.name"));
        props.setProperty("Browser", System.getProperty("BROWSERNAME"));
        props.setProperty("Environment", System.getProperty("ENVIRONMENT"));
        props.setProperty("OS", System.getProperty("os.name"));
        props.setProperty("Java Version", System.getProperty("java.version"));
        props.setProperty("Pipeline Executor", System.getenv("BUILD_USER") != null ? System.getenv("BUILD_USER") : "UNKNOWN");

        AllureEnvironmentWriter.writeEnvironmentProperties(props, ALLURE_RESULT_PATH);

        try {
            if (WebDriverHandler.getWebDriver() != null) {
                WebDriverHandler.close();
            }
            LOGGER.log(Level.INFO, "=============================== Generating Allure Report =============================== ");
            Runtime.getRuntime().exec("cmd.exe /c " + GENERATE_COMMAND).waitFor();
            LOGGER.log(Level.INFO, "Successfully Generation Of Allure Report");
            LOGGER.log(Level.INFO, "=============================== Auto Opening Allure Report =============================== ");
            Runtime.getRuntime().exec("cmd.exe /c " + SERVE_COMMAND);
            LOGGER.log(Level.INFO, "Successfully Opening Of Allure Report");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to generate or serve Allure report: " + e.getMessage(), e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
