package pack;
import net.miginfocom.swing.MigLayout;
import com.formdev.flatlaf.FlatDarkLaf;
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
        Font fuenteGrande = new Font("Arial", Font.PLAIN, 30);
        int widthvr= 75;
        int heightvr= 20;

        JPanel panelInicial = new JPanel(new MigLayout("wrap 1", "[center]", "[]10[]"));
        JLabel textoBienvenida = new JLabel("¡Bienvenido a FlyUS!", SwingConstants.CENTER) {{setFont(fuenteGrande);}};
        JButton botonEmpezar = new JButton("Empezar"){{setFont(fuenteGrande);setPreferredSize(new Dimension(widthvr, heightvr));}};
        JButton botonReg = new JButton("Registrarse"){{setFont(fuenteGrande);setPreferredSize(new Dimension(widthvr, heightvr));}};
        JButton botonPerf = new JButton("Perfil de usuario"){{setFont(fuenteGrande);setPreferredSize(new Dimension(widthvr, heightvr));}};
        JButton botonCs = new JButton("Cerrar Sesión"){{setFont(fuenteGrande);setPreferredSize(new Dimension(widthvr, heightvr));}};

        panelInicial.add(textoBienvenida, "span, grow, align center");
        panelInicial.add(botonEmpezar, "grow");
        panelInicial.add(botonReg, "grow");
        panelInicial.add(botonPerf, "grow");
        panelInicial.add(botonCs, "grow");


        // Panel de Login
        JPanel panelLogin = new JPanel(new MigLayout("wrap 1", "[center]", "[]10[]"));
        JLabel labelEmailLogin = new JLabel("Email:") {{setFont(fuenteGrande);}};
        JTextField campoEmailLogin = new JTextField(10) {{setFont(fuenteGrande);setPreferredSize(new Dimension(widthvr, heightvr));}};
        JLabel labelContrasenaLogin = new JLabel("Contraseña:") {{setFont(fuenteGrande);}};
        JPasswordField campoContrasenaLogin = new JPasswordField(10) {{setFont(fuenteGrande);setPreferredSize(new Dimension(widthvr, heightvr));}};
        JButton botonAcceder = new JButton("Acceder") {{setFont(fuenteGrande);setPreferredSize(new Dimension(widthvr, heightvr));}};
        JButton botonVolLg = new JButton("Volver") {{setFont(fuenteGrande);setPreferredSize(new Dimension(widthvr, heightvr));}};

        // Añadir los componentes al panel
        panelLogin.add(labelEmailLogin, "span, grow, align center");
        panelLogin.add(campoEmailLogin, "grow");
        panelLogin.add(labelContrasenaLogin, "grow");
        panelLogin.add(campoContrasenaLogin, "grow");
        panelLogin.add(botonAcceder, "grow");
        panelLogin.add(botonVolLg, "grow");

        // Panel de Registro
        JPanel panelRegistro = new JPanel(new MigLayout("wrap 1", "[center]", "[]10[]"));
        JLabel labelUsuarioReg = new JLabel("Nombre de Usuario:") {{setFont(fuenteGrande);}};
        JTextField campoUsuarioReg = new JTextField(15) {{setFont(fuenteGrande);setPreferredSize(new Dimension(widthvr, heightvr));}};
        JLabel labelContrasenaReg = new JLabel("Contraseña:") {{setFont(fuenteGrande);}};
        JPasswordField campoContrasenaReg = new JPasswordField(15) {{setFont(fuenteGrande);setPreferredSize(new Dimension(widthvr, heightvr));}};
        JLabel labelTelReg = new JLabel("Teléfono:") {{setFont(fuenteGrande);}};
        JTextField campoTelReg = new JTextField(15) {{setFont(fuenteGrande);setPreferredSize(new Dimension(widthvr, heightvr));}};
        JLabel labelCorreoReg = new JLabel("Correo:") {{setFont(fuenteGrande);}};
        JTextField campoCorreoReg = new JTextField(15) {{setFont(fuenteGrande);setPreferredSize(new Dimension(widthvr, heightvr));}};
        JButton botonRegistro = new JButton("Registrar") {{setFont(fuenteGrande);setPreferredSize(new Dimension(widthvr, heightvr));}};
        JButton botonVolR = new JButton("Volver") {{setFont(fuenteGrande);setPreferredSize(new Dimension(widthvr, heightvr));}};

        // Añadir los componentes al panel
        panelRegistro.add(labelUsuarioReg, "align center");
        panelRegistro.add(campoUsuarioReg, "grow");
        panelRegistro.add(labelContrasenaReg, "align center");
        panelRegistro.add(campoContrasenaReg, "grow");
        panelRegistro.add(labelTelReg, "align center");
        panelRegistro.add(campoTelReg, "grow");
        panelRegistro.add(labelCorreoReg, "align center");
        panelRegistro.add(campoCorreoReg, "grow");
        panelRegistro.add(botonRegistro, "grow");
        panelRegistro.add(botonVolR, "grow");

        // Panel perfil con MigLayout
        JPanel panelPerfil = new JPanel(new MigLayout("wrap 1", "[center]", "[]10[]")); // Usando MigLayout
        JLabel textoPerfil = new JLabel("Perfil", SwingConstants.CENTER){{setFont(fuenteGrande);}};
        JLabel labelNombreUs = new JLabel("Nombre de usuario:"){{setFont(fuenteGrande);}};
        JLabel labelNombreUsvc = new JLabel(""){{setFont(fuenteGrande);}};
        JLabel labelNombre = new JLabel("Nombre:"){{setFont(fuenteGrande);}};
        JLabel labelNombrevc = new JLabel(""){{setFont(fuenteGrande);}};
        JLabel labelCorreo = new JLabel("Correo Electrónico:"){{setFont(fuenteGrande);}};
        JLabel labelCorreovc = new JLabel(""){{setFont(fuenteGrande);}};
        JLabel labelTelefono = new JLabel("Número de Teléfono:"){{setFont(fuenteGrande);}};
        JLabel labelTelefonovc = new JLabel(""){{setFont(fuenteGrande);}};
        JButton botonCanre = new JButton("Cancelar reservas"){{setFont(fuenteGrande);setPreferredSize(new Dimension(widthvr, heightvr));}};
        JButton botonVolPf = new JButton("Volver"){{setFont(fuenteGrande);setPreferredSize(new Dimension(widthvr, heightvr));}};


        panelPerfil.add(textoPerfil, "span, grow, align center");
        panelPerfil.add(labelNombreUs, "split 2");
        panelPerfil.add(labelNombreUsvc, "grow");
        panelPerfil.add(labelNombre, "split 2");
        panelPerfil.add(labelNombrevc, "grow");
        panelPerfil.add(labelCorreo, "split 2");
        panelPerfil.add(labelCorreovc, "grow");
        panelPerfil.add(labelTelefono, "split 2");
        panelPerfil.add(labelTelefonovc, "grow");
        panelPerfil.add(botonCanre, "grow");
        panelPerfil.add(botonVolPf, "grow");


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
        JLabel labelprecio = new JLabel("Precio (dolares):");
        JComboBox<String> comboprecio = new JComboBox<>(new String[]{"800", "800", "800"});
        JLabel labelduracion = new JLabel("Duracion (horas):");
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




        // Panel de Pago utilizando MigLayout
        JPanel panelPago = new JPanel(new MigLayout("wrap 1", "[left][grow]")); // Dos columnas, la primera alineada a la derecha
        JLabel labelNumeroTarjeta = new JLabel("Número de tarjeta:"){{setFont(fuenteGrande);}};
        JTextField campoNumeroTarjeta = new JTextField(15){{setFont(fuenteGrande);setPreferredSize(new Dimension(widthvr, heightvr));}};
        JLabel labelNombreTitular = new JLabel("Nombre del titular:"){{setFont(fuenteGrande);}};
        JTextField campoNombreTitular = new JTextField(15){{setFont(fuenteGrande);setPreferredSize(new Dimension(widthvr, heightvr));}};
        JLabel labelFechaExpiracion = new JLabel("Fecha de expiración (MM/YY):"){{setFont(fuenteGrande);}};
        JTextField campoFechaExpiracion = new JTextField(15){{setFont(fuenteGrande);setPreferredSize(new Dimension(widthvr, heightvr));}};
        JLabel labelCVV = new JLabel("CVV:"){{setFont(fuenteGrande);}};
        JTextField campoCVV = new JTextField(4){{setFont(fuenteGrande);setPreferredSize(new Dimension(widthvr, heightvr));}};
        JButton botonConfirmarPago = new JButton("Confirmar Pago"){{setFont(fuenteGrande);setPreferredSize(new Dimension(widthvr, heightvr));}};
        JButton botonVolPg = new JButton("Volver"){{setFont(fuenteGrande);setPreferredSize(new Dimension(widthvr, heightvr));}};


        panelPago.add(labelNumeroTarjeta,"span, align center");
        panelPago.add(campoNumeroTarjeta,"align center");
        panelPago.add(labelNombreTitular,"align center");
        panelPago.add(campoNombreTitular,"align center");
        panelPago.add(labelFechaExpiracion,"align center");
        panelPago.add(campoFechaExpiracion,"align center");
        panelPago.add(labelCVV,"align center");
        panelPago.add(campoCVV,"align center");
        panelPago.add(botonConfirmarPago, "grow");
        panelPago.add(botonVolPg, "grow");


        // Panel de Confirmación de Compra
        JPanel panelConfirmacion = new JPanel();
        JLabel textoConfirmacion = new JLabel("¡Compra realizada con éxito! Revisa tu correo electrónico para ver el recibo.");
        textoConfirmacion.setFont(new Font("Arial", Font.BOLD, 16));
        panelConfirmacion.add(textoConfirmacion);
        JButton botonVolverConfirmacion = new JButton("Volver");

        panelConfirmacion.add(botonVolverConfirmacion);

        JPanel panelCentradopi = new JPanel(new GridBagLayout());
        GridBagConstraints gbcpi = new GridBagConstraints();
        gbcpi.anchor = GridBagConstraints.CENTER;
        panelCentradopi.add(panelInicial, gbcpi);

        JPanel panelCentradopa = new JPanel(new GridBagLayout());
        GridBagConstraints gbcpa = new GridBagConstraints();
        gbcpa.anchor = GridBagConstraints.CENTER;
        panelCentradopa.add(panelPago, gbcpa);


        JPanel panelCentradopf = new JPanel(new GridBagLayout());
        GridBagConstraints gbcpf = new GridBagConstraints();
        gbcpf.anchor = GridBagConstraints.CENTER;
        panelCentradopf.add(panelPerfil, gbcpf);


        JPanel panelCentradolg = new JPanel(new GridBagLayout());
        GridBagConstraints gbcplg = new GridBagConstraints();
        gbcplg.anchor = GridBagConstraints.CENTER;
        panelCentradolg.add(panelLogin, gbcpf);

        JPanel panelCentradorg = new JPanel(new GridBagLayout());
        GridBagConstraints gbcprg = new GridBagConstraints();
        gbcprg.anchor = GridBagConstraints.CENTER;
        panelCentradorg.add(panelRegistro, gbcpf);


        // Añadir los paneles a la ventana
        ventana.add(panelCentradopi, "Panel Inicial");
        ventana.add(panelCentradolg, "Panel Login");
        ventana.add(panelBienvenida, "Panel Bienvenida");
        ventana.add(panelCentradorg, "Panel Registro");
        ventana.add(panelCentradopf, "Panel Perfil");
        ventana.add(panelAsientos, "Panel Asientos");
        ventana.add(panelCentradopa,"Panel Pago");

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
            // Verifica si el evento es de la columna que contiene los JCheckBox
            if (e.getColumn() == 0) {
                int selectedCount = 0;
                for (int i = 0; i < tablaVuelos.getRowCount(); i++) {
                    // Asegúrate de que la fila es válida antes de acceder
                    if (i >= 0 && i < tablaVuelos.getRowCount()) {
                        Boolean isSelected = (Boolean) tablaVuelos.getValueAt(i, 0);
                        if (isSelected != null && isSelected) {
                            selectedCount++;
                        }
                    }
                }
                botonAceptar.setEnabled(selectedCount == 1);
            }
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
