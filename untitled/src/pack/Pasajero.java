package pack;

public class Pasajero {
    private String nombre;
    private String apellido;
    private String documentoIdentidad;

    public Pasajero(String nombre, String apellido, String documentoIdentidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    // Métodos adicionales si son necesarios
}
