package com.vodafone.vodafone_eshop_taf.tests.red;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
       features = "src/test/java/com/vodafone/vodafone_eshop_taf/tests/red",
        glue = {"com.vodafone.vodafone_eshop_taf.tests"},
        tags = "@eshop and @pipeline and @red",
        plugin = {"html:reports/eshop-Website-Report.html"},
        monochrome = true
)

public class RedRunner extends AbstractTestNGCucumberTests {
}
