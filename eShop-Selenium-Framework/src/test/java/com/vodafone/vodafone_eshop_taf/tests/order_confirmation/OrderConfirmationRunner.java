package com.vodafone.vodafone_eshop_taf.tests.order_confirmation;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/vodafone/vodafone_eshop_taf/tests/order_confirmation",
        glue = {"com.vodafone.vodafone_eshop_taf.tests"},
        tags = "@recommended_sections",
        plugin = {"html:reports/eshop-Website-Report.html"},
        monochrome = true
)
public class OrderConfirmationRunner extends AbstractTestNGCucumberTests {
}
