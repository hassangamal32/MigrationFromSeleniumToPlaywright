package com.vodafone.vodafone_eshop_taf.tests.at_home_wireless;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/vodafone/vodafone_eshop_taf/tests/at_home_wireless",
        glue = {"com.vodafone.vodafone_eshop_taf.tests"},
        tags = "@eshop and @pipeline and @athome",
        plugin = {"html:reports/eshop-Website-Report.html"},
        monochrome = true
)
public class AtHomeWirelessRunner extends AbstractTestNGCucumberTests {
}
