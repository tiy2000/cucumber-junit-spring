package tiy.tmp.security.provider.types;

import tiy.tmp.security.config.SecretProviderConfig;
import tiy.tmp.security.provider.BaseSecretProvider;

public class VaultSecretsProvider extends BaseSecretProvider {

    public VaultSecretsProvider(SecretProviderConfig config) {
        super(config);
    }

    @Override
    public String getSecret1() {
        return "VAULT_SECRET_1";
    }

    @Override
    public String getSecret2() {
        return "VAULT_SECRET_2";
    }
}
