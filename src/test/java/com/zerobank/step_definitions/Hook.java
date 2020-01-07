package com.zerobank.step_definitions;

import com.zerobank.utilities.Driver;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hook {
        @Before// buraya yazdigimiz before and after io.cucumber olacak ve bu kendiliginden baglaniyor.
        public void setup(){
            System.out.println("###################");
            System.out.println("Test setup!");
            Driver.get().manage().window().maximize();
        }

        @After
        public void teardown(Scenario scenario){
            if(scenario.isFailed()){
                System.out.println("Test failed");
                byte[] screenshot = ((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            }
            else{
                System.out.println("Cleanup!");
                System.out.println("Test completed!");
                System.out.println("###################");

                Driver.close();
            }
        }
    }

