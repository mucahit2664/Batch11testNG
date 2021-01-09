package com.techproed.pages;



import com.techproed.utitilies.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GlbTraderHomePage {
    public GlbTraderHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "header_search_category")
    public WebElement allCategories;
    @FindBy(xpath = "//a")
    public List<WebElement> tumLinkler;
    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement searchConfirm;
    @FindBy(xpath = "//label[@class='list_price_set']")
    public List<WebElement> fiyatListesi;
    @FindBy(xpath = "//h4[@class='icon-hotproduct']")
    public List<WebElement> urunBilgileri;
    @FindBy(xpath = "//a[@class='plus']")
    public WebElement arttirmaLinki;
    @FindBy(xpath = "//a[@class='minus']")
    public WebElement azatlmaLinki;
    @FindBy(name = "buynow_submit")
    public WebElement addToCart;
    @FindBy(xpath = "//img[@class='img-responsive']")
    public WebElement sepettekiUrun;
    @FindBy(xpath = "//div[@class='col-md-1 col-xs-4']")
    public WebElement arttirmaCheck;
    @FindBy(linkText = "Remove")
    public WebElement removeButton;
}