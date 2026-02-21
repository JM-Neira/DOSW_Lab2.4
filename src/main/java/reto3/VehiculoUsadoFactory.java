public class VehiculoUsadoFactory implements VehiculoFactory {

    @Override
    public Vehiculo crearVehiculoTierra(String modelo) {
        switch (modelo.toLowerCase()) {
            case "auto":
                return new VehiculoTierra("Auto Usado", 12000, 100);
            case "bicicleta":
                return new VehiculoTierra("Bicicleta Usada", 400, 30);
            case "moto":
                return new VehiculoTierra("Moto Usada", 6000, 85);
            default:
                throw new IllegalArgumentException("Modelo de tierra no válido");
        }
    }

    @Override
    public Vehiculo crearVehiculoAcuatico(String modelo) {
        switch (modelo.toLowerCase()) {
            case "lancha":
                return new VehiculoAcuatico("Lancha Usada", 18000, 65);
            case "velero":
                return new VehiculoAcuatico("Velero Usado", 15000, 50);
            case "jetski":
                return new VehiculoAcuatico("Jet Ski Usado", 12000, 70);
            default:
                throw new IllegalArgumentException("Modelo acuático no válido");
        }
    }

    @Override
    public Vehiculo crearVehiculoAereo(String modelo) {
        switch (modelo.toLowerCase()) {
            case "avion":
                return new VehiculoAereo("Avión Usado", 60000, 220);
            case "avioneta":
                return new VehiculoAereo("Avioneta Usada", 45000, 200);
            case "helicoptero":
                return new VehiculoAereo("Helicóptero Usado", 70000, 180);
            default:
                throw new IllegalArgumentException("Modelo aéreo no válido");
        }
    }
}
