package view;

import database.DatabaseConnection;

import java.sql.*;
import javax.swing.*;

public class AdminPengelolaPengaduan_menambah extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(AdminPengelolaPengaduan_menambah.class.getName());

    public AdminPengelolaPengaduan_menambah() {
        setUndecorated(true);
        initComponents();

        jComboBox1.setModel(new DefaultComboBoxModel<>(
                new String[]{"ditindaklanjuti", "diselesaikan", "diteruskan"}
        ));
        jComboBox1.setSelectedIndex(0);

        jCalendar1.setDate(new java.util.Date());

        loadIdPengaduan();
        
        jButton8.addActionListener(e -> tambahTanggapan());

        setLocationRelativeTo(null);
        setResizable(false);
        pack();
    }

    private void loadIdPengaduan() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("-- Pilih ID Pengaduan --");
        final String sql = "SELECT id_pengaduan FROM pengaduan ORDER BY id_pengaduan DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                model.addElement(rs.getString("id_pengaduan"));
            }
        } catch (SQLException ex) {
            logger.log(java.util.logging.Level.SEVERE, "Gagal memuat id_pengaduan", ex);
            JOptionPane.showMessageDialog(this,
                    "Gagal memuat ID Pengaduan:\n" + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        jComboBox2.setModel(model);
        jComboBox2.setSelectedIndex(0);
    }

    private void tambahTanggapan() {
        final String idPengaduan  = (String) jComboBox2.getSelectedItem(); // id_pengaduan
        final String status       = (String) jComboBox1.getSelectedItem(); // status_keluhan
        final String isiTanggapan = jTextArea1.getText().trim();           // isi_tanggapan

        if (idPengaduan == null || idPengaduan.equals("-- Pilih ID Pengaduan --")) {
            JOptionPane.showMessageDialog(this, "Silakan pilih ID Pengaduan.");
            return;
        }
        if (status == null || status.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Status tidak boleh kosong.");
            return;
        }
        if (isiTanggapan.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Isi tanggapan tidak boleh kosong.");
            return;
        }

        java.util.Date utilDate = jCalendar1.getDate();
        if (utilDate == null) utilDate = new java.util.Date(); 

        java.time.LocalDate localDate = utilDate.toInstant()
                .atZone(java.time.ZoneId.systemDefault())
                .toLocalDate();

        java.time.LocalDateTime ldt = java.time.LocalDateTime.of(localDate, java.time.LocalTime.now());

        final String SQL_AMBIL_AKUN =
                "SELECT id_akun FROM pengaduan WHERE id_pengaduan = ? LIMIT 1";
        final String SQL_INSERT =
                "INSERT INTO tanggapan (status_keluhan, isi_tanggapan, tanggal_tanggapan, id_pengaduan, id_akun) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection()) {

            String idAkunPemilik = null;
            try (PreparedStatement p1 = conn.prepareStatement(SQL_AMBIL_AKUN)) {
                p1.setString(1, idPengaduan);
                try (ResultSet rs = p1.executeQuery()) {
                    if (rs.next()) idAkunPemilik = rs.getString("id_akun");
                }
            }

            if (idAkunPemilik == null || idAkunPemilik.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "ID Pengaduan tidak ditemukan / tidak punya id_akun.");
                return;
            }

            try (PreparedStatement p2 = conn.prepareStatement(SQL_INSERT)) {
                p2.setString(1, status);
                p2.setString(2, isiTanggapan);
                p2.setTimestamp(3, java.sql.Timestamp.valueOf(ldt));
                p2.setString(4, idPengaduan);
                p2.setString(5, idAkunPemilik);
                p2.executeUpdate();
            }

            JOptionPane.showMessageDialog(this, "Tanggapan berhasil ditambahkan.");

            jComboBox2.setSelectedIndex(0);
            jComboBox1.setSelectedIndex(0);
            jTextArea1.setText("");
            jCalendar1.setDate(new java.util.Date());

            AdminPengelolaPengaduan_melihat lihat = new AdminPengelolaPengaduan_melihat();
            lihat.setVisible(true);
            this.dispose();

        } catch (SQLException ex) {
            logger.log(java.util.logging.Level.SEVERE, "Gagal insert tanggapan", ex);
            JOptionPane.showMessageDialog(this,
                    "Gagal menambahkan tanggapan:\n" + ex.getMessage(),
                    "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jCalendar1 = new com.toedter.calendar.JCalendar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(102, 0, 0));

        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MENU ADMIN - PENGELOLAAN DATA PENGADUAN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 407, Short.MAX_VALUE)
                .addComponent(jButton1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1)
                .addComponent(jLabel1))
        );

        jPanel3.setBackground(new java.awt.Color(102, 0, 0));

        jButton2.setBackground(new java.awt.Color(102, 0, 0));
        jButton2.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("DASHBOARD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(153, 0, 0));
        jButton4.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Menambah Data");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(102, 0, 0));
        jButton5.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Melihat Data");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(102, 0, 0));
        jButton3.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Memperbarui Data");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(102, 0, 0));
        jButton7.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Menghapus Data");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(102, 0, 0));
        jButton6.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Melihat Tabel Pengaduan");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton3)
                    .addComponent(jButton7)
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(102, 0, 0));

        jLabel2.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Status");

        jLabel4.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID Pengaduan");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Isi Tanggapan");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel6.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tanggal");

        jButton8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(102, 0, 0));
        jButton8.setText("TAMBAH");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton8)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(43, Short.MAX_VALUE))
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
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
                AdminPengelolaPengaduan dashboardPengaduan = new AdminPengelolaPengaduan();
        dashboardPengaduan.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        AdminPengelolaPengaduan_memperbarui baruiPengaduan = new AdminPengelolaPengaduan_memperbarui();
        baruiPengaduan.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        AdminPengelolaPengaduan_menambah tambahPengaduan = new AdminPengelolaPengaduan_menambah();
        tambahPengaduan.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        AdminPengelolaPengaduan_melihat lihatPengaduan = new AdminPengelolaPengaduan_melihat();
        lihatPengaduan.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        AdminPengelolaPengaduan_pengaduan tabelPengaduan = new AdminPengelolaPengaduan_pengaduan();
        tabelPengaduan.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        AdminPengelolaPengaduan_menghapus hapusPengaduan = new AdminPengelolaPengaduan_menghapus();
        hapusPengaduan.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
    }//GEN-LAST:event_jButton1ActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new AdminPengelolaPengaduan_menambah().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
