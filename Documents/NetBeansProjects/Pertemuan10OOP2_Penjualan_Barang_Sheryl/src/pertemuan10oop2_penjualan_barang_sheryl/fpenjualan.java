/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pertemuan10oop2_penjualan_barang_sheryl;
import java.awt.Desktop;
import java.net.URL;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;

/**
 *
 * @author acer
 */
public class fpenjualan extends javax.swing.JFrame {
     public long total;
     public long bayar;
     public long kembali;
     public Statement st;
     Connection cn = Koneksi.getKoneksi();
     private DefaultTableModel model;

    /**
     * Creates new form fpenjualan
     */
    public fpenjualan() {
        initComponents();
        model = new DefaultTableModel();
        tabel.setModel(model);
        model.addColumn("ID");
        model.addColumn("kode barang");
        model.addColumn("nama barang");
        model.addColumn("harga satuan");
        model.addColumn("jumlah beli");
        model.addColumn("harga");
        loadData();
        nofaktur();
        tampilpilih();
    }
    
    public void FilterHuruf(KeyEvent a){
        if(Character.isDigit(a.getKeyChar())){
            a.consume();
            JOptionPane.showMessageDialog(null, "masukan huruf saja!", "peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void FilterAngka(KeyEvent a){
        if(Character.isAlphabetic(a.getKeyChar())){
            a.consume();
            JOptionPane.showMessageDialog(null, "masukan angka saja!", "peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public final void loadData() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try {
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM tbl_hitung_jual";
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                Object[] o = new Object[6];
                o[0] = r.getString("id_hitung");
                o[1] = r.getString("kd_barang");
                o[2] = r.getString("nama_barang");
                o[3] = r.getString("hsatuan");
                o[4] = r.getString("jumlah_jual");
                o[5] = r.getString("harga");
                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Error" + e.getMessage());
        }
    }
    
    private void tampilpilih() {
        try {
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT nama_barang FROM tbl_barang WHERE jumlah_barang !='0'";
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                pilihbarang.addItem(r.getString("nama_barang"));
            }
            r.last();
            int jumlahdata = r.getRow();
            r.first();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void nofaktur() {
        try {
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM tbl_penjualan ORDER by nofaktur desc";
            ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                String nofak = r.getString("nofaktur").substring(1);
                String AN = "" + (Integer.parseInt(nofak) + 1);
                String Nol = "";
                if (AN.length() == 1) {
                    Nol = "000";
                } else if (AN.length() == 2) {
                    Nol = "00";
                } else if (AN.length() == 3) {
                    Nol = "0";
                } else if (AN.length() == 4) {
                    Nol = "";
                }
                faktur.setText("F" + Nol + AN);
            } else {
                faktur.setText("F0001");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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
        jLabel1 = new javax.swing.JLabel();
        btnkembali = new java.awt.Button();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        faktur = new javax.swing.JTextField();
        pilihbarang = new javax.swing.JComboBox<>();
        kdbarang = new javax.swing.JTextField();
        hsatuan = new javax.swing.JTextField();
        tjumlah = new javax.swing.JTextField();
        ttotal = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        totalbutton = new java.awt.Button();
        btnselesai = new java.awt.Button();
        btncetak = new java.awt.Button();
        txt_bayar = new javax.swing.JTextField();
        txt_kembali = new javax.swing.JTextField();
        hitung = new java.awt.Button();
        tambah = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jumlahstok = new javax.swing.JTextField();
        txt_faktur = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Penjualan");

        btnkembali.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnkembali.setLabel("kembali");
        btnkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnkembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnkembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("No. Faktur");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama barang");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Kode Barang");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Harga Satuan");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Jumlah Jual");

        pilihbarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pilih barang" }));
        pilihbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihbarangActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Rp.");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("bayar");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("kembalian");

        totalbutton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        totalbutton.setLabel("TOTAL");
        totalbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalbuttonActionPerformed(evt);
            }
        });

        btnselesai.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnselesai.setLabel("SELESAI TRANSAKSI");
        btnselesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnselesaiActionPerformed(evt);
            }
        });

        btncetak.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btncetak.setForeground(new java.awt.Color(153, 153, 153));
        btncetak.setLabel("CETAK");
        btncetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncetakActionPerformed(evt);
            }
        });

        txt_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bayarActionPerformed(evt);
            }
        });
        txt_bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_bayarKeyTyped(evt);
            }
        });

        txt_kembali.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_kembaliKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnselesai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(totalbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_bayar)
                            .addComponent(txt_kembali))))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btncetak, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(20, 20, 20)
                        .addComponent(totalbutton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(btnselesai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(btncetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        hitung.setLabel("HITUNG");
        hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungActionPerformed(evt);
            }
        });

        tambah.setLabel("TAMBAH");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(faktur)
                                    .addComponent(kdbarang)
                                    .addComponent(hsatuan)
                                    .addComponent(tjumlah)
                                    .addComponent(ttotal)
                                    .addComponent(pilihbarang, 0, 106, Short.MAX_VALUE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(hitung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(41, 41, 41))
                                    .addComponent(jumlahstok))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_faktur, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(hitung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(faktur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(22, 22, 22)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3)
                                            .addComponent(pilihbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel4)
                                            .addComponent(kdbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(hsatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6)
                                            .addComponent(tjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jumlahstok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(ttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(txt_faktur, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(tambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bayarActionPerformed
        // TODO add your handling code here:
        bayar = Integer.parseInt(String.valueOf(txt_bayar.getText()));
        total = Integer.parseInt(String.valueOf(jLabel7.getText()));
        kembali = bayar - total;
        txt_kembali.setText(Long.toString(kembali));
    }//GEN-LAST:event_txt_bayarActionPerformed

    private void pilihbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihbarangActionPerformed
        // TODO add your handling code here:
        if (pilihbarang.getSelectedItem().equals("pilih barang")){
            kdbarang.setText("");
            hsatuan.setText("");
        }else{
            try {
                Connection c = Koneksi.getKoneksi();
                Statement s = c.createStatement();
                String sql = "SELECT kd_barang, jumlah_barang FROM tbl_barang WHERE nama_barang ='" + 
                        pilihbarang.getSelectedItem() + "'";
                ResultSet r = s.executeQuery(sql);
                while (r.next()) {
                    kdbarang.setText(r.getString("kd_barang"));
                    jumlahstok.setText(r.getString("jumlah_barang"));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            try {
                Connection c = Koneksi.getKoneksi();
                Statement s = c.createStatement();
                String sql = "SELECT harga_jual FROM tbl_barang WHERE nama_barang ='" + 
                        pilihbarang.getSelectedItem() + "'";
                ResultSet r = s.executeQuery(sql);
                while (r.next()) {
                    hsatuan.setText(r.getString("harga_jual"));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_pilihbarangActionPerformed

    private void totalbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalbuttonActionPerformed
        // TODO add your handling code here:
        try {
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT SUM(`harga`) AS total FROM tbl_hitung_jual";
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                jLabel7.setText(r.getString(""+"total"));
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Error"+ e.getMessage());
        }
    }//GEN-LAST:event_totalbuttonActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
        if(faktur.getText().equals("") ||kdbarang.getText().equals("") || pilihbarang.getSelectedItem().equals("")|| hsatuan.getText().equals("")||
                tjumlah.getText().equals("")|| ttotal.getText().equals("")){
            JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "PT. Angin Ribut", JOptionPane.INFORMATION_MESSAGE);
        }else{
            String kdbarangg = kdbarang.getText();
            String pilihbarangg = (String)pilihbarang.getSelectedItem();
            String hsatuann = hsatuan.getText();
            String tjumlahh = tjumlah.getText();
            String totall = ttotal.getText();
            try {
                Connection c = Koneksi.getKoneksi();
                String sql = "INSERT INTO tbl_hitung_jual VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, null);
                p.setString(2, kdbarangg);
                p.setString(3, pilihbarangg);
                p.setString(4, hsatuann);
                p.setString(5,tjumlahh);
                p.setString(6,totall);
                p.executeUpdate();
                p.close();
            } catch (SQLException e) {
                System.out.println("Terjadi Error" + e.getMessage());
            } finally {
                nofaktur();
                kdbarang.setText("");
                pilihbarang.setSelectedItem("");
                hsatuan.setText("");
                tjumlah.setText("");
                ttotal.setText("");
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "PT. Himari Pharm", JOptionPane.INFORMATION_MESSAGE);
                loadData();
            }
        }
    }//GEN-LAST:event_tambahActionPerformed

    private void hitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungActionPerformed
        // TODO add your handling code here:
        if(faktur.getText().equals("") ||kdbarang.getText().equals("") || pilihbarang.getSelectedItem().equals("")|| hsatuan.getText().equals("")||
                tjumlah.getText().equals("")){
            JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "PT. Himari Pharm", JOptionPane.INFORMATION_MESSAGE);
        }else{
            String a = tjumlah.getText();
            int aa = Integer.parseInt(a);
            String b = jumlahstok.getText();
            int bb = Integer.parseInt(b);
            if(aa > bb){
                JOptionPane.showMessageDialog(null, "jumlah melebihi stok", "PT. Himari Pharm", JOptionPane.INFORMATION_MESSAGE);
                ttotal.setText("");
            }else{
                if(tjumlah.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "ISI JUMLAH BELI !");
                }else{
                    int jumlah, harga, total;
                    jumlah = Integer.parseInt(tjumlah.getText().toString());
                    harga = Integer.parseInt(hsatuan.getText().toString());
                    total = jumlah * harga;
                    ttotal.setText(Integer.toString(total));
                }
            }
        }
    }//GEN-LAST:event_hitungActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
        int jawaban;
        if ((jawaban = JOptionPane.showConfirmDialog(null,"Yakin batal?", "Konfirmasi", 
                JOptionPane.YES_NO_OPTION)) == 0) {
            try{
                int i = tabel.getSelectedRow();
                if (i == -1) {
                    return;
                }
                String id = (String) model.getValueAt(i, 0);
                st = cn.createStatement();
                st.executeUpdate("delete from tbl_hitung_jual where id_hitung = '"+id+ "'");
                nofaktur();
                loadData();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_tabelMouseClicked

    private void btnkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkembaliActionPerformed
        // TODO add your handling code here:
        fmenu fm = new fmenu();
        fm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnkembaliActionPerformed

    private void btnselesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnselesaiActionPerformed
        // TODO add your handling code here:
        if(txt_bayar.getText().equals("") ||txt_kembali.getText().equals("")){
            JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "PT Himari Pharm", 
                    JOptionPane.INFORMATION_MESSAGE);
        }else{
            String a = txt_bayar.getText();
            int ab = Integer.parseInt(String.valueOf(txt_bayar.getText()));
            if(ab < 0){
                JOptionPane.showMessageDialog(null, "Uang anda kurang", "PT Himari Pharm", 
                        JOptionPane.INFORMATION_MESSAGE);
                txt_bayar.setText("");
                txt_kembali.setText("");
            }else{
                try {
                    Connection c = Koneksi.getKoneksi();
                    Statement s = c.createStatement();
                    String sql = "SELECT * FROM tbl_hitung_jual";
                    ResultSet r = s.executeQuery(sql);
                    while (r.next()) {
                        long millis=System.currentTimeMillis(); 
                        java.sql.Date date=new java.sql.Date(millis); 
                        System.out.println(date); 
                        String tgl = date.toString();
                        String sqla = "INSERT INTO tbl_penjualan VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        
                        PreparedStatement p = c.prepareStatement(sqla);
                        p.setString(1, faktur.getText());
                        p.setString(2, r.getString("kd_barang"));
                        p.setString(3, r.getString("nama_barang"));
                        p.setString(4, r.getString("hsatuan"));
                        p.setString(5, r.getString("jumlah_jual"));
                        p.setString(6, r.getString("harga"));
                        p.setString(7, txt_bayar.getText());
                        p.setString(8, txt_kembali.getText());
                        p.setString(9, tgl);
                        p.executeUpdate();
                        p.close();
                    }
                    r.close();
                    s.close();
                } catch (SQLException e) {
                    System.out.println("Terjadi Error" + e.getMessage());
                }finally{
                    try {
                        String sqla ="TRUNCATE tbl_hitung_jual";
                        java.sql.Connection conn=(Connection)Koneksi.getKoneksi();
                        java.sql.PreparedStatement pst=conn.prepareStatement(sqla);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "TRANSAKSI SELESAI", "PT Himari Pharm", 
                                JOptionPane.INFORMATION_MESSAGE);
                        loadData();
                        txt_faktur.setText(faktur.getText());
                        txt_bayar.setText("");
                        txt_kembali.setText("");
                        jLabel7.setText("");
                        nofaktur();
                        btncetak.setEnabled(true);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
                }
            }
        }
    }//GEN-LAST:event_btnselesaiActionPerformed

    private void btncetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncetakActionPerformed
        // TODO add your handling code here:
        try{
            Desktop.getDesktop().browse(new URL("http://localhost/PenjualanBarang/invoice.php?lap&fk="+txt_faktur.getText()+"").toURI());
        } catch (Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_btncetakActionPerformed

    private void txt_bayarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_bayarKeyTyped
        // TODO add your handling code here:
        FilterAngka(evt);
    }//GEN-LAST:event_txt_bayarKeyTyped

    private void txt_kembaliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_kembaliKeyTyped
        // TODO add your handling code here:
        FilterAngka(evt);
    }//GEN-LAST:event_txt_kembaliKeyTyped

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
            java.util.logging.Logger.getLogger(fpenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fpenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fpenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fpenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fpenjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btncetak;
    private java.awt.Button btnkembali;
    private java.awt.Button btnselesai;
    private javax.swing.JTextField faktur;
    private java.awt.Button hitung;
    private javax.swing.JTextField hsatuan;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JTextField jumlahstok;
    private javax.swing.JTextField kdbarang;
    private javax.swing.JComboBox<String> pilihbarang;
    private javax.swing.JTable tabel;
    private java.awt.Button tambah;
    private javax.swing.JTextField tjumlah;
    private java.awt.Button totalbutton;
    private javax.swing.JTextField ttotal;
    private javax.swing.JTextField txt_bayar;
    private javax.swing.JTextField txt_faktur;
    private javax.swing.JTextField txt_kembali;
    // End of variables declaration//GEN-END:variables
}
