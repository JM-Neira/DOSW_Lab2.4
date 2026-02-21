package Reto5;

/**
 * Decorador concreto - Añade Caramelo al café
 */
public class CarameloDecorator extends ToppingDecorator {
    
    private static final double PRECIO_CARAMELO = 1200.0;
    
    public CarameloDecorator(Cafe cafe) {
        super(cafe);
    }
    
    @Override
    public String getDescripcion() {
        return cafe.getDescripcion() + " + Caramelo";
    }
    
    @Override
    public double getPrecio() {
        return cafe.getPrecio() + PRECIO_CARAMELO;
    }
}
