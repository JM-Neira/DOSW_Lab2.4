package Reto5;

/**
 * Decorador concreto - Añade Menta al café
 */
public class MentaDecorator extends ToppingDecorator {
    
    private static final double PRECIO_MENTA = 1300.0;
    
    public MentaDecorator(Cafe cafe) {
        super(cafe);
    }
    
    @Override
    public String getDescripcion() {
        return cafe.getDescripcion() + " + Menta";
    }
    
    @Override
    public double getPrecio() {
        return cafe.getPrecio() + PRECIO_MENTA;
    }
}
