package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Vuelo {
    private String origen;
    private String destino;
    private String fechaIda;
    private String fechaVuelta;
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/USUARIO";
    private static final String USERNAME_DB = "root";
    private static final String PASSWORD_DB_1 = "1111"; // Primera contraseña
    private static final String PASSWORD_DB_2 = "chacalocura24"; // Segunda contraseña

    // Constructor vacío
    public Vuelo() {
    }

    // Constructor con origen, destino, fechaIda y fechaVuelta
    public Vuelo(String origen, String destino, String fechaIda, String fechaVuelta) {
        this.origen = origen;
        this.destino = destino;
        this.fechaIda = fechaIda;
        this.fechaVuelta = fechaVuelta;
    }

    // Getters y setters
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

    public String getFechaIda() {
        return fechaIda;
    }

    public void setFechaIda(String fechaIda) {
        this.fechaIda = fechaIda;
    }

    public String getFechaVuelta() {
        return fechaVuelta;
    }

    public void setFechaVuelta(String fechaVuelta) {
        this.fechaVuelta = fechaVuelta;
    }

    // Método para intentar la conexión a la base de datos con dos contraseñas
    private Connection intentarConexion() {
        try {
            return DriverManager.getConnection(JDBC_URL, USERNAME_DB, PASSWORD_DB_1);
        } catch (SQLException e1) {
            System.out.println("Primera contraseña fallida, intentando con la nueva...");
            try {
                return DriverManager.getConnection(JDBC_URL, USERNAME_DB, PASSWORD_DB_2);
            } catch (SQLException e2) {
                System.err.println("Conexión fallida con ambas contraseñas: " + e2.getMessage());
                return null;
            }
        }
    }

    // Método para consultar vuelos basado en origen, destino, fecha de ida y fecha de vuelta
    public List<Vuelo> consultarVuelos(String origen, String destino, String fechaIda, String fechaVuelta) {
        String query = "SELECT * FROM vuelos WHERE origen = ? AND destino = ? AND fecha_ida = ? AND fecha_vuelta = ?";
        List<Vuelo> listaVuelos = new ArrayList<>();

        try (Connection conn = intentarConexion()) {
            if (conn == null) {
                System.err.println("No se pudo establecer la conexión.");
                return listaVuelos; // Retorna la lista vacía
            }

            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, origen);
                stmt.setString(2, destino);
                stmt.setString(3, fechaIda);
                stmt.setString(4, fechaVuelta);

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    // Creación de un objeto Vuelo para cada fila de resultado
                    Vuelo vuelo = new Vuelo(rs.getString("origen"), rs.getString("destino"), rs.getString("fecha_ida"), rs.getString("fecha_vuelta"));
                    listaVuelos.add(vuelo);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar los vuelos: " + e.getMessage());
        }

        return listaVuelos; // Devuelve la lista de vuelos encontrados
    }
}
