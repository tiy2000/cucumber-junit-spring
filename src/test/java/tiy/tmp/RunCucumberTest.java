package tiy.tmp;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber") // Работает без
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "tiy.tmp")   // Работает без
@SelectClasspathResource("features")
public class RunCucumberTest {
}
