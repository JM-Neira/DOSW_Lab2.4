import java.util.*;

public class Reto4 {
    
    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        ConversorMoneda conversor = new AdaptadorConversorMoneda();
        List<TransaccionCompleta> transacciones = new ArrayList<>();
        
        System.out.print("Ingrese número de transacciones: ");
        int numTransacciones = scanner.nextInt();
        scanner.nextLine();
        
        // Procesar cada transacción
        for (int i = 1; i <= numTransacciones; i++) {
            System.out.println("\n--- Transacción " + i + " ---");
            
            System.out.print("Ingrese monto: ");
            double monto = scanner.nextDouble();
            scanner.nextLine();
            
            System.out.print("Ingrese moneda de origen (USD, EUR, JPY, COP): ");
            String monedaOrigen = scanner.nextLine().toUpperCase().trim();
            
            System.out.print("Ingrese monedas destino (separadas por coma, ej: USD,JPY): ");
            String monedasDestinoStr = scanner.nextLine();
            
            // Crear moneda origen
            Moneda origen = crearMoneda(monedaOrigen, monto);
            
            // Procesar conversiones
            String[] codigosDestino = monedasDestinoStr.split(",");
            List<ConversionResultado> conversiones = new ArrayList<>();
            
            for (String codigo : codigosDestino) {
                codigo = codigo.trim().toUpperCase();
                Moneda convertida = conversor.convertir(origen, codigo);
                conversiones.add(new ConversionResultado(codigo, convertida.getMonto()));
            }
            
            transacciones.add(new TransaccionCompleta(i, monto, monedaOrigen, conversiones));
        }
        
        // Mostrar resultados
        System.out.println();
        mostrarResultados(transacciones);
    }
    
    private static void mostrarResultados(List<TransaccionCompleta> transacciones) {
        // Mostrar cada transacción
        for (TransaccionCompleta trans : transacciones) {
            System.out.println("Transacción " + trans.numero + ": " + 
                formatearMonto(trans.montoOrigen) + " " + trans.codigoOrigen);
            
            for (ConversionResultado conv : trans.conversiones) {
                System.out.println("  Convertido a " + conv.codigo + ": " + 
                    formatearMonto(conv.monto) + " " + conv.codigo);
            }
            System.out.println();
        }
        
        // Calcular y mostrar totales
        System.out.println("--- Totales por moneda ---");
        Map<String, Double> totales = calcularTotales(transacciones);
        
        // Mostrar en orden específico
        if (totales.containsKey("USD")) {
            System.out.println("USD: " + formatearTotal(totales.get("USD")) + " USD");
        }
        if (totales.containsKey("JPY")) {
            System.out.println("JPY: " + formatearTotal(totales.get("JPY")) + " JPY");
        }
        if (totales.containsKey("EUR")) {
            System.out.println("EUR: " + formatearTotal(totales.get("EUR")) + " EUR");
        }
        if (totales.containsKey("COP")) {
            System.out.println("COP: " + formatearTotal(totales.get("COP")) + " COP");
        }
    }
    
    private static Map<String, Double> calcularTotales(List<TransaccionCompleta> transacciones) {
        Map<String, Double> totales = new HashMap<>();
        
        for (TransaccionCompleta trans : transacciones) {
            for (ConversionResultado conv : trans.conversiones) {
                totales.put(conv.codigo, 
                    totales.getOrDefault(conv.codigo, 0.0) + conv.monto);
            }
        }
        
        return totales;
    }
    
    private static String formatearMonto(double monto) {
        // Para montos grandes (>= 1000), mostrar con punto como separador de miles
        if (monto >= 10000) {
            return String.format("%,.0f", monto).replace(",", ".");
        } else if (monto >= 100) {
            // Números como 8.250 (con 3 decimales máximo)
            String str = String.format("%.3f", monto);
            // Eliminar ceros innecesarios del final
            str = str.replaceAll("0+$", "").replaceAll("\\.$", "");
            return str.replace(".", ",");
        } else if (monto == Math.floor(monto)) {
            // Número entero
            return String.format("%.0f", monto);
        } else {
            // Decimal
            String str = String.format("%.2f", monto);
            str = str.replaceAll("0+$", "").replaceAll("\\.$", "");
            return str.replace(".", ",");
        }
    }
    
    private static String formatearTotal(double total) {
        if (total >= 1000) {
            return String.format("%,.3f", total).replace(",", ".").replaceAll("0+$", "").replaceAll("\\.$", "");
        } else if (total == Math.floor(total)) {
            return String.format("%.0f", total);
        } else {
            String str = String.format("%.3f", total);
            return str.replaceAll("0+$", "").replaceAll("\\.$", "").replace(".", ",");
        }
    }
    
    private static Moneda crearMoneda(String codigo, double monto) {
        switch (codigo) {
            case "USD": return new Dolar(monto);
            case "EUR": return new Euro(monto);
            case "JPY": return new Yen(monto);
            case "COP": return new PesoColombiano(monto);
            default: throw new IllegalArgumentException("Moneda no soportada: " + codigo);
        }
    }
}

class TransaccionCompleta {
    int numero;
    double montoOrigen;
    String codigoOrigen;
    List<ConversionResultado> conversiones;
    
    public TransaccionCompleta(int numero, double montoOrigen, String codigoOrigen, 
                               List<ConversionResultado> conversiones) {
        this.numero = numero;
        this.montoOrigen = montoOrigen;
        this.codigoOrigen = codigoOrigen;
        this.conversiones = conversiones;
    }
}

class ConversionResultado {
    String codigo;
    double monto;
    
    public ConversionResultado(String codigo, double monto) {
        this.codigo = codigo;
        this.monto = monto;
    }
}
