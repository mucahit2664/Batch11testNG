package com.techproed.pages;


import com.techproed.utitilies.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbTraderSignUp {

    public GlbTraderSignUp() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "email")
    public WebElement Email;
    @FindBy (id = "password")
    public WebElement password;
    @FindBy (linkText = "Sign In")
    public WebElement signIn;



}