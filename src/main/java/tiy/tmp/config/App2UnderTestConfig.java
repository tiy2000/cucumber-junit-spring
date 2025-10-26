package tiy.tmp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import tiy.tmp.config.dto.AppPlatform;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "app2")
public class App2UnderTestConfig {

    @Value("${cfg.platform}")
    private String currentPlatform;

    private final Map<String, AppPlatform> appPlatforms = new HashMap<>();

    // Setter with package-private scope is necessary for Spring's @ConfigurationProperties
    @SuppressWarnings("unused")
    void setPlatforms(Map<String, AppPlatform> platforms) {

        // Wrong!!! AppPlatform.id will be empty!!!
        // appPlatforms = platforms;

        // Setting id!
        platforms.forEach((key, value) ->
                appPlatforms.put(key, new AppPlatform(
                                key,    // This is an id
                                value.platformVersion(),
                                value.appName(),
                                value.deviceName(),
                                value.locale()
                        )
                )
        );
    }

    public AppPlatform getAppPlatform(String id) {
        return appPlatforms.get(id);
    }

    public AppPlatform getCurrentAppPlatform() {
        return appPlatforms.get(currentPlatform);
    }
}
