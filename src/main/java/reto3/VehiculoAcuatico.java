public class VehiculoAcuatico extends Vehiculo {

    public VehiculoAcuatico(String modelo, int precio, int velocidadMaxima) {
        super(modelo, precio, velocidadMaxima);
    }

    @Override
    public String getTipo() {
        return "Agua";
    }
}
