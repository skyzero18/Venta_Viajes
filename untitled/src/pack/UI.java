package pack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
    public UI() {
        JFrame ventana = new JFrame("FLY US");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 400); // Ventana más grande para acomodar los asientos
        ventana.setLayout(new CardLayout()); // Configuración de CardLayout

        CardLayout cl = (CardLayout) ventana.getContentPane().getLayout();

        // Panel Inicial
        JPanel panelInicial = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel textoBienvenida = new JLabel("¡Bienvenido a FlyUS!", SwingConstants.CENTER);
        textoBienvenida.setFont(new Font("Arial", Font.BOLD, 16));
        JButton botonEmpezar = new JButton("Empezar");
        botonEmpezar.setPreferredSize(new Dimension(80, 25));
        botonEmpezar.setFont(new Font("Arial", Font.PLAIN, 12));
        JButton botonReg = new JButton("Registrarse");
        botonReg.setPreferredSize(new Dimension(80, 25));
        botonReg.setFont(new Font("Arial", Font.PLAIN, 12));

        panelInicial.add(textoBienvenida);
        panelInicial.add(botonEmpezar);
        panelInicial.add(botonReg);

        // Panel de Login
        JPanel panelLogin = new JPanel();
        panelLogin.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JLabel labelUsuarioLogin = new JLabel("Nombre:");
        JTextField campoUsuarioLogin = new JTextField(10);
        JLabel labelContrasenaLogin = new JLabel("Contraseña:");
        JPasswordField campoContrasenaLogin = new JPasswordField(10);
        JButton botonAcceder = new JButton("Acceder");
        botonAcceder.setPreferredSize(new Dimension(80, 25));
        botonAcceder.setFont(new Font("Arial", Font.PLAIN, 12));

        panelLogin.add(labelUsuarioLogin);
        panelLogin.add(campoUsuarioLogin);
        panelLogin.add(labelContrasenaLogin);
        panelLogin.add(campoContrasenaLogin);
        panelLogin.add(botonAcceder);

        // Panel de Bienvenida
        JPanel panelBienvenida = new JPanel();
        panelBienvenida.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel labelOrigen = new JLabel("Origen:");
        JComboBox<String> comboOrigen = new JComboBox<>(new String[]{"Nueva York", "Los Ángeles", "Miami"});
        JLabel labelDestino = new JLabel("Destino:");
        JComboBox<String> comboDestino = new JComboBox<>(new String[]{"Londres", "París", "Tokio"});
        JButton botonBuscarVuelos = new JButton("Buscar vuelos");
        botonBuscarVuelos.setPreferredSize(new Dimension(100, 25));
        botonBuscarVuelos.setFont(new Font("Arial", Font.PLAIN, 12));

        panelBienvenida.add(labelOrigen);
        panelBienvenida.add(comboOrigen);
        panelBienvenida.add(labelDestino);
        panelBienvenida.add(comboDestino);
        panelBienvenida.add(botonBuscarVuelos);

        // Panel de Registro
        JPanel panelRegistro = new JPanel();
        panelRegistro.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel labelUsuarioReg = new JLabel("Nombre de Usuario:");
        JTextField campoUsuarioReg = new JTextField(15);
        JLabel labelContrasenaReg = new JLabel("Contraseña:");
        JPasswordField campoContrasenaReg = new JPasswordField(15);
        JButton botonRegistro = new JButton("Registrar");
        botonRegistro.setPreferredSize(new Dimension(100, 25));
        botonRegistro.setFont(new Font("Arial", Font.PLAIN, 12));

        panelRegistro.add(labelUsuarioReg);
        panelRegistro.add(campoUsuarioReg);
        panelRegistro.add(labelContrasenaReg);
        panelRegistro.add(campoContrasenaReg);
        panelRegistro.add(botonRegistro);

        // Panel de Asientos
        JPanel panelAsientos = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        int numRows = 6; // Número de filas
        int numCols = 4; // Dos columnas a cada lado del pasillo

        // Crear botones para asientos
        JButton[][] asientos = new JButton[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                gbc.gridy = i;
                if (j == 2) {
                    gbc.gridx = j + 1;
                } else {
                    gbc.gridx = j;
                }

                asientos[i][j] = new JButton("A" + (i + 1) + (j + 1));
                panelAsientos.add(asientos[i][j], gbc);
            }
        }

        // Añadir los paneles a la ventana
        ventana.add(panelInicial, "Panel Inicial");
        ventana.add(panelLogin, "Panel Login");
        ventana.add(panelBienvenida, "Panel Bienvenida");
        ventana.add(panelAsientos, "Panel Asientos");
        ventana.add(panelRegistro, "Panel Registro");

        // Mostrar el panel inicial primero
        cl.show(ventana.getContentPane(), "Panel Inicial");

        botonEmpezar.addActionListener(e -> cl.show(ventana.getContentPane(), "Panel Login"));
        botonReg.addActionListener(e -> cl.show(ventana.getContentPane(), "Panel Registro"));

        botonAcceder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreUsuario = campoUsuarioLogin.getText();
                String contrasena = new String(campoContrasenaLogin.getPassword());
                Usuario usuario = new Usuario(); // Instanciar la clase Usuario
                if (usuario.validarCredenciales(nombreUsuario, contrasena)) {
                    JOptionPane.showMessageDialog(ventana, "Acceso concedido.");
                    cl.show(ventana.getContentPane(), "Panel Bienvenida");
                } else {
                    JOptionPane.showMessageDialog(ventana, "Usuario o contraseña incorrectos.");
                }
            }
        });

        botonBuscarVuelos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String origenSeleccionado = (String) comboOrigen.getSelectedItem();
                String destinoSeleccionado = (String) comboDestino.getSelectedItem();
                JOptionPane.showMessageDialog(ventana, "Buscando vuelos desde " + origenSeleccionado + " hacia " + destinoSeleccionado);
                cl.show(ventana.getContentPane(), "Panel Asientos");
            }
        });

        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UI::new);
    }
}
