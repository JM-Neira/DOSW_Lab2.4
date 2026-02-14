package Reto5;

/**
 * Componente concreto - Café básico sin toppings
 */
public class CafeBase implements Cafe {
    
    private static final double PRECIO_BASE = 3000.0;
    
    @Override
    public String getDescripcion() {
        return "Café base";
    }
    
    @Override
    public double getPrecio() {
        return PRECIO_BASE;
    }
}