package pack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UI {
    String jdbcURL = "jdbc:mysql://localhost:3306/usuario";
    String username = "root";
    String password = "1111";

    public UI() {
        JFrame ventana = new JFrame("FLY US");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(1920, 1080);
        ventana.setLayout(new CardLayout());

        JPanel panelInicial = new JPanel(new BorderLayout());
        JLabel textoBienvenida = new JLabel("¡Bienvenido a FlyUS!", SwingConstants.CENTER);
        textoBienvenida.setFont(new Font("Arial", Font.BOLD, 24));
        JButton botonEmpezar = new JButton("Empezar");

        panelInicial.add(textoBienvenida, BorderLayout.NORTH);
        panelInicial.add(botonEmpezar, BorderLayout.CENTER);

        JPanel panelCampos = new JPanel(new GridLayout(3, 2));
        JLabel label1 = new JLabel("Nombre:");
        JTextField campo1 = new JTextField();
        JLabel label2 = new JLabel("Contraseña:");
        JPasswordField campo2 = new JPasswordField();
        JButton botonFinalizar = new JButton("Acceder");

        panelCampos.add(label1);
        panelCampos.add(campo1);
        panelCampos.add(label2);
        panelCampos.add(campo2);
        panelCampos.add(botonFinalizar);

        ventana.add(panelInicial, "Panel Inicial");
        ventana.add(panelCampos, "Panel Campos");

        CardLayout cl = (CardLayout) (ventana.getContentPane().getLayout());

        botonEmpezar.addActionListener(e -> cl.show(ventana.getContentPane(), "Panel Campos"));

        botonFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreUsuario = campo1.getText();
                String contrasena = new String(campo2.getPassword());
                if (validarCredenciales(nombreUsuario, contrasena)) {
                    JOptionPane.showMessageDialog(ventana, "Acceso concedido.");
                    cl.show(ventana.getContentPane(), "Panel Inicial");
                } else {
                    JOptionPane.showMessageDialog(ventana, "Usuario o contraseña incorrectos.");
                }
            }
        });

        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    private boolean validarCredenciales(String nombreUsuario, String contrasena) {
        try (Connection conexion = DriverManager.getConnection(jdbcURL, username, password)) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, nombreUsuario);
            statement.setString(2, contrasena);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next(); // Retorna true si se encuentra una coincidencia
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        new UI();
    }
}
