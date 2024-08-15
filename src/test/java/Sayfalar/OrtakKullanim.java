package Sayfalar;

import org.junit.jupiter.api.Assertions; //Assortions kullanımı için "junit-jupiter-api" isimli Maven dependency pom.xml'e eklendi
import org.openqa.selenium.By; //By. fonksiyonunu kullanabilmek için eklendi.
import org.openqa.selenium.JavascriptExecutor; //scroll işlemi yapabilmek için eklendi.
import org.openqa.selenium.WebDriver; //WebDriver kullanabilmek için eklendi.
import org.openqa.selenium.support.ui.ExpectedConditions; // ExpectedConditions kullanabilmek icin "selenium-support" isimli Maven dependency pom.xml'e eklendi.
import org.openqa.selenium.support.ui.WebDriverWait; // WebDriverWait kullanabilmek icin "selenium-support" isimli Maven dependency pom.xml'e eklendi.
import java.time.Duration; //dinamic wait methodunu kullanabilmek için eklendi.

public class OrtakKullanim {
    private WebDriver driver;

    public OrtakKullanim(WebDriver driver) { //OrtakKullanim constructor'ı oluşturuldu.
        this.driver = driver;
    }

    //wait methodu /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void ElementGozukeneKadarBekleId(String elementId){ //id locater'ı için wait methodu tanımlandı
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(elementId))); //presenceOfElementLocated = sayfada bir elementin olup olmadığı koşulu
    }
    public void ElementGozukeneKadarBekleXpath(String elementXpath){ //xpath locater'ı için wait methodu tanımlandı
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));//presenceOfElementLocated = sayfada bir elementin olup olmadığı koşulu
    }
    public void ElementGozukeneKadarBekleName(String elementName){ //name locater'ı için wait methodu tanımlandı
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name(elementName)));//presenceOfElementLocated = sayfada bir elementin olup olmadığı koşulu
    }
    public void ElementGozukeneKadarBekleVeKiyaslaXpath(String elementXpath){ //name locater'ı için wait methodu tanımlandı
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(elementXpath),"5")); //sepet ikonu üzerindeki sayı 5 olana kadar beklendi.
    }
    public void ElementYokOlanaKadarBekleXpath(String elementXpath){ //name locater'ı için wait methodu tanımlandı
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(elementXpath)));//yazı yok olana kadar beklendi.
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //click methodu /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void tusaBasId(String tusId){
        driver.findElement(By.id(tusId)).click();
    }

    public void tusaBasXpath(String tusXpath){
        driver.findElement(By.xpath(tusXpath)).click();
    }

    public void tusaBasCssSelector(String tusCssSelector){
        driver.findElement(By.cssSelector(tusCssSelector)).click();
    }

    public void tusaBasName(String tusName){
        driver.findElement(By.name(tusName)).click();
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    //sendKeys methodu //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void searchYazName(String searchId, String aranacakKelime){
        driver.findElement(By.name(searchId)).sendKeys(aranacakKelime);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //scroll methodu ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void scrollYapma(String scrollBy){
    JavascriptExecutor jsx = (JavascriptExecutor) driver; // scroll ile ekranı aşağı kaydırmak için. bir kere tanımlama yeterli
        jsx.executeScript(scrollBy);  // scroll ile ekranı aşağı kaydırmak için
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //Assertions methodu ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void yaziyiKontrolEtXpath(String getTextId){
        String ekrandaCikanYazi = driver.findElement(By.xpath(getTextId)).getText(); //ekranda çıkan yazı kaydedildi
        Assertions.assertEquals("SEPETİNİZE EKLENMİŞTİR",ekrandaCikanYazi); //kaydedilen yazı ile beklenen yazı kıyaslandı.
    }

    public void adediKontrolEtXpath(String getTextId){
        String adetSayisi= driver.findElement(By.xpath(getTextId)).getText(); //sepetteki adet sayısı kaydedildi.
        Assertions.assertEquals("5",adetSayisi); //kaydedilen sayı ile beklenen sayı kıyaslandı.
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


}


