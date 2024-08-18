package pack;

public class Usuario {
    private String jdbcURL = "jdbc:mysql://localhost:3306/USUARIO";
    private String usernameDB = "root";
    private String passwordDB = "chacalocura24";

    // Constructor (si es necesario)
    public Usuario() {
    }

    public boolean validarCredenciales(String nombreUsuario, String contrasena) {
        // Aquí puedes implementar la lógica real para validar credenciales con la base de datos
        // Utilizando los valores jdbcURL, usernameDB, y passwordDB
        return true; // Simulación de la validación
    }

    // Métodos adicionales para gestionar el usuario
}
