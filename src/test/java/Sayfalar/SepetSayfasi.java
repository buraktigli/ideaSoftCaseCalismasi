package Sayfalar;

import org.openqa.selenium.WebDriver; //WebDriver kullanabilmek için eklendi.

public class SepetSayfasi extends OrtakKullanim{ //OrtakKullanim class'ının extend'i olarak tanımlandı

    public SepetSayfasi(WebDriver driver) {  //SepetSayfasi constructor'ı oluşturuldu.

        super(driver);
    }

    //final key'i ile String'in farklı class'larda değiştirilmesi engellendi.
    public final String sepetDetayi = "//h4[.='SEPET DETAYI']"; //sepet sayfası açıldıktan sonra karşımıza çıkan sepet detayı başlığı
    public final String sepettekiAdetSayisi = "//div[@class='cart-amount']"; // sepette gözüken adet sayısı

}
