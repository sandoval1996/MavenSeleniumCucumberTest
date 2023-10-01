package com.store.utils;


import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.time.Duration;

public class Hooks extends Base {


        @Before
        public void setUp()
        {
            driver = new FirefoxDriver();
            FirefoxOptions options = new FirefoxOptions();
            options.addPreference("browser.private.browsing.autostart", true);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get(url);

        }

        @AfterStep
        public void takeScreen(Scenario scenario)
        {
            final byte[] screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screen, "image/png", "failed");
        }

       @After
        public void tearDown()
    {
        driver.quit();
    }




}
