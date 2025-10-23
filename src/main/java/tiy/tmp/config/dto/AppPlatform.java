package tiy.tmp.config.dto;

public record AppPlatform(
        String id,
        String platformVersion,
        String appName,
        String deviceName,
        String locale) {
}
