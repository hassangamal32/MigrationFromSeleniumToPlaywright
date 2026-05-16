package com.vodafone.vodafone_eshop_taf.tests.search;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/vodafone/vodafone_eshop_taf/tests/search/search.feature",
        glue = {"com.vodafone.vodafone_eshop_taf.tests"},
        plugin = {"html:reports/eshop-Website-Report.html"},
        monochrome = true
)
public class SearchRunner extends AbstractTestNGCucumberTests {
}