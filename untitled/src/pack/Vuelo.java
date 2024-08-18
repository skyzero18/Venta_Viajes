package pack;

import javax.swing.*;

public class Vuelo {
    private String origen;
    private String destino;

    public Vuelo(String origen, String destino) {
        this.origen = origen;
        this.destino = destino;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void buscarVuelos(JFrame ventana) {
        // Lógica para buscar vuelos disponibles
        JOptionPane.showMessageDialog(ventana, "Vuelos disponibles desde " + origen + " hacia " + destino);
    }

    // Otros métodos relacionados con los vuelos pueden añadirse aquí
}
