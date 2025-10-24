package tiy.tmp.security.provider;

import lombok.RequiredArgsConstructor;
import tiy.tmp.security.config.SecretProviderConfig;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public abstract class BaseSecretProvider implements SecretsProvider {

    protected final SecretProviderConfig config;

    protected Map<String, String> secrets = new HashMap<>();

    @Override
    public String getSecret(String secretId) {
        return secrets.get(secretId);
    }

    public void readSecrets() {
        System.out.println("Secrets provider " + config.getType() + " reads secrets");
    }
}
