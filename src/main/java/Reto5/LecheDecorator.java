package Reto5;

/**
 * Decorador concreto - Añade Leche al café
 */
public class LecheDecorator extends ToppingDecorator {
    
    private static final double PRECIO_LECHE = 1000.0;
    
    public LecheDecorator(Cafe cafe) {
        super(cafe);
    }
    
    @Override
    public String getDescripcion() {
        return cafe.getDescripcion() + " + Leche";
    }
    
    @Override
    public double getPrecio() {
        return cafe.getPrecio() + PRECIO_LECHE;
    }
}
