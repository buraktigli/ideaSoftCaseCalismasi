package Sayfalar;

import org.openqa.selenium.WebDriver; //WebDriver kullanabilmek için eklendi.

public class AramaSayfasi extends OrtakKullanim{ //OrtakKullanim class'ının extend'i olarak tanımlandı

    public AramaSayfasi(WebDriver driver) {  //AramaSayfasi constructor'ı oluşturuldu.

        super(driver);
    }

    //final key'i ile String'in farklı class'larda değiştirilmesi engellendi.
    public final String detayliArama = "//h4[.='Detaylı Arama']"; //arama sayfasındaki 'detaylı arama' yazısı
    public final String urun = "//div[@class='showcase-content']"; // arama yaptığımız ürünün gözükmesi
    public final String urunDetayi = "//div[@class='showcase-image showcase-image-vertical']/a[@href='/urun/urun']"; //ürün detayına gitmek için ürüne tıklanması

    public final String scroll = "window.scrollBy(0,500)";

}
