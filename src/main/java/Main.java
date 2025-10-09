import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        // Datos iniciales
        inventario.agregarProducto(new Producto(101, "Laptop", 5, 1200.00));
        inventario.agregarProducto(new Producto(102, "Mouse", 50, 25.50));

        System.out.println("--- GESTOR DE INVENTARIO ---");

        while (opcion != 6) {
            mostrarMenu();
            try {
                System.out.print("Ingrese su opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer

                switch (opcion) {
                    case 1 -> inventario.listarProductos();
                    case 2 -> agregarNuevoProducto(inventario, scanner);
                    case 3 -> actualizarCantidadProducto(inventario, scanner);
                    case 4 -> actualizarPrecioProducto(inventario, scanner);
                    case 5 -> eliminarProducto(inventario, scanner);
                    case 6 -> System.out.println("👋 Saliendo del sistema. ¡Gracias!");
                    default -> System.out.println("❌ Opción no válida. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("❌ Error: Ingrese solo números.");
                scanner.nextLine(); // limpiar entrada inválida
            }
        }
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n[MENÚ]");
        System.out.println("1. Listar todos los productos");
        System.out.println("2. Agregar nuevo producto");
        System.out.println("3. Actualizar cantidad de producto");
        System.out.println("4. Actualizar precio de producto");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Salir");
    }

    private static void agregarNuevoProducto(Inventario inventario, Scanner scanner) {
        try {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Cantidad: ");
            int cantidad = scanner.nextInt();

            System.out.print("Precio: ");
            double precio = scanner.nextDouble();

            if (cantidad < 0 || precio < 0) {
                System.out.println("❌ Cantidad y precio deben ser positivos.");
                return;
            }

            inventario.agregarProducto(new Producto(id, nombre, cantidad, precio));
        } catch (Exception e) {
            System.out.println("❌ Error: Entrada inválida.");
            scanner.nextLine();
        }
    }

    private static void actualizarCantidadProducto(Inventario inventario, Scanner scanner) {
        System.out.print("Ingrese ID del producto a actualizar: ");
        int id = scanner.nextInt();
        System.out.print("Nueva cantidad: ");
        int cantidad = scanner.nextInt();
        inventario.actualizarCantidad(id, cantidad);
    }

    private static void actualizarPrecioProducto(Inventario inventario, Scanner scanner) {
        System.out.print("Ingrese ID del producto a actualizar: ");
        int id = scanner.nextInt();
        System.out.print("Nuevo precio: ");
        double precio = scanner.nextDouble();
        inventario.actualizarPrecio(id, precio);
    }

    private static void eliminarProducto(Inventario inventario, Scanner scanner) {
        System.out.print("Ingrese ID del producto a eliminar: ");
        int id = scanner.nextInt();
        inventario.eliminarProducto(id);
    }
}
