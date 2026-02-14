public interface VehiculoFactory {
    Vehiculo crearVehiculoTierra(String modelo);
    Vehiculo crearVehiculoAgua(String modelo);
    Vehiculo crearVehiculoAire(String modelo);
}