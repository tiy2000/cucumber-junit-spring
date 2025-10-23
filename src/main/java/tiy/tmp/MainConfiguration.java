package tiy.tmp;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import tiy.tmp.config.YamlPropertySourceFactory;

@Configuration
@ComponentScan
@ConfigurationPropertiesScan    // For custom yaml configuration
@PropertySource(value = "classpath:config.yaml", factory = YamlPropertySourceFactory.class)
public class MainConfiguration {
}
