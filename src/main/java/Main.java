import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inicializa el inventario y el Scanner para la entrada de usuario
        Inventario inventario = new Inventario();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        
        // Carga de datos iniciales para demostración
        inventario.agregarProducto(new Producto(101, "Laptop", 5, 1200.00));
        inventario.agregarProducto(new Producto(102, "Mouse", 50, 25.50));

        System.out.println("--- GESTOR DE INVENTARIO ---");

        // Ciclo MIENTRAS: Mantiene el programa corriendo hasta que el usuario elija salir (opcion 5)
        while (opcion != 5) {
            
            mostrarMenu();
            
            // Manejo de errores de entrada (try-catch)
            try {
                System.out.print("Ingrese su opción: ");
                opcion = scanner.nextInt();
                
                // Estructura Condicional: Toma de decisiones (switch)
                switch (opcion) {
                    case 1: 
                        // Listar
                        inventario.listarProductos();
                        break;
                    case 2: 
                        // Agregar
                        agregarNuevoProducto(inventario, scanner);
                        break;
                    case 3:
                        // Actualizar
                        actualizarProducto(inventario, scanner);
                        break;
                    case 4:
                        // Eliminar
                        eliminarProducto(inventario, scanner);
                        break;
                    case 5: 
                        System.out.println("👋 Saliendo del sistema. ¡Gracias!");
                        break;
                    default: 
                        System.out.println("❌ Opción no válida. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("❌ Error de entrada: Ingrese solo números para las opciones.");
                scanner.next(); // Limpia la entrada inválida
                opcion = 0;
            }
        }
        scanner.close();
    }
    
    // Método para mostrar el menú
    private static void mostrarMenu() {
        System.out.println("\n[MENÚ]");
        System.out.println("1. Listar todos los productos");
        System.out.println("2. Agregar nuevo producto");
        System.out.println("3. Actualizar cantidad de producto");
        System.out.println("4. Eliminar producto");
        System.out.println("5. Salir");
    }

    // Método para manejar la entrada de un nuevo producto
    private static void agregarNuevoProducto(Inventario inventario, Scanner scanner) {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea
        
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        
        inventario.agregarProducto(new Producto(id, nombre, cantidad, precio));
    }

    // Método para manejar la actualización
    private static void actualizarProducto(Inventario inventario, Scanner scanner) {
        System.out.print("Ingrese ID del producto a actualizar: ");
        int id = scanner.nextInt();
        
        System.out.print("Ingrese la nueva cantidad: ");
        int nuevaCantidad = scanner.nextInt();
        
        inventario.actualizarCantidad(id, nuevaCantidad);
    }
    
    // Método para manejar la eliminación
    private static void eliminarProducto(Inventario inventario, Scanner scanner) {
        System.out.print("Ingrese ID del producto a eliminar: ");
        int id = scanner.nextInt();
        
        inventario.eliminarProducto(id);
    }
}
