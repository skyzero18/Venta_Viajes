package pack;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
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
        JLabel labelEmailLogin = new JLabel("Email:");
        JTextField campoEmailLogin = new JTextField(10);
        JLabel labelContrasenaLogin = new JLabel("Contraseña:");
        JPasswordField campoContrasenaLogin = new JPasswordField(10);
        JButton botonAcceder = new JButton("Acceder");
        botonAcceder.setPreferredSize(new Dimension(80, 25));
        botonAcceder.setFont(new Font("Arial", Font.PLAIN, 12));

        panelLogin.add(labelEmailLogin);
        panelLogin.add(campoEmailLogin);
        panelLogin.add(labelContrasenaLogin);
        panelLogin.add(campoContrasenaLogin);
        panelLogin.add(botonAcceder);

        // Panel de Bienvenida
        JPanel panelBienvenida = new JPanel();
        panelBienvenida.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel labelOrigen = new JLabel("Origen:");
        JComboBox<String> comboOrigen = new JComboBox<>(new String[]{"Mendoza", "San Luis", "San Juan"});
        JLabel labelDestino = new JLabel("Destino:");
        JComboBox<String> comboDestino = new JComboBox<>(new String[]{"Londres", "París", "Tokio"});
        JLabel labelFechas = new JLabel("Fecha de ida");
        JTextField campoFechas = new JTextField(10);
        campoFechas.setText("yyyy-mm-dd");
        JLabel labelFechav = new JLabel("Fecha de vuelta");
        JTextField campoFechav = new JTextField(10);
        campoFechav.setText("yyyy-mm-dd"); // Valor inicial
        JLabel labelPasajeros = new JLabel("Número de pasajeros:");
        JComboBox<String> comboPasajeros = new JComboBox<>(new String[]{"1", "2", "3", "4", "5", "6"});
        JButton botonBuscarVuelos = new JButton("Buscar vuelos");
        botonBuscarVuelos.setPreferredSize(new Dimension(120, 25));
        botonBuscarVuelos.setFont(new Font("Arial", Font.PLAIN, 12));

        panelBienvenida.add(labelOrigen);
        panelBienvenida.add(comboOrigen);
        panelBienvenida.add(labelDestino);
        panelBienvenida.add(comboDestino);
        panelBienvenida.add(labelFechas);
        panelBienvenida.add(campoFechas);
        panelBienvenida.add(labelFechav);
        panelBienvenida.add(campoFechav);
        panelBienvenida.add(labelPasajeros);
        panelBienvenida.add(comboPasajeros);
        panelBienvenida.add(botonBuscarVuelos);

        // Panel de Registro
        JPanel panelRegistro = new JPanel();
        panelRegistro.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel labelUsuarioReg = new JLabel("Nombre de Usuario:");
        JTextField campoUsuarioReg = new JTextField(15);
        JLabel labelContrasenaReg = new JLabel("Contraseña:");
        JTextField campoTelReg = new JTextField(15);
        JLabel labelTelReg = new JLabel("Telefono:");
        JTextField campoCorreoReg = new JTextField(15);
        JLabel labelCorreoReg = new JLabel("Correo:");
        JPasswordField campoContrasenaReg = new JPasswordField(15);
        JButton botonRegistro = new JButton("Registrar");
        botonRegistro.setPreferredSize(new Dimension(100, 25));
        botonRegistro.setFont(new Font("Arial", Font.PLAIN, 12));

        panelRegistro.add(labelUsuarioReg);
        panelRegistro.add(campoUsuarioReg);
        panelRegistro.add(labelContrasenaReg);
        panelRegistro.add(campoContrasenaReg);
        panelRegistro.add(labelTelReg);
        panelRegistro.add(campoTelReg);
        panelRegistro.add(labelCorreoReg);
        panelRegistro.add(campoCorreoReg);
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

        // Panel de Resultados de Búsqueda
        JPanel panelResultados = new JPanel(new BorderLayout());
        String[] columnNames = {"Seleccionar", "Aerolínea", "Horario", "Duración", "Precio"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable tablaVuelos = new JTable(model);
        tablaVuelos.setPreferredScrollableViewportSize(new Dimension(500, 200));
        tablaVuelos.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(tablaVuelos);
        panelResultados.add(scrollPane, BorderLayout.CENTER);

        JButton botonAceptar = new JButton("Aceptar");
        botonAceptar.setEnabled(false); // Inicialmente deshabilitado
        panelResultados.add(botonAceptar, BorderLayout.SOUTH);

        // Añadir los paneles a la ventana
        ventana.add(panelInicial, "Panel Inicial");
        ventana.add(panelLogin, "Panel Login");
        ventana.add(panelBienvenida, "Panel Bienvenida");
        ventana.add(panelAsientos, "Panel Asientos");
        ventana.add(panelRegistro, "Panel Registro");
        ventana.add(panelResultados, "Panel Resultados");

        // Mostrar el panel inicial primero
        cl.show(ventana.getContentPane(), "Panel Inicial");

        botonEmpezar.addActionListener(e -> cl.show(ventana.getContentPane(), "Panel Login"));
        botonReg.addActionListener(e -> cl.show(ventana.getContentPane(), "Panel Registro"));

        botonRegistro.addActionListener(e -> {
            String nombreUsuario = campoUsuarioReg.getText();
            String contrasena = campoContrasenaReg.getText();
            String telefono = campoTelReg.getText();
            String email = campoCorreoReg.getText();
            Usuario usuario = new Usuario();
            if (usuario.insertarUsuario(nombreUsuario, contrasena, email, telefono)) {
                JOptionPane.showMessageDialog(ventana, "Registro exitoso.");
            } else {
                JOptionPane.showMessageDialog(ventana, "Error en el registro. Por favor, revisa los datos.");
            }
        });



        botonAcceder.addActionListener(e -> {
            String email = campoEmailLogin.getText();
            String contrasena = new String(campoContrasenaLogin.getPassword());
            Usuario usuario = new Usuario(); // Instanciar la clase Usuario
            if (usuario.validarCredenciales(email, contrasena)) {
                JOptionPane.showMessageDialog(ventana, "Acceso concedido.");
                cl.show(ventana.getContentPane(), "Panel Bienvenida");
            } else {
                JOptionPane.showMessageDialog(ventana, "Usuario o contraseña incorrectos.");
            }
        });

        botonBuscarVuelos.addActionListener(e -> {
            String origenSeleccionado = (String) comboOrigen.getSelectedItem();
            String destinoSeleccionado = (String) comboDestino.getSelectedItem();
            String fechaSeleccionada = campoFechas.getText();
            String fechavSeleccionada = campoFechav.getText();

            Vuelo vuelo = new Vuelo();
            vuelo.consultarVuelos(origenSeleccionado, destinoSeleccionado, fechaSeleccionada, fechavSeleccionada);

            // Limpiar la tabla antes de agregar nuevos resultados
            model.setRowCount(0);

            // Agregar resultados de ejemplo
            model.addRow(new Object[]{false, "Aerolínea 1", "10:00", "2h", "$200"});
            model.addRow(new Object[]{false, "Aerolínea 2", "14:00", "3h", "$250"});
            model.addRow(new Object[]{false, "Aerolínea 3", "18:00", "1h 30m", "$180"});

            cl.show(ventana.getContentPane(), "Panel Resultados");
        });


        tablaVuelos.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JCheckBox checkBox = new JCheckBox();
                checkBox.setSelected((Boolean) value);
                return checkBox;
            }
        });

        tablaVuelos.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));

        // Acción para habilitar el botón Aceptar solo si hay una sola casilla marcada
        tablaVuelos.getModel().addTableModelListener(e -> {
            int selectedCount = 0;
            for (int i = 0; i < tablaVuelos.getRowCount(); i++) {
                if ((Boolean) tablaVuelos.getValueAt(i, 0)) {
                    selectedCount++;
                }
            }
            botonAceptar.setEnabled(selectedCount == 1);
        });

        botonAceptar.addActionListener(e -> cl.show(ventana.getContentPane(), "Panel Asientos"));

        ventana.setVisible(true);
    }

    public static void main(String[] args) {
        new UI();
    }
}
