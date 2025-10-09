import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> listaProductos;

    public Inventario() {
        this.listaProductos = new ArrayList<>();
    }

    // CREATE
    public void agregarProducto(Producto producto) {
        if (buscarProducto(producto.getId()) != null) {
            System.out.println("❌ Error: Ya existe un producto con ID " + producto.getId());
            return;
        }
        listaProductos.add(producto);
        System.out.println("✅ Producto agregado: " + producto.getNombre());
    }

    // READ
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

    public Producto buscarProducto(int id) {
        for (Producto p : listaProductos) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    // UPDATE
    public void actualizarCantidad(int id, int nuevaCantidad) {
        if (nuevaCantidad < 0) {
            System.out.println("❌ Error: La cantidad no puede ser negativa.");
            return;
        }
        Producto p = buscarProducto(id);
        if (p != null) {
            p.setCantidad(nuevaCantidad);
            System.out.println("✅ Cantidad de " + p.getNombre() + " actualizada a " + nuevaCantidad);
        } else {
            System.out.println("❌ Producto con ID " + id + " no encontrado.");
        }
    }

    public void actualizarPrecio(int id, double nuevoPrecio) {
        if (nuevoPrecio < 0) {
            System.out.println("❌ Error: El precio no puede ser negativo.");
            return;
        }
        Producto p = buscarProducto(id);
        if (p != null) {
            p.setPrecio(nuevoPrecio);
            System.out.println("✅ Precio de " + p.getNombre() + " actualizado a $" + String.format("%.2f", nuevoPrecio));
        } else {
            System.out.println("❌ Producto con ID " + id + " no encontrado.");
        }
    }

    // DELETE
    public void eliminarProducto(int id) {
        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getId() == id) {
                String nombre = listaProductos.get(i).getNombre();
                listaProductos.remove(i);
                System.out.println("🗑️ Producto eliminado: " + nombre);
                return;
            }
        }
        System.out.println("❌ Producto con ID " + id + " no encontrado.");
    }
}

