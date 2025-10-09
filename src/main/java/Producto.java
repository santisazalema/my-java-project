public class Producto {
    // 1. Atributos (Variables de instancia)
    private int id;
    private String nombre;
    private int cantidad;
    private double precio;

    // 2. Constructor para crear nuevos productos
    public Producto(int id, String nombre, int cantidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // 3. Métodos Getter (para obtener valores)
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }
    
    // 4. Métodos Setter (para cambiar valores, ej. actualizar cantidad)
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // 5. Método toString para fácil impresión
    @Override
    public String toString() {
        return "ID: " + id + 
               " | Nombre: " + nombre + 
               " | Cantidad: " + cantidad + 
               " | Precio: $" + precio;
    }
}
