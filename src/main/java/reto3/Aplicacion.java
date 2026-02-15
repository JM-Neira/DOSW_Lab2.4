import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacion {

    public static void ejecutar() {

        Scanner scanner = new Scanner(System.in);
        List<Vehiculo> carrito = new ArrayList<>();
        boolean continuar = true;

        System.out.println("=== Bienvenido al Reino de los Vehículos ===");

        while (continuar) {

            // Selección de categoría
            System.out.println("\nSeleccione categoría:");
            System.out.println("1. Económico");
            System.out.println("2. Lujo");
            System.out.println("3. Usado");

            int categoria = scanner.nextInt();
            scanner.nextLine();

            VehiculoFactory factory;

            switch (categoria) {
                case 1:
                    factory = new VehiculoEconomicoFactory();
                    break;
                case 2:
                    factory = new VehiculoLujoFactory();
                    break;
                case 3:
                    factory = new VehiculoUsadoFactory();
                    break;
                default:
                    System.out.println("Categoría inválida.");
                    continue;
            }

            // Selección de tipo
            System.out.println("\nSeleccione tipo:");
            System.out.println("1. Tierra");
            System.out.println("2. Acuático");
            System.out.println("3. Aéreo");

            int tipo = scanner.nextInt();
            scanner.nextLine();

            Vehiculo vehiculo = null;

            switch (tipo) {

                case 1:
                    System.out.println("Seleccione modelo:");
                    System.out.println("1. Auto");
                    System.out.println("2. Bicicleta");
                    System.out.println("3. Moto");

                    int modeloTierra = scanner.nextInt();
                    scanner.nextLine();

                    switch (modeloTierra) {
                        case 1:
                            vehiculo = factory.crearVehiculoTierra("auto");
                            break;
                        case 2:
                            vehiculo = factory.crearVehiculoTierra("bicicleta");
                            break;
                        case 3:
                            vehiculo = factory.crearVehiculoTierra("moto");
                            break;
                        default:
                            System.out.println("Modelo inválido.");
                    }
                    break;

                case 2:
                    System.out.println("Seleccione modelo:");
                    System.out.println("1. Lancha");
                    System.out.println("2. Velero");
                    System.out.println("3. Jet Ski");

                    int modeloAcuatico = scanner.nextInt();
                    scanner.nextLine();

                    switch (modeloAcuatico) {
                        case 1:
                            vehiculo = factory.crearVehiculoAcuatico("lancha");
                            break;
                        case 2:
                            vehiculo = factory.crearVehiculoAcuatico("velero");
                            break;
                        case 3:
                            vehiculo = factory.crearVehiculoAcuatico("jetski");
                            break;
                        default:
                            System.out.println("Modelo inválido.");
                    }
                    break;

                case 3:
                    System.out.println("Seleccione modelo:");
                    System.out.println("1. Avión");
                    System.out.println("2. Avioneta");
                    System.out.println("3. Helicóptero");

                    int modeloAereo = scanner.nextInt();
                    scanner.nextLine();

                    switch (modeloAereo) {
                        case 1:
                            vehiculo = factory.crearVehiculoAereo("avion");
                            break;
                        case 2:
                            vehiculo = factory.crearVehiculoAereo("avioneta");
                            break;
                        case 3:
                            vehiculo = factory.crearVehiculoAereo("helicoptero");
                            break;
                        default:
                            System.out.println("Modelo inválido.");
                    }
                    break;

                default:
                    System.out.println("Tipo inválido.");
            }

            if (vehiculo != null) {
                carrito.add(vehiculo);
                System.out.println("Vehículo agregado: " + vehiculo);
            }

            System.out.println("\n¿Desea agregar otro vehículo? (s/n)");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("n")) {
                continuar = false;
            }
        }

        mostrarFactura(carrito);
        scanner.close();
    }

    private static void mostrarFactura(List<Vehiculo> carrito) {

        System.out.println("\n=== FACTURA ===");

        if (carrito.isEmpty()) {
            System.out.println("No se compraron vehículos.");
            return;
        }

        carrito.forEach(System.out::println);

        double total = carrito.stream()
                .mapToDouble(Vehiculo::getPrecio)
                .sum();

        System.out.println("------------------------");
        System.out.println("Total a pagar: $" + total);
        System.out.println("========================");
    }
}
