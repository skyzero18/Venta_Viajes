package pack;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class UI {
    public UI() {
        JFrame ventana = new JFrame("FLY US");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 600); // Ventana más grande para acomodar todo
        ventana.setLayout(new CardLayout()); // Configuración de CardLayout

        CardLayout cl = (CardLayout) ventana.getContentPane().getLayout();

        // Panel Inicial
        JPanel panelInicial = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel textoBienvenida = new JLabel("¡Bienvenido a FlyUS!", SwingConstants.CENTER);
        textoBienvenida.setFont(new Font("Arial", Font.BOLD, 16));
        JButton botonEmpezar = new JButton("Empezar");
        JButton botonReg = new JButton("Registrarse");
        JButton botonPerf = new JButton("Perfil de usuario");

        panelInicial.add(textoBienvenida);
        panelInicial.add(botonEmpezar);
        panelInicial.add(botonReg);
        panelInicial.add(botonPerf);

        // Panel de Login
        JPanel panelLogin = new JPanel();
        panelLogin.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JLabel labelEmailLogin = new JLabel("Email:");
        JTextField campoEmailLogin = new JTextField(10);
        JLabel labelContrasenaLogin = new JLabel("Contraseña:");
        JPasswordField campoContrasenaLogin = new JPasswordField(10);
        JButton botonAcceder = new JButton("Acceder");
        JButton botonVolLg = new JButton("Volver");

        panelLogin.add(labelEmailLogin);
        panelLogin.add(campoEmailLogin);
        panelLogin.add(labelContrasenaLogin);
        panelLogin.add(campoContrasenaLogin);
        panelLogin.add(botonAcceder);
        panelLogin.add(botonVolLg);

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
        JButton botonVolR = new JButton("volver");

        panelRegistro.add(labelUsuarioReg);
        panelRegistro.add(campoUsuarioReg);
        panelRegistro.add(labelContrasenaReg);
        panelRegistro.add(campoContrasenaReg);
        panelRegistro.add(labelTelReg);
        panelRegistro.add(campoTelReg);
        panelRegistro.add(labelCorreoReg);
        panelRegistro.add(campoCorreoReg);
        panelRegistro.add(botonRegistro);
        panelRegistro.add(botonVolR);

        // Panel de Perfil
        JPanel panelPerfil = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel textoPerfil = new JLabel("Perfil", SwingConstants.CENTER);
        textoPerfil.setFont(new Font("Arial", Font.BOLD, 16));
        JButton botonVolPf = new JButton("Volver");

        panelPerfil.add(textoPerfil);
        panelPerfil.add(botonVolPf);

        // Panel de Bienvenida con el formulario y la tabla
        JPanel panelBienvenida = new JPanel();
        panelBienvenida.setLayout(new BorderLayout());

        JPanel panelFiltros = new JPanel();
        panelFiltros.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JLabel labelOrigen = new JLabel("Origen:");
        JComboBox<String> comboOrigen = new JComboBox<>(new String[]{"Mendoza", "San Luis", "San Juan"});
        JLabel labelDestino = new JLabel("Destino:");
        JComboBox<String> comboDestino = new JComboBox<>(new String[]{"Londres", "París", "Tokio"});
        JLabel labelFechas = new JLabel("Fecha de ida");
        JTextField campoFechas = new JTextField(10);
        campoFechas.setText("yyyy-mm-dd");
        JLabel labelFechav = new JLabel("Fecha de vuelta");
        JTextField campoFechav = new JTextField(10);
        campoFechav.setText("yyyy-mm-dd"); // Valor inicia
        JButton botonBuscarVuelos = new JButton("Buscar vuelos");
        JLabel labelAer = new JLabel("Empresa:");
        JComboBox<String> comboAer = new JComboBox<>(new String[]{"Aerolineas Argentinas", "Flybondi", "JetSMART"});
        JLabel labelprecio = new JLabel("Precio:");
        JComboBox<String> comboprecio = new JComboBox<>(new String[]{"800", "800", "800"});
        JLabel labelduracion = new JLabel("Duracion:");
        JComboBox<String> comboduracion = new JComboBox<>(new String[]{"12", "12", "12"});



        panelFiltros.add(labelOrigen);
        panelFiltros.add(comboOrigen);
        panelFiltros.add(labelDestino);
        panelFiltros.add(comboDestino);
        panelFiltros.add(labelFechas);
        panelFiltros.add(campoFechas);
        panelFiltros.add(labelFechav);
        panelFiltros.add(campoFechav);
        panelFiltros.add(labelAer);
        panelFiltros.add(comboAer);
        panelFiltros.add(labelprecio);
        panelFiltros.add(comboprecio);
        panelFiltros.add(labelduracion);
        panelFiltros.add(comboduracion);

        panelFiltros.add(botonBuscarVuelos);

        // Panel de Resultados de Búsqueda (Tabla dentro del mismo panel)
        JPanel panelResultados = new JPanel(new BorderLayout());
        String[] columnNames = {"Seleccionar", "Origen", "Destino", "Fecha de ida", "Fecha de vuelta","Aerolinea","Precio","Duracion"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable tablaVuelos = new JTable(model);
        tablaVuelos.setPreferredScrollableViewportSize(new Dimension(500, 200));
        tablaVuelos.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(tablaVuelos);
        panelResultados.add(scrollPane, BorderLayout.CENTER);

        JButton botonAceptar = new JButton("Aceptar");
        botonAceptar.setEnabled(false); // Inicialmente deshabilitado
        panelResultados.add(botonAceptar, BorderLayout.SOUTH);

        // Añadir panelFiltros y panelResultados al panel principal
        panelBienvenida.add(panelFiltros, BorderLayout.NORTH);
        panelBienvenida.add(panelResultados, BorderLayout.CENTER);


        // Añadir los paneles a la ventana
        ventana.add(panelInicial, "Panel Inicial");
        ventana.add(panelLogin, "Panel Login");
        ventana.add(panelBienvenida, "Panel Bienvenida");
        ventana.add(panelRegistro, "Panel Registro");
        ventana.add(panelPerfil, "Panel Perfil");

        // Mostrar el panel inicial primero
        cl.show(ventana.getContentPane(), "Panel Inicial");

        // Acciones de los botones
        botonEmpezar.addActionListener(e -> cl.show(ventana.getContentPane(), "Panel Login"));
        botonReg.addActionListener(e -> cl.show(ventana.getContentPane(), "Panel Registro"));
        botonPerf.addActionListener(e -> cl.show(ventana.getContentPane(), "Panel Perfil"));
        botonVolR.addActionListener(e -> cl.show(ventana.getContentPane(), "Panel Inicial"));
        botonVolLg.addActionListener(e -> cl.show(ventana.getContentPane(), "Panel Inicial"));
        botonVolPf.addActionListener(e -> cl.show(ventana.getContentPane(), "Panel Inicial"));

        botonAcceder.addActionListener(e -> {
            String email = campoEmailLogin.getText();
            String contrasena = new String(campoContrasenaLogin.getPassword());
            Usuario usuario = new Usuario(); // Instanciar la clase Usuario
            if (usuario.validarCredenciales(email, contrasena)) {
                JOptionPane.showMessageDialog(ventana, "Acceso concedido.");

                // Llamada a la función busquedaentera
                Vuelo vuelo = new Vuelo();
                List<Vuelo> listaVuelos = vuelo.busquedaentera();

                // Limpiar la tabla antes de agregar nuevos resultados
                model.setRowCount(0);

                // Recorrer la lista de vuelos obtenidos y agregarlos a la tabla
                for (Vuelo v : listaVuelos) {
                    model.addRow(new Object[]{false, v.getOrigen(), v.getDestino(), v.getFechaIda(), v.getFechaVuelta(),v.getAerolinea(), v.getPrecio(), v.getDuracion()});
                }

                cl.show(ventana.getContentPane(), "Panel Bienvenida");
            } else {
                JOptionPane.showMessageDialog(ventana, "Usuario o contraseña incorrectos.");
            }
        });


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

        botonBuscarVuelos.addActionListener(e -> {
            String origenSeleccionado = (String) comboOrigen.getSelectedItem();
            String destinoSeleccionado = (String) comboDestino.getSelectedItem();
            String fechaSeleccionada = campoFechas.getText();
            String fechavSeleccionada = campoFechav.getText();
            String aereolienaSeleccionada = (String) comboAer.getSelectedItem();
            String precioSeleccionada = (String) comboprecio.getSelectedItem();
            String duracionSeleccionada = (String) comboduracion.getSelectedItem();

            Vuelo vuelo = new Vuelo();
            List<Vuelo> vuelos = vuelo.consultarVuelos(origenSeleccionado, destinoSeleccionado, fechaSeleccionada, fechavSeleccionada, aereolienaSeleccionada, precioSeleccionada, duracionSeleccionada);

            // Limpiar la tabla antes de agregar nuevos resultados
            model.setRowCount(0);

            // Recorrer la lista de vuelos obtenidos y agregarlos a la tabla
            for (Vuelo v : vuelos) {
                model.addRow(new Object[]{false, v.getOrigen(), v.getDestino(), v.getFechaIda(), v.getFechaVuelta(),v.getAerolinea(),v.getPrecio(), v.getDuracion()});
            }
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

        ventana.setVisible(true);
    }

    public static void main(String[] args) {
        new UI();
    }
}
