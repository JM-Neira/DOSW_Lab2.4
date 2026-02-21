public interface VehiculoFactory {
    Vehiculo crearVehiculoTierra(String modelo);
    Vehiculo crearVehiculoAcuatico(String modelo);
    Vehiculo crearVehiculoAereo(String modelo);
}