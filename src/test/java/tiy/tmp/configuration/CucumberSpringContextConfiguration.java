package tiy.tmp.configuration;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import tiy.tmp.TmpCucumber1Application;

import java.util.Arrays;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // Работает без, но не поднимается WEB
@ContextConfiguration(classes = TmpCucumber1Application.class)              // Работает без, но не создается бин сервиса
@CucumberContextConfiguration
@RequiredArgsConstructor
public class CucumberSpringContextConfiguration {

    private final Environment environment;

    @PostConstruct
    public void checkProfiles() {
        StringBuilder errorMessages = new StringBuilder();
        if (!isEnvironmentSpecified()) {
            errorMessages.append("Environment");
        }
        if (!isPlatformSpecified()) {
            if (!errorMessages.isEmpty()) {
                errorMessages.append(" and ");
            }
            errorMessages.append("Platform");
        }
        if (!errorMessages.isEmpty()) {
            errorMessages.append(" must be specified");
            throw new RuntimeException(errorMessages.toString());
        }
    }

    private boolean isEnvironmentSpecified() {
        List<String> profiles = Arrays.asList(environment.getActiveProfiles());
        return profiles.contains("local") || profiles.contains("et") || profiles.contains("qt");
    }

    private boolean isPlatformSpecified() {
        List<String> profiles = Arrays.asList(environment.getActiveProfiles());
        return profiles.contains("android") || profiles.contains("ios");
    }

    @Before
    public void setup(Scenario scenario) {
        System.out.println("\nBEFORE: " + scenario.getName());

        System.out.println("environment=" + environment.getProperty("environment"));
        System.out.println("platform=" + environment.getProperty("platform"));

        // This method will be executed before each scenario.
        // It ensures the Spring context is loaded before tests run.
    }

    @After
    public void done(Scenario scenario) {
        System.out.println("AFTER: " + scenario.getName() + ", status: " + scenario.getStatus());
        System.out.println();
    }
}

@Configuration
@Profile("ios")
@PropertySource("classpath:platform-ios.properties")
class PlatformIOSConfiguration {
    public PlatformIOSConfiguration() {
        System.out.println("PlatformIOSConfiguration constructor");
    }
}

@Configuration
@Profile("android")
@PropertySource("classpath:platform-android.properties")
class PlatformAndroidConfiguration {
    public PlatformAndroidConfiguration() {
        System.out.println("PlatformAndroidConfiguration constructor");
    }
}

@Configuration
@Profile("local")
@PropertySource("classpath:environment-local.properties")
class EnvironmentLocalConfiguration {
    public EnvironmentLocalConfiguration() {
        System.out.println("EnvironmentLocalConfiguration constructor");
    }
}

@Configuration
@Profile("et")
@PropertySource("classpath:environment-et.properties")
class EnvironmentEtConfiguration {
    public EnvironmentEtConfiguration() {
        System.out.println("EnvironmentEtConfiguration constructor");
    }
}

@Configuration
@Profile("qt")
@PropertySource("classpath:environment-qt.properties")
class EnvironmentQtConfiguration {
    public EnvironmentQtConfiguration() {
        System.out.println("EnvironmentQtConfiguration constructor");
    }
}
