package com.vodafone.vodafone_eshop_taf.tests.home;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/vodafone/vodafone_eshop_taf/tests/home",
        glue = {"com.vodafone.vodafone_eshop_taf.tests"},
        tags = "@eshop and @pipeline and @home",
        plugin = {"html:reports/eshop-Website-Report.html"},
        monochrome = true
)
public class HomeRunner extends AbstractTestNGCucumberTests {
}
