package tiy.tmp.security.config;

import lombok.Data;
import tiy.tmp.security.provider.SecretsProviderType;

import static java.util.Objects.requireNonNullElseGet;

@Data
public class SecretProviderConfig {

    private String id;
    private SecretsProviderType type;
    private String url;

    public SecretProviderConfig(String id, SecretsProviderType type, String url) {
//        System.out.println("SecretProviderConfig constructor: id = " + id + ", type = " + type + ", url = " + url);
        this.id = id;
        this.type = requireNonNullElseGet(type, () -> SecretsProviderType.valueOf(id.toUpperCase()));
        this.url = url;
//        System.out.println("type: " + this.type);
    }

}
