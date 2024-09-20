package pack;

import java.sql.*;

public class Usuario {

    public static int userId;

    public Usuario() {
    }

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
        } catch (SQLException e) {
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
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Error en la conexión o consulta
        }
    }

    // Método para cerrar sesión para todos los usuarios activos
    public static void cerrarSesion() {
        String sqlUpdate = "UPDATE users SET status = 'inactive' WHERE status = 'active'";

        try (Connection conexion = Database.getConnection();
             PreparedStatement updateStatement = conexion.prepareStatement(sqlUpdate)) {

            if (conexion == null) {
                System.out.println("No se pudo establecer la conexión con la base de datos.");
                return;
            }

            int filasActualizadas = updateStatement.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Sesión cerrada para todos los usuarios activos.");
            } else {
                System.out.println("No hay usuarios activos.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al cerrar sesión.");
        }
    }

    public static Integer consultarUsuariosActivos() {
        String sql = "SELECT user_id FROM users WHERE status = 'active'";

        try (Connection conexion = Database.getConnection();
             PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            // Si hay al menos un usuario activo, guarda su id y retorna
            if (rs.next()) {
                userId = rs.getInt("user_id");
                System.out.println(userId);
                return userId;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public void pagofin(int idAsiento, int hayusuariosactivos, String titular) {
        System.out.println("Usuarios activos: " + hayusuariosactivos);
        System.out.println("ID de asiento: " + idAsiento);
        System.out.println("Titular: " + titular);

        String insertSql = "INSERT INTO reservas (id_usuario, id_asiento, fecha_reserva) VALUES (?, ?, ?)";
        String updateSql = "UPDATE asientos SET estado = 'ocupado' WHERE id_asiento = ? AND estado = 'libre'";
        String updateUserSql = "UPDATE users SET nombre_titular = ? WHERE user_id = ?";

        try (Connection conexion = Database.getConnection();
             PreparedStatement insertPstmt = conexion.prepareStatement(insertSql);
             PreparedStatement updatePstmt = conexion.prepareStatement(updateSql);
             PreparedStatement updateUserPstmt = conexion.prepareStatement(updateUserSql)) {

            // Verificar la conexión
            if (conexion == null) {
                System.out.println("No se pudo establecer la conexión con la base de datos.");
                return;
            }

            // Inserción en la tabla reservas
            insertPstmt.setInt(1, hayusuariosactivos); // ID del usuario
            insertPstmt.setInt(2, idAsiento); // ID del asiento
            insertPstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis())); // Fecha y hora actuales
            insertPstmt.executeUpdate();
            System.out.println("Reserva realizada con éxito.");

            // Actualización del estado del asiento
            updatePstmt.setInt(1, idAsiento);
            int filasActualizadas = updatePstmt.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Estado del asiento actualizado a 'ocupado'.");

                // Actualización del nombre del titular
                updateUserPstmt.setString(1, titular);
                updateUserPstmt.setInt(2, hayusuariosactivos);
                int filasActualizadasUser = updateUserPstmt.executeUpdate();

                if (filasActualizadasUser > 0) {
                    System.out.println("Nombre del titular actualizado con éxito.");
                } else {
                    System.out.println("No se pudo actualizar el nombre del titular. Puede que no exista.");
                }

            } else {
                System.out.println("No se pudo actualizar el estado del asiento. Puede que ya esté ocupado.");
            }

        } catch (SQLException e) {
            System.err.println("Error durante la operación de base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }




}
