package tiy.tmp.security.provider;

public interface SecretsProvider {

    // Approach 1
    String getSecret1();
    String getSecret2();

    // Approach 2
    String getSecret(String secretId);
    <T> T getSecret(String secretId, Class<T> dtoClass);

}
