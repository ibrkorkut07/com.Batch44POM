package tests.day16;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

import java.util.concurrent.locks.AbstractOwnableSynchronizer;
/*
Amazon'a gidelim
arama kutusuna Nutella (test01) / Java (test02) yazip aratalim
Atama sonuclarinin Nutella / Java icerdigini test edelim
*/
public class C02_PageIlkClass {

    //POM'de farkli class'lara farkli sekilde ulasilmasi benimsenmistir
    // Driver class'i icin static yontemi kullaniyoruz
    // Page Class'lari icin ise obje uzerinden kullanilmasi tercih edilmistir
    @Test
    public void test01(){
        // Amazon'a gidelim
        Driver.getDriver().get("https://www.amazon.com");
        // arama kutusuna Nutella yazip aratalim
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // Atama sonuclarinin Nutella icerdigini test edelim
        String actualSonucStr=amazonPage.sonucYazisiElementi.getText();
        Assert.assertTrue(actualSonucStr.contains("Nutella"));

        Driver.closeDriver();
    }

    @Test(groups = {"miniRegression","smoke"})
    public void test02(){
        // amazona gidelim
        Driver.getDriver().get("https://www.amazon.com");
        //java icin arama yapalim
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("java"+Keys.ENTER);
        // sonucun java icerdigini test edelim
        String sonucYazisiStr=amazonPage.sonucYazisiElementi.getText();

        Assert.assertTrue(sonucYazisiStr.contains("java"));
        Driver.closeDriver();
    }
}