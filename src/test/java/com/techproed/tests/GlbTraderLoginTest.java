package com.techproed.tests;


import com.techproed.utitilies.ConfigReader;
import com.techproed.utitilies.Driver;
import com.techproed.utitilies.ReusableMethods;
import org.testng.annotations.Test;

public class GlbTraderLoginTest  {

    @Test
     public void test01() throws InterruptedException {
    Driver.getDriver().get(ConfigReader.getProperty("glb_link"));
        Thread.sleep(5000);
        ReusableMethods.loginGlbTrader();
     //   Driver.closeDriver();

    }


}
