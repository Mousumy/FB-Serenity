package facebook;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
//@CucumberOptions(features="src/test/resources/features/consult_dictionary/LookupADefinition.feature")

@CucumberOptions(
features = "src/test/resources/features/" , plugin = { "html:target/cucumber", "json:target/cucumber/cucumber.json", "pretty:target/cucumber/cucumber-pretty.txt",
        "usage:target/cucumber/cucumber-usage.json", "junit:target/cucumber/cucumber-results.xml" })

public class FacebookTestSuite {}
