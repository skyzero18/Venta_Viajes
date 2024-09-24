package pack;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class UI {
    private int idVuelo=-1;
    private int idAsiento=-1;

    public UI() {
        FlatDarkLaf.setup();
        JFrame ventana = new JFrame("FLY US");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setLayout(new CardLayout());


        CardLayout cl = (CardLayout) ventana.getContentPane().getLayout();

        // Panel Inicial
        JPanel panelInicial = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel textoBienvenida = new JLabel("¡Bienvenido a FlyUS!", SwingConstants.CENTER);
        textoBienvenida.setFont(new Font("Arial", Font.BOLD, 16));
        JButton botonEmpezar = new JButton("Empezar");
        JButton botonReg = new JButton("Registrarse");
        JButton botonPerf = new JButton("Perfil de usuario");
        JButton botonCs = new JButton("cerrar sesion");

        panelInicial.add(textoBienvenida);
        panelInicial.add(botonEmpezar);
        panelInicial.add(botonReg);
        panelInicial.add(botonPerf);
        panelInicial.add(botonCs);

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

        //Panel perfil


        JPanel panelPerfil = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 50));
        JLabel textoPerfil = new JLabel("Perfil", SwingConstants.CENTER);
        JLabel labelNombreUs = new JLabel("Nombre de usuario:");
        JLabel labelNombreUsvc = new JLabel("");
        JLabel labelNombre = new JLabel("Nombre:");
        JLabel labelNombrevc = new JLabel("");
        JLabel labelCorreo = new JLabel("Correo Electrónico:");
        JLabel labelCorreovc = new JLabel("");
        JLabel labelTelefono = new JLabel("Número de Teléfono:");
        JLabel labelTelefonovc = new JLabel("");
        JLabel labelReservastx = new JLabel("Reservas");
        JButton botonCanre = new JButton("cancelar reservas");
        botonCanre.setPreferredSize(new Dimension(175, 25));
        botonCanre.setFont(new Font("Arial", Font.PLAIN, 12));
        JButton botonVolPf = new JButton("Volver");
        botonVolPf.setPreferredSize(new Dimension(80, 25));
        botonVolPf.setFont(new Font("Arial", Font.PLAIN, 12));




        panelPerfil.add(textoPerfil);
        panelPerfil.add(labelNombreUs);
        panelPerfil.add(labelNombreUsvc);
        panelPerfil.add(labelCorreovc);
        panelPerfil.add(labelNombre);
        panelPerfil.add(labelNombrevc);
        panelPerfil.add(labelCorreo);
        panelPerfil.add(labelCorreovc);
        panelPerfil.add(labelTelefono);
        panelPerfil.add(labelTelefonovc);
        panelPerfil.add(labelReservastx);
        panelPerfil.add(botonCanre);
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
        panelFiltros.add(labelAer);
        panelFiltros.add(comboAer);
        panelFiltros.add(labelprecio);
        panelFiltros.add(comboprecio);
        panelFiltros.add(labelduracion);
        panelFiltros.add(comboduracion);
        panelFiltros.add(labelFechas);
        panelFiltros.add(campoFechas);
        panelFiltros.add(labelFechav);
        panelFiltros.add(campoFechav);

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

        //Panel asientos
        JPanel panelAsientos = new JPanel();
        panelAsientos.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Configurar FlowLayout con separación de 10px

        JLabel labelSelec = new JLabel("Seleccione su asiento");
        panelAsientos.add(labelSelec);




        // Panel de Pago
        JPanel panelPago = new JPanel(new BorderLayout());
        panelPago.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel labelNumeroTarjeta = new JLabel("Número de tarjeta:");
        JTextField campoNumeroTarjeta = new JTextField(15);
        JLabel labelNombreTitular = new JLabel("Nombre del titular:");
        JTextField campoNombreTitular = new JTextField(15);
        JLabel labelFechaExpiracion = new JLabel("Fecha de expiración (MM/YY):");
        JTextField campoFechaExpiracion = new JTextField(10);
        JLabel labelCVV = new JLabel("CVV:");
        JTextField campoCVV = new JTextField(4);
        JButton botonConfirmarPago = new JButton("Confirmar Pago");
        JButton botonVolPg = new JButton("Volver");

        panelPago.add(labelNumeroTarjeta);
        panelPago.add(campoNumeroTarjeta);
        panelPago.add(labelNombreTitular);
        panelPago.add(campoNombreTitular);
        panelPago.add(labelFechaExpiracion);
        panelPago.add(campoFechaExpiracion);
        panelPago.add(labelCVV);
        panelPago.add(campoCVV);
        panelPago.add(botonConfirmarPago);
        panelPago.add(botonVolPg);

        // Panel de Confirmación de Compra
        JPanel panelConfirmacion = new JPanel();
        JLabel textoConfirmacion = new JLabel("¡Compra realizada con éxito! Revisa tu correo electrónico para ver el recibo.");
        textoConfirmacion.setFont(new Font("Arial", Font.BOLD, 16));
        panelConfirmacion.add(textoConfirmacion);
        JButton botonVolverConfirmacion = new JButton("Volver");

        panelConfirmacion.add(botonVolverConfirmacion);


        // Añadir los paneles a la ventana
        ventana.add(panelInicial, "Panel Inicial");
        ventana.add(panelLogin, "Panel Login");
        ventana.add(panelBienvenida, "Panel Bienvenida");
        ventana.add(panelRegistro, "Panel Registro");
        ventana.add(panelPerfil, "Panel Perfil");
        ventana.add(panelAsientos, "Panel Asientos");
        ventana.add(panelPago,"Panel Pago");

        // Mostrar el panel inicial primero
        cl.show(ventana.getContentPane(), "Panel Inicial");

        // Acciones de los botones
        botonReg.addActionListener(e -> cl.show(ventana.getContentPane(), "Panel Registro"));
        botonVolR.addActionListener(e -> cl.show(ventana.getContentPane(), "Panel Inicial"));
        botonVolLg.addActionListener(e -> cl.show(ventana.getContentPane(), "Panel Inicial"));
        botonVolPf.addActionListener(e -> cl.show(ventana.getContentPane(), "Panel Inicial"));
        botonVolPg.addActionListener(e -> cl.show(ventana.getContentPane(), "Panel Asientos"));




        // Consultar si hay usuarios activos
        Integer hayUsuariosActivos = Usuario.consultarUsuariosActivos();
        if (hayUsuariosActivos == null) {
            botonCs.setVisible(false);
            botonPerf.setVisible(false);
            botonEmpezar.addActionListener(e -> cl.show(ventana.getContentPane(), "Panel Login"));
        } else {
            botonCs.setVisible(true);
            botonEmpezar.addActionListener(e -> cl.show(ventana.getContentPane(), "Panel Bienvenida"));
            Vuelo vuelo = new Vuelo();
            List<Vuelo> listaVuelos = vuelo.busquedaentera();
            model.setRowCount(0);

            for (Vuelo v : listaVuelos) {
                model.addRow(new Object[]{false, v.getOrigen(), v.getDestino(), v.getFechaIda(), v.getFechaVuelta(),v.getAerolinea(), v.getPrecio(), v.getDuracion()});
            }
        }


        botonAcceder.addActionListener(e -> {
            String email = campoEmailLogin.getText();
            String contrasena = new String(campoContrasenaLogin.getPassword());
            Usuario usuario = new Usuario(); // Instanciar la clase Usuario
            if (usuario.validarCredenciales(email, contrasena)) {
                JOptionPane.showMessageDialog(ventana, "Acceso concedido.");
                Vuelo vuelo = new Vuelo();
                List<Vuelo> listaVuelos = vuelo.busquedaentera();
                model.setRowCount(0);

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

        botonAceptar.addActionListener(e -> {
            for (int i = 0; i < tablaVuelos.getRowCount(); i++) {
                if ((Boolean) tablaVuelos.getValueAt(i, 0)) {
                    // Obtener datos del vuelo seleccionado
                    String origen = (String) tablaVuelos.getValueAt(i, 1);
                    String destino = (String) tablaVuelos.getValueAt(i, 2);
                    // Aquí puedes trabajar con los datos seleccionados antes de cambiar de panel
                    System.out.println("Vuelo seleccionado de " + origen + " a " + destino);
                }
            }

            // Cambiar al panel inicial
            cl.show(ventana.getContentPane(), "Panel Inicial");
        });

        botonCs.addActionListener(e -> {
            Usuario.cerrarSesion();
            botonCs.setVisible(false);
            botonPerf.setVisible(false);
            JOptionPane.showMessageDialog(ventana, "Sesion cerrada");
        });


        tablaVuelos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tablaVuelos.rowAtPoint(e.getPoint());
                String origen = tablaVuelos.getValueAt(row, 1).toString();
                String destino = tablaVuelos.getValueAt(row, 2).toString();
                String fechaIda = tablaVuelos.getValueAt(row, 3).toString();
                String fechaVuelta = tablaVuelos.getValueAt(row, 4).toString();
                String aerolinea = tablaVuelos.getValueAt(row, 5).toString();

                Vuelo vuelo = new Vuelo();
                idVuelo = vuelo.obtenerIdVuelo(origen, destino, fechaIda, fechaVuelta, aerolinea);

                System.out.println("ID del vuelo: " + idVuelo);
            }
        });


        char letra = 'A';
        for (int i = 0; i < 25; i++) {
            int numero = (i % 5) + 1;
            JButton botonAsiento = new JButton(letra + "" + numero); // Ejemplo: A1, A2, A3, etc.
            panelAsientos.add(botonAsiento);
            botonAsiento.addActionListener(e -> {
                String asientoSeleccionado = botonAsiento.getText();
                Vuelo vuelo = new Vuelo();
                idAsiento = vuelo.obtenerIdAsiento(asientoSeleccionado);
                if (idAsiento != -1) {
                    System.out.println("Asiento seleccionado: " + asientoSeleccionado + " con ID: " + idAsiento);
                    System.out.println("Vuelo " + idVuelo);
                    System.out.println("id usuario "+ hayUsuariosActivos);
                    cl.show(ventana.getContentPane(), "Panel Pago");
                } else {
                    System.out.println("Asiento no encontrado para: " + asientoSeleccionado);
                }
            });
            if ((i + 1) % 5 == 0) {
                letra++;
            }
        }


        botonConfirmarPago.addActionListener(e -> {
            String titular = campoNombreTitular.getText();
            Usuario usuario = new Usuario();
            Vuelo vuelo = new Vuelo();
            boolean confasien = vuelo.consultarAsientoOcupado(idVuelo, idAsiento );
            if (confasien) {
              JOptionPane.showMessageDialog(ventana,"Error: El asiento elegido esta ocupado");
            }
            else {
                JOptionPane.showMessageDialog(ventana, "Vuelo adquirido, Hemos enviado un comprobante de pago a su correo");
                usuario.pagofin(idAsiento, hayUsuariosActivos,titular);
            }


        });

        botonPerf.addActionListener(e -> {
            cl.show(ventana.getContentPane(), "Panel Perfil");

            int idUsuarioActivo = hayUsuariosActivos;

            Pasajero pasajero = new Pasajero();
            pasajero.actualizarDatos(idUsuarioActivo);

            // Obtener los datos actualizados del pasajero
            String nombreusvc = pasajero.getNombre();
            String nombrevc = pasajero.getNombrefin();
            String correovc = pasajero.getCorreo();
            String telefonovc = pasajero.getTelefono();

            labelNombreUsvc.setText(nombreusvc);
            labelNombrevc.setText(nombrevc);
            labelCorreovc.setText(correovc);
            labelTelefonovc.setText(telefonovc);
        });

        botonCanre.addActionListener(e -> {
            JOptionPane.showMessageDialog(ventana, "Cancelando todas sus reservas");
            Pasajero pasajero = new Pasajero();
            pasajero.obtenerDatos(hayUsuariosActivos);

        });




        ventana.setVisible(true);
    }
}
