package tiy.tmp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import tiy.tmp.config.dto.AppiumRunningProfile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static tiy.tmp.config.utils.ConverterUtils.convertListToMap;

@Configuration
@ConfigurationProperties(prefix = "appium")
public class AppiumConfig {

    @Value("${cfg.environment}")
    private String currentRunningProfile;

    private Map<String, AppiumRunningProfile> runningProfiles = new HashMap<>();

    // Setter with package-private scope is necessary for Spring's @ConfigurationProperties
    @SuppressWarnings("unused")
    void setRunningProfiles(List<AppiumRunningProfile> runningProfiles) {
        this.runningProfiles = convertListToMap(runningProfiles, AppiumRunningProfile::id);
    }

    public AppiumRunningProfile getRunningProfile(String id) {
        return this.runningProfiles.get(id);
    }

    public AppiumRunningProfile getCurrentRunningProfile() {
        return this.runningProfiles.get(currentRunningProfile);
    }
}
