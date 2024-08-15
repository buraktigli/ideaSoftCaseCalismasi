package Sayfalar;

import org.openqa.selenium.WebDriver; //WebDriver kullanabilmek için eklendi.

public class AnaSayfa extends OrtakKullanim{ //OrtakKullanim class'ının extend'i olarak tanımlandı

    public AnaSayfa(WebDriver driver) {  //AnaSayfa constructor'ı oluşturuldu.
        super(driver);
    }

    //final key'i ile String'in farklı class'larda değiştirilmesi engellendi.
    public final String urunArama = "q"; // 'ürün' kelimesinin yazıldığı search kısmı
    public final String buyutecButonu = "[action] [width='24']"; // arama yapmak için tıklanılan büyüteç ikonu

}
