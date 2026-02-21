public class VehiculoEconomicoFactory implements VehiculoFactory {

    @Override
    public Vehiculo crearVehiculoTierra(String modelo) {
        switch (modelo.toLowerCase()) {
            case "auto":
                return new VehiculoTierra("Auto Económico", 20000, 120);
            case "bicicleta":
                return new VehiculoTierra("Bicicleta Económica", 800, 40);
            case "moto":
                return new VehiculoTierra("Moto Económica", 10000, 100);
            default:
                throw new IllegalArgumentException("Modelo de tierra no válido");
        }
    }

    @Override
    public Vehiculo crearVehiculoAcuatico(String modelo) {
        switch (modelo.toLowerCase()) {
            case "lancha":
                return new VehiculoAcuatico("Lancha Económica", 30000, 80);
            case "velero":
                return new VehiculoAcuatico("Velero Económico", 25000, 60);
            case "jetski":
                return new VehiculoAcuatico("Jet Ski Económico", 20000, 90);
            default:
                throw new IllegalArgumentException("Modelo acuático no válido");
        }
    }

    @Override
    public Vehiculo crearVehiculoAereo(String modelo) {
        switch (modelo.toLowerCase()) {
            case "avion":
                return new VehiculoAereo("Avión Económico", 100000, 300);
            case "avioneta":
                return new VehiculoAereo("Avioneta Económica", 80000, 250);
            case "helicoptero":
                return new VehiculoAereo("Helicóptero Económico", 120000, 220);
            default:
                throw new IllegalArgumentException("Modelo aéreo no válido");
        }
    }
}
