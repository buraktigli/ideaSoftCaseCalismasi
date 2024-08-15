package Testler;

import org.junit.jupiter.api.AfterEach; //AfterEach annotation kullanimi icin "junit-jupiter-api" isimli Maven dependency pom.xml'e eklendi
import org.junit.jupiter.api.BeforeEach; //BeforeEach annotation kullanimi icin "junit-jupiter-api" isimli Maven dependency pom.xml'e eklendi
import org.junit.jupiter.api.Test; //Test annotation kullanimi icin "junit-jupiter-api" isimli Maven dependency pom.xml'e eklendi
import org.openqa.selenium.*; // WebDriver kullanmak icin
import org.openqa.selenium.chrome.ChromeDriver; // chrome driver kullanabilmek icin "selenium-chrome-driver" isimli Maven dependency pom.xml'e eklendi
import Sayfalar.*; //oluşturulan class'lara erişim için eklendi.

public class Tests {
    WebDriver driver;

    //sayfalar için tanımlamalar yapıldı.
    private AnaSayfa anaSayfa;
    private AramaSayfasi aramaSayfasi;
    private UrunSayfasi urunSayfasi;
    private SepetSayfasi sepetSayfasi;

    @BeforeEach
    void setup(){
        driver = new ChromeDriver();

        //sayfaların nesneleri oluşturuldu
        anaSayfa = new AnaSayfa(driver);
        aramaSayfasi = new AramaSayfasi(driver);
        urunSayfasi = new UrunSayfasi(driver);
        sepetSayfasi = new SepetSayfasi(driver);

        driver.manage().window().maximize(); //açılan chrome sayfasını tam ekran boyutu yapmak için kullanıldı.
        driver.get("https://testcase.myideasoft.com/"); //testcase.myideasoft sitesine gidildi.
                System.out.println("1.adim: vivense sitesi acildi.");
    }
    @Test
    void ideaSoftOtomasyonTesti() {

        anaSayfa.tusaBasName(anaSayfa.urunArama); //ürün arama butonuna tıklanır
        anaSayfa.ElementGozukeneKadarBekleName(anaSayfa.urunArama); //ürün arama butonu gözükene kadar beklendi.
        anaSayfa.searchYazName(anaSayfa.urunArama,"ürün"); //arama kısmına ürün yazıldı
        anaSayfa.ElementGozukeneKadarBekleName(anaSayfa.urunArama); //ürün arama butonu gözükene kadar beklendi.
                System.out.println("2.adim: arama butonuna urun yazildi.");
        anaSayfa.tusaBasCssSelector(anaSayfa.buyutecButonu); //arama yapılması için büyütece tıklandı.


        aramaSayfasi.ElementGozukeneKadarBekleXpath(aramaSayfasi.detayliArama); //büyütece tıkladıktan sonraki sayfa açılana kadar bekledi.
        aramaSayfasi.scrollYapma(aramaSayfasi.scroll); // scroll ile ekranı aşağı kaydırmak için kullanıldı
                System.out.println("3.adim: scroll ile asagi inildi.");
        aramaSayfasi.ElementGozukeneKadarBekleXpath(aramaSayfasi.urun); //ürünü görene kadar beklendi.
        aramaSayfasi.tusaBasXpath(aramaSayfasi.urunDetayi); //ürün detayı için tıklandı
                System.out.println("4.adim: urun detayina gidildi.");


        urunSayfasi.ElementGozukeneKadarBekleId(urunSayfasi.urunDetayiSayfasi); //ürün detayı açılana kadar beklendi.
        urunSayfasi.tusaBasId(urunSayfasi.urunAdetSecenekleri); //adet seçimi için tıklandı.
        urunSayfasi.ElementGozukeneKadarBekleXpath(urunSayfasi.urunAdetSecimi); //adet seçeneklerinden 5i görene kadar beklendi.
        urunSayfasi.tusaBasXpath(urunSayfasi.urunAdetSecimi); //adet 5 olarak seçildi.
                System.out.println("5.adim: urun adedi 5 olarak secildi.");
        urunSayfasi.ElementGozukeneKadarBekleXpath(urunSayfasi.urunAdetSecimi); //adet 5 olarak seçilene kadar beklendi.
        urunSayfasi.tusaBasXpath(urunSayfasi.sepeteEkleButonu); // ürün sepete eklendi.
                System.out.println("6.adim: urun sepete eklendi.");
        urunSayfasi.ElementGozukeneKadarBekleVeKiyaslaXpath(urunSayfasi.sepetIkonUstuSayi); //sepet ikonu üzerindeki sayı 5 olana kadar beklendi.
        urunSayfasi.yaziyiKontrolEtXpath(urunSayfasi.sepetinizeEklenmistirYazisi); //ekranda çıkan yazı ile beklenen yazı kıyaslanıldı.
                System.out.println("7.adim: ekranda cikan yazinin gorundugu kontrol edildi.");
        urunSayfasi.ElementYokOlanaKadarBekleXpath(urunSayfasi.sepetinizeEklenmistirYazisi); //yazı yok olana kadar beklendi.
        urunSayfasi.tusaBasXpath(urunSayfasi.sepetIkonu); //sepet sayfasına gidildi.
                System.out.println("8.adim: sepete gidildi.");


        sepetSayfasi.ElementGozukeneKadarBekleXpath(sepetSayfasi.sepetDetayi); //sepet detayı açılana kadar beklendi.
        sepetSayfasi.adediKontrolEtXpath(sepetSayfasi.sepettekiAdetSayisi); // sepetteki adet sayısı ile beklenen sayı kıyaslandı.
                System.out.println("9.adim: sepette urunden 5 adet oldugu goruldu.");//sepet içeriğinde ilgili üründen 5 adet olduğu kontrol edildi.

    }
    @AfterEach
    void teardown () {
      driver.quit();
    }
}