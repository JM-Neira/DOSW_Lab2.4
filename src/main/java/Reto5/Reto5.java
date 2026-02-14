package Reto5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * RETO 5: El Café Personalizado
 * Patrón de Diseño: DECORATOR (Estructural)
 * 
 * Sistema de personalización de cafés con toppings
 * Permite agregar múltiples toppings dinámicamente sin modificar la clase base
 */
public class Reto5 {
    
    public static void main(String[] args) {
        ejecutar();
    }
    
    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n" + "=".repeat(70));
        System.out.println("      ☕ CAFETERÍA CREATIVA - SISTEMA DE PERSONALIZACIÓN ☕");
        System.out.println("=".repeat(70));
        
        // Mostrar menú de toppings
        mostrarMenuToppings();
        
        System.out.print("\nNúmero de cafés a personalizar: ");
        int numCafes = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        // Lista para almacenar todos los cafés
        List<Cafe> cafes = new ArrayList<>();
        
        // Procesar cada café usando programación funcional
        for (int i = 1; i <= numCafes; i++) {
            System.out.println("\n--- Café " + i + " ---");
            Cafe cafe = personalizarCafe(scanner);
            cafes.add(cafe);
        }
        
        // Mostrar resumen usando streams
        mostrarResumen(cafes);
        
        scanner.close();
    }
    
    /**
     * Muestra el menú de toppings disponibles
     */
    private static void mostrarMenuToppings() {
        System.out.println("\n📋 TOPPINGS DISPONIBLES:");
        System.out.println("┌────────┬─────────────────┬──────────────┐");
        System.out.println("│ Opción │     Topping     │    Precio    │");
        System.out.println("├────────┼─────────────────┼──────────────┤");
        System.out.println("│   1    │ Leche           │ $1.000       │");
        System.out.println("│   2    │ Chocolate       │ $1.500       │");
        System.out.println("│   3    │ Caramelo        │ $1.200       │");
        System.out.println("│   4    │ Crema Batida    │ $2.000       │");
        System.out.println("│   5    │ Menta           │ $1.300       │");
        System.out.println("│   6    │ Personalizado   │ A definir    │");
        System.out.println("└────────┴─────────────────┴──────────────┘");
    }
    
    /**
     * Personaliza un café con toppings seleccionados
     * Usa programación funcional para aplicar decoradores
     */
    private static Cafe personalizarCafe(Scanner scanner) {
        // Iniciar con café base
        Cafe cafe = new CafeBase();
        
        System.out.print("Seleccione toppings (números separados por coma): ");
        String input = scanner.nextLine();
        
        // Parsear opciones usando streams
        List<Integer> opciones = Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        
        // Aplicar cada topping usando programación funcional
        // Reducimos la lista de opciones aplicando decoradores
        cafe = opciones.stream()
                .reduce(
                    cafe,
                    (cafeActual, opcion) -> aplicarTopping(cafeActual, opcion, scanner),
                    (c1, c2) -> c1  // Combiner (no se usa en stream secuencial)
                );
        
        return cafe;
    }
    
    /**
     * Aplica un topping específico al café
     * Usa patrón Decorator para envolver el café con el topping
     */
    private static Cafe aplicarTopping(Cafe cafe, int opcion, Scanner scanner) {
        switch (opcion) {
            case 1:
                return new LecheDecorator(cafe);
            case 2:
                return new ChocolateDecorator(cafe);
            case 3:
                return new CarameloDecorator(cafe);
            case 4:
                return new CremaDecorator(cafe);
            case 5:
                return new MentaDecorator(cafe);
            case 6:
                System.out.print("Ingrese nombre del nuevo topping: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese precio del topping: ");
                double precio = scanner.nextDouble();
                scanner.nextLine(); // Limpiar buffer
                return new CustomToppingDecorator(cafe, nombre, precio);
            default:
                System.out.println("⚠️  Opción inválida: " + opcion);
                return cafe;
        }
    }
    
    /**
     * Muestra resumen final usando streams para calcular totales
     * Programación funcional para procesar la lista de cafés
     */
    private static void mostrarResumen(List<Cafe> cafes) {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("                        📋 RESUMEN DEL PEDIDO");
        System.out.println("=".repeat(70));
        
        // Mostrar cada café con su índice usando streams
        cafes.stream()
                .map(cafe -> new Object() {
                    int index = cafes.indexOf(cafe) + 1;
                    Cafe cafeObj = cafe;
                })
                .forEach(item -> {
                    System.out.println("\n☕ Café " + item.index + ":");
                    System.out.println("   Descripción: " + item.cafeObj.getDescripcion());
                    System.out.println("   Precio: $" + String.format("%.2f", item.cafeObj.getPrecio()));
                });
        
        // Calcular precio total usando reduce (programación funcional)
        double total = cafes.stream()
                .mapToDouble(Cafe::getPrecio)
                .sum();
        
        // Calcular estadísticas usando streams
        long cantidadCafes = cafes.stream().count();
        double precioPromedio = cafes.stream()
                .mapToDouble(Cafe::getPrecio)
                .average()
                .orElse(0.0);
        
        System.out.println("\n" + "─".repeat(70));
        System.out.println("📊 ESTADÍSTICAS:");
        System.out.println("   • Total de cafés: " + cantidadCafes);
        System.out.println("   • Precio promedio: $" + String.format("%.2f", precioPromedio));
        System.out.println("   • PRECIO TOTAL: $" + String.format("%.2f", total));
        System.out.println("=".repeat(70));
        
        // Mostrar café más elaborado usando streams
        cafes.stream()
                .max((c1, c2) -> Double.compare(c1.getPrecio(), c2.getPrecio()))
                .ifPresent(cafe -> {
                    System.out.println("\n⭐ CAFÉ MÁS ELABORADO:");
                    System.out.println("   " + cafe.getDescripcion());
                    System.out.println("   Precio: $" + String.format("%.2f", cafe.getPrecio()));
                });
        
        System.out.println("\n✅ Pedido procesado exitosamente!");
        System.out.println("=".repeat(70) + "\n");
    }
}
