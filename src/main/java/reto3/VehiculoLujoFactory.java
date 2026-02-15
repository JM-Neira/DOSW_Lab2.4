public class VehiculoLujoFactory implements VehiculoFactory {

    @Override
    public Vehiculo crearVehiculoTierra(String modelo) {
        switch (modelo.toLowerCase()) {
            case "auto":
                return new VehiculoTierra(modelo, 80000, 220);
            case "moto":
                return new VehiculoTierra(modelo, 40000, 180);
            case "bicicleta":
                return new VehiculoTierra(modelo, 15000, 60);
            default:
                throw new IllegalArgumentException("Modelo de tierra no válido");
        }
    }

    @Override
    public Vehiculo crearVehiculoAcuatico(String modelo) {
        switch (modelo.toLowerCase()) {
            case "lancha":
                return new VehiculoAcuatico(modelo, 120000, 140);
            case "velero":
                return new VehiculoAcuatico(modelo, 90000, 100);
            case "jetski":
                return new VehiculoAcuatico(modelo, 70000, 130);
            default:
                throw new IllegalArgumentException("Modelo acuático no válido");
        }
    }

    @Override
    public Vehiculo crearVehiculoAereo(String modelo) {
        switch (modelo.toLowerCase()) {
            case "avion":
                return new VehiculoAereo(modelo, 500000, 600);
            case "avioneta":
                return new VehiculoAereo(modelo, 300000, 450);
            case "helicoptero":
                return new VehiculoAereo(modelo, 400000, 350);
            default:
                throw new IllegalArgumentException("Modelo aéreo no válido");
        }
    }
}
