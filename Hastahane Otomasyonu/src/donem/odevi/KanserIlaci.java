package donem.odevi;

import java.io.Serializable;


public class KanserIlaci extends Ilac implements Serializable{
    
    public static String tavsiye="Bu ilacı sürekli yanınızda taşımalısınız, her zaman kullanacaksınız";
    
    public KanserIlaci(String isim){
        super.neIlaci="Kanser";
        super.ilacAdi=isim;
    }
    
}
