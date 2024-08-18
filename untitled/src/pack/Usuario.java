package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Usuario {
    private String jdbcURL = "jdbc:mysql://localhost:3306/USUARIO";
    private String usernameDB = "root";
    private String passwordDB = "1111";

    // Constructor (si es necesario)
    public Usuario() {
    }

    public boolean validarCredenciales(String nombreUsuario, String contrasena) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection conexion = DriverManager.getConnection(jdbcURL, usernameDB, passwordDB);
             PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setString(1, nombreUsuario);
            statement.setString(2, contrasena);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next(); // Retorna true si se encuentra una coincidencia
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Métodos adicionales para gestionar el usuario
}
