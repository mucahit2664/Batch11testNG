package com.techproed.pages;

import com.techproed.utitilies.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AmazonPage {

    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //searchDropdownBox

    @FindBy(id = "searchDropdownBox")
    public WebElement allCategories;
    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;
    @FindBy(xpath = "//span[@class='a-price-whole']")
    public List<WebElement> tamKisimlarList;
    @FindBy(xpath = "//span[@class='a-price-fraction']")
    public List<WebElement> ondalikliKisimlar;
    @FindBy(id = "add-to-cart-button")
    public WebElement sepeteEkle;
    @FindBy(id = "nav-cart-count")
    public WebElement sepet;
    @FindBy(xpath = "//img[@class='sc-product-image']")
    public WebElement seciliUrun;

}
