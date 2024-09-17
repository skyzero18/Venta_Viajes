package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Usuario {
    private String jdbcURL = "jdbc:mysql://localhost:3306/USUARIO";
    private String usernameDB = "root";
    private String passwordDB = "1111"; // Contraseña inicial

    public Usuario() {
    }

    // Método para intentar conectar con las dos contraseñas
    private Connection intentarConexion() {
        try {
            // Intentar conectar con la primera contraseña
            return DriverManager.getConnection(jdbcURL, usernameDB, passwordDB);
        } catch (Exception e1) {
            // Si falla, intentar con la segunda contraseña
            System.out.println("Primera contraseña fallida, intentando con la nueva...");
            try {
                passwordDB = "chacalocura24"; // Cambiar la contraseña
                return DriverManager.getConnection(jdbcURL, usernameDB, passwordDB);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null; // Si también falla con la nueva contraseña, retorna null
            }
        }
    }

    public boolean validarCredenciales(String email, String contrasena) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

        try (Connection conexion = intentarConexion();
             PreparedStatement statement = conexion.prepareStatement(sql)) {

            if (conexion == null) {
                System.out.println("No se pudo establecer la conexión con la base de datos.");
                return false;
            }

            statement.setString(1, email);
            statement.setString(2, contrasena);

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next(); // Devuelve true si encuentra un resultado
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Error en la conexión o consulta
        }
    }

    public boolean insertarUsuario(String nombreUsuario, String contrasena, String email, String telefono) {
        String sql = "INSERT INTO users (username, password, email, telefono) VALUES (?, ?, ?,?)";

        try (Connection conexion = intentarConexion();
             PreparedStatement statement = conexion.prepareStatement(sql)) {

            if (conexion == null) {
                System.out.println("No se pudo establecer la conexión con la base de datos.");
                return false;
            }

            statement.setString(1, nombreUsuario);
            statement.setString(2, contrasena);
            statement.setString(3, email);
            statement.setString(4, telefono);
            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Error en la conexión o consulta
        }
    }
}
