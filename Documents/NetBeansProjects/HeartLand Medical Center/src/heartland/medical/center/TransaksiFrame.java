/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heartland.medical.center;

import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class TransaksiFrame extends javax.swing.JFrame {
    public Statement stat;
    Connection con = Koneksi.getKoneksi();
    private DefaultTableModel model;
    public long total;
    public long bayar;
    public long kembali;

    /**
     * Creates new form TransaksiFrame
     */
    public TransaksiFrame() {
        initComponents();
        model = new DefaultTableModel();
        tbldaftar.setModel(model);
        model.addColumn("ID");
        model.addColumn("Jenis Biaya");
        model.addColumn("Jumlah Biaya");
        loadData();
        reff();
        tampilpilih();
    }
    
    public final void loadData() {
        btnsave.setEnabled(true);
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try {
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM tbl_hitung";
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                Object[] o = new Object[3];
                o[0] = r.getString("id_hitung");
                o[1] = r.getString("jenis_biaya");
                o[2] = r.getString("jumlah_biaya");
                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terjadi Error pada Data Hitung");
        }
    }
    
    private void reff() {
        try {
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM tbl_transaksi ORDER by no_reff desc";
            ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                String noreff = r.getString("no_reff").substring(1);
                String Akhir = "" + (Integer.parseInt(noreff) + 1);
                String Nol = "";
                if (Akhir.length() == 1) {
                    Nol = "0000";
                } else if (Akhir.length() == 2) {
                    Nol = "000";
                } else if (Akhir.length() == 3) {
                    Nol = "00";
                } else if (Akhir.length() == 3) {
                    Nol = "0";
                } else if (Akhir.length() == 4) {
                    Nol = "";
                }
                txtnoreff.setText("T" + Nol + Akhir);
            } else {
                txtnoreff.setText("T00001");
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada No Reff");
        }
    }
    
    private void tampilpilih() {
        try {
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql1 = "SELECT no_rm FROM tbl_pasien";
            ResultSet r1 = s.executeQuery(sql1);
            while (r1.next()) {
                cbrm.addItem(r1.getString("no_rm"));
            }
            r1.last();
            int jumlahdata1 = r1.getRow();
            r1.first();
            
            String sql2 = "SELECT nama_dokter FROM tbl_dokter";
            ResultSet r2 = s.executeQuery(sql2);
            while (r2.next()) {
                cbnamadok.addItem(r2.getString("nama_dokter"));
            }
            r2.last();
            int jumlahdata2 = r2.getRow();
            r2.first();
            
            String sql3 = "SELECT jenis_biaya FROM tbl_biayatbh";
            ResultSet r3 = s.executeQuery(sql3);
            while (r3.next()) {
                cbjenis.addItem(r3.getString("jenis_biaya"));
            }
            r3.last();
            int jumlahdata3 = r3.getRow();
            r3.first();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void cleanDaftar(){
        txtbiaya.setText("");
        cbjenis.setSelectedIndex(0);
    }
    
    private void cleanTransaksi(){
        txtnapas.setText("");
        txtkodepoli.setText("");
        txtnamapoli.setText("");
        cbrm.setSelectedIndex(0);
        cbnamadok.setSelectedIndex(0);
        date.setDate(null);
    }
    
    public void FilterAngka(KeyEvent a){
        if(Character.isAlphabetic(a.getKeyChar())){
            a.consume();
            JOptionPane.showMessageDialog(null, "masukan angka saja!", "peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnback = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtnoreff = new javax.swing.JTextField();
        txtnapas = new javax.swing.JTextField();
        txtkodepoli = new javax.swing.JTextField();
        txtnamapoli = new javax.swing.JTextField();
        txtbiaya = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        date = new com.toedter.calendar.JDateChooser();
        cbrm = new javax.swing.JComboBox<>();
        cbnamadok = new javax.swing.JComboBox<>();
        cbjenis = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldaftar = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txttotal = new javax.swing.JLabel();
        btntotal = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btndone = new javax.swing.JButton();
        btnprint = new javax.swing.JButton();
        txtbayar = new javax.swing.JTextField();
        txtkembali = new javax.swing.JLabel();
        reff = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Logo RS Kecil.jpg"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setText("Transaksi");

        btnback.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnback.setText("BACK");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(btnback)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("No Reff");

        jLabel5.setText("No RM");

        jLabel6.setText("Nama Pasien");

        jLabel7.setText("Kode Poli");

        jLabel8.setText("Nama Poli");

        jLabel9.setText("Nama Dokter");

        jLabel10.setText("Tanggal");

        jLabel11.setText("Jenis Biaya");

        jLabel12.setText("Biaya");

        txtnapas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnapasActionPerformed(evt);
            }
        });

        txtkodepoli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkodepoliActionPerformed(evt);
            }
        });

        txtbiaya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbiayaActionPerformed(evt);
            }
        });

        btnsave.setBackground(new java.awt.Color(0, 102, 153));
        btnsave.setForeground(new java.awt.Color(255, 255, 255));
        btnsave.setText("SAVE");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        cbrm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Silahkan Pilih", " " }));
        cbrm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbrmActionPerformed(evt);
            }
        });

        cbnamadok.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Silahkan Pilih" }));
        cbnamadok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbnamadokActionPerformed(evt);
            }
        });

        cbjenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Silahkan Pilih" }));
        cbjenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbjenisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnapas, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(txtkodepoli, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnoreff)
                            .addComponent(txtnamapoli)
                            .addComponent(txtbiaya, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbrm, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbnamadok, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbjenis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtnoreff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbrm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtnapas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbnamadok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtkodepoli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnamapoli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbjenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtbiaya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(btnsave)
                .addGap(35, 35, 35))
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 153));

        tbldaftar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbldaftar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldaftarMouseClicked(evt);
            }
        });
        tbldaftar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbldaftarKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbldaftar);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pembayaran");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Total");

        txttotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txttotal.setForeground(new java.awt.Color(255, 255, 255));
        txttotal.setText("Rp. ");

        btntotal.setText("Total");
        btntotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntotalActionPerformed(evt);
            }
        });

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Bayar");

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Kembali");

        btndone.setText("Done");
        btndone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndoneActionPerformed(evt);
            }
        });

        btnprint.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnprint.setText("Print");
        btnprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprintActionPerformed(evt);
            }
        });

        txtbayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbayarKeyTyped(evt);
            }
        });

        txtkembali.setForeground(new java.awt.Color(255, 255, 255));
        txtkembali.setText(" ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtbayar, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(txtkembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(txttotal)
                            .addGap(150, 150, 150))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(btndone, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(181, 181, 181))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addGap(396, 396, 396))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(btntotal, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(184, 184, 184))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(btnprint, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(97, 97, 97)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(42, 42, 42)
                        .addComponent(reff, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(reff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txttotal))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btntotal)
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtkembali))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btndone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnprint)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbiayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbiayaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbiayaActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        MenuFrame fmen = new MenuFrame();
        fmen.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        String jenis = (String) cbjenis.getSelectedItem();
        String jumlah = txtbiaya.getText();
        if(jenis.equals("") || jumlah.equals("")){
            JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "Transaksi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            try {
                Connection c = Koneksi.getKoneksi();
                if (c == null) {
                    throw new SQLException("Failed to get database connection.");
                }
                String sql = "INSERT INTO tbl_hitung VALUES (?, ?, ?, ?)";
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, null);
                p.setString(2, txtnoreff.getText());
                p.setString(3, jenis);
                p.setString(4, jumlah);
                p.executeUpdate();
                p.close(); 
            } catch (SQLException e) {
                System.out.println("Terjadi Error" + e.getMessage());
            } finally {
                reff();
                loadData();
                cleanDaftar();
                JOptionPane.showMessageDialog(null, "Data berhasil tersimpan", "Transaksi", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btntotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntotalActionPerformed
        // TODO add your handling code here:
        try {
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT SUM(`jumlah_biaya`) AS total FROM tbl_hitung";
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                txttotal.setText(r.getString(""+"total"));
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Error"+ e.getMessage());
        }
    }//GEN-LAST:event_btntotalActionPerformed

    private void btndoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndoneActionPerformed
        // TODO add your handling code here:
        if(txtbayar.getText().equals("")){
            JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "Transaksi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            String a = txtbayar.getText();
            int ab = Integer.parseInt(String.valueOf(txtbayar.getText()));
            String b = txttotal.getText();
            int bc = Integer.parseInt(String.valueOf(txttotal.getText()));
            if(ab < bc){
                JOptionPane.showMessageDialog(null, "Uang anda kurang", "Transaksi",JOptionPane.INFORMATION_MESSAGE);
                txtbayar.setText("");
            }else{
                bayar = Integer.parseInt(String.valueOf(txtbayar.getText()));
                total = Integer.parseInt(String.valueOf(txttotal.getText()));
                kembali = bayar - total;
                txtkembali.setText(Long.toString(kembali));
                try {
                    Connection c = Koneksi.getKoneksi();
                    Statement s = c.createStatement();
                    String sql = "SELECT * FROM tbl_hitung";
                    ResultSet r = s.executeQuery(sql);
                    while (r.next()) {
                        String noreff = txtnoreff.getText();
                        String rm = (String) cbrm.getSelectedItem();
                        String pasien = txtnapas.getText();
                        String dokter = (String) cbnamadok.getSelectedItem();
                        String kodepoli = txtkodepoli.getText();
                        String namapoli = txtnamapoli.getText();
                        String tanggal = date.getDate()!= null ? new SimpleDateFormat("yyyy-MM-dd").format(date.getDate()) : "-";
                        
                        String sqla = "INSERT INTO tbl_transaksi VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        
                        PreparedStatement p = c.prepareStatement(sqla);
                        p.setString(1, noreff);
                        p.setString(2, rm);
                        p.setString(3, pasien);
                        p.setString(4, kodepoli);
                        p.setString(5, namapoli);
                        p.setString(6, dokter);
                        p.setString(7, r.getString("jenis_biaya"));
                        p.setString(8, r.getString("jumlah_biaya"));
                        p.setString(9, txtbayar.getText());
                        p.setString(10, txtkembali.getText());
                        p.setString(11, tanggal);
                        p.executeUpdate();
                        p.close();
                    }
                    r.close();
                    s.close();
                } catch (SQLException e) {
                    System.out.println("Terjadi Error" + e.getMessage());
                }finally{
                    try {
                        String sqla ="TRUNCATE tbl_hitung";
                        java.sql.Connection conn=(Connection)Koneksi.getKoneksi();
                        java.sql.PreparedStatement pst=conn.prepareStatement(sqla);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "TRANSAKSI SELESAI", "Transaksi", JOptionPane.INFORMATION_MESSAGE);
                        loadData();
                        reff.setText(txtnoreff.getText());
                        reff();
                        cleanTransaksi();
                        btnprint.setEnabled(true);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
                }
            }
        }
    }//GEN-LAST:event_btndoneActionPerformed

    private void txtbayarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbayarKeyTyped
        // TODO add your handling code here:
        FilterAngka(evt);
    }//GEN-LAST:event_txtbayarKeyTyped

    private void tbldaftarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbldaftarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbldaftarKeyPressed

    private void tbldaftarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldaftarMouseClicked
        // TODO add your handling code here:
        int jawaban;
        if ((jawaban = JOptionPane.showConfirmDialog(null,"Yakin batal?", "Konfirmasi", 
                JOptionPane.YES_NO_OPTION)) == 0) {
            try{
                int i = tbldaftar.getSelectedRow();
                if (i == -1) {
                    return;
                }
                String id = (String) model.getValueAt(i, 0);
                stat = con.createStatement();
                stat.executeUpdate("delete from tbl_hitung where id_hitung = '"+id+ "'");
                reff();
                loadData();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_tbldaftarMouseClicked

    private void txtnapasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnapasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnapasActionPerformed

    private void txtkodepoliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkodepoliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkodepoliActionPerformed

    private void btnprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprintActionPerformed
        // TODO add your handling code here:
        try{
            Desktop.getDesktop().browse(new URL("http://localhost/RumahSakit/invoice.php?lap&reff="+reff.getText()+"").toURI());
        } catch (Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_btnprintActionPerformed

    private void cbrmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbrmActionPerformed
        // TODO add your handling code here:
        if (cbrm.getSelectedItem().equals("pilih rm")){
            txtnapas.setText("");
        }else{
            try {
                Connection c = Koneksi.getKoneksi();
                Statement s = c.createStatement();
                String sql = "SELECT nama_pasien FROM tbl_pasien WHERE no_rm ='" + 
                        cbrm.getSelectedItem() + "'";
                ResultSet r = s.executeQuery(sql);
                while (r.next()) {
                    txtnapas.setText(r.getString("nama_pasien"));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_cbrmActionPerformed

    private void cbnamadokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbnamadokActionPerformed
        // TODO add your handling code here:
        if (cbnamadok.getSelectedItem().equals("pilih nama dokter")){
            txtkodepoli.setText("");
            txtnamapoli.setText("");
        }else{
            try {
                Connection c = Koneksi.getKoneksi();
                Statement s = c.createStatement();
                String sql = "SELECT kode_poli FROM tbl_dokter WHERE nama_dokter ='" + 
                        cbnamadok.getSelectedItem() + "'";
                ResultSet r = s.executeQuery(sql);
                while (r.next()) {
                    txtkodepoli.setText(r.getString("kode_poli"));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            try {
                Connection c = Koneksi.getKoneksi();
                Statement s = c.createStatement();
                String sql = "SELECT nama_poli FROM tbl_poli WHERE kode_poli ='" + 
                        txtkodepoli.getText() + "'";
                ResultSet r = s.executeQuery(sql);
                while (r.next()) {
                    txtnamapoli.setText(r.getString("nama_poli"));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_cbnamadokActionPerformed

    private void cbjenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbjenisActionPerformed
        // TODO add your handling code here:
        if (cbjenis.getSelectedItem().equals("pilih jenis biaya")){
            txtbiaya.setText("");
        }else{
            try {
                Connection c = Koneksi.getKoneksi();
                Statement s = c.createStatement();
                String sql = "SELECT jumlah_biaya FROM tbl_biayatbh WHERE jenis_biaya ='" + 
                        cbjenis.getSelectedItem() + "'";
                ResultSet r = s.executeQuery(sql);
                while (r.next()) {
                    txtbiaya.setText(r.getString("jumlah_biaya"));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_cbjenisActionPerformed

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
            java.util.logging.Logger.getLogger(TransaksiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransaksiFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton btndone;
    private javax.swing.JButton btnprint;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btntotal;
    private javax.swing.JComboBox<String> cbjenis;
    private javax.swing.JComboBox<String> cbnamadok;
    private javax.swing.JComboBox<String> cbrm;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField reff;
    private javax.swing.JTable tbldaftar;
    private javax.swing.JTextField txtbayar;
    private javax.swing.JTextField txtbiaya;
    private javax.swing.JLabel txtkembali;
    private javax.swing.JTextField txtkodepoli;
    private javax.swing.JTextField txtnamapoli;
    private javax.swing.JTextField txtnapas;
    private javax.swing.JTextField txtnoreff;
    private javax.swing.JLabel txttotal;
    // End of variables declaration//GEN-END:variables
}
