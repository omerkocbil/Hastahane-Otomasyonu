/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donem.odevi.test;

import donem.odevi.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.*;


/**
 *
 * @author Bogdanovic44
 */
public class HastaFormu extends javax.swing.JFrame {
    String kanserTeshisi;
    String sogukAlginligiTeshisi;
    String tansiyonTeshisi;
    ArrayList<JCheckBox> belirti=new ArrayList();
    DefaultListModel<String> dlm=new DefaultListModel();
    String kk,sak,tk;
    Hasta hasta=null;
    
    /**
     * Creates new form HastaFormu
     */
    public HastaFormu() {
        initComponents();
        jButton3.setVisible(false);
        jLabel21.setVisible(false);
        jLabel23.setVisible(false);
        istenilenleriYap();
        JCheckBox[] cb={jCheckBox1,jCheckBox2,jCheckBox3,jCheckBox4,jCheckBox5,jCheckBox6,
                jCheckBox7,jCheckBox8,jCheckBox9,jCheckBox10,jCheckBox11};
        for (int i = 0; i < cb.length; i++) {
            cb[i].setVisible(false);
        }
        jButton1.setVisible(false);
        jLabel3.setVisible(false);
    }
    
    public Hasta hastayıBul(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Omer_Kocbil_1321221009_BP2_ODEV2PU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT h FROM Hasta h WHERE h.hastaPK.kullaniciAdi=:hAdi");
        q.setParameter("hAdi", Hastahane.h1.getHastaPK().getKullaniciAdi());
        hasta=(Hasta)q.getSingleResult();
        return hasta;
    }
    
    public void istenilenleriYap(){
            int j=0;
                String[] dizi={Hastahane.h1.getHastaliK1(),Hastahane.h1.getHastaliK2(),Hastahane.h1.getHastaliK3()};
                JLabel[] label={jLabel5,jLabel7,jLabel8};
                for (int i = 0; i < dizi.length; i++) {
                    if (dizi[i] != null) {
                        label[j].setText(dizi[i]);
                        j++;
                    }
                }
                if(j==0){
                    jLabel5.setText("Hiçbir hastalığa sahip değilsiniz");
                    jLabel7.setVisible(false);
                    jLabel8.setVisible(false);
                }
                else if (j == 1) {
                    jLabel7.setVisible(false);
                    jLabel8.setVisible(false);
                } else if (j == 2) {
                    jLabel8.setVisible(false);
                }
            j=0;
            JLabel[] label2={jLabel11,jLabel12,jLabel13,jLabel14,jLabel15,jLabel16,jLabel17,jLabel18,jLabel19};
                String[] dizi2={Hastahane.h1.getIlac1(),Hastahane.h1.getIlac2(),Hastahane.h1.getIlac3(),Hastahane.h1.getIlac4(),Hastahane.h1.getIlac5(),Hastahane.h1.getIlac6(),Hastahane.h1.getIlac7(),Hastahane.h1.getIlac8(),Hastahane.h1.getIlac9()};
                for (int i = 0; i < dizi2.length; i++) {
                    if (dizi2[i] != null) {
                        label2[j].setText(dizi2[i]);
                        j++;
                    }
                }
                if(j==0){
                    jLabel11.setText("Almış olduğunuz bir ilaç bulunmuyor");
                for (int i = 1; i < label2.length; i++) {
                    label2[i].setVisible(false);
                }
                jButton5.setVisible(false);
                }
                else if (j == 2) {
                    for (int i = 2; i < label2.length; i++) {
                        label2[i].setVisible(false);
                    }
                } else if (j == 4) {
                    for (int i = 4; i < label2.length; i++) {
                        label2[i].setVisible(false);
                    }
                } else if (j == 5) {
                    for (int i = 5; i < label2.length; i++) {
                        label2[i].setVisible(false);
                    }
                } else if (j == 6) {
                    for (int i = 6; i < label2.length; i++) {
                        label2[i].setVisible(false);
                    }
                } else if (j == 7) {
                    for (int i = 7; i < label2.length; i++) {
                        label2[i].setVisible(false);
                    }
                } else if (j == 8) {
                    for (int i = 8; i < label2.length; i++) {
                        label2[i].setVisible(false);
                    }
                }
            j=0;
            jLabel20.setVisible(false);
            jTextField1.setText(Hastahane.h1.getAd());
            jTextField2.setText(Hastahane.h1.getSoyad());
            jTextField3.setText(Hastahane.h1.getHastaPK().getKullaniciAdi());
            jTextField4.setText(Hastahane.h1.getSifre()); 
            jTextField5.setText(String.valueOf(Hastahane.h1.hastaPK.getHastaId()));
    }       
    
    public boolean doluMu(){
        boolean doluMu=true;
        JCheckBox[] cb={jCheckBox1,jCheckBox2,jCheckBox3,jCheckBox4,jCheckBox5,jCheckBox6,
                        jCheckBox7,jCheckBox8,jCheckBox9,jCheckBox10,jCheckBox11};
        for (int i = 0; i < cb.length; i++) {
            if(cb[i].isSelected()==true){
                doluMu=true;
                break;
            }
            else{
                doluMu=false;
            }
        }
        return doluMu;
    }
    
    public  String kanserKontrolu(){
        JCheckBox[] cb={jCheckBox1,jCheckBox2,jCheckBox3,jCheckBox4,jCheckBox5,jCheckBox6,
                jCheckBox7,jCheckBox8,jCheckBox9,jCheckBox10,jCheckBox11};
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Omer_Kocbil_1321221009_BP2_ODEV2PU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT h FROM Hastalik h WHERE h.ad=:hAdi");
        q.setParameter("hAdi","Kanser");
        Hastalik h=(Hastalik)q.getSingleResult();
        String[] dizi={h.getBelirti1(),h.getBelirti2(),h.getBelirti3(),h.getBelirti4()};     
            int belirtiAnalizi=0;
            for (int i = 0; i < cb.length; i++) {
                if(cb[i].isSelected()==true){
                    for (int j = 0; j < dizi.length; j++) {
                        if(cb[i].getText().equals(dizi[j])){
                            belirtiAnalizi++;
                        }
                    }
                    
                }
            }
            em.close();
            emf.close();
            EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("Omer_Kocbil_1321221009_BP2_ODEV2PU");
            EntityManager em2 = emf2.createEntityManager();
            
            if(belirtiAnalizi>2){
                kanserTeshisi="İleri düzeyde kanser teşhisi konulmuştur";
                Query q2=em2.createQuery("UPDATE Hasta a SET a.hastaliK1 = :hH WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                q2.setParameter("hAdi",jTextField3.getText());
                q2.setParameter("hH","Kanser");
                em2.getTransaction().begin();
                q2.executeUpdate();
                em2.getTransaction().commit();
            }
            else if(belirtiAnalizi>=1){
                kanserTeshisi="Başlangıç düzeyinde kanser teşhisi konulmuştur";
                Query q2=em2.createQuery("UPDATE Hasta a SET a.hastaliK1 = :hH WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                q2.setParameter("hAdi",jTextField3.getText());
                q2.setParameter("hH","Kanser");
                em2.getTransaction().begin();
                q2.executeUpdate();
                em2.getTransaction().commit();
            }
            else{
                kanserTeshisi="";
            }
            
            em2.close();
            emf2.close();
        return kanserTeshisi;
    }
    
    public String sogukAlginligiKontrolu(){
        JCheckBox[] cb={jCheckBox1,jCheckBox2,jCheckBox3,jCheckBox4,jCheckBox5,jCheckBox6,
                jCheckBox7,jCheckBox8,jCheckBox9,jCheckBox10,jCheckBox11};
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Omer_Kocbil_1321221009_BP2_ODEV2PU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT h FROM Hastalik h WHERE h.ad=:hAdi");
        q.setParameter("hAdi","Soğuk Algınlığı");
        Hastalik h=(Hastalik)q.getSingleResult();
        String[] dizi={h.getBelirti1(),h.getBelirti2(),h.getBelirti3(),h.getBelirti4()};     
            int belirtiAnalizi=0;
            for (int i = 0; i < cb.length; i++) {
                if(cb[i].isSelected()==true){
                    for (int j = 0; j < dizi.length; j++) {
                        if(cb[i].getText().equals(dizi[j])){
                            belirtiAnalizi++;
                        }
                    }
                    
                }
            }
            em.close();
            emf.close();
            EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("Omer_Kocbil_1321221009_BP2_ODEV2PU");
            EntityManager em2 = emf2.createEntityManager();
            hasta=hastayıBul();
            if(belirtiAnalizi>2){
                sogukAlginligiTeshisi="İleri düzeyde soğuk algınlığı teşhisi konulmuştur";
                if(hasta.getHastaliK1()==null){
                    Query q2 = em2.createQuery("UPDATE Hasta a SET a.hastaliK1 = :hH WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                    q2.setParameter("hAdi", jTextField3.getText());
                    q2.setParameter("hH", "Soğuk Algınlığı");
                    em2.getTransaction().begin();
                    q2.executeUpdate();
                    em2.getTransaction().commit();
                }
                else{
                    Query q2 = em2.createQuery("UPDATE Hasta a SET a.hastaliK2 = :hH WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                    q2.setParameter("hAdi", jTextField3.getText());
                    q2.setParameter("hH", "Soğuk Algınlığı");
                    em2.getTransaction().begin();
                    q2.executeUpdate();
                    em2.getTransaction().commit();
                }
            }
            else if(belirtiAnalizi>=1){
                sogukAlginligiTeshisi="Başlangıç düzeyinde soğuk algınlığı teşhisi konulmuştur";
                if(hasta.getHastaliK1()==null){
                    Query q2 = em2.createQuery("UPDATE Hasta a SET a.hastaliK1 = :hH WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                    q2.setParameter("hAdi", jTextField3.getText());
                    q2.setParameter("hH", "Soğuk Algınlığı");
                    em2.getTransaction().begin();
                    q2.executeUpdate();
                    em2.getTransaction().commit();
                }
                else{
                    Query q2 = em2.createQuery("UPDATE Hasta a SET a.hastaliK2 = :hH WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                    q2.setParameter("hAdi", jTextField3.getText());
                    q2.setParameter("hH", "Soğuk Algınlığı");
                    em2.getTransaction().begin();
                    q2.executeUpdate();
                    em2.getTransaction().commit();
                }
            }
            else{
                sogukAlginligiTeshisi="";
            }
            em2.close();
            emf2.close();
        return sogukAlginligiTeshisi;
    }
    
    public String tansiyonKontrolu(){
        JCheckBox[] cb={jCheckBox1,jCheckBox2,jCheckBox3,jCheckBox4,jCheckBox5,jCheckBox6,
                jCheckBox7,jCheckBox8,jCheckBox9,jCheckBox10,jCheckBox11};
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Omer_Kocbil_1321221009_BP2_ODEV2PU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT h FROM Hastalik h WHERE h.ad=:hAdi");
        q.setParameter("hAdi","Tansiyon");
        Hastalik h=(Hastalik)q.getSingleResult();
        String[] dizi={h.getBelirti1(),h.getBelirti2(),h.getBelirti3(),h.getBelirti4()};     
            int belirtiAnalizi=0;
            for (int i = 0; i < cb.length; i++) {
                if(cb[i].isSelected()==true){
                    for (int j = 0; j < dizi.length; j++) {
                        if(cb[i].getText().equals(dizi[j])){
                            belirtiAnalizi++;
                        }
                    }
                    
                }
            }
            em.close();
            emf.close();
            EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("Omer_Kocbil_1321221009_BP2_ODEV2PU");
            EntityManager em2 = emf2.createEntityManager();
            hasta=hastayıBul();
            if(belirtiAnalizi>2){
                tansiyonTeshisi="İleri düzeyde tansiyon teşhisi konulmuştur";
                if(hasta.getHastaliK1()==null){
                    Query q2 = em2.createQuery("UPDATE Hasta a SET a.hastaliK1 = :hH WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                    q2.setParameter("hAdi", jTextField3.getText());
                    q2.setParameter("hH", "Tansiyon");
                    em2.getTransaction().begin();
                    q2.executeUpdate();
                    em2.getTransaction().commit();
                }
                else if(hasta.getHastaliK2()==null){
                    Query q2 = em2.createQuery("UPDATE Hasta a SET a.hastaliK2 = :hH WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                    q2.setParameter("hAdi", jTextField3.getText());
                    q2.setParameter("hH", "Tansiyon");
                    em2.getTransaction().begin();
                    q2.executeUpdate();
                    em2.getTransaction().commit();
                }
                else{
                    Query q2 = em2.createQuery("UPDATE Hasta a SET a.hastaliK3 = :hH WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                    q2.setParameter("hAdi", jTextField3.getText());
                    q2.setParameter("hH", "Tansiyon");
                    em2.getTransaction().begin();
                    q2.executeUpdate();
                    em2.getTransaction().commit();
                }
            }
            else if(belirtiAnalizi>=1){
                tansiyonTeshisi="Başlangıç düzeyinde tansiyon teşhisi konulmuştur";
                if(hasta.getHastaliK1()==null){
                    Query q2 = em2.createQuery("UPDATE Hasta a SET a.hastaliK1 = :hH WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                    q2.setParameter("hAdi", jTextField3.getText());
                    q2.setParameter("hH", "Tansiyon");
                    em2.getTransaction().begin();
                    q2.executeUpdate();
                    em2.getTransaction().commit();
                }
                else if(hasta.getHastaliK2()==null){
                    Query q2 = em2.createQuery("UPDATE Hasta a SET a.hastaliK2 = :hH WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                    q2.setParameter("hAdi", jTextField3.getText());
                    q2.setParameter("hH", "Tansiyon");
                    em2.getTransaction().begin();
                    q2.executeUpdate();
                    em2.getTransaction().commit();
                }
                else{
                    Query q2 = em2.createQuery("UPDATE Hasta a SET a.hastaliK3 = :hH WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                    q2.setParameter("hAdi", jTextField3.getText());
                    q2.setParameter("hH", "Tansiyon");
                    em2.getTransaction().begin();
                    q2.executeUpdate();
                    em2.getTransaction().commit();
                }
            }
            else{
                tansiyonTeshisi="";
            }
            em2.close();
            emf2.close();
        return tansiyonTeshisi;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hasta Otomasyonu");

        jLabel1.setText("İsmi Değiştir:");

        jLabel2.setText("Soyismi Değiştir:");

        jLabel4.setText("Kullanıcı Adını Değiştir:");

        jLabel9.setText("Şifreni Değiştir:");

        jButton2.setText("Değişkilikleri Kaydet");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel22.setText("Hasta ID: ");

        jTextField5.setForeground(new java.awt.Color(255, 0, 0));
        jTextField5.setEnabled(false);

        jButton7.setText("Detaylı Ekran");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9)
                            .addComponent(jLabel22))
                        .addGap(46, 46, 46)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(174, Short.MAX_VALUE))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7)
                        .addGap(53, 53, 53))))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton7))
                .addGap(18, 18, 18))
        );
        jLayeredPane2.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jTextField3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jTextField4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel22, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jTextField5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jButton7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("Profil", jLayeredPane2);

        jLabel5.setText("jLabel1");

        jLabel7.setText("jLabel2");

        jLabel8.setText("jLabel4");

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addContainerGap(447, Short.MAX_VALUE))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addContainerGap(187, Short.MAX_VALUE))
        );
        jLayeredPane3.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("Hastalıklarım", jLayeredPane3);

        jLabel11.setText("jLabel11");

        jLabel12.setText("jLabel12");

        jLabel13.setText("jLabel13");

        jLabel14.setText("jLabel14");

        jLabel15.setText("jLabel15");

        jLabel16.setText("jLabel16");

        jLabel17.setText("jLabel17");

        jLabel18.setText("jLabel18");

        jLabel19.setText("jLabel19");

        jButton5.setText("İlaç Takibi");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addGap(33, 33, 33))))
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18))))
        );
        jLayeredPane4.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel16, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel17, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel18, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel19, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("İlaçlarım", jLayeredPane4);

        jCheckBox2.setText("Burun Akıntısı");
        jCheckBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox11İtemStateChanged(evt);
            }
        });

        jCheckBox3.setText("Halsizlik");
        jCheckBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox11İtemStateChanged(evt);
            }
        });

        jCheckBox4.setText("Cilt Değişimleri");
        jCheckBox4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox11İtemStateChanged(evt);
            }
        });

        jCheckBox5.setText("Kulak Çınlaması");
        jCheckBox5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox11İtemStateChanged(evt);
            }
        });

        jCheckBox6.setText("Çarpıntı");
        jCheckBox6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox11İtemStateChanged(evt);
            }
        });

        jCheckBox7.setText("Baş Ağrısı");
        jCheckBox7.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox11İtemStateChanged(evt);
            }
        });

        jCheckBox8.setText("Ateş");
        jCheckBox8.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox11İtemStateChanged(evt);
            }
        });

        jCheckBox9.setText("Öksürük");
        jCheckBox9.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox11İtemStateChanged(evt);
            }
        });

        jCheckBox10.setText("Aşırı Kilo Kaybı");
        jCheckBox10.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox11İtemStateChanged(evt);
            }
        });

        jLabel3.setText("Şikayetleriniz:");

        jCheckBox11.setText("Yukarıdaki belirtilerden hiçbirine sahip değilim");
        jCheckBox11.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox11İtemStateChanged(evt);
            }
        });

        jCheckBox1.setText("Şiddetli Karın Ağrısı");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox11İtemStateChanged(evt);
            }
        });

        jButton1.setText("Formu Gönder");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Reçeteyi Göster");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel21.setText("jLabel21");

        jLabel10.setText("Randevu Sıra Kodunuz:");

        jButton6.setText("Onayla");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel23.setText("Başarılı kod!!!");

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jCheckBox11)
                                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCheckBox1)
                                        .addComponent(jCheckBox3)
                                        .addComponent(jCheckBox5)
                                        .addComponent(jCheckBox7)
                                        .addComponent(jCheckBox9))
                                    .addGap(39, 39, 39)
                                    .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCheckBox4)
                                        .addComponent(jCheckBox2)
                                        .addComponent(jCheckBox6)
                                        .addComponent(jCheckBox8)
                                        .addComponent(jCheckBox10))))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(31, 31, 31))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox5)
                    .addComponent(jCheckBox6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox7)
                    .addComponent(jCheckBox8))
                .addGap(7, 7, 7)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox9)
                    .addComponent(jCheckBox10))
                .addGap(8, 8, 8)
                .addComponent(jCheckBox11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton1)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jLabel21))
        );
        jLayeredPane1.setLayer(jCheckBox2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jCheckBox3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jCheckBox4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jCheckBox5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jCheckBox6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jCheckBox7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jCheckBox8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jCheckBox9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jCheckBox10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jCheckBox11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jCheckBox1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel21, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jTextField6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel23, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("Şikayetleriniz", jLayeredPane1);

        jButton4.setText("Ana Sayfaya Dön");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel20.setText("jLabel20");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel20)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(doluMu()==false){
            JOptionPane.showMessageDialog(this, "Lütfen şikayetinizi belirtiniz veya şikayetim yok bölümünü seçiniz!", "Hatalı Giriş", JOptionPane.ERROR_MESSAGE);
        }
        else{
            if(jCheckBox11.isSelected()!=true){
                jLabel6.setText("Form başarıyla gönderildi!");
                jButton3.setVisible(true);
            }
            else{
                Bilgilendirme bg=new Bilgilendirme();
                bg.setVisible(true);
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    public void teshis(){
        kk=kanserKontrolu();
        sak=sogukAlginligiKontrolu();
        tk=tansiyonKontrolu();
        String[] dizi={kk,sak,tk};
        int j=0;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Omer_Kocbil_1321221009_BP2_ODEV2PU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT h FROM Hasta h WHERE h.hastaPK.kullaniciAdi=:hAdi");
        q.setParameter("hAdi", jTextField3.getText());
        Hasta h1=(Hasta)q.getSingleResult();
        dlm.addElement(h1.getHastaliK1());
        if(!(h1.getHastaliK2()==null)){
            dlm.addElement(h1.getHastaliK2());
            if(!(h1.getHastaliK3()==null)){
                dlm.addElement(h1.getHastaliK3());
            }
        }
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        teshis();
        Reçete r=new Reçete();
        r.setVisible(true);
        r.list.setModel(dlm);
        r.label.setText(kk);
        r.label2.setText(sak);
        r.label3.setText(tk);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jCheckBox11İtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox11İtemStateChanged
        // TODO add your handling code here:
        JCheckBox c=(JCheckBox) evt.getSource();
        JCheckBox[] cb={jCheckBox1,jCheckBox2,jCheckBox3,jCheckBox4,jCheckBox5,jCheckBox6,
                        jCheckBox7,jCheckBox8,jCheckBox9,jCheckBox10};
        if(c!=jCheckBox11){
            if(jCheckBox11.isSelected()==true){
                jCheckBox11.setSelected(false);
            }
        }
        if(jCheckBox11.isSelected()==true){
            for (int i = 0; i < cb.length; i++) {
                if(cb[i].isSelected()==true){
                    cb[i].setSelected(false);
                }
            }
            jCheckBox11.setSelected(true);
        }
    }//GEN-LAST:event_jCheckBox11İtemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Connection cn;
        try {
            cn = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
            PreparedStatement updStm=cn.prepareStatement("UPDATE hasta SET ad=? , soyad=? , kullanici_adi=? , sifre=? WHERE hasta_id=?"); 
            updStm.setString(1, jTextField1.getText());
            updStm.setString(2, jTextField2.getText());
            updStm.setString(3, jTextField3.getText());
            updStm.setString(4, jTextField4.getText());
            updStm.setInt(5, Integer.parseInt(jTextField5.getText()));
            updStm.executeUpdate();
            
            jLabel20.setVisible(true);
            jLabel20.setText("Değişiklikler başarıyla kaydeildi.");
        } catch (SQLException ex) {
            Logger.getLogger(HastaFormu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Hastahane h=new Hastahane();
        h.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        IlaçTakibi it=new IlaçTakibi();
        it.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Omer_Kocbil_1321221009_BP2_ODEV2PU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT h FROM Randevu h WHERE h.kullanici=:hAdi");
        q.setParameter("hAdi", jTextField3.getText());
        try{
            Randevu r=(Randevu)q.getSingleResult();
            if (r.getRandevuKodu() == Integer.parseInt(jTextField6.getText())) {
                jLabel23.setVisible(true);
                JCheckBox[] cb = {jCheckBox1, jCheckBox2, jCheckBox3, jCheckBox4, jCheckBox5, jCheckBox6,
                    jCheckBox7, jCheckBox8, jCheckBox9, jCheckBox10, jCheckBox11};
                for (int i = 0; i < cb.length; i++) {
                    cb[i].setVisible(true);
                }
                jButton1.setVisible(true);
                jLabel3.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(this, "Bu randevu kodu size ait değildir.", "Geçersiz Giriş", JOptionPane.ERROR_MESSAGE);
            }
        } catch(NoResultException n){
            JOptionPane.showMessageDialog(this, "Böyle bir randevu kodu kayıtta bulunmamaktadır.", "Geçersiz Giriş", JOptionPane.ERROR_MESSAGE);
        }
        
        em.close();
        
        EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("Omer_Kocbil_1321221009_BP2_ODEV2PU");
        EntityManager em2 = emf2.createEntityManager();
        Query q2 = em2.createQuery("DELETE FROM Randevu a WHERE a.randevuKodu = :hId ");
        q2.setParameter("hId", Integer.parseInt(jTextField6.getText()));
        
        em2.getTransaction().begin();
        q2.executeUpdate();
        em2.getTransaction().commit();
        
        em2.close();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        HastaDetayi hd=new HastaDetayi();
        hd.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HastaFormu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HastaFormu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HastaFormu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HastaFormu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HastaFormu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
