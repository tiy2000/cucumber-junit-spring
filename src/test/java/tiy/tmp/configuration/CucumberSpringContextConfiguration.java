package tiy.tmp.configuration;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import tiy.com.CommonSpringConfiguration;
import tiy.tmp.MainConfiguration;

// Run with: mvn clean test -Dcfg.platform=android -Dcfg.environment=qt

@ContextConfiguration(classes = {
        CommonSpringConfiguration.class,
        MainConfiguration.class
})
@CucumberContextConfiguration
@TestPropertySource("classpath:application.properties")
@RequiredArgsConstructor
public class CucumberSpringContextConfiguration {

    private final Environment environment;

    @PostConstruct
    public void checkProfiles() {
        new CfgChecker(environment).checkCfgProps();
    }


    @Before
    public void setup(Scenario scenario) {
        System.out.println("\nBEFORE: " + scenario.getName());
        System.out.println("environment=" + environment.getProperty("environment"));
        System.out.println("platform=" + environment.getProperty("platform"));
    }

    @After
    public void done(Scenario scenario) {
        System.out.println("AFTER: " + scenario.getName() + ", status: " + scenario.getStatus());
        System.out.println();
    }
}


@Configuration
@ConditionalOnProperty(name = "cfg.platform", havingValue = "ios")
@PropertySource("classpath:platform-ios.properties")
class PlatformIOSConfiguration {
    public PlatformIOSConfiguration() {
        System.out.println("PlatformIOSConfiguration constructor");
    }
}

@Configuration
@ConditionalOnProperty(name = "cfg.platform", havingValue = "android")
@PropertySource("classpath:platform-android.properties")
class PlatformAndroidConfiguration {
    public PlatformAndroidConfiguration() {
        System.out.println("PlatformAndroidConfiguration constructor");
    }
}

@Configuration
@ConditionalOnProperty(name = "cfg.environment", havingValue = "local")
@PropertySource("classpath:environment-local.properties")
class EnvironmentLocalConfiguration {
    public EnvironmentLocalConfiguration() {
        System.out.println("EnvironmentLocalConfiguration constructor");
    }
}

@Configuration
@ConditionalOnProperty(name = "cfg.environment", havingValue = "et")
@PropertySource("classpath:environment-et.properties")
class EnvironmentEtConfiguration {
    public EnvironmentEtConfiguration() {
        System.out.println("EnvironmentEtConfiguration constructor");
    }
}

@Configuration
@ConditionalOnProperty(name = "cfg.environment", havingValue = "qt")
@PropertySource("classpath:environment-qt.properties")
class EnvironmentQtConfiguration {
    public EnvironmentQtConfiguration() {
        System.out.println("EnvironmentQtConfiguration constructor");
    }
}


@RequiredArgsConstructor
class CfgChecker {

    private final Environment environment;

    public void checkCfgProps() {
        StringBuilder errorMessages = new StringBuilder();
        errorMessages.append(checkEnvironmentSpecified());
        String platformCheckResult = checkPlatformSpecified();
        if (!platformCheckResult.isEmpty() && !errorMessages.isEmpty()) {
            errorMessages.append(" and ");
        }
        errorMessages.append(platformCheckResult);
        if (!errorMessages.isEmpty()) {
            throw new IllegalStateException(errorMessages.toString());
        }
    }

    private String checkEnvironmentSpecified() {
        String environmentProperty = environment.getProperty("cfg.environment");
        if (environmentProperty == null) {
            return "property 'cfg.environment' is not specified";
        }
        return switch (environmentProperty) {
            case "local", "et", "qt" -> "";
            default -> "property 'cfg.environment' has invalid value: '" + environmentProperty + "'";
        };
    }

    private String checkPlatformSpecified() {
        String platformProperty = environment.getProperty("cfg.platform");
        if (platformProperty == null) {
            return "property 'cfg.platform' is not specified";
        }
        switch (platformProperty) {
            case "android", "ios" -> {
                return "";
            }
            default -> {
                return "property 'cfg.platform' has invalid value: '" + platformProperty + "'";
            }
        }
    }
}
