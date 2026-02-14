public class VehiculoEconomicoFactory implements VehiculoFactory {
    @Override
    public Vehiculo crearVehiculoTierra(String modelo) {
        return new VehiculoTierra(modelo, 20000, 120);
    }

    @Override
    public Vehiculo crearVehiculoAcuatico(String modelo) {
        return new VehiculoAcuatico(modelo, 30000, 80);
    }

    @Override
    public Vehiculo crearVehiculoAereo(String modelo) {
        return new VehiculoAereo(modelo, 100000, 300);
    }
}
