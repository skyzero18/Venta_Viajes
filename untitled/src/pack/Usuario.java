package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Usuario {
    private String jdbcURL = "jdbc:mysql://localhost:3306/USUARIO"; // Asegúrate de que esta URL sea correcta
    private String usernameDB = "root"; // Nombre de usuario de la base de datos
    private String passwordDB = "chacalocura24"; // Contraseña de la base de datos

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
                if (resultSet.next()) {
                    return true; // Credenciales válidas
                } else {
                    return false; // Credenciales inválidas
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Error en la conexión o consulta
        }
    }

    public boolean insertarUsuario(String nombreUsuario, String contrasena, String email) {
        String sql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";

        try (Connection conexion = DriverManager.getConnection(jdbcURL, usernameDB, passwordDB);
             PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setString(1, nombreUsuario);
            statement.setString(2, contrasena);
            statement.setString(3, email);
            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Error en la conexión o consulta
        }
    }
}
