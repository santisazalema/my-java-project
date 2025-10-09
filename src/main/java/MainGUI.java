import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainGUI {
    private Inventario inventario;

    public MainGUI() {
        inventario = new Inventario();
        inventario.agregarProducto(new Producto(101, "Laptop", 5, 1200.00));
        inventario.agregarProducto(new Producto(102, "Mouse", 50, 25.50));

        JFrame frame = new JFrame("Gestor de Inventario");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaTexto);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(3, 2, 5, 5));

        JButton listarBtn = new JButton("Listar productos");
        JButton agregarBtn = new JButton("Agregar producto");
        JButton actualizarCantidadBtn = new JButton("Actualizar cantidad");
        JButton actualizarPrecioBtn = new JButton("Actualizar precio");
        JButton eliminarBtn = new JButton("Eliminar producto");
        JButton salirBtn = new JButton("Salir");

        panelBotones.add(listarBtn);
        panelBotones.add(agregarBtn);
        panelBotones.add(actualizarCantidadBtn);
        panelBotones.add(actualizarPrecioBtn);
        panelBotones.add(eliminarBtn);
        panelBotones.add(salirBtn);

        frame.add(scroll, BorderLayout.CENTER);
        frame.add(panelBotones, BorderLayout.SOUTH);
        frame.setVisible(true);

        // Listar productos
        listarBtn.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            for (Producto p : inventario.listaProductos) {
                sb.append(p).append("\n");
            }
            areaTexto.setText(sb.toString());
        });

        // Salir
        salirBtn.addActionListener(e -> frame.dispose());

        // Para los botones de agregar, actualizar y eliminar puedes usar JOptionPane para pedir datos
        agregarBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(JOptionPane.showInputDialog(frame, "ID:"));
                String nombre = JOptionPane.showInputDialog(frame, "Nombre:");
                int cantidad = Integer.parseInt(JOptionPane.showInputDialog(frame, "Cantidad:"));
                double precio = Double.parseDouble(JOptionPane.showInputDialog(frame, "Precio:"));
                inventario.agregarProducto(new Producto(id, nombre, cantidad, precio));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Entrada inválida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        actualizarCantidadBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(JOptionPane.showInputDialog(frame, "ID del producto:"));
                int cantidad = Integer.parseInt(JOptionPane.showInputDialog(frame, "Nueva cantidad:"));
                inventario.actualizarCantidad(id, cantidad);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Entrada inválida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        actualizarPrecioBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(JOptionPane.showInputDialog(frame, "ID del producto:"));
                double precio = Double.parseDouble(JOptionPane.showInputDialog(frame, "Nuevo precio:"));
                inventario.actualizarPrecio(id, precio);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Entrada inválida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        eliminarBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(JOptionPane.showInputDialog(frame, "ID del producto a eliminar:"));
                inventario.eliminarProducto(id);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Entrada inválida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainGUI::new);
    }
}
