package com.vodafone.vodafone_eshop_taf.tests.paymentContent;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/vodafone/vodafone_eshop_taf/tests/paymentContent",
        glue = {"com.vodafone.vodafone_eshop_taf.tests"},
        tags = "@eshop and @pipeline and @payment-content",
        plugin = {"html:reports/eshop-Website-Report.html"},
        monochrome = true
)
public class paymentContentRunner extends AbstractTestNGCucumberTests {
}
