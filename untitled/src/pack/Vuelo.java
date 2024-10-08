package pack;

import java.sql.Connection;
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
    private String aerolinea;
    private String precio;
    private String duracion;

    // Constructor vacío
    public Vuelo() {
    }

    // Constructor con parámetros
    public Vuelo(String origen, String destino, String fechaIda, String fechaVuelta, String aerolinea, String precio, String duracion) {
        this.origen = origen;
        this.destino = destino;
        this.fechaIda = fechaIda;
        this.fechaVuelta = fechaVuelta;
        this.aerolinea = aerolinea;
        this.precio = precio;
        this.duracion = duracion;
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

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }


    public List<Vuelo> consultarVuelos(String origen, String destino, String fechaIda, String fechaVuelta, String aerolinea, String precio, String duracion) {
        String query = "SELECT * FROM vuelos WHERE origen = ? AND destino = ? AND fecha_ida = ? AND fecha_vuelta = ? AND aerolinea = ? AND precio = ? AND duracion = ?";
        List<Vuelo> listaVuelos = new ArrayList<>();

        try (Connection conn = Database.getConnection()) {
            if (conn == null) {
                System.err.println("No se pudo establecer la conexión.");
                return listaVuelos;
            }

            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, origen);
                stmt.setString(2, destino);
                stmt.setString(3, fechaIda);
                stmt.setString(4, fechaVuelta);
                stmt.setString(5, aerolinea);
                stmt.setString(6, precio);
                stmt.setString(7, duracion);

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Vuelo vuelo = new Vuelo(
                            rs.getString("origen"),
                            rs.getString("destino"),
                            rs.getString("fecha_ida"),
                            rs.getString("fecha_vuelta"),
                            rs.getString("aerolinea"),
                            rs.getString("precio"),
                            rs.getString("duracion")
                    );
                    listaVuelos.add(vuelo);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar los vuelos: " + e.getMessage());
        }

        return listaVuelos;
    }

    public List<Vuelo> busquedaentera() {
        String query = "SELECT * FROM vuelos";
        List<Vuelo> listaVuelos = new ArrayList<>();

        try (Connection conn = Database.getConnection()) {
            if (conn == null) {
                System.err.println("No se pudo establecer la conexión.");
                return listaVuelos;
            }

            try (PreparedStatement stmt = conn.prepareStatement(query);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Vuelo vuelo = new Vuelo(
                            rs.getString("origen"),
                            rs.getString("destino"),
                            rs.getString("fecha_ida"),
                            rs.getString("fecha_vuelta"),
                            rs.getString("aerolinea"),
                            rs.getString("precio"),
                            rs.getString("duracion")
                    );
                    listaVuelos.add(vuelo);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar los registros de la tabla vuelos: " + e.getMessage());
        }

        return listaVuelos;
    }
    public boolean consultarAsientoOcupado(int idVuelo, int idAsiento) {
        String query = "SELECT estado FROM asientos WHERE id_vuelo = ? AND id_asiento = ?";

        try (Connection conn = Database.getConnection()) {
            if (conn == null) {
                System.err.println("No se pudo establecer la conexión.");
                return false;
            }

            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, idVuelo);
                stmt.setInt(2, idAsiento);

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    String estado = rs.getString("estado");

                    // Verificar si el asiento está ocupado
                    if ("Ocupado".equalsIgnoreCase(estado)) {
                        return true; // Asiento está ocupado
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar el asiento: " + e.getMessage());
        }

        return false; // Asiento no está ocupado o no existe
    }


    public int obtenerIdVuelo(String origen, String destino, String fechaIda, String fechaVuelta, String aerolinea) {
        int idVuelo = -1; // Valor por defecto si no se encuentra ningún vuelo

        String sql = "SELECT id_vuelo FROM vuelos WHERE origen = ? AND destino = ? AND fecha_ida = ? AND fecha_vuelta = ? AND aerolinea = ?";

        try (Connection conn = Database.getConnection(); // Obtener conexión
             PreparedStatement pstmt = conn.prepareStatement(sql)) { // Preparar declaración con la conexión
            pstmt.setString(1, origen);
            pstmt.setString(2, destino);
            pstmt.setString(3, fechaIda);
            pstmt.setString(4, fechaVuelta);
            pstmt.setString(5, aerolinea);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    idVuelo = rs.getInt("id_vuelo");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        }

        return idVuelo;
    }

    public int obtenerIdAsiento(String asientoSeleccionado) {
        int idAsiento = -1; // Valor por defecto si no se encuentra el asiento

        String sql = "SELECT id_asiento FROM asientos WHERE numero_asiento = ?";

        try (Connection conn = Database.getConnection(); // Obtener conexión
             PreparedStatement pstmt = conn.prepareStatement(sql)) { // Preparar declaración con la conexión
            pstmt.setString(1, asientoSeleccionado); // Usar asientoSeleccionado como parámetro

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    idAsiento = rs.getInt("id_asiento"); // Obtener el id_asiento
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        }

        return idAsiento; // Devolver el id del asiento
    }



}
