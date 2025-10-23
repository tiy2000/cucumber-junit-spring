package tiy.tmp.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BaseStepDefinitions {

    @Before
    public void setup(Scenario scenario) {
        System.out.println("Before Scenario: " + scenario.getName());
    }

    @After
    public void done(Scenario scenario) {
        System.out.println("After Scenario: " + scenario.getName());
    }

}
