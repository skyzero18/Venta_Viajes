package pack;

public class Pago {
    private double monto;
    private String metodoPago;
    private boolean estadoPago;
    private Pasajero pasajero;
    private Vuelo vuelo;

    public Pago(double monto, String metodoPago, Pasajero pasajero, Vuelo vuelo) {
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.pasajero = pasajero;
        this.vuelo = vuelo;
        this.estadoPago = false;
    }

    public boolean realizarPago() {
        if (validarPago()) {
            estadoPago = true;
            guardarPagoEnBD();
            generarRecibo();
            return true;
        } else {
            return false;
        }
    }

    private boolean validarPago() {
        return true; // Simulación
    }

    private void generarRecibo() {
        System.out.println("Recibo generado para " + pasajero.getNombre() + " por el monto de " + monto);
    }

    private void guardarPagoEnBD() {
        // Lógica para guardar el pago en la base de datos
    }

    // Getters y setters para los atributos según sea necesario
}
