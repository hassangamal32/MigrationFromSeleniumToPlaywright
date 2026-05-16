package com.vodafone.vodafone_eshop_taf;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/vodafone/vodafone_eshop_taf/tests",
        glue = {"com.vodafone.vodafone_eshop_taf.tests"},
        tags = "@eshop and @pipeline and @regression",
        plugin = {"html:reports/eshop-Website-Report.html"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
