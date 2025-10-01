package tiy.tmp.tmpcucumber1;

import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import tiy.tmp.TmpCucumber1Application;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // Работает без, но не поднимается WEB
@ContextConfiguration(classes = TmpCucumber1Application.class)              // Работает без, но не создается бин сервиса
@CucumberContextConfiguration
public class CucumberSpringContextConfiguration {

    @Before
    public void setup() {
        System.out.println("Before");
        // This method will be executed before each scenario.
        // It ensures the Spring context is loaded before tests run.
    }
}
