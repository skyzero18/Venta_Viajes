package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Vuelo {
    private String origen;
    private String destino;
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/USUARIO";
    private static final String USERNAME_DB = "root";
    private static final String PASSWORD_DB_1 = "1111"; // Primera contraseña
    private static final String PASSWORD_DB_2 = "chacalocura24"; // Segunda contraseña

    public Vuelo() {
    }

    public Vuelo(String origen, String destino) {
        this.origen = origen;
        this.destino = destino;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    // Método para intentar conectar con las dos contraseñas
    private Connection intentarConexion() {
        try {
            // Intentar conectar con la primera contraseña
            return DriverManager.getConnection(JDBC_URL, USERNAME_DB, PASSWORD_DB_1);
        } catch (SQLException e1) {
            // Si falla, intentar con la segunda contraseña
            System.out.println("Primera contraseña fallida, intentando con la nueva...");
            try {
                return DriverManager.getConnection(JDBC_URL, USERNAME_DB, PASSWORD_DB_2);
            } catch (SQLException e2) {
                System.err.println("Conexión fallida con ambas contraseñas: " + e2.getMessage());
                return null; // Si también falla con la nueva contraseña, retorna null
            }
        }
    }

    // Método para consultar vuelos basado en origen, destino, fecha de ida y fecha de vuelta
    public void consultarVuelos(String origen, String destino, String fechaIda, String fechaVuelta) {
        String query = "SELECT * FROM vuelos WHERE origen = ? AND destino = ? AND fecha_ida = ? AND fecha_vuelta = ?";

        try (Connection conn = intentarConexion(); // Usar el método de conexión modificado
             PreparedStatement stmt = conn.prepareStatement(query)) {

            if (conn == null) {
                System.err.println("No se pudo establecer una conexión con la base de datos.");
                return;
            }

            // Asignar los parámetros a la consulta
            stmt.setString(1, origen);
            stmt.setString(2, destino);
            stmt.setString(3, fechaIda);
            stmt.setString(4, fechaVuelta);

            // Ejecutar la consulta
            ResultSet rs = stmt.executeQuery();

            // Recorrer y mostrar los resultados
            while (rs.next()) {
                int idVuelo = rs.getInt("id_vuelo");
                String aerolinea = rs.getString("aerolinea");
                int precio = rs.getInt("precio");
                int duracion = rs.getInt("duracion");
                int numeroPasajeros = rs.getInt("numero_pasajeros");

                // Imprimir o procesar los datos obtenidos
                System.out.println("ID Vuelo: " + idVuelo + ", Aerolínea: " + aerolinea + ", Precio: " + precio +
                        ", Duración: " + duracion + " horas, Pasajeros: " + numeroPasajeros);
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar los vuelos: " + e.getMessage());
        }
    }
}
