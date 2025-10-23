package tiy.tmp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tiy.tmp.config.dto.AppPlatform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static tiy.tmp.config.utils.ConverterUtils.convertListToMap;

@Configuration
@ConfigurationProperties(prefix = "app")
public class AppPlatformsConfig {

    @Value("${cfg.platform}")
    private String currentPlatform;

    private Map<String, AppPlatform> appPlatforms = new HashMap<>();

    // Setter with package-private scope is necessary for Spring's @ConfigurationProperties
    @SuppressWarnings("unused")
    void setPlatforms(List<AppPlatform> platforms) {
        appPlatforms = convertListToMap(platforms, AppPlatform::id);
    }

    public AppPlatform getAppPlatform(String id) {
        return appPlatforms.get(id);
    }

    public AppPlatform getCurrentAppPlatform() {
        return appPlatforms.get(currentPlatform);
    }

    @Bean
    public AppPlatform getCurrentAppPlatformConfig() {
        return getCurrentAppPlatform();
    }
}
