package com.vodafone.vodafone_eshop_taf.tests.profile.addresses;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/vodafone/vodafone_eshop_taf/tests/profile/addresses/addresses.feature",
        glue = {"com.vodafone.vodafone_eshop_taf.tests"},
        tags = "@eshop and @pipeline and @addresses",
        plugin = {"html:reports/eshop-Website-Report.html"},
        monochrome = true
)
public class AddressesRunner extends AbstractTestNGCucumberTests{
}
