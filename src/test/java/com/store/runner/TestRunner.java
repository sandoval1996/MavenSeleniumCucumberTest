package com.store.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.store",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin =
                {
                        "pretty",
                        "summary",
                        "html:target/test-report.html",
                        "json:target/cucumber.json",
                        "junit:target/cucumber.xml",
                        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                }
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
