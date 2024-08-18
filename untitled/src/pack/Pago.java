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
        this.estadoPago = false; // Por defecto, el pago no se ha realizado
    }

    public boolean realizarPago() {
        // Aquí podrías conectar con una API de pagos, por ahora simulamos el pago
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
        // Lógica para validar el pago
        return true; // Suponiendo que siempre es válido
    }

    private void generarRecibo() {
        // Lógica para generar un recibo
        System.out.println("Recibo generado para " + pasajero.getNombre() + " por el monto de " + monto);
    }

    private void guardarPagoEnBD() {
        // Lógica para guardar el pago en la base de datos
    }

    // Getters y setters para los atributos según sea necesario
}
