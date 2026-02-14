package Reto5;

/**
 * Decorador concreto - Permite añadir toppings personalizados
 */
public class CustomToppingDecorator extends ToppingDecorator {
    
    private final String nombreTopping;
    private final double precioTopping;
    
    public CustomToppingDecorator(Cafe cafe, String nombre, double precio) {
        super(cafe);
        this.nombreTopping = nombre;
        this.precioTopping = precio;
    }
    
    @Override
    public String getDescripcion() {
        return cafe.getDescripcion() + " + " + nombreTopping;
    }
    
    @Override
    public double getPrecio() {
        return cafe.getPrecio() + precioTopping;
    }
}
