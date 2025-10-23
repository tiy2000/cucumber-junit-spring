package tiy.tmp.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import tiy.tmp.config.AppPlatformsConfig;
import tiy.tmp.config.AppiumConfig;
import tiy.tmp.config.dto.AppPlatform;
import tiy.tmp.config.dto.AppiumRunningProfile;

import static org.junit.Assert.assertEquals;

public class ConfigTestStepDefinitions {

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private AppPlatformsConfig appPlatformsConfig;

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private AppiumConfig appiumConfig;


    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private AppPlatform injectedAppPlatform;

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private AppiumRunningProfile injectedAppiumRunningProfile;


    private AppPlatform appPlatform;
    private AppiumRunningProfile appiumRunningProfile;


    @Given("Application was started")
    public void application_was_started() {
        // Do nothing
    }


    @When("I get platform {string}")
    public void iGetPlatform(String platformId) {
        appPlatform = appPlatformsConfig.getAppPlatform(platformId);
        System.out.println("Platform: " + appPlatform);
    }

    @When("I get current platform")
    public void iGetCurrentPlatform() {
        appPlatform = appPlatformsConfig.getCurrentAppPlatform();
        System.out.println("Current platform: " + appPlatform);
    }

    @When("I get current platform via bean injection")
    public void iGetCurrentPlatformViaBeanInjection() {
        appPlatform = injectedAppPlatform;
        System.out.println("Current platform (injected): " + appPlatform);
    }

    @Then("I should receive app name {string}")
    public void iShouldReceiveAppName(String expectedAppName) {
        assertEquals(expectedAppName, appPlatform.appName());
    }


    @When("I get appium running profile {string}")
    public void iGetAppiumRunningProfile(String appiumRunningProfileId) {
        appiumRunningProfile = appiumConfig.getRunningProfile(appiumRunningProfileId);
        System.out.println("Appium running profile: " + appiumRunningProfile);
    }

    @When("I use current appium running profile")
    public void iUseCurrentAppiumRunningProfile() {
        appiumRunningProfile = appiumConfig.getCurrentRunningProfile();
        System.out.println("Current Appium running profile: " + appiumRunningProfile);
    }

    @When("I use current appium running profile via bean injection")
    public void iUseCurrentAppiumRunningProfileViaBeanInjection() {
        appiumRunningProfile = injectedAppiumRunningProfile;
        System.out.println("Current Appium running profile (injected): " + appiumRunningProfile);
    }

    @Then("I should receive url {string}")
    public void iShouldReceiveUrl(String expectedUrl) {
        assertEquals(expectedUrl, appiumRunningProfile.appiumServerUrl());
    }
}
