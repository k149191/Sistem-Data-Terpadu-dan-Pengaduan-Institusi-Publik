package view;

import database.DatabaseConnection;
import java.math.BigDecimal;
import java.sql.*;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class AdminPengelolaAnggaran_memperbarui extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
        java.util.logging.Logger.getLogger(AdminPengelolaAnggaran_memperbarui.class.getName());

    private boolean suppressEvents = false;

    public AdminPengelolaAnggaran_memperbarui() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        pack();

        installMoneyInputGuards();

        populateYearCombo();

        loadIdAnggaranToCombo();

        jComboBox1.addActionListener(e -> isiFormDariCombo());
        jButton7.addActionListener(evt -> perbaruiData());
    }

private void installMoneyInputGuards() {
    ((AbstractDocument) jTextField4.getDocument()).setDocumentFilter(new MoneyDocumentFilter());
    ((AbstractDocument) jTextField5.getDocument()).setDocumentFilter(new MoneyDocumentFilter());

    jTextField4.addFocusListener(new java.awt.event.FocusAdapter() {
        @Override 
        public void focusGained(java.awt.event.FocusEvent e) { }

        @Override 
        public void focusLost(java.awt.event.FocusEvent e) {
            formatMoneyField(jTextField4);
        }
    });

    jTextField5.addFocusListener(new java.awt.event.FocusAdapter() {
        @Override 
        public void focusGained(java.awt.event.FocusEvent e) { }

        @Override 
        public void focusLost(java.awt.event.FocusEvent e) {
            formatMoneyField(jTextField5);
        }
    });
}


    private void formatMoneyField(JTextField tf) {
        String txt = tf.getText().trim();
        if (txt.isEmpty()) return;
        try {
            BigDecimal val = toMoney(txt);
            tf.setText(formatIDR(val));
        } catch (Exception ignore) {
        }
    }

    private static class MoneyDocumentFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                throws BadLocationException {
            if (isAllowed(string)) super.insertString(fb, offset, string, attr);
        }
        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                throws BadLocationException {
            if (isAllowed(text)) super.replace(fb, offset, length, text, attrs);
        }
        private boolean isAllowed(String s) {
            if (s == null) return true;
            return s.matches("[0-9.,\\s]+");
        }
    }

    private String formatIDR(BigDecimal v) {
    Locale localeID = new Locale("id", "ID");
    NumberFormat nf = NumberFormat.getCurrencyInstance(localeID);
    nf.setMaximumFractionDigits(0);
    nf.setMinimumFractionDigits(0);
        String out = nf.format(v);

        
          if (!out.startsWith("Rp ")) {
        out = out.replace("Rp", "Rp ");
    }
        return out;
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
    
    private void populateYearCombo() {
        suppressEvents = true;
        try {
            jComboBox2.removeAllItems();
            int current = java.time.LocalDate.now().getYear();
            int end = current + 4; // tampilkan 5 tahun ke atas (termasuk tahun ini)
            for (int y = current; y <= end; y++) {
                jComboBox2.addItem(String.valueOf(y));
            }
            jComboBox2.setSelectedItem(String.valueOf(current));
        } finally {
            suppressEvents = false;
        }
    }


    private void setComboYearIfExists(String yearStr) {
        if (yearStr == null || yearStr.isBlank()) return;
        suppressEvents = true;
        try {
            ComboBoxModel<String> model = jComboBox2.getModel();
            boolean found = false;
            for (int i = 0; i < model.getSize(); i++) {
                if (yearStr.equals(model.getElementAt(i))) {
                    jComboBox2.setSelectedIndex(i);
                    found = true;
                    break;
                }
            }
            if (!found) {
                jComboBox2.insertItemAt(yearStr, 0);
                jComboBox2.setSelectedIndex(0);
            }
        } finally {
            suppressEvents = false;
        }
    }

    private void loadIdAnggaranToCombo() {
        try {
            suppressEvents = true;
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
            jComboBox1.setSelectedIndex(0); 
        } catch (Exception e) {
            logger.log(java.util.logging.Level.SEVERE, "Gagal memuat ID anggaran", e);
            JOptionPane.showMessageDialog(this, "Gagal memuat daftar ID anggaran: " + e.getMessage());
        } finally {
            suppressEvents = false;
        }
    }

    private void isiFormDariCombo() {
        if (suppressEvents) return;

        String sel = (String) jComboBox1.getSelectedItem();
        if (sel == null || sel.startsWith("--")) {
            clearForm();
            return;
        }
        String id = sel.split(" - ", 2)[0].trim();

        final String sql =
            "SELECT tahun, nama_program, total_anggaran, realisasi, keterangan " +
            "FROM anggaran WHERE id_anggaran = ?";

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int thn = rs.getInt("tahun");
                    setComboYearIfExists(String.valueOf(thn));

                    jTextField3.setText(rs.getString("nama_program"));

                    BigDecimal total = rs.getBigDecimal("total_anggaran");
                    BigDecimal real  = rs.getBigDecimal("realisasi");
                    jTextField4.setText(total != null ? formatIDR(total) : "");
                    jTextField5.setText(real  != null ? formatIDR(real)  : "");

                    jTextField6.setText(rs.getString("keterangan"));
                } else {
                    JOptionPane.showMessageDialog(this, "Data ID " + id + " tidak ditemukan.");
                    clearForm();
                }
            }
        } catch (Exception e) {
            logger.log(java.util.logging.Level.SEVERE, "Gagal memuat detail anggaran", e);
            JOptionPane.showMessageDialog(this, "Gagal memuat detail: " + e.getMessage());
        }
    }
    
    private void perbaruiData() {
        String selected = (String) jComboBox1.getSelectedItem();
        if (selected == null || selected.startsWith("--")) {
            JOptionPane.showMessageDialog(this, "Pilih ID Anggaran terlebih dahulu.");
            return;
        }
        String idAnggaran = selected.split(" - ", 2)[0].trim();

        String tahunStr         = (String) jComboBox2.getSelectedItem();
        String namaProgram      = jTextField3.getText().trim();
        String totalAnggaranStr = jTextField4.getText().trim();
        String realisasiStr     = jTextField5.getText().trim();
        String keterangan       = jTextField6.getText().trim();

        if (tahunStr == null || tahunStr.isEmpty() ||
            namaProgram.isEmpty() || totalAnggaranStr.isEmpty() ||
            realisasiStr.isEmpty() || keterangan.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field wajib diisi!");
            return;
        }

        int tahun;
        try {
            tahun = Integer.parseInt(tahunStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Tahun tidak valid.");
            return;
        }
        if (tahun < 2024 || tahun > 2100) {
            JOptionPane.showMessageDialog(this, "Tahun tidak valid.");
            return;
        }

        BigDecimal totalAnggaran, realisasi;
        try {
            totalAnggaran = toMoney(totalAnggaranStr);
            realisasi     = toMoney(realisasiStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Total anggaran dan realisasi harus berupa angka!");
            return;
        }

        if (realisasi.compareTo(totalAnggaran) > 0) {
            JOptionPane.showMessageDialog(this, "Realisasi tidak boleh lebih besar dari Total Anggaran.");
            jTextField5.requestFocus();
            return;
        }

        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn == null) {
                JOptionPane.showMessageDialog(this, "Koneksi database tidak tersedia.");
                return;
            }

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

            String updateSql = """
                UPDATE anggaran
                   SET tahun = ?, nama_program = ?, total_anggaran = ?, realisasi = ?, keterangan = ?
                 WHERE id_anggaran = ?
            """;
            try (PreparedStatement ps = conn.prepareStatement(updateSql)) {
                ps.setInt(1, tahun);
                ps.setString(2, namaProgram);
                ps.setBigDecimal(3, totalAnggaran);
                ps.setBigDecimal(4, realisasi);
                ps.setString(5, keterangan);
                ps.setString(6, idAnggaran);

                int rows = ps.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(this, "Data anggaran berhasil diperbarui!");

                    suppressEvents = true;
                    loadIdAnggaranToCombo();
                    jComboBox1.setSelectedIndex(0);
                    clearForm();
                    suppressEvents = false;

                    jComboBox1.requestFocusInWindow();
                } else {
                    JOptionPane.showMessageDialog(this, "Tidak ada perubahan disimpan!");
                }
            }
        } catch (Exception e) {
            logger.log(java.util.logging.Level.SEVERE, "Gagal memperbarui anggaran", e);
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage());
        }
    }

    private void clearForm() {
        populateYearCombo();
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");  
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
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();

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
        jLabel1.setText("MENU ADMIN - PENGELOLAAN DATA ANGGARAN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jButton3.setBackground(new java.awt.Color(102, 0, 0));
        jButton3.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Menambah Data");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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

        jButton6.setBackground(new java.awt.Color(153, 0, 0));
        jButton6.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Memperbarui Data");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(102, 0, 0));
        jButton4.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Menghapus Data");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
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
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
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
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(102, 0, 0));

        jLabel2.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Silahkan Ketik ID Anggaran yang ingin Anda Perbarui:");

        jLabel3.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID Anggaran");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jLabel4.setText("Tambahkan Data Anggaran yang Baru:");

        jLabel5.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jLabel5.setText("Tahun");

        jLabel6.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jLabel6.setText("Nama Program");

        jLabel7.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jLabel7.setText("Total Anggaran");

        jLabel8.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jLabel8.setText("Realisasi");

        jLabel9.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jLabel9.setText("Keterangan");

        jButton7.setBackground(new java.awt.Color(102, 0, 0));
        jButton7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("PERBARUI");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton7)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        AdminPengelolaAnggaran_menambah tambahData = new AdminPengelolaAnggaran_menambah();
        tambahData.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
                AdminPengelolaAnggaran_menghapus hapusData = new AdminPengelolaAnggaran_menghapus();
        hapusData.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    AdminPengelolaAnggaran_melihat lihatData = new AdminPengelolaAnggaran_melihat();
    lihatData.setVisible(true);
    this.dispose();
    this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    AdminPengelolaAnggaran_memperbarui baruiData = new AdminPengelolaAnggaran_memperbarui();
    baruiData.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new AdminPengelolaAnggaran_memperbarui().setVisible(true));
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
    private javax.swing.JComboBox<String> jComboBox2;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
