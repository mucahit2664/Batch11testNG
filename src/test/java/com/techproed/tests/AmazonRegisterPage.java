package com.techproed.tests;

import com.techproed.utitilies.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import javax.swing.*;

public class AmazonRegisterPage extends TestBase {
     /*
         Amazon.com a gidelim
        // 1. Adım : Mouse'u moveToElement methodunu kullanarak, Account & Lists
        //           webelementinin üzerine götürün.
        // 2. Adım : Start here. linkine tıklayın.
        3. Adım  Başlığın Amazon Registration a eşit olup olmadığını kontrol edin
        4. adım yeni bir method oluşturarak kayıt olun

        // name id =ap_customer_name
        email id =ap_email
        password = ap_password
        repassword = ap_password_check
        submit = id=continue
         */

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");

        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountList).perform();

        WebElement startHere = driver.findElement(By.xpath("//*[.='Start here.']"));
        startHere.click();

        Assert.assertTrue(driver.getTitle().equals("Amazon Registration"));


    }

    @Test (dependsOnMethods = "test01")
    public void test02(){

        driver.findElement(By.id("ap_customer_name")).sendKeys("Tulin Mungan");
        driver.findElement(By.id("ap_email")).sendKeys("tmungan.techproed@gmail.com");
        driver.findElement(By.id("ap_password")).sendKeys("Werty123");
        driver.findElement(By.id("ap_password_check")).sendKeys("Werty123");
        driver.findElement(By.id("continue")).submit();

    }

}