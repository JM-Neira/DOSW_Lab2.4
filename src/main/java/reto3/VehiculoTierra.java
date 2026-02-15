public class VehiculoTierra extends Vehiculo {

    public VehiculoTierra(String modelo, int precio, int velocidadMaxima) {
        super(modelo, precio, velocidadMaxima);
    }

    @Override
    public String getTipo() {
        return "Tierra";
    }
}
