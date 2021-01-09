package com.techproed.tests;

import com.techproed.pages.GlbTraderHomePage;
import com.techproed.utitilies.ConfigReader;
import com.techproed.utitilies.Driver;
import com.techproed.utitilies.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GlbTraderHomePageTest {
    /*
    GlbTrader sayfasına girin ve giriş yapın
    Ilk safada kac tane link oldugunu konsola yazdir ve linklerin calisip calsimadiginia bakalim
    All Categories e gidin ve rastgele bir seçeneği seçin
    Seçmiş olduğunuz kategoride kaç tane ürün olduğunu listeleyin
    Bütün ürünleri yazıdırıp sıralayarak en düşük ve en yüksek ücretli olan ürünü bulun
    Ürünlere ait tüm bilgileri yazdırın
    İlk ürüne tıklayın
    Arttırma ve azatlma linklerinin aktif olup olmadığını kontrol edin
    Ürünü 1 artırın
    Sepete giderek ürünün görünüp görünmediğini assert edin
    Ürünün 1 arttırılıp arttırılmadığını assert edin.
    Remove buttonuna tıklayıp, ürünün seçimini kaldırın
    Allert i accept edin.
     */
    GlbTraderHomePage glbTrader = new GlbTraderHomePage();
    @Test
    public void test01() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("glb_link"));
        ReusableMethods.loginGlbTrader();
        int linkSayisi = glbTrader.tumLinkler.size();
        System.out.println(linkSayisi);
        for (WebElement w:glbTrader.tumLinkler) {
            Assert.assertTrue(w.isEnabled());
        }
        Thread.sleep(3000);
        Select select = new Select(glbTrader.allCategories);
        //ReusableMethods.selectRandomTextFromDropdown(select);
        select.selectByIndex(4);
        glbTrader.searchConfirm.click();

        int urunSayisi = glbTrader.fiyatListesi.size();
        System.out.println(urunSayisi+" kadar urun ilk sayfada vardır");
        List<Double> urunFiyatListesi = new ArrayList<>();
        for (int i=0; i<urunSayisi;i++){
            if(!glbTrader.fiyatListesi.isEmpty()){
                urunFiyatListesi.add(Double.valueOf(glbTrader.fiyatListesi.get(i).getText()));
            }
            else{
                System.out.println("Urun bilgisi bulunamadi");
            }
        }
        if (urunFiyatListesi.size()!=0) {
            Collections.sort(urunFiyatListesi);
            System.out.println("Siralanmiş liste " + urunFiyatListesi);
            System.out.println("En dusuk fiyatli urun " + urunFiyatListesi.get(0));
            System.out.println("En yuksek fiyatli urun " + urunFiyatListesi.get(urunFiyatListesi.size() - 1));
            for (WebElement w : glbTrader.urunBilgileri) {
                System.out.println(w.getText());
            }

            Thread.sleep(3000);
            glbTrader.urunBilgileri.get(0).click();
            Thread.sleep(3000);

            Assert.assertTrue(glbTrader.arttirmaLinki.isEnabled());
            Assert.assertTrue(glbTrader.azatlmaLinki.isEnabled());

            glbTrader.arttirmaLinki.click();
            glbTrader.addToCart.click();
            Thread.sleep(3000);


            Assert.assertTrue(glbTrader.sepettekiUrun.isDisplayed());

            // glbTrader.removeButton.click();

            ReusableMethods.waitAndClick(glbTrader.removeButton,3);


            String alertBeklenen = "Do You  want to delete ?";
            String alertGercek = Driver.getDriver().switchTo().alert().getText();
            Assert.assertEquals(alertBeklenen,alertGercek);
            Driver.getDriver().switchTo().alert().accept();





        }

    }

}