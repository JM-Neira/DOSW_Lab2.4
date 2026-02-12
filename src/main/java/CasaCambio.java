import java.util.ArrayList;
import java.util.List;

class Transaccion {
    private final Moneda origen;
    private final Moneda destino;
    private final double tasa;
    
    public Transaccion(Moneda origen, Moneda destino, double tasa) {
        this.origen = origen;
        this.destino = destino;
        this.tasa = tasa;
    }
    
    public Moneda getOrigen() {
        return origen;
    }
    
    public Moneda getDestino() {
        return destino;
    }
    
    public double getTasa() {
        return tasa;
    }
    
    public void mostrar() {
        System.out.println("  Origen: " + origen);
        System.out.println("  Destino: " + destino);
        System.out.println("  Tasa de cambio: " + String.format("%.6f", tasa));
    }
}

/**
 * Casa de cambio que usa el conversor adaptado
 */
class CasaCambio {
    private final String nombre;
    private final ConversorMoneda conversor;
    private final List<Transaccion> transacciones;
    
    public CasaCambio(String nombre, ConversorMoneda conversor) {
        this.nombre = nombre;
        this.conversor = conversor;
        this.transacciones = new ArrayList<>();
    }
    
    public Transaccion realizarCambio(Moneda origen, String codigoDestino) {
        System.out.println("\n--- Procesando transacción en " + nombre + " ---");
        
        double tasa = conversor.obtenerTasa(origen.getCodigo(), codigoDestino);
        Moneda destino = conversor.convertir(origen, codigoDestino);
        
        Transaccion transaccion = new Transaccion(origen, destino, tasa);
        transacciones.add(transaccion);
        
        transaccion.mostrar();
        
        return transaccion;
    }
    
    public List<Transaccion> getTransacciones() {
        return new ArrayList<>(transacciones);
    }
    
    public void mostrarResumen() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║  RESUMEN DE TRANSACCIONES - " + nombre);
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println("║  Total de transacciones: " + transacciones.size());
        System.out.println("╚════════════════════════════════════════════╝");
        
        // Calcular totales por moneda usando streams
        System.out.println("\nTotales convertidos:");
        
        double totalUSD = transacciones.stream()
            .filter(t -> t.getDestino().getCodigo().equals("USD"))
            .mapToDouble(t -> t.getDestino().getMonto())
            .sum();
        
        double totalEUR = transacciones.stream()
            .filter(t -> t.getDestino().getCodigo().equals("EUR"))
            .mapToDouble(t -> t.getDestino().getMonto())
            .sum();
        
        double totalJPY = transacciones.stream()
            .filter(t -> t.getDestino().getCodigo().equals("JPY"))
            .mapToDouble(t -> t.getDestino().getMonto())
            .sum();
        
        double totalCOP = transacciones.stream()
            .filter(t -> t.getDestino().getCodigo().equals("COP"))
            .mapToDouble(t -> t.getDestino().getMonto())
            .sum();
        
        if (totalUSD > 0) System.out.println("  USD: " + String.format("%.2f", totalUSD));
        if (totalEUR > 0) System.out.println("  EUR: " + String.format("%.2f", totalEUR));
        if (totalJPY > 0) System.out.println("  JPY: " + String.format("%.2f", totalJPY));
        if (totalCOP > 0) System.out.println("  COP: " + String.format("%,.2f", totalCOP));
    }
}
