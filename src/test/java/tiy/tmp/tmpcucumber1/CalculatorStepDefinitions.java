package tiy.tmp.tmpcucumber1;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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

    @When("I subtract {int} and {int}")
    public void iSubtractAnd(int arg0, int arg1) {
        System.out.println("Subtracting " + arg0 + " and " + arg1);
        result = calculator.subtract(arg0, arg1);
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

    public int subtract(int a, int b) {
        return a - b;
    }
}
