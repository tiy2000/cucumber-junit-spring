package tiy.tmp.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.RequiredArgsConstructor;
import tiy.tmp.config.App2UnderTestConfig;
import tiy.tmp.security.provider.SecretsProvider;
import tiy.tmp.service.LoginService;

@RequiredArgsConstructor
public class BaseStepDefinitions {

    // This ugly line is necessary for @AfterAll static method
    private static LoginService staticLoginService;

    private final SecretsProvider secretsProvider;
    private final App2UnderTestConfig app2UnderTestConfig;
    private final LoginService loginService;

    @Before
    public void setup(Scenario scenario) {

        staticLoginService = loginService;  // This ugly line is necessary for @AfterAll static method
        loginService.loginIfStillNotLoggedIn();

        System.out.println(secretsProvider.getSecret1());
        System.out.println(secretsProvider.getSecret2());
        System.out.println("App2: " + app2UnderTestConfig.getCurrentAppPlatform());

//        System.out.println("Before Scenario: " + scenario.getName());
    }

    @After
    public void done(Scenario scenario) {
//        System.out.println("After Scenario: " + scenario.getName());
    }

    @AfterAll
    public static void logout() {
        staticLoginService.logout();
    }

}
