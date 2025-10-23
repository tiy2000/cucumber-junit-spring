package tiy.tmp.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = {"tiy.tmp.stepdefs", "tiy.tmp.configuration"},
        tags = "(@Calc or @Greeting or @Cfg) and not @Api"
)
public class RunCucumberTest {
}
