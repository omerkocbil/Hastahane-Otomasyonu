package donem.odevi;

import java.io.Serializable;

public class Ilac implements Serializable {
    public String ilacAdi;
    int miktar;
    String neIlaci;
    String tavsiye;
    
    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }
}
