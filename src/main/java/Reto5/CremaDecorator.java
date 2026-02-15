package Reto5;

/**
 * Decorador concreto - Añade Crema Batida al café
 */
public class CremaDecorator extends ToppingDecorator {
    
    private static final double PRECIO_CREMA = 2000.0;
    
    public CremaDecorator(Cafe cafe) {
        super(cafe);
    }
    
    @Override
    public String getDescripcion() {
        return cafe.getDescripcion() + " + Crema Batida";
    }
    
    @Override
    public double getPrecio() {
        return cafe.getPrecio() + PRECIO_CREMA;
    }
}
