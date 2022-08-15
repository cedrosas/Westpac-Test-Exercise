package Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",
                "html:target/cucumber-reports/cucumber.html"

        },
        features = {"src/test/resources/features"},
        glue =  {"Test.StepDefinitions"}
)


public class TestRunner  extends AbstractTestNGCucumberTests{


}
