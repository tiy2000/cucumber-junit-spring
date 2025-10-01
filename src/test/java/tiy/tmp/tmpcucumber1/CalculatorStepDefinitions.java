package tiy.tmp.tmpcucumber1;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorStepDefinitions {

    private int result;
    private Calculator calculator;

    @Given("I have a calculator")
    public void iHaveACalculator() {
        calculator = new Calculator();
    }

    @When("I add {int} and {int}")
    public void iAddAnd(int arg0, int arg1) {
        System.out.println("Adding " + arg0 + " and " + arg1);
        result = calculator.add(arg0, arg1);
    }

    @Then("the result should be {int}")
    public void theResultShouldBe(int expectedResult) {
        assertEquals(expectedResult, result);
    }
}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}
