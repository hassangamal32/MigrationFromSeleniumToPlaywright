package com.vodafone.vodafone_eshop_taf.tests.profile.myOrders;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/vodafone/vodafone_eshop_taf/tests/profile/myOrders/myOrders.feature",
        glue = {"com.vodafone.vodafone_eshop_taf.tests"},
        plugin = {"html:reports/eshop-Website-Report.html"},
        monochrome = true
)
public class MyOrdersRunner extends AbstractTestNGCucumberTests {
}