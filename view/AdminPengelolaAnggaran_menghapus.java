package view;

import database.DatabaseConnection;
import java.sql.*;
import javax.swing.*;

public class AdminPengelolaAnggaran_menghapus extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
        java.util.logging.Logger.getLogger(AdminPengelolaAnggaran_menghapus.class.getName());

    public AdminPengelolaAnggaran_menghapus() {
        setUndecorated(true);
        initComponents();                
        setLocationRelativeTo(null);
        setResizable(false);
        jTextArea1.setEditable(false);
        pack();

        loadIdAnggaranToCombo();

        jComboBox1.addActionListener(e -> previewDariCombo());

        jButton7.addActionListener(evt -> hapusData());
    }

    private void loadIdAnggaranToCombo() {
        try {
            jComboBox1.removeAllItems();
            jComboBox1.addItem("-- Pilih ID Anggaran --");

            final String sql =
                "SELECT id_anggaran, nama_program, tahun " +
                "FROM anggaran ORDER BY id_anggaran DESC";

            try (Connection c = DatabaseConnection.getConnection();
                 PreparedStatement ps = c.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String item = rs.getString("id_anggaran") + " - " +
                                  rs.getString("nama_program") + " (" +
                                  rs.getString("tahun") + ")";
                    jComboBox1.addItem(item);
                }
            }
        } catch (Exception e) {
            logger.log(java.util.logging.Level.SEVERE, "Gagal memuat ID anggaran", e);
            JOptionPane.showMessageDialog(this, "Gagal memuat daftar ID anggaran: " + e.getMessage());
        }
    }

    private void previewDariCombo() {
        String sel = (String) jComboBox1.getSelectedItem();
        if (sel == null || sel.startsWith("--")) {
            jTextArea1.setText("");
            return;
        }
        String id = sel.split(" - ", 2)[0].trim(); 
        tampilkanPreviewById(id);
    }

    private void tampilkanPreviewById(String idAnggaran) {
        final String sql =
            "SELECT a.id_anggaran, i.nama_instansi, a.tahun, a.nama_program, " +
            "       a.total_anggaran, a.realisasi, a.keterangan " +
            "FROM anggaran a " +
            "JOIN instansi i ON i.id_instansi = a.id_instansi " +
            "WHERE a.id_anggaran = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, idAnggaran);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String detail =
                        "ID Anggaran   : " + rs.getString("id_anggaran") + "\n" +
                        "Nama Instansi : " + safe(rs, "nama_instansi") + "\n" +
                        "Tahun         : " + safe(rs, "tahun") + "\n" +
                        "Nama Program  : " + safe(rs, "nama_program") + "\n" +
                        "Total Anggaran: " + safe(rs, "total_anggaran") + "\n" +
                        "Realisasi     : " + safe(rs, "realisasi") + "\n" +
                        "Keterangan    : " + safe(rs, "keterangan");
                    jTextArea1.setText(detail);
                } else {
                    jTextArea1.setText("");
                    JOptionPane.showMessageDialog(this, "Data dengan ID tersebut tidak ditemukan!");
                }
            }
        } catch (Exception e) {
            logger.log(java.util.logging.Level.SEVERE, "Kesalahan saat menampilkan preview", e);
            JOptionPane.showMessageDialog(this, "Kesalahan saat menampilkan data: " + e.getMessage());
        }
    }

    private String safe(ResultSet rs, String col) {
        try {
            String v = rs.getString(col);
            return v == null ? "-" : v;
        } catch (Exception e) {
            return "-";
        }
    }

    private void hapusData() {
        String sel = (String) jComboBox1.getSelectedItem();
        if (sel == null || sel.startsWith("--")) {
            JOptionPane.showMessageDialog(this, "Pilih ID Anggaran terlebih dahulu.");
            return;
        }
        String idAnggaran = sel.split(" - ", 2)[0].trim();

        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn == null) {
                JOptionPane.showMessageDialog(this, "Koneksi database tidak tersedia.");
                return;
            }

            // pastikan ID ada
            try (PreparedStatement cek = conn.prepareStatement(
                    "SELECT 1 FROM anggaran WHERE id_anggaran = ?")) {
                cek.setString(1, idAnggaran);
                try (ResultSet rs = cek.executeQuery()) {
                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(this, "ID Anggaran tidak ditemukan!");
                        return;
                    }
                }
            }

            int konfirmasi = JOptionPane.showConfirmDialog(
                this,
                "Yakin hapus data ID: " + idAnggaran + " ?",
                "Konfirmasi Hapus",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
            );
            if (konfirmasi != JOptionPane.YES_OPTION) return;

            try (PreparedStatement del = conn.prepareStatement(
                    "DELETE FROM anggaran WHERE id_anggaran = ?")) {
                del.setString(1, idAnggaran);
                int rows = del.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
                    // refresh UI
                    loadIdAnggaranToCombo();
                    jTextArea1.setText("");
                    jComboBox1.setSelectedIndex(0);

                } else {
                    JOptionPane.showMessageDialog(this, "Data gagal dihapus!");
                }
            }
        } catch (Exception e) {
            logger.log(java.util.logging.Level.SEVERE, "Gagal menghapus anggaran", e);
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(102, 0, 0));

        jLabel1.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MENU ADMIN - PENGELOLAAN DATA ANGGARAN");

        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 398, Short.MAX_VALUE)
                .addComponent(jButton1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)))
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

        jButton3.setBackground(new java.awt.Color(102, 0, 0));
        jButton3.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Menambah Data");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(102, 0, 0));
        jButton4.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Melihat Data");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(102, 0, 0));
        jButton5.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Memperbarui Data");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(153, 0, 0));
        jButton6.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Menghapus Data");
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
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jLabel2.setText("Silahkan Ketik ID Anggaran yang ingin Anda Hapus:");

        jLabel3.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jLabel3.setText("ID Anggaran");

        jButton7.setBackground(new java.awt.Color(102, 0, 0));
        jButton7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("HAPUS");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton7)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
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
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new AdminPengelolaAnggaran().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        AdminPengelolaAnggaran_menambah tambahData = new AdminPengelolaAnggaran_menambah();
        tambahData.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    AdminPengelolaAnggaran_melihat lihatData = new AdminPengelolaAnggaran_melihat();
    lihatData.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    AdminPengelolaAnggaran_memperbarui baruiData = new AdminPengelolaAnggaran_memperbarui();
    baruiData.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
                AdminPengelolaAnggaran_menghapus hapusData = new AdminPengelolaAnggaran_menghapus();
        hapusData.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new AdminPengelolaAnggaran_menghapus().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
