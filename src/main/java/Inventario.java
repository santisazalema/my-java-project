import java.util.ArrayList;
import java.util.List;

public class Inventario {
    
    // Usa un ArrayList para almacenar los productos.
    private List<Producto> listaProductos;

    public Inventario() {
        this.listaProductos = new ArrayList<>();
    }

    // Operación: CREATE (Crear/Agregar)
    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
        System.out.println("✅ Producto agregado: " + producto.getNombre());
    }

    // Operación: READ (Leer/Listar todos)
    public void listarProductos() {
        if (listaProductos.isEmpty()) {
            System.out.println("El inventario está vacío.");
            return;
        }
        System.out.println("\n--- INVENTARIO ACTUAL ---");
        for (Producto p : listaProductos) {
            System.out.println(p);
        }
        System.out.println("-------------------------");
    }

    // Operación: READ (Leer/Buscar por ID)
    public Producto buscarProducto(int id) {
        for (Producto p : listaProductos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null; // Retorna null si no lo encuentra
    }

    // Operación: UPDATE (Actualizar Cantidad)
    public void actualizarCantidad(int id, int nuevaCantidad) {
        Producto p = buscarProducto(id);
        if (p != null) {
            p.setCantidad(nuevaCantidad);
            System.out.println("✅ Cantidad de " + p.getNombre() + " actualizada a " + nuevaCantidad);
        } else {
            System.out.println("❌ Error: Producto con ID " + id + " no encontrado.");
        }
    }
    
    // Operación: DELETE (Eliminar)
    public void eliminarProducto(int id) {
        // Buscar el producto para eliminarlo
        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getId() == id) {
                String nombre = listaProductos.get(i).getNombre();
                listaProductos.remove(i);
                System.out.println("🗑️ Producto eliminado: " + nombre);
                return;
            }
        }
        System.out.println("❌ Error: No se puede eliminar. Producto con ID " + id + " no encontrado.");
    }
}
