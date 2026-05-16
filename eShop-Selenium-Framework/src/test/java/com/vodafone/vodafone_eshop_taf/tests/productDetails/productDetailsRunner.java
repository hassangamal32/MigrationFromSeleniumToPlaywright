package com.vodafone.vodafone_eshop_taf.tests.productDetails;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/vodafone/vodafone_eshop_taf/tests/productDetails",
        glue = {"com.vodafone.vodafone_eshop_taf.tests"},
        tags = "@eshop and @pipeline and @productDetails",
        plugin = {"html:reports/eshop-Website-Report.html"},
        monochrome = true
)
public class productDetailsRunner extends AbstractTestNGCucumberTests {
}
