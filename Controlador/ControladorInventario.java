package Controlador;

import Modelo.Producto;
import Vista.VentanaInventario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorInventario implements ActionListener {
    private VentanaInventario vista;

    public ControladorInventario(VentanaInventario vista) {
        this.vista = vista;
        this.vista.getBtnRegistrar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String nombre = vista.getTxtNombre().getText().trim();
            String categoria = vista.getTxtCategoria().getText().trim();

            if (nombre.isEmpty() || categoria.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Todos los campos de texto son obligatorios.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            double precio = Double.parseDouble(vista.getTxtPrecio().getText().trim());
            int stock = Integer.parseInt(vista.getTxtStock().getText().trim());

            if (precio < 0 || stock < 0) {
                JOptionPane.showMessageDialog(vista, "El precio y el stock no pueden ser negativos.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Producto nuevoProducto = new Producto(nombre, categoria, precio, stock);

            Object[] fila = {
                nuevoProducto.getNombre(),
                nuevoProducto.getCategoria(),
                nuevoProducto.getPrecio(),
                nuevoProducto.getStock()
            };
            vista.getModeloTabla().addRow(fila);

            vista.limpiarCampos();
            JOptionPane.showMessageDialog(vista, "¡Producto registrado con éxito!", "Información", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Por favor, ingresa valores numéricos válidos en Precio y Stock.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }
}