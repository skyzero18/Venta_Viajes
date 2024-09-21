package pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pasajero {
    // Variables que actualizarás
    private String nombre;
    private String correo;
    private String telefono;
    private String nombrefin;

    // Constructor vacío o personalizado según tus necesidades
    public Pasajero() {}

    // Método para actualizar los datos desde la tabla users
    public void actualizarDatos(int idUsuario) {
        String sql = "SELECT username, email, telefono, nombre_titular FROM users WHERE user_id = ?";

        try (PreparedStatement statement = Database.getConnection().prepareStatement(sql)) {
            statement.setInt(1, idUsuario);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                this.nombre = rs.getString("username");
                this.correo = rs.getString("email");
                this.telefono = rs.getString("telefono");
                this.nombrefin = rs.getString("nombre_titular");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void obtenerDatos(int idUsuario) {
        String selectSql = "SELECT id_asiento, estado FROM reservas WHERE id_usuario = ?";
        String updateReservaSql = "UPDATE reservas SET estado = 'cancelada' WHERE id_usuario = ? AND estado = 'pagada'";
        String updateAsientoSql = "UPDATE asientos SET estado = 'libre' WHERE id_asiento = ? AND estado = 'ocupado'";

        try (Connection connection = Database.getConnection();
             PreparedStatement selectStatement = connection.prepareStatement(selectSql);
             PreparedStatement updateReservaStatement = connection.prepareStatement(updateReservaSql);
             PreparedStatement updateAsientoStatement = connection.prepareStatement(updateAsientoSql)) {

            // Obtener datos de reservas
            selectStatement.setInt(1, idUsuario);
            ResultSet rs = selectStatement.executeQuery();

            // Procesar resultados de la consulta
            while (rs.next()) {
                int idAsiento = rs.getInt("id_asiento");
                String estadoReserva = rs.getString("estado");
                System.out.println("ID de Asiento: " + idAsiento + ", Estado: " + estadoReserva);

                // Si el estado es 'pagada', se actualiza a 'cancelada' y se libera el asiento
                if ("pagada".equals(estadoReserva)) {
                    // Actualizar el estado de la reserva
                    updateReservaStatement.setInt(1, idUsuario);
                    updateReservaStatement.executeUpdate();
                    System.out.println("Estado de reserva de ID " + idUsuario + " cambiado a 'cancelada'.");

                    // Actualizar el estado del asiento a 'libre'
                    updateAsientoStatement.setInt(1, idAsiento);
                    int filasActualizadas = updateAsientoStatement.executeUpdate();

                    if (filasActualizadas > 0) {
                        System.out.println("Estado del asiento ID " + idAsiento + " cambiado a 'libre'.");
                    } else {
                        System.out.println("No se pudo cambiar el estado del asiento ID " + idAsiento + ". Puede que ya esté libre.");
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    // Getters para obtener los datos actualizados
    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNombrefin() {
        return nombrefin;
    }
}
