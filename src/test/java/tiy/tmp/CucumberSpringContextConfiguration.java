package tiy.tmp;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // Работает без, но не поднимается WEB
@ContextConfiguration(classes = TmpCucumber1Application.class)              // Работает без, но не создается бин сервиса
@CucumberContextConfiguration
public class CucumberSpringContextConfiguration {

    @Before
    public void setup(Scenario scenario) {
        System.out.println("\nBEFORE: " + scenario.getName());
        // This method will be executed before each scenario.
        // It ensures the Spring context is loaded before tests run.
    }

    @After
    public void done(Scenario scenario) {
        System.out.println("AFTER: " + scenario.getName() + ", status: " + scenario.getStatus());
        System.out.println();
    }
}
