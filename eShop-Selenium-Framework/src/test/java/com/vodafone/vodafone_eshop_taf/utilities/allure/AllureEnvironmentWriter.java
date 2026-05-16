package com.vodafone.vodafone_eshop_taf.utilities.allure;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class AllureEnvironmentWriter {
    private AllureEnvironmentWriter(){
        super();
    }
    public static void writeEnvironmentProperties(Properties props, String outputDirectory) {
        File envFile = new File(outputDirectory + "/environment.properties");

        try (FileWriter writer = new FileWriter(envFile)) {
            props.store(writer, "Allure Environment Properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
