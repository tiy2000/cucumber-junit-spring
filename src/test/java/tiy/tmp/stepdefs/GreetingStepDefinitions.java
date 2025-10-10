package tiy.tmp.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import tiy.com.service.GreetingService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingStepDefinitions {

    private String actualResult;

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private GreetingService greetingService;

    @Given("the greeting service is running")
    public void theGreetingServiceIsRunning() {
        // Do nothing
    }

    @When("I send a request to greet {string}")
    public void iSendARequestToGreet(String name) {
        actualResult = greetingService.sayHello(name);
    }

    @Then("I should receive a greeting message {string}")
    public void iShouldReceiveAGreetingMessage(String expectedResult) {
        assertEquals(expectedResult, actualResult);
    }
}
