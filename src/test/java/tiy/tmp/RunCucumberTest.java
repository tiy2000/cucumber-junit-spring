package tiy.tmp;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "tiy.tmp",
//        tags = "@Calc and not @Api"
        tags = "@Plus and not @Api"
)
//@CucumberOptions(
//        features = "classpath:features",
//        glue = "tiy.tmp",
//        plugin = {
//                "pretty",
//                "html:target/cucumber-reports/cucumber-pretty.html",
//                "json:target/cucumber-reports/CucumberTestReport.json"
//        }
//)
public class RunCucumberTest {
}
