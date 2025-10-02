package tiy.tmp.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import tiy.tmp.service.CalculatorService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorStepDefinitions {

    private int result;

    @Autowired  // IDEA не понимает, что класс stepdef будет создан как бин кукумбером!!!
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private CalculatorService calculatorService;

    public CalculatorStepDefinitions() {
        System.out.println("CalculatorStepDefinitions constructor");
    }

    @Given("I have a calculator")
    public void iHaveACalculator() {
        // Do nothing
    }

    @When("I add {int} and {int}")
    public void iAddAnd(int arg0, int arg1) {
        System.out.println("Adding " + arg0 + " and " + arg1);
        result = calculatorService.add(arg0, arg1);
    }

    @When("I subtract {int} and {int}")
    public void iSubtractAnd(int arg0, int arg1) {
        System.out.println("Subtracting " + arg0 + " and " + arg1);
        result = calculatorService.subtract(arg0, arg1);
    }

    @Then("the result should be {int}")
    public void theResultShouldBe(int expectedResult) {
        assertEquals(expectedResult, result);
    }
}
