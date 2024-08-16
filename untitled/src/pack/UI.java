package pack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
    String jdbcURL = "jdbc:mysql://localhost:3306/USUARIO";
    String username = "root";
    String password = "chacalocura24";

    public UI() {
        JFrame ventana = new JFrame("FLY US");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 300); // Ventana más pequeña
        ventana.setLayout(new CardLayout());

        // Panel Inicial
        JPanel panelInicial = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel textoBienvenida = new JLabel("¡Bienvenido a FlyUS!", SwingConstants.CENTER);
        textoBienvenida.setFont(new Font("Arial", Font.BOLD, 16)); // Fuente más pequeña
        JButton botonEmpezar = new JButton("Empezar");
        botonEmpezar.setPreferredSize(new Dimension(80, 25)); // Tamaño ajustado
        botonEmpezar.setFont(new Font("Arial", Font.PLAIN, 12)); // Fuente más pequeña

        panelInicial.add(textoBienvenida);
        panelInicial.add(botonEmpezar);

        // Panel de Login
        JPanel panelCampos = new JPanel();
        panelCampos.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5)); // Layout compacto
        JLabel label1 = new JLabel("Nombre:");
        JTextField campo1 = new JTextField(10); // Campo de texto ajustado
        JLabel label2 = new JLabel("Contraseña:");
        JPasswordField campo2 = new JPasswordField(10); // Campo de texto ajustado
        JButton botonFinalizar = new JButton("Acceder");
        botonFinalizar.setPreferredSize(new Dimension(80, 25)); // Tamaño ajustado
        botonFinalizar.setFont(new Font("Arial", Font.PLAIN, 12)); // Fuente más pequeña

        panelCampos.add(label1);
        panelCampos.add(campo1);
        panelCampos.add(label2);
        panelCampos.add(campo2);
        panelCampos.add(botonFinalizar);

        // Panel de Bienvenida
        JPanel panelBienvenida = new JPanel();
        panelBienvenida.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Layout compacto
        JLabel labelOrigen = new JLabel("Origen:");
        JComboBox<String> comboOrigen = new JComboBox<>(new String[]{"Nueva York", "Los Ángeles", "Miami"});
        JLabel labelDestino = new JLabel("Destino:");
        JComboBox<String> comboDestino = new JComboBox<>(new String[]{"Londres", "París", "Tokio"});
        JButton botonBuscarVuelos = new JButton("Buscar vuelos");
        botonBuscarVuelos.setPreferredSize(new Dimension(100, 25)); // Tamaño ajustado
        botonBuscarVuelos.setFont(new Font("Arial", Font.PLAIN, 12)); // Fuente más pequeña

        panelBienvenida.add(labelOrigen);
        panelBienvenida.add(comboOrigen);
        panelBienvenida.add(labelDestino);
        panelBienvenida.add(comboDestino);
        panelBienvenida.add(botonBuscarVuelos);

        ventana.add(panelInicial, "Panel Inicial");
        ventana.add(panelCampos, "Panel Campos");
        ventana.add(panelBienvenida, "Panel Bienvenida");

        CardLayout cl = (CardLayout) (ventana.getContentPane().getLayout());

        botonEmpezar.addActionListener(e -> cl.show(ventana.getContentPane(), "Panel Campos"));

        botonFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreUsuario = campo1.getText();
                String contrasena = new String(campo2.getPassword());
                if (validarCredenciales(nombreUsuario, contrasena)) {
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
                // Aquí podrías continuar con la lógica de búsqueda de vuelos
            }
        });

        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    private boolean validarCredenciales(String nombreUsuario, String contrasena) {
        // Lógica para validar credenciales
        return true; // Simulación
    }

    public static void main(String[] args) {
        new UI();
    }
}
