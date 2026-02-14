package Reto5;

/**
 * Decorador concreto - Añade Chocolate al café
 */
public class ChocolateDecorator extends ToppingDecorator {
    
    private static final double PRECIO_CHOCOLATE = 1500.0;
    
    public ChocolateDecorator(Cafe cafe) {
        super(cafe);
    }
    
    @Override
    public String getDescripcion() {
        return cafe.getDescripcion() + " + Chocolate";
    }
    
    @Override
    public double getPrecio() {
        return cafe.getPrecio() + PRECIO_CHOCOLATE;
    }
}
