package pack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
    // Constructor de la clase UI
    public UI() {
        // Crear la ventana principal
        JFrame ventana = new JFrame("FLY US");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(1920, 1080);
        ventana.setLayout(new CardLayout()); // Usar un CardLayout para cambiar entre paneles

        // Panel inicial con un texto y el botón "Empezar"
        JPanel panelInicial = new JPanel(new BorderLayout());
        JLabel textoBienvenida = new JLabel("¡Bienvenido a FlyUS!", SwingConstants.CENTER);
        textoBienvenida.setFont(new Font("Arial", Font.BOLD, 24)); // Ajustar el tamaño de la fuente
        JButton botonEmpezar = new JButton("Empezar");

        panelInicial.add(textoBienvenida, BorderLayout.NORTH);
        panelInicial.add(botonEmpezar, BorderLayout.CENTER);

        // Panel con dos campos de texto
        JPanel panelCampos = new JPanel(new GridLayout(3, 2));
        JLabel label1 = new JLabel("nombre:");
        JTextField campo1 = new JTextField();
        JLabel label2 = new JLabel("contraseña:");
        JTextField campo2 = new JTextField();
        JButton botonFinalizar = new JButton("acceder");

        panelCampos.add(label1);
        panelCampos.add(campo1);
        panelCampos.add(label2);
        panelCampos.add(campo2);
        panelCampos.add(botonFinalizar);

        // Agregar ambos paneles al CardLayout de la ventana
        ventana.add(panelInicial, "Panel Inicial");
        ventana.add(panelCampos, "Panel Campos");

        // Obtener el layout para cambiar entre paneles
        CardLayout cl = (CardLayout) (ventana.getContentPane().getLayout());

        // Acción para el botón "Empezar"
        botonEmpezar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cambiar al panel con los campos de texto
                cl.show(ventana.getContentPane(), "Panel Campos");
            }
        });

        // Acción para el botón "Finalizar"
        botonFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar la acción que deseas realizar al finalizar
                System.out.println("Campo 1: " + campo1.getText());
                System.out.println("Campo 2: " + campo2.getText());
                // Cambiar de vuelta al panel inicial o realizar otra acción
                cl.show(ventana.getContentPane(), "Panel Inicial");
            }
        });

        // Mostrar la ventana
        ventana.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        ventana.setVisible(true);
    }

    public static void main(String[] args) {
        new UI();
    }
}
