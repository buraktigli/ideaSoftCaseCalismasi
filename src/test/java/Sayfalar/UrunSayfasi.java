package Sayfalar;

import org.openqa.selenium.WebDriver; //WebDriver kullanabilmek için eklendi.

public class UrunSayfasi extends OrtakKullanim{ //OrtakKullanim class'ının extend'i olarak tanımlandı

    public UrunSayfasi(WebDriver driver) {  //UrunSayfasi constructor'ı oluşturuldu.

        super(driver);
    }

    //final key'i ile String'in farklı class'larda değiştirilmesi engellendi.
    public final String urunDetayiSayfasi = "main"; // açılan ürün detay sayfası
    public final String urunAdetSecenekleri = "qty-input"; // ürün adet seçeneklerinin açılması butonu
    public final String urunAdetSecimi = "//option[.='5']"; // ürün adetinin 5 seçilmesi
    public final String sepeteEkleButonu = "//a[contains(.,'SEPETE EKLE')]"; //sepete ekle butonu
    public final String sepetIkonUstuSayi = "//div[@class='cart-amount']"; //sağ üstteki sepet ikonunun üzerinde 0 iken 5 olan değişken sayı
    public final String sepetinizeEklenmistirYazisi = "//div[@class='shopping-information-cart-inside']"; //sepete ekle butonuna bastıktan sonra ekranda çıkan yazı
    public final String sepetIkonu = "//a[@href='/sepet']"; //sağ üstteki sepet ikonu
}
