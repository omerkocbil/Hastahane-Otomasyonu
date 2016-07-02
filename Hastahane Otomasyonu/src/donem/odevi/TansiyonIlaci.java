package donem.odevi;

import java.io.Serializable;

public class TansiyonIlaci extends Ilac implements Serializable {
    
    public static String tavsiye="Bu ilacı sürekli yanınızda taşıyınız, gerektiği zaman kullanacaksınız";
    
    public TansiyonIlaci(String isim){
        super.neIlaci="Tansiyon";
        super.ilacAdi=isim;
    }
    
}
