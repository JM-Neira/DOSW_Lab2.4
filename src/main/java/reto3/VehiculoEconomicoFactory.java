
import reto4.Vehiculo;

public class VehiculoEconomicoFactory implements VehiculoFactory {
    @Override
    public Vehiculo crearVehiculoTierra(String modelo) {
        switch (modelo) {
            case "auto":
                return new VehiculoTierra(modelo, 20000, 120);
            case "bicicleta":
                return new VehiculoTierra(modelo, 500, 40);
            case "moto":
                return new VehiculoTierra(modelo, 8000, 100);
        }
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
