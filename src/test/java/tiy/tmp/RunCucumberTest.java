package tiy.tmp;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.FILTER_TAGS_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber") // Работает без
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "tiy.tmp")   // Работает без
//@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@Calc")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@Plus")
@SelectClasspathResource("features")
public class RunCucumberTest {
}
