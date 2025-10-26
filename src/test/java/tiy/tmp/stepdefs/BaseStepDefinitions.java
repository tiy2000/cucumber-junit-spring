package tiy.tmp.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.RequiredArgsConstructor;
import tiy.tmp.config.App2UnderTestConfig;
import tiy.tmp.security.provider.SecretsProvider;

@RequiredArgsConstructor
public class BaseStepDefinitions {

    private final SecretsProvider secretsProvider;
    private final App2UnderTestConfig app2UnderTestConfig;

    @Before
    public void setup(Scenario scenario) {
        System.out.println(secretsProvider.getSecret1());
        System.out.println(secretsProvider.getSecret2());
        System.out.println("App2: " + app2UnderTestConfig.getCurrentAppPlatform());
//        System.out.println("Before Scenario: " + scenario.getName());
    }

    @After
    public void done(Scenario scenario) {
//        System.out.println("After Scenario: " + scenario.getName());
    }

}
