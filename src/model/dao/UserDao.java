package model.dao;

import java.sql.*;

public class UserDao {

    public Long logar(String login_user, String password_user) throws SQLException {
        Long idUser = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/banco_val_desktop_pig", "root", "admin");
            pstmt = conn.prepareStatement("SELECT id_user FROM usuario WHERE login_user LIKE ? AND password_user LIKE ?");
            pstmt.setString(1, login_user);
            pstmt.setString(2, password_user);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                idUser = rs.getLong("id_user");
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Erro: "+ e.getMessage());
        } finally {
            conn.close();
            pstmt.close();
        }

        return idUser;
    }

}
