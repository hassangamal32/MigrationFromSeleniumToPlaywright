package com.vodafone.vodafone_eshop_taf.properties_reading;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

    private static final String eshopProductionEnvironmentConfigPath = System.getProperty("user.dir")+"/resources/config/eshop-production-environment-config.properties";
    private static final String eshopStagingEnvironmentConfigPath = System.getProperty("user.dir")+"/resources/config/eshop-staging-environment-config.properties";
    private static final String eshopProductionMsisdnConfigPath = System.getProperty("user.dir")+"/resources/config/eshop-production-msisdn-config.properties";
    private static final String eshopStagingMsisdnConfigPath = System.getProperty("user.dir")+"/resources/config/eshop-staging-msisdn-config.properties";


    public static Properties setEshopProductionEnvironmentProperties() throws IOException {
        Properties configProperties = new Properties();
        FileInputStream inputStream = new FileInputStream(eshopProductionEnvironmentConfigPath);
        configProperties.load(inputStream);
        return configProperties;
    }
    public static Properties setEshopStagingEnvironmentProperties() throws IOException {
        Properties configProperties = new Properties();
        FileInputStream inputStream = new FileInputStream(eshopStagingEnvironmentConfigPath);
        configProperties.load(inputStream);
        return configProperties;
    }
    public static Properties setEshopProductionMsisdnProperties() throws IOException {
        Properties configProperties = new Properties();
        FileInputStream inputStream = new FileInputStream(eshopProductionMsisdnConfigPath);
        configProperties.load(inputStream);
        return configProperties;
    }
    public static Properties setEshopStagingMsisdnProperties() throws IOException {
        Properties configProperties = new Properties();
        FileInputStream inputStream = new FileInputStream(eshopStagingMsisdnConfigPath);
        configProperties.load(inputStream);
        return configProperties;
    }
}
