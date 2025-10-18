package tiy.tmp.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;

@RequiredArgsConstructor
public class BaseStepDefinitions {

    private final Environment environment;

    @Before
    public void setup(Scenario scenario) {
        System.out.println("\nBEFORE: " + scenario.getName());
        System.out.println("environment=" + environment.getProperty("environment"));
        System.out.println("platform=" + environment.getProperty("platform"));
    }

    @After
    public void done(Scenario scenario) {
        System.out.println("AFTER: " + scenario.getName() + ", status: " + scenario.getStatus());
        System.out.println();
    }
}
