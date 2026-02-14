import java.util.HashMap;
import java.util.Map;

/**
 * Servicio externo (antiguo) que tiene su propia estructura
 * Este es el ADAPTEE - la clase que necesita ser adaptada
 */
class ServicioTasasCambio {
    private final Map<String, Map<String, Double>> tasas;
    
    public ServicioTasasCambio() {
        tasas = new HashMap<>();
        inicializarTasas();
    }
    
    private void inicializarTasas() {
        // Tasas desde USD
        Map<String, Double> desdeUSD = new HashMap<>();
        desdeUSD.put("EUR", 0.92);
        desdeUSD.put("JPY", 149.50);
        desdeUSD.put("COP", 4100.00);
        desdeUSD.put("USD", 1.0);
        tasas.put("USD", desdeUSD);
        
        // Tasas desde EUR
        Map<String, Double> desdeEUR = new HashMap<>();
        desdeEUR.put("USD", 1.09);
        desdeEUR.put("JPY", 162.50);
        desdeEUR.put("COP", 4456.00);
        desdeEUR.put("EUR", 1.0);
        tasas.put("EUR", desdeEUR);
        
        // Tasas desde JPY
        Map<String, Double> desdeJPY = new HashMap<>();
        desdeJPY.put("USD", 0.0067);
        desdeJPY.put("EUR", 0.0062);
        desdeJPY.put("COP", 27.42);
        desdeJPY.put("JPY", 1.0);
        tasas.put("JPY", desdeJPY);
        
        // Tasas desde COP
        Map<String, Double> desdeCOP = new HashMap<>();
        desdeCOP.put("USD", 0.000244);
        desdeCOP.put("EUR", 0.000224);
        desdeCOP.put("JPY", 0.0365);
        desdeCOP.put("COP", 1.0);
        tasas.put("COP", desdeCOP);
    }
    
    /**
     * Método antiguo
     */
    public double getTasaCambio(String de, String a) {
        if (!tasas.containsKey(de)) {
            throw new IllegalArgumentException("Moneda origen no soportada: " + de);
        }
        if (!tasas.get(de).containsKey(a)) {
            throw new IllegalArgumentException("Moneda destino no soportada: " + a);
        }
        return tasas.get(de).get(a);
    }
    
    /**
     * Método antiguo
     */
    public double convertirMonto(double monto, String de, String a) {
        return monto * getTasaCambio(de, a);
    }
}

/**
 * ADAPTER - Adapta el servicio antiguo a la nueva interfaz
 * Este es el patrón Adapter en acción
 */
class AdaptadorConversorMoneda implements ConversorMoneda {
    private final ServicioTasasCambio servicioAntiguo;
    
    public AdaptadorConversorMoneda() {
        this.servicioAntiguo = new ServicioTasasCambio();
    }
    
    @Override
    public Moneda convertir(Moneda origen, String codigoDestino) {
        double montoConvertido = servicioAntiguo.convertirMonto(
            origen.getMonto(),
            origen.getCodigo(),
            codigoDestino
        );
        
        // Crear la moneda destino apropiada
        return crearMoneda(codigoDestino, montoConvertido);
    }
    
    @Override
    public double obtenerTasa(String codigoOrigen, String codigoDestino) {
        return servicioAntiguo.getTasaCambio(codigoOrigen, codigoDestino);
    }
    
    private Moneda crearMoneda(String codigo, double monto) {
        switch (codigo) {
            case "USD":
                return new Dolar(monto);
            case "EUR":
                return new Euro(monto);
            case "JPY":
                return new Yen(monto);
            case "COP":
                return new PesoColombiano(monto);
            default:
                throw new IllegalArgumentException("Código de moneda no soportado: " + codigo);
        }
    }
}
