package pack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
    private Usuario usuario = new Usuario(); // Instanciar la clase Usuario para validar credenciales

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
        JButton botonReg = new JButton("Registrarse");
        botonReg.setPreferredSize(new Dimension(80, 25));
        botonEmpezar.setFont(new Font("Arial", Font.PLAIN, 12)); // Fuente más pequeña

        panelInicial.add(textoBienvenida);
        panelInicial.add(botonEmpezar);
        panelInicial.add(botonReg);

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

        // Panel de Registro
        JPanel panelRegistro = new JPanel();
        panelRegistro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5)); // Layout compacto
        JLabel labelNombre = new JLabel("Nombre:");
        JTextField campoNombre = new JTextField(10); // Campo de texto ajustado
        JLabel labelEmail = new JLabel("Email:");
        JTextField campoEmail = new JTextField(10); // Campo de texto ajustado
        JLabel labelContrasena = new JLabel("Contraseña:");
        JPasswordField campoContrasena = new JPasswordField(10); // Campo de texto ajustado
        JButton botonRegistrar = new JButton("Registrar");
        botonRegistrar.setPreferredSize(new Dimension(80, 25)); // Tamaño ajustado
        botonRegistrar.setFont(new Font("Arial", Font.PLAIN, 12)); // Fuente más pequeña

        panelRegistro.add(labelNombre);
        panelRegistro.add(campoNombre);
        panelRegistro.add(labelEmail);
        panelRegistro.add(campoEmail);
        panelRegistro.add(labelContrasena);
        panelRegistro.add(campoContrasena);
        panelRegistro.add(botonRegistrar);

        // Panel de Selección de Destino
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

        // Panel de Selección de Método de Pago
        JPanel panelPago = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel labelPago = new JLabel("Selecciona método de pago:");
        JComboBox<String> comboMetodoPago = new JComboBox<>(new String[]{"Tarjeta de Crédito", "PayPal", "Transferencia Bancaria"});
        JButton botonConfirmarPago = new JButton("Confirmar Pago");
        botonConfirmarPago.setPreferredSize(new Dimension(120, 25)); // Tamaño ajustado
        botonConfirmarPago.setFont(new Font("Arial", Font.PLAIN, 12)); // Fuente más pequeña

        panelPago.add(labelPago);
        panelPago.add(comboMetodoPago);
        panelPago.add(botonConfirmarPago);

        ventana.add(panelInicial, "Panel Inicial");
        ventana.add(panelCampos, "Panel Campos");
        ventana.add(panelBienvenida, "Panel Bienvenida");
        ventana.add(panelPago, "Panel Pago");
        ventana.add(panelRegistro, "Panel Registro");

        CardLayout cl = (CardLayout) (ventana.getContentPane().getLayout());

        botonEmpezar.addActionListener(e -> cl.show(ventana.getContentPane(), "Panel Campos"));
        botonReg.addActionListener(e -> cl.show(ventana.getContentPane(), "Panel Registro"));

        botonFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreUsuario = campo1.getText();
                String contrasena = new String(campo2.getPassword());
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
                JOptionPane.showMessageDialog(ventana, "Vuelos disponibles desde " + origenSeleccionado + " hacia " + destinoSeleccionado);
                cl.show(ventana.getContentPane(), "Panel Pago");
            }
        });

        botonConfirmarPago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String metodoPagoSeleccionado = (String) comboMetodoPago.getSelectedItem();
                JOptionPane.showMessageDialog(ventana, "Pago confirmado con " + metodoPagoSeleccionado);
                // Aquí puedes añadir lógica para procesar el pago
            }
        });
        botonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = campoNombre.getText();
                String email = campoEmail.getText();
                String contrasena = new String(campoContrasena.getPassword());

                boolean resultado = usuario.insertarUsuario(nombre, contrasena, email);

                if (resultado) {
                    JOptionPane.showMessageDialog(ventana, "Usuario registrado con éxito.");
                    cl.show(ventana.getContentPane(), "Panel Campos");
                } else {
                    JOptionPane.showMessageDialog(ventana, "Error al registrar el usuario.");
                }
            }
        });


        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }


}
