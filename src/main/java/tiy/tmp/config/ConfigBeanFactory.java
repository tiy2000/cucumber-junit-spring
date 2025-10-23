package tiy.tmp.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tiy.tmp.config.dto.AppPlatform;
import tiy.tmp.config.dto.AppiumRunningProfile;

@Configuration
@RequiredArgsConstructor
public class ConfigBeanFactory {

    private final AppUnderTestConfig appUnderTestConfig;
    private final AppiumConfig appiumConfig;

    @Bean
    public AppiumRunningProfile getAppiumRunningProfile() {
        return appiumConfig.getCurrentRunningProfile();
    }

    @Bean
    public AppPlatform getCurrentAppPlatformConfig() {
        return appUnderTestConfig.getCurrentAppPlatform();
    }
}
