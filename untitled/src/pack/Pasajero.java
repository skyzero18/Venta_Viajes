package pack;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
