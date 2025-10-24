package tiy.tmp.security.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import tiy.tmp.config.utils.ConverterUtils;

import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "security")
public class SecurityConfig {

    @Value("${cfg.secrets-provider}")
    private String currentSecretProvider;

    private Map<String, SecretProviderConfig> providers;

    // Setter with package-private scope is necessary for Spring's @ConfigurationProperties
    @SuppressWarnings("unused")
    void setProviders(List<SecretProviderConfig> providers) {
        this.providers = ConverterUtils.convertListToMap(providers, SecretProviderConfig::getId);
    }

    public SecretProviderConfig getSecretsProviderConfig(String id) {
        return providers.get(id);
    }

    public SecretProviderConfig getCurrentSecretsProviderConfig() {
        return providers.get(currentSecretProvider);
    }
}
