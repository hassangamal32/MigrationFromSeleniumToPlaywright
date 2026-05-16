package com.vodafone.vodafone_eshop_taf.tests.profile.vouchers;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/vodafone/vodafone_eshop_taf/tests/profile/vouchers/vouchers.feature",
        glue = {"com.vodafone.vodafone_eshop_taf.tests"},
        tags = "@eshop and @pipeline and @vouchers",
        plugin = {"html:reports/eshop-Website-Report.html"},
        monochrome = true
)
public class VouchersRunner extends AbstractTestNGCucumberTests{
}
