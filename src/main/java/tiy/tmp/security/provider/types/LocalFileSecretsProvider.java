package tiy.tmp.security.provider.types;

import tiy.tmp.security.config.SecretProviderConfig;
import tiy.tmp.security.provider.BaseSecretProvider;

public class LocalFileSecretsProvider extends BaseSecretProvider {

    public LocalFileSecretsProvider(SecretProviderConfig config) {
        super(config);
    }

    @Override
    public String getSecret1() {
        return "LOCAL_SECRET_1";
    }

    @Override
    public String getSecret2() {
        return "LOCAL_SECRET_2";
    }
}
