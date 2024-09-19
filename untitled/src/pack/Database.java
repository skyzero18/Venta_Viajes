package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/USUARIO";
    private static final String USERNAME_DB = "root";
    private static final String PASSWORD_DB_1 = "1111"; // Primera contraseña
    private static final String PASSWORD_DB_2 = "chacalocura24"; // Segunda contraseña

    // Método para intentar la conexión a la base de datos con dos contraseñas
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(JDBC_URL, USERNAME_DB, PASSWORD_DB_1);
        } catch (SQLException e1) {
            System.out.println("Primera contraseña fallida, intentando con la segunda...");
            try {
                return DriverManager.getConnection(JDBC_URL, USERNAME_DB, PASSWORD_DB_2);
            } catch (SQLException e2) {
                System.err.println("Conexión fallida con ambas contraseñas: " + e2.getMessage());
                return null;
            }
        }
    }
}
