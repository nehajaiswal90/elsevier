package org.elsevier.eshopping;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/org/elsevier/eshopping/features",
        plugin = { "pretty", "html:target/cucumber-reports/Cucumber.html" , "junit:target/cucumber-reports/Cucumber.xml",  "json:target/cucumber-reports/Cucumber.json" }

)
public class TestRunner {
}
