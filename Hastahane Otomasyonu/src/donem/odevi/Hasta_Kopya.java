package donem.odevi;

import java.io.Serializable;
import java.util.ArrayList;

public class Hasta_Kopya implements Serializable  {
    String ad,soyad;
    public ArrayList<String> hastalik=new ArrayList();
    public ArrayList<Ilac> eczaDolabi=new ArrayList();
    public String kullaniciAdi, sifre;
    public String gün, ay, yil;
    
    
    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }
    
    public void ilacTuketimi(Ilac ilac){
            if(ilac.miktar==0){
                System.out.println("Hiç ilacınız kalmamış!!!");
            }
            else{ 
                if(ilac.miktar<=10){
                    System.out.println("Lütfen en kısa zamanda ilaç alınız!!!");
                }
                ilac.miktar--;
            }
    }
    
    public void ilacAl(Ilac... ilac){
        for (int i = 0; i < hastalik.size(); i++) {
            for (int j = 0; j < ilac.length; j++) {
                if(hastalik.get(i)==ilac[j].neIlaci){
                    ilacAl(ilac[j]);
                }
                else{
                    System.out.println(hastalik.get(i)+" hastası birisine "+ilac[j].neIlaci+" ilacını veremem");
                }
            }
        }
    }
    
    public void ilacAl(Ilac ilac, int miktar){
        boolean varMi=false;
        for (int i = 0; i < hastalik.size(); i++) {
            if(hastalik.get(i)==ilac.neIlaci){
                ilacAl(miktar, ilac);
                varMi=true;
                break;
            }    
        }
        if(varMi==false){
            System.out.println("Sizde "+ilac.neIlaci+" hastalığı yok o yüzden ize bu ilacı veremem");
        }
    }
    
    private static void ilacAl(Ilac ilac){
            ilac.setMiktar(100);
    }
    
    private static void ilacAl(int miktar, Ilac ilac){
            ilac.setMiktar(miktar);
    }
    
    public void eczaDolabinaIlacEkle(Ilac... i1){
        for (int i = 0; i <i1.length; i++) {
            eczaDolabi.add(i1[i]);
        }
    }
}
