package com.vodafone.vodafone_eshop_taf.tests.flex;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/vodafone/vodafone_eshop_taf/tests/flex",
        glue = {"com.vodafone.vodafone_eshop_taf.tests"},
        plugin = {"html:reports/eshop-flexLines-Website-Report.html"},
        monochrome = true
)

public class FlexRunner extends AbstractTestNGCucumberTests{
}