package donem.odevi;

import java.io.Serializable;

public class SogukAlginligiIlaci extends Ilac implements Serializable{
    
    public static String tavsiye="Bu ilacı sürekli yanınızda taşımanıza gerek yok, yılın belli dönemlerinde kullanacaksınız";
    
    public SogukAlginligiIlaci(String isim){
        super.neIlaci="Soğuk Algınlığı";
        super.ilacAdi=isim;
    }
    
}
