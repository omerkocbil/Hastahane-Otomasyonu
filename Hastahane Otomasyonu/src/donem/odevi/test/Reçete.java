/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donem.odevi.test;

import donem.odevi.*;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JButton;
//import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author Bogdanovic44
 */
public class Reçete extends javax.swing.JFrame {
    public JList list=new JList();
    public JLabel label=new JLabel();
    public JLabel label2=new JLabel();
    public JLabel label3=new JLabel();
    public JLabel label4=new JLabel();
    public JLabel label5=new JLabel();
    public JLabel label6=new JLabel();
    public JLabel label7=new JLabel();
    public JLabel label8=new JLabel();
    public JLabel label9=new JLabel();
    public JLabel label10=new JLabel();
    public JButton buton=new JButton();
    public JButton buton1=new JButton();
    public JButton buton2=new JButton();
    public JButton buton3=new JButton();
    String i,j,k;
    Object o=null;
    Hasta_Kopya h=new Hasta_Kopya();
    Hasta hasta=null;
    
    /**
     * Creates new form Reçete
     */
    public Reçete() {
        initComponents();
        listOlustur();
        labelOlustur();
        label2Olustur();
        label3Olustur();
        jLabel3.setVisible(false);
        label.setVisible(false);
        label2.setVisible(false);
        label3.setVisible(false);
        jLabel5.setVisible(false);
        listiKullan();
        butonuKullan();
        buton1Kullan();
        buton2Kullan();
        buton3Kullan();
    }
    
    public void labelOlustur(){
        label.setBounds(18,217,386,16);
        this.getContentPane().add(label);
    }
    
    public void label2Olustur(){
        label2.setBounds(18,217,386,16);
        this.getContentPane().add(label2);
    }
    
    public void label3Olustur(){
        label3.setBounds(18,217,386,16);
        this.getContentPane().add(label3);
    }
    
    public void listOlustur(){
        list.setBounds(76,45,230,108);
        this.getContentPane().add(list);
    }
    
    public void listiKullan(){
        list.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jLabel3.setVisible(true); 
                jLabel5.setVisible(true);
                if("Kanser".equals(list.getSelectedValue().toString())){
                    jLabel3.setText("Kanser Hastalığı");
                    label.setVisible(true);
                    label2.setVisible(false);
                    label3.setVisible(false);
                    if(label.getText().length()==40){
                        i="K";
                        jLabel5.setText("Almanız gereken ilaçlar"+" gleevec,"+" avastin"+" ve bleocin");
                    }
                    else{
                        i="k";
                        jLabel5.setText("Almanız gereken ilaçlar"+" gleevec"+" ve avastin");
                    }
                }
                else if("Soğuk Algınlığı".equals(list.getSelectedValue().toString())){
                    jLabel3.setText("Soğuk Algınlığı Hastalığı");
                    label2.setVisible(true);
                    label.setVisible(false);
                    label3.setVisible(false);
                    if(label2.getText().length()==49){
                        j="SA";
                        jLabel5.setText("Almanız gereken ilaçlar"+" theraFlu,"+" nurofen"+" ve tylolhot");
                    }
                    else{
                        j="sa";
                        jLabel5.setText("Almanız gereken ilaçlar"+" theraFlu"+" ve nurofen");
                    }
                }
                else{
                    jLabel3.setText("Tansiyon Hastalığı");
                    label3.setVisible(true);
                    label.setVisible(false);
                    label2.setVisible(false);
                    if(label3.getText().length()==42){
                        k="T";
                        jLabel5.setText("Almanız gereken ilaçlar"+" novartis,"+" accuzide"+" ve ayra");
                    }
                    else{
                        k="t";
                        jLabel5.setText("Almanız gereken ilaçlar"+" novartis"+" ve accuzide");
                    }
                }
            }
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reçete");

        jLabel1.setText("Teşhisi Konulan Hastalık veya Hastalıklar:");

        jLabel2.setText("(Hastalıkların üstüne tıklayarak detaylı bilgi alabilirsiniz)");

        jLabel3.setText("jLabel3");

        jLabel5.setText("jLabel5");

        jButton1.setText("Eczaneye Git");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ana Sayfaya Dön");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)))))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(126, 126, 126)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(34, 34, 34)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public void label4Olustur(){
        label4.setBounds(97,26,186,16);
        this.getContentPane().add(label4);
        label4.setForeground(Color.red);
    }
    
    public void label5Olustur(){
        label5.setBounds(49,62,386,16);
        this.getContentPane().add(label5);
    }
    
    public void label6Olustur(){
        label6.setBounds(49,90,386,16);
        this.getContentPane().add(label6);
    }
    
    public void butonOlustur(){
        buton.setBounds(22,130,142,28);
        this.getContentPane().add(buton);
        buton.setText("Reçetedeki İlaçları Al");
    }
    
    public void label7Olustur(){
        label7.setBounds(22,170,386,16);
        this.getContentPane().add(label7);
    }
    
    public void label8Olustur(){
        label8.setBounds(22,210,386,16);
        this.getContentPane().add(label8);
    }
    
    public void label9Olustur(){
        label9.setBounds(22,250,386,16);
        this.getContentPane().add(label9);
    }

    public void label10Olustur(){
        label10.setBounds(22,280,386,16);
        this.getContentPane().add(label10);
    }
    
    public void buton1Olustur(){
        buton1.setBounds(310,165,65,28);
        this.getContentPane().add(buton1);
        buton1.setText("Bilgi Al");
    }
    
    public void buton2Olustur(){
        buton2.setBounds(310,205,65,28);
        this.getContentPane().add(buton2);
        buton2.setText("Bilgi Al");
    }
    
    public void buton3Olustur(){
        buton3.setBounds(310,245,65,28);
        this.getContentPane().add(buton3);
        buton3.setText("Bilgi Al");
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setTitle("Eczane Ömer");
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        label.setVisible(false);
        label2.setVisible(false);
        label3.setVisible(false);
        jLabel5.setVisible(false);
        list.setVisible(false);
        jButton1.setVisible(false);
        butonOlustur();
        label4Olustur();
        label5Olustur();
        label6Olustur();
        label4.setText("ECZANE ÖMER'E HOŞGELDİNİZ!!");
        label5.setText("Sayın "+Hastahane.h1.getAd()+" "+Hastahane.h1.getSoyad()+" eczanemize hoşgeldiniz.");
        label6.setText("İşlem yapmak için aşağıdaki fonksiyonları kullanabilirsiniz.");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Hastahane h=new Hastahane();
        h.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
    
    public Hasta hastayıBul(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Omer_Kocbil_1321221009_BP2_ODEV2PU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT h FROM Hasta h WHERE h.hastaPK.kullaniciAdi=:hAdi");
        q.setParameter("hAdi", Hastahane.h1.getHastaPK().getKullaniciAdi());
        hasta=(Hasta)q.getSingleResult();
        return hasta;
    }
    
    public void butonuKullan(){
       buton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label10Olustur();
                label10.setText("YİNE BEKLERİZ, HOŞÇAKALIN :)");
                EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("Omer_Kocbil_1321221009_BP2_ODEV2PU");
                EntityManager em2 = emf2.createEntityManager();
                if (i == "K") {
                    KanserIlaci gleevec = new KanserIlaci("gleevec");
                    KanserIlaci avastin = new KanserIlaci("avastin");
                    KanserIlaci bleocin = new KanserIlaci("bleocin");
                    h.ilacAl(gleevec, avastin, bleocin);
                    h.eczaDolabinaIlacEkle(gleevec, avastin, bleocin);
                    Query q2 = em2.createQuery("UPDATE Hasta a SET a.ilac1 = :hH, a.ilac2=:hH1, a.ilac3=:hH2 WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                    q2.setParameter("hAdi", Hastahane.h1.getHastaPK().getKullaniciAdi());
                    q2.setParameter("hH", "gleevec");
                    q2.setParameter("hH1", "avastin");
                    q2.setParameter("hH2", "bleocin");
                    em2.getTransaction().begin();
                    q2.executeUpdate();
                    em2.getTransaction().commit();
                    label7Olustur();
                    label7.setText("Gleevec, Avastin ve Bleocin kanser ilaçları verildi");
                    buton1Olustur();
                } else if (i == "k") {
                    KanserIlaci gleevec = new KanserIlaci("gleevec");
                    KanserIlaci avastin = new KanserIlaci("avastin");
                    h.ilacAl(gleevec, avastin);
                    h.eczaDolabinaIlacEkle(gleevec, avastin);
                    Query q2 = em2.createQuery("UPDATE Hasta a SET a.ilac1 = :hH, a.ilac2=:hH1 WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                    q2.setParameter("hAdi", Hastahane.h1.getHastaPK().getKullaniciAdi());
                    q2.setParameter("hH", "gleevec");
                    q2.setParameter("hH1", "avastin");
                    em2.getTransaction().begin();
                    q2.executeUpdate();
                    em2.getTransaction().commit();
                    label7Olustur();
                    label7.setText("Gleevec ve Avastin kanser ilaçları verildi");
                    buton1Olustur();
                }
                em2.close();
                emf2.close();
                EntityManagerFactory emf3 = Persistence.createEntityManagerFactory("Omer_Kocbil_1321221009_BP2_ODEV2PU");
                EntityManager em3 = emf3.createEntityManager();
                hasta=hastayıBul();
                if (j == "SA") {
                    SogukAlginligiIlaci theraFlu = new SogukAlginligiIlaci("theraFlu");
                    SogukAlginligiIlaci nurofen = new SogukAlginligiIlaci("nurofen");
                    SogukAlginligiIlaci tylolhot = new SogukAlginligiIlaci("tylolhot");
                    h.ilacAl(theraFlu, nurofen, tylolhot);
                    h.eczaDolabinaIlacEkle(theraFlu, nurofen, tylolhot);
                    if(hasta.getIlac1()==null){
                        Query q3 = em3.createQuery("UPDATE Hasta a SET a.ilac1 = :hH, a.ilac2=:hH1, a.ilac3=:hH2 WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                        q3.setParameter("hAdi", Hastahane.h1.getHastaPK().getKullaniciAdi());
                        q3.setParameter("hH", "theraFlu");
                        q3.setParameter("hH1", "nurofen");
                        q3.setParameter("hH2", "tylolhot");
                        em3.getTransaction().begin();
                        q3.executeUpdate();
                        em3.getTransaction().commit();
                    }
                    else if(hasta.getIlac3()==null){
                        Query q3 = em3.createQuery("UPDATE Hasta a SET a.ilac3 = :hH, a.ilac4=:hH1, a.ilac5=:hH2 WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                        q3.setParameter("hAdi", Hastahane.h1.getHastaPK().getKullaniciAdi());
                        q3.setParameter("hH", "theraFlu");
                        q3.setParameter("hH1", "nurofen");
                        q3.setParameter("hH2", "tylolhot");
                        em3.getTransaction().begin();
                        q3.executeUpdate();
                        em3.getTransaction().commit();
                    }
                    else{
                        Query q3 = em3.createQuery("UPDATE Hasta a SET a.ilac4 = :hH, a.ilac5=:hH1, a.ilac6=:hH2 WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                        q3.setParameter("hAdi", Hastahane.h1.getHastaPK().getKullaniciAdi());
                        q3.setParameter("hH", "theraFlu");
                        q3.setParameter("hH1", "nurofen");
                        q3.setParameter("hH2", "tylolhot");
                        em3.getTransaction().begin();
                        q3.executeUpdate();
                        em3.getTransaction().commit();
                    }
                    label8Olustur();
                    label8.setText("TheraFlu, Nurofen ve Tylolhot soğuk algınlığı ilaçları verildi");
                    buton2Olustur();
                } else if (j == "sa") {
                    SogukAlginligiIlaci theraFlu = new SogukAlginligiIlaci("theraFlu");
                    SogukAlginligiIlaci nurofen = new SogukAlginligiIlaci("nurofen");
                    h.ilacAl(theraFlu, nurofen);
                    h.eczaDolabinaIlacEkle(theraFlu, nurofen);
                    if(hasta.getIlac1()==null){
                        Query q3 = em3.createQuery("UPDATE Hasta a SET a.ilac1 = :hH, a.ilac2=:hH1 WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                        q3.setParameter("hAdi", Hastahane.h1.getHastaPK().getKullaniciAdi());
                        q3.setParameter("hH", "theraFlu");
                        q3.setParameter("hH1", "nurofen");
                        em3.getTransaction().begin();
                        q3.executeUpdate();
                        em3.getTransaction().commit();
                    }
                    else if(hasta.getIlac3()==null){
                        Query q3 = em3.createQuery("UPDATE Hasta a SET a.ilac3 = :hH, a.ilac4=:hH1 WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                        q3.setParameter("hAdi", Hastahane.h1.getHastaPK().getKullaniciAdi());
                        q3.setParameter("hH", "theraFlu");
                        q3.setParameter("hH1", "nurofen");
                        em3.getTransaction().begin();
                        q3.executeUpdate();
                        em3.getTransaction().commit();
                    }
                    else{
                        Query q3 = em3.createQuery("UPDATE Hasta a SET a.ilac4 = :hH, a.ilac5=:hH1 WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                        q3.setParameter("hAdi", Hastahane.h1.getHastaPK().getKullaniciAdi());
                        q3.setParameter("hH", "theraFlu");
                        q3.setParameter("hH1", "nurofen");
                        em3.getTransaction().begin();
                        q3.executeUpdate();
                        em3.getTransaction().commit();
                    }
                    label8Olustur();
                    label8.setText("TheraFlu ve Nurofen soğuk algınlığı ilaçları verildi");
                    buton2Olustur();
                }
                em3.close();
                emf3.close();
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("Omer_Kocbil_1321221009_BP2_ODEV2PU");
                EntityManager em = emf.createEntityManager();
                hasta=hastayıBul();
                if (k == "T") {
                    TansiyonIlaci novartis = new TansiyonIlaci("novartis");
                    TansiyonIlaci accuzide = new TansiyonIlaci("accuzide");
                    TansiyonIlaci ayra = new TansiyonIlaci("ayra");
                    h.ilacAl(novartis, accuzide, ayra);
                    h.eczaDolabinaIlacEkle(novartis, accuzide, ayra);
                    if(hasta.getIlac1()==null){
                        Query q = em.createQuery("UPDATE Hasta a SET a.ilac1 = :hH, a.ilac2=:hH1, a.ilac3=:hH2 WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                        q.setParameter("hAdi", Hastahane.h1.getHastaPK().getKullaniciAdi());
                        q.setParameter("hH", "novartis");
                        q.setParameter("hH1", "accuzide");
                        q.setParameter("hH2", "ayra");
                        em.getTransaction().begin();
                        q.executeUpdate();
                        em.getTransaction().commit();
                    }
                    else if(hasta.getIlac3()==null){
                        Query q = em.createQuery("UPDATE Hasta a SET a.ilac3 = :hH, a.ilac4=:hH1, a.ilac5=:hH2 WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                        q.setParameter("hAdi", Hastahane.h1.getHastaPK().getKullaniciAdi());
                        q.setParameter("hH", "novartis");
                        q.setParameter("hH1", "accuzide");
                        q.setParameter("hH2", "ayra");
                        em.getTransaction().begin();
                        q.executeUpdate();
                        em.getTransaction().commit();
                    }
                    else if(hasta.getIlac4()==null){
                        Query q = em.createQuery("UPDATE Hasta a SET a.ilac4 = :hH, a.ilac5=:hH1, a.ilac6=:hH2 WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                        q.setParameter("hAdi", Hastahane.h1.getHastaPK().getKullaniciAdi());
                        q.setParameter("hH", "novartis");
                        q.setParameter("hH1", "accuzide");
                        q.setParameter("hH2", "ayra");
                        em.getTransaction().begin();
                        q.executeUpdate();
                        em.getTransaction().commit();
                    }
                    else if(hasta.getIlac5()==null){
                        Query q = em.createQuery("UPDATE Hasta a SET a.ilac5 = :hH, a.ilac6=:hH1, a.ilac7=:hH2 WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                        q.setParameter("hAdi", Hastahane.h1.getHastaPK().getKullaniciAdi());
                        q.setParameter("hH", "novartis");
                        q.setParameter("hH1", "accuzide");
                        q.setParameter("hH2", "ayra");
                        em.getTransaction().begin();
                        q.executeUpdate();
                        em.getTransaction().commit();
                    }
                    else if(hasta.getIlac6()==null){
                        Query q = em.createQuery("UPDATE Hasta a SET a.ilac6 = :hH, a.ilac7=:hH1, a.ilac8=:hH2 WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                        q.setParameter("hAdi", Hastahane.h1.getHastaPK().getKullaniciAdi());
                        q.setParameter("hH", "novartis");
                        q.setParameter("hH1", "accuzide");
                        q.setParameter("hH2", "ayra");
                        em.getTransaction().begin();
                        q.executeUpdate();
                        em.getTransaction().commit();
                    }
                    else{
                        Query q = em.createQuery("UPDATE Hasta a SET a.ilac7 = :hH, a.ilac8=:hH1, a.ilac9=:hH2 WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                        q.setParameter("hAdi", Hastahane.h1.getHastaPK().getKullaniciAdi());
                        q.setParameter("hH", "novartis");
                        q.setParameter("hH1", "accuzide");
                        q.setParameter("hH2", "ayra");
                        em.getTransaction().begin();
                        q.executeUpdate();
                        em.getTransaction().commit();
                    }
                    label9Olustur();
                    label9.setText("Novartis, Accuzide ve Ayra tansiyon ilaçları verildi");
                    buton3Olustur();
                } else if (k == "t") {
                    TansiyonIlaci novartis = new TansiyonIlaci("novartis");
                    TansiyonIlaci accuzide = new TansiyonIlaci("accuzide");
                    h.ilacAl(novartis, accuzide);
                    h.eczaDolabinaIlacEkle(novartis, accuzide);
                    if(hasta.getIlac1()==null){
                        Query q = em.createQuery("UPDATE Hasta a SET a.ilac1 = :hH, a.ilac2=:hH1 WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                        q.setParameter("hAdi", Hastahane.h1.getHastaPK().getKullaniciAdi());
                        q.setParameter("hH", "novartis");
                        q.setParameter("hH1", "accuzide");
                        em.getTransaction().begin();
                        q.executeUpdate();
                        em.getTransaction().commit();
                    }
                    else if(hasta.getIlac3()==null){
                        Query q = em.createQuery("UPDATE Hasta a SET a.ilac3 = :hH, a.ilac4=:hH1 WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                        q.setParameter("hAdi", Hastahane.h1.getHastaPK().getKullaniciAdi());
                        q.setParameter("hH", "novartis");
                        q.setParameter("hH1", "accuzide");
                        em.getTransaction().begin();
                        q.executeUpdate();
                        em.getTransaction().commit();
                    }
                    else if(hasta.getIlac4()==null){
                        Query q = em.createQuery("UPDATE Hasta a SET a.ilac4 = :hH, a.ilac5=:hH1 WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                        q.setParameter("hAdi", Hastahane.h1.getHastaPK().getKullaniciAdi());
                        q.setParameter("hH", "novartis");
                        q.setParameter("hH1", "accuzide");
                        em.getTransaction().begin();
                        q.executeUpdate();
                        em.getTransaction().commit();
                    }
                    else if(hasta.getIlac5()==null){
                        Query q = em.createQuery("UPDATE Hasta a SET a.ilac5 = :hH, a.ilac6=:hH1 WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                        q.setParameter("hAdi", Hastahane.h1.getHastaPK().getKullaniciAdi());
                        q.setParameter("hH", "novartis");
                        q.setParameter("hH1", "accuzide");
                        em.getTransaction().begin();
                        q.executeUpdate();
                        em.getTransaction().commit();
                    }
                    else if(hasta.getIlac6()==null){
                        Query q = em.createQuery("UPDATE Hasta a SET a.ilac6 = :hH, a.ilac7=:hH1 WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                        q.setParameter("hAdi", Hastahane.h1.getHastaPK().getKullaniciAdi());
                        q.setParameter("hH", "novartis");
                        q.setParameter("hH1", "accuzide");
                        em.getTransaction().begin();
                        q.executeUpdate();
                        em.getTransaction().commit();
                    }
                    else{
                        Query q = em.createQuery("UPDATE Hasta a SET a.ilac7 = :hH, a.ilac8=:hH1 WHERE a.hastaPK.kullaniciAdi = :hAdi ");
                        q.setParameter("hAdi", Hastahane.h1.getHastaPK().getKullaniciAdi());
                        q.setParameter("hH", "novartis");
                        q.setParameter("hH1", "accuzide");
                        em.getTransaction().begin();
                        q.executeUpdate();
                        em.getTransaction().commit();
                    }
                    label9Olustur();
                    label9.setText("Novartis ve Accuzide tansiyon ilaçları verildi");
                    buton3Olustur();
                }
                em.close();
                emf.close();
            }
        });
    }
    
    public void buton1Kullan(){
       buton1.addActionListener(new java.awt.event.ActionListener() {   
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOptionPane.showMessageDialog(buton, KanserIlaci.tavsiye , "Kanser İlaçları Hakkında Bilgi", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
    
    public void buton2Kullan(){
       buton2.addActionListener(new java.awt.event.ActionListener() {   
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOptionPane.showMessageDialog(buton, SogukAlginligiIlaci.tavsiye , "Soğuk Algınlığı İlaçları Hakkında Bilgi", JOptionPane.INFORMATION_MESSAGE); 
            }
        });
    }
    
    public void buton3Kullan(){
       buton3.addActionListener(new java.awt.event.ActionListener() {   
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOptionPane.showMessageDialog(buton, TansiyonIlaci.tavsiye , "Tansiyon İlaçları Hakkında Bilgi", JOptionPane.INFORMATION_MESSAGE);    
            }
        });
    }
    
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
            java.util.logging.Logger.getLogger(Reçete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reçete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reçete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reçete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reçete().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
