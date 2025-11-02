package main;

import view.menuUtama;

public class MainApp {
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            System.err.println("Gagal mengatur Look and Feel: " + ex.getMessage());
        }

        java.awt.EventQueue.invokeLater(() -> {
            menuUtama frame = new menuUtama();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        });
    }
}
