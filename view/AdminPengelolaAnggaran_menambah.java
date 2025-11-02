package view;

import database.DatabaseConnection;
import java.math.BigDecimal;
import java.sql.*;
import javax.swing.*;
import controller.AuthService;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AdminPengelolaAnggaran_menambah extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(AdminPengelolaAnggaran_menambah.class.getName());

    private String idAkunAktif = null;

    private JComboBox<String> comboInstansi;

    public AdminPengelolaAnggaran_menambah() {
        setUndecorated(true);
        initComponents();
        jYearChooser1.setYear(java.time.LocalDate.now().getYear());

        comboInstansi = jComboBox1;

        installMoneyInputGuards();

        AuthService.LoginInfo me = AuthService.getInstance().getCurrentLogin();
        if (me == null || me.getIdAkun() == null || me.getIdAkun().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sesi login tidak ditemukan. Silakan login lagi.");
            dispose();
            return;
        }
        idAkunAktif = me.getIdAkun();

        loadInstansiToCombo();

        jToggleButton1.addActionListener(evt -> tambahDataAnggaran());

        setLocationRelativeTo(null);
        setResizable(false);
        pack();
    }

    public void setIdAkun(String idAkun) { this.idAkunAktif = idAkun; }

    private void loadInstansiToCombo() {
        if (comboInstansi == null) {
            throw new IllegalStateException("comboInstansi belum terhubung ke jComboBox1.");
        }

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("-- Pilih Instansi --");

        final String sql = "SELECT nama_instansi FROM instansi ORDER BY nama_instansi ASC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                model.addElement(rs.getString("nama_instansi"));
            }
        } catch (SQLException e) {
            logger.log(java.util.logging.Level.SEVERE, "Gagal memuat nama instansi", e);
            JOptionPane.showMessageDialog(this,
                    "Gagal memuat daftar instansi: " + e.getMessage(),
                    "Koneksi DB", JOptionPane.ERROR_MESSAGE);
        }

        comboInstansi.setModel(model);
        comboInstansi.setSelectedIndex(0);
    }

    private void tambahDataAnggaran() {
        String namaInstansi     = (String) comboInstansi.getSelectedItem(); // dari combo
        int tahun               = jYearChooser1.getYear();
        String namaProgram      = jTextField3.getText().trim();
        String totalAnggaranStr = jTextField5.getText().trim();
        String realisasiStr     = jTextField8.getText().trim();
        String keterangan       = jTextField7.getText().trim();

        if (namaInstansi == null || namaInstansi.equals("-- Pilih Instansi --")) {
            JOptionPane.showMessageDialog(this, "Silakan pilih instansi terlebih dahulu.");
            return;
        }
        if (namaProgram.isEmpty() || totalAnggaranStr.isEmpty() || realisasiStr.isEmpty() || keterangan.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field wajib diisi.");
            return;
        }
        if (idAkunAktif == null || idAkunAktif.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID Akun tidak terdeteksi. Silakan login ulang.");
            return;
        }
        if (tahun < 2025 || tahun > 2030) {
            JOptionPane.showMessageDialog(this, "Tahun tidak valid.");
            return;
        }

        BigDecimal totalAnggaran, realisasi;
        try {
            totalAnggaran = toMoney(totalAnggaranStr);
            realisasi     = toMoney(realisasiStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Total anggaran dan realisasi harus angka uang yang valid.");
            return;
        }

        // 👉 Validasi bisnis: Realisasi ≤ Total
        if (realisasi.compareTo(totalAnggaran) > 0) {
            JOptionPane.showMessageDialog(this,
                    "Realisasi tidak boleh lebih besar dari Total Anggaran.",
                    "Validasi Anggaran",
                    JOptionPane.WARNING_MESSAGE);
            jTextField8.requestFocus();
            return;
        }

        final String SQL_CEK_INSTANSI = "SELECT 1 FROM instansi WHERE nama_instansi = ? LIMIT 1";
        final String SQL_INSERT_ANGGARAN =
                "INSERT INTO anggaran " +
                "(tahun, nama_program, total_anggaran, realisasi, keterangan, id_instansi, id_akun) " +
                "VALUES (?, ?, ?, ?, ?, (SELECT id_instansi FROM instansi WHERE nama_instansi = ?), ?)";

        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn == null) {
                JOptionPane.showMessageDialog(this, "Koneksi database tidak tersedia.");
                return;
            }
            try (PreparedStatement c = conn.prepareStatement(SQL_CEK_INSTANSI)) {
                c.setString(1, namaInstansi);
                try (ResultSet r = c.executeQuery()) {
                    if (!r.next()) {
                        JOptionPane.showMessageDialog(this, "Instansi \"" + namaInstansi + "\" tidak ditemukan.");
                        return;
                    }
                }
            }

            try (PreparedStatement ps = conn.prepareStatement(SQL_INSERT_ANGGARAN)) {
                ps.setInt(1, tahun);
                ps.setString(2, namaProgram);
                ps.setBigDecimal(3, totalAnggaran);
                ps.setBigDecimal(4, realisasi);
                ps.setString(5, keterangan);
                ps.setString(6, namaInstansi);
                ps.setString(7, idAkunAktif);
                ps.executeUpdate();
            }

            JOptionPane.showMessageDialog(this, "Data anggaran berhasil ditambahkan!");

            comboInstansi.setSelectedIndex(0);
            jYearChooser1.setYear(java.time.LocalDate.now().getYear());
            jTextField3.setText("");
            jTextField5.setText("");
            jTextField8.setText("");
            jTextField7.setText("");

            new AdminPengelolaAnggaran_melihat().setVisible(true);
            this.dispose();

        } catch (SQLException e) {
            logger.log(java.util.logging.Level.SEVERE, "Gagal menambahkan data (SQL)", e);
            JOptionPane.showMessageDialog(this,
                    "Gagal menambahkan data (SQL): " + e.getMessage(),
                    "Error SQL", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            logger.log(java.util.logging.Level.SEVERE, "Gagal menambahkan data", e);
            JOptionPane.showMessageDialog(this,
                    "Gagal menambahkan data: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private BigDecimal toMoney(String raw) {
        String cleaned = raw.trim().replaceAll("[^\\d,\\.]", "");
        if (cleaned.isEmpty()) throw new NumberFormatException("empty");
        if (cleaned.contains(",") && cleaned.lastIndexOf(',') > cleaned.lastIndexOf('.')) {
            cleaned = cleaned.replace(".", "").replace(",", ".");
        } else {
            cleaned = cleaned.replace(",", "");
        }
        return new BigDecimal(cleaned);
    }
    private static class MoneyDocumentFilter extends DocumentFilter {
        private static final String ALLOWED = "[0-9.,]*";

        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                throws BadLocationException {
            if (string != null && string.matches(ALLOWED)) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                throws BadLocationException {
            if (text != null && text.matches(ALLOWED)) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }
    private void installMoneyInputGuards() {
        ((AbstractDocument) jTextField5.getDocument()).setDocumentFilter(new MoneyDocumentFilter()); // Total
        ((AbstractDocument) jTextField8.getDocument()).setDocumentFilter(new MoneyDocumentFilter()); // Realisasi

        FocusAdapter fa = new FocusAdapter() {
            @Override public void focusLost(FocusEvent e) {
                JTextField tf = (JTextField) e.getSource();
                String s = tf.getText().trim();
                if (s.isEmpty()) return;

                try {
                    BigDecimal val = toMoney(s);
                    tf.setText(val.toPlainString());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            AdminPengelolaAnggaran_menambah.this,
                            "Masukan nominal tidak valid.",
                            "Format Angka", JOptionPane.WARNING_MESSAGE
                    );
                    tf.requestFocus();
                }
                tryCrossFieldConstraint();
            }
        };

        jTextField5.addFocusListener(fa);
        jTextField8.addFocusListener(fa);
    }

    private void tryCrossFieldConstraint() {
        String tStr = jTextField5.getText().trim();
        String rStr = jTextField8.getText().trim();
        if (tStr.isEmpty() || rStr.isEmpty()) return;

        try{
            BigDecimal total = toMoney(tStr);
            BigDecimal real  = toMoney(rStr);
            if (real.compareTo(total) > 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "Realisasi tidak boleh lebih besar dari Total Anggaran.",
                        "Validasi Anggaran",
                        JOptionPane.WARNING_MESSAGE
                );
                jTextField8.requestFocus();
            }
        } catch (NumberFormatException ignore) {
            
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField4 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(102, 0, 0));

        jButton6.setText("X");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MENU ADMIN - PENGELOLAAN DATA ANGGARAN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton6)
                .addComponent(jLabel1))
        );

        jPanel3.setBackground(new java.awt.Color(102, 0, 0));

        jButton1.setBackground(new java.awt.Color(102, 0, 0));
        jButton1.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("DASHBOARD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 0, 0));
        jButton2.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Menambah Data");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(102, 0, 0));
        jButton3.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Melihat Data");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(102, 0, 0));
        jButton4.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Memperbarui Data");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(102, 0, 0));
        jButton5.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Menghapus Data");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(102, 0, 0));

        jLabel3.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tahun");

        jLabel4.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nama Program");

        jLabel5.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Total Anggaran");

        jLabel6.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Keterangan");

        jLabel7.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Realisasi");

        jToggleButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(102, 0, 0));
        jToggleButton1.setText("TAMBAH");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nama Instansi");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField3)
                            .addComponent(jTextField7)
                            .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(29, 29, 29)
                .addComponent(jToggleButton1)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new AdminPengelolaAnggaran().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        AdminPengelolaAnggaran_menambah tambahData = new AdminPengelolaAnggaran_menambah();
        tambahData.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    AdminPengelolaAnggaran_melihat lihatData = new AdminPengelolaAnggaran_melihat();
    lihatData.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        AdminPengelolaAnggaran_memperbarui baruiData = new AdminPengelolaAnggaran_memperbarui();
        baruiData.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
                AdminPengelolaAnggaran_menghapus hapusData = new AdminPengelolaAnggaran_menghapus();
        hapusData.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int pilih = javax.swing.JOptionPane.showConfirmDialog(
        this,
        "Apakah Anda yakin ingin kembali ke Menu Utama?",
        "Konfirmasi",
        javax.swing.JOptionPane.YES_NO_OPTION,
        javax.swing.JOptionPane.QUESTION_MESSAGE
    );

    if (pilih == javax.swing.JOptionPane.YES_OPTION) {
        // buka Menu Utama lalu tutup jendela saat ini
        java.awt.EventQueue.invokeLater(() -> {
            new menuUtama().setVisible(true); // pastikan kelas ini ada
        });
        this.dispose();
    }
    }//GEN-LAST:event_jButton6ActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new AdminPengelolaAnggaran_menambah().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JToggleButton jToggleButton1;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    // End of variables declaration//GEN-END:variables
}
