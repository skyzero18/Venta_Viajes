package pack;

public class Reserva {
    private Pasajero pasajero;
    private Vuelo vuelo;
    private Pago pago;

    public Reserva(Pasajero pasajero, Vuelo vuelo) {
        this.pasajero = pasajero;
        this.vuelo = vuelo;
    }

    public void realizarReserva(String metodoPago) {
        double monto = calcularCosto();
        this.pago = new Pago(monto, metodoPago, pasajero, vuelo);

        if (pago.realizarPago()) {
            confirmarReserva();
        } else {
            System.out.println("El pago ha fallado. No se pudo realizar la reserva.");
        }
    }

    private double calcularCosto() {
        // Lógica para calcular el costo del vuelo
        return 200.0; // Simulación de un costo fijo
    }

    private void confirmarReserva() {
        // Lógica para confirmar la reserva
        System.out.println("Reserva confirmada para " + pasajero.getNombre() + " en el vuelo de " + vuelo.getOrigen() + " a " + vuelo.getDestino());
    }

    // Getters y setters según sea necesario
}
