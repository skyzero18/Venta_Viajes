package pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

    public Usuario() {
    }

    // Método para validar credenciales y activar el usuario
    public boolean validarCredenciales(String email, String contrasena) {
        String selectSql = "SELECT * FROM users WHERE email = ? AND password = ?";
        String updateSql = "UPDATE users SET status = 'active' WHERE email = ? AND password = ?";

        try (Connection conexion = Database.getConnection();
             PreparedStatement selectStatement = conexion.prepareStatement(selectSql);
             PreparedStatement updateStatement = conexion.prepareStatement(updateSql)) {

            if (conexion == null) {
                System.out.println("No se pudo establecer la conexión con la base de datos.");
                return false;
            }

            // Verificar credenciales
            selectStatement.setString(1, email);
            selectStatement.setString(2, contrasena);
            try (ResultSet resultSet = selectStatement.executeQuery()) {
                if (resultSet.next()) { // Si hay un usuario con esas credenciales
                    // Actualizar estado del usuario a 'active'
                    updateStatement.setString(1, email);
                    updateStatement.setString(2, contrasena);
                    updateStatement.executeUpdate();
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método para insertar un nuevo usuario
    public boolean insertarUsuario(String nombreUsuario, String contrasena, String email, String telefono) {
        String sql = "INSERT INTO users (username, password, email, telefono) VALUES (?,?,?,?)";

        try (Connection conexion = Database.getConnection();
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

    // Método para cerrar sesión para todos los usuarios activos
    public static void cerrarSesion() {
        String sqlSelect = "SELECT email FROM users WHERE status = 'active'";
        String sqlUpdate = "UPDATE users SET status = 'inactive' WHERE status = 'active'";

        try (Connection conexion = Database.getConnection();
             PreparedStatement selectStatement = conexion.prepareStatement(sqlSelect);
             PreparedStatement updateStatement = conexion.prepareStatement(sqlUpdate)) {

            if (conexion == null) {
                System.out.println("No se pudo establecer la conexión con la base de datos.");
                return;
            }

            // Consultar usuarios activos
            try (ResultSet resultSet = selectStatement.executeQuery()) {
                boolean hayUsuariosActivos = false;
                while (resultSet.next()) {
                    hayUsuariosActivos = true;
                    // Aquí podrías realizar alguna acción adicional con los usuarios activos si es necesario
                }

                if (hayUsuariosActivos) {
                    // Actualizar estado a 'inactive'
                    updateStatement.executeUpdate();
                    System.out.println("Sesión cerrada para todos los usuarios activos.");
                } else {
                    System.out.println("No hay usuarios activos.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al cerrar sesión.");
        }
    }

    public static boolean consultarUsuariosActivos() {
        String sql = "SELECT * FROM users WHERE status = 'active'";

        try (Connection conexion = Database.getConnection();
             PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            // Si hay al menos un usuario activo, retorna true
            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Si no se encontró ningún usuario activo, retorna false
        return false;
    }




}
