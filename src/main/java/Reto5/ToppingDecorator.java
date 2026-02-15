package Reto5;

/**
 * Decorador abstracto - Base para todos los toppings
 * Implementa la interfaz Cafe y mantiene una referencia al café decorado
 */
public abstract class ToppingDecorator implements Cafe {
    
    protected Cafe cafe;
    
    public ToppingDecorator(Cafe cafe) {
        this.cafe = cafe;
    }
    
    @Override
    public String getDescripcion() {
        return cafe.getDescripcion();
    }
    
    @Override
    public double getPrecio() {
        return cafe.getPrecio();
    }
}