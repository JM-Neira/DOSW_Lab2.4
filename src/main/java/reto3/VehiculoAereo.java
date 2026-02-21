public class VehiculoAereo extends Vehiculo {

    public VehiculoAereo(String modelo, int precio, int velocidadMaxima) {
        super(modelo, precio, velocidadMaxima);
    }

    @Override
    public String getTipo() {
        return "Aire";
    }
}
