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
        ventana.setSize(600, 400);
        ventana.setLayout(new CardLayout());

        // Panel Inicial
        JPanel panelInicial = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel textoBienvenida = new JLabel("¡Bienvenido a FlyUS!", SwingConstants.CENTER);
        textoBienvenida.setFont(new Font("Arial", Font.BOLD, 16));
        JButton botonEmpezar = new JButton("Empezar");
        botonEmpezar.setPreferredSize(new Dimension(80, 25));
        botonEmpezar.setFont(new Font("Arial", Font.PLAIN, 12));

        panelInicial.add(textoBienvenida);
        panelInicial.add(botonEmpezar);

        // Panel de Login
        JPanel panelCampos = new JPanel();
        panelCampos.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JLabel label1 = new JLabel("Nombre:");
        JTextField campo1 = new JTextField(10);
        JLabel label2 = new JLabel("Contraseña:");
        JPasswordField campo2 = new JPasswordField(10);
        JButton botonFinalizar = new JButton("Acceder");
        botonFinalizar.setPreferredSize(new Dimension(80, 25));
        botonFinalizar.setFont(new Font("Arial", Font.PLAIN, 12));

        panelCampos.add(label1);
        panelCampos.add(campo1);
        panelCampos.add(label2);
        panelCampos.add(campo2);
        panelCampos.add(botonFinalizar);

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
                // Aquí podrías continuar con la lógica de búsqueda de vuelos
                abrirSeleccionDeAsientos(ventana, origenSeleccionado, destinoSeleccionado);
            }
        });

        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    private boolean validarCredenciales(String nombreUsuario, String contrasena) {
        return true; // Simulación
    }

    private void abrirSeleccionDeAsientos(JFrame ventana, String origen, String destino) {
        JFrame seleccionAsientosFrame = new JFrame("Seleccionar Asiento");
        seleccionAsientosFrame.setSize(300, 200);
        seleccionAsientosFrame.setLayout(new GridLayout(5, 5)); // Crear una cuadrícula para asientos

        for (int i = 1; i <= 25; i++) {
            JButton asiento = new JButton(String.valueOf(i));
            asiento.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(ventana, "Asiento " + asiento.getText() + " seleccionado.");
                    seleccionAsientosFrame.dispose();
                }
            });
            seleccionAsientosFrame.add(asiento);
        }

        seleccionAsientosFrame.setLocationRelativeTo(null);
        seleccionAsientosFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new UI();
    }
}
