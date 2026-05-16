package com.vodafone.vodafone_eshop_taf.tests.profile.personalDetails;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/vodafone/vodafone_eshop_taf/tests/profile/personalDetails/personalDetails.feature",
        glue = {"com.vodafone.vodafone_eshop_taf.tests"},
        plugin = {"html:reports/eshop-Website-Report.html"},
        monochrome = true
)
public class PersonalDetailsRunner extends AbstractTestNGCucumberTests {
}