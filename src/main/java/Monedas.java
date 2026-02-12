abstract class MonedaBase implements Moneda {
    protected final double monto;
    
    public MonedaBase(double monto) {
        if (monto < 0) {
            throw new IllegalArgumentException("El monto no puede ser negativo");
        }
        this.monto = monto;
    }
    
    @Override
    public double getMonto() {
        return monto;
    }
    
    @Override
    public String toString() {
        return String.format("%.2f %s (%s)", monto, getCodigo(), getNombre());
    }
}

/**
 * Dólar estadounidense
 */
class Dolar extends MonedaBase {
    public Dolar(double monto) {
        super(monto);
    }
    
    @Override
    public String getCodigo() {
        return "USD";
    }
    
    @Override
    public String getNombre() {
        return "Dólar";
    }
}

/**
 * Euro
 */
class Euro extends MonedaBase {
    public Euro(double monto) {
        super(monto);
    }
    
    @Override
    public String getCodigo() {
        return "EUR";
    }
    
    @Override
    public String getNombre() {
        return "Euro";
    }
}

/**
 * Yen japonés
 */
class Yen extends MonedaBase {
    public Yen(double monto) {
        super(monto);
    }
    
    @Override
    public String getCodigo() {
        return "JPY";
    }
    
    @Override
    public String getNombre() {
        return "Yen";
    }
}

/**
 * Peso colombiano
 */
class PesoColombiano extends MonedaBase {
    public PesoColombiano(double monto) {
        super(monto);
    }
    
    @Override
    public String getCodigo() {
        return "COP";
    }
    
    @Override
    public String getNombre() {
        return "Peso Colombiano";
    }
}
