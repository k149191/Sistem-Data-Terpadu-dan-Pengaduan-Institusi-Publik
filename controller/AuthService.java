package controller;

import database.DatabaseConnection;
import javax.swing.*;
import java.sql.*;

public class AuthService {
    private static AuthService instance;
    private AuthService() {}

    public static AuthService getInstance() {
        if (instance == null) instance = new AuthService();
        return instance;
    }
    private volatile LoginInfo currentLogin;

    public LoginInfo getCurrentLogin() { 
        return currentLogin; 
    }
    
    public boolean isLoggedIn() { 
        return currentLogin != null; 
    }
    
    public void logout() { 
        currentLogin = null; 
    }

    public static class LoginInfo {
        private final String idAkun;
        private final String nama;
        private final String roleType; // "ADMIN" / "PENGGUNA"
        public LoginInfo(String idAkun, String nama, String roleType) {
            this.idAkun = idAkun; this.nama = nama; this.roleType = roleType;
        }
        public String getIdAkun() { 
            return idAkun; 
        }
        public String getNama() { 
            return nama; 
        }
        public String getRoleType() { 
            return roleType; 
        }
        public boolean isAdmin() { 
            return "ADMIN".equalsIgnoreCase(roleType); 
        }
    }

    public LoginInfo loginGetRole(String email, String kataSandi) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn == null) return null;

            String q1 = "SELECT id_akun, nama FROM akun WHERE email=? AND kata_sandi=?";
            try (PreparedStatement ps = conn.prepareStatement(q1)) {
                ps.setString(1, email);
                ps.setString(2, kataSandi);
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) return null;

                    String idAkun = rs.getString("id_akun");
                    String nama   = rs.getString("nama");

                    String role = "PENGGUNA";
                    String q2 = "SELECT 1 FROM admin WHERE id_akun=? LIMIT 1";
                    try (PreparedStatement ps2 = conn.prepareStatement(q2)) {
                        ps2.setString(1, idAkun);
                        try (ResultSet r2 = ps2.executeQuery()) {
                            if (r2.next()) role = "ADMIN";
                        }
                    }

                    LoginInfo info = new LoginInfo(idAkun, nama, role);
                    this.currentLogin = info;                 // simpan sesi
                    return info;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public LoginInfo requireLoginOrRedirect(JFrame currentFrame, Runnable redirectToLogin) {
        LoginInfo li = getCurrentLogin();
        if (li != null) return li;

        JOptionPane.showMessageDialog(currentFrame, "Sesi berakhir. Silakan login ulang.");
        if (currentFrame != null) currentFrame.dispose();
        if (redirectToLogin != null) redirectToLogin.run();
        return null;
    }

    public String requireIdAkunOrRedirect(JFrame currentFrame, Runnable redirectToLogin) {
        LoginInfo li = requireLoginOrRedirect(currentFrame, redirectToLogin);
        return li != null ? li.getIdAkun() : null;
    }

    public LoginInfo requireAdminOrRedirect(JFrame currentFrame, Runnable redirectToLogin) {
        LoginInfo li = requireLoginOrRedirect(currentFrame, redirectToLogin);
        if (li == null) return null;
        if (!li.isAdmin()) {
            JOptionPane.showMessageDialog(currentFrame, "Akses ditolak: khusus ADMIN.");
            if (currentFrame != null) currentFrame.dispose();
            if (redirectToLogin != null) redirectToLogin.run();
            return null;
        }
        return li;
    }

    public LoginInfo requireLoginOrThrow() {
        LoginInfo li = getCurrentLogin();
        if (li == null) throw new IllegalStateException("Belum login.");
        return li;
    }
    public String requireIdAkunOrThrow() { 
        return requireLoginOrThrow().getIdAkun(); 
    }
    public void requireAdminOrThrow() {
        if (!requireLoginOrThrow().isAdmin()) throw new SecurityException("Akses admin diperlukan.");
    }
}
