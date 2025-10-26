package tiy.tmp.security.provider;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tiy.tmp.security.config.SecretProviderConfig;
import tiy.tmp.security.config.SecurityConfig;
import tiy.tmp.security.provider.types.LocalFileSecretsProvider;
import tiy.tmp.security.provider.types.VaultSecretsProvider;

@Configuration
@RequiredArgsConstructor
public class SecretProviderFactory {

    private final SecurityConfig securityConfig;

    @Bean
    public SecretsProvider getSecretsProvider() {
        SecretProviderConfig currentSecretsProviderConfig = securityConfig.getCurrentSecretsProviderConfig();

        BaseSecretProvider provider = createSecretsProvider(currentSecretsProviderConfig);
        provider.readSecrets();

        return provider;
    }

    private BaseSecretProvider createSecretsProvider(SecretProviderConfig secretsProviderConfig) {
        return switch (secretsProviderConfig.getType()) {
            case LOCAL -> new LocalFileSecretsProvider(secretsProviderConfig);
            case VAULT -> new VaultSecretsProvider(secretsProviderConfig);
        };
    }

}
