package pack;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Main extends JFrame {
    private JTextField txtNombre;
    private JComboBox<String> cmbOrigen;
    private JComboBox<String> cmbDestino;
    private JSpinner dateSpinner;
    private JTable tblReservas;
    private DefaultTableModel modeloTabla;

    public Main() {
        this.setTitle("Reservación de Boletos de Avión");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo((Component)null);
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        JPanel panelFormulario = new JPanel(new GridLayout(5, 2));
        JPanel panelTabla = new JPanel(new BorderLayout());
        JLabel lblNombre = new JLabel("Nombre:");
        this.txtNombre = new JTextField();
        JLabel lblOrigen = new JLabel("Origen:");
        this.cmbOrigen = new JComboBox(new String[]{"Ciudad A", "Ciudad B", "Ciudad C"});
        JLabel lblDestino = new JLabel("Destino:");
        this.cmbDestino = new JComboBox(new String[]{"Ciudad D", "Ciudad E", "Ciudad F"});
        JLabel lblFecha = new JLabel("Fecha:");
        SpinnerDateModel model = new SpinnerDateModel();
        this.dateSpinner = new JSpinner(model);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(this.dateSpinner, "dd-MM-yyyy");
        this.dateSpinner.setEditor(editor);
        JButton btnReservar = new JButton("Reservar");
        panelFormulario.add(lblNombre);
        panelFormulario.add(this.txtNombre);
        panelFormulario.add(lblOrigen);
        panelFormulario.add(this.cmbOrigen);
        panelFormulario.add(lblDestino);
        panelFormulario.add(this.cmbDestino);
        panelFormulario.add(lblFecha);
        panelFormulario.add(this.dateSpinner);
        panelFormulario.add(new JLabel());
        panelFormulario.add(btnReservar);
        panelPrincipal.add(panelFormulario, "North");
        this.modeloTabla = new DefaultTableModel(new String[]{"Nombre", "Origen", "Destino", "Fecha"}, 0);
        this.tblReservas = new JTable(this.modeloTabla);
        panelTabla.add(new JScrollPane(this.tblReservas), "Center");
        panelPrincipal.add(panelTabla, "Center");
        this.add(panelPrincipal);
        btnReservar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = Main.this.txtNombre.getText();
                String origen = (String)Main.this.cmbOrigen.getSelectedItem();
                String destino = (String)Main.this.cmbDestino.getSelectedItem();
                String fecha = (new SimpleDateFormat("dd-MM-yyyy")).format(Main.this.dateSpinner.getValue());
                if (!nombre.isEmpty() && !origen.equals(destino) && !fecha.isEmpty()) {
                    Main.this.modeloTabla.addRow(new Object[]{nombre, origen, destino, fecha});
                    Main.this.txtNombre.setText("");
                    Main.this.dateSpinner.setValue(new Date());
                    JOptionPane.showMessageDialog(Main.this, "Reserva exitosa para " + nombre + " de " + origen + " a " + destino + " el " + fecha + ".");
                } else {
                    JOptionPane.showMessageDialog(Main.this, "Por favor, complete todos los campos y asegúrese de que el origen y el destino sean diferentes.", "Error", 0);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main app = new Main();
            app.setVisible(true);
        });
    }
}